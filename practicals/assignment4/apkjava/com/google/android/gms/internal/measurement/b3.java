package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class b3 {
    private static final a3 a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final a3 f17133b = new c3();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a3 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a3 b() {
        return f17133b;
    }

    private static a3 c() {
        try {
            return (a3) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
