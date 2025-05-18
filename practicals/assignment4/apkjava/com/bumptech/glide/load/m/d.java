package com.bumptech.glide.load.m;

/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface d<T> {

    /* compiled from: DataFetcher.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void c(Exception exc);

        void f(T t);
    }

    Class<T> a();

    void b();

    void cancel();

    com.bumptech.glide.load.a d();

    void e(com.bumptech.glide.g gVar, a<? super T> aVar);
}
