package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface GoogleSignInApi {
    Intent a(GoogleApiClient googleApiClient);

    GoogleSignInResult b(Intent intent);

    PendingResult<Status> c(GoogleApiClient googleApiClient);

    PendingResult<Status> d(GoogleApiClient googleApiClient);
}
