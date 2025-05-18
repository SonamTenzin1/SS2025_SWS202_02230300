package cm.aptoide.pt.search.websocket;

/* loaded from: classes.dex */
public final class SocketEvent {
    private final byte[] data;
    private final Status status;

    /* loaded from: classes.dex */
    public enum Status {
        OPEN,
        MESSAGE,
        CLOSING,
        CLOSED,
        FAILURE
    }

    SocketEvent(Status status, byte[] bArr) {
        this.status = status;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean hasData() {
        return this.data != null;
    }

    SocketEvent(Status status) {
        this(status, null);
    }
}
