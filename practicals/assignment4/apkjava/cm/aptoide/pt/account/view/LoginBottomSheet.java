package cm.aptoide.pt.account.view;

/* loaded from: classes.dex */
public interface LoginBottomSheet {

    /* loaded from: classes.dex */
    public enum State {
        EXPANDED,
        COLLAPSED
    }

    void collapse();

    void expand();

    rx.e<State> state();
}
