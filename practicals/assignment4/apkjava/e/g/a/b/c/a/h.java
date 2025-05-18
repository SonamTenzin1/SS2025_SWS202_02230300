package e.g.a.b.c.a;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarItemClickOnSubscribe.java */
/* loaded from: classes2.dex */
public final class h implements e.a<MenuItem> {

    /* renamed from: f, reason: collision with root package name */
    final Toolbar f21158f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ToolbarItemClickOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a implements Toolbar.f {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.a.isUnsubscribed()) {
                return true;
            }
            this.a.onNext(menuItem);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ToolbarItemClickOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            h.this.f21158f.setOnMenuItemClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Toolbar toolbar) {
        this.f21158f = toolbar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super MenuItem> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21158f.setOnMenuItemClickListener(aVar);
    }
}
