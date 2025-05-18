package androidx.datastore.preferences.protobuf;

/* compiled from: ExtensionSchemas.java */
/* loaded from: classes.dex */
final class s {
    private static final q<?> a = new r();

    /* renamed from: b, reason: collision with root package name */
    private static final q<?> f1409b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q<?> a() {
        q<?> qVar = f1409b;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q<?> b() {
        return a;
    }

    private static q<?> c() {
        try {
            return (q) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
