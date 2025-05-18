package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes2.dex */
public final class x6 {
    public static boolean a(w6 w6Var) {
        return new File(w6Var.a, w6Var.f11133b).delete();
    }

    public static boolean b(w6 w6Var, w6 w6Var2) {
        FileChannel fileChannel;
        File file;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        try {
            File file2 = new File(w6Var.a, w6Var.f11133b);
            file = new File(w6Var2.a, w6Var2.f11133b);
            file.getParentFile().mkdirs();
            file.delete();
            channel = new FileInputStream(file2).getChannel();
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file).getChannel();
            fileChannel2.transferFrom(channel, 0L, channel.size());
            c2.f(channel);
            c2.f(fileChannel2);
            return true;
        } catch (Exception e3) {
            e = e3;
            FileChannel fileChannel3 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel3;
            try {
                d1.c(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                c2.f(fileChannel2);
                c2.f(fileChannel);
                return false;
            } catch (Throwable th2) {
                th = th2;
                c2.f(fileChannel2);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            FileChannel fileChannel4 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel4;
            c2.f(fileChannel2);
            c2.f(fileChannel);
            throw th;
        }
    }

    public static boolean c(File file, File file2) {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        try {
            file2.getParentFile().mkdirs();
            file2.delete();
            file2.createNewFile();
            channel = new FileInputStream(file).getChannel();
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file2).getChannel();
            fileChannel2.transferFrom(channel, 0L, channel.size());
            c2.f(channel);
            c2.f(fileChannel2);
            return true;
        } catch (Exception e3) {
            e = e3;
            FileChannel fileChannel3 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel3;
            try {
                d1.c(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                c2.f(fileChannel2);
                c2.f(fileChannel);
                return false;
            } catch (Throwable th2) {
                th = th2;
                c2.f(fileChannel2);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            FileChannel fileChannel4 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel4;
            c2.f(fileChannel2);
            c2.f(fileChannel);
            throw th;
        }
    }

    public static boolean d(w6 w6Var, w6 w6Var2) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3 = null;
        try {
            File file = new File(w6Var.a, w6Var.f11133b);
            FileChannel channel = new FileInputStream(new File(w6Var2.a, w6Var2.f11133b)).getChannel();
            try {
                fileChannel3 = new FileOutputStream(file, true).getChannel();
                fileChannel3.transferFrom(channel, fileChannel3.size(), channel.size());
                c2.f(channel);
                c2.f(fileChannel3);
                return true;
            } catch (Exception unused) {
                FileChannel fileChannel4 = fileChannel3;
                fileChannel3 = channel;
                fileChannel2 = fileChannel4;
                c2.f(fileChannel3);
                c2.f(fileChannel2);
                return false;
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel5 = fileChannel3;
                fileChannel3 = channel;
                fileChannel = fileChannel5;
                c2.f(fileChannel3);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Exception unused2) {
            fileChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }
}
