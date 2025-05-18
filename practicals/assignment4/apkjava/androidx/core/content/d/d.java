package androidx.core.content.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class d {
    private static a a(a aVar, int i2, int i3, boolean z, int i4) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i2, i4, i3);
        }
        return new a(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray s = g.s(resources, theme, attributeSet, c.i.d.y);
            float j2 = g.j(s, xmlPullParser, "startX", c.i.d.H, 0.0f);
            float j3 = g.j(s, xmlPullParser, "startY", c.i.d.I, 0.0f);
            float j4 = g.j(s, xmlPullParser, "endX", c.i.d.J, 0.0f);
            float j5 = g.j(s, xmlPullParser, "endY", c.i.d.K, 0.0f);
            float j6 = g.j(s, xmlPullParser, "centerX", c.i.d.C, 0.0f);
            float j7 = g.j(s, xmlPullParser, "centerY", c.i.d.D, 0.0f);
            int k2 = g.k(s, xmlPullParser, "type", c.i.d.B, 0);
            int f2 = g.f(s, xmlPullParser, "startColor", c.i.d.z, 0);
            boolean r = g.r(xmlPullParser, "centerColor");
            int f3 = g.f(s, xmlPullParser, "centerColor", c.i.d.G, 0);
            int f4 = g.f(s, xmlPullParser, "endColor", c.i.d.A, 0);
            int k3 = g.k(s, xmlPullParser, "tileMode", c.i.d.F, 0);
            float j8 = g.j(s, xmlPullParser, "gradientRadius", c.i.d.E, 0.0f);
            s.recycle();
            a a2 = a(c(resources, xmlPullParser, attributeSet, theme), f2, f4, r, f3);
            if (k2 != 1) {
                if (k2 != 2) {
                    return new LinearGradient(j2, j3, j4, j5, a2.a, a2.f953b, d(k3));
                }
                return new SweepGradient(j6, j7, a2.a, a2.f953b);
            }
            if (j8 > 0.0f) {
                return new RadialGradient(j6, j7, j8, a2.a, a2.f953b, d(k3));
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray s = g.s(resources, theme, attributeSet, c.i.d.L);
                int i2 = c.i.d.M;
                boolean hasValue = s.hasValue(i2);
                int i3 = c.i.d.N;
                boolean hasValue2 = s.hasValue(i3);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = s.getColor(i2, 0);
                float f2 = s.getFloat(i3, 0.0f);
                s.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f2));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i2) {
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {
        final int[] a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f953b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.f953b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.a[i2] = list.get(i2).intValue();
                this.f953b[i2] = list2.get(i2).floatValue();
            }
        }

        a(int i2, int i3) {
            this.a = new int[]{i2, i3};
            this.f953b = new float[]{0.0f, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.a = new int[]{i2, i3, i4};
            this.f953b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
