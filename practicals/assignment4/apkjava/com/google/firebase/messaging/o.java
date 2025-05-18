package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class o {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static b1 f19838b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f19839c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f19840d = h.f19820f;

    public o(Context context) {
        this.f19839c = context;
    }

    private static Task<Integer> a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        return b(context, "com.google.firebase.MESSAGING_EVENT").c(intent).g(k.f19825f, l.a);
    }

    private static b1 b(Context context, String str) {
        b1 b1Var;
        synchronized (a) {
            if (f19838b == null) {
                f19838b = new b1(context, "com.google.firebase.MESSAGING_EVENT");
            }
            b1Var = f19838b;
        }
        return b1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer c(Task task) throws Exception {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer e(Task task) throws Exception {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Task f(Context context, Intent intent, Task task) throws Exception {
        return (PlatformVersion.k() && ((Integer) task.j()).intValue() == 402) ? a(context, intent).g(m.f19831f, n.a) : task;
    }

    @KeepForSdk
    public Task<Integer> g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f19839c, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> h(final Context context, final Intent intent) {
        boolean z = false;
        if (PlatformVersion.k() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        int flags = intent.getFlags() & 268435456;
        if (z && flags == 0) {
            return a(context, intent);
        }
        return Tasks.c(this.f19840d, new Callable(context, intent) { // from class: com.google.firebase.messaging.i

            /* renamed from: f, reason: collision with root package name */
            private final Context f19821f;

            /* renamed from: g, reason: collision with root package name */
            private final Intent f19822g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f19821f = context;
                this.f19822g = intent;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(l0.b().g(this.f19821f, this.f19822g));
                return valueOf;
            }
        }).h(this.f19840d, new Continuation(context, intent) { // from class: com.google.firebase.messaging.j
            private final Context a;

            /* renamed from: b, reason: collision with root package name */
            private final Intent f19823b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = context;
                this.f19823b = intent;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task) {
                return o.f(this.a, this.f19823b, task);
            }
        });
    }
}
