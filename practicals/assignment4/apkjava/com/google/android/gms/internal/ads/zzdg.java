package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzdg extends zzdf {
    private zzdg(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzdg l(String str, Context context, boolean z) {
        zzdf.g(context, z);
        return new zzdg(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdf
    public final List<Callable<Void>> k(zzdy zzdyVar, Context context, zzbp.zza.C0176zza c0176zza, zzbk.zza zzaVar) {
        if (zzdyVar.r() != null && this.D) {
            int q = zzdyVar.q();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(super.k(zzdyVar, context, c0176zza, zzaVar));
            arrayList.add(new zzes(zzdyVar, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", c0176zza, q, 24));
            return arrayList;
        }
        return super.k(zzdyVar, context, c0176zza, zzaVar);
    }
}
