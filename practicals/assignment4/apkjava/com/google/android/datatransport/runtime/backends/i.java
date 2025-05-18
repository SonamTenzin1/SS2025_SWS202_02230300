package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Inject;

/* compiled from: CreationContextFactory.java */
/* loaded from: classes2.dex */
class i {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11312b;

    /* renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11313c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public i(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2) {
        this.a = context;
        this.f11312b = aVar;
        this.f11313c = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(String str) {
        return h.a(this.a, this.f11312b, this.f11313c, str);
    }
}
