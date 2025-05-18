package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class qy {
    static zzdbq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzdy zzdyVar) throws IllegalAccessException, InvocationTargetException {
        Method p;
        zzdbq zzdbqVar;
        if (a != null) {
            return true;
        }
        String str = (String) zzyt.e().c(zzacu.s2);
        if (str == null || str.length() == 0) {
            str = (zzdyVar == null || (p = zzdyVar.p("zu6uZ8u7nNJHsIXbotuBCEBd9hieUh9UBKC94dMPsF422AtJb3FisPSqZI3W+06A", "tm6XtP5M5qvCs+TffoCZhF/AF3Fx7Ow8iqgApPbgXSw=")) == null) ? null : (String) p.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzdbu b2 = zzdbz.b(zzcg.b(str, true));
            zzdbl.b(zzddc.a);
            zzdcf.l(new zzddg());
            zzdbqVar = (zzdbq) zzdcf.f(zzdcf.c(b2, null, zzdbq.class));
            a = zzdbqVar;
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return zzdbqVar != null;
    }
}
