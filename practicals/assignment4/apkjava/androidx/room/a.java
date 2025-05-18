package androidx.room;

import android.content.Context;
import androidx.room.j;
import c.u.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class a {
    public final c.InterfaceC0094c a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2117b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2118c;

    /* renamed from: d, reason: collision with root package name */
    public final j.d f2119d;

    /* renamed from: e, reason: collision with root package name */
    public final List<j.b> f2120e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2121f;

    /* renamed from: g, reason: collision with root package name */
    public final j.c f2122g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f2123h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f2124i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2125j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2126k;
    public final boolean l;
    private final Set<Integer> m;
    public final String n;
    public final File o;

    public a(Context context, String str, c.InterfaceC0094c interfaceC0094c, j.d dVar, List<j.b> list, boolean z, j.c cVar, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = interfaceC0094c;
        this.f2117b = context;
        this.f2118c = str;
        this.f2119d = dVar;
        this.f2120e = list;
        this.f2121f = z;
        this.f2122g = cVar;
        this.f2123h = executor;
        this.f2124i = executor2;
        this.f2125j = z2;
        this.f2126k = z3;
        this.l = z4;
        this.m = set;
        this.n = str2;
        this.o = file;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return !((i2 > i3) && this.l) && this.f2126k && ((set = this.m) == null || !set.contains(Integer.valueOf(i2)));
    }
}
