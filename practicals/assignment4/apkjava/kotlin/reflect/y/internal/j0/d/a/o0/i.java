package kotlin.reflect.y.internal.j0.d.a.o0;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* loaded from: classes3.dex */
public final class i {
    private final h a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f23626b;

    public i(h hVar, boolean z) {
        m.f(hVar, "qualifier");
        this.a = hVar;
        this.f23626b = z;
    }

    public static /* synthetic */ i b(i iVar, h hVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hVar = iVar.a;
        }
        if ((i2 & 2) != 0) {
            z = iVar.f23626b;
        }
        return iVar.a(hVar, z);
    }

    public final i a(h hVar, boolean z) {
        m.f(hVar, "qualifier");
        return new i(hVar, z);
    }

    public final h c() {
        return this.a;
    }

    public final boolean d() {
        return this.f23626b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.f23626b == iVar.f23626b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.f23626b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.f23626b + ')';
    }

    public /* synthetic */ i(h hVar, boolean z, int i2, g gVar) {
        this(hVar, (i2 & 2) != 0 ? false : z);
    }
}
