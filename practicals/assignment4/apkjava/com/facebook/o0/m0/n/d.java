package com.facebook.o0.m0.n;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

/* compiled from: SensitiveUserDataUtils.kt */
/* loaded from: classes.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    private final boolean a(TextView textView) {
        int i2;
        int d2;
        f fVar = f.a;
        String c2 = new Regex("\\s").c(f.k(textView), HttpUrl.FRAGMENT_ENCODE_SET);
        int length = c2.length();
        if (length < 12 || length > 19) {
            return false;
        }
        int i3 = length - 1;
        if (i3 >= 0) {
            boolean z = false;
            i2 = 0;
            while (true) {
                int i4 = i3 - 1;
                char charAt = c2.charAt(i3);
                if (!Character.isDigit(charAt)) {
                    return false;
                }
                d2 = kotlin.text.c.d(charAt);
                if (z && (d2 = d2 * 2) > 9) {
                    d2 = (d2 % 10) + 1;
                }
                i2 += d2;
                z = !z;
                if (i4 < 0) {
                    break;
                }
                i3 = i4;
            }
        } else {
            i2 = 0;
        }
        return i2 % 10 == 0;
    }

    private final boolean b(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        f fVar = f.a;
        String k2 = f.k(textView);
        if (k2 == null) {
            return false;
        }
        if (k2.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(k2).matches();
    }

    private final boolean c(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private final boolean d(TextView textView) {
        return textView.getInputType() == 96;
    }

    private final boolean e(TextView textView) {
        return textView.getInputType() == 3;
    }

    private final boolean f(TextView textView) {
        return textView.getInputType() == 112;
    }

    public static final boolean g(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        d dVar = a;
        TextView textView = (TextView) view;
        return dVar.c(textView) || dVar.a(textView) || dVar.d(textView) || dVar.f(textView) || dVar.e(textView) || dVar.b(textView);
    }
}
