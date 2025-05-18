package kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* compiled from: AnnotationUseSiteTarget.kt */
/* loaded from: classes2.dex */
public enum e {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");

    private final String p;

    e(String str) {
        this.p = str == null ? kotlin.reflect.y.internal.j0.m.u.a.f(name()) : str;
    }

    public final String k() {
        return this.p;
    }

    /* synthetic */ e(String str, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }
}
