package com.facebook;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: FacebookGraphResponseException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "Lcom/facebook/d0;", "g", "Lcom/facebook/d0;", "getGraphResponse", "()Lcom/facebook/d0;", "graphResponse", "errorMessage", "<init>", "(Lcom/facebook/d0;Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FacebookGraphResponseException extends FacebookException {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final d0 graphResponse;

    public FacebookGraphResponseException(d0 d0Var, String str) {
        super(str);
        this.graphResponse = d0Var;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public String toString() {
        d0 d0Var = this.graphResponse;
        FacebookRequestError b2 = d0Var == null ? null : d0Var.b();
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (b2 != null) {
            sb.append("httpResponseCode: ");
            sb.append(b2.f());
            sb.append(", facebookErrorCode: ");
            sb.append(b2.b());
            sb.append(", facebookErrorType: ");
            sb.append(b2.d());
            sb.append(", message: ");
            sb.append(b2.c());
            sb.append("}");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.e(sb2, "errorStringBuilder.toString()");
        return sb2;
    }
}
