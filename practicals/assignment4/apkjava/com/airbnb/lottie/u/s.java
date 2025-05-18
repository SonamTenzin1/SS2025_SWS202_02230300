package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.s.k.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {
    /* JADX WARN: Removed duplicated region for block: B:101:0x022a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0316 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x017d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0222 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.s.k.d a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        d.b bVar = d.b.None;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        d.a aVar = null;
        String str = null;
        com.airbnb.lottie.s.i.l lVar = null;
        com.airbnb.lottie.s.i.j jVar = null;
        com.airbnb.lottie.s.i.k kVar = null;
        com.airbnb.lottie.s.i.b bVar3 = null;
        long j2 = 0;
        long j3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c2 = 0;
                    }
                    switch (c2) {
                        case 0:
                            j3 = jsonReader.nextInt();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 1:
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                com.airbnb.lottie.s.j.b a = g.a(jsonReader, dVar);
                                if (a != null) {
                                    arrayList4.add(a);
                                }
                            }
                            jsonReader.endArray();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 2:
                            i6 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 3:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                nextName2.hashCode();
                                if (nextName2.equals("a")) {
                                    jsonReader.beginArray();
                                    if (jsonReader.hasNext()) {
                                        kVar = b.a(jsonReader, dVar);
                                    }
                                    while (jsonReader.hasNext()) {
                                        jsonReader.skipValue();
                                    }
                                    jsonReader.endArray();
                                } else if (!nextName2.equals("d")) {
                                    jsonReader.skipValue();
                                } else {
                                    jVar = d.d(jsonReader, dVar);
                                }
                            }
                            jsonReader.endObject();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 4:
                            i5 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 5:
                            str2 = jsonReader.nextString();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 6:
                            jsonReader.beginArray();
                            ArrayList arrayList5 = new ArrayList();
                            while (jsonReader.hasNext()) {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName3 = jsonReader.nextName();
                                    nextName3.hashCode();
                                    if (!nextName3.equals("nm")) {
                                        jsonReader.skipValue();
                                    } else {
                                        arrayList5.add(jsonReader.nextString());
                                    }
                                }
                                jsonReader.endObject();
                            }
                            jsonReader.endArray();
                            dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 7:
                            f2 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\b':
                            lVar = c.a(jsonReader, dVar);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\t':
                            str3 = jsonReader.nextString();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\n':
                            f3 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 11:
                            i4 = Color.parseColor(jsonReader.nextString());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\f':
                            i3 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\r':
                            f4 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 14:
                            f5 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 15:
                            i2 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 16:
                            bVar3 = d.f(jsonReader, dVar, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 17:
                            bVar2 = d.b.values()[jsonReader.nextInt()];
                            break;
                        case 18:
                            int nextInt = jsonReader.nextInt();
                            aVar = d.a.Unknown;
                            if (nextInt < aVar.ordinal()) {
                                aVar = d.a.values()[nextInt];
                                break;
                            }
                            break;
                        case 19:
                            j2 = jsonReader.nextInt();
                            break;
                        case 20:
                            str = jsonReader.nextString();
                            break;
                        case 21:
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList3.add(u.a(jsonReader, dVar));
                            }
                            jsonReader.endArray();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c2 = 1;
                    }
                    switch (c2) {
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c2 = 2;
                    }
                    switch (c2) {
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 3;
                    }
                    switch (c2) {
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 4;
                    }
                    switch (c2) {
                    }
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c2 = 5;
                    }
                    switch (c2) {
                    }
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c2 = 6;
                    }
                    switch (c2) {
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c2 = 7;
                    }
                    switch (c2) {
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c2 = '\b';
                    }
                    switch (c2) {
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = '\t';
                    }
                    switch (c2) {
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c2 = '\n';
                    }
                    switch (c2) {
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c2 = 11;
                    }
                    switch (c2) {
                    }
                    break;
                case 3669:
                    if (nextName.equals("sh")) {
                        c2 = '\f';
                    }
                    switch (c2) {
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c2 = '\r';
                    }
                    switch (c2) {
                    }
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c2 = 14;
                    }
                    switch (c2) {
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c2 = 15;
                    }
                    switch (c2) {
                    }
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c2 = 16;
                    }
                    switch (c2) {
                    }
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        c2 = 17;
                    }
                    switch (c2) {
                    }
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c2 = 18;
                    }
                    switch (c2) {
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c2 = 19;
                    }
                    switch (c2) {
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c2 = 20;
                    }
                    switch (c2) {
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c2 = 21;
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
        jsonReader.endObject();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.w.a(dVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = dVar.f();
        }
        arrayList2.add(new com.airbnb.lottie.w.a(dVar, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new com.airbnb.lottie.w.a(dVar, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.s.k.d(arrayList4, dVar, str3, j2, aVar, j3, str, arrayList, lVar, i2, i3, i4, f4, f5, i5, i6, jVar, kVar, arrayList2, bVar2, bVar3);
    }

    public static com.airbnb.lottie.s.k.d b(com.airbnb.lottie.d dVar) {
        Rect b2 = dVar.b();
        return new com.airbnb.lottie.s.k.d(Collections.emptyList(), dVar, "__container", -1L, d.a.PreComp, -1L, null, Collections.emptyList(), new com.airbnb.lottie.s.i.l(), 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), null, null, Collections.emptyList(), d.b.None, null);
    }
}
