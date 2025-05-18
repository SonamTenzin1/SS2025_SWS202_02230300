package c.l.b;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: PreferenceDataStoreFile.kt */
/* loaded from: classes.dex */
public final class b {
    public static final File a(Context context, String str) {
        m.f(context, "<this>");
        m.f(str, "name");
        return c.l.a.a(context, m.n(str, ".preferences_pb"));
    }
}
