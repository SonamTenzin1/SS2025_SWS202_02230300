package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzag {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12052b;

    /* renamed from: c, reason: collision with root package name */
    private static String f12053c;

    /* renamed from: d, reason: collision with root package name */
    private static int f12054d;

    public static int a(Context context) {
        c(context);
        return f12054d;
    }

    public static String b(Context context) {
        c(context);
        return f12053c;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (a) {
            if (f12052b) {
                return;
            }
            f12052b = true;
            try {
                bundle = Wrappers.a(context).c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f12053c = bundle.getString("com.google.app.id");
            f12054d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
