package cm.aptoide.pt.toolbox;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import cm.aptoide.pt.account.FacebookSignUpAdapter;
import cm.aptoide.pt.account.GoogleSignUpAdapter;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.Authentication;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.preferences.toolbox.ToolboxKeys;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

/* loaded from: classes.dex */
public class ToolboxContentProvider extends ContentProvider {
    private static final String BACKUP_PACKAGE = "pt.aptoide.backupapps";
    private static final int CHANGE_PREFERENCE = 6;
    private static final int LOGIN_AVATAR = 9;
    private static final int LOGIN_NAME = 5;
    private static final int LOGIN_NICKNAME = 8;
    private static final int LOGIN_TYPE = 4;
    private static final int PASSHASH = 3;
    private static final int REFRESH_TOKEN = 7;
    private static final int REPO = 2;
    private static final int TOKEN = 1;
    private static final String UPLOADER_PACKAGE = "pt.caixamagica.aptoide.uploader";

    @Inject
    AptoideAccountManager accountManager;

    @Inject
    AuthenticationPersistence authenticationPersistence;
    private ToolboxSecurityManager securityManager;

    @Inject
    @Named
    SharedPreferences sharedPreferences;
    private UriMatcher uriMatcher;

    private MatrixCursor create(String str, String str2) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str}, 1);
        matrixCursor.addRow(new String[]{str2});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.securityManager = new ToolboxSecurityManager(getContext().getPackageManager());
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "token", 1);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "refreshToken", 7);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "repo", 2);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "loginType", 4);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "passHash", 3);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "loginName", 5);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "changePreference", 6);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "loginNickname", 8);
        this.uriMatcher.addURI(BuildConfig.CONTENT_AUTHORITY, "loginAvatar", 9);
        ((AptoideApplication) getContext().getApplicationContext()).getApplicationComponent().inject(this);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!this.securityManager.checkSignature(Binder.getCallingUid(), BuildConfig.SIGNATURE_BACKUP, BACKUP_PACKAGE) && !this.securityManager.checkSignature(Binder.getCallingUid(), BuildConfig.SIGNATURE_UPLOADER, UPLOADER_PACKAGE)) {
            throw new SecurityException("Package not authorized to access provider.");
        }
        Authentication b2 = this.authenticationPersistence.getAuthentication().r(null).y().b();
        Account b3 = this.accountManager.accountStatus().W0().b();
        if (b2 != null && b3 != null) {
            switch (this.uriMatcher.match(uri)) {
                case 1:
                    return create("userToken", b2.getAccessToken());
                case 2:
                    return create(AndroidAccountManagerPersistence.ACCOUNT_STORE_NAME, b3.getStore().getName());
                case 3:
                    if (AptoideAccountManager.APTOIDE_SIGN_UP_TYPE.equals(b2.getType())) {
                        return create("userPass", AptoideUtils.AlgorithmU.computeSha1(b2.getPassword()));
                    }
                    if (FacebookSignUpAdapter.TYPE.equals(b2.getType()) || GoogleSignUpAdapter.TYPE.equals(b2.getType())) {
                        return create("userPass", b2.getPassword());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    return create("loginName", b2.getEmail());
                case 6:
                default:
                    throw new IllegalArgumentException("Only /token, /refreshToken, /repo, /passHash, /loginType, /loginName, loginNickname and loginAvatar supported.");
                case 7:
                    return create("userRefreshToken", b2.getRefreshToken());
                case 8:
                    return create("loginNickname", b3.getNickname());
                case 9:
                    return create("loginAvatar", b3.getAvatar());
            }
            return create("loginType", b2.getType().toLowerCase(Locale.US));
        }
        throw new IllegalStateException("User not logged in.");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x015a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003c A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i2 = 0;
        try {
            int callingUid = Binder.getCallingUid();
            final Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String str2 = packageManager.getPackagesForUid(callingUid)[0];
            Log.d("AptoideDebug", "Someone is trying to update preferences");
            if (packageManager.checkSignatures(str2, context.getPackageName()) == 0) {
                if (this.uriMatcher.match(uri) != 6) {
                    return 0;
                }
                SharedPreferences.Editor edit = this.sharedPreferences.edit();
                for (final Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        if (!ToolboxManager.isDebug(this.sharedPreferences)) {
                            AptoideUtils.ThreadU.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.toolbox.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Toast.makeText(context, "Please enable debug mode for toolbox to work.", 1).show();
                                }
                            });
                        }
                        if (entry.getKey().equals(ToolboxKeys.FORCE_COUNTRY)) {
                            ToolboxManager.setForceCountry((String) value, this.sharedPreferences);
                        } else if (entry.getKey().equals("notificationtype")) {
                            ToolboxManager.setNotificationType((String) value, this.sharedPreferences);
                        } else if (entry.getKey().equals("pullNotificationAction")) {
                            Intent intent = new Intent(context, (Class<?>) PullingContentService.class);
                            intent.setAction(PullingContentService.PUSH_NOTIFICATIONS_ACTION);
                            context.startService(intent);
                        } else {
                            if (entry.getKey().equals("UpdatesAction")) {
                                Intent intent2 = new Intent(context, (Class<?>) PullingContentService.class);
                                intent2.setAction(PullingContentService.UPDATES_ACTION);
                                context.startService(intent2);
                            }
                            if (i2 > 0 && !TextUtils.isEmpty(entry.getValue().toString())) {
                                AptoideUtils.ThreadU.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.toolbox.a
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Toast.makeText(context, "Preference set: " + ((String) r1.getKey()) + "=" + entry.getValue(), 1).show();
                                    }
                                });
                            }
                        }
                        i2++;
                        if (i2 > 0) {
                            AptoideUtils.ThreadU.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.toolbox.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Toast.makeText(context, "Preference set: " + ((String) r1.getKey()) + "=" + entry.getValue(), 1).show();
                                }
                            });
                        }
                    } else if (value instanceof Boolean) {
                        if (entry.getKey().equals("debugmode")) {
                            ToolboxManager.setDebug(((Boolean) entry.getValue()).booleanValue(), this.sharedPreferences);
                            Logger.setDBG(((Boolean) entry.getValue()).booleanValue());
                            i2++;
                        }
                        if (entry.getKey().equals(ToolboxKeys.TOOLBOX_ENABLE_HTTP_SCHEME)) {
                            ToolboxManager.setToolboxEnableHttpScheme(((Boolean) entry.getValue()).booleanValue(), this.sharedPreferences);
                            i2++;
                        }
                        if (entry.getKey().equals(ToolboxKeys.TOOLBOX_RETROFIT_LOGS)) {
                            ToolboxManager.setToolboxEnableRetrofitLogs(((Boolean) entry.getValue()).booleanValue(), this.sharedPreferences);
                            i2++;
                        }
                        if (i2 > 0) {
                        }
                    } else {
                        if ((value instanceof Long) && entry.getKey().equals(ToolboxKeys.PUSH_NOTIFICATION_PULL_INTERVAL)) {
                            ToolboxManager.setPushNotificationPullingInterval(((Long) value).longValue(), this.sharedPreferences);
                            i2++;
                        }
                        if (i2 > 0) {
                        }
                    }
                }
                edit.apply();
            }
        } catch (NullPointerException unused) {
        }
        return i2;
    }
}
