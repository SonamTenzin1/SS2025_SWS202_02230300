package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class zz {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f13725b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f13726c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f13727d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f13728e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zz(long[] jArr, int[] iArr, long[] jArr2, int[] iArr2) {
        zzkh.a(iArr.length == jArr2.length);
        zzkh.a(jArr.length == jArr2.length);
        zzkh.a(iArr2.length == jArr2.length);
        this.f13725b = jArr;
        this.f13726c = iArr;
        this.f13727d = jArr2;
        this.f13728e = iArr2;
        this.a = jArr.length;
    }
}
