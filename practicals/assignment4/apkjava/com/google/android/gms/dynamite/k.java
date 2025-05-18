package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class k implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int a;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int b2 = iVersions.b(context, str);
        selectionResult.a = b2;
        int i2 = 0;
        if (b2 != 0) {
            a = iVersions.a(context, str, false);
            selectionResult.f12203b = a;
        } else {
            a = iVersions.a(context, str, true);
            selectionResult.f12203b = a;
        }
        int i3 = selectionResult.a;
        if (i3 != 0) {
            i2 = i3;
        } else if (a == 0) {
            selectionResult.f12204c = 0;
            return selectionResult;
        }
        if (a >= i2) {
            selectionResult.f12204c = 1;
        } else {
            selectionResult.f12204c = -1;
        }
        return selectionResult;
    }
}
