package c.x;

import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class l {
    private ViewGroup a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f3588b;

    public static l b(ViewGroup viewGroup) {
        return (l) viewGroup.getTag(j.f3573c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.f3573c, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.a) != this || (runnable = this.f3588b) == null) {
            return;
        }
        runnable.run();
    }
}
