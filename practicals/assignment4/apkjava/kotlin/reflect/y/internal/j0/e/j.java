package kotlin.reflect.y.internal.j0.e;

import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public enum j implements i.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);


    /* renamed from: j, reason: collision with root package name */
    private static i.b<j> f24014j = new i.b<j>() { // from class: kotlin.f0.y.e.j0.e.j.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(int i2) {
            return j.g(i2);
        }
    };
    private final int l;

    j(int i2, int i3) {
        this.l = i3;
    }

    public static j g(int i2) {
        if (i2 == 0) {
            return DECLARATION;
        }
        if (i2 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i2 == 2) {
            return DELEGATION;
        }
        if (i2 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
    public final int f() {
        return this.l;
    }
}
