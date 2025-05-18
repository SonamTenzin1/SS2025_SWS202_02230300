package cm.aptoide.pt.install.installer;

import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.exception.InstallationException;
import cm.aptoide.pt.logger.Logger;
import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.e;

/* loaded from: classes.dex */
public class RootInstaller implements e.a<Void> {
    private static final String TAG = "RootInstaller";
    private final InstallerAnalytics analytics;
    private Installation installation;
    private final String packageName;
    private Root root = new Root();

    public RootInstaller(String str, InstallerAnalytics installerAnalytics, Installation installation) {
        this.packageName = str;
        this.analytics = installerAnalytics;
        this.installation = installation;
    }

    private int getFilesSize(Installation installation) {
        int i2 = 0;
        for (RoomFileToDownload roomFileToDownload : installation.getFiles()) {
            i2 = (int) (i2 + new File(roomFileToDownload.getPath() + roomFileToDownload.getFileName()).length());
        }
        return i2;
    }

    @Override // rx.m.b
    public void call(rx.j<? super Void> jVar) {
        Logger.getInstance().d(TAG, "call: start with installation package name: " + this.installation.getPackageName());
        this.analytics.rootInstallStart();
        if (this.root.isTerminated() || !this.root.isAcquired()) {
            Root.requestRoot();
            if (!this.root.isAcquired()) {
                Logger.getInstance().d(TAG, "root is not available");
                jVar.onError(new InstallationException("No root permissions"));
                return;
            }
        }
        String exec = this.root.exec(String.format(Locale.getDefault(), "pm install-create -i " + this.packageName + " --user %s -r -S %d", "0", Integer.valueOf(getFilesSize(this.installation))));
        if (exec != null && exec.length() != 0) {
            Matcher matcher = Pattern.compile("(\\d+)").matcher(exec);
            matcher.find();
            int parseInt = Integer.parseInt(matcher.group(1));
            for (RoomFileToDownload roomFileToDownload : this.installation.getFiles()) {
                Logger.getInstance().d(TAG, "started instalation of file: " + roomFileToDownload.getFileName());
                File file = new File(roomFileToDownload.getPath() + roomFileToDownload.getFileName());
                String exec2 = this.root.exec(String.format(Locale.getDefault(), "cat \"%s\" | pm install-write -S %d %d \"%s\"", file.getAbsolutePath(), Long.valueOf(file.length()), Integer.valueOf(parseInt), file.getName()));
                if (exec2 == null || exec2.length() == 0) {
                    InstallationException installationException = new InstallationException(this.root.readError());
                    this.analytics.rootInstallFail(installationException);
                    jVar.onError(installationException);
                    return;
                }
            }
            String exec3 = this.root.exec(String.format(Locale.getDefault(), "pm install-commit %d ", Integer.valueOf(parseInt)));
            if (exec3 != null && exec3.length() != 0) {
                if (exec3.toLowerCase().contains(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    this.analytics.rootInstallCompleted(0);
                    jVar.onCompleted();
                    return;
                }
                InstallationException installationException2 = new InstallationException(this.root.readError());
                this.analytics.rootInstallFail(installationException2);
                jVar.onError(installationException2);
                return;
            }
            InstallationException installationException3 = new InstallationException(this.root.readError());
            this.analytics.rootInstallFail(installationException3);
            jVar.onError(installationException3);
            return;
        }
        InstallationException installationException4 = new InstallationException(this.root.readError());
        this.analytics.rootInstallFail(installationException4);
        jVar.onError(installationException4);
    }
}
