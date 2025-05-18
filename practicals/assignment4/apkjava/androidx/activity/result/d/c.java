package androidx.activity.result.d;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

/* compiled from: ActivityResultContracts.java */
/* loaded from: classes.dex */
public final class c extends a<Intent, ActivityResult> {
    @Override // androidx.activity.result.d.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        return intent;
    }

    @Override // androidx.activity.result.d.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i2, Intent intent) {
        return new ActivityResult(i2, intent);
    }
}
