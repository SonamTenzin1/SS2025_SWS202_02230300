package com.airbnb.lottie.q.a;

import com.airbnb.lottie.q.b.a;
import com.airbnb.lottie.s.j.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class r implements b, a.InterfaceC0118a {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a.InterfaceC0118a> f8645b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final q.a f8646c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8647d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8648e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8649f;

    public r(com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.q qVar) {
        this.a = qVar.c();
        this.f8646c = qVar.f();
        com.airbnb.lottie.q.b.a<Float, Float> a = qVar.e().a();
        this.f8647d = a;
        com.airbnb.lottie.q.b.a<Float, Float> a2 = qVar.b().a();
        this.f8648e = a2;
        com.airbnb.lottie.q.b.a<Float, Float> a3 = qVar.d().a();
        this.f8649f = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        for (int i2 = 0; i2 < this.f8645b.size(); i2++) {
            this.f8645b.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.InterfaceC0118a interfaceC0118a) {
        this.f8645b.add(interfaceC0118a);
    }

    public com.airbnb.lottie.q.b.a<?, Float> e() {
        return this.f8648e;
    }

    public com.airbnb.lottie.q.b.a<?, Float> h() {
        return this.f8649f;
    }

    public com.airbnb.lottie.q.b.a<?, Float> i() {
        return this.f8647d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q.a j() {
        return this.f8646c;
    }
}
