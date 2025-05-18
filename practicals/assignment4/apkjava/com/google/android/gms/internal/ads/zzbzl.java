package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbzl {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzaxb f14920b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcxv f14921c;

    /* renamed from: d, reason: collision with root package name */
    private final zzbyx f14922d;

    /* renamed from: e, reason: collision with root package name */
    private final zzbyt f14923e;

    /* renamed from: f, reason: collision with root package name */
    private final zzbzt f14924f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f14925g;

    /* renamed from: h, reason: collision with root package name */
    private final Executor f14926h;

    /* renamed from: i, reason: collision with root package name */
    private final zzady f14927i;

    public zzbzl(Context context, zzaxb zzaxbVar, zzcxv zzcxvVar, zzbyx zzbyxVar, zzbyt zzbytVar, zzbzt zzbztVar, Executor executor, Executor executor2) {
        this.a = context;
        this.f14920b = zzaxbVar;
        this.f14921c = zzcxvVar;
        this.f14927i = zzcxvVar.f15755i;
        this.f14922d = zzbyxVar;
        this.f14923e = zzbytVar;
        this.f14924f = zzbztVar;
        this.f14925g = executor;
        this.f14926h = executor2;
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i2 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(zzcab zzcabVar, String[] strArr) {
        Map<String, WeakReference<View>> V3 = zzcabVar.V3();
        if (V3 == null) {
            return false;
        }
        for (String str : strArr) {
            if (V3.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View z = this.f14923e.z();
        if (z == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (z.getParent() instanceof ViewGroup) {
            ((ViewGroup) z.getParent()).removeView(z);
        }
        if (((Boolean) zzyt.e().c(zzacu.R2)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(z, layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.f14923e.z() != null) {
            if (2 != this.f14923e.w() && 1 != this.f14923e.w()) {
                if (6 == this.f14923e.w()) {
                    this.f14920b.z(this.f14921c.f15752f, "2", z);
                    this.f14920b.z(this.f14921c.f15752f, "1", z);
                    return;
                }
                return;
            }
            this.f14920b.z(this.f14921c.f15752f, String.valueOf(this.f14923e.w()), z);
        }
    }

    public final void f(final zzcab zzcabVar) {
        this.f14925g.execute(new Runnable(this, zzcabVar) { // from class: com.google.android.gms.internal.ads.zf

            /* renamed from: f, reason: collision with root package name */
            private final zzbzl f13705f;

            /* renamed from: g, reason: collision with root package name */
            private final zzcab f13706g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13705f = this;
                this.f13706g = zzcabVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13705f.h(this.f13706g);
            }
        });
    }

    public final void g(zzcab zzcabVar) {
        if (zzcabVar == null || this.f14924f == null || zzcabVar.E0() == null) {
            return;
        }
        try {
            zzcabVar.E0().addView(this.f14924f.c());
        } catch (zzbhj e2) {
            zzawz.l("web view can not be obtained", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(zzcab zzcabVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        Drawable drawable;
        if (this.f14922d.c() || this.f14922d.b()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            for (int i2 = 0; i2 < 2; i2++) {
                View Y4 = zzcabVar.Y4(strArr[i2]);
                if (Y4 != null && (Y4 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) Y4;
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f14923e.x() != null) {
            view = this.f14923e.x();
            zzady zzadyVar = this.f14927i;
            if (zzadyVar != null && !z) {
                a(layoutParams, zzadyVar.f13849j);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.f14923e.V() instanceof zzadt) {
            zzadt zzadtVar = (zzadt) this.f14923e.V();
            if (!z) {
                a(layoutParams, zzadtVar.n7());
            }
            View zzaduVar = new zzadu(this.a, zzadtVar, layoutParams);
            zzaduVar.setContentDescription((CharSequence) zzyt.e().c(zzacu.O2));
            view = zzaduVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcabVar.k0().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout E0 = zzcabVar.E0();
                if (E0 != null) {
                    E0.addView(adChoicesView);
                }
            }
            zzcabVar.H(zzcabVar.A5(), view, true);
        }
        if (!((Boolean) zzyt.e().c(zzacu.X4)).booleanValue()) {
            g(zzcabVar);
        }
        String[] strArr2 = zzbzj.f14914f;
        int length = strArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                viewGroup2 = null;
                break;
            }
            View Y42 = zzcabVar.Y4(strArr2[i3]);
            if (Y42 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) Y42;
                break;
            }
            i3++;
        }
        this.f14926h.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.ag

            /* renamed from: f, reason: collision with root package name */
            private final zzbzl f12253f;

            /* renamed from: g, reason: collision with root package name */
            private final ViewGroup f12254g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12253f = this;
                this.f12254g = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12253f.e(this.f12254g);
            }
        });
        if (viewGroup2 != null) {
            if (b(viewGroup2)) {
                if (this.f14923e.A() != null) {
                    this.f14923e.A().x0(new bg(this, zzcabVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View k0 = zzcabVar.k0();
            Context context = k0 != null ? k0.getContext() : null;
            if (context == null || this.f14923e.h() == null || this.f14923e.h().isEmpty()) {
                return;
            }
            zzadw zzadwVar = this.f14923e.h().get(0);
            zzaei h7 = zzadwVar instanceof IBinder ? zzaej.h7(zzadwVar) : null;
            if (h7 != null) {
                try {
                    IObjectWrapper t4 = h7.t4();
                    if (t4 == null || (drawable = (Drawable) ObjectWrapper.k0(t4)) == null) {
                        return;
                    }
                    ImageView imageView = new ImageView(context);
                    imageView.setImageDrawable(drawable);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    viewGroup2.addView(imageView);
                } catch (RemoteException unused) {
                    zzbad.i("Could not get drawable from image");
                }
            }
        }
    }
}
