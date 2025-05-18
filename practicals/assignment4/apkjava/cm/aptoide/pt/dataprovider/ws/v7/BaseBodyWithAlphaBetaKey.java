package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;

/* loaded from: classes.dex */
public class BaseBodyWithAlphaBetaKey extends BaseBody {
    private String notApkTags;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBodyWithAlphaBetaKey(SharedPreferences sharedPreferences) {
        if (ManagerPreferences.getUpdatesFilterAlphaBetaKey(sharedPreferences)) {
            this.notApkTags = "alpha,beta";
        }
    }

    public String getNotApkTags() {
        return this.notApkTags;
    }

    public boolean shouldIncludeTag() {
        return true;
    }
}
