package com.bumptech.glide.load.o.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements u<T>, q {

    /* renamed from: f, reason: collision with root package name */
    protected final T f9410f;

    public b(T t) {
        this.f9410f = (T) j.d(t);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        T t = this.f9410f;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.bumptech.glide.load.o.g.c) {
            ((com.bumptech.glide.load.o.g.c) t).e().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f9410f.getConstantState();
        if (constantState == null) {
            return this.f9410f;
        }
        return (T) constantState.newDrawable();
    }
}
