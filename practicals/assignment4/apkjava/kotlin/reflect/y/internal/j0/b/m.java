package kotlin.reflect.y.internal.j0.b;

import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnsignedType.kt */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: f, reason: collision with root package name */
    public static final m f23211f;

    /* renamed from: g, reason: collision with root package name */
    public static final m f23212g;

    /* renamed from: h, reason: collision with root package name */
    public static final m f23213h;

    /* renamed from: i, reason: collision with root package name */
    public static final m f23214i;

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ m[] f23215j;

    /* renamed from: k, reason: collision with root package name */
    private final b f23216k;
    private final f l;

    static {
        b e2 = b.e("kotlin/UByteArray");
        kotlin.jvm.internal.m.e(e2, "fromString(\"kotlin/UByteArray\")");
        f23211f = new m("UBYTEARRAY", 0, e2);
        b e3 = b.e("kotlin/UShortArray");
        kotlin.jvm.internal.m.e(e3, "fromString(\"kotlin/UShortArray\")");
        f23212g = new m("USHORTARRAY", 1, e3);
        b e4 = b.e("kotlin/UIntArray");
        kotlin.jvm.internal.m.e(e4, "fromString(\"kotlin/UIntArray\")");
        f23213h = new m("UINTARRAY", 2, e4);
        b e5 = b.e("kotlin/ULongArray");
        kotlin.jvm.internal.m.e(e5, "fromString(\"kotlin/ULongArray\")");
        f23214i = new m("ULONGARRAY", 3, e5);
        f23215j = g();
    }

    private m(String str, int i2, b bVar) {
        this.f23216k = bVar;
        f j2 = bVar.j();
        kotlin.jvm.internal.m.e(j2, "classId.shortClassName");
        this.l = j2;
    }

    private static final /* synthetic */ m[] g() {
        return new m[]{f23211f, f23212g, f23213h, f23214i};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f23215j.clone();
    }

    public final f k() {
        return this.l;
    }
}
