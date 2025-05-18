package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class zzp {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f16552b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f16553c;

    /* renamed from: d, reason: collision with root package name */
    public final List<zzl> f16554d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16555e;

    /* renamed from: f, reason: collision with root package name */
    private final long f16556f;

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzp(int i2, byte[] bArr, Map<String, String> map, boolean z, long j2) {
        this(i2, bArr, map, r0, z, j2);
        List arrayList;
        if (map == null) {
            arrayList = null;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new zzl(entry.getKey(), entry.getValue()));
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzp(int i2, byte[] bArr, boolean z, long j2, List<zzl> list) {
        this(i2, bArr, r0, list, z, j2);
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzl zzlVar : list) {
                treeMap.put(zzlVar.a(), zzlVar.b());
            }
        }
    }

    @Deprecated
    public zzp(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private zzp(int i2, byte[] bArr, Map<String, String> map, List<zzl> list, boolean z, long j2) {
        this.a = i2;
        this.f16552b = bArr;
        this.f16553c = map;
        if (list == null) {
            this.f16554d = null;
        } else {
            this.f16554d = Collections.unmodifiableList(list);
        }
        this.f16555e = z;
        this.f16556f = j2;
    }
}
