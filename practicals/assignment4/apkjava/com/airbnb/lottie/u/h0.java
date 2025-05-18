package com.airbnb.lottie.u;

import android.util.JsonReader;
import com.airbnb.lottie.s.j.p;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
public class h0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.s.j.p a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c2;
        char c3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.a aVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        p.b bVar3 = null;
        p.c cVar = null;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 100:
                    if (nextName.equals("d")) {
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
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            c2 = 65535;
            switch (c2) {
                case 0:
                    aVar = d.c(jsonReader, dVar);
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.airbnb.lottie.s.i.b bVar4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (!nextName2.equals("v")) {
                                jsonReader.skipValue();
                            } else {
                                bVar4 = d.e(jsonReader, dVar);
                            }
                        }
                        jsonReader.endObject();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c3 = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                        }
                        c3 = 65535;
                        switch (c3) {
                            case 0:
                            case 1:
                                arrayList.add(bVar4);
                                break;
                            case 2:
                                bVar = bVar4;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                case 2:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 3:
                    bVar2 = d.e(jsonReader, dVar);
                    break;
                case 4:
                    bVar3 = p.b.values()[jsonReader.nextInt() - 1];
                    break;
                case 5:
                    cVar = p.c.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.p(str, bVar, arrayList, aVar, dVar2, bVar2, bVar3, cVar, f2);
    }
}
