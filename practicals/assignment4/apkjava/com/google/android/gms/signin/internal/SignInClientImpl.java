package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInOptions;

@KeepForSdk
/* loaded from: classes2.dex */
public class SignInClientImpl extends GmsClient<zaf> implements com.google.android.gms.signin.zad {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f18280d;

    /* renamed from: e, reason: collision with root package name */
    private final ClientSettings f18281e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f18282f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f18283g;

    private SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f18280d = true;
        this.f18281e = clientSettings;
        this.f18282f = bundle;
        this.f18283g = clientSettings.g();
    }

    @KeepForSdk
    public static Bundle j(ClientSettings clientSettings) {
        SignInOptions l = clientSettings.l();
        Integer g2 = clientSettings.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.b());
        if (g2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g2.intValue());
        }
        if (l != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", l.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", l.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", l.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", l.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", l.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", l.h());
            if (l.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", l.a().longValue());
            }
            if (l.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", l.c().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.signin.zad
    public final void a() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    @Override // com.google.android.gms.signin.zad
    public final void b(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) getService()).V2(iAccountAccessor, this.f18283g.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void c() {
        try {
            ((zaf) getService()).B1(this.f18283g.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zag(iBinder);
    }

    @Override // com.google.android.gms.signin.zad
    public final void d(zad zadVar) {
        Preconditions.l(zadVar, "Expecting a valid ISignInCallbacks");
        try {
            Account d2 = this.f18281e.d();
            ((zaf) getService()).n3(new zah(new ResolveAccountRequest(d2, this.f18283g.intValue(), BaseGmsClient.DEFAULT_ACCOUNT.equals(d2.name) ? Storage.b(getContext()).c() : null)), zadVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zadVar.w1(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f18281e.j())) {
            this.f18282f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f18281e.j());
        }
        return this.f18282f;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return this.f18280d;
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, clientSettings, j(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }
}
