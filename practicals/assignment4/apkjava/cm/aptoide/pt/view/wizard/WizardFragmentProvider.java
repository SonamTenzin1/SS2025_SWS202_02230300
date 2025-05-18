package cm.aptoide.pt.view.wizard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.LoginSignUpFragment;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;

/* loaded from: classes.dex */
public class WizardFragmentProvider {
    private static final int WIZARD_LOGIN_POSITION = 2;
    private static final int WIZARD_STEP_ONE_POSITION = 0;
    private static final int WIZARD_STEP_TWO_POSITION = 1;
    private ThemeManager themeManager;

    public WizardFragmentProvider(ThemeManager themeManager) {
        this.themeManager = themeManager;
    }

    private Fragment setFragmentLogFlag(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBoolean(NavigationTrackFragment.SHOULD_REGISTER_VIEW, false);
        fragment.setArguments(arguments);
        return fragment;
    }

    public int getCount(Boolean bool) {
        return bool.booleanValue() ? 2 : 3;
    }

    public Fragment getItem(int i2) {
        Fragment newInstance;
        if (i2 == 0) {
            newInstance = WizardPageOneFragment.newInstance();
        } else if (i2 == 1) {
            newInstance = WizardPageTwoFragment.newInstance();
        } else if (i2 == 2) {
            newInstance = LoginSignUpFragment.newInstance(true, false, true, true);
        } else {
            throw new IllegalArgumentException("Invalid wizard fragment position: " + i2);
        }
        return setFragmentLogFlag(newInstance);
    }

    public Integer[] getTransitionColors() {
        return new Integer[]{Integer.valueOf(this.themeManager.getAttributeForTheme(R.attr.wizardFirstColor).resourceId), Integer.valueOf(this.themeManager.getAttributeForTheme(R.attr.wizardSecondColor).resourceId), Integer.valueOf(this.themeManager.getAttributeForTheme(R.attr.wizardThirdColor).resourceId)};
    }
}
