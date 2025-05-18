package com.flurry.sdk;

/* loaded from: classes2.dex */
public final class v {
    public final boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11078b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11079c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11080d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11081e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11082f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11083g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11084h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11085i;

    /* loaded from: classes2.dex */
    public enum a {
        NONE_OR_UNKNOWN(0),
        NETWORK_AVAILABLE(1),
        WIFI(2),
        CELL(3);


        /* renamed from: k, reason: collision with root package name */
        public int f11091k;

        a(int i2) {
            this.f11091k = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(a aVar, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.a = z;
        this.f11078b = aVar;
        this.f11079c = str;
        this.f11080d = str2;
        this.f11081e = str3;
        this.f11082f = str4;
        this.f11083g = str5;
        this.f11084h = str6;
        this.f11085i = i2;
    }
}
