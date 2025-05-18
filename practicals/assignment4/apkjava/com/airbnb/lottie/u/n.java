package com.airbnb.lottie.u;

import android.util.JsonReader;
import com.airbnb.lottie.s.j.p;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.s.j.e a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c2;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.airbnb.lottie.s.j.f fVar = null;
        com.airbnb.lottie.s.i.c cVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        com.airbnb.lottie.s.i.f fVar2 = null;
        com.airbnb.lottie.s.i.f fVar3 = null;
        com.airbnb.lottie.s.i.b bVar = null;
        p.b bVar2 = null;
        p.c cVar2 = null;
        float f2 = 0.0f;
        com.airbnb.lottie.s.i.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            com.airbnb.lottie.s.i.b bVar4 = bVar3;
            float f3 = f2;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals("g")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
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
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            c2 = 65535;
            switch (c2) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.airbnb.lottie.s.i.b bVar5 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            p.c cVar3 = cVar2;
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (!nextName2.equals("v")) {
                                jsonReader.skipValue();
                            } else {
                                bVar5 = d.e(jsonReader, dVar);
                            }
                            cVar2 = cVar3;
                        }
                        p.c cVar4 = cVar2;
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            bVar4 = bVar5;
                        } else if (str2.equals("d") || str2.equals("g")) {
                            arrayList.add(bVar5);
                        }
                        cVar2 = cVar4;
                    }
                    p.c cVar5 = cVar2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar3 = bVar4;
                    f2 = f3;
                    cVar2 = cVar5;
                    continue;
                case 1:
                    fVar3 = d.i(jsonReader, dVar);
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i2 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        if (nextName3.equals("k")) {
                            cVar = d.g(jsonReader, dVar, i2);
                        } else if (!nextName3.equals("p")) {
                            jsonReader.skipValue();
                        } else {
                            i2 = jsonReader.nextInt();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 3:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 4:
                    fVar2 = d.i(jsonReader, dVar);
                    break;
                case 5:
                    fVar = jsonReader.nextInt() == 1 ? com.airbnb.lottie.s.j.f.Linear : com.airbnb.lottie.s.j.f.Radial;
                    break;
                case 6:
                    bVar = d.e(jsonReader, dVar);
                    break;
                case 7:
                    bVar2 = p.b.values()[jsonReader.nextInt() - 1];
                    break;
                case '\b':
                    cVar2 = p.c.values()[jsonReader.nextInt() - 1];
                    break;
                case '\t':
                    f2 = (float) jsonReader.nextDouble();
                    bVar3 = bVar4;
                    continue;
                case '\n':
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            bVar3 = bVar4;
            f2 = f3;
        }
        return new com.airbnb.lottie.s.j.e(str, fVar, cVar, dVar2, fVar2, fVar3, bVar, bVar2, cVar2, f2, arrayList, bVar3);
    }
}
