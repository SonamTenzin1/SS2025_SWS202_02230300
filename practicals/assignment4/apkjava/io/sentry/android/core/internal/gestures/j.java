package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.b;
import io.sentry.util.q;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ViewUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static io.sentry.internal.gestures.b a(SentryAndroidOptions sentryAndroidOptions, View view, float f2, float f3, b.a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        io.sentry.internal.gestures.b bVar = null;
        while (linkedList.size() > 0) {
            View view2 = (View) q.c((View) linkedList.poll(), "view is required");
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    linkedList.add(viewGroup.getChildAt(i2));
                }
            }
            Iterator<io.sentry.internal.gestures.a> it = sentryAndroidOptions.getGestureTargetLocators().iterator();
            while (it.hasNext()) {
                io.sentry.internal.gestures.b a = it.next().a(view2, f2, f3, aVar);
                if (a != null) {
                    if (aVar != b.a.CLICKABLE) {
                        return a;
                    }
                    bVar = a;
                }
            }
        }
        return bVar;
    }

    public static String b(View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id != -1 && !c(id)) {
            Resources resources = view.getContext().getResources();
            return resources != null ? resources.getResourceEntryName(id) : HttpUrl.FRAGMENT_ENCODE_SET;
        }
        throw new Resources.NotFoundException();
    }

    private static boolean c(int i2) {
        return ((-16777216) & i2) == 0 && (i2 & 16777215) != 0;
    }
}
