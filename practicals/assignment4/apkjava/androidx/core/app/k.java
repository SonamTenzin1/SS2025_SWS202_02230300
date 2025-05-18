package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.i;
import androidx.core.graphics.drawable.IconCompat;
import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    private static Field f907b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f908c;
    private static final Object a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f909d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle b(i.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat e2 = aVar.e();
        bundle2.putInt(RoomInstalled.ICON, e2 != null ? e2.e() : 0);
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle c(Notification notification) {
        synchronized (a) {
            if (f908c) {
                return null;
            }
            try {
                if (f907b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f908c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f907b = declaredField;
                }
                Bundle bundle = (Bundle) f907b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f907b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f908c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f908c = true;
                return null;
            }
        }
    }

    private static Bundle d(n nVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] e(n[] nVarArr) {
        if (nVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            bundleArr[i2] = d(nVarArr[i2]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, i.a aVar) {
        IconCompat e2 = aVar.e();
        builder.addAction(e2 != null ? e2.e() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
