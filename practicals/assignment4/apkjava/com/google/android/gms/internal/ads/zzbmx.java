package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmx implements zzdti<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> {
    private final zzdtu<zzbmn> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14571b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<JSONObject> f14572c;

    private zzbmx(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14571b = zzdtuVar2;
        this.f14572c = zzdtuVar3;
    }

    public static zzbmx a(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbmx(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set singleton;
        zzbmn zzbmnVar = this.a.get();
        Executor executor = this.f14571b.get();
        if (this.f14572c.get() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbuz(zzbmnVar, executor));
        }
        return (Set) zzdto.b(singleton, "Cannot return null from a non-@Nullable @Provides method");
    }
}
