package e.h.a.k0;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: FileDownloadUtils.java */
/* loaded from: classes2.dex */
public class f {
    private static int a = 65536;

    /* renamed from: b, reason: collision with root package name */
    private static long f21371b = 2000;

    /* renamed from: c, reason: collision with root package name */
    private static String f21372c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f21373d;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f21374e = Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f21375f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static String A(String str) {
        int length = str.length();
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        int i3 = (lastIndexOf != -1 || i2 <= 0) ? lastIndexOf : 2;
        if (i3 == -1) {
            return null;
        }
        char charAt = str.charAt(length - 1);
        char c2 = File.separatorChar;
        if (charAt == c2) {
            return null;
        }
        if (str.indexOf(c2) == i3 && str.charAt(i2) == File.separatorChar) {
            return str.substring(0, i3 + 1);
        }
        return str.substring(0, i3);
    }

    public static String B(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return q(str, str2);
    }

    public static String C(String str) {
        return o("%s.temp", str);
    }

    public static String D(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean E(int i2, e.h.a.e0.b bVar) {
        if (i2 == 206 || i2 == 1) {
            return true;
        }
        return "bytes".equals(bVar.e("Accept-Ranges"));
    }

    private static boolean F(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            if (!powerManager.isInteractive()) {
                return false;
            }
        } else if (!powerManager.isScreenOn()) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean G(int i2, FileDownloadModel fileDownloadModel) {
        return H(i2, fileDownloadModel, null);
    }

    public static boolean H(int i2, FileDownloadModel fileDownloadModel, Boolean bool) {
        if (fileDownloadModel == null) {
            if (d.a) {
                d.a(f.class, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        }
        if (fileDownloadModel.j() == null) {
            if (d.a) {
                d.a(f.class, "can't continue %d temp path == null", Integer.valueOf(i2));
            }
            return false;
        }
        return I(i2, fileDownloadModel, fileDownloadModel.j(), bool);
    }

    public static boolean I(int i2, FileDownloadModel fileDownloadModel, String str, Boolean bool) {
        if (str == null) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long g2 = fileDownloadModel.g();
            if (fileDownloadModel.a() <= 1 && g2 == 0) {
                if (!d.a) {
                    return false;
                }
                d.a(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
                return false;
            }
            long k2 = fileDownloadModel.k();
            if (length >= g2 && (k2 == -1 || (length <= k2 && g2 < k2))) {
                if (bool == null || bool.booleanValue() || k2 != length) {
                    return true;
                }
                if (!d.a) {
                    return false;
                }
                d.a(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
                return false;
            }
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(g2), Long.valueOf(k2));
            return false;
        }
        if (!d.a) {
            return false;
        }
        d.a(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
        return false;
    }

    public static boolean J(Context context) {
        Boolean bool = f21373d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (!e.a().f21366d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                d.i(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        z = next.processName.endsWith(":filedownloader");
                        break;
                    }
                }
            } else {
                d.i(f.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                return false;
            }
        } else {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        f21373d = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean K(String str) {
        return true;
    }

    public static boolean L(long j2, long j3) {
        return j2 > ((long) y()) && j3 > z();
    }

    public static boolean M() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.i(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static void N(Context context) {
        File u = u(context);
        try {
            u.getParentFile().mkdirs();
            u.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String O(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public static boolean P(Context context) {
        return Build.VERSION.SDK_INT >= 26 && !F(context);
    }

    public static String Q(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            matcher = f21374e.matcher(str);
        } catch (UnsupportedEncodingException | IllegalStateException unused) {
        }
        if (matcher.find()) {
            return URLDecoder.decode(matcher.group(2), matcher.group(1));
        }
        Matcher matcher2 = f21375f.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long R(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                d.c(f.class, e2, "parse content length from content range error", new Object[0]);
            }
        }
        return -1L;
    }

    public static long S(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                d.i(f.class, "parse instance length failed with %s", str);
            }
        }
        return -1L;
    }

    public static void T(int i2) throws IllegalAccessException {
        if (J(c.a())) {
            a = i2;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static void U(long j2) throws IllegalAccessException {
        if (J(c.a())) {
            f21371b = j2;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static boolean a(String str) {
        return c.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static e.h.a.j0.a c(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            if (K(str)) {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    throw new RuntimeException(o("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
                if (!file.exists() && !file.createNewFile()) {
                    throw new IOException(o("create new file error  %s", file.getAbsolutePath()));
                }
                return e.h.a.g0.c.j().b(file);
            }
            throw new RuntimeException(o("found invalid internal destination filename %s", str));
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    public static String d() {
        return o("FileDownloader/%s", "1.7.7");
    }

    public static void e(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void f(String str, String str2) {
        g(str2);
        e(str);
    }

    public static void g(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static long h(int i2, e.h.a.e0.b bVar) {
        long b2 = b(bVar.e("Content-Length"));
        String e2 = bVar.e("Transfer-Encoding");
        if (b2 >= 0) {
            return b2;
        }
        if (!(e2 != null && e2.equals("chunked"))) {
            if (e.a().f21365c) {
                if (d.a) {
                    d.a(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
                }
            } else {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
        }
        return -1L;
    }

    public static long i(e.h.a.e0.b bVar) {
        long R = R(t(bVar));
        if (R < 0) {
            return -1L;
        }
        return R;
    }

    public static String j(int i2, e.h.a.e0.b bVar) {
        if (bVar != null) {
            String e2 = bVar.e("Etag");
            if (d.a) {
                d.a(f.class, "etag find %s for task(%d)", e2, Integer.valueOf(i2));
            }
            return e2;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    static String k(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (substring.isEmpty()) {
                    return null;
                }
                return substring;
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }

    public static String l(e.h.a.e0.b bVar, String str) throws FileDownloadSecurityException {
        String Q = Q(bVar.e("Content-Disposition"));
        if (TextUtils.isEmpty(Q)) {
            Q = k(str);
        }
        if (TextUtils.isEmpty(Q)) {
            return p(str);
        }
        if (Q.contains("../")) {
            throw new FileDownloadSecurityException(o("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", Q));
        }
        return Q;
    }

    public static long m(e.h.a.e0.b bVar) {
        long n = n(bVar);
        if (n < 0) {
            d.i(f.class, "don't get instance length fromContent-Range header", new Object[0]);
            n = -1;
        }
        if (n == 0 && e.a().f21370h) {
            return -1L;
        }
        return n;
    }

    public static long n(e.h.a.e0.b bVar) {
        return S(t(bVar));
    }

    public static String o(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static String p(String str) {
        return O(str);
    }

    public static String q(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return o("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static int r(String str, String str2) {
        return e.h.a.g0.c.j().i().a(str, str2, false);
    }

    public static int s(String str, String str2, boolean z) {
        return e.h.a.g0.c.j().i().a(str, str2, z);
    }

    private static String t(e.h.a.e0.b bVar) {
        return bVar.e("Content-Range");
    }

    public static File u(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String v(String str) {
        return q(w(), p(str));
    }

    public static String w() {
        if (!TextUtils.isEmpty(f21372c)) {
            return f21372c;
        }
        boolean z = false;
        if (c.a().getExternalCacheDir() != null && Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().getFreeSpace() > 0) {
            z = true;
        }
        if (z) {
            return c.a().getExternalCacheDir().getAbsolutePath();
        }
        return c.a().getCacheDir().getAbsolutePath();
    }

    public static long x(String str) {
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static int y() {
        return a;
    }

    public static long z() {
        return f21371b;
    }
}
