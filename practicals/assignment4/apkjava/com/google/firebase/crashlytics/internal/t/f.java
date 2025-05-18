package com.google.firebase.crashlytics.internal.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.d0;
import com.google.firebase.crashlytics.internal.n.e0;
import com.google.firebase.crashlytics.internal.n.f0;
import com.google.firebase.crashlytics.internal.n.i0;
import com.google.firebase.crashlytics.internal.n.p0;
import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.q.b;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SettingsController.java */
/* loaded from: classes2.dex */
public class f implements i {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final j f19559b;

    /* renamed from: c, reason: collision with root package name */
    private final g f19560c;

    /* renamed from: d, reason: collision with root package name */
    private final d0 f19561d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.t.a f19562e;

    /* renamed from: f, reason: collision with root package name */
    private final k f19563f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f19564g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicReference<d> f19565h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReference<TaskCompletionSource<d>> f19566i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsController.java */
    /* loaded from: classes2.dex */
    public class a implements SuccessContinuation<Void, Void> {
        a() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task<Void> a(Void r5) throws Exception {
            JSONObject a = f.this.f19563f.a(f.this.f19559b, true);
            if (a != null) {
                d b2 = f.this.f19560c.b(a);
                f.this.f19562e.c(b2.f19546c, a);
                f.this.q(a, "Loaded settings: ");
                f fVar = f.this;
                fVar.r(fVar.f19559b.f19571f);
                f.this.f19565h.set(b2);
                ((TaskCompletionSource) f.this.f19566i.get()).e(b2);
            }
            return Tasks.e(null);
        }
    }

    f(Context context, j jVar, d0 d0Var, g gVar, com.google.firebase.crashlytics.internal.t.a aVar, k kVar, e0 e0Var) {
        AtomicReference<d> atomicReference = new AtomicReference<>();
        this.f19565h = atomicReference;
        this.f19566i = new AtomicReference<>(new TaskCompletionSource());
        this.a = context;
        this.f19559b = jVar;
        this.f19561d = d0Var;
        this.f19560c = gVar;
        this.f19562e = aVar;
        this.f19563f = kVar;
        this.f19564g = e0Var;
        atomicReference.set(b.b(d0Var));
    }

    public static f l(Context context, String str, i0 i0Var, b bVar, String str2, String str3, com.google.firebase.crashlytics.internal.r.f fVar, e0 e0Var) {
        String g2 = i0Var.g();
        p0 p0Var = new p0();
        return new f(context, new j(str, i0Var.h(), i0Var.i(), i0Var.j(), i0Var, t.h(t.m(context), str, str3, str2), str3, str2, f0.g(g2).k()), p0Var, new g(p0Var), new com.google.firebase.crashlytics.internal.t.a(fVar), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), e0Var);
    }

    private d m(e eVar) {
        d dVar = null;
        try {
            if (!e.SKIP_CACHE_LOOKUP.equals(eVar)) {
                JSONObject b2 = this.f19562e.b();
                if (b2 != null) {
                    d b3 = this.f19560c.b(b2);
                    if (b3 != null) {
                        q(b2, "Loaded cached settings: ");
                        long a2 = this.f19561d.a();
                        if (!e.IGNORE_CACHE_EXPIRATION.equals(eVar) && b3.a(a2)) {
                            h.f().i("Cached settings have expired.");
                        }
                        try {
                            h.f().i("Returning cached settings.");
                            dVar = b3;
                        } catch (Exception e2) {
                            e = e2;
                            dVar = b3;
                            h.f().e("Failed to get cached settings", e);
                            return dVar;
                        }
                    } else {
                        h.f().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    h.f().b("No cached settings data found.");
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return dVar;
    }

    private String n() {
        return t.q(this.a).getString("existing_instance_identifier", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) throws JSONException {
        h.f().b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean r(String str) {
        SharedPreferences.Editor edit = t.q(this.a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.t.i
    public Task<d> a() {
        return this.f19566i.get().a();
    }

    @Override // com.google.firebase.crashlytics.internal.t.i
    public d b() {
        return this.f19565h.get();
    }

    boolean k() {
        return !n().equals(this.f19559b.f19571f);
    }

    public Task<Void> o(e eVar, Executor executor) {
        d m;
        if (!k() && (m = m(eVar)) != null) {
            this.f19565h.set(m);
            this.f19566i.get().e(m);
            return Tasks.e(null);
        }
        d m2 = m(e.IGNORE_CACHE_EXPIRATION);
        if (m2 != null) {
            this.f19565h.set(m2);
            this.f19566i.get().e(m2);
        }
        return this.f19564g.i(executor).p(executor, new a());
    }

    public Task<Void> p(Executor executor) {
        return o(e.USE_CACHE, executor);
    }
}
