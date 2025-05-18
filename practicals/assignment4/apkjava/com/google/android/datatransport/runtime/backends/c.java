package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* compiled from: AutoValue_CreationContext.java */
/* loaded from: classes2.dex */
final class c extends h {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11304b;

    /* renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11305c;

    /* renamed from: d, reason: collision with root package name */
    private final String f11306d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, String str) {
        if (context != null) {
            this.a = context;
            if (aVar != null) {
                this.f11304b = aVar;
                if (aVar2 != null) {
                    this.f11305c = aVar2;
                    if (str != null) {
                        this.f11306d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public Context b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public String c() {
        return this.f11306d;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public e.e.b.a.i.c0.a d() {
        return this.f11305c;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public e.e.b.a.i.c0.a e() {
        return this.f11304b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.b()) && this.f11304b.equals(hVar.e()) && this.f11305c.equals(hVar.d()) && this.f11306d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f11304b.hashCode()) * 1000003) ^ this.f11305c.hashCode()) * 1000003) ^ this.f11306d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.f11304b + ", monotonicClock=" + this.f11305c + ", backendName=" + this.f11306d + "}";
    }
}
