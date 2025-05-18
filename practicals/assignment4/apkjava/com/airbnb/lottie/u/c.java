package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.i.l a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.airbnb.lottie.s.i.e eVar = null;
        com.airbnb.lottie.s.i.g gVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        com.airbnb.lottie.s.i.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if (jsonReader.nextName().equals("k")) {
                                    eVar = a.a(jsonReader, dVar);
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 1:
                            dVar2 = d.h(jsonReader, dVar);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 2:
                            mVar = a.b(jsonReader, dVar);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 3:
                            break;
                        case 4:
                            gVar = d.j(jsonReader, dVar);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 5:
                            bVar3 = d.f(jsonReader, dVar, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 6:
                            dVar.a("Lottie doesn't support 3D layers.");
                            break;
                        case 7:
                            bVar2 = d.f(jsonReader, dVar, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                    }
                    bVar = d.f(jsonReader, dVar, false);
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c2 = 3;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 4;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3242:
                    if (nextName.equals("eo")) {
                        c2 = 5;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3656:
                    if (nextName.equals("rz")) {
                        c2 = 6;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3676:
                    if (nextName.equals("so")) {
                        c2 = 7;
                    }
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                default:
                    switch (c2) {
                    }
                    bVar = d.f(jsonReader, dVar, false);
                    break;
            }
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new com.airbnb.lottie.s.i.e();
        }
        com.airbnb.lottie.s.i.e eVar2 = eVar;
        if (gVar == null) {
            gVar = new com.airbnb.lottie.s.i.g(new com.airbnb.lottie.w.d(1.0f, 1.0f));
        }
        com.airbnb.lottie.s.i.g gVar2 = gVar;
        if (dVar2 == null) {
            dVar2 = new com.airbnb.lottie.s.i.d();
        }
        return new com.airbnb.lottie.s.i.l(eVar2, mVar, gVar2, bVar, dVar2, bVar2, bVar3);
    }
}
