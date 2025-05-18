package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbxr implements zzdti<Set<String>> {
    private final zzdtu<zzbzc> a;

    public zzbxr(zzdtu<zzbzc> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set emptySet;
        if (this.a.get().d() != null) {
            emptySet = Collections.singleton("banner");
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdto.b(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
