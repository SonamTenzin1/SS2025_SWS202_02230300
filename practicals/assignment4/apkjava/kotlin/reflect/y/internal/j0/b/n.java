package kotlin.reflect.y.internal.j0.b;

import kotlin.jvm.internal.m;
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
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static final n f23217f;

    /* renamed from: g, reason: collision with root package name */
    public static final n f23218g;

    /* renamed from: h, reason: collision with root package name */
    public static final n f23219h;

    /* renamed from: i, reason: collision with root package name */
    public static final n f23220i;

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ n[] f23221j;

    /* renamed from: k, reason: collision with root package name */
    private final b f23222k;
    private final f l;
    private final b m;

    static {
        b e2 = b.e("kotlin/UByte");
        m.e(e2, "fromString(\"kotlin/UByte\")");
        f23217f = new n("UBYTE", 0, e2);
        b e3 = b.e("kotlin/UShort");
        m.e(e3, "fromString(\"kotlin/UShort\")");
        f23218g = new n("USHORT", 1, e3);
        b e4 = b.e("kotlin/UInt");
        m.e(e4, "fromString(\"kotlin/UInt\")");
        f23219h = new n("UINT", 2, e4);
        b e5 = b.e("kotlin/ULong");
        m.e(e5, "fromString(\"kotlin/ULong\")");
        f23220i = new n("ULONG", 3, e5);
        f23221j = g();
    }

    private n(String str, int i2, b bVar) {
        this.f23222k = bVar;
        f j2 = bVar.j();
        m.e(j2, "classId.shortClassName");
        this.l = j2;
        this.m = new b(bVar.h(), f.x(j2.k() + "Array"));
    }

    private static final /* synthetic */ n[] g() {
        return new n[]{f23217f, f23218g, f23219h, f23220i};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f23221j.clone();
    }

    public final b k() {
        return this.m;
    }

    public final b q() {
        return this.f23222k;
    }

    public final f u() {
        return this.l;
    }
}
