package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcjm {
    private static final SparseArray<zzwt.zzi.zzc> a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15299b;

    /* renamed from: c, reason: collision with root package name */
    private final zzbbh<Bundle> f15300c;

    /* renamed from: d, reason: collision with root package name */
    private final TelephonyManager f15301d;

    /* renamed from: e, reason: collision with root package name */
    private final zzcji f15302e;

    /* renamed from: f, reason: collision with root package name */
    private final zzcjc f15303f;

    /* renamed from: g, reason: collision with root package name */
    private zzwx f15304g;

    static {
        SparseArray<zzwt.zzi.zzc> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwt.zzi.zzc.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzwt.zzi.zzc zzcVar = zzwt.zzi.zzc.CONNECTING;
        sparseArray.put(ordinal, zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwt.zzi.zzc.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzwt.zzi.zzc zzcVar2 = zzwt.zzi.zzc.DISCONNECTED;
        sparseArray.put(ordinal2, zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwt.zzi.zzc.SUSPENDED);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzcVar);
        }
        if (i2 >= 16) {
            sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjm(Context context, zzbbh<Bundle> zzbbhVar, zzcji zzcjiVar, zzcjc zzcjcVar) {
        this.f15299b = context;
        this.f15300c = zzbbhVar;
        this.f15302e = zzcjiVar;
        this.f15303f = zzcjcVar;
        this.f15301d = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] d(boolean z, ArrayList<zzwt.zza.EnumC0187zza> arrayList, zzwt.zzg zzgVar, zzwt.zzi.zzc zzcVar) {
        return ((zzwt.zzi.zza) ((zzdob) zzwt.zzi.zza.W().w(arrayList).G(e(zzk.zzli().o(this.f15299b.getContentResolver()) != 0)).H(zzk.zzli().h(this.f15299b, this.f15301d)).C(this.f15302e.b()).D(this.f15302e.d()).A(this.f15302e.a()).v(zzcVar).u(zzgVar).I(this.f15304g).E(e(z)).B(zzk.zzln().a()).F(e(zzk.zzli().d(this.f15299b.getContentResolver()) != 0)).p0())).g();
    }

    private static zzwx e(boolean z) {
        return z ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzwt.zzg i(Bundle bundle) {
        zzwt.zzg.zzb zzbVar;
        zzwt.zzg.zza B = zzwt.zzg.B();
        int i2 = bundle.getInt("cnt", -2);
        int i3 = bundle.getInt("gnt", 0);
        if (i2 == -1) {
            this.f15304g = zzwx.ENUM_TRUE;
        } else {
            this.f15304g = zzwx.ENUM_FALSE;
            if (i2 == 0) {
                B.v(zzwt.zzg.zzc.CELL);
            } else if (i2 != 1) {
                B.v(zzwt.zzg.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                B.v(zzwt.zzg.zzc.WIFI);
            }
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzwt.zzg.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzwt.zzg.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzwt.zzg.zzb.LTE;
                    break;
                default:
                    zzbVar = zzwt.zzg.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            B.u(zzbVar);
        }
        return (zzwt.zzg) ((zzdob) B.p0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzwt.zzi.zzc j(Bundle bundle) {
        return a.get(zzcxz.a(zzcxz.a(bundle, "device"), "network").getInt("active_network_state", -1), zzwt.zzi.zzc.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<zzwt.zza.EnumC0187zza> k(Bundle bundle) {
        List<String> emptyList;
        List asList;
        zzwt.zza.EnumC0187zza enumC0187zza;
        Object obj = bundle.get("ad_types");
        if (obj instanceof List) {
            asList = (List) obj;
        } else if (obj instanceof String[]) {
            asList = Arrays.asList((String[]) obj);
        } else {
            emptyList = Collections.emptyList();
            ArrayList<zzwt.zza.EnumC0187zza> arrayList = new ArrayList<>();
            for (String str : emptyList) {
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                enumC0187zza = zzwt.zza.EnumC0187zza.BANNER;
                                break;
                            case 1:
                                enumC0187zza = zzwt.zza.EnumC0187zza.NATIVE_APP_INSTALL;
                                break;
                            case 2:
                                enumC0187zza = zzwt.zza.EnumC0187zza.REWARD_BASED_VIDEO_AD;
                                break;
                            case 3:
                                enumC0187zza = zzwt.zza.EnumC0187zza.INTERSTITIAL;
                                break;
                            default:
                                enumC0187zza = zzwt.zza.EnumC0187zza.AD_FORMAT_TYPE_UNSPECIFIED;
                                break;
                        }
                        arrayList.add(enumC0187zza);
                    case -1052618729:
                        if (str.equals("native")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        arrayList.add(enumC0187zza);
                        break;
                    case -239580146:
                        if (str.equals("rewarded")) {
                            c2 = 2;
                        }
                        switch (c2) {
                        }
                        arrayList.add(enumC0187zza);
                        break;
                    case 604727084:
                        if (str.equals("interstitial")) {
                            c2 = 3;
                        }
                        switch (c2) {
                        }
                        arrayList.add(enumC0187zza);
                        break;
                    default:
                        switch (c2) {
                        }
                        arrayList.add(enumC0187zza);
                        break;
                }
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(asList.size());
        for (Object obj2 : asList) {
            if (obj2 instanceof String) {
                arrayList2.add((String) obj2);
            }
        }
        emptyList = Collections.unmodifiableList(arrayList2);
        ArrayList<zzwt.zza.EnumC0187zza> arrayList3 = new ArrayList<>();
        while (r4.hasNext()) {
        }
        return arrayList3;
    }

    public final void g(boolean z) {
        zzbar.f(this.f15300c, new zj(this, z), zzbbm.f14331b);
    }
}
