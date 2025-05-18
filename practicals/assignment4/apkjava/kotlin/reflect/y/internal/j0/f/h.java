package kotlin.reflect.y.internal.j0.f;

import kotlin.jvm.internal.m;

/* compiled from: SpecialNames.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final f f24216b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f24217c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f24218d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f24219e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f24220f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f24221g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f24222h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f24223i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f24224j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f24225k;
    public static final f l;
    public static final f m;
    public static final f n;

    static {
        f D = f.D("<no name provided>");
        m.e(D, "special(\"<no name provided>\")");
        f24216b = D;
        f D2 = f.D("<root package>");
        m.e(D2, "special(\"<root package>\")");
        f24217c = D2;
        f x = f.x("Companion");
        m.e(x, "identifier(\"Companion\")");
        f24218d = x;
        f x2 = f.x("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        m.e(x2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        f24219e = x2;
        f D3 = f.D("<anonymous>");
        m.e(D3, "special(ANONYMOUS_STRING)");
        f24220f = D3;
        f D4 = f.D("<unary>");
        m.e(D4, "special(\"<unary>\")");
        f24221g = D4;
        f D5 = f.D("<this>");
        m.e(D5, "special(\"<this>\")");
        f24222h = D5;
        f D6 = f.D("<init>");
        m.e(D6, "special(\"<init>\")");
        f24223i = D6;
        f D7 = f.D("<iterator>");
        m.e(D7, "special(\"<iterator>\")");
        f24224j = D7;
        f D8 = f.D("<destruct>");
        m.e(D8, "special(\"<destruct>\")");
        f24225k = D8;
        f D9 = f.D("<local>");
        m.e(D9, "special(\"<local>\")");
        l = D9;
        f D10 = f.D("<unused var>");
        m.e(D10, "special(\"<unused var>\")");
        m = D10;
        f D11 = f.D("<set-?>");
        m.e(D11, "special(\"<set-?>\")");
        n = D11;
    }

    private h() {
    }

    public static final f b(f fVar) {
        return (fVar == null || fVar.y()) ? f24219e : fVar;
    }

    public final boolean a(f fVar) {
        m.f(fVar, "name");
        String k2 = fVar.k();
        m.e(k2, "name.asString()");
        return (k2.length() > 0) && !fVar.y();
    }
}
