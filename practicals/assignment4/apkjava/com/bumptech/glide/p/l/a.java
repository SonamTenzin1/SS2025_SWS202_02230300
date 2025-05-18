package com.bumptech.glide.p.l;

import android.graphics.drawable.Drawable;

/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class a<Z> implements i<Z> {
    private com.bumptech.glide.p.d request;

    @Override // com.bumptech.glide.p.l.i
    public com.bumptech.glide.p.d getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.m.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.m.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.m.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void setRequest(com.bumptech.glide.p.d dVar) {
        this.request = dVar;
    }
}
