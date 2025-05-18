package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: Modality.kt */
/* loaded from: classes2.dex */
public enum d0 {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    /* renamed from: f, reason: collision with root package name */
    public static final a f25129f = new a(null);

    /* compiled from: Modality.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final d0 a(boolean z, boolean z2, boolean z3) {
            if (z) {
                return d0.SEALED;
            }
            if (z2) {
                return d0.ABSTRACT;
            }
            if (z3) {
                return d0.OPEN;
            }
            return d0.FINAL;
        }
    }
}
