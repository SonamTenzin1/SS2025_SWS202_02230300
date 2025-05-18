package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
final class w10 {
    private final zzst a = new zzst(8);

    /* renamed from: b, reason: collision with root package name */
    private int f13488b;

    private final long b(zzno zznoVar) throws IOException, InterruptedException {
        int i2 = 0;
        zznoVar.d(this.a.a, 0, 1);
        int i3 = this.a.a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (i4 ^ (-1));
        zznoVar.d(this.a.a, 1, i5);
        while (i2 < i5) {
            i2++;
            i6 = (this.a.a[i2] & 255) + (i6 << 8);
        }
        this.f13488b += i5 + 1;
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(zzno zznoVar) throws IOException, InterruptedException {
        long f2 = zznoVar.f();
        long j2 = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (f2 != -1 && f2 <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j2 = f2;
        }
        int i2 = (int) j2;
        zznoVar.d(this.a.a, 0, 4);
        long q = this.a.q();
        this.f13488b = 4;
        while (q != 440786851) {
            int i3 = this.f13488b + 1;
            this.f13488b = i3;
            if (i3 == i2) {
                return false;
            }
            zznoVar.d(this.a.a, 0, 1);
            q = ((q << 8) & (-256)) | (this.a.a[0] & 255);
        }
        long b2 = b(zznoVar);
        long j3 = this.f13488b;
        if (b2 != Long.MIN_VALUE && (f2 == -1 || j3 + b2 < f2)) {
            while (true) {
                int i4 = this.f13488b;
                long j4 = j3 + b2;
                if (i4 < j4) {
                    if (b(zznoVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long b3 = b(zznoVar);
                    if (b3 < 0 || b3 > 2147483647L) {
                        break;
                    }
                    if (b3 != 0) {
                        zznoVar.g((int) b3);
                        this.f13488b = (int) (this.f13488b + b3);
                    }
                } else if (i4 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
