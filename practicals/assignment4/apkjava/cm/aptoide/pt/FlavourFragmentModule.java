package cm.aptoide.pt;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.FragmentScope;
import cm.aptoide.pt.view.wizard.WizardFragmentProvider;

/* loaded from: classes.dex */
public class FlavourFragmentModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @FragmentScope
    public WizardFragmentProvider providesWizardFragmentProvider(ThemeManager themeManager) {
        return new WizardFragmentProvider(themeManager);
    }
}
