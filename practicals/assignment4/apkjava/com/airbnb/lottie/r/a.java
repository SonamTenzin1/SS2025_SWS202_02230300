package com.airbnb.lottie.r;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.s.h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f8679d;

    /* renamed from: e, reason: collision with root package name */
    private com.airbnb.lottie.a f8680e;
    private final h<String> a = new h<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<h<String>, Typeface> f8677b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Typeface> f8678c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private String f8681f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f8679d = null;
        } else {
            this.f8679d = ((View) callback).getContext().getAssets();
        }
    }

    private Typeface a(String str) {
        Typeface typeface = this.f8678c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.a aVar = this.f8680e;
        if (aVar != null) {
            throw null;
        }
        if (aVar != null) {
            throw null;
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f8679d, "fonts/" + str + this.f8681f);
        this.f8678c.put(str, createFromAsset);
        return createFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.f8677b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f8677b.put(this.a, d2);
        return d2;
    }

    public void c(com.airbnb.lottie.a aVar) {
    }
}
