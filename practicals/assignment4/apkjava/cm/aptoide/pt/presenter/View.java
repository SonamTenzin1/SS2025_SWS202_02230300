package cm.aptoide.pt.presenter;

/* loaded from: classes.dex */
public interface View {

    /* loaded from: classes.dex */
    public enum LifecycleEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    void attachPresenter(Presenter presenter);

    <T> com.trello.rxlifecycle.b<T> bindUntilEvent(LifecycleEvent lifecycleEvent);

    rx.e<LifecycleEvent> getLifecycleEvent();
}
