package com.bumptech.glide.q;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: EmptySignature.java */
/* loaded from: classes.dex */
public final class b implements f {

    /* renamed from: b, reason: collision with root package name */
    private static final b f9537b = new b();

    private b() {
    }

    public static b a() {
        return f9537b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
