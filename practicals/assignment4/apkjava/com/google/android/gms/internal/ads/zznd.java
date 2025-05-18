package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zznd extends zzmy {

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f16502c;

    /* renamed from: d, reason: collision with root package name */
    public long f16503d;

    /* renamed from: b, reason: collision with root package name */
    public final zzmz f16501b = new zzmz();

    /* renamed from: e, reason: collision with root package name */
    private final int f16504e = 0;

    public zznd(int i2) {
    }

    private final ByteBuffer i(int i2) {
        ByteBuffer byteBuffer = this.f16502c;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i2);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f16502c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void h(int i2) throws IllegalStateException {
        ByteBuffer byteBuffer = this.f16502c;
        if (byteBuffer == null) {
            this.f16502c = i(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f16502c.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            return;
        }
        ByteBuffer i4 = i(i3);
        if (position > 0) {
            this.f16502c.position(0);
            this.f16502c.limit(position);
            i4.put(this.f16502c);
        }
        this.f16502c = i4;
    }

    public final boolean j() {
        return d(1073741824);
    }
}
