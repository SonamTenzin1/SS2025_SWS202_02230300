package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {
    public static com.airbnb.lottie.s.i.e a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.w.a(p.e(jsonReader, com.airbnb.lottie.v.f.e())));
        }
        return new com.airbnb.lottie.s.i.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.i.m<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.e eVar = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals("k")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            eVar = a(jsonReader, dVar);
                            continue;
                            continue;
                            continue;
                            continue;
                        case 1:
                            if (jsonReader.peek() == JsonToken.STRING) {
                                jsonReader.skipValue();
                                break;
                            } else {
                                bVar = d.e(jsonReader, dVar);
                                break;
                            }
                        case 2:
                            if (jsonReader.peek() == JsonToken.STRING) {
                                jsonReader.skipValue();
                                break;
                            } else {
                                bVar2 = d.e(jsonReader, dVar);
                                break;
                            }
                        default:
                            jsonReader.skipValue();
                            continue;
                            continue;
                            continue;
                            continue;
                    }
                    z = true;
                case 120:
                    if (nextName.equals("x")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    z = true;
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    z = true;
                    break;
                default:
                    switch (c2) {
                    }
                    z = true;
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.airbnb.lottie.s.i.i(bVar, bVar2);
    }
}
