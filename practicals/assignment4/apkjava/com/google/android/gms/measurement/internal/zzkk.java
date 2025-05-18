package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzn;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzkk extends q4 {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f18229c = {"firebase_", "google_", "ga_"};

    /* renamed from: d, reason: collision with root package name */
    private SecureRandom f18230d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f18231e;

    /* renamed from: f, reason: collision with root package name */
    private int f18232f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f18233g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18233g = null;
        this.f18231e = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest A0() {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static Bundle B(List<zzkj> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkj zzkjVar : list) {
            String str = zzkjVar.f18228k;
            if (str != null) {
                bundle.putString(zzkjVar.f18224g, str);
            } else {
                Long l = zzkjVar.f18226i;
                if (l != null) {
                    bundle.putLong(zzkjVar.f18224g, l.longValue());
                } else {
                    Double d2 = zzkjVar.m;
                    if (d2 != null) {
                        bundle.putDouble(zzkjVar.f18224g, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    private static Object D(int i2, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return F(String.valueOf(obj), i2, z);
        }
        return null;
    }

    public static String F(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i2) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
        }
        return null;
    }

    private static void K(Bundle bundle, Object obj) {
        Preconditions.k(bundle);
        if (obj != null) {
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                bundle.putLong("_el", String.valueOf(obj).length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean U(Context context, boolean z) {
        Preconditions.k(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return m0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return m0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean V(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    private static boolean W(Bundle bundle, int i2) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean X(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Y(String str) {
        Preconditions.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final boolean c0(String str, String str2, int i2, Object obj, boolean z) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if ((obj instanceof Bundle) && z) {
                    return true;
                }
                if ((obj instanceof Parcelable[]) && z) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            h().M().c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
                if (!(obj instanceof ArrayList) || !z) {
                    return false;
                }
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (!(obj2 instanceof Bundle)) {
                        h().M().c("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                h().M().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f0(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] g0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] h0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static Bundle k0(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static ArrayList<Bundle> l0(List<zzv> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzv zzvVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, zzvVar.f18240f);
            bundle.putString("origin", zzvVar.f18241g);
            bundle.putLong("creation_timestamp", zzvVar.f18243i);
            bundle.putString("name", zzvVar.f18242h.f18224g);
            zzgt.b(bundle, zzvVar.f18242h.y());
            bundle.putBoolean("active", zzvVar.f18244j);
            String str = zzvVar.f18245k;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzan zzanVar = zzvVar.l;
            if (zzanVar != null) {
                bundle.putString("timed_out_event_name", zzanVar.f18067f);
                zzam zzamVar = zzvVar.l.f18068g;
                if (zzamVar != null) {
                    bundle.putBundle("timed_out_event_params", zzamVar.Y());
                }
            }
            bundle.putLong("trigger_timeout", zzvVar.m);
            zzan zzanVar2 = zzvVar.n;
            if (zzanVar2 != null) {
                bundle.putString("triggered_event_name", zzanVar2.f18067f);
                zzam zzamVar2 = zzvVar.n.f18068g;
                if (zzamVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzamVar2.Y());
                }
            }
            bundle.putLong("triggered_timestamp", zzvVar.f18242h.f18225h);
            bundle.putLong("time_to_live", zzvVar.o);
            zzan zzanVar3 = zzvVar.p;
            if (zzanVar3 != null) {
                bundle.putString("expired_event_name", zzanVar3.f18067f);
                zzam zzamVar3 = zzvVar.p.f18068g;
                if (zzamVar3 != null) {
                    bundle.putBundle("expired_event_params", zzamVar3.Y());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static boolean m0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    private final boolean q0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e2 = Wrappers.a(context).e(str, 64);
            if (e2 == null || (signatureArr = e2.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e3) {
            h().H().b("Package name not found", e3);
            return true;
        } catch (CertificateException e4) {
            h().H().b("Error obtaining certificate", e4);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static long v(long j2, long j3) {
        return (j2 + (j3 * 60000)) / PullingContentService.UPDATES_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static long x(byte[] bArr) {
        Preconditions.k(bArr);
        int i2 = 0;
        Preconditions.n(bArr.length > 0);
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j2 += (bArr[length] & 255) << i2;
            i2 += 8;
        }
        return j2;
    }

    @VisibleForTesting
    private static boolean x0(String str) {
        Preconditions.k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static int y0(String str) {
        return "_ldl".equals(str) ? RecyclerView.l.FLAG_MOVED : "_id".equals(str) ? 256 : 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0065, code lost:
    
        if (a0("event param", 40, r15) == false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle A(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Set<String> keySet;
        int i2;
        String str3;
        int i3;
        boolean c0;
        int i4;
        int size;
        boolean z3;
        String[] strArr = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        if (n().B(str, zzap.u0)) {
            keySet = new TreeSet<>(bundle.keySet());
        } else {
            keySet = bundle.keySet();
        }
        Iterator<String> it = keySet.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (list == null || !list.contains(next)) {
                int i6 = 14;
                if (z) {
                    if (b0("event param", next)) {
                        if (!e0("event param", strArr, next)) {
                            i2 = 14;
                            if (i2 == 0) {
                                if (n0("event param", next)) {
                                    if (e0("event param", strArr, next)) {
                                        if (a0("event param", 40, next)) {
                                            i6 = 0;
                                        }
                                    }
                                    i2 = i6;
                                }
                                i6 = 3;
                                i2 = i6;
                            }
                        }
                    }
                    i2 = 3;
                    if (i2 == 0) {
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                }
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                if (W(bundle2, i2)) {
                    bundle2.putString("_ev", F(next, 40, true));
                    if (i2 == 3) {
                        K(bundle2, next);
                    }
                }
                bundle2.remove(next);
            } else {
                Object obj = bundle.get(next);
                d();
                if (z2) {
                    if (obj instanceof Parcelable[]) {
                        size = ((Parcelable[]) obj).length;
                    } else {
                        if (obj instanceof ArrayList) {
                            size = ((ArrayList) obj).size();
                        }
                        z3 = true;
                        if (!z3) {
                            i4 = 17;
                            str3 = "_ev";
                            i3 = 40;
                            if (i4 == 0 && !str3.equals(next)) {
                                if (W(bundle2, i4)) {
                                    bundle2.putString(str3, F(next, i3, true));
                                    K(bundle2, bundle.get(next));
                                }
                                bundle2.remove(next);
                            } else if (!Y(next) && (i5 = i5 + 1) > 25) {
                                StringBuilder sb = new StringBuilder(48);
                                sb.append("Event can't contain more than 25 params");
                                h().J().c(sb.toString(), k().y(str2), k().u(bundle));
                                W(bundle2, 5);
                                bundle2.remove(next);
                            }
                        }
                    }
                    if (size > 1000) {
                        h().M().d("Parameter array is too long; discarded. Value kind, name, array length", "param", next, Integer.valueOf(size));
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z3 = true;
                    if (!z3) {
                    }
                }
                if ((n().D(str) && u0(str2)) || u0(next)) {
                    str3 = "_ev";
                    i3 = 40;
                    c0 = c0("param", next, 256, obj, z2);
                } else {
                    str3 = "_ev";
                    i3 = 40;
                    c0 = c0("param", next, 100, obj, z2);
                }
                i4 = c0 ? 0 : 4;
                if (i4 == 0) {
                }
                if (!Y(next)) {
                }
            }
            strArr = null;
        }
        return bundle2;
    }

    public final int B0() {
        if (this.f18233g == null) {
            this.f18233g = Integer.valueOf(GoogleApiAvailabilityLight.h().b(f()) / 1000);
        }
        return this.f18233g.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzan C(String str, String str2, Bundle bundle, String str3, long j2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (i0(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            return new zzan(str2, new zzam(z(A(str, str2, bundle2, CollectionUtils.b("_o"), false, false))), str3, j2);
        }
        h().H().b("Invalid conditional property event name", k().B(str2));
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String C0() {
        byte[] bArr = new byte[16];
        z0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final boolean D0() {
        try {
            f().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object E(String str, Object obj) {
        if ("_ev".equals(str)) {
            return D(256, obj, true);
        }
        return D(u0(str) ? 256 : 100, obj, false);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final URL H(long j2, String str, String str2, long j3) {
        try {
            Preconditions.g(str2);
            Preconditions.g(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j2), Integer.valueOf(B0())), str2, str, Long.valueOf(j3));
            if (str.equals(n().W())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            h().H().b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final void I(int i2, String str, String str2, int i3) {
        T(null, i2, str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void J(Bundle bundle, long j2) {
        long j3 = bundle.getLong("_et");
        if (j3 != 0) {
            h().K().b("Params already contained engagement", Long.valueOf(j3));
        }
        bundle.putLong("_et", j2 + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (str != null) {
            h().M().c("Not putting event parameter. Invalid value type. name, type", k().A(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void M(zzn zznVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning int value to wrapper", e2);
        }
    }

    public final void N(zzn zznVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j2);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning long value to wrapper", e2);
        }
    }

    public final void O(zzn zznVar, Bundle bundle) {
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void P(zzn zznVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning string value to wrapper", e2);
        }
    }

    public final void Q(zzn zznVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning bundle list to wrapper", e2);
        }
    }

    public final void R(zzn zznVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void S(zzn zznVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.a.h().K().b("Error returning byte array to wrapper", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        W(bundle, i2);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", i3);
        }
        this.a.G();
        this.a.H().S("auto", "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    public final boolean Z(String str, double d2) {
        try {
            SharedPreferences.Editor edit = f().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString(DeepLinkIntentReceiver.DEEP_LINK, str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            h().H().b("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a0(String str, int i2, String str2) {
        if (str2 == null) {
            h().J().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i2) {
            return true;
        }
        h().J().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b0(String str, String str2) {
        if (str2 == null) {
            h().J().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            h().J().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            h().J().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                h().J().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e0(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            h().J().b("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.k(str2);
        String[] strArr2 = f18229c;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (str2.startsWith(strArr2[i2])) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            h().J().c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.k(strArr);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z2 = false;
                    break;
                }
                if (t0(str2, strArr[i3])) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                h().J().c("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i0(String str) {
        if (!n0("event", str)) {
            return 2;
        }
        if (e0("event", zzgw.a, str)) {
            return !a0("event", 40, str) ? 2 : 0;
        }
        return 13;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int j0(String str, Object obj) {
        boolean c0;
        if ("_ldl".equals(str)) {
            c0 = c0("user property referrer", str, y0(str), obj, false);
        } else {
            c0 = c0("user property", str, y0(str), obj, false);
        }
        return c0 ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n0(String str, String str2) {
        if (str2 == null) {
            h().J().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            h().J().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            h().J().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                h().J().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final void o() {
        d();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                h().K().a("Utils falling back to Random for random id");
            }
        }
        this.f18231e.set(nextLong);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int o0(String str) {
        if (!n0("user property", str)) {
            return 6;
        }
        if (e0("user property", zzgy.a, str)) {
            return !a0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object p0(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return D(y0(str), obj, true);
        }
        return D(y0(str), obj, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (x0(str)) {
                return true;
            }
            if (this.a.L()) {
                h().J().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzet.x(str));
            }
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (x0(str2)) {
                return true;
            }
            h().J().b("Invalid admob_app_id. Analytics disabled.", zzet.x(str2));
            return false;
        }
        if (this.a.L()) {
            h().J().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s0(String str) {
        d();
        if (Wrappers.a(f()).a(str) == 0) {
            return true;
        }
        h().O().b("Permission not granted", str);
        return false;
    }

    public final int u(int i2) {
        return GoogleApiAvailabilityLight.h().j(f(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String V = n().V();
        G();
        return V.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0065 -> B:7:0x0072). Please report as a decompilation issue!!! */
    public final long w(Context context, String str) {
        d();
        Preconditions.k(context);
        Preconditions.g(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest A0 = A0();
        long j2 = -1;
        if (A0 == null) {
            h().H().a("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    h().H().b("Package name not found", e2);
                }
                if (!q0(context, str)) {
                    Signature[] signatureArr = Wrappers.a(context).e(f().getPackageName(), 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        j2 = x(A0.digest(signatureArr[0].toByteArray()));
                    } else {
                        h().K().a("Could not get signatures");
                    }
                }
            }
            j2 = 0;
        }
        return j2;
    }

    public final long w0() {
        long andIncrement;
        long j2;
        if (this.f18231e.get() == 0) {
            synchronized (this.f18231e) {
                long nextLong = new Random(System.nanoTime() ^ j().a()).nextLong();
                int i2 = this.f18232f + 1;
                this.f18232f = i2;
                j2 = nextLong + i2;
            }
            return j2;
        }
        synchronized (this.f18231e) {
            this.f18231e.compareAndSet(-1L, 1L);
            andIncrement = this.f18231e.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle y(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            h().K().b("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle z(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object E = E(str, bundle.get(str));
                if (E == null) {
                    h().M().b("Param value can't be null", k().A(str));
                } else {
                    L(bundle2, str, E);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom z0() {
        d();
        if (this.f18230d == null) {
            this.f18230d = new SecureRandom();
        }
        return this.f18230d;
    }
}
