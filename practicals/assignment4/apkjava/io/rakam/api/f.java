package io.rakam.api;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Rakam.java */
/* loaded from: classes.dex */
public class f {
    static final Map<String, g> a = new HashMap();

    public static g a() {
        return b(null);
    }

    public static synchronized g b(String str) {
        g gVar;
        synchronized (f.class) {
            String e2 = j.e(str);
            Map<String, g> map = a;
            gVar = map.get(e2);
            if (gVar == null) {
                gVar = new g(e2);
                map.put(e2, gVar);
            }
        }
        return gVar;
    }
}
