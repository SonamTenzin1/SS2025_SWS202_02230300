package com.airbnb.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class e0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0057 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.j.m a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        com.airbnb.lottie.s.i.a aVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        int i2 = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -396065730:
                    if (nextName.equals("fillEnabled")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            aVar = d.c(jsonReader, dVar);
                            break;
                        case 2:
                            dVar2 = d.h(jsonReader, dVar);
                            break;
                        case 3:
                            i2 = jsonReader.nextInt();
                            break;
                        case 4:
                            str = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                case 99:
                    if (nextName.equals("c")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c2 = 3;
                    }
                    switch (c2) {
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 4;
                    }
                    switch (c2) {
                    }
                    break;
                default:
                    switch (c2) {
                    }
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2);
    }
}
