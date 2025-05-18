package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzgx {
    private static final HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16264b;

        public a(String str, boolean z) {
            this.a = str;
            this.f16264b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && this.f16264b == aVar.f16264b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f16264b ? 1231 : 1237);
        }
    }

    private static Pair<String, MediaCodecInfo.CodecCapabilities> a(a aVar, gz gzVar) throws zzgz {
        try {
            String str = aVar.a;
            int c2 = gzVar.c();
            boolean b2 = gzVar.b();
            boolean z = false;
            int i2 = 0;
            while (i2 < c2) {
                MediaCodecInfo a2 = gzVar.a(i2);
                String name = a2.getName();
                if (!a2.isEncoder() && name.startsWith("OMX.") && (b2 || !name.endsWith(".secure"))) {
                    String[] supportedTypes = a2.getSupportedTypes();
                    int i3 = 0;
                    while (i3 < supportedTypes.length) {
                        String str2 = supportedTypes[i3];
                        if (str2.equalsIgnoreCase(str)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                            boolean d2 = gzVar.d(aVar.a, capabilitiesForType);
                            if (!b2) {
                                HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> hashMap = a;
                                hashMap.put(aVar.f16264b ? new a(str, z) : aVar, Pair.create(name, capabilitiesForType));
                                if (d2) {
                                    hashMap.put(aVar.f16264b ? aVar : new a(str, true), Pair.create(name.concat(".secure"), capabilitiesForType));
                                }
                            } else {
                                a.put(aVar.f16264b == d2 ? aVar : new a(str, d2), Pair.create(name, capabilitiesForType));
                            }
                            HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> hashMap2 = a;
                            if (hashMap2.containsKey(aVar)) {
                                return hashMap2.get(aVar);
                            }
                        }
                        i3++;
                        z = false;
                    }
                }
                i2++;
                z = false;
            }
            return null;
        } catch (Exception e2) {
            throw new zzgz(e2);
        }
    }

    public static zzgc b(String str, boolean z) throws zzgz {
        Pair<String, MediaCodecInfo.CodecCapabilities> c2 = c(str, z);
        if (c2 == null) {
            return null;
        }
        return new zzgc((String) c2.first, zzkq.a >= 19 ? ((MediaCodecInfo.CodecCapabilities) c2.second).isFeatureSupported("adaptive-playback") : false);
    }

    private static synchronized Pair<String, MediaCodecInfo.CodecCapabilities> c(String str, boolean z) throws zzgz {
        synchronized (zzgx.class) {
            a aVar = new a(str, z);
            HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> hashMap = a;
            if (hashMap.containsKey(aVar)) {
                return hashMap.get(aVar);
            }
            int i2 = zzkq.a;
            Pair<String, MediaCodecInfo.CodecCapabilities> a2 = a(aVar, i2 >= 21 ? new iz(z) : new hz());
            if (z && a2 == null && i2 >= 21 && (a2 = a(aVar, new hz())) != null) {
                String str2 = (String) a2.first;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
            return a2;
        }
    }
}
