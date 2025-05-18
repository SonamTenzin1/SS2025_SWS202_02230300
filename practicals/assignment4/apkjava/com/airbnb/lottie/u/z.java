package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.s.j.i;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
public class z {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
    public static com.airbnb.lottie.s.j.i a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        i.a aVar = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        com.airbnb.lottie.s.i.b bVar3 = null;
        com.airbnb.lottie.s.i.b bVar4 = null;
        com.airbnb.lottie.s.i.b bVar5 = null;
        com.airbnb.lottie.s.i.b bVar6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals("p")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 1:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 2:
                    bVar3 = d.e(jsonReader, dVar);
                    break;
                case 3:
                    bVar5 = d.f(jsonReader, dVar, false);
                    break;
                case 4:
                    str = jsonReader.nextString();
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case '\b':
                    aVar = i.a.g(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
