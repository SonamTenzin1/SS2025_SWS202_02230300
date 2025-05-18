package androidx.activity.result.d;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.d.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ActivityResultContracts.java */
/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    static Intent e(String[] strArr) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
    }

    @Override // androidx.activity.result.d.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        return e(strArr);
    }

    @Override // androidx.activity.result.d.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a.C0008a<Map<String, Boolean>> b(Context context, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            c.e.a aVar = new c.e.a();
            boolean z = true;
            for (String str : strArr) {
                boolean z2 = androidx.core.content.a.a(context, str) == 0;
                aVar.put(str, Boolean.valueOf(z2));
                if (!z2) {
                    z = false;
                }
            }
            if (z) {
                return new a.C0008a<>(aVar);
            }
            return null;
        }
        return new a.C0008a<>(Collections.emptyMap());
    }

    @Override // androidx.activity.result.d.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i2, Intent intent) {
        if (i2 != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra != null && stringArrayExtra != null) {
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(stringArrayExtra[i3], Boolean.valueOf(intArrayExtra[i3] == 0));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
