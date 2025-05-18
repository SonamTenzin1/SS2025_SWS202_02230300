package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzagj extends UnifiedNativeAd {
    private final zzagg a;

    /* renamed from: c, reason: collision with root package name */
    private final zzael f13876c;

    /* renamed from: e, reason: collision with root package name */
    private final NativeAd.AdChoicesInfo f13878e;

    /* renamed from: g, reason: collision with root package name */
    private final UnifiedNativeAd.zza f13880g;

    /* renamed from: b, reason: collision with root package name */
    private final List<NativeAd.Image> f13875b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final VideoController f13877d = new VideoController();

    /* renamed from: f, reason: collision with root package name */
    private final List<MuteThisAdReason> f13879f = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(3:2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6)))|24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28))|41|42|(12:44|45|46|47|(7:49|50|51|52|(2:54|55)|57|58)|63|50|51|52|(0)|57|58)|67|45|46|47|(0)|63|50|51|52|(0)|57|58) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28))|41|42|(12:44|45|46|47|(7:49|50|51|52|(2:54|55)|57|58)|63|50|51|52|(0)|57|58)|67|45|46|47|(0)|63|50|51|52|(0)|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d7, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ba, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        com.google.android.gms.internal.ads.zzbad.c(okhttp3.HttpUrl.FRAGMENT_ENCODE_SET, r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae A[Catch: RemoteException -> 0x00ba, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00ba, blocks: (B:47:0x00a6, B:49:0x00ae), top: B:46:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9 A[Catch: RemoteException -> 0x00d6, TRY_LEAVE, TryCatch #4 {RemoteException -> 0x00d6, blocks: (B:52:0x00c1, B:54:0x00c9), top: B:51:0x00c1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzagj(zzagg zzaggVar) {
        zzael zzaelVar;
        zzaed zzaedVar;
        zzaei n;
        zzaei zzaeiVar;
        IBinder iBinder;
        this.a = zzaggVar;
        zzaeh zzaehVar = null;
        try {
            List k2 = zzaggVar.k();
            if (k2 != null) {
                for (Object obj : k2) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaeiVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        if (queryLocalInterface instanceof zzaei) {
                            zzaeiVar = (zzaei) queryLocalInterface;
                        } else {
                            zzaeiVar = new zzaek(iBinder);
                        }
                    }
                    if (zzaeiVar != null) {
                        this.f13875b.add(new zzael(zzaeiVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        try {
            List u4 = this.a.u4();
            if (u4 != null) {
                for (Object obj2 : u4) {
                    zzaak h7 = obj2 instanceof IBinder ? zzaal.h7((IBinder) obj2) : null;
                    if (h7 != null) {
                        this.f13879f.add(new zzaan(h7));
                    }
                }
            }
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        try {
            n = this.a.n();
        } catch (RemoteException e4) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e4);
        }
        if (n != null) {
            zzaelVar = new zzael(n);
            this.f13876c = zzaelVar;
            if (this.a.f() != null) {
                zzaedVar = new zzaed(this.a.f());
                this.f13878e = zzaedVar;
                if (this.a.n2() != null) {
                    zzaehVar = new zzaeh(this.a.n2());
                }
                this.f13880g = zzaehVar;
            }
            zzaedVar = null;
            this.f13878e = zzaedVar;
            if (this.a.n2() != null) {
            }
            this.f13880g = zzaehVar;
        }
        zzaelVar = null;
        this.f13876c = zzaelVar;
        if (this.a.f() != null) {
        }
        zzaedVar = null;
        this.f13878e = zzaedVar;
        if (this.a.n2() != null) {
        }
        this.f13880g = zzaehVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzkq() {
        try {
            return this.a.r();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.a.W();
        } catch (RemoteException e2) {
            zzbad.c("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.a.destroy();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.a.j0();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f13878e;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.a.w();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.a.i();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.a.h();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.a.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.a.g();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.f13876c;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.f13875b;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.f13879f;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.a.o();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double t = this.a.t();
            if (t == -1.0d) {
                return null;
            }
            return Double.valueOf(t);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.a.getStore();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.a.getVideoController() != null) {
                this.f13877d.zza(this.a.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbad.c("Exception occurred while getting video controller", e2);
        }
        return this.f13877d;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.a.u2();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbad.g("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.a.e0(null);
            } else if (muteThisAdReason instanceof zzaan) {
                this.a.e0(((zzaan) muteThisAdReason).a());
            } else {
                zzbad.g("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.a.z(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.a.D6();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.a.E(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.a.L(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.a.G0(new zzaaj(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.a.d0(new zzagt(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbad.c("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzkv() {
        try {
            IObjectWrapper j2 = this.a.j();
            if (j2 != null) {
                return ObjectWrapper.k0(j2);
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }
}
