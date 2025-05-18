package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@zzard
/* loaded from: classes2.dex */
public final class zzbcq extends FrameLayout implements zzbcn {

    /* renamed from: f, reason: collision with root package name */
    private final zzbdf f14347f;

    /* renamed from: g, reason: collision with root package name */
    private final FrameLayout f14348g;

    /* renamed from: h, reason: collision with root package name */
    private final zzadi f14349h;

    /* renamed from: i, reason: collision with root package name */
    private final f8 f14350i;

    /* renamed from: j, reason: collision with root package name */
    private final long f14351j;

    /* renamed from: k, reason: collision with root package name */
    private zzbco f14352k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private long p;
    private long q;
    private String r;
    private String[] s;
    private Bitmap t;
    private ImageView u;
    private boolean v;

    public zzbcq(Context context, zzbdf zzbdfVar, int i2, boolean z, zzadi zzadiVar, zzbde zzbdeVar) {
        super(context);
        this.f14347f = zzbdfVar;
        this.f14349h = zzadiVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f14348g = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.k(zzbdfVar.c());
        zzbco a = zzbdfVar.c().zzbqs.a(context, zzbdfVar, i2, z, zzadiVar, zzbdeVar);
        this.f14352k = a;
        if (a != null) {
            frameLayout.addView(a, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzyt.e().c(zzacu.K)).booleanValue()) {
                F();
            }
        }
        this.u = new ImageView(context);
        this.f14351j = ((Long) zzyt.e().c(zzacu.O)).longValue();
        boolean booleanValue = ((Boolean) zzyt.e().c(zzacu.M)).booleanValue();
        this.o = booleanValue;
        if (zzadiVar != null) {
            zzadiVar.d("spinner_used", booleanValue ? "1" : "0");
        }
        this.f14350i = new f8(this);
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar != null) {
            zzbcoVar.k(this);
        }
        if (this.f14352k == null) {
            b("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private final boolean H() {
        return this.u.getParent() != null;
    }

    private final void I() {
        if (this.f14347f.a() == null || !this.m || this.n) {
            return;
        }
        this.f14347f.a().getWindow().clearFlags(128);
        this.m = false;
    }

    public static void p(zzbdf zzbdfVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbdfVar.y("onVideoEvent", hashMap);
    }

    public static void q(zzbdf zzbdfVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdfVar.y("onVideoEvent", hashMap);
    }

    public static void s(zzbdf zzbdfVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbdfVar.y("onVideoEvent", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.f14347f.y("onVideoEvent", hashMap);
    }

    public final void A(int i2) {
        this.f14352k.q(i2);
    }

    @TargetApi(14)
    public final void B(MotionEvent motionEvent) {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.dispatchTouchEvent(motionEvent);
    }

    public final void C() {
        if (this.f14352k == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.r)) {
            this.f14352k.l(this.r, this.s);
        } else {
            x("no_src", new String[0]);
        }
    }

    public final void D() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.f14346g.b(true);
        zzbcoVar.b();
    }

    public final void E() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.f14346g.b(false);
        zzbcoVar.b();
    }

    @TargetApi(14)
    public final void F() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        TextView textView = new TextView(zzbcoVar.getContext());
        String valueOf = String.valueOf(this.f14352k.r());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.f14348g.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.f14348g.bringChildToFront(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        long currentPosition = zzbcoVar.getCurrentPosition();
        if (this.p == currentPosition || currentPosition <= 0) {
            return;
        }
        x("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.p = currentPosition;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void a() {
        if (this.f14352k != null && this.q == 0) {
            x("canplaythrough", "duration", String.valueOf(r0.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.f14352k.getVideoWidth()), "videoHeight", String.valueOf(this.f14352k.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void b(String str, String str2) {
        x("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void c() {
        this.f14350i.b();
        zzaxi.a.post(new y7(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void d(int i2, int i3) {
        if (this.o) {
            zzacj<Integer> zzacjVar = zzacu.N;
            int max = Math.max(i2 / ((Integer) zzyt.e().c(zzacjVar)).intValue(), 1);
            int max2 = Math.max(i3 / ((Integer) zzyt.e().c(zzacjVar)).intValue(), 1);
            Bitmap bitmap = this.t;
            if (bitmap != null && bitmap.getWidth() == max && this.t.getHeight() == max2) {
                return;
            }
            this.t = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.v = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void e() {
        x("pause", new String[0]);
        I();
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void f() {
        if (this.l && H()) {
            this.f14348g.removeView(this.u);
        }
        if (this.t != null) {
            long b2 = zzk.zzln().b();
            if (this.f14352k.getBitmap(this.t) != null) {
                this.v = true;
            }
            long b3 = zzk.zzln().b() - b2;
            if (zzawz.n()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(b3);
                sb.append("ms");
                zzawz.m(sb.toString());
            }
            if (b3 > this.f14351j) {
                zzbad.i("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.o = false;
                this.t = null;
                zzadi zzadiVar = this.f14349h;
                if (zzadiVar != null) {
                    zzadiVar.d("spinner_jank", Long.toString(b3));
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            this.f14350i.a();
            zzbco zzbcoVar = this.f14352k;
            if (zzbcoVar != null) {
                Executor executor = zzbbm.a;
                zzbcoVar.getClass();
                executor.execute(w7.a(zzbcoVar));
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void g() {
        if (this.v && this.t != null && !H()) {
            this.u.setImageBitmap(this.t);
            this.u.invalidate();
            this.f14348g.addView(this.u, new FrameLayout.LayoutParams(-1, -1));
            this.f14348g.bringChildToFront(this.u);
        }
        this.f14350i.a();
        this.q = this.p;
        zzaxi.a.post(new z7(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void h() {
        x("ended", new String[0]);
        I();
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void i() {
        if (this.f14347f.a() != null && !this.m) {
            boolean z = (this.f14347f.a().getWindow().getAttributes().flags & 128) != 0;
            this.n = z;
            if (!z) {
                this.f14347f.a().getWindow().addFlags(128);
                this.m = true;
            }
        }
        this.l = true;
    }

    public final void j() {
        this.f14350i.a();
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar != null) {
            zzbcoVar.i();
        }
        I();
    }

    public final void k() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.c();
    }

    public final void l() {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.d();
    }

    public final void m(int i2) {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.h(i2);
    }

    public final void n(float f2, float f3) {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar != null) {
            zzbcoVar.j(f2, f3);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f14350i.b();
        } else {
            this.f14350i.a();
            this.q = this.p;
        }
        zzaxi.a.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.x7

            /* renamed from: f, reason: collision with root package name */
            private final zzbcq f13563f;

            /* renamed from: g, reason: collision with root package name */
            private final boolean f13564g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13563f = this;
                this.f13564g = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13563f.r(this.f13564g);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbcn
    public final void onWindowVisibilityChanged(int i2) {
        boolean z;
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            this.f14350i.b();
            z = true;
        } else {
            this.f14350i.a();
            this.q = this.p;
            z = false;
        }
        zzaxi.a.post(new a8(this, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r(boolean z) {
        x("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void setVolume(float f2) {
        zzbco zzbcoVar = this.f14352k;
        if (zzbcoVar == null) {
            return;
        }
        zzbcoVar.f14346g.c(f2);
        zzbcoVar.b();
    }

    public final void t(String str, String[] strArr) {
        this.r = str;
        this.s = strArr;
    }

    public final void u(int i2) {
        this.f14352k.m(i2);
    }

    public final void v(int i2) {
        this.f14352k.n(i2);
    }

    public final void w(int i2, int i3, int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.setMargins(i2, i3, 0, 0);
        this.f14348g.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void y(int i2) {
        this.f14352k.o(i2);
    }

    public final void z(int i2) {
        this.f14352k.p(i2);
    }
}
