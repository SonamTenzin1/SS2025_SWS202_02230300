package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.internal.modules.d;
import io.sentry.s4;
import io.sentry.w1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AssetsModulesLoader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class a extends d {

    /* renamed from: d, reason: collision with root package name */
    private final Context f22162d;

    public a(Context context, w1 w1Var) {
        super(w1Var);
        this.f22162d = context;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream open = this.f22162d.getAssets().open("sentry-external-modules.txt");
            try {
                Map<String, String> c2 = c(open);
                if (open != null) {
                    open.close();
                }
                return c2;
            } catch (Throwable th) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            this.f22448b.c(s4.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e2) {
            this.f22448b.b(s4.ERROR, "Error extracting modules.", e2);
            return treeMap;
        }
    }
}
