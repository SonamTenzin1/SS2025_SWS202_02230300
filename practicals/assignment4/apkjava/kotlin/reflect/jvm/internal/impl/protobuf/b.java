package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* compiled from: AbstractParser.java */
/* loaded from: classes3.dex */
public abstract class b<MessageType extends o> implements q<MessageType> {
    private static final f a = f.c();

    private MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException f(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).a();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType c(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(j(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(k(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType d(d dVar, f fVar) throws InvalidProtocolBufferException {
        return e(l(dVar, fVar));
    }

    public MessageType j(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return k(new a.AbstractC0413a.C0414a(inputStream, e.B(read, inputStream)), fVar);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e g2 = e.g(inputStream);
        MessageType messagetype = (MessageType) b(g2, fVar);
        try {
            g2.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.i(messagetype);
        }
    }

    public MessageType l(d dVar, f fVar) throws InvalidProtocolBufferException {
        try {
            e v = dVar.v();
            MessageType messagetype = (MessageType) b(v, fVar);
            try {
                v.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(messagetype);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}
