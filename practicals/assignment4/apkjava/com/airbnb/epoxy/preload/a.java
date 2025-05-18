package com.airbnb.epoxy.preload;

import android.view.View;
import com.airbnb.epoxy.preload.c;
import com.airbnb.epoxy.preload.h;
import com.airbnb.epoxy.s;
import java.util.List;
import kotlin.jvm.internal.m;

/* compiled from: EpoxyModelPreloader.kt */
/* loaded from: classes.dex */
public abstract class a<T extends s<?>, U extends h, P extends c> {
    public static final C0114a a = new C0114a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Class<T> f8447b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Integer> f8448c;

    /* compiled from: EpoxyModelPreloader.kt */
    /* renamed from: com.airbnb.epoxy.preload.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0114a {
        private C0114a() {
        }

        public /* synthetic */ C0114a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public abstract U a(View view);

    public final Class<T> b() {
        return this.f8447b;
    }

    public final List<Integer> c() {
        return this.f8448c;
    }

    public abstract void d(T t, P p, g<? extends U> gVar);

    public Object e(T t) {
        m.g(t, "epoxyModel");
        return null;
    }
}
