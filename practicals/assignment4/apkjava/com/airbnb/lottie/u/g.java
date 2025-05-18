package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentModelParser.java */
/* loaded from: classes.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00bd, code lost:
    
        if (r2.equals("gf") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.j.b a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        com.airbnb.lottie.s.j.b bVar;
        String str;
        jsonReader.beginObject();
        char c2 = 2;
        int i2 = 2;
        while (true) {
            bVar = null;
            if (!jsonReader.hasNext()) {
                str = null;
                break;
            }
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("d")) {
                if (!nextName.equals("ty")) {
                    jsonReader.skipValue();
                } else {
                    str = jsonReader.nextString();
                    break;
                }
            } else {
                i2 = jsonReader.nextInt();
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3488:
                if (str.equals("mm")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                bVar = e.a(jsonReader, dVar, i2);
                break;
            case 1:
                bVar = e0.a(jsonReader, dVar);
                break;
            case 2:
                bVar = m.a(jsonReader, dVar);
                break;
            case 3:
                bVar = f0.a(jsonReader, dVar);
                break;
            case 4:
                bVar = n.a(jsonReader, dVar);
                break;
            case 5:
                bVar = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVar = a0.a(jsonReader, dVar);
                break;
            case 7:
                bVar = b0.a(jsonReader, dVar);
                break;
            case '\b':
                bVar = g0.a(jsonReader, dVar);
                break;
            case '\t':
                bVar = z.a(jsonReader, dVar);
                break;
            case '\n':
                bVar = h0.a(jsonReader, dVar);
                break;
            case 11:
                bVar = i0.a(jsonReader, dVar);
                break;
            case '\f':
                bVar = c.a(jsonReader, dVar);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + str);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return bVar;
    }
}
