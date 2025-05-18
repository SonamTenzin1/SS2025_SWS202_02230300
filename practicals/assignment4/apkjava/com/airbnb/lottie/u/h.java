package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<com.airbnb.lottie.s.b> {
    public static final h a = new h();

    private h() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0029. Please report as an issue. */
    @Override // com.airbnb.lottie.u.j0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.s.b a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 102:
                    if (nextName.equals("f")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 106:
                    if (nextName.equals("j")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3452:
                    if (nextName.equals("lh")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3463:
                    if (nextName.equals("ls")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3543:
                    if (nextName.equals("of")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    i2 = jsonReader.nextInt();
                    break;
                case 2:
                    d2 = jsonReader.nextDouble();
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    i4 = p.d(jsonReader);
                    break;
                case 5:
                    d3 = jsonReader.nextDouble();
                    break;
                case 6:
                    d4 = jsonReader.nextDouble();
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                case '\b':
                    i5 = p.d(jsonReader);
                    break;
                case '\t':
                    d5 = jsonReader.nextDouble();
                    break;
                case '\n':
                    i3 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.b(str, str2, d2, i2, i3, d3, d4, i4, i5, d5, z);
    }
}
