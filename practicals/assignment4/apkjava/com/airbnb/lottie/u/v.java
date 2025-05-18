package com.airbnb.lottie.u;

import android.util.JsonReader;
import com.airbnb.lottie.s.j.h;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.s.j.h a(JsonReader jsonReader) throws IOException {
        String str = null;
        h.a aVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("mm")) {
                aVar = h.a.g(jsonReader.nextInt());
            } else if (!nextName.equals("nm")) {
                jsonReader.skipValue();
            } else {
                str = jsonReader.nextString();
            }
        }
        return new com.airbnb.lottie.s.j.h(str, aVar);
    }
}
