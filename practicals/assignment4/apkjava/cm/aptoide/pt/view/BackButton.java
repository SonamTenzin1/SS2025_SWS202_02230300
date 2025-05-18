package cm.aptoide.pt.view;

/* loaded from: classes.dex */
public interface BackButton {

    /* loaded from: classes.dex */
    public interface ClickHandler {
        boolean handle();
    }

    void registerClickHandler(ClickHandler clickHandler);

    void unregisterClickHandler(ClickHandler clickHandler);
}
