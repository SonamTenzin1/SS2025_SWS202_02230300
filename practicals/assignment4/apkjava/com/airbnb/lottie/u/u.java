package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.s.j.g;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaskParser.java */
/* loaded from: classes.dex */
public class u {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.equals("s") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.j.g a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c2;
        jsonReader.beginObject();
        g.a aVar = null;
        com.airbnb.lottie.s.i.h hVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c3 = 2;
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            c2 = 65535;
            switch (c2) {
                case 0:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 1:
                    hVar = d.k(jsonReader, dVar);
                    break;
                case 2:
                    String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                c3 = 0;
                                break;
                            }
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 115:
                            break;
                    }
                    c3 = 65535;
                    switch (c3) {
                        case 0:
                            aVar = g.a.MaskModeAdd;
                            break;
                        case 1:
                            dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = g.a.MaskModeIntersect;
                            break;
                        case 2:
                            aVar = g.a.MaskModeSubtract;
                            break;
                        default:
                            Log.w("LOTTIE", "Unknown mask mode " + nextName + ". Defaulting to Add.");
                            aVar = g.a.MaskModeAdd;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.j.g(aVar, hVar, dVar2);
    }
}
