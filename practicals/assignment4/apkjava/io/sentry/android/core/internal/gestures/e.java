package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import io.sentry.internal.gestures.b;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AndroidViewGestureTargetLocator.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class e implements io.sentry.internal.gestures.a {
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f22146b = new int[2];

    public e(boolean z) {
        this.a = z;
    }

    private io.sentry.internal.gestures.b b(View view) {
        try {
            return new io.sentry.internal.gestures.b(view, io.sentry.android.core.internal.util.j.a(view), j.b(view), null, "old_view_system");
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private static boolean c(View view, boolean z) {
        if (z) {
            return ScrollingView.class.isAssignableFrom(view.getClass());
        }
        return false;
    }

    private static boolean d(View view, boolean z) {
        return (c(view, z) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass())) && view.getVisibility() == 0;
    }

    private static boolean e(View view) {
        return view.isClickable() && view.getVisibility() == 0;
    }

    private boolean f(View view, float f2, float f3) {
        view.getLocationOnScreen(this.f22146b);
        int[] iArr = this.f22146b;
        int i2 = iArr[0];
        int i3 = iArr[1];
        return f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getWidth())) && f3 >= ((float) i3) && f3 <= ((float) (i3 + view.getHeight()));
    }

    @Override // io.sentry.internal.gestures.a
    public io.sentry.internal.gestures.b a(Object obj, float f2, float f3, b.a aVar) {
        if (!(obj instanceof View)) {
            return null;
        }
        View view = (View) obj;
        if (f(view, f2, f3)) {
            if (aVar == b.a.CLICKABLE && e(view)) {
                return b(view);
            }
            if (aVar == b.a.SCROLLABLE && d(view, this.a)) {
                return b(view);
            }
        }
        return null;
    }
}
