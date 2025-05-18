package io.sentry.config;

import io.sentry.n5;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: PropertiesProviderFactory.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class h {
    public static g a() {
        Properties a;
        Properties a2;
        n5 n5Var = new n5();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j());
        arrayList.add(new d());
        String property = System.getProperty("sentry.properties.file");
        if (property != null && (a2 = new e(property, n5Var).a()) != null) {
            arrayList.add(new i(a2));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null && (a = new e(str, n5Var).a()) != null) {
            arrayList.add(new i(a));
        }
        Properties a3 = new b(n5Var).a();
        if (a3 != null) {
            arrayList.add(new i(a3));
        }
        Properties a4 = new e("sentry.properties", n5Var).a();
        if (a4 != null) {
            arrayList.add(new i(a4));
        }
        return new c(arrayList);
    }
}
