package rx.n.e;

/* compiled from: UtilityFunctions.java */
/* loaded from: classes3.dex */
public final class m {

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes3.dex */
    enum a implements rx.m.e<Object, Boolean> {
        INSTANCE;

        @Override // rx.m.e
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes3.dex */
    enum b implements rx.m.e<Object, Object> {
        INSTANCE;

        @Override // rx.m.e
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> rx.m.e<? super T, Boolean> a() {
        return a.INSTANCE;
    }

    public static <T> rx.m.e<T, T> b() {
        return b.INSTANCE;
    }
}
