package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.n.j0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_InstallIdProvider_InstallIds.java */
/* loaded from: classes2.dex */
public final class n extends j0.a {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19065b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.f19065b = str2;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    @Override // com.google.firebase.crashlytics.h.n.j0.a
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.n.j0.a
    public String d() {
        return this.f19065b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j0.a)) {
            return false;
        }
        j0.a aVar = (j0.a) obj;
        if (this.a.equals(aVar.c())) {
            String str = this.f19065b;
            if (str == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (str.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19065b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.a + ", firebaseInstallationId=" + this.f19065b + "}";
    }
}
