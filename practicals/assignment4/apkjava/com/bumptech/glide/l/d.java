package com.bumptech.glide.l;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f9008b;

    /* renamed from: c, reason: collision with root package name */
    private c f9009c;
    private final byte[] a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f9010d = 0;

    private boolean b() {
        return this.f9009c.f8998b != 0;
    }

    private int d() {
        try {
            return this.f9008b.get() & 255;
        } catch (Exception unused) {
            this.f9009c.f8998b = 1;
            return 0;
        }
    }

    private void e() {
        this.f9009c.f9000d.a = n();
        this.f9009c.f9000d.f8988b = n();
        this.f9009c.f9000d.f8989c = n();
        this.f9009c.f9000d.f8990d = n();
        int d2 = d();
        boolean z = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        b bVar = this.f9009c.f9000d;
        bVar.f8991e = (d2 & 64) != 0;
        if (z) {
            bVar.f8997k = g(pow);
        } else {
            bVar.f8997k = null;
        }
        this.f9009c.f9000d.f8996j = this.f9008b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f9009c;
        cVar.f8999c++;
        cVar.f9001e.add(cVar.f9000d);
    }

    private void f() {
        int d2 = d();
        this.f9010d = d2;
        if (d2 <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.f9010d;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.f9008b.get(this.a, i2, i3);
                i2 += i3;
            } catch (Exception e2) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f9010d, e2);
                }
                this.f9009c.f8998b = 1;
                return;
            }
        }
    }

    private int[] g(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f9008b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f9009c.f8998b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i2) {
        boolean z = false;
        while (!z && !b() && this.f9009c.f8999c <= i2) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    q();
                } else if (d3 == 249) {
                    this.f9009c.f9000d = new b();
                    j();
                } else if (d3 == 254) {
                    q();
                } else if (d3 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f9009c;
                if (cVar.f9000d == null) {
                    cVar.f9000d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f9009c.f8998b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int d2 = d();
        b bVar = this.f9009c.f9000d;
        int i2 = (d2 & 28) >> 2;
        bVar.f8993g = i2;
        if (i2 == 0) {
            bVar.f8993g = 1;
        }
        bVar.f8992f = (d2 & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f9009c.f9000d;
        bVar2.f8995i = n * 10;
        bVar2.f8994h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f9009c.f8998b = 1;
            return;
        }
        l();
        if (!this.f9009c.f9004h || b()) {
            return;
        }
        c cVar = this.f9009c;
        cVar.a = g(cVar.f9005i);
        c cVar2 = this.f9009c;
        cVar2.l = cVar2.a[cVar2.f9006j];
    }

    private void l() {
        this.f9009c.f9002f = n();
        this.f9009c.f9003g = n();
        int d2 = d();
        c cVar = this.f9009c;
        cVar.f9004h = (d2 & 128) != 0;
        cVar.f9005i = (int) Math.pow(2.0d, (d2 & 7) + 1);
        this.f9009c.f9006j = d();
        this.f9009c.f9007k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.f9009c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f9010d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f9008b.getShort();
    }

    private void o() {
        this.f9008b = null;
        Arrays.fill(this.a, (byte) 0);
        this.f9009c = new c();
        this.f9010d = 0;
    }

    private void q() {
        int d2;
        do {
            d2 = d();
            this.f9008b.position(Math.min(this.f9008b.position() + d2, this.f9008b.limit()));
        } while (d2 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f9008b = null;
        this.f9009c = null;
    }

    public c c() {
        if (this.f9008b != null) {
            if (b()) {
                return this.f9009c;
            }
            k();
            if (!b()) {
                h();
                c cVar = this.f9009c;
                if (cVar.f8999c < 0) {
                    cVar.f8998b = 1;
                }
            }
            return this.f9009c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f9008b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f9008b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
