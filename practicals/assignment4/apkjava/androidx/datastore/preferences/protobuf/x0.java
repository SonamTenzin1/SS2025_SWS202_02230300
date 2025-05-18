package androidx.datastore.preferences.protobuf;

/* compiled from: NewInstanceSchemas.java */
/* loaded from: classes.dex */
final class x0 {
    private static final v0 a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final v0 f1446b = new w0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v0 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v0 b() {
        return f1446b;
    }

    private static v0 c() {
        try {
            return (v0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
