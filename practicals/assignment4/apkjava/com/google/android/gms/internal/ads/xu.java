package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class xu {
    private static final vu<?> a = new wu();

    /* renamed from: b, reason: collision with root package name */
    private static final vu<?> f13585b = a();

    private static vu<?> a() {
        try {
            return (vu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static vu<?> b() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static vu<?> c() {
        vu<?> vuVar = f13585b;
        if (vuVar != null) {
            return vuVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
