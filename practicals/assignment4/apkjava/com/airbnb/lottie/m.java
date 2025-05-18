package com.airbnb.lottie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class m {
    private boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set<b> f8552b = new c.e.b();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, com.airbnb.lottie.v.d> f8553c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator<c.i.j.e<String, Float>> f8554d = new a();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    class a implements Comparator<c.i.j.e<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c.i.j.e<String, Float> eVar, c.i.j.e<String, Float> eVar2) {
            float floatValue = eVar.f3281b.floatValue();
            float floatValue2 = eVar2.f3281b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.a) {
            com.airbnb.lottie.v.d dVar = this.f8553c.get(str);
            if (dVar == null) {
                dVar = new com.airbnb.lottie.v.d();
                this.f8553c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                Iterator<b> it = this.f8552b.iterator();
                while (it.hasNext()) {
                    it.next().a(f2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}
