package e.e.b.a.i.b0.j;

import android.content.Context;
import javax.inject.Named;
import javax.inject.Singleton;

/* compiled from: EventStoreModule.java */
/* loaded from: classes2.dex */
public abstract class l0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Named
    public static String a() {
        return "com.google.android.datatransport.events";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    @Named
    public static String b(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Named
    public static int c() {
        return t0.f20799g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 d() {
        return k0.a;
    }
}
