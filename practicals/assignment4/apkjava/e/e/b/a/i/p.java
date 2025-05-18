package e.e.b.a.i;

import com.google.auto.value.AutoValue;
import e.e.b.a.i.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendRequest.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class p {

    /* compiled from: SendRequest.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract p a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(e.e.b.a.b bVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(e.e.b.a.c<?> cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(e.e.b.a.e<?, byte[]> eVar);

        public abstract a e(q qVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new d.b();
    }

    public abstract e.e.b.a.b b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.e.b.a.c<?> c();

    public byte[] d() {
        return e().a(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.e.b.a.e<?, byte[]> e();

    public abstract q f();

    public abstract String g();
}
