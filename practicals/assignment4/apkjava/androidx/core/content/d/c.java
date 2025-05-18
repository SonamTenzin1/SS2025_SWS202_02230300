package androidx.core.content.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {
        private final C0022c[] a;

        public b(C0022c[] c0022cArr) {
            this.a = c0022cArr;
        }

        public C0022c[] a() {
            return this.a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.d.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0022c {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private int f945b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f946c;

        /* renamed from: d, reason: collision with root package name */
        private String f947d;

        /* renamed from: e, reason: collision with root package name */
        private int f948e;

        /* renamed from: f, reason: collision with root package name */
        private int f949f;

        public C0022c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.a = str;
            this.f945b = i2;
            this.f946c = z;
            this.f947d = str2;
            this.f948e = i3;
            this.f949f = i4;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f949f;
        }

        public int c() {
            return this.f948e;
        }

        public String d() {
            return this.f947d;
        }

        public int e() {
            return this.f945b;
        }

        public boolean f() {
            return this.f946c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {
        private final c.i.h.d a;

        /* renamed from: b, reason: collision with root package name */
        private final int f950b;

        /* renamed from: c, reason: collision with root package name */
        private final int f951c;

        /* renamed from: d, reason: collision with root package name */
        private final String f952d;

        public d(c.i.h.d dVar, int i2, int i3, String str) {
            this.a = dVar;
            this.f951c = i2;
            this.f950b = i3;
            this.f952d = str;
        }

        public int a() {
            return this.f951c;
        }

        public c.i.h.d b() {
            return this.a;
        }

        public String c() {
            return this.f952d;
        }

        public int d() {
            return this.f950b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.i.d.f3182f);
        String string = obtainAttributes.getString(c.i.d.f3183g);
        String string2 = obtainAttributes.getString(c.i.d.f3187k);
        String string3 = obtainAttributes.getString(c.i.d.l);
        int resourceId = obtainAttributes.getResourceId(c.i.d.f3184h, 0);
        int integer = obtainAttributes.getInteger(c.i.d.f3185i, 1);
        int integer2 = obtainAttributes.getInteger(c.i.d.f3186j, 500);
        String string4 = obtainAttributes.getString(c.i.d.m);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new c.i.h.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0022c[]) arrayList.toArray(new C0022c[arrayList.size()]));
    }

    private static C0022c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.i.d.n);
        int i2 = c.i.d.w;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = c.i.d.p;
        }
        int i3 = obtainAttributes.getInt(i2, 400);
        int i4 = c.i.d.u;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = c.i.d.q;
        }
        boolean z = 1 == obtainAttributes.getInt(i4, 0);
        int i5 = c.i.d.x;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = c.i.d.r;
        }
        int i6 = c.i.d.v;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = c.i.d.s;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = c.i.d.t;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = c.i.d.o;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0022c(string2, i3, z, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
