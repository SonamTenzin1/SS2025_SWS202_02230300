package com.airbnb.epoxy;

import android.os.Handler;
import androidx.recyclerview.widget.f;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncEpoxyDiffer.java */
/* loaded from: classes.dex */
public class c {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final e f8393b;

    /* renamed from: c, reason: collision with root package name */
    private final f.d<s<?>> f8394c;

    /* renamed from: e, reason: collision with root package name */
    private volatile List<? extends s<?>> f8396e;

    /* renamed from: d, reason: collision with root package name */
    private final d f8395d = new d(null);

    /* renamed from: f, reason: collision with root package name */
    private volatile List<? extends s<?>> f8397f = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncEpoxyDiffer.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C0113c f8398f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f8399g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f8400h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f8401i;

        a(C0113c c0113c, int i2, List list, List list2) {
            this.f8398f = c0113c;
            this.f8399g = i2;
            this.f8400h = list;
            this.f8401i = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.c a = androidx.recyclerview.widget.f.a(this.f8398f);
            c cVar = c.this;
            int i2 = this.f8399g;
            List list = this.f8400h;
            cVar.h(i2, list, k.b(this.f8401i, list, a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncEpoxyDiffer.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f8403f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f8404g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ k f8405h;

        b(List list, int i2, k kVar) {
            this.f8403f = list;
            this.f8404g = i2;
            this.f8405h = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j2 = c.this.j(this.f8403f, this.f8404g);
            if (this.f8405h == null || !j2) {
                return;
            }
            c.this.f8393b.d(this.f8405h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncEpoxyDiffer.java */
    /* renamed from: com.airbnb.epoxy.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0113c extends f.b {
        final List<? extends s<?>> a;

        /* renamed from: b, reason: collision with root package name */
        final List<? extends s<?>> f8407b;

        /* renamed from: c, reason: collision with root package name */
        private final f.d<s<?>> f8408c;

        C0113c(List<? extends s<?>> list, List<? extends s<?>> list2, f.d<s<?>> dVar) {
            this.a = list;
            this.f8407b = list2;
            this.f8408c = dVar;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areContentsTheSame(int i2, int i3) {
            return this.f8408c.a(this.a.get(i2), this.f8407b.get(i3));
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areItemsTheSame(int i2, int i3) {
            return this.f8408c.b(this.a.get(i2), this.f8407b.get(i3));
        }

        @Override // androidx.recyclerview.widget.f.b
        public Object getChangePayload(int i2, int i3) {
            return this.f8408c.c(this.a.get(i2), this.f8407b.get(i3));
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getNewListSize() {
            return this.f8407b.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getOldListSize() {
            return this.a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncEpoxyDiffer.java */
    /* loaded from: classes.dex */
    public static class d {
        private volatile int a;

        /* renamed from: b, reason: collision with root package name */
        private volatile int f8409b;

        private d() {
        }

        synchronized boolean a(int i2) {
            boolean z;
            z = this.a == i2 && i2 > this.f8409b;
            if (z) {
                this.f8409b = i2;
            }
            return z;
        }

        synchronized boolean b() {
            boolean c2;
            c2 = c();
            this.f8409b = this.a;
            return c2;
        }

        synchronized boolean c() {
            return this.a > this.f8409b;
        }

        synchronized int d() {
            int i2;
            i2 = this.a + 1;
            this.a = i2;
            return i2;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncEpoxyDiffer.java */
    /* loaded from: classes.dex */
    public interface e {
        void d(k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Handler handler, e eVar, f.d<s<?>> dVar) {
        this.a = new w(handler);
        this.f8393b = eVar;
        this.f8394c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, List<? extends s<?>> list, k kVar) {
        b0.f8392h.execute(new b(list, i2, kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean j(List<? extends s<?>> list, int i2) {
        if (!this.f8395d.a(i2)) {
            return false;
        }
        this.f8396e = list;
        if (list == null) {
            this.f8397f = Collections.emptyList();
        } else {
            this.f8397f = Collections.unmodifiableList(list);
        }
        return true;
    }

    public boolean d() {
        return this.f8395d.b();
    }

    public synchronized boolean e(List<s<?>> list) {
        boolean d2;
        d2 = d();
        j(list, this.f8395d.d());
        return d2;
    }

    public List<? extends s<?>> f() {
        return this.f8397f;
    }

    public boolean g() {
        return this.f8395d.c();
    }

    public void i(List<? extends s<?>> list) {
        int d2;
        List<? extends s<?>> list2;
        synchronized (this) {
            d2 = this.f8395d.d();
            list2 = this.f8396e;
        }
        if (list == list2) {
            h(d2, list, k.f(list2));
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (list2 != null && !list2.isEmpty()) {
                this.a.execute(new a(new C0113c(list2, list, this.f8394c), d2, list, list2));
                return;
            } else {
                h(d2, list, k.e(list));
                return;
            }
        }
        h(d2, null, (list2 == null || list2.isEmpty()) ? null : k.a(list2));
    }
}
