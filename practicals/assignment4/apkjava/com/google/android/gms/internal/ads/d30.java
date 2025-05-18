package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes2.dex */
final class d30 {
    private final zznn[] a;

    /* renamed from: b, reason: collision with root package name */
    private final zznp f12446b;

    /* renamed from: c, reason: collision with root package name */
    private zznn f12447c;

    public d30(zznn[] zznnVarArr, zznp zznpVar) {
        this.a = zznnVarArr;
        this.f12446b = zznpVar;
    }

    public final void a() {
        zznn zznnVar = this.f12447c;
        if (zznnVar != null) {
            zznnVar.c();
            this.f12447c = null;
        }
    }

    public final zznn b(zzno zznoVar, Uri uri) throws IOException, InterruptedException {
        zznn zznnVar = this.f12447c;
        if (zznnVar != null) {
            return zznnVar;
        }
        zznn[] zznnVarArr = this.a;
        int length = zznnVarArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            zznn zznnVar2 = zznnVarArr[i2];
            try {
            } catch (EOFException unused) {
            } finally {
                zznoVar.c();
            }
            if (zznnVar2.g(zznoVar)) {
                this.f12447c = zznnVar2;
                break;
            }
            i2++;
        }
        zznn zznnVar3 = this.f12447c;
        if (zznnVar3 != null) {
            zznnVar3.e(this.f12446b);
            return this.f12447c;
        }
        String d2 = zzsy.d(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(d2);
        sb.append(") could read the stream.");
        throw new zzrc(sb.toString(), uri);
    }
}
