package kotlin.reflect.y.internal.j0.b.q;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.x0;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.i.u.e;

/* compiled from: JvmBuiltInsSignatures.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f23301b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f23302c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<String> f23303d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f23304e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<String> f23305f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f23306g;

    static {
        Set<String> m;
        Set l;
        Set l2;
        Set l3;
        Set l4;
        Set l5;
        Set<String> l6;
        Set l7;
        Set l8;
        Set l9;
        Set l10;
        Set l11;
        Set<String> l12;
        Set l13;
        Set<String> l14;
        Set l15;
        Set<String> l16;
        i iVar = new i();
        a = iVar;
        x xVar = x.a;
        m = x0.m(xVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f23301b = m;
        l = x0.l(iVar.b(), xVar.f("List", "sort(Ljava/util/Comparator;)V"));
        l2 = x0.l(l, xVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        l3 = x0.l(l2, xVar.e("Double", "isInfinite()Z", "isNaN()Z"));
        l4 = x0.l(l3, xVar.e("Float", "isInfinite()Z", "isNaN()Z"));
        l5 = x0.l(l4, xVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        l6 = x0.l(l5, xVar.e("CharSequence", "isEmpty()Z"));
        f23302c = l6;
        l7 = x0.l(xVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), xVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        l8 = x0.l(l7, xVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        l9 = x0.l(l8, xVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        l10 = x0.l(l9, xVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        l11 = x0.l(l10, xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        l12 = x0.l(l11, xVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f23303d = l12;
        l13 = x0.l(xVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        l14 = x0.l(l13, xVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        f23304e = l14;
        Set<String> a2 = iVar.a();
        String[] b2 = xVar.b("D");
        l15 = x0.l(a2, xVar.e("Float", (String[]) Arrays.copyOf(b2, b2.length)));
        String[] b3 = xVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        l16 = x0.l(l15, xVar.e("String", (String[]) Arrays.copyOf(b3, b3.length)));
        f23305f = l16;
        String[] b4 = xVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f23306g = xVar.e("Throwable", (String[]) Arrays.copyOf(b4, b4.length));
    }

    private i() {
    }

    private final Set<String> a() {
        List m;
        x xVar = x.a;
        e eVar = e.BYTE;
        m = u.m(e.BOOLEAN, eVar, e.DOUBLE, e.FLOAT, eVar, e.INT, e.LONG, e.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = m.iterator();
        while (it.hasNext()) {
            String k2 = ((e) it.next()).y().g().k();
            m.e(k2, "it.wrapperFqName.shortName().asString()");
            String[] b2 = xVar.b("Ljava/lang/String;");
            z.z(linkedHashSet, xVar.e(k2, (String[]) Arrays.copyOf(b2, b2.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        List<e> m;
        x xVar = x.a;
        m = u.m(e.BOOLEAN, e.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (e eVar : m) {
            String k2 = eVar.y().g().k();
            m.e(k2, "it.wrapperFqName.shortName().asString()");
            z.z(linkedHashSet, xVar.e(k2, eVar.v() + "Value()" + eVar.u()));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return f23301b;
    }

    public final Set<String> d() {
        return f23305f;
    }

    public final Set<String> e() {
        return f23302c;
    }

    public final Set<String> f() {
        return f23304e;
    }

    public final Set<String> g() {
        return f23306g;
    }

    public final Set<String> h() {
        return f23303d;
    }

    public final boolean i(d dVar) {
        m.f(dVar, "fqName");
        return m.a(dVar, k.a.f23208i) || k.e(dVar);
    }

    public final boolean j(d dVar) {
        m.f(dVar, "fqName");
        if (i(dVar)) {
            return true;
        }
        b n = c.a.n(dVar);
        if (n == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(n.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
