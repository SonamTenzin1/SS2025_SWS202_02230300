package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzccd extends zzaff {

    /* renamed from: f, reason: collision with root package name */
    private final Context f15046f;

    /* renamed from: g, reason: collision with root package name */
    private final zzbyt f15047g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbzl f15048h;

    /* renamed from: i, reason: collision with root package name */
    private final zzbyn f15049i;

    public zzccd(Context context, zzbyt zzbytVar, zzbzl zzbzlVar, zzbyn zzbynVar) {
        this.f15046f = context;
        this.f15047g = zzbytVar;
        this.f15048h = zzbzlVar;
        this.f15049i = zzbynVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final boolean F3(IObjectWrapper iObjectWrapper) {
        Object k0 = ObjectWrapper.k0(iObjectWrapper);
        if (!(k0 instanceof ViewGroup) || !this.f15048h.b((ViewGroup) k0)) {
            return false;
        }
        this.f15047g.A().x0(new ih(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaei N1(String str) {
        return this.f15047g.D().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper U4() {
        return ObjectWrapper.E0(this.f15046f);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String Y0(String str) {
        return this.f15047g.E().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void destroy() {
        this.f15049i.a();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final List<String> getAvailableAssetNames() {
        c.e.g<String, zzadw> D = this.f15047g.D();
        c.e.g<String, String> E = this.f15047g.E();
        String[] strArr = new String[D.size() + E.size()];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < D.size()) {
            strArr[i4] = D.j(i3);
            i3++;
            i4++;
        }
        while (i2 < E.size()) {
            strArr[i4] = E.j(i2);
            i2++;
            i4++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final String getCustomTemplateId() {
        return this.f15047g.e();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final zzaar getVideoController() {
        return this.f15047g.m();
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void performClick(String str) {
        this.f15049i.x(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final IObjectWrapper r() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafe
    public final void recordImpression() {
        this.f15049i.p();
    }
}
