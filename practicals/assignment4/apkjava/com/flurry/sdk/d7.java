package com.flurry.sdk;

import com.flurry.sdk.i2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class d7<T> extends l2 {
    protected Set<f7<T>> o;

    /* loaded from: classes2.dex */
    final class a extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f10702h;

        a(f7 f7Var) {
            this.f10702h = f7Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            d7.this.o.add(this.f10702h);
        }
    }

    /* loaded from: classes2.dex */
    final class b extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f10704h;

        b(f7 f7Var) {
            this.f10704h = f7Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            d7.this.o.remove(this.f10704h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f10706h;

        /* loaded from: classes2.dex */
        final class a extends f2 {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ f7 f10708h;

            a(f7 f7Var) {
                this.f10708h = f7Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.flurry.sdk.f2
            public final void a() {
                this.f10708h.a(c.this.f10706h);
            }
        }

        c(Object obj) {
            this.f10706h = obj;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            Iterator<f7<T>> it = d7.this.o.iterator();
            while (it.hasNext()) {
                d7.this.m(new a(it.next()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d7(String str) {
        super(str, i2.a(i2.b.PROVIDER));
        this.o = null;
        this.o = new HashSet();
    }

    public void t(T t) {
        m(new c(t));
    }

    public void u() {
    }

    public void v(f7<T> f7Var) {
        if (f7Var == null) {
            return;
        }
        m(new a(f7Var));
    }

    public void w(f7<T> f7Var) {
        m(new b(f7Var));
    }
}
