package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* compiled from: PathKeyframeParser.java */
/* loaded from: classes.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.q.b.h a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.q.b.h(dVar, q.b(jsonReader, dVar, com.airbnb.lottie.v.f.e(), x.a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
