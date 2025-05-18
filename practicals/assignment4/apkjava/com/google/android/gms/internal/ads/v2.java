package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
final class v2 {
    long a;

    /* renamed from: b, reason: collision with root package name */
    final String f13429b;

    /* renamed from: c, reason: collision with root package name */
    final String f13430c;

    /* renamed from: d, reason: collision with root package name */
    final long f13431d;

    /* renamed from: e, reason: collision with root package name */
    final long f13432e;

    /* renamed from: f, reason: collision with root package name */
    final long f13433f;

    /* renamed from: g, reason: collision with root package name */
    final long f13434g;

    /* renamed from: h, reason: collision with root package name */
    final List<zzl> f13435h;

    private v2(String str, String str2, long j2, long j3, long j4, long j5, List<zzl> list) {
        this.f13429b = str;
        this.f13430c = HttpUrl.FRAGMENT_ENCODE_SET.equals(str2) ? null : str2;
        this.f13431d = j2;
        this.f13432e = j3;
        this.f13433f = j4;
        this.f13434g = j5;
        this.f13435h = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v2 b(y2 y2Var) throws IOException {
        if (zzan.l(y2Var) == 538247942) {
            return new v2(zzan.f(y2Var), zzan.f(y2Var), zzan.n(y2Var), zzan.n(y2Var), zzan.n(y2Var), zzan.n(y2Var), zzan.m(y2Var));
        }
        throw new IOException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(OutputStream outputStream) {
        try {
            zzan.g(outputStream, 538247942);
            zzan.i(outputStream, this.f13429b);
            String str = this.f13430c;
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            zzan.i(outputStream, str);
            zzan.h(outputStream, this.f13431d);
            zzan.h(outputStream, this.f13432e);
            zzan.h(outputStream, this.f13433f);
            zzan.h(outputStream, this.f13434g);
            List<zzl> list = this.f13435h;
            if (list != null) {
                zzan.g(outputStream, list.size());
                for (zzl zzlVar : list) {
                    zzan.i(outputStream, zzlVar.a());
                    zzan.i(outputStream, zzlVar.b());
                }
            } else {
                zzan.g(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e2) {
            zzag.a("%s", e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v2(String str, zzc zzcVar) {
        this(str, r2, r3, r5, r7, r9, r0);
        String str2 = zzcVar.f14946b;
        long j2 = zzcVar.f14947c;
        long j3 = zzcVar.f14948d;
        long j4 = zzcVar.f14949e;
        long j5 = zzcVar.f14950f;
        List list = zzcVar.f14952h;
        if (list == null) {
            Map<String, String> map = zzcVar.f14951g;
            list = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new zzl(entry.getKey(), entry.getValue()));
            }
        }
    }
}
