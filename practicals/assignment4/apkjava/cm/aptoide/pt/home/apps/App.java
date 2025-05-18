package cm.aptoide.pt.home.apps;

/* loaded from: classes.dex */
public interface App {

    /* loaded from: classes.dex */
    public enum Type {
        UPDATE,
        DOWNLOAD,
        INSTALLED
    }

    String getIdentifier();

    Type getType();
}
