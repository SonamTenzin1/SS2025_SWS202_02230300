package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class wu extends vu<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final Object b(zzdno zzdnoVar, zzdpk zzdpkVar, int i2) {
        return zzdnoVar.a(zzdpkVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final <UT, UB> UB c(kw kwVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar, UB ub, cx<UT, UB> cxVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final void d(zzdmr zzdmrVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final void e(kw kwVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final void f(ux uxVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final void g(Object obj) {
        i(obj).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final boolean h(zzdpk zzdpkVar) {
        return zzdpkVar instanceof zzdob.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final yu<Object> i(Object obj) {
        return ((zzdob.zzc) obj).zzhhj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.vu
    public final yu<Object> j(Object obj) {
        zzdob.zzc zzcVar = (zzdob.zzc) obj;
        if (zzcVar.zzhhj.c()) {
            zzcVar.zzhhj = (yu) zzcVar.zzhhj.clone();
        }
        return zzcVar.zzhhj;
    }
}
