package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
final class h10 implements zzlx {

    /* renamed from: b, reason: collision with root package name */
    private int f12675b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f12676c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f12677d = 0;

    /* renamed from: e, reason: collision with root package name */
    private ByteBuffer f12678e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f12679f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12680g;

    public h10() {
        ByteBuffer byteBuffer = zzlx.a;
        this.f12678e = byteBuffer;
        this.f12679f = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean C() {
        return this.f12680g && this.f12679f == zzlx.a;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void a() {
        flush();
        this.f12678e = zzlx.a;
        this.f12675b = -1;
        this.f12676c = -1;
        this.f12677d = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean b() {
        int i2 = this.f12677d;
        return (i2 == 0 || i2 == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void c() {
        this.f12680g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer d() {
        ByteBuffer byteBuffer = this.f12679f;
        this.f12679f = zzlx.a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int e() {
        return this.f12676c;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int f() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.f12679f = zzlx.a;
        this.f12680g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean g(int i2, int i3, int i4) throws zzly {
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            throw new zzly(i2, i3, i4);
        }
        if (this.f12675b == i2 && this.f12676c == i3 && this.f12677d == i4) {
            return false;
        }
        this.f12675b = i2;
        this.f12676c = i3;
        this.f12677d = i4;
        if (i4 != 2) {
            return true;
        }
        this.f12678e = zzlx.a;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
      0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.google.android.gms.internal.ads.zzlx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i4 = limit - position;
        int i5 = this.f12677d;
        if (i5 == Integer.MIN_VALUE) {
            i4 /= 3;
        } else if (i5 != 3) {
            if (i5 == 1073741824) {
                i2 = i4 / 2;
                if (this.f12678e.capacity() >= i2) {
                    this.f12678e = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                } else {
                    this.f12678e.clear();
                }
                i3 = this.f12677d;
                if (i3 != Integer.MIN_VALUE) {
                    while (position < limit) {
                        this.f12678e.put(byteBuffer.get(position + 1));
                        this.f12678e.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i3 == 3) {
                    while (position < limit) {
                        this.f12678e.put((byte) 0);
                        this.f12678e.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else {
                    if (i3 != 1073741824) {
                        throw new IllegalStateException();
                    }
                    while (position < limit) {
                        this.f12678e.put(byteBuffer.get(position + 2));
                        this.f12678e.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                this.f12678e.flip();
                this.f12679f = this.f12678e;
            }
            throw new IllegalStateException();
        }
        i2 = i4 << 1;
        if (this.f12678e.capacity() >= i2) {
        }
        i3 = this.f12677d;
        if (i3 != Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.f12678e.flip();
        this.f12679f = this.f12678e;
    }
}
