package androidx.datastore.preferences.protobuf;

/* compiled from: GeneratedMessageInfoFactory.java */
/* loaded from: classes.dex */
class x implements p0 {
    private static final x a = new x();

    private x() {
    }

    public static x c() {
        return a;
    }

    @Override // androidx.datastore.preferences.protobuf.p0
    public o0 a(Class<?> cls) {
        if (y.class.isAssignableFrom(cls)) {
            try {
                return (o0) y.w(cls.asSubclass(y.class)).p();
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e2);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    @Override // androidx.datastore.preferences.protobuf.p0
    public boolean b(Class<?> cls) {
        return y.class.isAssignableFrom(cls);
    }
}
