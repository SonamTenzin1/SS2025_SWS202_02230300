package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class h implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.a = iVersions.b(context, str);
        int a = iVersions.a(context, str, true);
        selectionResult.f12203b = a;
        int i2 = selectionResult.a;
        if (i2 == 0) {
            if (a == 0) {
                selectionResult.f12204c = 0;
                return selectionResult;
            }
            i2 = 0;
        }
        if (i2 >= a) {
            selectionResult.f12204c = -1;
        } else {
            selectionResult.f12204c = 1;
        }
        return selectionResult;
    }
}
