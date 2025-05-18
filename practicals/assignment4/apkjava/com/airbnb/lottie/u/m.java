package com.airbnb.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
public class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.s.j.d a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c2;
        String str = null;
        com.airbnb.lottie.s.j.f fVar = null;
        Path.FillType fillType = null;
        com.airbnb.lottie.s.i.c cVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        com.airbnb.lottie.s.i.f fVar2 = null;
        com.airbnb.lottie.s.i.f fVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            int i2 = -1;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals("g")) {
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
                case 114:
                    if (nextName.equals("r")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            c2 = 65535;
            switch (c2) {
                case 0:
                    fVar3 = d.i(jsonReader, dVar);
                    break;
                case 1:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("k")) {
                            cVar = d.g(jsonReader, dVar, i2);
                        } else if (!nextName2.equals("p")) {
                            jsonReader.skipValue();
                        } else {
                            i2 = jsonReader.nextInt();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 3:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 4:
                    fVar2 = d.i(jsonReader, dVar);
                    break;
                case 5:
                    fVar = jsonReader.nextInt() == 1 ? com.airbnb.lottie.s.j.f.Linear : com.airbnb.lottie.s.j.f.Radial;
                    break;
                case 6:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.d(str, fVar, fillType, cVar, dVar2, fVar2, fVar3, null, null);
    }
}
