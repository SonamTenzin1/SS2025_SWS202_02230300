package cm.aptoide.accountmanager;

/* loaded from: classes.dex */
public interface AdultContent {
    rx.b disable(boolean z);

    rx.b enable(int i2);

    rx.b enable(boolean z);

    rx.e<Boolean> enabled();

    rx.e<Boolean> pinRequired();

    rx.b removePin(int i2);

    rx.b requirePin(int i2);
}
