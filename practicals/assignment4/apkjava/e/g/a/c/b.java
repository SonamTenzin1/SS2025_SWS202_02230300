package e.g.a.c;

import android.view.View;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewClickOnSubscribe.java */
/* loaded from: classes2.dex */
public final class b implements e.a<Void> {

    /* renamed from: f, reason: collision with root package name */
    final View f21161f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewClickOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21162f;

        a(j jVar) {
            this.f21162f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f21162f.isUnsubscribed()) {
                return;
            }
            this.f21162f.onNext(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewClickOnSubscribe.java */
    /* renamed from: e.g.a.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0269b extends rx.l.a {
        C0269b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            b.this.f21161f.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(View view) {
        this.f21161f = view;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Void> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new C0269b());
        this.f21161f.setOnClickListener(aVar);
    }
}
