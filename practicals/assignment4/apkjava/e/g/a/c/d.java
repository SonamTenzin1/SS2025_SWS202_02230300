package e.g.a.c;

import android.view.View;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFocusChangeOnSubscribe.java */
/* loaded from: classes2.dex */
public final class d implements e.a<Boolean> {

    /* renamed from: f, reason: collision with root package name */
    final View f21165f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFocusChangeOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnFocusChangeListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21166f;

        a(j jVar) {
            this.f21166f = jVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (this.f21166f.isUnsubscribed()) {
                return;
            }
            this.f21166f.onNext(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFocusChangeOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21165f.setOnFocusChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.f21165f = view;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Boolean> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21165f.setOnFocusChangeListener(aVar);
        jVar.onNext(Boolean.valueOf(this.f21165f.hasFocus()));
    }
}
