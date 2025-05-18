package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcxn {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15734b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15735c;

    public zzcxn(int i2, int i3, boolean z) {
        this.a = i2;
        this.f15734b = i3;
        this.f15735c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzcxn> a(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzcxn(i2, i3, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
