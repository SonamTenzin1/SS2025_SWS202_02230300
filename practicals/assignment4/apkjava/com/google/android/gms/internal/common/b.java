package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class b extends g {

    /* renamed from: h, reason: collision with root package name */
    private final zzag f17062h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzag zzagVar, int i2) {
        super(zzagVar.size(), i2);
        this.f17062h = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.g
    protected final Object b(int i2) {
        return this.f17062h.get(i2);
    }
}
