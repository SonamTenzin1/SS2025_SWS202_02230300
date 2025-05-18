package com.facebook.o0.k0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.o0.g0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* compiled from: MetadataViewObserver.kt */
/* loaded from: classes.dex */
public final class f implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10157f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Map<Integer, f> f10158g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final Set<String> f10159h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f10160i;

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<Activity> f10161j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f10162k;

    /* compiled from: MetadataViewObserver.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String str, String str2) {
            return m.a("r2", str) ? new Regex("[^\\d.]").c(str2, HttpUrl.FRAGMENT_ENCODE_SET) : str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r7.equals("r5") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            r8 = new kotlin.text.Regex("[^a-z]+").c(r8, okhttp3.HttpUrl.FRAGMENT_ENCODE_SET);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        
            if (r7.equals("r4") == false) goto L34;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void d(Map<String, String> map, String str, String str2) {
            boolean E;
            boolean E2;
            boolean E3;
            boolean J;
            switch (str.hashCode()) {
                case 3585:
                    if (str.equals("r3")) {
                        E = u.E(str2, "m", false, 2, null);
                        if (!E) {
                            E2 = u.E(str2, "b", false, 2, null);
                            if (!E2) {
                                E3 = u.E(str2, "ge", false, 2, null);
                                if (!E3) {
                                    str2 = "f";
                                }
                            }
                        }
                        str2 = "m";
                    }
                    map.put(str, str2);
                    return;
                case 3586:
                    break;
                case 3587:
                    break;
                case 3588:
                    if (str.equals("r6")) {
                        J = v.J(str2, "-", false, 2, null);
                        if (J) {
                            Object[] array = new Regex("-").d(str2, 0).toArray(new String[0]);
                            if (array != null) {
                                str2 = ((String[]) array)[0];
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                    }
                    map.put(str, str2);
                    return;
                default:
                    map.put(str, str2);
                    return;
            }
        }

        public final void e(Activity activity) {
            m.f(activity, "activity");
            int hashCode = activity.hashCode();
            Map map = f.f10158g;
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = map.get(valueOf);
            if (obj == null) {
                obj = new f(activity, null);
                map.put(valueOf, obj);
            }
            ((f) obj).h();
        }
    }

    private f(Activity activity) {
        this.f10159h = new LinkedHashSet();
        this.f10160i = new Handler(Looper.getMainLooper());
        this.f10161j = new WeakReference<>(activity);
        this.f10162k = new AtomicBoolean(false);
    }

    public /* synthetic */ f(Activity activity, g gVar) {
        this(activity);
    }

    private final void d(final View view) {
        g(new Runnable() { // from class: com.facebook.o0.k0.b
            @Override // java.lang.Runnable
            public final void run() {
                f.e(view, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, f fVar) {
        m.f(view, "$view");
        m.f(fVar, "this$0");
        if (view instanceof EditText) {
            fVar.f(view);
        }
    }

    private final void f(View view) {
        CharSequence O0;
        String obj = ((EditText) view).getText().toString();
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        O0 = v.O0(obj);
        String obj2 = O0.toString();
        if (obj2 != null) {
            String lowerCase = obj2.toLowerCase();
            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            if ((lowerCase.length() == 0) || this.f10159h.contains(lowerCase) || lowerCase.length() > 100) {
                return;
            }
            this.f10159h.add(lowerCase);
            HashMap hashMap = new HashMap();
            d dVar = d.a;
            List<String> b2 = d.b(view);
            List<String> list = null;
            for (e eVar : e.a.c()) {
                a aVar = f10157f;
                String c2 = aVar.c(eVar.c(), lowerCase);
                if (eVar.d().length() > 0) {
                    d dVar2 = d.a;
                    if (!d.f(c2, eVar.d())) {
                    }
                }
                d dVar3 = d.a;
                if (d.e(b2, eVar.b())) {
                    aVar.d(hashMap, eVar.c(), c2);
                } else {
                    if (list == null) {
                        list = d.a(view);
                    }
                    if (d.e(list, eVar.b())) {
                        aVar.d(hashMap, eVar.c(), c2);
                    }
                }
            }
            g0.a.e(hashMap);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void g(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f10160i.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.f10162k.getAndSet(true)) {
            return;
        }
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        View e2 = com.facebook.o0.q0.g.e(this.f10161j.get());
        if (e2 == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = e2.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalFocusChangeListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (view != null) {
            d(view);
        }
        if (view2 != null) {
            d(view2);
        }
    }
}
