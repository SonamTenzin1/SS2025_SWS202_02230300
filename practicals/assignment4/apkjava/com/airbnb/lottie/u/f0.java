package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
public class f0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.s.j.n a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.s.j.b a = g.a(jsonReader, dVar);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                jsonReader.endArray();
            } else if (!nextName.equals("nm")) {
                jsonReader.skipValue();
            } else {
                str = jsonReader.nextString();
            }
        }
        return new com.airbnb.lottie.s.j.n(str, arrayList);
    }
}
