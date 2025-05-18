package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class a0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    public static com.airbnb.lottie.s.j.j a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.s.i.f fVar = null;
        com.airbnb.lottie.s.i.b bVar = null;
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
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 1:
                    bVar = d.e(jsonReader, dVar);
                    break;
                case 2:
                    fVar = d.i(jsonReader, dVar);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.j(str, mVar, fVar, bVar);
    }
}
