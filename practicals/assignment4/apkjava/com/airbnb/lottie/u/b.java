package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {
    public static com.airbnb.lottie.s.i.k a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("a")) {
                jsonReader.skipValue();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new com.airbnb.lottie.s.i.k(null, null, null, null) : kVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static com.airbnb.lottie.s.i.k b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.a aVar = null;
        com.airbnb.lottie.s.i.a aVar2 = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    bVar2 = d.e(jsonReader, dVar);
                    break;
                case 1:
                    aVar = d.c(jsonReader, dVar);
                    break;
                case 2:
                    aVar2 = d.c(jsonReader, dVar);
                    break;
                case 3:
                    bVar = d.e(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.i.k(aVar, aVar2, bVar, bVar2);
    }
}
