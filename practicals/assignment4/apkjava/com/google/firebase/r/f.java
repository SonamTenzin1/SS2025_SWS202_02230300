package com.google.firebase.r;

import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.b0;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import com.google.firebase.r.j;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DefaultHeartBeatController.java */
/* loaded from: classes2.dex */
public class f implements i, j {
    private final com.google.firebase.s.b<k> a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f19894b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.u.i> f19895c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<g> f19896d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f19897e;

    private f(final Context context, final String str, Set<g> set, com.google.firebase.s.b<com.google.firebase.u.i> bVar, Executor executor) {
        this((com.google.firebase.s.b<k>) new com.google.firebase.s.b() { // from class: com.google.firebase.r.c
            @Override // com.google.firebase.s.b
            public final Object get() {
                return f.g(context, str);
            }
        }, set, executor, bVar, context);
    }

    public static n<f> c() {
        final b0 a = b0.a(com.google.firebase.o.a.a.class, Executor.class);
        return n.d(f.class, i.class, j.class).b(v.k(Context.class)).b(v.k(com.google.firebase.j.class)).b(v.n(g.class)).b(v.m(com.google.firebase.u.i.class)).b(v.j(a)).f(new r() { // from class: com.google.firebase.r.d
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                return f.d(b0.this, pVar);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ f d(b0 b0Var, p pVar) {
        return new f((Context) pVar.a(Context.class), ((com.google.firebase.j) pVar.a(com.google.firebase.j.class)).m(), (Set<g>) pVar.g(g.class), (com.google.firebase.s.b<com.google.firebase.u.i>) pVar.c(com.google.firebase.u.i.class), (Executor) pVar.f(b0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String f() throws Exception {
        String byteArrayOutputStream;
        synchronized (this) {
            k kVar = this.a.get();
            List<l> c2 = kVar.c();
            kVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < c2.size(); i2++) {
                l lVar = c2.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", lVar.c());
                jSONObject.put("dates", new JSONArray((Collection) lVar.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                try {
                    gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                    gZIPOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    base64OutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ k g(Context context, String str) {
        return new k(context, str);
    }

    private /* synthetic */ Void h() throws Exception {
        synchronized (this) {
            this.a.get().k(System.currentTimeMillis(), this.f19895c.get().a());
        }
        return null;
    }

    @Override // com.google.firebase.r.i
    public Task<String> a() {
        if (!androidx.core.os.e.a(this.f19894b)) {
            return Tasks.e(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        return Tasks.c(this.f19897e, new Callable() { // from class: com.google.firebase.r.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.this.f();
            }
        });
    }

    @Override // com.google.firebase.r.j
    public synchronized j.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        k kVar = this.a.get();
        if (kVar.i(currentTimeMillis)) {
            kVar.g();
            return j.a.GLOBAL;
        }
        return j.a.NONE;
    }

    public /* synthetic */ Void i() {
        h();
        return null;
    }

    public Task<Void> j() {
        if (this.f19896d.size() <= 0) {
            return Tasks.e(null);
        }
        if (!androidx.core.os.e.a(this.f19894b)) {
            return Tasks.e(null);
        }
        return Tasks.c(this.f19897e, new Callable() { // from class: com.google.firebase.r.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                f.this.i();
                return null;
            }
        });
    }

    f(com.google.firebase.s.b<k> bVar, Set<g> set, Executor executor, com.google.firebase.s.b<com.google.firebase.u.i> bVar2, Context context) {
        this.a = bVar;
        this.f19896d = set;
        this.f19897e = executor;
        this.f19895c = bVar2;
        this.f19894b = context;
    }
}
