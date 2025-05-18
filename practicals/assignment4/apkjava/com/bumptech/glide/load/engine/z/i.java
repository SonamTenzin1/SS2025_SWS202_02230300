package com.bumptech.glide.load.engine.z;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i2) {
        return new int[i2];
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
