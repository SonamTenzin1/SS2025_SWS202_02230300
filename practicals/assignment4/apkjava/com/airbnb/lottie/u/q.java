package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {
    private static final Interpolator a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private static c.e.h<WeakReference<Interpolator>> f8849b;

    q() {
    }

    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> g2;
        synchronized (q.class) {
            g2 = e().g(i2);
        }
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.airbnb.lottie.w.a<T> b(JsonReader jsonReader, com.airbnb.lottie.d dVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        if (z) {
            return c(dVar, jsonReader, f2, j0Var);
        }
        return d(jsonReader, f2, j0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0085 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> com.airbnb.lottie.w.a<T> c(com.airbnb.lottie.d dVar, JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            t2 = j0Var.a(jsonReader, f2);
                            break;
                        case 1:
                            if (jsonReader.nextInt() != 1) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        case 2:
                            pointF2 = p.e(jsonReader, f2);
                            break;
                        case 3:
                            pointF = p.e(jsonReader, f2);
                            break;
                        case 4:
                            t = j0Var.a(jsonReader, f2);
                            break;
                        case 5:
                            f3 = (float) jsonReader.nextDouble();
                            break;
                        case 6:
                            pointF4 = p.e(jsonReader, f2);
                            break;
                        case 7:
                            pointF3 = p.e(jsonReader, f2);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                case 104:
                    if (nextName.equals("h")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 3;
                    }
                    switch (c2) {
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 4;
                    }
                    switch (c2) {
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 5;
                    }
                    switch (c2) {
                    }
                    break;
                case 3701:
                    if (nextName.equals("ti")) {
                        c2 = 6;
                    }
                    switch (c2) {
                    }
                    break;
                case 3707:
                    if (nextName.equals("to")) {
                        c2 = 7;
                    }
                    switch (c2) {
                    }
                    break;
                default:
                    switch (c2) {
                    }
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = a;
            t2 = t;
        } else if (pointF != null && pointF2 != null) {
            float f4 = -f2;
            pointF.x = com.airbnb.lottie.v.e.b(pointF.x, f4, f2);
            pointF.y = com.airbnb.lottie.v.e.b(pointF.y, -100.0f, 100.0f);
            pointF2.x = com.airbnb.lottie.v.e.b(pointF2.x, f4, f2);
            float b2 = com.airbnb.lottie.v.e.b(pointF2.y, -100.0f, 100.0f);
            pointF2.y = b2;
            int g2 = com.airbnb.lottie.v.f.g(pointF.x, pointF.y, pointF2.x, b2);
            WeakReference<Interpolator> a2 = a(g2);
            Interpolator interpolator2 = a2 != null ? a2.get() : null;
            if (a2 == null || interpolator2 == null) {
                interpolator2 = androidx.core.view.e0.b.a(pointF.x / f2, pointF.y / f2, pointF2.x / f2, pointF2.y / f2);
                try {
                    f(g2, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolator2;
        } else {
            interpolator = a;
        }
        com.airbnb.lottie.w.a<T> aVar = new com.airbnb.lottie.w.a<>(dVar, t, t2, interpolator, f3, null);
        aVar.f8869i = pointF3;
        aVar.f8870j = pointF4;
        return aVar;
    }

    private static <T> com.airbnb.lottie.w.a<T> d(JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        return new com.airbnb.lottie.w.a<>(j0Var.a(jsonReader, f2));
    }

    private static c.e.h<WeakReference<Interpolator>> e() {
        if (f8849b == null) {
            f8849b = new c.e.h<>();
        }
        return f8849b;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f8849b.k(i2, weakReference);
        }
    }
}
