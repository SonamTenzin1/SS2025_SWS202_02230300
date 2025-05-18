package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* compiled from: AbstractMessageLite.java */
/* loaded from: classes3.dex */
public abstract class a implements o {

    /* renamed from: f, reason: collision with root package name */
    protected int f25392f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException a() {
        return new UninitializedMessageException(this);
    }

    public void i(OutputStream outputStream) throws IOException {
        int e2 = e();
        CodedOutputStream J = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(e2) + e2));
        J.o0(e2);
        h(J);
        J.I();
    }

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0413a<BuilderType extends AbstractC0413a> implements o.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException j(o oVar) {
            return new UninitializedMessageException(oVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        public abstract BuilderType i(e eVar, f fVar) throws IOException;

        /* compiled from: AbstractMessageLite.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0414a extends FilterInputStream {

            /* renamed from: f, reason: collision with root package name */
            private int f25393f;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0414a(InputStream inputStream, int i2) {
                super(inputStream);
                this.f25393f = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f25393f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f25393f <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f25393f--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) throws IOException {
                long skip = super.skip(Math.min(j2, this.f25393f));
                if (skip >= 0) {
                    this.f25393f = (int) (this.f25393f - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.f25393f;
                if (i4 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i2, Math.min(i3, i4));
                if (read >= 0) {
                    this.f25393f -= read;
                }
                return read;
            }
        }
    }
}
