package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class d {
    private final m a = new m();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<String> f8495b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.s.k.d>> f8496c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, g> f8497d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, com.airbnb.lottie.s.c> f8498e;

    /* renamed from: f, reason: collision with root package name */
    private c.e.h<com.airbnb.lottie.s.d> f8499f;

    /* renamed from: g, reason: collision with root package name */
    private c.e.d<com.airbnb.lottie.s.k.d> f8500g;

    /* renamed from: h, reason: collision with root package name */
    private List<com.airbnb.lottie.s.k.d> f8501h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f8502i;

    /* renamed from: j, reason: collision with root package name */
    private float f8503j;

    /* renamed from: k, reason: collision with root package name */
    private float f8504k;
    private float l;

    public void a(String str) {
        Log.w("LOTTIE", str);
        this.f8495b.add(str);
    }

    public Rect b() {
        return this.f8502i;
    }

    public c.e.h<com.airbnb.lottie.s.d> c() {
        return this.f8499f;
    }

    public float d() {
        return (e() / this.l) * 1000.0f;
    }

    public float e() {
        return this.f8504k - this.f8503j;
    }

    public float f() {
        return this.f8504k;
    }

    public Map<String, com.airbnb.lottie.s.c> g() {
        return this.f8498e;
    }

    public float h() {
        return this.l;
    }

    public Map<String, g> i() {
        return this.f8497d;
    }

    public List<com.airbnb.lottie.s.k.d> j() {
        return this.f8501h;
    }

    public m k() {
        return this.a;
    }

    public List<com.airbnb.lottie.s.k.d> l(String str) {
        return this.f8496c.get(str);
    }

    public float m() {
        return this.f8503j;
    }

    public void n(Rect rect, float f2, float f3, float f4, List<com.airbnb.lottie.s.k.d> list, c.e.d<com.airbnb.lottie.s.k.d> dVar, Map<String, List<com.airbnb.lottie.s.k.d>> map, Map<String, g> map2, c.e.h<com.airbnb.lottie.s.d> hVar, Map<String, com.airbnb.lottie.s.c> map3) {
        this.f8502i = rect;
        this.f8503j = f2;
        this.f8504k = f3;
        this.l = f4;
        this.f8501h = list;
        this.f8500g = dVar;
        this.f8496c = map;
        this.f8497d = map2;
        this.f8499f = hVar;
        this.f8498e = map3;
    }

    public com.airbnb.lottie.s.k.d o(long j2) {
        return this.f8500g.g(j2);
    }

    public void p(boolean z) {
        this.a.b(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.airbnb.lottie.s.k.d> it = this.f8501h.iterator();
        while (it.hasNext()) {
            sb.append(it.next().v("\t"));
        }
        return sb.toString();
    }
}
