package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class r<T> implements Callable<T> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzacj f13246f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzacr f13247g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zzacr zzacrVar, zzacj zzacjVar) {
        this.f13247g = zzacrVar;
        this.f13246f = zzacjVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        SharedPreferences sharedPreferences;
        zzacj zzacjVar = this.f13246f;
        sharedPreferences = this.f13247g.f13796j;
        return (T) zzacjVar.h(sharedPreferences);
    }
}
