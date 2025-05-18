package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* compiled from: SavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public final class v extends y.c {
    private static final Class<?>[] a = {Application.class, u.class};

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f1772b = {u.class};

    /* renamed from: c, reason: collision with root package name */
    private final Application f1773c;

    /* renamed from: d, reason: collision with root package name */
    private final y.b f1774d;

    /* renamed from: e, reason: collision with root package name */
    private final Bundle f1775e;

    /* renamed from: f, reason: collision with root package name */
    private final g f1776f;

    /* renamed from: g, reason: collision with root package name */
    private final SavedStateRegistry f1777g;

    @SuppressLint({"LambdaLast"})
    public v(Application application, androidx.savedstate.c cVar, Bundle bundle) {
        y.b b2;
        this.f1777g = cVar.getSavedStateRegistry();
        this.f1776f = cVar.getLifecycle();
        this.f1775e = bundle;
        this.f1773c = application;
        if (application != null) {
            b2 = y.a.c(application);
        } else {
            b2 = y.d.b();
        }
        this.f1774d = b2;
    }

    private static <T> Constructor<T> d(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.y.c, androidx.lifecycle.y.b
    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.y.e
    void b(x xVar) {
        SavedStateHandleController.b(xVar, this.f1777g, this.f1776f);
    }

    @Override // androidx.lifecycle.y.c
    public <T extends x> T c(String str, Class<T> cls) {
        Constructor d2;
        T t;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        if (isAssignableFrom && this.f1773c != null) {
            d2 = d(cls, a);
        } else {
            d2 = d(cls, f1772b);
        }
        if (d2 == null) {
            return (T) this.f1774d.a(cls);
        }
        SavedStateHandleController d3 = SavedStateHandleController.d(this.f1777g, this.f1776f, str, this.f1775e);
        if (isAssignableFrom) {
            try {
                Application application = this.f1773c;
                if (application != null) {
                    t = (T) d2.newInstance(application, d3.e());
                    t.e("androidx.lifecycle.savedstate.vm.tag", d3);
                    return t;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        t = (T) d2.newInstance(d3.e());
        t.e("androidx.lifecycle.savedstate.vm.tag", d3);
        return t;
    }
}
