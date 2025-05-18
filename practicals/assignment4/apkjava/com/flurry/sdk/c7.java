package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class c7<T> {
    private final File a;

    /* renamed from: b, reason: collision with root package name */
    private final v1<T> f10678b;

    public c7(File file, String str, int i2, y1<T> y1Var) {
        this.a = file;
        this.f10678b = new t1(new x1(str, i2, y1Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T a() {
        FileInputStream fileInputStream;
        File file = this.a;
        T t = (T) null;
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            d1.c(5, "VersionedDataFile", "No data to read for file:" + this.a.getName());
            return null;
        }
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(this.a);
            try {
                try {
                    t = this.f10678b.b(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    d1.d(3, "VersionedDataFile", "Error reading data file:" + this.a.getName(), e);
                    z = true;
                    c2.f(fileInputStream);
                    if (z) {
                    }
                    return (T) t;
                }
            } catch (Throwable th) {
                th = th;
                t = (T) fileInputStream;
                c2.f(t);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            c2.f(t);
            throw th;
        }
        c2.f(fileInputStream);
        if (z) {
            d1.c(3, "VersionedDataFile", "Deleting data file:" + this.a.getName());
            this.a.delete();
        }
        return (T) t;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(T t) {
        boolean z;
        FileOutputStream fileOutputStream = null;
        try {
            try {
            } catch (Exception e2) {
                e = e2;
            }
            if (b2.b(this.a)) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.a);
                try {
                    this.f10678b.a(fileOutputStream2, t);
                    c2.f(fileOutputStream2);
                    z = false;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    d1.d(3, "VersionedDataFile", "Error writing data file:" + this.a.getName(), e);
                    z = true;
                    c2.f(fileOutputStream);
                    if (z) {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    c2.f(fileOutputStream);
                    throw th;
                }
                if (z) {
                    return;
                }
                d1.c(3, "VersionedDataFile", "Deleting data file:" + this.a.getName());
                this.a.delete();
                return;
            }
            throw new IOException("Cannot create parent directory!");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean c() {
        File file = this.a;
        if (file == null) {
            return false;
        }
        return file.delete();
    }
}
