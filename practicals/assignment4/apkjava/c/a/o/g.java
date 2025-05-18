package c.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.y;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {
    static final Class<?>[] a;

    /* renamed from: b, reason: collision with root package name */
    static final Class<?>[] f2816b;

    /* renamed from: c, reason: collision with root package name */
    final Object[] f2817c;

    /* renamed from: d, reason: collision with root package name */
    final Object[] f2818d;

    /* renamed from: e, reason: collision with root package name */
    Context f2819e;

    /* renamed from: f, reason: collision with root package name */
    private Object f2820f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: f, reason: collision with root package name */
        private static final Class<?>[] f2821f = {MenuItem.class};

        /* renamed from: g, reason: collision with root package name */
        private Object f2822g;

        /* renamed from: h, reason: collision with root package name */
        private Method f2823h;

        public a(Object obj, String str) {
            this.f2822g = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2823h = cls.getMethod(str, f2821f);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2823h.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2823h.invoke(this.f2822g, menuItem)).booleanValue();
                }
                this.f2823h.invoke(this.f2822g, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;

        /* renamed from: b, reason: collision with root package name */
        private int f2824b;

        /* renamed from: c, reason: collision with root package name */
        private int f2825c;

        /* renamed from: d, reason: collision with root package name */
        private int f2826d;

        /* renamed from: e, reason: collision with root package name */
        private int f2827e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2828f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2829g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2830h;

        /* renamed from: i, reason: collision with root package name */
        private int f2831i;

        /* renamed from: j, reason: collision with root package name */
        private int f2832j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f2833k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f2819e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f2819e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.a, g.this.f2817c));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                androidx.core.view.h.a(menuItem, bVar);
            }
            androidx.core.view.h.c(menuItem, this.B);
            androidx.core.view.h.h(menuItem, this.C);
            androidx.core.view.h.b(menuItem, this.n, this.o);
            androidx.core.view.h.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                androidx.core.view.h.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                androidx.core.view.h.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2830h = true;
            i(this.a.add(this.f2824b, this.f2831i, this.f2832j, this.f2833k));
        }

        public SubMenu b() {
            this.f2830h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.f2824b, this.f2831i, this.f2832j, this.f2833k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f2830h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f2819e.obtainStyledAttributes(attributeSet, c.a.j.r1);
            this.f2824b = obtainStyledAttributes.getResourceId(c.a.j.t1, 0);
            this.f2825c = obtainStyledAttributes.getInt(c.a.j.v1, 0);
            this.f2826d = obtainStyledAttributes.getInt(c.a.j.w1, 0);
            this.f2827e = obtainStyledAttributes.getInt(c.a.j.x1, 0);
            this.f2828f = obtainStyledAttributes.getBoolean(c.a.j.u1, true);
            this.f2829g = obtainStyledAttributes.getBoolean(c.a.j.s1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            q0 u = q0.u(g.this.f2819e, attributeSet, c.a.j.y1);
            this.f2831i = u.n(c.a.j.B1, 0);
            this.f2832j = (u.k(c.a.j.E1, this.f2825c) & (-65536)) | (u.k(c.a.j.F1, this.f2826d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f2833k = u.p(c.a.j.G1);
            this.l = u.p(c.a.j.H1);
            this.m = u.n(c.a.j.z1, 0);
            this.n = c(u.o(c.a.j.I1));
            this.o = u.k(c.a.j.P1, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            this.p = c(u.o(c.a.j.J1));
            this.q = u.k(c.a.j.T1, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            int i2 = c.a.j.K1;
            if (u.s(i2)) {
                this.r = u.a(i2, false) ? 1 : 0;
            } else {
                this.r = this.f2827e;
            }
            this.s = u.a(c.a.j.C1, false);
            this.t = u.a(c.a.j.D1, this.f2828f);
            this.u = u.a(c.a.j.A1, this.f2829g);
            this.v = u.k(c.a.j.U1, -1);
            this.z = u.o(c.a.j.L1);
            this.w = u.n(c.a.j.M1, 0);
            this.x = u.o(c.a.j.O1);
            String o = u.o(c.a.j.N1);
            this.y = o;
            boolean z = o != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (androidx.core.view.b) e(o, g.f2816b, g.this.f2818d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u.p(c.a.j.Q1);
            this.C = u.p(c.a.j.V1);
            int i3 = c.a.j.S1;
            if (u.s(i3)) {
                this.E = y.e(u.k(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = c.a.j.R1;
            if (u.s(i4)) {
                this.D = u.c(i4);
            } else {
                this.D = null;
            }
            u.w();
            this.f2830h = false;
        }

        public void h() {
            this.f2824b = 0;
            this.f2825c = 0;
            this.f2826d = 0;
            this.f2827e = 0;
            this.f2828f = true;
            this.f2829g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        a = clsArr;
        f2816b = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f2819e = context;
        Object[] objArr = {context};
        this.f2817c = objArr;
        this.f2818d = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.a() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
    }

    Object b() {
        if (this.f2820f == null) {
            this.f2820f = a(this.f2819e);
        }
        return this.f2820f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof c.i.f.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2819e.getResources().getLayout(i2);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
