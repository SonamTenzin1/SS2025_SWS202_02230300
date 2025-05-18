package cm.aptoide.pt.account.view;

import cm.aptoide.pt.presenter.View;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public interface GooglePlayServicesView extends View {
    void showConnectionError(ConnectionResult connectionResult);
}
