package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.p.f0;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* loaded from: classes2.dex */
public final class m extends b0 {
    private final f0 a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19063b;

    /* renamed from: c, reason: collision with root package name */
    private final File f19064c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f0 f0Var, String str, File file) {
        if (f0Var != null) {
            this.a = f0Var;
            if (str != null) {
                this.f19063b = str;
                if (file != null) {
                    this.f19064c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    @Override // com.google.firebase.crashlytics.internal.n.b0
    public f0 b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.n.b0
    public File c() {
        return this.f19064c;
    }

    @Override // com.google.firebase.crashlytics.internal.n.b0
    public String d() {
        return this.f19063b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a.equals(b0Var.b()) && this.f19063b.equals(b0Var.d()) && this.f19064c.equals(b0Var.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19063b.hashCode()) * 1000003) ^ this.f19064c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.a + ", sessionId=" + this.f19063b + ", reportFile=" + this.f19064c + "}";
    }
}
