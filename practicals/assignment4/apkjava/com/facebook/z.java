package com.facebook;

/* compiled from: FacebookCallback.kt */
/* loaded from: classes.dex */
public interface z<RESULT> {
    void onCancel();

    void onError(FacebookException facebookException);

    void onSuccess(RESULT result);
}
