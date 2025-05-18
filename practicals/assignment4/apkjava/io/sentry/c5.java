package io.sentry;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SentryValues.java */
/* loaded from: classes2.dex */
public final class c5<T> {
    private final List<T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c5(List<T> list) {
        this.a = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> a() {
        return this.a;
    }
}
