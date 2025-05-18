package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzadi {

    @VisibleForTesting
    boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final List<zzadg> f13824b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f13825c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f13826d;

    /* renamed from: e, reason: collision with root package name */
    private zzadi f13827e;

    public zzadi(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f13825c = linkedHashMap;
        this.f13826d = new Object();
        this.a = true;
        linkedHashMap.put("action", str);
        linkedHashMap.put("ad_format", str2);
    }

    public final boolean a(zzadg zzadgVar, long j2, String... strArr) {
        synchronized (this.f13826d) {
            for (String str : strArr) {
                this.f13824b.add(new zzadg(j2, str, zzadgVar));
            }
        }
        return true;
    }

    public final void b(zzadi zzadiVar) {
        synchronized (this.f13826d) {
            this.f13827e = zzadiVar;
        }
    }

    public final zzadg c(long j2) {
        if (this.a) {
            return new zzadg(j2, null, null);
        }
        return null;
    }

    public final void d(String str, String str2) {
        zzacy l;
        if (!this.a || TextUtils.isEmpty(str2) || (l = zzk.zzlk().l()) == null) {
            return;
        }
        synchronized (this.f13826d) {
            zzadc e2 = l.e(str);
            Map<String, String> map = this.f13825c;
            map.put(str, e2.a(map.get(str), str2));
        }
    }

    public final String e() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.f13826d) {
            for (zzadg zzadgVar : this.f13824b) {
                long a = zzadgVar.a();
                String b2 = zzadgVar.b();
                zzadg c2 = zzadgVar.c();
                if (c2 != null && a > 0) {
                    long a2 = a - c2.a();
                    sb2.append(b2);
                    sb2.append('.');
                    sb2.append(a2);
                    sb2.append(',');
                }
            }
            this.f13824b.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Map<String, String> f() {
        zzadi zzadiVar;
        synchronized (this.f13826d) {
            zzacy l = zzk.zzlk().l();
            if (l != null && (zzadiVar = this.f13827e) != null) {
                return l.a(this.f13825c, zzadiVar.f());
            }
            return this.f13825c;
        }
    }
}
