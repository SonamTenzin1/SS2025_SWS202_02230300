package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* renamed from: j, reason: collision with root package name */
    private static final a f11501j = new a();

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    private static int f11502k = b.a;

    /* loaded from: classes2.dex */
    private static class a implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private a() {
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount a(GoogleSignInResult googleSignInResult) {
            return googleSignInResult.a();
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    enum b {
        public static final int a = 1;

        /* renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ int[] f11503b = {1, 2, 3, 4};
    }
}
