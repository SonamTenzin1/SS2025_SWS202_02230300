package com.airbnb.lottie.u;

import android.util.JsonReader;
import com.airbnb.lottie.s.j.q;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class i0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static com.airbnb.lottie.s.j.q a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        q.a aVar = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        com.airbnb.lottie.s.i.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 109:
                    if (nextName.equals("m")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
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
            }
            switch (c2) {
                case 0:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 1:
                    aVar = q.a.g(jsonReader.nextInt());
                    break;
                case 2:
                    bVar3 = d.f(jsonReader, dVar, false);
                    break;
                case 3:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 4:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.q(str, aVar, bVar, bVar2, bVar3);
    }
}
