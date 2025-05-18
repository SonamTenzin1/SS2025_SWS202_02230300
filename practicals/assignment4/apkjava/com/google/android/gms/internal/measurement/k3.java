package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class k3 {
    private static final j3 a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final j3 f17193b = new i3();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j3 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j3 b() {
        return f17193b;
    }

    private static j3 c() {
        try {
            return (j3) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
