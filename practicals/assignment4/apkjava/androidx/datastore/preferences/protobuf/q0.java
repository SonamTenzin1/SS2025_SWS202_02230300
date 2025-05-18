package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: MessageLite.java */
/* loaded from: classes.dex */
public interface q0 extends r0 {

    /* compiled from: MessageLite.java */
    /* loaded from: classes.dex */
    public interface a extends r0, Cloneable {
        q0 J0();

        q0 c();

        a z(q0 q0Var);
    }

    a d();

    int e();

    a f();

    y0<? extends q0> g();

    h h();

    void i(CodedOutputStream codedOutputStream) throws IOException;
}
