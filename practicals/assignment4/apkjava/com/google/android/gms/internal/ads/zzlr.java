package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzlr {
    public static final zzlr a = new t00();

    public final boolean a() {
        return g() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if ((g() - 1) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(int i2, zzlt zzltVar, zzlu zzluVar, int i3) {
        c(i2, zzltVar, false);
        d(0, zzluVar, false);
        int i4 = 1;
        if (i2 != 0) {
            return i2 + 1;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException();
                }
            }
            i4 = 0;
        } else if (g() - 1 == 0) {
            i4 = -1;
        }
        if (i4 == -1) {
            return -1;
        }
        d(i4, zzluVar, false);
        return 0;
    }

    public abstract zzlt c(int i2, zzlt zzltVar, boolean z);

    public final zzlu d(int i2, zzlu zzluVar, boolean z) {
        return e(i2, zzluVar, false, 0L);
    }

    public abstract zzlu e(int i2, zzlu zzluVar, boolean z, long j2);

    public abstract int f(Object obj);

    public abstract int g();

    public abstract int h();
}
