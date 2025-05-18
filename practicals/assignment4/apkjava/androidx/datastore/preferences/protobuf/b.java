package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q0;

/* compiled from: AbstractParser.java */
/* loaded from: classes.dex */
public abstract class b<MessageType extends q0> implements y0<MessageType> {
    private static final p a = p.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).m();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType a(h hVar, p pVar) throws InvalidProtocolBufferException {
        return c(f(hVar, pVar));
    }

    public MessageType f(h hVar, p pVar) throws InvalidProtocolBufferException {
        try {
            j v = hVar.v();
            MessageType messagetype = (MessageType) b(v, pVar);
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
