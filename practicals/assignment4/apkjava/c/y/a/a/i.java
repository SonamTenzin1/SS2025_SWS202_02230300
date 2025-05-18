package c.y.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.recyclerview.widget.RecyclerView;
import c.i.e.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends c.y.a.a.h {

    /* renamed from: g, reason: collision with root package name */
    static final PorterDuff.Mode f3645g = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    private h f3646h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f3647i;

    /* renamed from: j, reason: collision with root package name */
    private ColorFilter f3648j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3649k;
    private boolean l;
    private Drawable.ConstantState m;
    private final float[] n;
    private final Matrix o;
    private final Rect p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3667b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.a = c.i.e.c.d(string2);
            }
            this.f3668c = androidx.core.content.d.g.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // c.y.a.a.i.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.d.g.r(xmlPullParser, "pathData")) {
                TypedArray s = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3625d);
                f(s, xmlPullParser);
                s.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        int a;

        /* renamed from: b, reason: collision with root package name */
        g f3680b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f3681c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f3682d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3683e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f3684f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f3685g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f3686h;

        /* renamed from: i, reason: collision with root package name */
        int f3687i;

        /* renamed from: j, reason: collision with root package name */
        boolean f3688j;

        /* renamed from: k, reason: collision with root package name */
        boolean f3689k;
        Paint l;

        public h(h hVar) {
            this.f3681c = null;
            this.f3682d = i.f3645g;
            if (hVar != null) {
                this.a = hVar.a;
                g gVar = new g(hVar.f3680b);
                this.f3680b = gVar;
                if (hVar.f3680b.f3674f != null) {
                    gVar.f3674f = new Paint(hVar.f3680b.f3674f);
                }
                if (hVar.f3680b.f3673e != null) {
                    this.f3680b.f3673e = new Paint(hVar.f3680b.f3673e);
                }
                this.f3681c = hVar.f3681c;
                this.f3682d = hVar.f3682d;
                this.f3683e = hVar.f3683e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f3684f.getWidth() && i3 == this.f3684f.getHeight();
        }

        public boolean b() {
            return !this.f3689k && this.f3685g == this.f3681c && this.f3686h == this.f3682d && this.f3688j == this.f3683e && this.f3687i == this.f3680b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f3684f == null || !a(i2, i3)) {
                this.f3684f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f3689k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3684f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f3680b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean f() {
            return this.f3680b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f3680b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f3680b.g(iArr);
            this.f3689k |= g2;
            return g2;
        }

        public void i() {
            this.f3685g = this.f3681c;
            this.f3686h = this.f3682d;
            this.f3687i = this.f3680b.getRootAlpha();
            this.f3688j = this.f3683e;
            this.f3689k = false;
        }

        public void j(int i2, int i3) {
            this.f3684f.eraseColor(0);
            this.f3680b.b(new Canvas(this.f3684f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f3681c = null;
            this.f3682d = i.f3645g;
            this.f3680b = new g();
        }
    }

    i() {
        this.l = true;
        this.n = new float[9];
        this.o = new Matrix();
        this.p = new Rect();
        this.f3646h = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static i b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f3644f = androidx.core.content.d.f.d(resources, i2, theme);
            iVar.m = new C0104i(iVar.f3644f.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f3646h;
        g gVar = hVar.f3680b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f3677i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3657b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.q.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.a = cVar.f3669d | hVar.a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3657b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.q.put(bVar.getPathName(), bVar);
                    }
                    hVar.a = bVar.f3669d | hVar.a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3657b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.q.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.a = dVar2.f3666k | hVar.a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 != 9) {
            switch (i2) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_ATOP;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f3646h;
        g gVar = hVar.f3680b;
        hVar.f3682d = g(androidx.core.content.d.g.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g2 = androidx.core.content.d.g.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g2 != null) {
            hVar.f3681c = g2;
        }
        hVar.f3683e = androidx.core.content.d.g.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f3683e);
        gVar.l = androidx.core.content.d.g.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.l);
        float j2 = androidx.core.content.d.g.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.m);
        gVar.m = j2;
        if (gVar.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (j2 > 0.0f) {
            gVar.f3678j = typedArray.getDimension(3, gVar.f3678j);
            float dimension = typedArray.getDimension(2, gVar.f3679k);
            gVar.f3679k = dimension;
            if (gVar.f3678j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                gVar.setAlpha(androidx.core.content.d.g.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.o = string;
                    gVar.q.put(string, gVar);
                    return;
                }
                return;
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3644f;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f3646h.f3680b.q.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.p);
        if (this.p.width() <= 0 || this.p.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3648j;
        if (colorFilter == null) {
            colorFilter = this.f3647i;
        }
        canvas.getMatrix(this.o);
        this.o.getValues(this.n);
        float abs = Math.abs(this.n[0]);
        float abs2 = Math.abs(this.n[4]);
        float abs3 = Math.abs(this.n[1]);
        float abs4 = Math.abs(this.n[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(RecyclerView.l.FLAG_MOVED, (int) (this.p.width() * abs));
        int min2 = Math.min(RecyclerView.l.FLAG_MOVED, (int) (this.p.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.p;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.p.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.p.offsetTo(0, 0);
        this.f3646h.c(min, min2);
        if (!this.l) {
            this.f3646h.j(min, min2);
        } else if (!this.f3646h.b()) {
            this.f3646h.j(min, min2);
            this.f3646h.i();
        }
        this.f3646h.d(canvas, colorFilter, this.p);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f3646h.f3680b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3646h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f3648j;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3644f != null && Build.VERSION.SDK_INT >= 24) {
            return new C0104i(this.f3644f.getConstantState());
        }
        this.f3646h.a = getChangingConfigurations();
        return this.f3646h;
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f3646h.f3680b.f3679k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f3646h.f3680b.f3678j;
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.l = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f3646h.f3683e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f3646h) != null && (hVar.g() || ((colorStateList = this.f3646h.f3681c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3649k && super.mutate() == this) {
            this.f3646h = new h(this.f3646h);
            this.f3649k = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f3646h;
        ColorStateList colorStateList = hVar.f3681c;
        if (colorStateList != null && (mode = hVar.f3682d) != null) {
            this.f3647i = j(this.f3647i, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f3646h.f3680b.getRootAlpha() != i2) {
            this.f3646h.f3680b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f3646h.f3683e = z;
        }
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f3646h;
        if (hVar.f3681c != colorStateList) {
            hVar.f3681c = colorStateList;
            this.f3647i = j(this.f3647i, colorStateList, hVar.f3682d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f3646h;
        if (hVar.f3682d != mode) {
            hVar.f3682d = mode;
            this.f3647i = j(this.f3647i, hVar.f3681c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: c.y.a.a.i$i, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0104i extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public C0104i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f3644f = (VectorDrawable) this.a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f3644f = (VectorDrawable) this.a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f3644f = (VectorDrawable) this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3648j = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        protected c.b[] a;

        /* renamed from: b, reason: collision with root package name */
        String f3667b;

        /* renamed from: c, reason: collision with root package name */
        int f3668c;

        /* renamed from: d, reason: collision with root package name */
        int f3669d;

        public f() {
            super();
            this.a = null;
            this.f3668c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.f3667b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!c.i.e.c.b(this.a, bVarArr)) {
                this.a = c.i.e.c.f(bVarArr);
            } else {
                c.i.e.c.j(this.a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.a = null;
            this.f3668c = 0;
            this.f3667b = fVar.f3667b;
            this.f3669d = fVar.f3669d;
            this.a = c.i.e.c.f(fVar.a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f3646h;
        hVar.f3680b = new g();
        TypedArray s = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.a);
        i(s, xmlPullParser, theme);
        s.recycle();
        hVar.a = getChangingConfigurations();
        hVar.f3689k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f3647i = j(this.f3647i, hVar.f3681c, hVar.f3682d);
    }

    i(h hVar) {
        this.l = true;
        this.n = new float[9];
        this.o = new Matrix();
        this.p = new Rect();
        this.f3646h = hVar;
        this.f3647i = j(this.f3647i, hVar.f3681c, hVar.f3682d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f3650e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.d.b f3651f;

        /* renamed from: g, reason: collision with root package name */
        float f3652g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.d.b f3653h;

        /* renamed from: i, reason: collision with root package name */
        float f3654i;

        /* renamed from: j, reason: collision with root package name */
        float f3655j;

        /* renamed from: k, reason: collision with root package name */
        float f3656k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        c() {
            this.f3652g = 0.0f;
            this.f3654i = 1.0f;
            this.f3655j = 1.0f;
            this.f3656k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3650e = null;
            if (androidx.core.content.d.g.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3667b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.a = c.i.e.c.d(string2);
                }
                this.f3653h = androidx.core.content.d.g.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f3655j = androidx.core.content.d.g.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f3655j);
                this.n = e(androidx.core.content.d.g.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(androidx.core.content.d.g.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.d.g.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f3651f = androidx.core.content.d.g.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f3654i = androidx.core.content.d.g.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3654i);
                this.f3652g = androidx.core.content.d.g.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f3652g);
                this.l = androidx.core.content.d.g.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.d.g.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.f3656k = androidx.core.content.d.g.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f3656k);
                this.f3668c = androidx.core.content.d.g.k(typedArray, xmlPullParser, "fillType", 13, this.f3668c);
            }
        }

        @Override // c.y.a.a.i.e
        public boolean a() {
            return this.f3653h.i() || this.f3651f.i();
        }

        @Override // c.y.a.a.i.e
        public boolean b(int[] iArr) {
            return this.f3651f.j(iArr) | this.f3653h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3624c);
            h(s, xmlPullParser, theme);
            s.recycle();
        }

        float getFillAlpha() {
            return this.f3655j;
        }

        int getFillColor() {
            return this.f3653h.e();
        }

        float getStrokeAlpha() {
            return this.f3654i;
        }

        int getStrokeColor() {
            return this.f3651f.e();
        }

        float getStrokeWidth() {
            return this.f3652g;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.f3656k;
        }

        void setFillAlpha(float f2) {
            this.f3655j = f2;
        }

        void setFillColor(int i2) {
            this.f3653h.k(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f3654i = f2;
        }

        void setStrokeColor(int i2) {
            this.f3651f.k(i2);
        }

        void setStrokeWidth(float f2) {
            this.f3652g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        void setTrimPathStart(float f2) {
            this.f3656k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f3652g = 0.0f;
            this.f3654i = 1.0f;
            this.f3655j = 1.0f;
            this.f3656k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f3650e = cVar.f3650e;
            this.f3651f = cVar.f3651f;
            this.f3652g = cVar.f3652g;
            this.f3654i = cVar.f3654i;
            this.f3653h = cVar.f3653h;
            this.f3668c = cVar.f3668c;
            this.f3655j = cVar.f3655j;
            this.f3656k = cVar.f3656k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        private final Path f3670b;

        /* renamed from: c, reason: collision with root package name */
        private final Path f3671c;

        /* renamed from: d, reason: collision with root package name */
        private final Matrix f3672d;

        /* renamed from: e, reason: collision with root package name */
        Paint f3673e;

        /* renamed from: f, reason: collision with root package name */
        Paint f3674f;

        /* renamed from: g, reason: collision with root package name */
        private PathMeasure f3675g;

        /* renamed from: h, reason: collision with root package name */
        private int f3676h;

        /* renamed from: i, reason: collision with root package name */
        final d f3677i;

        /* renamed from: j, reason: collision with root package name */
        float f3678j;

        /* renamed from: k, reason: collision with root package name */
        float f3679k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final c.e.a<String, Object> q;

        public g() {
            this.f3672d = new Matrix();
            this.f3678j = 0.0f;
            this.f3679k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new c.e.a<>();
            this.f3677i = new d();
            this.f3670b = new Path();
            this.f3671c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f3665j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f3657b.size(); i4++) {
                e eVar = dVar.f3657b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.l;
            float f3 = i3 / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.a;
            this.f3672d.set(matrix);
            this.f3672d.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 == 0.0f) {
                return;
            }
            fVar.d(this.f3670b);
            Path path = this.f3670b;
            this.f3671c.reset();
            if (fVar.c()) {
                this.f3671c.setFillType(fVar.f3668c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f3671c.addPath(path, this.f3672d);
                canvas.clipPath(this.f3671c);
                return;
            }
            c cVar = (c) fVar;
            float f4 = cVar.f3656k;
            if (f4 != 0.0f || cVar.l != 1.0f) {
                float f5 = cVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.l + f5) % 1.0f;
                if (this.f3675g == null) {
                    this.f3675g = new PathMeasure();
                }
                this.f3675g.setPath(this.f3670b, false);
                float length = this.f3675g.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f3675g.getSegment(f8, length, path, true);
                    this.f3675g.getSegment(0.0f, f9, path, true);
                } else {
                    this.f3675g.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3671c.addPath(path, this.f3672d);
            if (cVar.f3653h.l()) {
                androidx.core.content.d.b bVar = cVar.f3653h;
                if (this.f3674f == null) {
                    Paint paint = new Paint(1);
                    this.f3674f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f3674f;
                if (bVar.h()) {
                    Shader f10 = bVar.f();
                    f10.setLocalMatrix(this.f3672d);
                    paint2.setShader(f10);
                    paint2.setAlpha(Math.round(cVar.f3655j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(i.a(bVar.e(), cVar.f3655j));
                }
                paint2.setColorFilter(colorFilter);
                this.f3671c.setFillType(cVar.f3668c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3671c, paint2);
            }
            if (cVar.f3651f.l()) {
                androidx.core.content.d.b bVar2 = cVar.f3651f;
                if (this.f3673e == null) {
                    Paint paint3 = new Paint(1);
                    this.f3673e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f3673e;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.h()) {
                    Shader f11 = bVar2.f();
                    f11.setLocalMatrix(this.f3672d);
                    paint4.setShader(f11);
                    paint4.setAlpha(Math.round(cVar.f3654i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(i.a(bVar2.e(), cVar.f3654i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f3652g * min * e2);
                canvas.drawPath(this.f3671c, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f3677i, a, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.f3677i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f3677i.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.n = i2;
        }

        public g(g gVar) {
            this.f3672d = new Matrix();
            this.f3678j = 0.0f;
            this.f3679k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            c.e.a<String, Object> aVar = new c.e.a<>();
            this.q = aVar;
            this.f3677i = new d(gVar.f3677i, aVar);
            this.f3670b = new Path(gVar.f3670b);
            this.f3671c = new Path(gVar.f3671c);
            this.f3678j = gVar.f3678j;
            this.f3679k = gVar.f3679k;
            this.l = gVar.l;
            this.m = gVar.m;
            this.f3676h = gVar.f3676h;
            this.n = gVar.n;
            this.o = gVar.o;
            String str = gVar.o;
            if (str != null) {
                aVar.put(str, this);
            }
            this.p = gVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {
        final Matrix a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<e> f3657b;

        /* renamed from: c, reason: collision with root package name */
        float f3658c;

        /* renamed from: d, reason: collision with root package name */
        private float f3659d;

        /* renamed from: e, reason: collision with root package name */
        private float f3660e;

        /* renamed from: f, reason: collision with root package name */
        private float f3661f;

        /* renamed from: g, reason: collision with root package name */
        private float f3662g;

        /* renamed from: h, reason: collision with root package name */
        private float f3663h;

        /* renamed from: i, reason: collision with root package name */
        private float f3664i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f3665j;

        /* renamed from: k, reason: collision with root package name */
        int f3666k;
        private int[] l;
        private String m;

        public d(d dVar, c.e.a<String, Object> aVar) {
            super();
            f bVar;
            this.a = new Matrix();
            this.f3657b = new ArrayList<>();
            this.f3658c = 0.0f;
            this.f3659d = 0.0f;
            this.f3660e = 0.0f;
            this.f3661f = 1.0f;
            this.f3662g = 1.0f;
            this.f3663h = 0.0f;
            this.f3664i = 0.0f;
            Matrix matrix = new Matrix();
            this.f3665j = matrix;
            this.m = null;
            this.f3658c = dVar.f3658c;
            this.f3659d = dVar.f3659d;
            this.f3660e = dVar.f3660e;
            this.f3661f = dVar.f3661f;
            this.f3662g = dVar.f3662g;
            this.f3663h = dVar.f3663h;
            this.f3664i = dVar.f3664i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.f3666k = dVar.f3666k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f3665j);
            ArrayList<e> arrayList = dVar.f3657b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f3657b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3657b.add(bVar);
                    String str2 = bVar.f3667b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f3665j.reset();
            this.f3665j.postTranslate(-this.f3659d, -this.f3660e);
            this.f3665j.postScale(this.f3661f, this.f3662g);
            this.f3665j.postRotate(this.f3658c, 0.0f, 0.0f);
            this.f3665j.postTranslate(this.f3663h + this.f3659d, this.f3664i + this.f3660e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f3658c = androidx.core.content.d.g.j(typedArray, xmlPullParser, "rotation", 5, this.f3658c);
            this.f3659d = typedArray.getFloat(1, this.f3659d);
            this.f3660e = typedArray.getFloat(2, this.f3660e);
            this.f3661f = androidx.core.content.d.g.j(typedArray, xmlPullParser, "scaleX", 3, this.f3661f);
            this.f3662g = androidx.core.content.d.g.j(typedArray, xmlPullParser, "scaleY", 4, this.f3662g);
            this.f3663h = androidx.core.content.d.g.j(typedArray, xmlPullParser, "translateX", 6, this.f3663h);
            this.f3664i = androidx.core.content.d.g.j(typedArray, xmlPullParser, "translateY", 7, this.f3664i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // c.y.a.a.i.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f3657b.size(); i2++) {
                if (this.f3657b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.y.a.a.i.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f3657b.size(); i2++) {
                z |= this.f3657b.get(i2).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3623b);
            e(s, xmlPullParser);
            s.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f3665j;
        }

        public float getPivotX() {
            return this.f3659d;
        }

        public float getPivotY() {
            return this.f3660e;
        }

        public float getRotation() {
            return this.f3658c;
        }

        public float getScaleX() {
            return this.f3661f;
        }

        public float getScaleY() {
            return this.f3662g;
        }

        public float getTranslateX() {
            return this.f3663h;
        }

        public float getTranslateY() {
            return this.f3664i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3659d) {
                this.f3659d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3660e) {
                this.f3660e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3658c) {
                this.f3658c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3661f) {
                this.f3661f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3662g) {
                this.f3662g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3663h) {
                this.f3663h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3664i) {
                this.f3664i = f2;
                d();
            }
        }

        public d() {
            super();
            this.a = new Matrix();
            this.f3657b = new ArrayList<>();
            this.f3658c = 0.0f;
            this.f3659d = 0.0f;
            this.f3660e = 0.0f;
            this.f3661f = 1.0f;
            this.f3662g = 1.0f;
            this.f3663h = 0.0f;
            this.f3664i = 0.0f;
            this.f3665j = new Matrix();
            this.m = null;
        }
    }
}
