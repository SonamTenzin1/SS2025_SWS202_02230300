package cm.aptoide.pt.view.settings;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreferenceCompat;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.SettingsManager;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.file.FileManager;
import cm.aptoide.pt.link.CustomTabsHelper;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.notification.NotificationSyncScheduler;
import cm.aptoide.pt.preferences.managed.ManagedKeys;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.updates.view.excluded.ExcludedUpdatesFragment;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.util.SettingsConstants;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.dialog.EditableTextDialog;
import cm.aptoide.pt.view.feedback.SendFeedbackFragment;
import cm.aptoide.pt.view.rx.RxAlertDialog;
import cm.aptoide.pt.view.rx.RxPreference;
import cm.aptoide.pt.view.settings.InputDialog;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class SettingsFragment extends androidx.preference.g implements SharedPreferences.OnSharedPreferenceChangeListener, NotBottomNavigationView {
    private static final String ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY = "Maturepin";
    private static final String ADULT_CONTENT_PREFERENCE_VIEW_KEY = "matureChkBox";
    private static final String ADULT_CONTENT_WITH_PIN_PREFERENCE_VIEW_KEY = "matureChkBoxWithPin";
    private static final String APP_THEME_PREFERENCE_KEY = "appTheme";
    private static final String DELETE_ACCOUNT = "deleteAccount";
    private static final String EXCLUDED_UPDATES_PREFERENCE_KEY = "excludedUpdates";
    private static final String PRIVACY_POLICY_PREFERENCE_KEY = "privacyPolicy";
    private static final String REMOVE_ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY = "removeMaturepin";
    private static final String SEND_FEEDBACK_PREFERENCE_KEY = "sendFeedback";
    private static final String TAG = SettingsFragment.class.getSimpleName();
    private static final String TERMS_AND_CONDITIONS_PREFERENCE_KEY = "termsConditions";
    private AptoideAccountManager accountManager;
    private AdultContentAnalytics adultContentAnalytics;
    private RxAlertDialog adultContentConfirmationDialog;
    private SwitchPreferenceCompat adultContentPreferenceView;
    private SwitchPreferenceCompat adultContentWithPinPreferenceView;
    private RxAlertDialog appThemeDialog;
    private Context context;
    private Preference deleteAccount;
    private EditableTextDialog enableAdultContentPinDialog;
    private Preference excludedUpdates;

    @Inject
    FileManager fileManager;
    private InputDialog fileMaxCacheDialog;
    private Preference fileMaxCachePreferenceView;
    private FragmentNavigator fragmentNavigator;

    @Inject
    @Named
    String marketName;

    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private NotificationSyncScheduler notificationSyncScheduler;
    private Preference pinPreferenceView;
    private Preference privacyPolicy;
    private EditableTextDialog removePinDialog;
    private Preference removePinPreferenceView;
    private Preference sendFeedback;
    private EditableTextDialog setPinDialog;
    private SettingsManager settingsManager;
    private SharedPreferences sharedPreferences;
    private SwitchPreferenceCompat socialCampaignNotifications;
    private rx.t.b subscriptions;

    @Inject
    SupportEmailProvider supportEmailProvider;
    private Preference termsAndConditions;

    @Inject
    ThemeAnalytics themeAnalytics;

    @Inject
    ThemeManager themeManager;
    protected Toolbar toolbar;
    private boolean trackAnalytics;

    @Inject
    UpdateRepository updatesRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cm.aptoide.pt.view.settings.SettingsFragment$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Preference.d {
        AnonymousClass1() {
        }

        @Override // androidx.preference.Preference.d
        public boolean onPreferenceClick(Preference preference) {
            String str;
            int i2;
            View inflate = LayoutInflater.from(SettingsFragment.this.context).inflate(R.layout.dialog_about, (ViewGroup) null);
            try {
                str = SettingsFragment.this.getActivity().getPackageManager().getPackageInfo(SettingsFragment.this.getActivity().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                CrashReport.getInstance().log(e2);
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            try {
                i2 = SettingsFragment.this.getActivity().getPackageManager().getPackageInfo(SettingsFragment.this.getActivity().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e3) {
                CrashReport.getInstance().log(e3);
                i2 = 0;
            }
            ((TextView) inflate.findViewById(R.id.aptoide_version)).setText(SettingsFragment.this.getString(R.string.version) + " " + str + " (" + i2 + ")");
            ((TextView) inflate.findViewById(R.id.credits)).setMovementMethod(LinkMovementMethod.getInstance());
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.contact_layout);
            ((TextView) inflate.findViewById(R.id.contact_text)).setText(SettingsFragment.this.supportEmailProvider.getEmail());
            if (SettingsFragment.this.supportEmailProvider.isAptoideSupport()) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
            new c.a(new c.a.o.d(SettingsFragment.this.context, SettingsFragment.this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId)).w(inflate).v(SettingsFragment.this.getString(R.string.settings_about_us)).f(android.R.drawable.ic_menu_info_details).q(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.view.settings.m2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.cancel();
                }
            }).a().show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cm.aptoide.pt.view.settings.SettingsFragment$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$themes$ThemeManager$ThemeOption;

        static {
            int[] iArr = new int[ThemeManager.ThemeOption.values().length];
            $SwitchMap$cm$aptoide$pt$themes$ThemeManager$ThemeOption = iArr;
            try {
                iArr[ThemeManager.ThemeOption.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$themes$ThemeManager$ThemeOption[ThemeManager.ThemeOption.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$themes$ThemeManager$ThemeOption[ThemeManager.ThemeOption.SYSTEM_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private String getFormattedDensity(int i2) {
        return i2 + (i2 != 120 ? i2 != 160 ? i2 != 213 ? i2 != 240 ? i2 != 320 ? i2 != 480 ? i2 != 640 ? HttpUrl.FRAGMENT_ENCODE_SET : " xxxhdpi" : " xxhdpi" : " xhdpi" : " hdpi" : " tvdpi" : " mdpi" : " ldpi");
    }

    private String getThemeString(ThemeManager.ThemeOption themeOption) {
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$themes$ThemeManager$ThemeOption[themeOption.ordinal()];
        if (i2 == 1) {
            return getString(R.string.settings_dark_theme_dark);
        }
        if (i2 != 2) {
            return getString(R.string.settings_dark_theme_system);
        }
        return getString(R.string.settings_dark_theme_light);
    }

    private void handleDeleteAccountVisibility() {
        this.subscriptions.a(this.accountManager.accountStatus().j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.a3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.d((Account) obj);
            }
        }).D0());
    }

    private void handleSocialNotifications(Boolean bool) {
        this.notificationSyncScheduler.setEnabled(bool.booleanValue());
        if (bool.booleanValue()) {
            this.notificationSyncScheduler.schedule();
        } else {
            this.notificationSyncScheduler.removeSchedules();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleDeleteAccountVisibility$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Account account) {
        this.deleteAccount.T0(account.isLoggedIn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onViewCreated$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(DialogInterface dialogInterface) {
        this.adultContentPreferenceView.G0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        this.adultContentPreferenceView.G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(DialogInterface dialogInterface) {
        return this.accountManager.enable().m(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.l3
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.g();
            }
        }).z(rx.l.c.a.b()).q(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.l2
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.h();
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(DialogInterface dialogInterface) {
        rollbackCheck(this.adultContentPreferenceView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(DialogInterface dialogInterface) {
        rollbackCheck(this.adultContentWithPinPreferenceView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m() {
        this.adultContentWithPinPreferenceView.G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(Preference preference) {
        if (((SwitchPreferenceCompat) preference).Z0()) {
            this.enableAdultContentPinDialog.show();
            return rx.e.B();
        }
        this.adultContentWithPinPreferenceView.G0(false);
        return this.accountManager.disable().m(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.y3
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.l();
            }
        }).z(rx.l.c.a.b()).q(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.u3
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.m();
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(Throwable th) {
        if (th instanceof SecurityException) {
            ShowMessage.asSnack(getActivity(), R.string.adult_pin_wrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(CharSequence charSequence) {
        return this.accountManager.removePin(Integer.valueOf(charSequence.toString()).intValue()).z(rx.l.c.a.b()).n(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.m3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.o((Throwable) obj);
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(CharSequence charSequence) {
        this.adultContentWithPinPreferenceView.G0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Throwable th) {
        if (th instanceof SecurityException) {
            ShowMessage.asSnack(getActivity(), R.string.adult_pin_wrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        this.adultContentWithPinPreferenceView.G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u(CharSequence charSequence) {
        return this.accountManager.enable(Integer.valueOf(charSequence.toString()).intValue()).m(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.t2
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.r();
            }
        }).z(rx.l.c.a.b()).n(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.j3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.s((Throwable) obj);
            }
        }).q(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.i3
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.t();
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Boolean bool) {
        this.adultContentPreferenceView.a1(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Boolean bool) {
        this.adultContentWithPinPreferenceView.a1(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y() {
        this.adultContentPreferenceView.G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(Preference preference) {
        if (((SwitchPreferenceCompat) preference).Z0()) {
            this.adultContentConfirmationDialog.show();
            return rx.e.B();
        }
        this.adultContentPreferenceView.G0(false);
        return this.accountManager.disable().m(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.j4
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.x();
            }
        }).z(rx.l.c.a.b()).q(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.h4
            @Override // rx.m.a
            public final void call() {
                SettingsFragment.this.y();
            }
        }).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Preference preference) {
        this.setPinDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Preference preference) {
        this.fileMaxCacheDialog.showWithInput(String.valueOf(ManagerPreferences.getCacheLimit(this.sharedPreferences)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Boolean bool) {
        if (bool.booleanValue()) {
            this.pinPreferenceView.T0(false);
            this.removePinPreferenceView.T0(true);
            this.adultContentWithPinPreferenceView.T0(true);
            this.adultContentPreferenceView.T0(false);
            return;
        }
        this.pinPreferenceView.T0(true);
        this.removePinPreferenceView.T0(false);
        this.adultContentWithPinPreferenceView.T0(false);
        this.adultContentPreferenceView.T0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(Preference preference) {
        this.removePinDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e E(CharSequence charSequence) {
        return this.accountManager.requirePin(Integer.valueOf(charSequence.toString()).intValue()).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAdultContentClickHandlers$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Integer num) {
        ManagerPreferences.setCacheLimit(num.intValue(), this.sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAppTheme$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(Preference preference) {
        this.appThemeDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAppTheme$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ThemeManager.ThemeOption H(ThemeManager.ThemeOption[] themeOptionArr, DialogInterface dialogInterface) {
        return themeOptionArr[this.appThemeDialog.getCheckedItem()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupAppTheme$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Preference preference, CharSequence[] charSequenceArr, ThemeManager.ThemeOption themeOption) {
        preference.P0(charSequenceArr[this.appThemeDialog.getCheckedItem()]);
        this.themeManager.setThemeOption(themeOption);
        this.themeManager.resetToBaseTheme();
        this.themeAnalytics.sendThemeChangedEvent(themeOption, TAG);
        this.themeAnalytics.setDarkThemeUserProperty(this.themeManager.getDarkThemeMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Preference preference) {
        this.fragmentNavigator.navigateTo(ExcludedUpdatesFragment.newInstance(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Preference preference) {
        this.fragmentNavigator.navigateTo(SendFeedbackFragment.newInstance(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(Preference preference) {
        CustomTabsHelper.getInstance().openInChromeCustomTab(getString(R.string.all_url_terms_conditions), getContext(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Preference preference) {
        CustomTabsHelper.getInstance().openInChromeCustomTab(getString(R.string.all_url_privacy_policy), getContext(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean N(Preference preference) {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) preference;
        boolean z = false;
        if (switchPreferenceCompat.Z0()) {
            switchPreferenceCompat.a1(true);
            z = true;
        } else {
            switchPreferenceCompat.a1(false);
        }
        ManagerPreferences.setHWSpecsFilter(z, this.sharedPreferences);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e O(GenericDialogs.EResponse eResponse) {
        return this.fileManager.deleteCache(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Long l) {
        ShowMessage.asSnack(this, AptoideUtils.StringU.getFormattedString(R.string.freed_space, getContext().getResources(), AptoideUtils.StringU.formatBytes(l.longValue(), false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(Throwable th) {
        ShowMessage.asSnack(this, R.string.ws_error_SYS_1);
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean R(Preference preference) {
        final ProgressDialog createGenericPleaseWaitDialog = GenericDialogs.createGenericPleaseWaitDialog(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        this.subscriptions.a(GenericDialogs.createGenericContinueCancelMessage(getContext(), getString(R.string.storage_dialog_title, this.marketName), getString(R.string.clear_cache_dialog_message), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.v2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
                return valueOf;
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.i4
            @Override // rx.m.b
            public final void call(Object obj) {
                createGenericPleaseWaitDialog.show();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.x2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SettingsFragment.this.O((GenericDialogs.EResponse) obj);
            }
        }).j0(rx.l.c.a.b()).z(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.e3
            @Override // rx.m.a
            public final void call() {
                createGenericPleaseWaitDialog.dismiss();
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.k4
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.P((Long) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.d4
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.Q((Throwable) obj);
            }
        }));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setupClickHandlers$22(DialogInterface dialogInterface, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean S(String str, Preference preference) {
        c.a aVar = new c.a(this.context, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        aVar.v(getString(R.string.setting_hwspecstitle));
        aVar.f(android.R.drawable.ic_menu_info_details).j(getString(R.string.setting_sdk_version) + ": " + AptoideUtils.SystemU.getSdkVer() + "\n" + getString(R.string.setting_screen_size) + ": " + AptoideUtils.ScreenU.getScreenSize(getContext().getResources()) + "\n" + getString(R.string.setting_esgl_version) + ": " + AptoideUtils.SystemU.getGlEsVer((ActivityManager) getContext().getSystemService("activity")) + "\n" + getString(R.string.screenCode) + ": " + AptoideUtils.ScreenU.getNumericScreenSize(getContext().getResources()) + "/" + AptoideUtils.ScreenU.getDensityDpi((WindowManager) getContext().getSystemService("window")) + "\n" + getString(R.string.cpuAbi) + ": " + AptoideUtils.SystemU.getAbis() + "\n" + getString(R.string.setting_density) + ": " + str).d(false).n(getString(android.R.string.ok), new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.view.settings.c3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SettingsFragment.lambda$setupClickHandlers$22(dialogInterface, i2);
            }
        });
        aVar.a().show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e T(Preference preference) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(Account account) {
        openDeleteAccountView(account.getEmail());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setupClickHandlers$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(Preference preference) {
        handleSocialNotifications(Boolean.valueOf(((SwitchPreferenceCompat) preference).Z0()));
    }

    public static Fragment newInstance() {
        return new SettingsFragment();
    }

    private void openDeleteAccountView(String str) {
        CustomTabsHelper.getInstance().openInChromeCustomTab(getString(R.string.settings_url_delete_account, str), getContext(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    private void rollbackCheck(SwitchPreferenceCompat switchPreferenceCompat) {
        switchPreferenceCompat.a1(!switchPreferenceCompat.Z0());
    }

    private void setAdultContentContent() {
        if (this.settingsManager.showAdultContent()) {
            this.adultContentConfirmationDialog = new RxAlertDialog.Builder(getContext(), this.themeManager).setMessage(R.string.are_you_adult).setPositiveButton(R.string.yes).setNegativeButton(R.string.no).build();
            this.enableAdultContentPinDialog = new InputDialog.Builder(getContext(), this.themeManager).setMessage(R.string.request_adult_pin).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).setView(R.layout.dialog_request_input).setEditText(R.id.input).build();
            this.removePinDialog = new InputDialog.Builder(getContext(), this.themeManager).setMessage(R.string.request_adult_pin).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).setView(R.layout.dialog_request_input).setEditText(R.id.input).build();
            this.setPinDialog = new InputDialog.Builder(getContext(), this.themeManager).setMessage(R.string.asksetadultpinmessage).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).setView(R.layout.dialog_request_input).setEditText(R.id.input).build();
        }
    }

    private void setAdultContentViews() {
        if (this.settingsManager.showAdultContent()) {
            this.adultContentPreferenceView = (SwitchPreferenceCompat) findPreference(ADULT_CONTENT_PREFERENCE_VIEW_KEY);
            this.adultContentWithPinPreferenceView = (SwitchPreferenceCompat) findPreference(ADULT_CONTENT_WITH_PIN_PREFERENCE_VIEW_KEY);
            this.pinPreferenceView = findPreference(ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY);
            this.removePinPreferenceView = findPreference(REMOVE_ADULT_CONTENT_PIN_PREFERENCE_VIEW_KEY);
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("adultContent");
        if (preferenceCategory != null) {
            getPreferenceScreen().i1(preferenceCategory);
        }
    }

    private void setGDPR() {
        if (this.settingsManager.showGDPR()) {
            this.termsAndConditions = findPreference(TERMS_AND_CONDITIONS_PREFERENCE_KEY);
            this.privacyPolicy = findPreference(PRIVACY_POLICY_PREFERENCE_KEY);
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("about");
        Preference findPreference = findPreference(TERMS_AND_CONDITIONS_PREFERENCE_KEY);
        Preference findPreference2 = findPreference(PRIVACY_POLICY_PREFERENCE_KEY);
        if (findPreference != null) {
            preferenceCategory.i1(findPreference);
        }
        if (findPreference2 != null) {
            preferenceCategory.i1(findPreference2);
        }
    }

    private void setupAdultContentClickHandlers() {
        if (this.settingsManager.showAdultContent()) {
            this.subscriptions.a(this.adultContentConfirmationDialog.positiveClicks().x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.n3
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.f((DialogInterface) obj);
                }
            }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.p3
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.i((DialogInterface) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.adultContentConfirmationDialog.negativeClicks().x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.g4
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.j((DialogInterface) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.enableAdultContentPinDialog.negativeClicks().x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.o2
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.k((DialogInterface) obj);
                }
            }).s0().D0());
            this.subscriptions.a(RxPreference.clicks(this.adultContentWithPinPreferenceView).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.s2
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.n((Preference) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.removePinDialog.positiveClicks().G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.b4
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.p((CharSequence) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.enableAdultContentPinDialog.positiveClicks().x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.f4
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.q((CharSequence) obj);
                }
            }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.c4
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.u((CharSequence) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.accountManager.hasMatureContentEnabled().j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.m4
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.v((Boolean) obj);
                }
            }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.s3
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.w((Boolean) obj);
                }
            }).D0());
            this.subscriptions.a(RxPreference.clicks(this.adultContentPreferenceView).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.a4
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.z((Preference) obj);
                }
            }).s0().D0());
            this.subscriptions.a(RxPreference.clicks(this.pinPreferenceView).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.y2
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.A((Preference) obj);
                }
            }).D0());
            this.subscriptions.a(RxPreference.clicks(this.fileMaxCachePreferenceView).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.q2
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.B((Preference) obj);
                }
            }).D0());
            this.subscriptions.a(this.accountManager.pinRequired().j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.g3
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.C((Boolean) obj);
                }
            }).D0());
            this.subscriptions.a(RxPreference.clicks(this.removePinPreferenceView).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.b3
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.D((Preference) obj);
                }
            }).D0());
            this.subscriptions.a(this.setPinDialog.positiveClicks().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.o3
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Boolean valueOf;
                    CharSequence charSequence = (CharSequence) obj;
                    valueOf = Boolean.valueOf(!TextUtils.isEmpty(charSequence));
                    return valueOf;
                }
            }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.h3
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return SettingsFragment.this.E((CharSequence) obj);
                }
            }).s0().D0());
            this.subscriptions.a(this.fileMaxCacheDialog.positiveClicks().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.f3
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Boolean valueOf;
                    CharSequence charSequence = (CharSequence) obj;
                    valueOf = Boolean.valueOf(!TextUtils.isEmpty(charSequence));
                    return valueOf;
                }
            }).X(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.n4
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(Integer.parseInt(((CharSequence) obj).toString()));
                    return valueOf;
                }
            }).o0(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.x3
                @Override // rx.m.e
                public final Object call(Object obj) {
                    rx.e S;
                    S = rx.e.S(200);
                    return S;
                }
            }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.z2
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.F((Integer) obj);
                }
            }).s0().D0());
        }
    }

    private void setupAppTheme() {
        final Preference findPreference = findPreference(APP_THEME_PREFERENCE_KEY);
        findPreference.P0(getThemeString(this.themeManager.getThemeOption()));
        final ThemeManager.ThemeOption[] values = ThemeManager.ThemeOption.values();
        ThemeManager.ThemeOption themeOption = this.themeManager.getThemeOption();
        final CharSequence[] charSequenceArr = new CharSequence[values.length];
        int i2 = 0;
        for (int i3 = 0; i3 < values.length; i3++) {
            if (values[i3].equals(themeOption)) {
                i2 = i3;
            }
            charSequenceArr[i3] = getThemeString(values[i3]);
        }
        this.appThemeDialog = new RxAlertDialog.Builder(getContext(), this.themeManager).setTitleSmall(R.string.settings_dark_theme_dialog_title).setSingleChoiceItems(charSequenceArr, i2).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).build();
        this.subscriptions.a(RxPreference.clicks(findPreference).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.l4
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.G((Preference) obj);
            }
        }).D0());
        this.subscriptions.a(this.appThemeDialog.positiveClicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.t3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SettingsFragment.this.H(values, (DialogInterface) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.z3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.I(findPreference, charSequenceArr, (ThemeManager.ThemeOption) obj);
            }
        }).s0().D0());
    }

    private void setupClickHandlers() {
        handleDeleteAccountVisibility();
        Preference findPreference = findPreference(SettingsConstants.CHECK_AUTO_UPDATE);
        findPreference.S0(this.marketResourceFormatter.formatString(getContext(), R.string.setting_category_autoupdate_title, new String[0]));
        findPreference.P0(this.marketResourceFormatter.formatString(getContext(), R.string.setting_category_autoupdate_message, new String[0]));
        this.subscriptions.a(RxPreference.clicks(this.deleteAccount).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.r3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SettingsFragment.this.T((Preference) obj);
            }
        }).E().x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.d3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.U((Account) obj);
            }
        }).D0());
        this.subscriptions.a(RxPreference.clicks(this.socialCampaignNotifications).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.w3
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.V((Preference) obj);
            }
        }));
        this.subscriptions.a(RxPreference.clicks(this.excludedUpdates).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.J((Preference) obj);
            }
        }));
        this.subscriptions.a(RxPreference.clicks(this.sendFeedback).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.w2
            @Override // rx.m.b
            public final void call(Object obj) {
                SettingsFragment.this.K((Preference) obj);
            }
        }));
        if (this.settingsManager.showGDPR()) {
            this.subscriptions.a(RxPreference.clicks(this.termsAndConditions).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.e4
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.L((Preference) obj);
                }
            }));
            this.subscriptions.a(RxPreference.clicks(this.privacyPolicy).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.v3
                @Override // rx.m.b
                public final void call(Object obj) {
                    SettingsFragment.this.M((Preference) obj);
                }
            }));
        }
        findPreference(SettingsConstants.FILTER_APPS).N0(new Preference.d() { // from class: cm.aptoide.pt.view.settings.r2
            @Override // androidx.preference.Preference.d
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.N(preference);
            }
        });
        findPreference(SettingsConstants.CLEAR_CACHE).N0(new Preference.d() { // from class: cm.aptoide.pt.view.settings.u2
            @Override // androidx.preference.Preference.d
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.R(preference);
            }
        });
        Preference findPreference2 = findPreference(SettingsConstants.HARDWARE_SPECS);
        final String formattedDensity = getFormattedDensity(AptoideUtils.ScreenU.getDensityDpi(getActivity().getWindowManager()));
        findPreference2.N0(new Preference.d() { // from class: cm.aptoide.pt.view.settings.o4
            @Override // androidx.preference.Preference.d
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.S(formattedDensity, preference);
            }
        });
        findPreference(SettingsConstants.ABOUT_DIALOG).N0(new AnonymousClass1());
        setupAdultContentClickHandlers();
    }

    private void setupFileMaxCacheDialog() {
        this.fileMaxCacheDialog = new InputDialog.Builder(getContext(), this.themeManager).setMessage(R.string.settings_maxFileCache_title).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).setView(R.layout.dialog_request_input).setEditText(R.id.input).build();
    }

    private boolean shouldRefreshUpdates(String str) {
        return str.equals(ManagedKeys.UPDATES_FILTER_ALPHA_BETA_KEY) || str.equals(ManagedKeys.HWSPECS_FILTER) || str.equals(ManagedKeys.UPDATES_SYSTEM_APPS_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trackLock, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void x() {
        if (this.trackAnalytics) {
            this.trackAnalytics = false;
            this.adultContentAnalytics.lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trackUnlock, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void r() {
        if (this.trackAnalytics) {
            this.trackAnalytics = false;
            this.adultContentAnalytics.unlock();
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((BaseActivity) getContext()).getActivityComponent().inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.trackAnalytics = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.subscriptions = new rx.t.b();
        this.fragmentNavigator = ((ActivityResultNavigator) getActivity()).getFragmentNavigator();
        this.notificationSyncScheduler = ((AptoideApplication) getContext().getApplicationContext()).getNotificationSyncScheduler();
        ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker().registerScreen(ScreenTagHistory.Builder.build(getClass().getSimpleName()));
        this.adultContentAnalytics = aptoideApplication.getAdultContentAnalytics();
        this.settingsManager = ((AptoideApplication) getContext().getApplicationContext()).getSettingsManager();
        setAdultContentContent();
        setupFileMaxCacheDialog();
    }

    @Override // androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        addPreferencesFromResource(R.xml.settings);
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        this.sharedPreferences = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.subscriptions.b();
        this.toolbar = null;
        this.adultContentPreferenceView = null;
        this.adultContentWithPinPreferenceView = null;
        this.socialCampaignNotifications = null;
        this.pinPreferenceView = null;
        this.fileMaxCachePreferenceView = null;
        this.removePinPreferenceView = null;
        this.excludedUpdates = null;
        this.sendFeedback = null;
        this.termsAndConditions = null;
        this.privacyPolicy = null;
        this.deleteAccount = null;
        this.context = null;
        super.onDestroyView();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (shouldRefreshUpdates(str)) {
            this.updatesRepository.sync(true, false, true).I(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.k3
                @Override // rx.m.a
                public final void call() {
                    Logger.getInstance().d(SettingsFragment.TAG, "updates refreshed");
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.q3
                @Override // rx.m.b
                public final void call(Object obj) {
                    CrashReport.getInstance().log((Throwable) obj);
                }
            });
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            dVar.setSupportActionBar(toolbar);
            this.toolbar.setTitle(R.string.settings_title_settings);
            this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.settings.p2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment.this.e(view2);
                }
            });
            androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.r(true);
            }
        }
        setAdultContentViews();
        this.excludedUpdates = findPreference(EXCLUDED_UPDATES_PREFERENCE_KEY);
        this.sendFeedback = findPreference(SEND_FEEDBACK_PREFERENCE_KEY);
        setGDPR();
        setupAppTheme();
        this.deleteAccount = findPreference(DELETE_ACCOUNT);
        this.socialCampaignNotifications = (SwitchPreferenceCompat) findPreference(ManagedKeys.CAMPAIGN_SOCIAL_NOTIFICATIONS_PREFERENCE_VIEW_KEY);
        this.fileMaxCachePreferenceView = findPreference(ManagedKeys.MAX_FILE_CACHE);
        setupClickHandlers();
    }
}
