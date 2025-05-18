package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzdni extends zzdmq {
    private static final Logger a = Logger.getLogger(zzdni.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f15990b = gx.p();

    /* renamed from: c, reason: collision with root package name */
    su f15991c;

    /* loaded from: classes2.dex */
    static class a extends zzdni {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f15992d;

        /* renamed from: e, reason: collision with root package name */
        private final int f15993e;

        /* renamed from: f, reason: collision with root package name */
        private final int f15994f;

        /* renamed from: g, reason: collision with root package name */
        private int f15995g;

        a(byte[] bArr, int i2, int i3) {
            super();
            if (bArr != null) {
                int i4 = i2 + i3;
                if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                    this.f15992d = bArr;
                    this.f15993e = i2;
                    this.f15995g = i2;
                    this.f15994f = i4;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void D(int i2, zzdmr zzdmrVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            g(3, zzdmrVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void E(int i2, zzdpk zzdpkVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            h(3, zzdpkVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void H0(int i2, int i3) throws IOException {
            e0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void I0(int i2, int i3) throws IOException {
            H0(i2, 0);
            b0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void J0(int i2, int i3) throws IOException {
            H0(i2, 0);
            e0(i3);
        }

        public final int L0() {
            return this.f15995g - this.f15993e;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void M(zzdmr zzdmrVar) throws IOException {
            e0(zzdmrVar.size());
            zzdmrVar.g(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void P(byte b2) throws IOException {
            try {
                byte[] bArr = this.f15992d;
                int i2 = this.f15995g;
                this.f15995g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void R(int i2, String str) throws IOException {
            H0(i2, 2);
            q0(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void S(long j2) throws IOException {
            if (zzdni.f15990b && u() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f15992d;
                    int i2 = this.f15995g;
                    this.f15995g = i2 + 1;
                    gx.i(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f15992d;
                int i3 = this.f15995g;
                this.f15995g = i3 + 1;
                gx.i(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f15992d;
                    int i4 = this.f15995g;
                    this.f15995g = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), 1), e2);
                }
            }
            byte[] bArr4 = this.f15992d;
            int i5 = this.f15995g;
            this.f15995g = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void U(long j2) throws IOException {
            try {
                byte[] bArr = this.f15992d;
                int i2 = this.f15995g;
                int i3 = i2 + 1;
                this.f15995g = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.f15995g = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.f15995g = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.f15995g = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.f15995g = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.f15995g = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.f15995g = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.f15995g = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public void b() {
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void b0(int i2) throws IOException {
            if (i2 >= 0) {
                e0(i2);
            } else {
                S(i2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f15992d, this.f15995g, i3);
                this.f15995g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void e0(int i2) throws IOException {
            if (zzdni.f15990b && u() >= 10) {
                while ((i2 & (-128)) != 0) {
                    byte[] bArr = this.f15992d;
                    int i3 = this.f15995g;
                    this.f15995g = i3 + 1;
                    gx.i(bArr, i3, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.f15992d;
                int i4 = this.f15995g;
                this.f15995g = i4 + 1;
                gx.i(bArr2, i4, (byte) i2);
                return;
            }
            while ((i2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f15992d;
                    int i5 = this.f15995g;
                    this.f15995g = i5 + 1;
                    bArr3[i5] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), 1), e2);
                }
            }
            byte[] bArr4 = this.f15992d;
            int i6 = this.f15995g;
            this.f15995g = i6 + 1;
            bArr4[i6] = (byte) i2;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g(int i2, zzdmr zzdmrVar) throws IOException {
            H0(i2, 2);
            M(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g0(int i2) throws IOException {
            try {
                byte[] bArr = this.f15992d;
                int i3 = this.f15995g;
                int i4 = i3 + 1;
                this.f15995g = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.f15995g = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.f15995g = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.f15995g = i6 + 1;
                bArr[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f15995g), Integer.valueOf(this.f15994f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void h(int i2, zzdpk zzdpkVar) throws IOException {
            H0(i2, 2);
            y0(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void i(int i2, zzdpk zzdpkVar, lw lwVar) throws IOException {
            H0(i2, 2);
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int c2 = zzdmiVar.c();
            if (c2 == -1) {
                c2 = lwVar.i(zzdmiVar);
                zzdmiVar.j(c2);
            }
            e0(c2);
            lwVar.e(zzdpkVar, this.f15991c);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void j(zzdpk zzdpkVar, lw lwVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int c2 = zzdmiVar.c();
            if (c2 == -1) {
                c2 = lwVar.i(zzdmiVar);
                zzdmiVar.j(c2);
            }
            e0(c2);
            lwVar.e(zzdpkVar, this.f15991c);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void l(int i2, int i3) throws IOException {
            H0(i2, 5);
            g0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void q0(String str) throws IOException {
            int i2 = this.f15995g;
            try {
                int j0 = zzdni.j0(str.length() * 3);
                int j02 = zzdni.j0(str.length());
                if (j02 == j0) {
                    int i3 = i2 + j02;
                    this.f15995g = i3;
                    int b2 = jx.b(str, this.f15992d, i3, u());
                    this.f15995g = i2;
                    e0((b2 - i2) - j02);
                    this.f15995g = b2;
                    return;
                }
                e0(jx.a(str));
                this.f15995g = jx.b(str, this.f15992d, this.f15995g, u());
            } catch (nx e2) {
                this.f15995g = i2;
                k(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void t0(int i2, long j2) throws IOException {
            H0(i2, 0);
            S(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int u() {
            return this.f15994f - this.f15995g;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void v0(int i2, boolean z) throws IOException {
            H0(i2, 0);
            P(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void x0(int i2, long j2) throws IOException {
            H0(i2, 1);
            U(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void y0(zzdpk zzdpkVar) throws IOException {
            e0(zzdpkVar.i());
            zzdpkVar.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: h, reason: collision with root package name */
        private final ByteBuffer f15996h;

        /* renamed from: i, reason: collision with root package name */
        private int f15997i;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f15996h = byteBuffer;
            this.f15997i = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzdni.a, com.google.android.gms.internal.ads.zzdni
        public final void b() {
            this.f15996h.position(this.f15997i + L0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzdni {

        /* renamed from: d, reason: collision with root package name */
        private final ByteBuffer f15998d;

        /* renamed from: e, reason: collision with root package name */
        private final ByteBuffer f15999e;

        /* renamed from: f, reason: collision with root package name */
        private final int f16000f;

        c(ByteBuffer byteBuffer) {
            super();
            this.f15998d = byteBuffer;
            this.f15999e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f16000f = byteBuffer.position();
        }

        private final void L0(String str) throws IOException {
            try {
                jx.c(str, this.f15999e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void D(int i2, zzdmr zzdmrVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            g(3, zzdmrVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void E(int i2, zzdpk zzdpkVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            h(3, zzdpkVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void H0(int i2, int i3) throws IOException {
            e0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void I0(int i2, int i3) throws IOException {
            H0(i2, 0);
            b0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void J0(int i2, int i3) throws IOException {
            H0(i2, 0);
            e0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void M(zzdmr zzdmrVar) throws IOException {
            e0(zzdmrVar.size());
            zzdmrVar.g(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void P(byte b2) throws IOException {
            try {
                this.f15999e.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void R(int i2, String str) throws IOException {
            H0(i2, 2);
            q0(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void S(long j2) throws IOException {
            while (((-128) & j2) != 0) {
                try {
                    this.f15999e.put((byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f15999e.put((byte) j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void U(long j2) throws IOException {
            try {
                this.f15999e.putLong(j2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void b() {
            this.f15998d.position(this.f15999e.position());
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void b0(int i2) throws IOException {
            if (i2 >= 0) {
                e0(i2);
            } else {
                S(i2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.f15999e.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void e0(int i2) throws IOException {
            while ((i2 & (-128)) != 0) {
                try {
                    this.f15999e.put((byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f15999e.put((byte) i2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g(int i2, zzdmr zzdmrVar) throws IOException {
            H0(i2, 2);
            M(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g0(int i2) throws IOException {
            try {
                this.f15999e.putInt(i2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void h(int i2, zzdpk zzdpkVar) throws IOException {
            H0(i2, 2);
            y0(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void i(int i2, zzdpk zzdpkVar, lw lwVar) throws IOException {
            H0(i2, 2);
            j(zzdpkVar, lwVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void j(zzdpk zzdpkVar, lw lwVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int c2 = zzdmiVar.c();
            if (c2 == -1) {
                c2 = lwVar.i(zzdmiVar);
                zzdmiVar.j(c2);
            }
            e0(c2);
            lwVar.e(zzdpkVar, this.f15991c);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void l(int i2, int i3) throws IOException {
            H0(i2, 5);
            g0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void q0(String str) throws IOException {
            int position = this.f15999e.position();
            try {
                int j0 = zzdni.j0(str.length() * 3);
                int j02 = zzdni.j0(str.length());
                if (j02 == j0) {
                    int position2 = this.f15999e.position() + j02;
                    this.f15999e.position(position2);
                    L0(str);
                    int position3 = this.f15999e.position();
                    this.f15999e.position(position);
                    e0(position3 - position2);
                    this.f15999e.position(position3);
                    return;
                }
                e0(jx.a(str));
                L0(str);
            } catch (nx e2) {
                this.f15999e.position(position);
                k(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void t0(int i2, long j2) throws IOException {
            H0(i2, 0);
            S(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int u() {
            return this.f15999e.remaining();
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void v0(int i2, boolean z) throws IOException {
            H0(i2, 0);
            P(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void x0(int i2, long j2) throws IOException {
            H0(i2, 1);
            U(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void y0(zzdpk zzdpkVar) throws IOException {
            e0(zzdpkVar.i());
            zzdpkVar.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzdni {

        /* renamed from: d, reason: collision with root package name */
        private final ByteBuffer f16001d;

        /* renamed from: e, reason: collision with root package name */
        private final ByteBuffer f16002e;

        /* renamed from: f, reason: collision with root package name */
        private final long f16003f;

        /* renamed from: g, reason: collision with root package name */
        private final long f16004g;

        /* renamed from: h, reason: collision with root package name */
        private final long f16005h;

        /* renamed from: i, reason: collision with root package name */
        private final long f16006i;

        /* renamed from: j, reason: collision with root package name */
        private long f16007j;

        d(ByteBuffer byteBuffer) {
            super();
            this.f16001d = byteBuffer;
            this.f16002e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long J = gx.J(byteBuffer);
            this.f16003f = J;
            long position = byteBuffer.position() + J;
            this.f16004g = position;
            long limit = J + byteBuffer.limit();
            this.f16005h = limit;
            this.f16006i = limit - 10;
            this.f16007j = position;
        }

        private final void L0(long j2) {
            this.f16002e.position((int) (j2 - this.f16003f));
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void D(int i2, zzdmr zzdmrVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            g(3, zzdmrVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void E(int i2, zzdpk zzdpkVar) throws IOException {
            H0(1, 3);
            J0(2, i2);
            h(3, zzdpkVar);
            H0(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void H0(int i2, int i3) throws IOException {
            e0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void I0(int i2, int i3) throws IOException {
            H0(i2, 0);
            b0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void J0(int i2, int i3) throws IOException {
            H0(i2, 0);
            e0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void M(zzdmr zzdmrVar) throws IOException {
            e0(zzdmrVar.size());
            zzdmrVar.g(this);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void P(byte b2) throws IOException {
            long j2 = this.f16007j;
            if (j2 < this.f16005h) {
                this.f16007j = 1 + j2;
                gx.b(j2, b2);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f16007j), Long.valueOf(this.f16005h), 1));
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void R(int i2, String str) throws IOException {
            H0(i2, 2);
            q0(str);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void S(long j2) throws IOException {
            if (this.f16007j <= this.f16006i) {
                while ((j2 & (-128)) != 0) {
                    long j3 = this.f16007j;
                    this.f16007j = j3 + 1;
                    gx.b(j3, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                long j4 = this.f16007j;
                this.f16007j = 1 + j4;
                gx.b(j4, (byte) j2);
                return;
            }
            while (true) {
                long j5 = this.f16007j;
                if (j5 >= this.f16005h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f16007j), Long.valueOf(this.f16005h), 1));
                }
                if ((j2 & (-128)) == 0) {
                    this.f16007j = 1 + j5;
                    gx.b(j5, (byte) j2);
                    return;
                } else {
                    this.f16007j = j5 + 1;
                    gx.b(j5, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void U(long j2) throws IOException {
            this.f16002e.putLong((int) (this.f16007j - this.f16003f), j2);
            this.f16007j += 8;
        }

        @Override // com.google.android.gms.internal.ads.zzdmq
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void b() {
            this.f16001d.position((int) (this.f16007j - this.f16003f));
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void b0(int i2) throws IOException {
            if (i2 >= 0) {
                e0(i2);
            } else {
                S(i2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = i3;
                long j3 = this.f16005h - j2;
                long j4 = this.f16007j;
                if (j3 >= j4) {
                    gx.j(bArr, i2, j4, j2);
                    this.f16007j += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f16007j), Long.valueOf(this.f16005h), Integer.valueOf(i3)));
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void e0(int i2) throws IOException {
            if (this.f16007j <= this.f16006i) {
                while ((i2 & (-128)) != 0) {
                    long j2 = this.f16007j;
                    this.f16007j = j2 + 1;
                    gx.b(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.f16007j;
                this.f16007j = 1 + j3;
                gx.b(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.f16007j;
                if (j4 >= this.f16005h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f16007j), Long.valueOf(this.f16005h), 1));
                }
                if ((i2 & (-128)) == 0) {
                    this.f16007j = 1 + j4;
                    gx.b(j4, (byte) i2);
                    return;
                } else {
                    this.f16007j = j4 + 1;
                    gx.b(j4, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g(int i2, zzdmr zzdmrVar) throws IOException {
            H0(i2, 2);
            M(zzdmrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void g0(int i2) throws IOException {
            this.f16002e.putInt((int) (this.f16007j - this.f16003f), i2);
            this.f16007j += 4;
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void h(int i2, zzdpk zzdpkVar) throws IOException {
            H0(i2, 2);
            y0(zzdpkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void i(int i2, zzdpk zzdpkVar, lw lwVar) throws IOException {
            H0(i2, 2);
            j(zzdpkVar, lwVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        final void j(zzdpk zzdpkVar, lw lwVar) throws IOException {
            zzdmi zzdmiVar = (zzdmi) zzdpkVar;
            int c2 = zzdmiVar.c();
            if (c2 == -1) {
                c2 = lwVar.i(zzdmiVar);
                zzdmiVar.j(c2);
            }
            e0(c2);
            lwVar.e(zzdpkVar, this.f15991c);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void l(int i2, int i3) throws IOException {
            H0(i2, 5);
            g0(i3);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void q0(String str) throws IOException {
            long j2 = this.f16007j;
            try {
                int j0 = zzdni.j0(str.length() * 3);
                int j02 = zzdni.j0(str.length());
                if (j02 == j0) {
                    int i2 = ((int) (this.f16007j - this.f16003f)) + j02;
                    this.f16002e.position(i2);
                    jx.c(str, this.f16002e);
                    int position = this.f16002e.position() - i2;
                    e0(position);
                    this.f16007j += position;
                    return;
                }
                int a = jx.a(str);
                e0(a);
                L0(this.f16007j);
                jx.c(str, this.f16002e);
                this.f16007j += a;
            } catch (nx e2) {
                this.f16007j = j2;
                L0(j2);
                k(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void t0(int i2, long j2) throws IOException {
            H0(i2, 0);
            S(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final int u() {
            return (int) (this.f16005h - this.f16007j);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void v0(int i2, boolean z) throws IOException {
            H0(i2, 0);
            P(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void x0(int i2, long j2) throws IOException {
            H0(i2, 1);
            U(j2);
        }

        @Override // com.google.android.gms.internal.ads.zzdni
        public final void y0(zzdpk zzdpkVar) throws IOException {
            e0(zzdpkVar.i());
            zzdpkVar.h(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        zzc(String str) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "));
            String valueOf = String.valueOf(str);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        zzc(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }
    }

    private zzdni() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(zzdpk zzdpkVar, lw lwVar) {
        zzdmi zzdmiVar = (zzdmi) zzdpkVar;
        int c2 = zzdmiVar.c();
        if (c2 == -1) {
            c2 = lwVar.i(zzdmiVar);
            zzdmiVar.j(c2);
        }
        return j0(c2) + c2;
    }

    public static int A0(zzdpk zzdpkVar) {
        int i2 = zzdpkVar.i();
        return j0(i2) + i2;
    }

    public static int B0(int i2, long j2) {
        return h0(i2) + W(j2);
    }

    @Deprecated
    public static int C0(zzdpk zzdpkVar) {
        return zzdpkVar.i();
    }

    public static int D0(int i2, long j2) {
        return h0(i2) + W(a0(j2));
    }

    public static zzdni E0(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (gx.q()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int F0(int i2, long j2) {
        return h0(i2) + 8;
    }

    public static int G(boolean z) {
        return 1;
    }

    public static int G0(int i2, long j2) {
        return h0(i2) + 8;
    }

    public static int H(double d2) {
        return 8;
    }

    public static int I(int i2, double d2) {
        return h0(i2) + 8;
    }

    public static int J(int i2, zzdmr zzdmrVar) {
        int h0 = h0(i2);
        int size = zzdmrVar.size();
        return h0 + j0(size) + size;
    }

    public static int K(int i2, zzdpk zzdpkVar) {
        return h0(i2) + A0(zzdpkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int L(int i2, zzdpk zzdpkVar, lw lwVar) {
        int h0 = h0(i2) << 1;
        zzdmi zzdmiVar = (zzdmi) zzdpkVar;
        int c2 = zzdmiVar.c();
        if (c2 == -1) {
            c2 = lwVar.i(zzdmiVar);
            zzdmiVar.j(c2);
        }
        return h0 + c2;
    }

    public static int N(int i2, zzdmr zzdmrVar) {
        return (h0(1) << 1) + o(2, i2) + J(3, zzdmrVar);
    }

    public static int O(int i2, zzdpk zzdpkVar) {
        return (h0(1) << 1) + o(2, i2) + K(3, zzdpkVar);
    }

    public static int Q(zzdmr zzdmrVar) {
        int size = zzdmrVar.size();
        return j0(size) + size;
    }

    public static int V(long j2) {
        return W(j2);
    }

    public static int W(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int X(long j2) {
        return W(a0(j2));
    }

    public static int Y(long j2) {
        return 8;
    }

    public static int Z(long j2) {
        return 8;
    }

    private static long a0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int c0(int i2, String str) {
        return h0(i2) + r0(str);
    }

    public static int d(int i2, zzdor zzdorVar) {
        int h0 = h0(i2);
        int b2 = zzdorVar.b();
        return h0 + j0(b2) + b2;
    }

    public static int e(zzdor zzdorVar) {
        int b2 = zzdorVar.b();
        return j0(b2) + b2;
    }

    public static int h0(int i2) {
        return j0(i2 << 3);
    }

    public static int i0(int i2) {
        if (i2 >= 0) {
            return j0(i2);
        }
        return 10;
    }

    public static int j0(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int k0(int i2) {
        return j0(o0(i2));
    }

    public static int l0(int i2) {
        return 4;
    }

    public static int m(int i2, int i3) {
        return h0(i2) + i0(i3);
    }

    public static int m0(int i2) {
        return 4;
    }

    public static zzdni n(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int n0(int i2) {
        return i0(i2);
    }

    public static int o(int i2, int i3) {
        return h0(i2) + j0(i3);
    }

    private static int o0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static int p(byte[] bArr) {
        int length = bArr.length;
        return j0(length) + length;
    }

    @Deprecated
    public static int p0(int i2) {
        return j0(i2);
    }

    public static int q(int i2, int i3) {
        return h0(i2) + j0(o0(i3));
    }

    public static int r(int i2, int i3) {
        return h0(i2) + 4;
    }

    public static int r0(String str) {
        int length;
        try {
            length = jx.a(str);
        } catch (nx unused) {
            length = str.getBytes(zzdod.a).length;
        }
        return j0(length) + length;
    }

    public static int s(int i2, int i3) {
        return h0(i2) + 4;
    }

    public static int s0(float f2) {
        return 4;
    }

    public static int t(int i2, int i3) {
        return h0(i2) + i0(i3);
    }

    public static int w0(int i2, boolean z) {
        return h0(i2) + 1;
    }

    public static int x(int i2, float f2) {
        return h0(i2) + 4;
    }

    public static int y(int i2, zzdor zzdorVar) {
        return (h0(1) << 1) + o(2, i2) + d(3, zzdorVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(int i2, zzdpk zzdpkVar, lw lwVar) {
        return h0(i2) + A(zzdpkVar, lwVar);
    }

    public static int z0(int i2, long j2) {
        return h0(i2) + W(j2);
    }

    public final void B(double d2) throws IOException {
        U(Double.doubleToRawLongBits(d2));
    }

    public final void C(int i2, double d2) throws IOException {
        x0(i2, Double.doubleToRawLongBits(d2));
    }

    public abstract void D(int i2, zzdmr zzdmrVar) throws IOException;

    public abstract void E(int i2, zzdpk zzdpkVar) throws IOException;

    public final void F(boolean z) throws IOException {
        P(z ? (byte) 1 : (byte) 0);
    }

    public abstract void H0(int i2, int i3) throws IOException;

    public abstract void I0(int i2, int i3) throws IOException;

    public abstract void J0(int i2, int i3) throws IOException;

    public final void K0(int i2, int i3) throws IOException {
        J0(i2, o0(i3));
    }

    public abstract void M(zzdmr zzdmrVar) throws IOException;

    public abstract void P(byte b2) throws IOException;

    public abstract void R(int i2, String str) throws IOException;

    public abstract void S(long j2) throws IOException;

    public final void T(long j2) throws IOException {
        S(a0(j2));
    }

    public abstract void U(long j2) throws IOException;

    public abstract void b() throws IOException;

    public abstract void b0(int i2) throws IOException;

    public abstract void c(byte[] bArr, int i2, int i3) throws IOException;

    public final void d0(float f2) throws IOException {
        g0(Float.floatToRawIntBits(f2));
    }

    public abstract void e0(int i2) throws IOException;

    public final void f(int i2, float f2) throws IOException {
        l(i2, Float.floatToRawIntBits(f2));
    }

    public final void f0(int i2) throws IOException {
        e0(o0(i2));
    }

    public abstract void g(int i2, zzdmr zzdmrVar) throws IOException;

    public abstract void g0(int i2) throws IOException;

    public abstract void h(int i2, zzdpk zzdpkVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(int i2, zzdpk zzdpkVar, lw lwVar) throws IOException;

    abstract void j(zzdpk zzdpkVar, lw lwVar) throws IOException;

    final void k(String str, nx nxVar) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) nxVar);
        byte[] bytes = str.getBytes(zzdod.a);
        try {
            e0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }

    public abstract void l(int i2, int i3) throws IOException;

    public abstract void q0(String str) throws IOException;

    public abstract void t0(int i2, long j2) throws IOException;

    public abstract int u();

    public final void u0(int i2, long j2) throws IOException {
        t0(i2, a0(j2));
    }

    public final void v() {
        if (u() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void v0(int i2, boolean z) throws IOException;

    public abstract void x0(int i2, long j2) throws IOException;

    public abstract void y0(zzdpk zzdpkVar) throws IOException;
}
