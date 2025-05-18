package com.google.android.datatransport.cct;

import cm.aptoide.pt.networking.BodyInterceptorV3;
import e.e.b.a.i.h;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* compiled from: CCTDestination.java */
/* loaded from: classes2.dex */
public final class c implements h {
    static final String a;

    /* renamed from: b, reason: collision with root package name */
    static final String f11185b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f11186c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<e.e.b.a.b> f11187d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f11188e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f11189f;

    /* renamed from: g, reason: collision with root package name */
    private final String f11190g;

    /* renamed from: h, reason: collision with root package name */
    private final String f11191h;

    static {
        String a2 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        a = a2;
        String a3 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f11185b = a3;
        String a4 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f11186c = a4;
        f11187d = Collections.unmodifiableSet(new HashSet(Arrays.asList(e.e.b.a.b.b("proto"), e.e.b.a.b.b(BodyInterceptorV3.RESPONSE_MODE_JSON))));
        f11188e = new c(a2, null);
        f11189f = new c(a3, a4);
    }

    public c(String str, String str2) {
        this.f11190g = str;
        this.f11191h = str2;
    }

    public static c c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new c(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // e.e.b.a.i.h
    public Set<e.e.b.a.b> a() {
        return f11187d;
    }

    public byte[] b() {
        String str = this.f11191h;
        if (str == null && this.f11190g == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f11190g;
        objArr[2] = "\\";
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f11191h;
    }

    public String e() {
        return this.f11190g;
    }

    @Override // e.e.b.a.i.g
    public byte[] getExtras() {
        return b();
    }

    @Override // e.e.b.a.i.g
    public String getName() {
        return "cct";
    }
}
