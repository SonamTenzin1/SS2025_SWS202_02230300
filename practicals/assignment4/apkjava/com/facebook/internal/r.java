package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Set;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

/* compiled from: BoltsMeasurementEventListener.kt */
/* loaded from: classes2.dex */
public final class r extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static r f9838b;

    /* renamed from: d, reason: collision with root package name */
    private final Context f9840d;
    public static final a a = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f9839c = "com.parse.bolts.measurement_event";

    /* compiled from: BoltsMeasurementEventListener.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final r a(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            if (r.f9838b != null) {
                return r.f9838b;
            }
            r rVar = new r(context, null);
            rVar.e();
            r.f9838b = rVar;
            return r.f9838b;
        }
    }

    private r(Context context) {
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.m.e(applicationContext, "context.applicationContext");
        this.f9840d = applicationContext;
    }

    public /* synthetic */ r(Context context, kotlin.jvm.internal.g gVar) {
        this(context);
    }

    private final void d() {
        c.q.a.a b2 = c.q.a.a.b(this.f9840d);
        kotlin.jvm.internal.m.e(b2, "getInstance(applicationContext)");
        b2.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        c.q.a.a b2 = c.q.a.a.b(this.f9840d);
        kotlin.jvm.internal.m.e(b2, "getInstance(applicationContext)");
        b2.c(this, new IntentFilter(f9839c));
    }

    public final void finalize() throws Throwable {
        d();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.facebook.o0.g0 g0Var = new com.facebook.o0.g0(context);
        String n = kotlin.jvm.internal.m.n("bf_", intent == null ? null : intent.getStringExtra("event_name"));
        Bundle bundleExtra = intent == null ? null : intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        Set<String> keySet = bundleExtra != null ? bundleExtra.keySet() : null;
        if (keySet != null) {
            for (String str : keySet) {
                kotlin.jvm.internal.m.e(str, RoomNotification.KEY);
                bundle.putString(new Regex("[ -]*$").c(new Regex("^[ -]*").c(new Regex("[^0-9a-zA-Z _-]").c(str, "-"), HttpUrl.FRAGMENT_ENCODE_SET), HttpUrl.FRAGMENT_ENCODE_SET), (String) bundleExtra.get(str));
            }
        }
        g0Var.d(n, bundle);
    }
}
