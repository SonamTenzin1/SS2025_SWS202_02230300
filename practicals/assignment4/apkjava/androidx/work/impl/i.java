package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.n;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: WorkDatabasePathHelper.java */
/* loaded from: classes.dex */
public class i {
    private static final String a = n.f("WrkDbPathHelper");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f2438b = {"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return b(context);
        }
        return c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        String format;
        File b2 = b(context);
        if (Build.VERSION.SDK_INT < 23 || !b2.exists()) {
            return;
        }
        n.c().a(a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map<File, File> f2 = f(context);
        for (File file : f2.keySet()) {
            File file2 = f2.get(file);
            if (file.exists() && file2 != null) {
                if (file2.exists()) {
                    n.c().h(a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                }
                if (file.renameTo(file2)) {
                    format = String.format("Migrated %s to %s", file, file2);
                } else {
                    format = String.format("Renaming %s to %s failed", file, file2);
                }
                n.c().a(a, format, new Throwable[0]);
            }
        }
    }

    public static Map<File, File> f(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File b2 = b(context);
            File a2 = a(context);
            hashMap.put(b2, a2);
            for (String str : f2438b) {
                hashMap.put(new File(b2.getPath() + str), new File(a2.getPath() + str));
            }
        }
        return hashMap;
    }
}
