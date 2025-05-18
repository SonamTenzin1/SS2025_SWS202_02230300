package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.file.CacheHelper;
import com.google.android.gms.ads.AdRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzpi {

    /* renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f16583d;

    /* renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f16584e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f16585f;
    private static final zzpd a = zzpd.g("OMX.google.raw.decoder");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f16581b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<a, List<zzpd>> f16582c = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static int f16586g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16587b;

        public a(String str, boolean z) {
            this.a = str;
            this.f16587b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && this.f16587b == aVar.f16587b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f16587b ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16583d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16584e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, AdRequest.MAX_CONTENT_URL_LENGTH);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, RecyclerView.l.FLAG_MOVED);
        sparseIntArray2.put(41, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, Http2.INITIAL_MAX_FRAME_SIZE);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f16585f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", Integer.valueOf(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
        hashMap.put("L150", Integer.valueOf(Http2.INITIAL_MAX_FRAME_SIZE));
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", Integer.valueOf(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES));
        hashMap.put("L183", 4194304);
        hashMap.put("L186", Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE));
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        hashMap.put("H120", Integer.valueOf(RecyclerView.l.FLAG_MOVED));
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            String valueOf2 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf3;
            } else {
                String valueOf4 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf4) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf5 = Integer.valueOf(f16583d.get(num.intValue()));
            if (valueOf5 == null) {
                String valueOf6 = String.valueOf(num);
                StringBuilder sb = new StringBuilder(valueOf6.length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf6);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf7 = Integer.valueOf(f16584e.get(valueOf.intValue()));
            if (valueOf7 == null) {
                String valueOf8 = String.valueOf(valueOf);
                StringBuilder sb2 = new StringBuilder(valueOf8.length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf8);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf5, valueOf7);
        } catch (NumberFormatException unused) {
            String valueOf9 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf9) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzpk.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.p20):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0126, code lost:
    
        if ("C1605".equals(r14) == false) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0182 A[Catch: Exception -> 0x0278, TryCatch #2 {Exception -> 0x0278, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:29:0x006c, B:33:0x0078, B:35:0x0080, B:40:0x0090, B:42:0x0098, B:44:0x00a2, B:46:0x00aa, B:48:0x00b2, B:50:0x00ba, B:52:0x00c2, B:54:0x00ca, B:56:0x00d2, B:58:0x00da, B:60:0x00e2, B:62:0x00ea, B:64:0x00f2, B:68:0x00fe, B:70:0x0106, B:72:0x0110, B:74:0x0118, B:76:0x0120, B:80:0x012f, B:82:0x0137, B:84:0x0141, B:86:0x014b, B:88:0x0153, B:90:0x0159, B:92:0x0161, B:96:0x016c, B:98:0x0174, B:103:0x0182, B:105:0x018a, B:138:0x0200, B:141:0x0208, B:143:0x020e, B:146:0x0232, B:147:0x0262), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cb A[Catch: Exception -> 0x01c6, TryCatch #3 {Exception -> 0x01c6, blocks: (B:153:0x01a2, B:155:0x01ac, B:157:0x01b4, B:159:0x01bc, B:116:0x01cb, B:120:0x01d9, B:123:0x01d4, B:129:0x01e7), top: B:152:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x026d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzpd> b(com.google.android.gms.internal.ads.zzpi.a r17, com.google.android.gms.internal.ads.q20 r18) throws com.google.android.gms.internal.ads.zzpk {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.b(com.google.android.gms.internal.ads.zzpi$a, com.google.android.gms.internal.ads.q20):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0044, code lost:
    
        if (r3.equals("avc1") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> c(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        char c2 = 0;
        String str2 = split[0];
        str2.hashCode();
        int i2 = 2;
        switch (str2.hashCode()) {
            case 3006243:
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3199032:
                if (str2.equals("hev1")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return a(str, split);
            case 2:
            case 3:
                if (split.length < 4) {
                    Log.w("MediaCodecUtil", str.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(str) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                Matcher matcher = f16581b.matcher(split[1]);
                if (!matcher.matches()) {
                    Log.w("MediaCodecUtil", str.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(str) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                String group = matcher.group(1);
                if ("1".equals(group)) {
                    i2 = 1;
                } else if (!"2".equals(group)) {
                    String valueOf = String.valueOf(group);
                    Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf) : new String("Unknown HEVC profile string: "));
                    return null;
                }
                Integer num = f16585f.get(split[3]);
                if (num == null) {
                    String valueOf2 = String.valueOf(matcher.group(1));
                    Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf2) : new String("Unknown HEVC level string: "));
                    return null;
                }
                return new Pair<>(Integer.valueOf(i2), num);
            default:
                return null;
        }
    }

    public static zzpd d(String str, boolean z) throws zzpk {
        List<zzpd> e2 = e(str, z);
        if (e2.isEmpty()) {
            return null;
        }
        return e2.get(0);
    }

    private static synchronized List<zzpd> e(String str, boolean z) throws zzpk {
        synchronized (zzpi.class) {
            a aVar = new a(str, z);
            HashMap<a, List<zzpd>> hashMap = f16582c;
            List<zzpd> list = hashMap.get(aVar);
            if (list != null) {
                return list;
            }
            int i2 = zzsy.a;
            List<zzpd> b2 = b(aVar, i2 >= 21 ? new s20(z) : new r20());
            if (z && b2.isEmpty() && 21 <= i2 && i2 <= 23) {
                b2 = b(aVar, new r20());
                if (!b2.isEmpty()) {
                    String str2 = b2.get(0).a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzpd> unmodifiableList = Collections.unmodifiableList(b2);
            hashMap.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static zzpd f() {
        return a;
    }

    public static int g() throws zzpk {
        if (f16586g == -1) {
            int i2 = 0;
            zzpd d2 = d("video/avc", false);
            if (d2 != null) {
                MediaCodecInfo.CodecProfileLevel[] j2 = d2.j();
                int length = j2.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = j2[i2].level;
                    int i5 = 9437184;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                break;
                            case 64:
                                i5 = 202752;
                                break;
                            case 128:
                            case 256:
                                i5 = 414720;
                                break;
                            case AdRequest.MAX_CONTENT_URL_LENGTH /* 512 */:
                                i5 = 921600;
                                break;
                            case 1024:
                                i5 = 1310720;
                                break;
                            case RecyclerView.l.FLAG_MOVED /* 2048 */:
                            case RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT /* 4096 */:
                                i5 = 2097152;
                                break;
                            case 8192:
                                i5 = 2228224;
                                break;
                            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                                i5 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i5 = -1;
                                break;
                        }
                    } else {
                        i5 = 25344;
                    }
                    i3 = Math.max(i5, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzsy.a >= 21 ? 345600 : 172800);
            }
            f16586g = i2;
        }
        return f16586g;
    }
}
