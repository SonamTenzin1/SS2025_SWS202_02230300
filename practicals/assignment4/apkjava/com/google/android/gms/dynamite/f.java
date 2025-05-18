package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class f implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int b2 = iVersions.b(context, str);
        selectionResult.a = b2;
        if (b2 != 0) {
            selectionResult.f12204c = -1;
        } else {
            int a = iVersions.a(context, str, true);
            selectionResult.f12203b = a;
            if (a != 0) {
                selectionResult.f12204c = 1;
            }
        }
        return selectionResult;
    }
}
