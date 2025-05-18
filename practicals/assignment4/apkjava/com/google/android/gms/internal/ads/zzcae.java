package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcae implements zzbzb {
    private final zzana a;

    /* renamed from: b, reason: collision with root package name */
    private final zzand f14960b;

    /* renamed from: c, reason: collision with root package name */
    private final zzang f14961c;

    /* renamed from: d, reason: collision with root package name */
    private final zzbrt f14962d;

    /* renamed from: e, reason: collision with root package name */
    private final zzbri f14963e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f14964f;

    /* renamed from: g, reason: collision with root package name */
    private final zzcxm f14965g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbai f14966h;

    /* renamed from: i, reason: collision with root package name */
    private final zzcxv f14967i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14968j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14969k = false;

    public zzcae(zzana zzanaVar, zzand zzandVar, zzang zzangVar, zzbrt zzbrtVar, zzbri zzbriVar, Context context, zzcxm zzcxmVar, zzbai zzbaiVar, zzcxv zzcxvVar) {
        this.a = zzanaVar;
        this.f14960b = zzandVar;
        this.f14961c = zzangVar;
        this.f14962d = zzbrtVar;
        this.f14963e = zzbriVar;
        this.f14964f = context;
        this.f14965g = zzcxmVar;
        this.f14966h = zzbaiVar;
        this.f14967i = zzcxvVar;
    }

    private final void o(View view) {
        try {
            zzang zzangVar = this.f14961c;
            if (zzangVar != null && !zzangVar.M()) {
                this.f14961c.N(ObjectWrapper.E0(view));
                this.f14963e.onAdClicked();
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null && !zzanaVar.M()) {
                this.a.N(ObjectWrapper.E0(view));
                this.f14963e.onAdClicked();
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar == null || zzandVar.M()) {
                return;
            }
            this.f14960b.N(ObjectWrapper.E0(view));
            this.f14963e.onAdClicked();
        } catch (RemoteException e2) {
            zzbad.d("Failed to call handleClick", e2);
        }
    }

    private static HashMap<String, View> p(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void G0(zzaag zzaagVar) {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void W() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper E0 = ObjectWrapper.E0(view);
            HashMap<String, View> p = p(map);
            HashMap<String, View> p2 = p(map2);
            zzang zzangVar = this.f14961c;
            if (zzangVar != null) {
                zzangVar.D(E0, ObjectWrapper.E0(p), ObjectWrapper.E0(p2));
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null) {
                zzanaVar.D(E0, ObjectWrapper.E0(p), ObjectWrapper.E0(p2));
                this.a.C0(E0);
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar != null) {
                zzandVar.D(E0, ObjectWrapper.E0(p), ObjectWrapper.E0(p2));
                this.f14960b.C0(E0);
            }
        } catch (RemoteException e2) {
            zzbad.d("Failed to call trackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void b(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void c(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d0(zzagd zzagdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper E0 = ObjectWrapper.E0(view);
            zzang zzangVar = this.f14961c;
            if (zzangVar != null) {
                zzangVar.A(E0);
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null) {
                zzanaVar.A(E0);
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar != null) {
                zzandVar.A(E0);
            }
        } catch (RemoteException e2) {
            zzbad.d("Failed to call untrackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e0(zzaak zzaakVar) {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void f(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void g(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void h(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.f14969k && this.f14965g.D) {
            return;
        }
        o(view);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void i(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            boolean z = this.f14968j;
            if (!z && this.f14965g.z != null) {
                this.f14968j = z | zzk.zzlq().c(this.f14964f, this.f14966h.f14326f, this.f14965g.z.toString(), this.f14967i.f15752f);
            }
            zzang zzangVar = this.f14961c;
            if (zzangVar != null && !zzangVar.C()) {
                this.f14961c.recordImpression();
                this.f14962d.Y();
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null && !zzanaVar.C()) {
                this.a.recordImpression();
                this.f14962d.Y();
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar == null || zzandVar.C()) {
                return;
            }
            this.f14960b.recordImpression();
            this.f14962d.Y();
        } catch (RemoteException e2) {
            zzbad.d("Failed to call recordImpression", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j0() {
        this.f14969k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void k(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f14969k) {
            zzbad.i("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.f14965g.D) {
            zzbad.i("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            o(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void l() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean m(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void n() {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }
}
