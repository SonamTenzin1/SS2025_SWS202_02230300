package c.l;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: DataStoreFile.kt */
/* loaded from: classes.dex */
public final class a {
    public static final File a(Context context, String str) {
        m.f(context, "<this>");
        m.f(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), m.n("datastore/", str));
    }
}
