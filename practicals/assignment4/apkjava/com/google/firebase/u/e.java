package com.google.firebase.u;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: GlobalLibraryVersionRegistrar.java */
/* loaded from: classes2.dex */
public class e {
    private static volatile e a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<g> f20133b = new HashSet();

    e() {
    }

    public static e a() {
        e eVar = a;
        if (eVar == null) {
            synchronized (e.class) {
                eVar = a;
                if (eVar == null) {
                    eVar = new e();
                    a = eVar;
                }
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<g> b() {
        Set<g> unmodifiableSet;
        synchronized (this.f20133b) {
            unmodifiableSet = Collections.unmodifiableSet(this.f20133b);
        }
        return unmodifiableSet;
    }
}
