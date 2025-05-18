package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: MessageLite.java */
/* loaded from: classes3.dex */
public interface o extends p {

    /* compiled from: MessageLite.java */
    /* loaded from: classes3.dex */
    public interface a extends Cloneable, p {
        a W(e eVar, f fVar) throws IOException;

        o c();
    }

    a d();

    int e();

    a f();

    q<? extends o> g();

    void h(CodedOutputStream codedOutputStream) throws IOException;
}
