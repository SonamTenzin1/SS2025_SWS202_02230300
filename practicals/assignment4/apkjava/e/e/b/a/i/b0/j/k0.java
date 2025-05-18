package e.e.b.a.i.b0.j;

import com.google.auto.value.AutoValue;
import e.e.b.a.i.b0.j.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventStoreConfig.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class k0 {
    static final k0 a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        abstract k0 a();

        abstract a b(int i2);

        abstract a c(long j2);

        abstract a d(int i2);

        abstract a e(int i2);

        abstract a f(long j2);
    }

    static a a() {
        return new g0.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long f();
}
