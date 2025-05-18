package com.bumptech.glide.load.n;

import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {
    private final InterfaceC0134b<Data> a;

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.n.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0133a implements InterfaceC0134b<ByteBuffer> {
            C0133a() {
            }

            @Override // com.bumptech.glide.load.n.b.InterfaceC0134b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.n.b.InterfaceC0134b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<byte[], ByteBuffer> b(r rVar) {
            return new b(new C0133a());
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.n.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0134b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.load.m.d<Data> {

        /* renamed from: f, reason: collision with root package name */
        private final byte[] f9295f;

        /* renamed from: g, reason: collision with root package name */
        private final InterfaceC0134b<Data> f9296g;

        c(byte[] bArr, InterfaceC0134b<Data> interfaceC0134b) {
            this.f9295f = bArr;
            this.f9296g = interfaceC0134b;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f9296g.a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            aVar.f(this.f9296g.b(this.f9295f));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* loaded from: classes.dex */
        class a implements InterfaceC0134b<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.b.InterfaceC0134b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.n.b.InterfaceC0134b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<byte[], InputStream> b(r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0134b<Data> interfaceC0134b) {
        this.a = interfaceC0134b;
    }

    @Override // com.bumptech.glide.load.n.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(byte[] bArr, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(bArr), new c(bArr, this.a));
    }

    @Override // com.bumptech.glide.load.n.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }
}
