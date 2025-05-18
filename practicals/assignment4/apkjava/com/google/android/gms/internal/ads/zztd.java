package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
/* loaded from: classes2.dex */
public final class zztd extends Surface {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f16757f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f16758g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f16759h;

    /* renamed from: i, reason: collision with root package name */
    private final r30 f16760i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16761j;

    private zztd(r30 r30Var, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f16760i = r30Var;
        this.f16759h = z;
    }

    public static zztd a(Context context, boolean z) {
        if (zzsy.a >= 17) {
            zzsk.e(!z || b(context));
            return new r30().b(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(Context context) {
        boolean z;
        boolean z2;
        synchronized (zztd.class) {
            if (!f16758g) {
                int i2 = zzsy.a;
                if (i2 >= 17) {
                    boolean z3 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (i2 == 24) {
                            String str = zzsy.f16742d;
                            if ((str.startsWith("SM-G950") || str.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                                z2 = true;
                                if (!z2) {
                                    z3 = true;
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                        }
                    }
                    f16757f = z3;
                }
                f16758g = true;
            }
            z = f16757f;
        }
        return z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f16760i) {
            if (!this.f16761j) {
                this.f16760i.a();
                this.f16761j = true;
            }
        }
    }
}
