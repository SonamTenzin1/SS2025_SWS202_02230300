package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.q;
import androidx.work.q;
import androidx.work.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* compiled from: CancelWorkRunnable.java */
/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final androidx.work.impl.c f2559f = new androidx.work.impl.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CancelWorkRunnable.java */
    /* renamed from: androidx.work.impl.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0053a extends a {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.j f2560g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ UUID f2561h;

        C0053a(androidx.work.impl.j jVar, UUID uuid) {
            this.f2560g = jVar;
            this.f2561h = uuid;
        }

        @Override // androidx.work.impl.utils.a
        void h() {
            WorkDatabase t = this.f2560g.t();
            t.beginTransaction();
            try {
                a(this.f2560g, this.f2561h.toString());
                t.setTransactionSuccessful();
                t.endTransaction();
                g(this.f2560g);
            } catch (Throwable th) {
                t.endTransaction();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CancelWorkRunnable.java */
    /* loaded from: classes.dex */
    public class b extends a {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.j f2562g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f2563h;

        b(androidx.work.impl.j jVar, String str) {
            this.f2562g = jVar;
            this.f2563h = str;
        }

        @Override // androidx.work.impl.utils.a
        void h() {
            WorkDatabase t = this.f2562g.t();
            t.beginTransaction();
            try {
                Iterator<String> it = t.j().o(this.f2563h).iterator();
                while (it.hasNext()) {
                    a(this.f2562g, it.next());
                }
                t.setTransactionSuccessful();
                t.endTransaction();
                g(this.f2562g);
            } catch (Throwable th) {
                t.endTransaction();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CancelWorkRunnable.java */
    /* loaded from: classes.dex */
    public class c extends a {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.j f2564g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f2565h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f2566i;

        c(androidx.work.impl.j jVar, String str, boolean z) {
            this.f2564g = jVar;
            this.f2565h = str;
            this.f2566i = z;
        }

        @Override // androidx.work.impl.utils.a
        void h() {
            WorkDatabase t = this.f2564g.t();
            t.beginTransaction();
            try {
                Iterator<String> it = t.j().k(this.f2565h).iterator();
                while (it.hasNext()) {
                    a(this.f2564g, it.next());
                }
                t.setTransactionSuccessful();
                t.endTransaction();
                if (this.f2566i) {
                    g(this.f2564g);
                }
            } catch (Throwable th) {
                t.endTransaction();
                throw th;
            }
        }
    }

    public static a b(UUID uuid, androidx.work.impl.j jVar) {
        return new C0053a(jVar, uuid);
    }

    public static a c(String str, androidx.work.impl.j jVar, boolean z) {
        return new c(jVar, str, z);
    }

    public static a d(String str, androidx.work.impl.j jVar) {
        return new b(jVar, str);
    }

    private void f(WorkDatabase workDatabase, String str) {
        q j2 = workDatabase.j();
        androidx.work.impl.n.b b2 = workDatabase.b();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            x.a l = j2.l(str2);
            if (l != x.a.SUCCEEDED && l != x.a.FAILED) {
                j2.a(x.a.CANCELLED, str2);
            }
            linkedList.addAll(b2.b(str2));
        }
    }

    void a(androidx.work.impl.j jVar, String str) {
        f(jVar.t(), str);
        jVar.r().l(str);
        Iterator<androidx.work.impl.e> it = jVar.s().iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public androidx.work.q e() {
        return this.f2559f;
    }

    void g(androidx.work.impl.j jVar) {
        androidx.work.impl.f.b(jVar.n(), jVar.t(), jVar.s());
    }

    abstract void h();

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
            this.f2559f.a(androidx.work.q.a);
        } catch (Throwable th) {
            this.f2559f.a(new q.b.a(th));
        }
    }
}
