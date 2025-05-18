package com.flurry.sdk;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class o7 {
    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        b(hashMap);
        c(hashMap);
        e(hashMap);
        h(hashMap);
        i(hashMap);
        d(hashMap);
        f(hashMap);
        g(hashMap);
        return hashMap;
    }

    private static void b(Map<String, String> map) {
        try {
            map.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e2) {
            d1.d(6, "CrashParameterCollector", "Error retrieving max memory", e2);
        }
    }

    private static void c(Map<String, String> map) {
        try {
            Debug.getMemoryInfo(new Debug.MemoryInfo());
            map.put("mem.pss", Long.toString(r0.getTotalPss() * 1024));
        } catch (RuntimeException e2) {
            d1.d(6, "CrashParameterCollector", "Error retrieving pss memory", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r7 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (r7 == 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
    
        r10.put("mem.virt.max", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r10.put("mem.virt", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(Map<String, String> map) {
        BufferedReader bufferedReader;
        Pattern compile = Pattern.compile("^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$");
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(new File("/proc/" + Integer.toString(Process.myPid())), "status"));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.find()) {
                            String group = matcher.group(1);
                            String group2 = matcher.group(2);
                            if (!TextUtils.isEmpty(group) && !TextUtils.isEmpty(group2)) {
                                char c2 = 65535;
                                int hashCode = group.hashCode();
                                if (hashCode != 81458) {
                                    if (hashCode != 2483455) {
                                        if (hashCode == 2577441 && group.equals("Size")) {
                                            c2 = 1;
                                        }
                                    } else if (group.equals("Peak")) {
                                        c2 = 2;
                                    }
                                } else if (group.equals("RSS")) {
                                    c2 = 0;
                                }
                                map.put("mem.rss", group2);
                            }
                        }
                    }
                    c2.f(fileInputStream2);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        d1.d(6, "CrashParameterCollector", "Error getting proc file Info", e);
                        c2.f(fileInputStream);
                        c2.f(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        c2.f(fileInputStream);
                        c2.f(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    c2.f(fileInputStream);
                    c2.f(bufferedReader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        c2.f(bufferedReader);
    }

    private static void e(Map<String, String> map) {
        map.put("application.state", Integer.toString(e7.a().f10731j.y().f10800j));
    }

    private static void f(Map<String, String> map) {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            blockSize = statFs.getBlockSizeLong();
        } else {
            blockSize = statFs.getBlockSize();
        }
        if (i2 >= 18) {
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            availableBlocks = statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(availableBlocks * blockSize));
    }

    private static void g(Map<String, String> map) {
        long blockSize;
        long blockCount;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            blockSize = statFs.getBlockSizeLong();
        } else {
            blockSize = statFs.getBlockSize();
        }
        if (i2 >= 18) {
            blockCount = statFs.getBlockCountLong();
        } else {
            blockCount = statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(blockCount * blockSize));
    }

    private static void h(Map<String, String> map) {
        map.put("net.status", Integer.toString(e7.a().f10724c.T().ordinal()));
    }

    private static void i(Map<String, String> map) {
        map.put("orientation", Integer.toString(e7.a().f10725d.q));
    }
}
