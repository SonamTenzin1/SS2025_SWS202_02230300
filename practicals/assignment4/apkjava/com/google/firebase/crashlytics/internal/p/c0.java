package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.g;
import com.google.firebase.crashlytics.internal.p.g0;

/* compiled from: AutoValue_StaticSessionData_AppData.java */
/* loaded from: classes2.dex */
final class c0 extends g0.a {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19339b;

    /* renamed from: c, reason: collision with root package name */
    private final String f19340c;

    /* renamed from: d, reason: collision with root package name */
    private final String f19341d;

    /* renamed from: e, reason: collision with root package name */
    private final int f19342e;

    /* renamed from: f, reason: collision with root package name */
    private final g f19343f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(String str, String str2, String str3, String str4, int i2, g gVar) {
        if (str != null) {
            this.a = str;
            if (str2 != null) {
                this.f19339b = str2;
                if (str3 != null) {
                    this.f19340c = str3;
                    if (str4 != null) {
                        this.f19341d = str4;
                        this.f19342e = i2;
                        if (gVar != null) {
                            this.f19343f = gVar;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public String a() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public int c() {
        return this.f19342e;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public g d() {
        return this.f19343f;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public String e() {
        return this.f19341d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.a)) {
            return false;
        }
        g0.a aVar = (g0.a) obj;
        return this.a.equals(aVar.a()) && this.f19339b.equals(aVar.f()) && this.f19340c.equals(aVar.g()) && this.f19341d.equals(aVar.e()) && this.f19342e == aVar.c() && this.f19343f.equals(aVar.d());
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public String f() {
        return this.f19339b;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.a
    public String g() {
        return this.f19340c;
    }

    public int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19339b.hashCode()) * 1000003) ^ this.f19340c.hashCode()) * 1000003) ^ this.f19341d.hashCode()) * 1000003) ^ this.f19342e) * 1000003) ^ this.f19343f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.a + ", versionCode=" + this.f19339b + ", versionName=" + this.f19340c + ", installUuid=" + this.f19341d + ", deliveryMechanism=" + this.f19342e + ", developmentPlatformProvider=" + this.f19343f + "}";
    }
}
