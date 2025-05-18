package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.k0;
import com.facebook.login.LoginClient;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: KatanaProxyLoginMethodHandler.kt */
/* loaded from: classes2.dex */
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {

    /* renamed from: k, reason: collision with root package name */
    private final String f9959k;

    /* renamed from: j, reason: collision with root package name */
    public static final b f9958j = new b(null);
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new a();

    /* compiled from: KatanaProxyLoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<KatanaProxyLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KatanaProxyLoginMethodHandler[] newArray(int i2) {
            return new KatanaProxyLoginMethodHandler[i2];
        }
    }

    /* compiled from: KatanaProxyLoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9959k = "katana_proxy_auth";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.f9959k;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean n() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    @Override // com.facebook.login.LoginMethodHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int o(LoginClient.Request request) {
        boolean z;
        r g2;
        Iterator<Intent> it;
        kotlin.jvm.internal.m.f(request, "request");
        t j2 = request.j();
        if (com.facebook.a0.r) {
            com.facebook.internal.v vVar = com.facebook.internal.v.a;
            if (com.facebook.internal.v.a() != null && j2.k()) {
                z = true;
                String a2 = LoginClient.f9960f.a();
                k0 k0Var = k0.a;
                androidx.fragment.app.d i2 = d().i();
                String a3 = request.a();
                Set<String> n = request.n();
                boolean s = request.s();
                boolean p = request.p();
                g2 = request.g();
                if (g2 == null) {
                    g2 = r.NONE;
                }
                r rVar = g2;
                String c2 = c(request.b());
                String c3 = request.c();
                String l = request.l();
                boolean o = request.o();
                boolean q = request.q();
                boolean z2 = request.z();
                String m = request.m();
                String d2 = request.d();
                p e2 = request.e();
                List<Intent> m2 = k0.m(i2, a3, n, a2, s, p, rVar, c2, c3, z, l, o, q, z2, m, d2, e2 != null ? null : e2.name());
                a("e2e", a2);
                it = m2.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3++;
                    if (B(it.next(), LoginClient.f9960f.b())) {
                        return i3;
                    }
                }
                return 0;
            }
        }
        z = false;
        String a22 = LoginClient.f9960f.a();
        k0 k0Var2 = k0.a;
        androidx.fragment.app.d i22 = d().i();
        String a32 = request.a();
        Set<String> n2 = request.n();
        boolean s2 = request.s();
        boolean p2 = request.p();
        g2 = request.g();
        if (g2 == null) {
        }
        r rVar2 = g2;
        String c22 = c(request.b());
        String c32 = request.c();
        String l2 = request.l();
        boolean o2 = request.o();
        boolean q2 = request.q();
        boolean z22 = request.z();
        String m3 = request.m();
        String d22 = request.d();
        p e22 = request.e();
        List<Intent> m22 = k0.m(i22, a32, n2, a22, s2, p2, rVar2, c22, c32, z, l2, o2, q2, z22, m3, d22, e22 != null ? null : e22.name());
        a("e2e", a22);
        it = m22.iterator();
        int i32 = 0;
        while (it.hasNext()) {
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9959k = "katana_proxy_auth";
    }
}
