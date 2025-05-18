package com.facebook.o0.m0.n;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import cm.aptoide.pt.root.execution.Command;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import com.facebook.internal.p0;
import com.google.android.gms.ads.AdRequest;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewHierarchy.kt */
/* loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10338b = f.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<View> f10339c = new WeakReference<>(null);

    /* renamed from: d, reason: collision with root package name */
    private static Method f10340d;

    private f() {
    }

    public static final View a(View view) {
        while (view != null) {
            if (a.q(view)) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public static final List<View> b(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            if (childCount > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    arrayList.add(viewGroup.getChildAt(i2));
                    if (i3 >= childCount) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return arrayList;
    }

    public static final int c(View view) {
        m.f(view, "view");
        int i2 = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i2 |= 32;
        }
        f fVar = a;
        if (o(view)) {
            i2 |= AdRequest.MAX_CONTENT_URL_LENGTH;
        }
        if (!(view instanceof TextView)) {
            return ((view instanceof Spinner) || (view instanceof DatePicker)) ? i2 | RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT : view instanceof RatingBar ? i2 | 65536 : view instanceof RadioGroup ? i2 | Http2.INITIAL_MAX_FRAME_SIZE : ((view instanceof ViewGroup) && fVar.p(view, f10339c.get())) ? i2 | 64 : i2;
        }
        int i3 = i2 | 1024 | 1;
        if (view instanceof Button) {
            i3 |= 4;
            if (view instanceof Switch) {
                i3 |= 8192;
            } else if (view instanceof CheckBox) {
                i3 |= 32768;
            }
        }
        return view instanceof EditText ? i3 | RecyclerView.l.FLAG_MOVED : i3;
    }

    public static final JSONObject d(View view) {
        m.f(view, "view");
        if (m.a(view.getClass().getName(), "com.facebook.react.ReactRootView")) {
            f10339c = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            s(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> b2 = b(view);
            int i2 = 0;
            int size = b2.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    jSONArray.put(d(b2.get(i2)));
                    if (i3 > size) {
                        break;
                    }
                    i2 = i3;
                }
            }
            jSONObject.put("childviews", jSONArray);
        } catch (JSONException e2) {
            Log.e(f10338b, "Failed to create JSONObject for view.", e2);
        }
        return jSONObject;
    }

    private final JSONObject e(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e2) {
            Log.e(f10338b, "Failed to create JSONObject for dimension.", e2);
        }
        return jSONObject;
    }

    private final Class<?> f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final View.OnClickListener g(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static final View.OnTouchListener h(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (ClassNotFoundException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10338b, e2);
            return null;
        } catch (IllegalAccessException e3) {
            p0 p0Var2 = p0.a;
            p0.i0(f10338b, e3);
            return null;
        } catch (NoSuchFieldException e4) {
            p0 p0Var3 = p0.a;
            p0.i0(f10338b, e4);
            return null;
        }
    }

    public static final String i(View view) {
        CharSequence hint;
        String obj;
        if (view instanceof EditText) {
            hint = ((EditText) view).getHint();
        } else {
            hint = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        return (hint == null || (obj = hint.toString()) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : obj;
    }

    public static final ViewGroup j(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static final String k(View view) {
        CharSequence valueOf;
        Object selectedItem;
        String obj;
        if (view instanceof TextView) {
            valueOf = ((TextView) view).getText();
            if (view instanceof Switch) {
                valueOf = ((Switch) view).isChecked() ? "1" : "0";
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            if (spinner.getCount() > 0 && (selectedItem = spinner.getSelectedItem()) != null) {
                valueOf = selectedItem.toString();
            }
            valueOf = null;
        } else {
            int i2 = 0;
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int dayOfMonth = datePicker.getDayOfMonth();
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                valueOf = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                m.e(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                Integer currentHour = timePicker.getCurrentHour();
                m.e(currentHour, "view.currentHour");
                int intValue = currentHour.intValue();
                Integer currentMinute = timePicker.getCurrentMinute();
                m.e(currentMinute, "view.currentMinute");
                int intValue2 = currentMinute.intValue();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
                valueOf = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                m.e(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int childCount = radioGroup.getChildCount();
                if (childCount > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        View childAt = radioGroup.getChildAt(i2);
                        if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                            valueOf = ((RadioButton) childAt).getText();
                            break;
                        }
                        if (i3 >= childCount) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                valueOf = null;
            } else {
                if (view instanceof RatingBar) {
                    valueOf = String.valueOf(((RatingBar) view).getRating());
                }
                valueOf = null;
            }
        }
        return (valueOf == null || (obj = valueOf.toString()) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : obj;
    }

    private final View l(float[] fArr, View view) {
        n();
        Method method = f10340d;
        if (method != null && view != null) {
            try {
                if (method == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Object invoke = method.invoke(null, fArr, view);
                if (invoke != null) {
                    View view2 = (View) invoke;
                    if (view2.getId() > 0) {
                        Object parent = view2.getParent();
                        if (parent != null) {
                            return (View) parent;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
            } catch (IllegalAccessException e2) {
                p0 p0Var = p0.a;
                p0.i0(f10338b, e2);
            } catch (InvocationTargetException e3) {
                p0 p0Var2 = p0.a;
                p0.i0(f10338b, e3);
            }
        }
        return null;
    }

    private final float[] m(View view) {
        view.getLocationOnScreen(new int[2]);
        return new float[]{r1[0], r1[1]};
    }

    private final void n() {
        if (f10340d != null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
            f10340d = declaredMethod;
            if (declaredMethod == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            declaredMethod.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10338b, e2);
        } catch (NoSuchMethodException e3) {
            p0 p0Var2 = p0.a;
            p0.i0(f10338b, e3);
        }
    }

    private static final boolean o(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof AdapterView) {
            return true;
        }
        f fVar = a;
        Class<?> f2 = fVar.f("android.support.v4.view.NestedScrollingChild");
        if (f2 != null && f2.isInstance(parent)) {
            return true;
        }
        Class<?> f3 = fVar.f("androidx.core.view.NestedScrollingChild");
        return f3 != null && f3.isInstance(parent);
    }

    private final boolean q(View view) {
        return m.a(view.getClass().getName(), "com.facebook.react.ReactRootView");
    }

    public static final void r(View view, View.OnClickListener onClickListener) {
        Field field;
        Field field2;
        m.f(view, "view");
        Object obj = null;
        try {
            try {
                field = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            } catch (ClassNotFoundException | NoSuchFieldException unused) {
                field = null;
            }
            try {
                field2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            } catch (ClassNotFoundException | NoSuchFieldException unused2) {
                field2 = null;
                if (field == null) {
                }
                view.setOnClickListener(onClickListener);
            }
            if (field == null && field2 != null) {
                field.setAccessible(true);
                field2.setAccessible(true);
                try {
                    field.setAccessible(true);
                    obj = field.get(view);
                } catch (IllegalAccessException unused3) {
                }
                if (obj == null) {
                    view.setOnClickListener(onClickListener);
                    return;
                } else {
                    field2.set(obj, onClickListener);
                    return;
                }
            }
            view.setOnClickListener(onClickListener);
        } catch (Exception unused4) {
        }
    }

    public static final void s(View view, JSONObject jSONObject) {
        m.f(view, "view");
        m.f(jSONObject, BodyInterceptorV3.RESPONSE_MODE_JSON);
        try {
            f fVar = a;
            String k2 = k(view);
            String i2 = i(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", c(view));
            jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, view.getId());
            d dVar = d.a;
            if (!d.g(view)) {
                p0 p0Var = p0.a;
                jSONObject.put(Command.CommandHandler.TEXT, p0.i(p0.F0(k2), HttpUrl.FRAGMENT_ENCODE_SET));
            } else {
                jSONObject.put(Command.CommandHandler.TEXT, HttpUrl.FRAGMENT_ENCODE_SET);
                jSONObject.put("is_user_input", true);
            }
            p0 p0Var2 = p0.a;
            jSONObject.put("hint", p0.i(p0.F0(i2), HttpUrl.FRAGMENT_ENCODE_SET));
            if (tag != null) {
                jSONObject.put(StoreTabGridRecyclerFragment.BundleCons.TAG, p0.i(p0.F0(tag.toString()), HttpUrl.FRAGMENT_ENCODE_SET));
            }
            if (contentDescription != null) {
                jSONObject.put("description", p0.i(p0.F0(contentDescription.toString()), HttpUrl.FRAGMENT_ENCODE_SET));
            }
            jSONObject.put("dimension", fVar.e(view));
        } catch (JSONException e2) {
            p0 p0Var3 = p0.a;
            p0.i0(f10338b, e2);
        }
    }

    public final boolean p(View view, View view2) {
        View l;
        m.f(view, "view");
        return m.a(view.getClass().getName(), "com.facebook.react.views.view.ReactViewGroup") && (l = l(m(view), view2)) != null && l.getId() == view.getId();
    }
}
