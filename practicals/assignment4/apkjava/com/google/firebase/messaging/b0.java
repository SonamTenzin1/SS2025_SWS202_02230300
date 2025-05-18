package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.r.j;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class b0 {
    private final com.google.firebase.j a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f19793b;

    /* renamed from: c, reason: collision with root package name */
    private final Rpc f19794c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.u.i> f19795d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.r.j> f19796e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.i f19797f;

    b0(com.google.firebase.j jVar, g0 g0Var, Rpc rpc, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this.a = jVar;
        this.f19793b = g0Var;
        this.f19794c = rpc;
        this.f19795d = bVar;
        this.f19796e = bVar2;
        this.f19797f = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(com.google.firebase.j jVar, g0 g0Var, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this(jVar, g0Var, new Rpc(jVar.i()), bVar, bVar2, iVar);
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> b(Task<Bundle> task) {
        return task.g(z.f19885f, new Continuation(this) { // from class: com.google.firebase.messaging.a0
            private final b0 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task2) {
                return this.a.g(task2);
            }
        });
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(this.a.k().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String e(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            }
            if (string3 != null) {
                throw new IOException(string3);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(valueOf.length() + 21);
            sb.append("Unexpected response: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    private Bundle h(String str, String str2, String str3, Bundle bundle) {
        j.a b2;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.l().c());
        bundle.putString("gmsv", Integer.toString(this.f19793b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f19793b.a());
        bundle.putString("app_ver_name", this.f19793b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String b3 = ((com.google.firebase.installations.l) Tasks.a(this.f19797f.a(false))).b();
            if (!TextUtils.isEmpty(b3)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b3);
            } else {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e2);
        }
        bundle.putString("cliv", "fcm-20.1.7_1p");
        com.google.firebase.r.j jVar = this.f19796e.get();
        com.google.firebase.u.i iVar = this.f19795d.get();
        if (jVar != null && iVar != null && (b2 = jVar.b("fire-iid")) != j.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(b2.g()));
            bundle.putString("Firebase-Client", iVar.a());
        }
        return bundle;
    }

    private Task<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f19794c.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<String> d(String str) {
        return b(i(str, g0.c(this.a), "*", new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String g(Task task) throws Exception {
        return e((Bundle) task.k(IOException.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> j(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return b(i(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return b(i(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }
}
