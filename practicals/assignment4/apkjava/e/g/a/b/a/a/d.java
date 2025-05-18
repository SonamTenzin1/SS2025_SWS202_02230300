package e.g.a.b.a.a;

import com.google.android.material.snackbar.Snackbar;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnackbarDismissesOnSubscribe.java */
/* loaded from: classes2.dex */
public final class d implements e.a<Integer> {

    /* renamed from: f, reason: collision with root package name */
    final Snackbar f21138f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarDismissesOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a extends Snackbar.b {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // com.google.android.material.snackbar.Snackbar.b
        public void onDismissed(Snackbar snackbar, int i2) {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(Integer.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarDismissesOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21138f.d0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Snackbar snackbar) {
        this.f21138f = snackbar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Integer> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21138f.d0(aVar);
    }
}
