package e.g.a.c;

import android.view.View;

/* compiled from: ViewEvent.java */
/* loaded from: classes2.dex */
public abstract class c<T extends View> {
    private final T a;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(T t) {
        this.a = (T) e.g.a.a.b.a(t, "view == null");
    }

    public T a() {
        return this.a;
    }
}
