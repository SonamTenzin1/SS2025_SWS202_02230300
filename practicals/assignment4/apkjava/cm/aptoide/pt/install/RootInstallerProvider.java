package cm.aptoide.pt.install;

import android.os.Build;
import cm.aptoide.pt.install.installer.Installation;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import cm.aptoide.pt.install.installer.RootInstaller;
import java.io.File;
import rx.e;

/* loaded from: classes.dex */
public class RootInstallerProvider {
    private InstallerAnalytics installerAnalytics;
    private final String packageName;

    public RootInstallerProvider(InstallerAnalytics installerAnalytics, String str) {
        this.installerAnalytics = installerAnalytics;
        this.packageName = str;
    }

    private String getRootInstallCommand(Installation installation) {
        File file = installation.getFile();
        if (Build.VERSION.SDK_INT >= 28) {
            return "cat " + file.getAbsolutePath() + " | pm install -S " + file.length();
        }
        return "pm install -r " + file.getAbsolutePath();
    }

    public e.a<Void> provideRootInstaller(Installation installation) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RootInstaller(this.packageName, this.installerAnalytics, installation);
        }
        return new RootCommandOnSubscribe(installation.getId().hashCode(), getRootInstallCommand(installation), this.installerAnalytics);
    }
}
