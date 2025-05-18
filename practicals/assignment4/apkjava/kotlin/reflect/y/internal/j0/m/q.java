package kotlin.reflect.y.internal.j0.m;

import java.util.Set;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.text.Regex;

/* compiled from: OperatorNameConventions.kt */
/* loaded from: classes3.dex */
public final class q {
    public static final f A;
    public static final f B;
    public static final f C;
    public static final f D;
    public static final f E;
    public static final f F;
    public static final f G;
    public static final f H;
    public static final f I;
    public static final f J;
    public static final f K;
    public static final f L;
    public static final f M;
    public static final f N;
    public static final f O;
    public static final Set<f> P;
    public static final Set<f> Q;
    public static final Set<f> R;
    public static final Set<f> S;
    public static final Set<f> T;
    public static final q a = new q();

    /* renamed from: b, reason: collision with root package name */
    public static final f f24917b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f24918c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f24919d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f24920e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f24921f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f24922g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f24923h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f24924i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f24925j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f24926k;
    public static final f l;
    public static final f m;
    public static final f n;
    public static final f o;
    public static final Regex p;
    public static final f q;
    public static final f r;
    public static final f s;
    public static final f t;
    public static final f u;
    public static final f v;
    public static final f w;
    public static final f x;
    public static final f y;
    public static final f z;

    static {
        Set<f> i2;
        Set<f> i3;
        Set<f> i4;
        Set<f> i5;
        Set<f> i6;
        f x2 = f.x("getValue");
        m.e(x2, "identifier(\"getValue\")");
        f24917b = x2;
        f x3 = f.x("setValue");
        m.e(x3, "identifier(\"setValue\")");
        f24918c = x3;
        f x4 = f.x("provideDelegate");
        m.e(x4, "identifier(\"provideDelegate\")");
        f24919d = x4;
        f x5 = f.x("equals");
        m.e(x5, "identifier(\"equals\")");
        f24920e = x5;
        f x6 = f.x("hashCode");
        m.e(x6, "identifier(\"hashCode\")");
        f24921f = x6;
        f x7 = f.x("compareTo");
        m.e(x7, "identifier(\"compareTo\")");
        f24922g = x7;
        f x8 = f.x("contains");
        m.e(x8, "identifier(\"contains\")");
        f24923h = x8;
        f x9 = f.x("invoke");
        m.e(x9, "identifier(\"invoke\")");
        f24924i = x9;
        f x10 = f.x("iterator");
        m.e(x10, "identifier(\"iterator\")");
        f24925j = x10;
        f x11 = f.x("get");
        m.e(x11, "identifier(\"get\")");
        f24926k = x11;
        f x12 = f.x("set");
        m.e(x12, "identifier(\"set\")");
        l = x12;
        f x13 = f.x("next");
        m.e(x13, "identifier(\"next\")");
        m = x13;
        f x14 = f.x("hasNext");
        m.e(x14, "identifier(\"hasNext\")");
        n = x14;
        f x15 = f.x("toString");
        m.e(x15, "identifier(\"toString\")");
        o = x15;
        p = new Regex("component\\d+");
        f x16 = f.x("and");
        m.e(x16, "identifier(\"and\")");
        q = x16;
        f x17 = f.x("or");
        m.e(x17, "identifier(\"or\")");
        r = x17;
        f x18 = f.x("xor");
        m.e(x18, "identifier(\"xor\")");
        s = x18;
        f x19 = f.x("inv");
        m.e(x19, "identifier(\"inv\")");
        t = x19;
        f x20 = f.x("shl");
        m.e(x20, "identifier(\"shl\")");
        u = x20;
        f x21 = f.x("shr");
        m.e(x21, "identifier(\"shr\")");
        v = x21;
        f x22 = f.x("ushr");
        m.e(x22, "identifier(\"ushr\")");
        w = x22;
        f x23 = f.x("inc");
        m.e(x23, "identifier(\"inc\")");
        x = x23;
        f x24 = f.x("dec");
        m.e(x24, "identifier(\"dec\")");
        y = x24;
        f x25 = f.x("plus");
        m.e(x25, "identifier(\"plus\")");
        z = x25;
        f x26 = f.x("minus");
        m.e(x26, "identifier(\"minus\")");
        A = x26;
        f x27 = f.x("not");
        m.e(x27, "identifier(\"not\")");
        B = x27;
        f x28 = f.x("unaryMinus");
        m.e(x28, "identifier(\"unaryMinus\")");
        C = x28;
        f x29 = f.x("unaryPlus");
        m.e(x29, "identifier(\"unaryPlus\")");
        D = x29;
        f x30 = f.x("times");
        m.e(x30, "identifier(\"times\")");
        E = x30;
        f x31 = f.x("div");
        m.e(x31, "identifier(\"div\")");
        F = x31;
        f x32 = f.x("mod");
        m.e(x32, "identifier(\"mod\")");
        G = x32;
        f x33 = f.x("rem");
        m.e(x33, "identifier(\"rem\")");
        H = x33;
        f x34 = f.x("rangeTo");
        m.e(x34, "identifier(\"rangeTo\")");
        I = x34;
        f x35 = f.x("timesAssign");
        m.e(x35, "identifier(\"timesAssign\")");
        J = x35;
        f x36 = f.x("divAssign");
        m.e(x36, "identifier(\"divAssign\")");
        K = x36;
        f x37 = f.x("modAssign");
        m.e(x37, "identifier(\"modAssign\")");
        L = x37;
        f x38 = f.x("remAssign");
        m.e(x38, "identifier(\"remAssign\")");
        M = x38;
        f x39 = f.x("plusAssign");
        m.e(x39, "identifier(\"plusAssign\")");
        N = x39;
        f x40 = f.x("minusAssign");
        m.e(x40, "identifier(\"minusAssign\")");
        O = x40;
        i2 = w0.i(x23, x24, x29, x28, x27, x19);
        P = i2;
        i3 = w0.i(x29, x28, x27, x19);
        Q = i3;
        i4 = w0.i(x30, x25, x26, x31, x32, x33, x34);
        R = i4;
        i5 = w0.i(x35, x36, x37, x38, x39, x40);
        S = i5;
        i6 = w0.i(x2, x3, x4);
        T = i6;
    }

    private q() {
    }
}
