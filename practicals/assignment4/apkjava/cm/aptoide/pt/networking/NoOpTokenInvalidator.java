package cm.aptoide.pt.networking;

import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;

/* loaded from: classes.dex */
public class NoOpTokenInvalidator implements TokenInvalidator {
    @Override // cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator
    public rx.b invalidateAccessToken() {
        return rx.b.e();
    }
}
