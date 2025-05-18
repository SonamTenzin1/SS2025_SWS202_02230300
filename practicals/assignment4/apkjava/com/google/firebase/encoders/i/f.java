package com.google.firebase.encoders.i;

/* compiled from: Protobuf.java */
/* loaded from: classes.dex */
public @interface f {

    /* compiled from: Protobuf.java */
    /* loaded from: classes.dex */
    public enum a {
        DEFAULT,
        SIGNED,
        FIXED
    }

    a intEncoding() default a.DEFAULT;

    int tag();
}
