package com.bumptech.glide.p;

import com.bumptech.glide.load.engine.GlideException;

/* compiled from: RequestListener.java */
/* loaded from: classes.dex */
public interface g<R> {
    boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.p.l.i<R> iVar, boolean z);

    boolean onResourceReady(R r, Object obj, com.bumptech.glide.p.l.i<R> iVar, com.bumptech.glide.load.a aVar, boolean z);
}
