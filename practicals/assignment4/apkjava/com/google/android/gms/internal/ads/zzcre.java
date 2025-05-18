package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcre implements zzcva<zzcrd> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15561b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcxv f15562c;

    /* renamed from: d, reason: collision with root package name */
    private final View f15563d;

    public zzcre(zzbbl zzbblVar, Context context, zzcxv zzcxvVar, ViewGroup viewGroup) {
        this.a = zzbblVar;
        this.f15561b = context;
        this.f15562c = zzcxvVar;
        this.f15563d = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcrd a() throws Exception {
        Context context = this.f15561b;
        zzyd zzydVar = this.f15562c.f15751e;
        ArrayList arrayList = new ArrayList();
        View view = this.f15563d;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcrd(context, zzydVar, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcrd> b() {
        if (!((Boolean) zzyt.e().c(zzacu.y0)).booleanValue()) {
            return zzbar.l(new Exception("Ad Key signal disabled."));
        }
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.on

            /* renamed from: f, reason: collision with root package name */
            private final zzcre f13111f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13111f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13111f.a();
            }
        });
    }
}
