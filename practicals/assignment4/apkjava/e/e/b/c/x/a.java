package e.e.b.c.x;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback.java */
/* loaded from: classes2.dex */
public final class a extends f {
    private final Typeface a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0262a f21083b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21084c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: e.e.b.c.x.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0262a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0262a interfaceC0262a, Typeface typeface) {
        this.a = typeface;
        this.f21083b = interfaceC0262a;
    }

    private void d(Typeface typeface) {
        if (this.f21084c) {
            return;
        }
        this.f21083b.a(typeface);
    }

    @Override // e.e.b.c.x.f
    public void a(int i2) {
        d(this.a);
    }

    @Override // e.e.b.c.x.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f21084c = true;
    }
}
