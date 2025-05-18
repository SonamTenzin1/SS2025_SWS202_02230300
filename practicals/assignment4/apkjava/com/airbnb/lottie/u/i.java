package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* loaded from: classes.dex */
public class i implements j0<Float> {
    public static final i a = new i();

    private i() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f2) throws IOException {
        return Float.valueOf(p.g(jsonReader) * f2);
    }
}
