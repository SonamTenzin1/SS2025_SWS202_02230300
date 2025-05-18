package androidx.core.content.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.d.c;
import c.i.j.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class f {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<b, SparseArray<a>> f954b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f955c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        final ColorStateList a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f956b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f956b = configuration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static final class b {
        final Resources a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f957b;

        b(Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.f957b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && c.i.j.d.a(this.f957b, bVar.f957b);
        }

        public int hashCode() {
            return c.i.j.d.b(this.a, this.f957b);
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Typeface f958f;

            a(Typeface typeface) {
                this.f958f = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e(this.f958f);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f960f;

            b(int i2) {
                this.f960f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d(this.f960f);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i2, Handler handler) {
            c(handler).post(new b(i2));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new a(typeface));
        }

        public abstract void d(int i2);

        public abstract void e(Typeface typeface);
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        static class a {
            private static final Object a = new Object();

            /* renamed from: b, reason: collision with root package name */
            private static Method f962b;

            /* renamed from: c, reason: collision with root package name */
            private static boolean f963c;

            static void a(Resources.Theme theme) {
                synchronized (a) {
                    if (!f963c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f962b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f963c = true;
                    }
                    Method method = f962b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f962b = null;
                        }
                    }
                }
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(b bVar, int i2, ColorStateList colorStateList) {
        synchronized (f955c) {
            WeakHashMap<b, SparseArray<a>> weakHashMap = f954b;
            SparseArray<a> sparseArray = weakHashMap.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(bVar, sparseArray);
            }
            sparseArray.append(i2, new a(colorStateList, bVar.a.getConfiguration()));
        }
    }

    private static ColorStateList b(b bVar, int i2) {
        a aVar;
        synchronized (f955c) {
            SparseArray<a> sparseArray = f954b.get(bVar);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i2)) != null) {
                if (aVar.f956b.equals(bVar.a.getConfiguration())) {
                    return aVar.a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i2, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList b2 = b(bVar, i2);
        if (b2 != null) {
            return b2;
        }
        ColorStateList i3 = i(resources, i2, theme);
        if (i3 != null) {
            a(bVar, i2, i3);
            return i3;
        }
        return resources.getColorStateList(i2);
    }

    public static Drawable d(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme);
        }
        return resources.getDrawable(i2);
    }

    public static Typeface e(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i2, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface f(Context context, int i2, TypedValue typedValue, int i3, c cVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i2, typedValue, i3, cVar, null, true, false);
    }

    public static void g(Context context, int i2, c cVar, Handler handler) throws Resources.NotFoundException {
        i.c(cVar);
        if (context.isRestricted()) {
            cVar.a(-4, handler);
        } else {
            k(context, i2, new TypedValue(), 0, cVar, handler, false, false);
        }
    }

    private static TypedValue h() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList i(Resources resources, int i2, Resources.Theme theme) {
        if (j(resources, i2)) {
            return null;
        }
        try {
            return androidx.core.content.d.a.a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean j(Resources resources, int i2) {
        TypedValue h2 = h();
        resources.getValue(i2, h2, true);
        int i3 = h2.type;
        return i3 >= 28 && i3 <= 31;
    }

    private static Typeface k(Context context, int i2, TypedValue typedValue, int i3, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface l = l(context, resources, typedValue, i2, i3, cVar, handler, z, z2);
        if (l != null || cVar != null || z2) {
            return l;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface l(Context context, Resources resources, TypedValue typedValue, int i2, int i3, c cVar, Handler handler, boolean z, boolean z2) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (!charSequence2.startsWith("res/")) {
                if (cVar != null) {
                    cVar.a(-3, handler);
                }
                return null;
            }
            Typeface f2 = c.i.e.d.f(resources, i2, i3);
            if (f2 != null) {
                if (cVar != null) {
                    cVar.b(f2, handler);
                }
                return f2;
            }
            if (z2) {
                return null;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    c.a b2 = androidx.core.content.d.c.b(resources.getXml(i2), resources);
                    if (b2 == null) {
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        if (cVar != null) {
                            cVar.a(-3, handler);
                        }
                        return null;
                    }
                    return c.i.e.d.c(context, b2, resources, i2, i3, cVar, handler, z);
                }
                Typeface d2 = c.i.e.d.d(context, resources, i2, charSequence2, i3);
                if (cVar != null) {
                    if (d2 != null) {
                        cVar.b(d2, handler);
                    } else {
                        cVar.a(-3, handler);
                    }
                }
                return d2;
            } catch (IOException e2) {
                Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence2, e2);
                if (cVar != null) {
                    cVar.a(-3, handler);
                }
                return null;
            } catch (XmlPullParserException e3) {
                Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence2, e3);
                if (cVar != null) {
                }
                return null;
            }
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
    }
}
