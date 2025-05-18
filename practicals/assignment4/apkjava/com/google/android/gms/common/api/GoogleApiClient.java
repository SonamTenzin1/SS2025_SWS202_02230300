package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

@KeepForSdk
/* loaded from: classes2.dex */
public abstract class GoogleApiClient {
    private static final Set<GoogleApiClient> a = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Builder {
        private Account a;

        /* renamed from: d, reason: collision with root package name */
        private int f11675d;

        /* renamed from: e, reason: collision with root package name */
        private View f11676e;

        /* renamed from: f, reason: collision with root package name */
        private String f11677f;

        /* renamed from: g, reason: collision with root package name */
        private String f11678g;

        /* renamed from: j, reason: collision with root package name */
        private final Context f11681j;
        private LifecycleActivity l;
        private OnConnectionFailedListener n;
        private Looper o;

        /* renamed from: b, reason: collision with root package name */
        private final Set<Scope> f11673b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set<Scope> f11674c = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        private final Map<Api<?>, ClientSettings.OptionalApiSettings> f11679h = new c.e.a();

        /* renamed from: i, reason: collision with root package name */
        private boolean f11680i = false;

        /* renamed from: k, reason: collision with root package name */
        private final Map<Api<?>, Api.ApiOptions> f11682k = new c.e.a();
        private int m = -1;
        private GoogleApiAvailability p = GoogleApiAvailability.q();
        private Api.AbstractClientBuilder<? extends zad, SignInOptions> q = zaa.f18293c;
        private final ArrayList<ConnectionCallbacks> r = new ArrayList<>();
        private final ArrayList<OnConnectionFailedListener> s = new ArrayList<>();
        private boolean t = false;

        @KeepForSdk
        public Builder(Context context) {
            this.f11681j = context;
            this.o = context.getMainLooper();
            this.f11677f = context.getPackageName();
            this.f11678g = context.getClass().getName();
        }

        public final Builder a(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.l(api, "Api must not be null");
            this.f11682k.put(api, null);
            List<Scope> a = api.c().a(null);
            this.f11674c.addAll(a);
            this.f11673b.addAll(a);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder b(Api<O> api, O o) {
            Preconditions.l(api, "Api must not be null");
            Preconditions.l(o, "Null options are not permitted for this Api");
            this.f11682k.put(api, o);
            List<Scope> a = api.c().a(o);
            this.f11674c.addAll(a);
            this.f11673b.addAll(a);
            return this;
        }

        public final Builder c(ConnectionCallbacks connectionCallbacks) {
            Preconditions.l(connectionCallbacks, "Listener must not be null");
            this.r.add(connectionCallbacks);
            return this;
        }

        public final Builder d(OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.l(onConnectionFailedListener, "Listener must not be null");
            this.s.add(onConnectionFailedListener);
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [com.google.android.gms.common.api.Api$Client, java.lang.Object] */
        public final GoogleApiClient e() {
            Preconditions.b(!this.f11682k.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings f2 = f();
            Api<?> api = null;
            Map<Api<?>, ClientSettings.OptionalApiSettings> h2 = f2.h();
            c.e.a aVar = new c.e.a();
            c.e.a aVar2 = new c.e.a();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api<?> api2 : this.f11682k.keySet()) {
                Api.ApiOptions apiOptions = this.f11682k.get(api2);
                boolean z2 = h2.get(api2) != null;
                aVar.put(api2, Boolean.valueOf(z2));
                zaq zaqVar = new zaq(api2, z2);
                arrayList.add(zaqVar);
                Api.AbstractClientBuilder<?, ?> d2 = api2.d();
                ?? c2 = d2.c(this.f11681j, this.o, f2, apiOptions, zaqVar, zaqVar);
                aVar2.put(api2.a(), c2);
                if (d2.b() == 1) {
                    z = apiOptions != null;
                }
                if (c2.providesSignIn()) {
                    if (api != null) {
                        String b2 = api2.b();
                        String b3 = api.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 21 + String.valueOf(b3).length());
                        sb.append(b2);
                        sb.append(" cannot be used with ");
                        sb.append(b3);
                        throw new IllegalStateException(sb.toString());
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.p(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.b());
                    Preconditions.p(this.f11673b.equals(this.f11674c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.b());
                } else {
                    String b4 = api.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 82);
                    sb2.append("With using ");
                    sb2.append(b4);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            zaaw zaawVar = new zaaw(this.f11681j, new ReentrantLock(), this.o, f2, this.p, this.q, aVar, this.r, this.s, aVar2, this.m, zaaw.y(aVar2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.a) {
                GoogleApiClient.a.add(zaawVar);
            }
            if (this.m >= 0) {
                zaj.p(this.l).r(this.m, zaawVar, this.n);
            }
            return zaawVar;
        }

        @VisibleForTesting
        @KeepForSdk
        public final ClientSettings f() {
            SignInOptions signInOptions = SignInOptions.f18274f;
            Map<Api<?>, Api.ApiOptions> map = this.f11682k;
            Api<SignInOptions> api = zaa.f18297g;
            if (map.containsKey(api)) {
                signInOptions = (SignInOptions) this.f11682k.get(api);
            }
            return new ClientSettings(this.a, this.f11673b, this.f11679h, this.f11675d, this.f11676e, this.f11677f, this.f11678g, signInOptions, false);
        }

        public final Builder g(Handler handler) {
            Preconditions.l(handler, "Handler must not be null");
            this.o = handler.getLooper();
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface ConnectionCallbacks {
        void H(int i2);

        void P(Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public interface OnConnectionFailedListener {
        void E0(ConnectionResult connectionResult);
    }

    @KeepForSdk
    public static Set<GoogleApiClient> l() {
        Set<GoogleApiClient> set = a;
        synchronized (set) {
        }
        return set;
    }

    public abstract ConnectionResult d();

    public abstract PendingResult<Status> e();

    public abstract void f();

    public void g(int i2) {
        throw new UnsupportedOperationException();
    }

    public abstract void h();

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T j(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T k(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <C extends Api.Client> C m(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Context n() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper o() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean p();

    @KeepForSdk
    public boolean q(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void r() {
        throw new UnsupportedOperationException();
    }

    public abstract void s();

    public abstract void t(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void u(OnConnectionFailedListener onConnectionFailedListener);

    public void v(zacm zacmVar) {
        throw new UnsupportedOperationException();
    }
}
