package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzctp implements zzcva<zzcto> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcxv f15618b;

    /* renamed from: c, reason: collision with root package name */
    private final PackageInfo f15619c;

    /* renamed from: d, reason: collision with root package name */
    private final zzaxb f15620d;

    public zzctp(zzbbl zzbblVar, zzcxv zzcxvVar, PackageInfo packageInfo, zzaxb zzaxbVar) {
        this.a = zzbblVar;
        this.f15618b = zzcxvVar;
        this.f15619c = packageInfo;
        this.f15620d = zzaxbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ArrayList arrayList, Bundle bundle) {
        JSONArray optJSONArray;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.f15618b.f15754h);
        String str = "landscape";
        if (((Boolean) zzyt.e().c(zzacu.N2)).booleanValue() && this.f15618b.f15755i.f13845f > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i2 = this.f15618b.f15755i.m;
            String str2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "square" : "portrait" : "landscape" : "any";
            if (!"unknown".equals(str2)) {
                bundle.putString("native_media_orientation", str2);
            }
        }
        int i3 = this.f15618b.f15755i.f13847h;
        if (i3 == 0) {
            str = "any";
        } else if (i3 == 1) {
            str = "portrait";
        } else if (i3 != 2) {
            str = "unknown";
        }
        if (!"unknown".equals(str)) {
            bundle.putString("native_image_orientation", str);
        }
        bundle.putBoolean("native_multiple_images", this.f15618b.f15755i.f13848i);
        bundle.putBoolean("use_custom_mute", this.f15618b.f15755i.l);
        PackageInfo packageInfo = this.f15619c;
        int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i4 > this.f15620d.s()) {
            this.f15620d.y();
            this.f15620d.e(i4);
        }
        JSONObject a = this.f15620d.a();
        String jSONArray = (a == null || (optJSONArray = a.optJSONArray(this.f15618b.f15752f)) == null) ? null : optJSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray)) {
            bundle.putString("native_advanced_settings", jSONArray);
        }
        int i5 = this.f15618b.l;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzaiy zzaiyVar = this.f15618b.f15749c;
        if (zzaiyVar != null) {
            int i6 = zzaiyVar.f13921f;
            String str3 = "l";
            if (i6 != 1) {
                if (i6 != 2) {
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Instream ad video aspect ratio ");
                    sb.append(i6);
                    sb.append(" is wrong.");
                    zzbad.g(sb.toString());
                } else {
                    str3 = "p";
                }
            }
            bundle.putString("ia_var", str3);
            bundle.putBoolean("instr", true);
        }
        if (this.f15618b.a() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcto> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ko

            /* renamed from: f, reason: collision with root package name */
            private final zzctp f12893f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12893f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12893f.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcto c() throws Exception {
        final ArrayList<String> arrayList = this.f15618b.f15753g;
        if (arrayList == null) {
            return lo.a;
        }
        if (arrayList.isEmpty()) {
            return mo.a;
        }
        return new zzcto(this, arrayList) { // from class: com.google.android.gms.internal.ads.no
            private final zzctp a;

            /* renamed from: b, reason: collision with root package name */
            private final ArrayList f13062b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13062b = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Bundle bundle) {
                this.a.a(this.f13062b, bundle);
            }
        };
    }
}
