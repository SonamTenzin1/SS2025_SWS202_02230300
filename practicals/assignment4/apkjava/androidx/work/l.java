package androidx.work;

/* compiled from: InputMergerFactory.java */
/* loaded from: classes.dex */
public abstract class l {

    /* compiled from: InputMergerFactory.java */
    /* loaded from: classes.dex */
    class a extends l {
        a() {
        }

        @Override // androidx.work.l
        public k a(String str) {
            return null;
        }
    }

    public static l c() {
        return new a();
    }

    public abstract k a(String str);

    public final k b(String str) {
        k a2 = a(str);
        return a2 == null ? k.a(str) : a2;
    }
}
