package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<com.airbnb.lottie.w.d> {
    public static final c0 a = new c0();

    private c0() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.w.d a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.airbnb.lottie.w.d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
    }
}
