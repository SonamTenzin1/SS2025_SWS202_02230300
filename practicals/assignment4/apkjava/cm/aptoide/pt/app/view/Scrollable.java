package cm.aptoide.pt.app.view;

/* loaded from: classes.dex */
public interface Scrollable {

    /* loaded from: classes.dex */
    public enum Position {
        FIRST,
        LAST
    }

    void itemAdded(int i2);

    void itemChanged(int i2);

    void itemRemoved(int i2);

    void scroll(Position position);
}
