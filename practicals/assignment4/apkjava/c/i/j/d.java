package c.i.j;

import android.os.Build;
import java.util.Arrays;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static String c(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
