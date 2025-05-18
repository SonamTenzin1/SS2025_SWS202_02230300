package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzael extends NativeAd.Image {
    private final zzaei a;

    /* renamed from: b, reason: collision with root package name */
    private final Drawable f13853b;

    /* renamed from: c, reason: collision with root package name */
    private final Uri f13854c;

    /* renamed from: d, reason: collision with root package name */
    private final double f13855d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13856e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13857f;

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(2:2|3)|(15:5|6|7|8|9|10|11|12|13|14|15|16|17|18|19)|34|6|7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r1);
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0032, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0033, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0023, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0024, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzael(zzaei zzaeiVar) {
        Drawable drawable;
        IObjectWrapper t4;
        this.a = zzaeiVar;
        Uri uri = null;
        try {
            t4 = zzaeiVar.t4();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        if (t4 != null) {
            drawable = (Drawable) ObjectWrapper.k0(t4);
            this.f13853b = drawable;
            uri = this.a.I0();
            this.f13854c = uri;
            double d2 = 1.0d;
            d2 = this.a.T3();
            this.f13855d = d2;
            int i2 = -1;
            int i3 = this.a.getWidth();
            this.f13856e = i3;
            i2 = this.a.getHeight();
            this.f13857f = i2;
        }
        drawable = null;
        this.f13853b = drawable;
        uri = this.a.I0();
        this.f13854c = uri;
        double d22 = 1.0d;
        d22 = this.a.T3();
        this.f13855d = d22;
        int i22 = -1;
        int i32 = this.a.getWidth();
        this.f13856e = i32;
        i22 = this.a.getHeight();
        this.f13857f = i22;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.f13853b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.f13857f;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.f13855d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.f13854c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.f13856e;
    }
}
