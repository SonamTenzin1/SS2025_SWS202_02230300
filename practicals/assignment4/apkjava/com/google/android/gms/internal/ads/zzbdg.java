package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.TimeUnit;

@zzard
/* loaded from: classes2.dex */
public final class zzbdg {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14373b;

    /* renamed from: c, reason: collision with root package name */
    private final zzbai f14374c;

    /* renamed from: d, reason: collision with root package name */
    private final zzadg f14375d;

    /* renamed from: e, reason: collision with root package name */
    private final zzadi f14376e;

    /* renamed from: g, reason: collision with root package name */
    private final long[] f14378g;

    /* renamed from: h, reason: collision with root package name */
    private final String[] f14379h;
    private boolean m;
    private zzbco n;
    private boolean o;
    private boolean p;

    /* renamed from: f, reason: collision with root package name */
    private final zzayq f14377f = new zzayt().a("min_1", Double.MIN_VALUE, 1.0d).a("1_5", 1.0d, 5.0d).a("5_10", 5.0d, 10.0d).a("10_20", 10.0d, 20.0d).a("20_30", 20.0d, 30.0d).a("30_max", 30.0d, Double.MAX_VALUE).e();

    /* renamed from: i, reason: collision with root package name */
    private boolean f14380i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14381j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14382k = false;
    private boolean l = false;
    private long q = -1;

    public zzbdg(Context context, zzbai zzbaiVar, String str, zzadi zzadiVar, zzadg zzadgVar) {
        this.a = context;
        this.f14374c = zzbaiVar;
        this.f14373b = str;
        this.f14376e = zzadiVar;
        this.f14375d = zzadgVar;
        String str2 = (String) zzyt.e().c(zzacu.I);
        if (str2 == null) {
            this.f14379h = new String[0];
            this.f14378g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f14379h = new String[split.length];
        this.f14378g = new long[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                this.f14378g[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException e2) {
                zzbad.d("Unable to parse frame hash target time number.", e2);
                this.f14378g[i2] = -1;
            }
        }
    }

    public final void a() {
        if (!((Boolean) zzyt.e().c(zzacu.H)).booleanValue() || this.o) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.f14373b);
        bundle.putString("player", this.n.r());
        for (zzays zzaysVar : this.f14377f.c()) {
            String valueOf = String.valueOf(zzaysVar.a);
            bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzaysVar.f14289e));
            String valueOf2 = String.valueOf(zzaysVar.a);
            bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzaysVar.f14288d));
        }
        int i2 = 0;
        while (true) {
            long[] jArr = this.f14378g;
            if (i2 < jArr.length) {
                String str = this.f14379h[i2];
                if (str != null) {
                    String valueOf3 = String.valueOf(Long.valueOf(jArr[i2]));
                    StringBuilder sb = new StringBuilder(valueOf3.length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf3);
                    bundle.putString(sb.toString(), str);
                }
                i2++;
            } else {
                zzk.zzlg().l(this.a, this.f14374c.f14326f, "gmob-apps", bundle, true);
                this.o = true;
                return;
            }
        }
    }

    public final void b(zzbco zzbcoVar) {
        zzadb.a(this.f14376e, this.f14375d, "vpc2");
        this.f14380i = true;
        zzadi zzadiVar = this.f14376e;
        if (zzadiVar != null) {
            zzadiVar.d("vpn", zzbcoVar.r());
        }
        this.n = zzbcoVar;
    }

    public final void c(zzbco zzbcoVar) {
        if (this.f14382k && !this.l) {
            if (zzawz.n() && !this.l) {
                zzawz.m("VideoMetricsMixin first frame");
            }
            zzadb.a(this.f14376e, this.f14375d, "vff2");
            this.l = true;
        }
        long nanoTime = zzk.zzln().nanoTime();
        if (this.m && this.p && this.q != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d2 = nanoTime - this.q;
            Double.isNaN(nanos);
            Double.isNaN(d2);
            this.f14377f.a(nanos / d2);
        }
        this.p = this.m;
        this.q = nanoTime;
        long longValue = ((Long) zzyt.e().c(zzacu.J)).longValue();
        long currentPosition = zzbcoVar.getCurrentPosition();
        int i2 = 0;
        while (true) {
            String[] strArr = this.f14379h;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(currentPosition - this.f14378g[i2])) {
                String[] strArr2 = this.f14379h;
                int i3 = 8;
                Bitmap bitmap = zzbcoVar.getBitmap(8, 8);
                long j2 = 63;
                int i4 = 0;
                long j3 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        j3 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j2);
                        i5++;
                        j2--;
                        i3 = 8;
                    }
                    i4++;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i2++;
        }
    }

    public final void d() {
        if (!this.f14380i || this.f14381j) {
            return;
        }
        zzadb.a(this.f14376e, this.f14375d, "vfr2");
        this.f14381j = true;
    }

    public final void e() {
        this.m = true;
        if (!this.f14381j || this.f14382k) {
            return;
        }
        zzadb.a(this.f14376e, this.f14375d, "vfp2");
        this.f14382k = true;
    }

    public final void f() {
        this.m = false;
    }
}
