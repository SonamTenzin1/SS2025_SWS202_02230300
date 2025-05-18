package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: b, reason: collision with root package name */
    int f2088b;

    /* renamed from: c, reason: collision with root package name */
    int f2089c;

    /* renamed from: d, reason: collision with root package name */
    int f2090d;

    /* renamed from: e, reason: collision with root package name */
    int f2091e;

    /* renamed from: h, reason: collision with root package name */
    boolean f2094h;

    /* renamed from: i, reason: collision with root package name */
    boolean f2095i;
    boolean a = true;

    /* renamed from: f, reason: collision with root package name */
    int f2092f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f2093g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.z zVar) {
        int i2 = this.f2089c;
        return i2 >= 0 && i2 < zVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o = vVar.o(this.f2089c);
        this.f2089c += this.f2090d;
        return o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2088b + ", mCurrentPosition=" + this.f2089c + ", mItemDirection=" + this.f2090d + ", mLayoutDirection=" + this.f2091e + ", mStartLine=" + this.f2092f + ", mEndLine=" + this.f2093g + '}';
    }
}
