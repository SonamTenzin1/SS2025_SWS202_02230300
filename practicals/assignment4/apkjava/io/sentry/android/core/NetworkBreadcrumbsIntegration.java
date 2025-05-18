package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class NetworkBreadcrumbsIntegration implements Integration, Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final Context f22049f;

    /* renamed from: g, reason: collision with root package name */
    private final s0 f22050g;

    /* renamed from: h, reason: collision with root package name */
    private final w1 f22051h;

    /* renamed from: i, reason: collision with root package name */
    b f22052i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        final int a;

        /* renamed from: b, reason: collision with root package name */
        final int f22053b;

        /* renamed from: c, reason: collision with root package name */
        final int f22054c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f22055d;

        /* renamed from: e, reason: collision with root package name */
        final String f22056e;

        @SuppressLint({"NewApi", "ObsoleteSdkInt"})
        a(NetworkCapabilities networkCapabilities, s0 s0Var) {
            io.sentry.util.q.c(networkCapabilities, "NetworkCapabilities is required");
            io.sentry.util.q.c(s0Var, "BuildInfoProvider is required");
            this.a = networkCapabilities.getLinkDownstreamBandwidthKbps();
            this.f22053b = networkCapabilities.getLinkUpstreamBandwidthKbps();
            int signalStrength = s0Var.d() >= 29 ? networkCapabilities.getSignalStrength() : 0;
            this.f22054c = signalStrength > -100 ? signalStrength : 0;
            this.f22055d = networkCapabilities.hasTransport(4);
            String d2 = io.sentry.android.core.internal.util.k.d(networkCapabilities, s0Var);
            this.f22056e = d2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : d2;
        }

        boolean a(a aVar) {
            if (this.f22055d == aVar.f22055d && this.f22056e.equals(aVar.f22056e)) {
                int i2 = this.f22054c;
                int i3 = aVar.f22054c;
                if (-5 <= i2 - i3 && i2 - i3 <= 5) {
                    int i4 = this.a;
                    int i5 = aVar.a;
                    if (-1000 <= i4 - i5 && i4 - i5 <= 1000) {
                        int i6 = this.f22053b;
                        int i7 = aVar.f22053b;
                        if (-1000 <= i6 - i7 && i6 - i7 <= 1000) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* loaded from: classes2.dex */
    static final class b extends ConnectivityManager.NetworkCallback {
        final v1 a;

        /* renamed from: b, reason: collision with root package name */
        final s0 f22057b;

        /* renamed from: c, reason: collision with root package name */
        Network f22058c = null;

        /* renamed from: d, reason: collision with root package name */
        NetworkCapabilities f22059d = null;

        b(v1 v1Var, s0 s0Var) {
            this.a = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
            this.f22057b = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required");
        }

        private io.sentry.v0 a(String str) {
            io.sentry.v0 v0Var = new io.sentry.v0();
            v0Var.p("system");
            v0Var.l("network.event");
            v0Var.m("action", str);
            v0Var.n(s4.INFO);
            return v0Var;
        }

        private a b(NetworkCapabilities networkCapabilities, NetworkCapabilities networkCapabilities2) {
            if (networkCapabilities == null) {
                return new a(networkCapabilities2, this.f22057b);
            }
            a aVar = new a(networkCapabilities, this.f22057b);
            a aVar2 = new a(networkCapabilities2, this.f22057b);
            if (aVar2.a(aVar)) {
                return null;
            }
            return aVar2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network.equals(this.f22058c)) {
                return;
            }
            this.a.i(a("NETWORK_AVAILABLE"));
            this.f22058c = network;
            this.f22059d = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            a b2;
            if (network.equals(this.f22058c) && (b2 = b(this.f22059d, networkCapabilities)) != null) {
                this.f22059d = networkCapabilities;
                io.sentry.v0 a = a("NETWORK_CAPABILITIES_CHANGED");
                a.m("download_bandwidth", Integer.valueOf(b2.a));
                a.m("upload_bandwidth", Integer.valueOf(b2.f22053b));
                a.m("vpn_active", Boolean.valueOf(b2.f22055d));
                a.m("network_type", b2.f22056e);
                int i2 = b2.f22054c;
                if (i2 != 0) {
                    a.m("signal_strength", Integer.valueOf(i2));
                }
                n1 n1Var = new n1();
                n1Var.j("android:networkCapabilities", b2);
                this.a.n(a, n1Var);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (network.equals(this.f22058c)) {
                this.a.i(a("NETWORK_LOST"));
                this.f22058c = null;
                this.f22059d = null;
            }
        }
    }

    public NetworkBreadcrumbsIntegration(Context context, s0 s0Var, w1 w1Var) {
        this.f22049f = (Context) io.sentry.util.q.c(context, "Context is required");
        this.f22050g = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required");
        this.f22051h = (w1) io.sentry.util.q.c(w1Var, "ILogger is required");
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    @SuppressLint({"NewApi"})
    public void c(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        w1 w1Var = this.f22051h;
        s4 s4Var = s4.DEBUG;
        w1Var.c(s4Var, "NetworkBreadcrumbsIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
        if (sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()) {
            if (this.f22050g.d() < 21) {
                this.f22052i = null;
                this.f22051h.c(s4Var, "NetworkBreadcrumbsIntegration requires Android 5+", new Object[0]);
                return;
            }
            b bVar = new b(v1Var, this.f22050g);
            this.f22052i = bVar;
            if (!io.sentry.android.core.internal.util.k.f(this.f22049f, this.f22051h, this.f22050g, bVar)) {
                this.f22052i = null;
                this.f22051h.c(s4Var, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
            } else {
                this.f22051h.c(s4Var, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
                a();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b bVar = this.f22052i;
        if (bVar != null) {
            io.sentry.android.core.internal.util.k.g(this.f22049f, this.f22051h, this.f22050g, bVar);
            this.f22051h.c(s4.DEBUG, "NetworkBreadcrumbsIntegration remove.", new Object[0]);
        }
        this.f22052i = null;
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }
}
