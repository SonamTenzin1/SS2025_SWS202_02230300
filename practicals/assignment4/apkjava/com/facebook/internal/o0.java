package com.facebook.internal;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: SmartLoginOption.kt */
/* loaded from: classes2.dex */
public enum o0 {
    None(0),
    Enabled(1),
    RequireConfirm(2);


    /* renamed from: f, reason: collision with root package name */
    public static final a f9810f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final EnumSet<o0> f9811g;
    private final long l;

    /* compiled from: SmartLoginOption.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final EnumSet<o0> a(long j2) {
            EnumSet<o0> noneOf = EnumSet.noneOf(o0.class);
            Iterator it = o0.f9811g.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                if ((o0Var.q() & j2) != 0) {
                    noneOf.add(o0Var);
                }
            }
            kotlin.jvm.internal.m.e(noneOf, "result");
            return noneOf;
        }
    }

    static {
        EnumSet<o0> allOf = EnumSet.allOf(o0.class);
        kotlin.jvm.internal.m.e(allOf, "allOf(SmartLoginOption::class.java)");
        f9811g = allOf;
    }

    o0(long j2) {
        this.l = j2;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static o0[] valuesCustom() {
        o0[] valuesCustom = values();
        return (o0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final long q() {
        return this.l;
    }
}
