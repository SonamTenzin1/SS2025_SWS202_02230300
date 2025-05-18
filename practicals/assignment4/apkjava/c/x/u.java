package c.x;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
public class u extends z implements w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u g(ViewGroup viewGroup) {
        return (u) z.e(viewGroup);
    }

    @Override // c.x.w
    public void c(View view) {
        this.a.b(view);
    }

    @Override // c.x.w
    public void d(View view) {
        this.a.g(view);
    }
}
