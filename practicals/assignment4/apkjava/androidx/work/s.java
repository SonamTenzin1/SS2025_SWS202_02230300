package androidx.work;

import android.os.Build;
import androidx.work.z;
import java.util.concurrent.TimeUnit;

/* compiled from: PeriodicWorkRequest.java */
/* loaded from: classes.dex */
public final class s extends z {

    /* compiled from: PeriodicWorkRequest.java */
    /* loaded from: classes.dex */
    public static final class a extends z.a<a, s> {
        public a(Class<? extends ListenableWorker> cls, long j2, TimeUnit timeUnit) {
            super(cls);
            this.f2681c.e(timeUnit.toMillis(j2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public s c() {
            if (this.a && Build.VERSION.SDK_INT >= 23 && this.f2681c.l.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (!this.f2681c.s) {
                return new s(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    s(a aVar) {
        super(aVar.f2680b, aVar.f2681c, aVar.f2682d);
    }
}
