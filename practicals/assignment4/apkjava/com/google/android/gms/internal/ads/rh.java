package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class rh<T> implements zzaho<Object> {
    private final WeakReference<T> a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13269b;

    /* renamed from: c, reason: collision with root package name */
    private final zzaho<T> f13270c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzccj f13271d;

    private rh(zzccj zzccjVar, WeakReference<T> weakReference, String str, zzaho<T> zzahoVar) {
        this.f13271d = zzccjVar;
        this.a = weakReference;
        this.f13269b = str;
        this.f13270c = zzahoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        T t = this.a.get();
        if (t == null) {
            this.f13271d.h(this.f13269b, this);
        } else {
            this.f13270c.a(t, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ rh(zzccj zzccjVar, WeakReference weakReference, String str, zzaho zzahoVar, lh lhVar) {
        this(zzccjVar, weakReference, str, zzahoVar);
    }
}
