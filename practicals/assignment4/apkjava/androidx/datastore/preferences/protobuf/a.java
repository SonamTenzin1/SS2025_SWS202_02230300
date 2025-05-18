package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.a.AbstractC0032a;
import androidx.datastore.preferences.protobuf.h;
import androidx.datastore.preferences.protobuf.q0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: AbstractMessageLite.java */
/* loaded from: classes.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0032a<MessageType, BuilderType>> implements q0 {
    protected int memoizedHashCode = 0;

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0032a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0032a<MessageType, BuilderType>> implements q0.a {
        protected static <T> void j(Iterable<T> iterable, List<? super T> list) {
            a0.a(iterable);
            if (iterable instanceof f0) {
                List<?> j2 = ((f0) iterable).j();
                f0 f0Var = (f0) list;
                int size = list.size();
                for (Object obj : j2) {
                    if (obj == null) {
                        String str = "Element at index " + (f0Var.size() - size) + " is null.";
                        for (int size2 = f0Var.size() - 1; size2 >= size; size2--) {
                            f0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    }
                    if (obj instanceof h) {
                        f0Var.a0((h) obj);
                    } else {
                        f0Var.add((String) obj);
                    }
                }
                return;
            }
            if (iterable instanceof z0) {
                list.addAll((Collection) iterable);
            } else {
                k(iterable, list);
            }
        }

        private static <T> void k(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException n(q0 q0Var) {
            return new UninitializedMessageException(q0Var);
        }

        protected abstract BuilderType l(MessageType messagetype);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.q0.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public BuilderType z(q0 q0Var) {
            if (b().getClass().isInstance(q0Var)) {
                return (BuilderType) l((a) q0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void a(Iterable<T> iterable, List<? super T> list) {
        AbstractC0032a.j(iterable, list);
    }

    private String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    public h h() {
        try {
            h.C0033h u = h.u(e());
            i(u.b());
            return u.a();
        } catch (IOException e2) {
            throw new RuntimeException(l("ByteString"), e2);
        }
    }

    int j() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(f1 f1Var) {
        int j2 = j();
        if (j2 != -1) {
            return j2;
        }
        int i2 = f1Var.i(this);
        n(i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException m() {
        return new UninitializedMessageException(this);
    }

    void n(int i2) {
        throw new UnsupportedOperationException();
    }

    public void o(OutputStream outputStream) throws IOException {
        CodedOutputStream f0 = CodedOutputStream.f0(outputStream, CodedOutputStream.I(e()));
        i(f0);
        f0.c0();
    }
}
