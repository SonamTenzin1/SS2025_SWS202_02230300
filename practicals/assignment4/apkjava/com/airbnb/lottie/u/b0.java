package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
class b0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    public static com.airbnb.lottie.s.j.k a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        com.airbnb.lottie.s.i.l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 1:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    lVar = c.a(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.k(str, bVar, bVar2, lVar);
    }
}
