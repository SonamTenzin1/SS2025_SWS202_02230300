package com.liulishuo.filedownloader.message;

/* compiled from: MessageSnapshotFlow.java */
/* loaded from: classes2.dex */
public class b {
    private volatile d a;

    /* renamed from: b, reason: collision with root package name */
    private volatile InterfaceC0246b f20488b;

    /* compiled from: MessageSnapshotFlow.java */
    /* loaded from: classes2.dex */
    public static final class a {
        private static final b a = new b();
    }

    /* compiled from: MessageSnapshotFlow.java */
    /* renamed from: com.liulishuo.filedownloader.message.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0246b {
        void H(MessageSnapshot messageSnapshot);
    }

    public static b a() {
        return a.a;
    }

    public void b(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.liulishuo.filedownloader.message.a) {
            if (this.f20488b != null) {
                this.f20488b.H(messageSnapshot);
            }
        } else if (this.a != null) {
            this.a.b(messageSnapshot);
        }
    }

    public void c(InterfaceC0246b interfaceC0246b) {
        this.f20488b = interfaceC0246b;
        if (interfaceC0246b == null) {
            this.a = null;
        } else {
            this.a = new d(5, interfaceC0246b);
        }
    }
}
