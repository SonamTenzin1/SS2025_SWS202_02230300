package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Locale;
import okhttp3.HttpUrl;

@TargetApi(28)
/* loaded from: classes2.dex */
public final class zzaxy extends zzaxx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets x(Activity activity, View view, WindowInsets windowInsets) {
        if (zzk.zzlk().r().t() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (displayCutout != null) {
                zzaxb r = zzk.zzlk().r();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                r.f(str);
            } else {
                zzk.zzlk().r().f(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }
        y(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static void y(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = attributes.layoutInDisplayCutoutMode;
        int i3 = z ? 1 : 2;
        if (i3 != i2) {
            attributes.layoutInDisplayCutoutMode = i3;
            window.setAttributes(attributes);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void r(final Activity activity) {
        if (((Boolean) zzyt.e().c(zzacu.o1)).booleanValue() && zzk.zzlk().r().t() == null && !activity.isInMultiWindowMode()) {
            y(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.internal.ads.l5
                private final zzaxy a;

                /* renamed from: b, reason: collision with root package name */
                private final Activity f12913b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f12913b = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzaxy.x(this.f12913b, view, windowInsets);
                }
            });
        }
    }
}
