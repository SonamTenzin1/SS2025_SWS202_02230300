package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.r.j;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class k {
    private final com.google.firebase.j a;

    /* renamed from: b, reason: collision with root package name */
    private final n f19643b;

    /* renamed from: c, reason: collision with root package name */
    private final Rpc f19644c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.u.i> f19645d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.r.j> f19646e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.i f19647f;

    k(com.google.firebase.j jVar, n nVar, Rpc rpc, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this.a = jVar;
        this.f19643b = nVar;
        this.f19644c = rpc;
        this.f19645d = bVar;
        this.f19646e = bVar2;
        this.f19647f = iVar;
    }

    public k(com.google.firebase.j jVar, n nVar, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this(jVar, nVar, new Rpc(jVar.i()), bVar, bVar2, iVar);
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> b(Task<Bundle> task) {
        return task.g(b.a(), new Continuation(this) { // from class: com.google.firebase.iid.j
            private final k a;

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
            Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
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
        bundle.putString("gmsv", Integer.toString(this.f19643b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f19643b.a());
        bundle.putString("app_ver_name", this.f19643b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String b3 = ((com.google.firebase.installations.l) Tasks.a(this.f19647f.a(false))).b();
            if (!TextUtils.isEmpty(b3)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b3);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e2);
        }
        bundle.putString("cliv", "fiid-21.1.0");
        com.google.firebase.r.j jVar = this.f19646e.get();
        com.google.firebase.u.i iVar = this.f19645d.get();
        if (jVar != null && iVar != null && (b2 = jVar.b("fire-iid")) != j.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(b2.g()));
            bundle.putString("Firebase-Client", iVar.a());
        }
        return bundle;
    }

    private Task<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f19644c.a(bundle);
    }

    public Task<String> d(String str, String str2, String str3) {
        return b(i(str, str2, str3, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String g(Task task) throws Exception {
        return e((Bundle) task.k(IOException.class));
    }
}
