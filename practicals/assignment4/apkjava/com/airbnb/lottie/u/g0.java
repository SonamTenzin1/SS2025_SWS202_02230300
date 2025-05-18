package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
class g0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    public static com.airbnb.lottie.s.j.o a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        com.airbnb.lottie.s.i.h hVar = null;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3432:
                    if (nextName.equals("ks")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    hVar = d.k(jsonReader, dVar);
                    break;
                case 1:
                    str = jsonReader.nextString();
                    break;
                case 2:
                    i2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.o(str, i2, hVar);
    }
}
