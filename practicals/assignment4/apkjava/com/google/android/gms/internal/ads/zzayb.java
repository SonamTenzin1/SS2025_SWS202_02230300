package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzayb {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private String f14264b;

    /* renamed from: c, reason: collision with root package name */
    private String f14265c;

    /* renamed from: d, reason: collision with root package name */
    private String f14266d;

    /* renamed from: e, reason: collision with root package name */
    private String f14267e;

    /* renamed from: f, reason: collision with root package name */
    private int f14268f;

    /* renamed from: g, reason: collision with root package name */
    private int f14269g;

    /* renamed from: h, reason: collision with root package name */
    private PointF f14270h;

    /* renamed from: i, reason: collision with root package name */
    private PointF f14271i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f14272j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f14273k;

    public zzayb(Context context) {
        this.f14268f = 0;
        this.f14273k = new Runnable(this) { // from class: com.google.android.gms.internal.ads.m5

            /* renamed from: f, reason: collision with root package name */
            private final zzayb f12963f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12963f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12963f.m();
            }
        };
        this.a = context;
        this.f14269g = ViewConfiguration.get(context).getScaledTouchSlop();
        zzk.zzlu().b();
        this.f14272j = zzk.zzlu().a();
    }

    private static int c(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    private final boolean f(float f2, float f3, float f4, float f5) {
        return Math.abs(this.f14270h.x - f2) < ((float) this.f14269g) && Math.abs(this.f14270h.y - f3) < ((float) this.f14269g) && Math.abs(this.f14271i.x - f4) < ((float) this.f14269g) && Math.abs(this.f14271i.y - f5) < ((float) this.f14269g);
    }

    public final void a(String str) {
        this.f14265c = str;
    }

    public final void b() {
        try {
            if (!(this.a instanceof Activity)) {
                zzbad.h("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzk.zzlq().l()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzk.zzlq().m() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int c2 = c(arrayList, "Ad Information", true);
            final int c3 = c(arrayList, str, true);
            final int c4 = c(arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a, zzk.zzli().v());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, c2, c3, c4) { // from class: com.google.android.gms.internal.ads.n5

                /* renamed from: f, reason: collision with root package name */
                private final zzayb f13022f;

                /* renamed from: g, reason: collision with root package name */
                private final int f13023g;

                /* renamed from: h, reason: collision with root package name */
                private final int f13024h;

                /* renamed from: i, reason: collision with root package name */
                private final int f13025i;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13022f = this;
                    this.f13023g = c2;
                    this.f13024h = c3;
                    this.f13025i = c4;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f13022f.d(this.f13023g, this.f13024h, this.f13025i, dialogInterface, i2);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e2) {
            zzawz.l(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void d(int i2, int i3, int i4, DialogInterface dialogInterface, int i5) {
        final String str;
        if (i5 != i2) {
            if (i5 == i3) {
                zzbad.e("Debug mode [Creative Preview] selected.");
                zzaxg.b(new Runnable(this) { // from class: com.google.android.gms.internal.ads.q5

                    /* renamed from: f, reason: collision with root package name */
                    private final zzayb f13219f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f13219f = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13219f.l();
                    }
                });
                return;
            } else {
                if (i5 == i4) {
                    zzbad.e("Debug mode [Troubleshooting] selected.");
                    zzaxg.b(new Runnable(this) { // from class: com.google.android.gms.internal.ads.r5

                        /* renamed from: f, reason: collision with root package name */
                        private final zzayb f13261f;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f13261f = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f13261f.k();
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (!(this.a instanceof Activity)) {
            zzbad.h("Can not create dialog without Activity Context");
            return;
        }
        String str2 = this.f14264b;
        if (!TextUtils.isEmpty(str2)) {
            Uri build = new Uri.Builder().encodedQuery(str2.replaceAll("\\+", "%20")).build();
            StringBuilder sb = new StringBuilder();
            zzk.zzlg();
            Map<String, String> X = zzaxi.X(build);
            for (String str3 : X.keySet()) {
                sb.append(str3);
                sb.append(" = ");
                sb.append(X.get(str3));
                sb.append("\n\n");
            }
            str = sb.toString().trim();
        }
        str = "No debug information";
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage(str);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener(this, str) { // from class: com.google.android.gms.internal.ads.o5

            /* renamed from: f, reason: collision with root package name */
            private final zzayb f13086f;

            /* renamed from: g, reason: collision with root package name */
            private final String f13087g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13086f = this;
                this.f13087g = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i6) {
                this.f13086f.e(this.f13087g, dialogInterface2, i6);
            }
        });
        builder.setNegativeButton("Close", p5.f13150f);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(String str, DialogInterface dialogInterface, int i2) {
        zzk.zzlg();
        zzaxi.i(this.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        boolean z = false;
        if (actionMasked == 0) {
            this.f14268f = 0;
            this.f14270h = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i2 = this.f14268f;
        if (i2 == -1) {
            return;
        }
        if (i2 == 0 && actionMasked == 5) {
            this.f14268f = 5;
            this.f14271i = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.f14272j.postDelayed(this.f14273k, ((Long) zzyt.e().c(zzacu.H3)).longValue());
            return;
        }
        if (i2 != 5) {
            return;
        }
        if (pointerCount == 2) {
            if (actionMasked == 2) {
                boolean z2 = false;
                for (int i3 = 0; i3 < historySize; i3++) {
                    if (!f(motionEvent.getHistoricalX(0, i3), motionEvent.getHistoricalY(0, i3), motionEvent.getHistoricalX(1, i3), motionEvent.getHistoricalY(1, i3))) {
                        z2 = true;
                    }
                }
                if (f(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                    z = z2;
                }
            }
            if (z) {
                return;
            }
            this.f14268f = -1;
            this.f14272j.removeCallbacks(this.f14273k);
            return;
        }
        z = true;
        if (z) {
        }
    }

    public final void h(String str) {
        this.f14264b = str;
    }

    public final void i(String str) {
        this.f14267e = str;
    }

    public final void j(String str) {
        this.f14266d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k() {
        zzk.zzlq().a(this.a, this.f14265c, this.f14266d, this.f14267e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void l() {
        zzk.zzlq().g(this.a, this.f14265c, this.f14266d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m() {
        this.f14268f = 4;
        b();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.f14264b);
        sb.append(",DebugSignal: ");
        sb.append(this.f14267e);
        sb.append(",AFMA Version: ");
        sb.append(this.f14266d);
        sb.append(",Ad Unit ID: ");
        sb.append(this.f14265c);
        sb.append("}");
        return sb.toString();
    }

    public zzayb(Context context, String str) {
        this(context);
        this.f14264b = str;
    }
}
