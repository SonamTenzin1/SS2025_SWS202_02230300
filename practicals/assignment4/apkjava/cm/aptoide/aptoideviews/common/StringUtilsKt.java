package cm.aptoide.aptoideviews.common;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* compiled from: StringUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"getImageGetter", "Landroid/text/Html$ImageGetter;", "resources", "Landroid/content/res/Resources;", "formatWithHtmlImage", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "drawableId", HttpUrl.FRAGMENT_ENCODE_SET, "width", "height", "aptoide-views_prodRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StringUtilsKt {
    public static final CharSequence formatWithHtmlImage(String str, int i2, int i3, int i4, Resources resources) {
        m.f(str, "<this>");
        m.f(resources, "resources");
        String format = String.format(str, Arrays.copyOf(new Object[]{"<img width='" + i3 + "px' height='" + i4 + "px' src='" + i2 + "'/>"}, 1));
        m.e(format, "format(this, *args)");
        Spanned fromHtml = Html.fromHtml(format, getImageGetter(resources), null);
        m.e(fromHtml, "fromHtml(this.format(ima…eGetter(resources), null)");
        return fromHtml;
    }

    private static final Html.ImageGetter getImageGetter(final Resources resources) {
        return new Html.ImageGetter() { // from class: cm.aptoide.aptoideviews.common.a
            @Override // android.text.Html.ImageGetter
            public final Drawable getDrawable(String str) {
                Drawable m0getImageGetter$lambda0;
                m0getImageGetter$lambda0 = StringUtilsKt.m0getImageGetter$lambda0(resources, str);
                return m0getImageGetter$lambda0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getImageGetter$lambda-0, reason: not valid java name */
    public static final Drawable m0getImageGetter$lambda0(Resources resources, String str) {
        m.f(resources, "$resources");
        m.f(str, "source");
        Drawable drawable = null;
        try {
            drawable = resources.getDrawable(Integer.parseInt(str));
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        } catch (Resources.NotFoundException e2) {
            Log.e("FormatWithHtmlImage", "Image not found. Check the ID.", e2);
            return drawable;
        } catch (NumberFormatException e3) {
            Log.e("FormatWithHtmlImage", "Source string not a valid resource ID.", e3);
            return drawable;
        }
    }
}
