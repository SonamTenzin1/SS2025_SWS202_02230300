package cm.aptoide.pt.root.execution;

import android.content.Context;
import android.os.Build;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.RootShell;
import cm.aptoide.pt.root.exceptions.RootDeniedException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class Shell {
    private static final String token = "F*D^W@#FGF";
    private boolean close;
    private String error;
    private final BufferedReader errorStream;
    private Runnable input;
    private final BufferedReader inputStream;
    private boolean isCleaning;
    private Boolean isSELinuxEnforcing;
    private int maxCommands;
    private Runnable output;
    private final OutputStreamWriter outputStream;
    private final Process proc;
    private int read;
    private ShellContext shellContext;
    private int shellTimeout;
    private ShellType shellType;
    private int totalExecuted;
    private int totalRead;
    private int write;
    public static ShellContext defaultContext = ShellContext.NORMAL;
    private static Shell rootShell = null;
    private static Shell shell = null;
    private static Shell customShell = null;
    private static String[] suVersion = {null, null};
    private final List<Command> commands = new ArrayList();
    public boolean isExecuting = false;
    public boolean isReading = false;
    public boolean isClosed = false;

    /* loaded from: classes.dex */
    public enum ShellContext {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");

        private String value;

        ShellContext(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum ShellType {
        NORMAL,
        ROOT,
        CUSTOM
    }

    /* loaded from: classes.dex */
    protected static class Worker extends Thread {
        public int exit;
        public Shell shell;

        private void setShellOom() {
            Field declaredField;
            try {
                Class<?> cls = this.shell.proc.getClass();
                try {
                    declaredField = cls.getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    declaredField = cls.getDeclaredField(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                }
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(this.shell.proc)).intValue();
                this.shell.outputStream.write("(echo -17 > /proc/" + intValue + "/oom_adj) &> /dev/null\n");
                this.shell.outputStream.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.shell.outputStream.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.shell.outputStream.write("echo Started\n");
                this.shell.outputStream.flush();
                while (true) {
                    String readLine = this.shell.inputStream.readLine();
                    if (readLine != null) {
                        if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(readLine)) {
                            if (!"Started".equals(readLine)) {
                                this.shell.error = "unknown error occurred.";
                            } else {
                                this.exit = 1;
                                setShellOom();
                                return;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            } catch (IOException e2) {
                this.exit = -42;
                if (e2.getMessage() == null) {
                    this.shell.error = "RootAccess denied?.";
                } else {
                    this.shell.error = e2.getMessage();
                }
            }
        }

        private Worker(Shell shell) {
            this.exit = -911;
            this.shell = shell;
        }
    }

    private Shell(String str, ShellType shellType, ShellContext shellContext, int i2) throws IOException, TimeoutException, RootDeniedException {
        this.shellTimeout = 25000;
        this.shellType = null;
        ShellContext shellContext2 = ShellContext.NORMAL;
        this.shellContext = shellContext2;
        this.error = HttpUrl.FRAGMENT_ENCODE_SET;
        this.close = false;
        this.isSELinuxEnforcing = null;
        this.maxCommands = 5000;
        this.read = 0;
        this.write = 0;
        this.totalExecuted = 0;
        this.totalRead = 0;
        this.isCleaning = false;
        this.input = new Runnable() { // from class: cm.aptoide.pt.root.execution.Shell.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        try {
                            synchronized (Shell.this.commands) {
                                while (!Shell.this.close && Shell.this.write >= Shell.this.commands.size()) {
                                    Shell shell2 = Shell.this;
                                    shell2.isExecuting = false;
                                    shell2.commands.wait();
                                }
                            }
                            if (Shell.this.write >= Shell.this.maxCommands) {
                                while (Shell.this.read != Shell.this.write) {
                                    RootShell.log("Waiting for read and write to catch up before cleanup.");
                                }
                                Shell.this.cleanCommands();
                            }
                            if (Shell.this.write >= Shell.this.commands.size()) {
                                if (Shell.this.close) {
                                    Shell shell3 = Shell.this;
                                    shell3.isExecuting = false;
                                    shell3.outputStream.write("\nexit 0\n");
                                    Shell.this.outputStream.flush();
                                    RootShell.log("Closing shell");
                                    return;
                                }
                            } else {
                                Shell shell4 = Shell.this;
                                shell4.isExecuting = true;
                                Command command = (Command) shell4.commands.get(Shell.this.write);
                                command.startExecution();
                                RootShell.log("Executing: " + command.getCommand() + " with context: " + Shell.this.shellContext);
                                Shell.this.outputStream.write(command.getCommand());
                                Shell.this.outputStream.flush();
                                Shell.this.outputStream.write("\necho F*D^W@#FGF " + Shell.this.totalExecuted + " $?\n");
                                Shell.this.outputStream.flush();
                                Shell.access$208(Shell.this);
                                Shell.access$808(Shell.this);
                            }
                        } finally {
                            Shell.this.write = 0;
                            Shell shell5 = Shell.this;
                            shell5.closeQuietly(shell5.outputStream);
                        }
                    } catch (IOException | InterruptedException e2) {
                        RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                        return;
                    }
                }
            }
        };
        this.output = new Runnable() { // from class: cm.aptoide.pt.root.execution.Shell.2
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0057, code lost:
            
                r9.this$0.proc.waitFor();
                r9.this$0.proc.destroy();
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x011d, code lost:
            
                r9.this$0.processErrors(r1);
                r4 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x0127, code lost:
            
                if (r1.totalOutput <= r1.totalOutputProcessed) goto L106;
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x0129, code lost:
            
                if (r4 != 0) goto L83;
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x012b, code lost:
            
                r4 = r4 + 1;
                cm.aptoide.pt.root.RootShell.log("Waiting for output to be processed. " + r1.totalOutputProcessed + " Of " + r1.totalOutput);
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x014d, code lost:
            
                monitor-enter(r9);
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x0150, code lost:
            
                wait(2000);
             */
            /* JADX WARN: Code restructure failed: missing block: B:67:0x0153, code lost:
            
                monitor-exit(r9);
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x0158, code lost:
            
                r5 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:79:0x0159, code lost:
            
                cm.aptoide.pt.root.RootShell.log(r5.getMessage());
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Command command;
                int i3;
                int i4;
                loop0: while (true) {
                    command = null;
                    while (true) {
                        try {
                            try {
                                if (!Shell.this.close || Shell.this.inputStream.ready() || Shell.this.read < Shell.this.commands.size()) {
                                    Shell shell2 = Shell.this;
                                    shell2.isReading = false;
                                    String readLine = shell2.inputStream.readLine();
                                    Shell shell3 = Shell.this;
                                    shell3.isReading = true;
                                    if (readLine == null) {
                                        break loop0;
                                    }
                                    if (command == null) {
                                        if (shell3.read >= Shell.this.commands.size()) {
                                            if (!Shell.this.close) {
                                            }
                                        } else {
                                            command = (Command) Shell.this.commands.get(Shell.this.read);
                                        }
                                    }
                                    int indexOf = readLine.indexOf(Shell.token);
                                    i3 = -1;
                                    if (indexOf == -1) {
                                        command.output(command.id, readLine);
                                    } else if (indexOf > 0) {
                                        RootShell.log("Found token, line: " + readLine);
                                        command.output(command.id, readLine.substring(0, indexOf));
                                    }
                                    if (indexOf >= 0) {
                                        String[] split = readLine.substring(indexOf).split(" ");
                                        if (split.length >= 2 && split[1] != null) {
                                            try {
                                                i4 = Integer.parseInt(split[1]);
                                            } catch (NumberFormatException unused) {
                                                i4 = 0;
                                            }
                                            try {
                                                i3 = Integer.parseInt(split[2]);
                                            } catch (NumberFormatException unused2) {
                                            }
                                            if (i4 == Shell.this.totalRead) {
                                                break;
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } catch (IOException e2) {
                                RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                            }
                        } finally {
                            Shell shell4 = Shell.this;
                            shell4.closeQuietly(shell4.outputStream);
                            Shell shell5 = Shell.this;
                            shell5.closeQuietly(shell5.errorStream);
                            Shell shell6 = Shell.this;
                            shell6.closeQuietly(shell6.inputStream);
                            RootShell.log("Shell destroyed");
                            Shell shell7 = Shell.this;
                            shell7.isClosed = true;
                            shell7.isReading = false;
                        }
                    }
                    RootShell.log("Read all output");
                    command.setExitCode(i3);
                    command.commandFinished();
                    Shell.access$408(Shell.this);
                    Shell.access$1108(Shell.this);
                }
                while (Shell.this.read < Shell.this.commands.size()) {
                    if (command == null) {
                        command = (Command) Shell.this.commands.get(Shell.this.read);
                    }
                    if (command.totalOutput < command.totalOutputProcessed) {
                        command.terminated("All output not processed!");
                        command.terminated("Did you forget the super.commandOutput call or are you waiting on the command object?");
                    } else {
                        command.terminated("Unexpected Termination.");
                    }
                    Shell.access$408(Shell.this);
                    command = null;
                }
                Shell.this.read = 0;
            }
        };
        RootShell.log("Starting shell: " + str);
        RootShell.log("Context: " + shellContext.getValue());
        RootShell.log("Timeout: " + i2);
        this.shellType = shellType;
        this.shellTimeout = i2 <= 0 ? this.shellTimeout : i2;
        this.shellContext = shellContext;
        if (shellContext == shellContext2) {
            this.proc = Runtime.getRuntime().exec(str);
        } else {
            String suVersion2 = getSuVersion(false);
            String suVersion3 = getSuVersion(true);
            if (isSELinuxEnforcing() && suVersion2 != null && suVersion3 != null && suVersion2.endsWith("SUPERSU") && Integer.valueOf(suVersion3).intValue() >= 190) {
                str = str + " --context " + this.shellContext.getValue();
            } else {
                RootShell.log("Su binary --context switch not supported!");
                RootShell.log("Su binary display version: " + suVersion2);
                RootShell.log("Su binary internal version: " + suVersion3);
                RootShell.log("SELinuxEnforcing: " + isSELinuxEnforcing());
            }
            this.proc = Runtime.getRuntime().exec(str);
        }
        this.inputStream = new BufferedReader(new InputStreamReader(this.proc.getInputStream(), "UTF-8"));
        this.errorStream = new BufferedReader(new InputStreamReader(this.proc.getErrorStream(), "UTF-8"));
        this.outputStream = new OutputStreamWriter(this.proc.getOutputStream(), "UTF-8");
        Worker worker = new Worker();
        worker.start();
        try {
            worker.join(this.shellTimeout);
            int i3 = worker.exit;
            if (i3 == -911) {
                try {
                    this.proc.destroy();
                } catch (Exception unused) {
                }
                closeQuietly(this.inputStream);
                closeQuietly(this.errorStream);
                closeQuietly(this.outputStream);
                throw new TimeoutException(this.error);
            }
            if (i3 != -42) {
                Thread thread = new Thread(this.input, "Shell Input");
                thread.setPriority(5);
                thread.start();
                Thread thread2 = new Thread(this.output, "Shell Output");
                thread2.setPriority(5);
                thread2.start();
                return;
            }
            try {
                this.proc.destroy();
            } catch (Exception unused2) {
            }
            closeQuietly(this.inputStream);
            closeQuietly(this.errorStream);
            closeQuietly(this.outputStream);
            throw new RootDeniedException("Root Access Denied");
        } catch (InterruptedException unused3) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    static /* synthetic */ int access$1108(Shell shell2) {
        int i2 = shell2.totalRead;
        shell2.totalRead = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$208(Shell shell2) {
        int i2 = shell2.write;
        shell2.write = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$408(Shell shell2) {
        int i2 = shell2.read;
        shell2.read = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$808(Shell shell2) {
        int i2 = shell2.totalExecuted;
        shell2.totalExecuted = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanCommands() {
        this.isCleaning = true;
        int i2 = this.maxCommands;
        int abs = Math.abs(i2 - (i2 / 4));
        RootShell.log("Cleaning up: " + abs);
        for (int i3 = 0; i3 < abs; i3++) {
            this.commands.remove(0);
        }
        this.read = this.commands.size() - 1;
        this.write = this.commands.size() - 1;
        this.isCleaning = false;
    }

    public static void closeAll() throws IOException {
        RootShell.log("Request to close all shells!");
        closeShell();
        closeRootShell();
        closeCustomShell();
    }

    public static void closeCustomShell() throws IOException {
        RootShell.log("Request to close custom shell!");
        Shell shell2 = customShell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeQuietly(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void closeRootShell() throws IOException {
        RootShell.log("Request to close root shell!");
        Shell shell2 = rootShell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    public static void closeShell() throws IOException {
        RootShell.log("Request to close normal shell!");
        Shell shell2 = shell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    public static Shell getOpenShell() {
        Shell shell2 = customShell;
        if (shell2 != null) {
            return shell2;
        }
        Shell shell3 = rootShell;
        return shell3 != null ? shell3 : shell;
    }

    private synchronized String getSuVersion(boolean z) {
        char c2;
        c2 = z ? (char) 0 : (char) 1;
        if (suVersion[c2] == null) {
            String str = null;
            try {
                Process exec = Runtime.getRuntime().exec(z ? "su -V" : "su -v", (String[]) null);
                exec.waitFor();
                ArrayList<String> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        }
                    } catch (IOException unused) {
                    }
                    try {
                        break;
                    } catch (IOException unused2) {
                    }
                }
                bufferedReader.close();
                exec.destroy();
                for (String str2 : arrayList) {
                    if (!z) {
                        if (str2.contains(".")) {
                        }
                    } else {
                        try {
                        } catch (NumberFormatException unused3) {
                            continue;
                        }
                        if (Integer.parseInt(str2) > 0) {
                        }
                    }
                    str = str2;
                }
                suVersion[c2] = str;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (InterruptedException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return suVersion[c2];
    }

    public static boolean isAnyShellOpen() {
        return (shell == null && rootShell == null && customShell == null) ? false : true;
    }

    public static boolean isCustomShellOpen() {
        return customShell == null;
    }

    public static boolean isRootShellOpen() {
        return rootShell == null;
    }

    public static boolean isShellOpen() {
        return shell == null;
    }

    public static Command runCommand(Command command) throws IOException, TimeoutException {
        return startShell().add(command);
    }

    public static Command runRootCommand(Command command) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell().add(command);
    }

    public static Shell startCustomShell(String str) throws IOException, TimeoutException, RootDeniedException {
        return startCustomShell(str, 0);
    }

    public static Shell startRootShell() throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(0, 3);
    }

    public static Shell startShell() throws IOException, TimeoutException {
        return startShell(0);
    }

    public Command add(Command command) throws IOException {
        if (!this.close) {
            if (command.used) {
                throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
            }
            do {
            } while (this.isCleaning);
            this.commands.add(command);
            notifyThreads();
            return command;
        }
        throw new IllegalStateException("Unable to add commands to a closed shell");
    }

    public void close() throws IOException {
        RootShell.log("Request to close shell!");
        int i2 = 0;
        while (this.isExecuting) {
            RootShell.log("Waiting on shell to finish executing before closing...");
            i2++;
            if (i2 > 10000) {
                break;
            }
        }
        synchronized (this.commands) {
            this.close = true;
            notifyThreads();
        }
        RootShell.log("Shell Closed!");
        if (this == rootShell) {
            rootShell = null;
        } else if (this == shell) {
            shell = null;
        } else if (this == customShell) {
            customShell = null;
        }
    }

    public int getCommandQueuePosition(Command command) {
        return this.commands.indexOf(command);
    }

    public String getCommandQueuePositionString(Command command) {
        return "Command is in position " + getCommandQueuePosition(command) + " currently executing command at position " + this.write + " and the number of commands is " + this.commands.size();
    }

    public synchronized boolean isSELinuxEnforcing() {
        if (this.isSELinuxEnforcing == null) {
            Boolean bool = null;
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = true;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            bool = Boolean.valueOf(fileInputStream.read() == 49);
                            fileInputStream.close();
                        } catch (Throwable th) {
                            fileInputStream.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (bool == null) {
                    if (Build.VERSION.SDK_INT < 19) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                }
            }
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            this.isSELinuxEnforcing = bool;
        }
        return this.isSELinuxEnforcing.booleanValue();
    }

    protected void notifyThreads() {
        new Thread() { // from class: cm.aptoide.pt.root.execution.Shell.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (Shell.this.commands) {
                    Shell.this.commands.notifyAll();
                }
            }
        }.start();
    }

    public void processErrors(Command command) {
        String readLine;
        while (this.errorStream.ready() && command != null && (readLine = this.errorStream.readLine()) != null) {
            try {
                command.output(command.id, readLine);
            } catch (Exception e2) {
                RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                return;
            }
        }
    }

    public Shell switchRootShellContext(ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        if (this.shellType == ShellType.ROOT) {
            try {
                closeRootShell();
            } catch (Exception unused) {
                RootShell.log("Problem closing shell while trying to switch context...");
            }
            return startRootShell(this.shellTimeout, shellContext, 0);
        }
        RootShell.log("Can only switch context on a root shell!");
        return this;
    }

    public final void useCWD(Context context) throws IOException, TimeoutException, RootDeniedException {
        add(new Command(-1, false, "cd " + context.getApplicationInfo().dataDir));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeQuietly(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public static Shell startCustomShell(String str, int i2) throws IOException, TimeoutException, RootDeniedException {
        if (customShell == null) {
            RootShell.log("Starting Custom Shell!");
            customShell = new Shell(str, ShellType.CUSTOM, ShellContext.NORMAL, i2);
        } else {
            RootShell.log("Using Existing Custom Shell!");
        }
        return customShell;
    }

    public static Shell startRootShell(int i2) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(i2, 3);
    }

    public static Shell startShell(int i2) throws IOException, TimeoutException {
        try {
            if (shell == null) {
                RootShell.log("Starting Shell!");
                shell = new Shell("/system/bin/sh", ShellType.NORMAL, ShellContext.NORMAL, i2);
            } else {
                RootShell.log("Using Existing Shell!");
            }
            return shell;
        } catch (RootDeniedException unused) {
            throw new IOException();
        }
    }

    public static Shell startRootShell(int i2, int i3) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(i2, defaultContext, i3);
    }

    public static Shell startRootShell(int i2, ShellContext shellContext, int i3) throws IOException, TimeoutException, RootDeniedException {
        int i4;
        Shell shell2 = rootShell;
        if (shell2 == null) {
            RootShell.log("Starting Root Shell!");
            int i5 = 0;
            while (rootShell == null) {
                try {
                    RootShell.log("Trying to open Root Shell, attempt #" + i5);
                    rootShell = new Shell("su", ShellType.ROOT, shellContext, i2);
                } catch (RootDeniedException e2) {
                    throw e2;
                } catch (IOException e3) {
                    i4 = i5 + 1;
                    if (i5 >= i3) {
                        RootShell.log("IOException, could not start shell");
                        throw e3;
                    }
                    i5 = i4;
                } catch (TimeoutException e4) {
                    i4 = i5 + 1;
                    if (i5 >= i3) {
                        RootShell.log("TimeoutException, could not start shell");
                        throw e4;
                    }
                    i5 = i4;
                }
            }
        } else if (shell2.shellContext != shellContext) {
            try {
                RootShell.log("Context is different than open shell, switching context... " + rootShell.shellContext + " VS " + shellContext);
                rootShell.switchRootShellContext(shellContext);
            } catch (RootDeniedException e5) {
                if (i3 <= 0) {
                    RootShell.log("RootDeniedException, could not switch context!");
                    throw e5;
                }
            } catch (IOException e6) {
                if (i3 <= 0) {
                    RootShell.log("IOException, could not switch context!");
                    throw e6;
                }
            } catch (TimeoutException e7) {
                if (i3 <= 0) {
                    RootShell.log("TimeoutException, could not switch context!");
                    throw e7;
                }
            }
        } else {
            RootShell.log("Using Existing Root Shell!");
        }
        return rootShell;
    }
}
