package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class d0 implements j0<com.airbnb.lottie.s.j.l> {
    public static final d0 a = new d0();

    private d0() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:
    
        if (r5.equals("i") == false) goto L10;
     */
    @Override // com.airbnb.lottie.u.j0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.airbnb.lottie.s.j.l a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (true) {
            char c2 = 1;
            if (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case 99:
                        if (nextName.equals("c")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 105:
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 118:
                        if (nextName.equals("v")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                c2 = 65535;
                switch (c2) {
                    case 0:
                        z = jsonReader.nextBoolean();
                        break;
                    case 1:
                        list2 = p.f(jsonReader, f2);
                        break;
                    case 2:
                        list3 = p.f(jsonReader, f2);
                        break;
                    case 3:
                        list = p.f(jsonReader, f2);
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (list != null && list2 != null && list3 != null) {
                    if (list.isEmpty()) {
                        return new com.airbnb.lottie.s.j.l(new PointF(), false, Collections.emptyList());
                    }
                    int size = list.size();
                    PointF pointF = list.get(0);
                    ArrayList arrayList = new ArrayList(size);
                    for (int i2 = 1; i2 < size; i2++) {
                        PointF pointF2 = list.get(i2);
                        int i3 = i2 - 1;
                        arrayList.add(new com.airbnb.lottie.s.a(com.airbnb.lottie.v.e.a(list.get(i3), list3.get(i3)), com.airbnb.lottie.v.e.a(pointF2, list2.get(i2)), pointF2));
                    }
                    if (z) {
                        PointF pointF3 = list.get(0);
                        int i4 = size - 1;
                        arrayList.add(new com.airbnb.lottie.s.a(com.airbnb.lottie.v.e.a(list.get(i4), list3.get(i4)), com.airbnb.lottie.v.e.a(pointF3, list2.get(0)), pointF3));
                    }
                    return new com.airbnb.lottie.s.j.l(pointF, z, arrayList);
                }
                throw new IllegalArgumentException("Shape data was missing information.");
            }
        }
    }
}
