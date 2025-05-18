package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class zzdbx {
    private static final CopyOnWriteArrayList<zzdbw> a = new CopyOnWriteArrayList<>();

    public static zzdbw a(String str) throws GeneralSecurityException {
        Iterator<zzdbw> it = a.iterator();
        while (it.hasNext()) {
            zzdbw next = it.next();
            if (next.a(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
