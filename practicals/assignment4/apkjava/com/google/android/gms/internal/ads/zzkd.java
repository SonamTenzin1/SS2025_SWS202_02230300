package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzkd extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzkd(Exception exc) {
        super(r2.toString(), exc);
        String simpleName = exc.getClass().getSimpleName();
        String valueOf = String.valueOf(exc.getMessage());
        StringBuilder sb = new StringBuilder(simpleName.length() + 13 + valueOf.length());
        sb.append("Unexpected ");
        sb.append(simpleName);
        sb.append(": ");
        sb.append(valueOf);
    }
}
