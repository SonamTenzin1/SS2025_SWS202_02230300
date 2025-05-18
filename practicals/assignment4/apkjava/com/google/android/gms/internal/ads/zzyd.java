package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzyd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyd> CREATOR = new zzye();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f16987f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f16988g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f16989h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f16990i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f16991j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f16992k;

    @SafeParcelable.Field
    public final zzyd[] l;

    @SafeParcelable.Field
    public final boolean m;

    @SafeParcelable.Field
    public final boolean n;

    @SafeParcelable.Field
    public boolean o;

    public zzyd() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    private static int W(DisplayMetrics displayMetrics) {
        int i2 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i2 <= 400) {
            return 32;
        }
        return i2 <= 720 ? 50 : 90;
    }

    public static zzyd Y(Context context) {
        return new zzyd("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static zzyd e0() {
        return new zzyd("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static int y(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int z(DisplayMetrics displayMetrics) {
        return (int) (W(displayMetrics) * displayMetrics.density);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f16987f, false);
        SafeParcelWriter.l(parcel, 3, this.f16988g);
        SafeParcelWriter.l(parcel, 4, this.f16989h);
        SafeParcelWriter.c(parcel, 5, this.f16990i);
        SafeParcelWriter.l(parcel, 6, this.f16991j);
        SafeParcelWriter.l(parcel, 7, this.f16992k);
        SafeParcelWriter.x(parcel, 8, this.l, i2, false);
        SafeParcelWriter.c(parcel, 9, this.m);
        SafeParcelWriter.c(parcel, 10, this.n);
        SafeParcelWriter.c(parcel, 11, this.o);
        SafeParcelWriter.b(parcel, a);
    }

    public zzyd(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzyd(Context context, AdSize[] adSizeArr) {
        int i2;
        int i3;
        double d2;
        double d3;
        AdSize adSize = adSizeArr[0];
        this.f16990i = false;
        boolean isFluid = adSize.isFluid();
        this.n = isFluid;
        if (isFluid) {
            AdSize adSize2 = AdSize.BANNER;
            this.f16991j = adSize2.getWidth();
            this.f16988g = adSize2.getHeight();
        } else {
            this.f16991j = adSize.getWidth();
            this.f16988g = adSize.getHeight();
        }
        boolean z = this.f16991j == -1;
        boolean z2 = this.f16988g == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            zzyt.a();
            if (zzazt.o(context)) {
                zzyt.a();
                if (zzazt.p(context)) {
                    int i4 = displayMetrics.widthPixels;
                    zzyt.a();
                    this.f16992k = i4 - zzazt.q(context);
                    d2 = this.f16992k / displayMetrics.density;
                    i2 = (int) d2;
                    d3 = i2;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    if (d2 - d3 >= 0.01d) {
                        i2++;
                    }
                }
            }
            this.f16992k = displayMetrics.widthPixels;
            d2 = this.f16992k / displayMetrics.density;
            i2 = (int) d2;
            d3 = i2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 - d3 >= 0.01d) {
            }
        } else {
            i2 = this.f16991j;
            zzyt.a();
            this.f16992k = zzazt.b(displayMetrics, this.f16991j);
        }
        if (z2) {
            i3 = W(displayMetrics);
        } else {
            i3 = this.f16988g;
        }
        zzyt.a();
        this.f16989h = zzazt.b(displayMetrics, i3);
        if (z || z2) {
            StringBuilder sb = new StringBuilder(26);
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            sb.append("_as");
            this.f16987f = sb.toString();
        } else if (isFluid) {
            this.f16987f = "320x50_mb";
        } else {
            this.f16987f = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.l = new zzyd[adSizeArr.length];
            for (int i5 = 0; i5 < adSizeArr.length; i5++) {
                this.l[i5] = new zzyd(context, adSizeArr[i5]);
            }
        } else {
            this.l = null;
        }
        this.m = false;
        this.o = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzyd(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i4, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) zzyd[] zzydVarArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4) {
        this.f16987f = str;
        this.f16988g = i2;
        this.f16989h = i3;
        this.f16990i = z;
        this.f16991j = i4;
        this.f16992k = i5;
        this.l = zzydVarArr;
        this.m = z2;
        this.n = z3;
        this.o = z4;
    }
}
