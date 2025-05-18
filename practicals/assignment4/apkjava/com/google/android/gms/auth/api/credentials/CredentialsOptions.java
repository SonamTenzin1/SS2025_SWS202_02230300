package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

/* loaded from: classes2.dex */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {

    /* renamed from: i, reason: collision with root package name */
    public static final CredentialsOptions f11471i = (CredentialsOptions) new Builder().a();

    /* loaded from: classes2.dex */
    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CredentialsOptions a() {
            return new CredentialsOptions(this);
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
