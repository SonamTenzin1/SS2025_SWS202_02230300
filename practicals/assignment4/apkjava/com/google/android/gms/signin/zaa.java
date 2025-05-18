package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* loaded from: classes2.dex */
public final class zaa {
    private static final Api.ClientKey<SignInClientImpl> a;

    /* renamed from: b, reason: collision with root package name */
    @ShowFirstParty
    private static final Api.ClientKey<SignInClientImpl> f18292b;

    /* renamed from: c, reason: collision with root package name */
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> f18293c;

    /* renamed from: d, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<SignInClientImpl, Object> f18294d;

    /* renamed from: e, reason: collision with root package name */
    private static final Scope f18295e;

    /* renamed from: f, reason: collision with root package name */
    private static final Scope f18296f;

    /* renamed from: g, reason: collision with root package name */
    public static final Api<SignInOptions> f18297g;

    /* renamed from: h, reason: collision with root package name */
    private static final Api<Object> f18298h;

    static {
        Api.ClientKey<SignInClientImpl> clientKey = new Api.ClientKey<>();
        a = clientKey;
        Api.ClientKey<SignInClientImpl> clientKey2 = new Api.ClientKey<>();
        f18292b = clientKey2;
        a aVar = new a();
        f18293c = aVar;
        b bVar = new b();
        f18294d = bVar;
        f18295e = new Scope("profile");
        f18296f = new Scope("email");
        f18297g = new Api<>("SignIn.API", aVar, clientKey);
        f18298h = new Api<>("SignIn.INTERNAL_API", bVar, clientKey2);
    }
}
