package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class uu {
    private static final Class<?> a = a();

    private static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno b() {
        if (a != null) {
            try {
                return d("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzdno.f16009c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzdno c() {
        zzdno d2;
        if (a != null) {
            try {
                d2 = d("loadGeneratedRegistry");
            } catch (Exception unused) {
            }
            if (d2 == null) {
                d2 = zzdno.b();
            }
            return d2 != null ? b() : d2;
        }
        d2 = null;
        if (d2 == null) {
        }
        if (d2 != null) {
        }
    }

    private static final zzdno d(String str) throws Exception {
        return (zzdno) a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
