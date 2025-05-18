package androidx.room;

import c.u.a.c;
import java.io.File;

/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* loaded from: classes.dex */
class p implements c.InterfaceC0094c {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final File f2202b;

    /* renamed from: c, reason: collision with root package name */
    private final c.InterfaceC0094c f2203c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, File file, c.InterfaceC0094c interfaceC0094c) {
        this.a = str;
        this.f2202b = file;
        this.f2203c = interfaceC0094c;
    }

    @Override // c.u.a.c.InterfaceC0094c
    public c.u.a.c a(c.b bVar) {
        return new o(bVar.a, this.a, this.f2202b, bVar.f3471c.a, this.f2203c.a(bVar));
    }
}
