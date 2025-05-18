package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class b2 {
    private static String a = "FileUtil";

    /* loaded from: classes2.dex */
    static class a implements FilenameFilter {
        final /* synthetic */ Pattern a;

        a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public static File a() {
        return b0.a().getFilesDir();
    }

    public static boolean b(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        d1.c(6, a, "Unable to create persistent dir: ".concat(String.valueOf(parentFile)));
        return false;
    }

    public static String[] c(File file, Pattern pattern) {
        if (!file.exists()) {
            return new String[0];
        }
        String[] list = file.list(new a(pattern));
        return list == null ? new String[0] : list;
    }

    @TargetApi(21)
    public static File d() {
        File file;
        Context a2 = b0.a();
        if (c2.g(21)) {
            file = a2.getNoBackupFilesDir();
        } else {
            file = new File(a2.getFilesDir().getPath() + File.separator + "no_backup");
        }
        return new File(file.getPath() + File.separator + ".flurryNoBackup");
    }

    public static boolean e(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        for (String str : file.list()) {
            if (!e(new File(file, str))) {
                return false;
            }
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(File file) {
        FileInputStream fileInputStream;
        StringBuilder sb;
        if (file != null && file.exists()) {
            d1.c(4, a, "Loading persistent data: " + file.getAbsolutePath());
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    sb = new StringBuilder();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        d1.d(6, a, "Error when loading persistent file", th);
                        c2.f(fileInputStream);
                        sb = null;
                        if (sb == null) {
                        }
                    } finally {
                        c2.f(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            if (sb == null) {
                return sb.toString();
            }
            return null;
        }
        d1.c(4, a, "Persistent file doesn't exist.");
        return null;
    }
}
