package cm.aptoide.pt.preferences;

import android.content.pm.PackageManager;
import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.preferences.managed.ManagedKeys;
import cm.aptoide.pt.utils.AptoideUtils;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class AptoideMd5Manager {
    private String cachedMd5;
    private PackageManager packageManager;
    private String packageName;
    private PreferencesPersister preferencesPersister;
    private int vercode;

    public AptoideMd5Manager(PreferencesPersister preferencesPersister, PackageManager packageManager, String str, int i2) {
        this.preferencesPersister = preferencesPersister;
        this.packageManager = packageManager;
        this.packageName = str;
        this.vercode = i2;
    }

    private String parseMd5(String str, int i2) {
        if (str == null || str.isEmpty()) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String[] split = str.split("_", 2);
        try {
            return (split.length == 2 && Integer.parseInt(split[0]) == i2) ? split[1] : HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (NumberFormatException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private void persistAptoideMd5(int i2, String str) {
        this.preferencesPersister.save(ManagedKeys.APTOIDE_MD5, i2 + "_" + str);
    }

    public Void calculateMd5Sum() {
        if (this.cachedMd5 != null) {
            return null;
        }
        String parseMd5 = parseMd5(this.preferencesPersister.get(ManagedKeys.APTOIDE_MD5, HttpUrl.FRAGMENT_ENCODE_SET), this.vercode);
        if (!parseMd5.isEmpty()) {
            this.cachedMd5 = parseMd5;
            return null;
        }
        try {
            String computeMd5 = AptoideUtils.AlgorithmU.computeMd5(this.packageManager.getPackageInfo(this.packageName, 0));
            this.cachedMd5 = computeMd5;
            persistAptoideMd5(this.vercode, computeMd5);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public String getAptoideMd5() {
        String str = this.cachedMd5;
        return str != null ? str : parseMd5(this.preferencesPersister.get(ManagedKeys.APTOIDE_MD5, HttpUrl.FRAGMENT_ENCODE_SET), this.vercode);
    }
}
