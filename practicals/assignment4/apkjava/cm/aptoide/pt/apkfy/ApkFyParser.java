package cm.aptoide.pt.apkfy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* compiled from: ApkFyParser.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcm/aptoide/pt/apkfy/ApkFyParser;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "securePreferences", "Landroid/content/SharedPreferences;", "apkfyManager", "Lcm/aptoide/pt/apkfy/ApkfyManager;", "firstLaunchAnalytics", "Lcm/aptoide/pt/analytics/FirstLaunchAnalytics;", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/SharedPreferences;Lcm/aptoide/pt/apkfy/ApkfyManager;Lcm/aptoide/pt/analytics/FirstLaunchAnalytics;)V", "run", HttpUrl.FRAGMENT_ENCODE_SET, "saveGuestUID", "guestUid", HttpUrl.FRAGMENT_ENCODE_SET, "setApkfyUtmProperties", "apkfyModel", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "updateApkfy", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ApkFyParser {
    public static final String APKFY_PACKAGE_APKFY_NO_UTM = "APKFY_BUT_NO_UTM";
    public static final String APKFY_PACKAGE_NO_APKFY = "NO_APKFY";
    public static final String APKFY_PACKAGE_NO_APP = "APKFY_BUT_NO_APP";
    public static final String MMP_GUEST_UID = "MMP_GUEST_UID";
    private final ApkfyManager apkfyManager;
    private final Context context;
    private final FirstLaunchAnalytics firstLaunchAnalytics;
    private final Intent intent;
    private final SharedPreferences securePreferences;

    public ApkFyParser(Context context, Intent intent, SharedPreferences sharedPreferences, ApkfyManager apkfyManager, FirstLaunchAnalytics firstLaunchAnalytics) {
        m.f(context, "context");
        m.f(intent, "intent");
        m.f(sharedPreferences, "securePreferences");
        m.f(apkfyManager, "apkfyManager");
        m.f(firstLaunchAnalytics, "firstLaunchAnalytics");
        this.context = context;
        this.intent = intent;
        this.securePreferences = sharedPreferences;
        this.apkfyManager = apkfyManager;
        this.firstLaunchAnalytics = firstLaunchAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveGuestUID(String guestUid) {
        this.securePreferences.edit().putString(MMP_GUEST_UID, guestUid).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r1 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r1 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setApkfyUtmProperties(ApkfyModel apkfyModel) {
        boolean t;
        boolean t2;
        boolean z = false;
        if (apkfyModel.hasUTMs()) {
            String packageName = apkfyModel.getPackageName();
            if (packageName != null) {
                t2 = u.t(packageName);
            }
            z = true;
            if (z && apkfyModel.getAppId() == null) {
                this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), APKFY_PACKAGE_NO_APP);
                return;
            } else {
                this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), apkfyModel.getPackageName());
                return;
            }
        }
        String packageName2 = apkfyModel.getPackageName();
        if (packageName2 != null) {
            t = u.t(packageName2);
        }
        z = true;
        if (z && apkfyModel.getAppId() == null) {
            this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY);
        } else {
            this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), APKFY_PACKAGE_APKFY_NO_UTM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r0 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        if (r0 != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateApkfy(ApkfyModel apkfyModel) {
        boolean z;
        boolean J;
        boolean z2;
        boolean t;
        boolean t2;
        boolean t3;
        boolean t4;
        String packageName = apkfyModel.getPackageName();
        boolean z3 = false;
        if (packageName != null) {
            t4 = u.t(packageName);
            if (!t4) {
                z = false;
                if (!z) {
                    return;
                }
                J = v.J(apkfyModel.getPackageName(), "cm.aptoide.pt", false, 2, null);
                if (J) {
                    return;
                }
                if (apkfyModel.getAppId() != null) {
                    this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT, true);
                    this.intent.putExtra("appId", apkfyModel.getAppId().longValue());
                    String oemId = apkfyModel.getOemId();
                    if (oemId != null) {
                        t3 = u.t(oemId);
                    }
                    z3 = true;
                    if (!z3) {
                        this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY, apkfyModel.getOemId());
                    }
                    this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, true);
                    SecurePreferences.setApkFyRun(this.securePreferences);
                    this.context.startActivity(this.intent);
                    return;
                }
                String packageName2 = apkfyModel.getPackageName();
                if (packageName2 != null) {
                    t2 = u.t(packageName2);
                    if (!t2) {
                        z2 = false;
                        if (z2) {
                            this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT, true);
                            this.intent.putExtra("packageName", apkfyModel.getPackageName());
                            String oemId2 = apkfyModel.getOemId();
                            if (oemId2 != null) {
                                t = u.t(oemId2);
                            }
                            z3 = true;
                            if (!z3) {
                                this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY, apkfyModel.getOemId());
                            }
                            this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, true);
                            SecurePreferences.setApkFyRun(this.securePreferences);
                            this.context.startActivity(this.intent);
                            return;
                        }
                        return;
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final void run() {
        j.b(p0.a(Dispatchers.c()), null, null, new ApkFyParser$run$1(this, null), 3, null);
    }
}
