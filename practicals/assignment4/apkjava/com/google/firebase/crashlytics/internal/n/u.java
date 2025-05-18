package com.google.firebase.crashlytics.internal.n;

import c.i.j.c;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.r.f;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: CrashlyticsAppQualitySessionsStore.java */
/* loaded from: classes2.dex */
class u {
    private static final FilenameFilter a = new FilenameFilter() { // from class: com.google.firebase.crashlytics.h.n.a
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean startsWith;
            startsWith = str.startsWith("aqs.");
            return startsWith;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Comparator<File> f19084b = new Comparator() { // from class: com.google.firebase.crashlytics.h.n.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return u.c((File) obj, (File) obj2);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final f f19085c;

    /* renamed from: d, reason: collision with root package name */
    private String f19086d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f19087e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(f fVar) {
        this.f19085c = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(File file, File file2) {
        return (file2.lastModified() > file.lastModified() ? 1 : (file2.lastModified() == file.lastModified() ? 0 : -1));
    }

    private static void d(f fVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            fVar.o(str, "aqs." + str2).createNewFile();
        } catch (IOException e2) {
            h.f().l("Failed to persist App Quality Sessions session id.", e2);
        }
    }

    static String e(f fVar, String str) {
        List<File> p = fVar.p(str, a);
        if (p.isEmpty()) {
            h.f().k("Unable to read App Quality Sessions session id.");
            return null;
        }
        return ((File) Collections.min(p, f19084b)).getName().substring(4);
    }

    public synchronized String a(String str) {
        if (c.a(this.f19086d, str)) {
            return this.f19087e;
        }
        return e(this.f19085c, str);
    }

    public synchronized void f(String str) {
        if (!c.a(this.f19087e, str)) {
            d(this.f19085c, this.f19086d, str);
            this.f19087e = str;
        }
    }

    public synchronized void g(String str) {
        if (!c.a(this.f19086d, str)) {
            d(this.f19085c, str, this.f19087e);
            this.f19086d = str;
        }
    }
}
