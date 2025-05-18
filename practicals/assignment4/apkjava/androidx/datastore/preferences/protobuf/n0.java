package androidx.datastore.preferences.protobuf;

/* compiled from: MapFieldSchemas.java */
/* loaded from: classes.dex */
final class n0 {
    private static final l0 a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final l0 f1372b = new m0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 b() {
        return f1372b;
    }

    private static l0 c() {
        try {
            return (l0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
