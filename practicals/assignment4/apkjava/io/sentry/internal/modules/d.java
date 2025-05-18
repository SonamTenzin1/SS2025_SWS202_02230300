package io.sentry.internal.modules;

import io.sentry.s4;
import io.sentry.w1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ModulesLoader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public abstract class d implements b {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    protected final w1 f22448b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f22449c = null;

    public d(w1 w1Var) {
        this.f22448b = w1Var;
    }

    @Override // io.sentry.internal.modules.b
    public Map<String, String> a() {
        Map<String, String> map = this.f22449c;
        if (map != null) {
            return map;
        }
        Map<String, String> b2 = b();
        this.f22449c = b2;
        return b2;
    }

    protected abstract Map<String, String> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> c(InputStream inputStream) {
        TreeMap treeMap = new TreeMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, a));
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    int lastIndexOf = readLine.lastIndexOf(58);
                    treeMap.put(readLine.substring(0, lastIndexOf), readLine.substring(lastIndexOf + 1));
                }
                this.f22448b.c(s4.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            this.f22448b.b(s4.ERROR, "Error extracting modules.", e2);
        } catch (RuntimeException e3) {
            this.f22448b.a(s4.ERROR, e3, "%s file is malformed.", "sentry-external-modules.txt");
        }
        return treeMap;
    }
}
