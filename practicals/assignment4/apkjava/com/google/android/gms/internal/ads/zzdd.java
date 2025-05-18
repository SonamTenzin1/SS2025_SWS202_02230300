package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public abstract class zzdd implements zzdc {

    /* renamed from: f, reason: collision with root package name */
    protected static volatile zzdy f15874f;

    /* renamed from: g, reason: collision with root package name */
    protected MotionEvent f15875g;
    protected double p;
    private double q;
    private double r;
    protected float s;
    protected float t;
    protected float u;
    protected float v;
    protected DisplayMetrics y;

    /* renamed from: h, reason: collision with root package name */
    protected LinkedList<MotionEvent> f15876h = new LinkedList<>();

    /* renamed from: i, reason: collision with root package name */
    protected long f15877i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected long f15878j = 0;

    /* renamed from: k, reason: collision with root package name */
    protected long f15879k = 0;
    protected long l = 0;
    protected long m = 0;
    protected long n = 0;
    protected long o = 0;
    private boolean w = false;
    protected boolean x = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdd(Context context) {
        try {
            if (((Boolean) zzyt.e().c(zzacu.t2)).booleanValue()) {
                ij.f();
            } else {
                qy.a(f15874f);
            }
            this.y = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(14:5|6|7|(2:9|(10:11|12|13|(1:15)(1:46)|(2:(1:18)(1:21)|19)|22|(3:36|37|(1:39)(4:40|(2:(1:43)(1:45)|44)|25|26))|24|25|26))|54|12|13|(0)(0)|(0)|22|(0)|24|25|26)|57|7|(0)|54|12|13|(0)(0)|(0)|22|(0)|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0054, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0056, code lost:
    
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0058, code lost:
    
        if (r12 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005a, code lost:
    
        r10 = 1003;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005f, code lost:
    
        r1.c(r10, -1, java.lang.System.currentTimeMillis() - r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005d, code lost:
    
        r10 = okhttp3.internal.ws.WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035 A[Catch: Exception -> 0x0054, TRY_ENTER, TryCatch #2 {Exception -> 0x0054, blocks: (B:15:0x0035, B:19:0x004b, B:46:0x003d), top: B:13:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003d A[Catch: Exception -> 0x0054, TryCatch #2 {Exception -> 0x0054, blocks: (B:15:0x0035, B:19:0x004b, B:46:0x003d), top: B:13:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String d(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        zzbk.zza zzaVar;
        zzda zzdaVar;
        String h2;
        zzbp.zza.C0176zza c0176zza = null;
        if (bArr != null && bArr.length > 0) {
            try {
                zzaVar = zzbk.zza.x(bArr, zzdno.e());
            } catch (zzdok unused) {
            }
            if (f15874f != null) {
                if (((Boolean) zzyt.e().c(zzacu.j2)).booleanValue()) {
                    zzdaVar = f15874f.w();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (z) {
                        c0176zza = b(context, view, activity);
                        this.w = true;
                    } else {
                        c0176zza = c(context, zzaVar);
                    }
                    if (zzdaVar != null) {
                        zzdaVar.b(z ? 1002 : 1000, -1, System.currentTimeMillis() - currentTimeMillis);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (c0176zza != null) {
                        try {
                        } catch (Exception e2) {
                            h2 = Integer.toString(7);
                            if (zzdaVar != null) {
                                zzdaVar.c(z ? 1007 : WebSocketProtocol.CLOSE_NO_STATUS_CODE, -1, System.currentTimeMillis() - currentTimeMillis2, e2);
                            }
                        }
                        if (((zzbp.zza) ((zzdob) c0176zza.p0())).i() != 0) {
                            h2 = ij.h((zzbp.zza) ((zzdob) c0176zza.p0()), str);
                            if (zzdaVar != null) {
                                zzdaVar.b(z ? 1006 : 1004, -1, System.currentTimeMillis() - currentTimeMillis2);
                            }
                            return h2;
                        }
                    }
                    h2 = Integer.toString(5);
                    return h2;
                }
            }
            zzdaVar = null;
            long currentTimeMillis3 = System.currentTimeMillis();
            if (z) {
            }
            if (zzdaVar != null) {
            }
            long currentTimeMillis22 = System.currentTimeMillis();
            if (c0176zza != null) {
            }
            h2 = Integer.toString(5);
            return h2;
        }
        zzaVar = null;
        if (f15874f != null) {
        }
        zzdaVar = null;
        long currentTimeMillis32 = System.currentTimeMillis();
        if (z) {
        }
        if (zzdaVar != null) {
        }
        long currentTimeMillis222 = System.currentTimeMillis();
        if (c0176zza != null) {
        }
        h2 = Integer.toString(5);
        return h2;
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr) throws zzdv;

    protected abstract zzbp.zza.C0176zza b(Context context, View view, Activity activity);

    protected abstract zzbp.zza.C0176zza c(Context context, zzbk.zza zzaVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzee e(MotionEvent motionEvent) throws zzdv;

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context) {
        if (zzef.a()) {
            if (((Boolean) zzyt.e().c(zzacu.v2)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return d(context, null, false, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public void zzb(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view, Activity activity) {
        return d(context, str, true, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.w) {
            this.l = 0L;
            this.f15879k = 0L;
            this.f15878j = 0L;
            this.f15877i = 0L;
            this.m = 0L;
            this.o = 0L;
            this.n = 0L;
            Iterator<MotionEvent> it = this.f15876h.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.f15876h.clear();
            this.f15875g = null;
            this.w = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = 0.0d;
            this.q = motionEvent.getRawX();
            this.r = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = this.q;
            Double.isNaN(rawX);
            double d3 = rawX - d2;
            double d4 = this.r;
            Double.isNaN(rawY);
            double d5 = rawY - d4;
            this.p += Math.sqrt((d3 * d3) + (d5 * d5));
            this.q = rawX;
            this.r = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    this.f15875g = obtain;
                    this.f15876h.add(obtain);
                    if (this.f15876h.size() > 6) {
                        this.f15876h.remove().recycle();
                    }
                    this.f15879k++;
                    this.m = a(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.f15878j += motionEvent.getHistorySize() + 1;
                    zzee e2 = e(motionEvent);
                    if ((e2 == null || e2.f16195e == null || e2.f16198h == null) ? false : true) {
                        this.n += e2.f16195e.longValue() + e2.f16198h.longValue();
                    }
                    if (this.y != null && e2 != null && e2.f16196f != null && e2.f16199i != null) {
                        z = true;
                    }
                    if (z) {
                        this.o += e2.f16196f.longValue() + e2.f16199i.longValue();
                    }
                } else if (action2 == 3) {
                    this.l++;
                }
            } catch (zzdv unused) {
            }
        } else {
            this.s = motionEvent.getX();
            this.t = motionEvent.getY();
            this.u = motionEvent.getRawX();
            this.v = motionEvent.getRawY();
            this.f15877i++;
        }
        this.x = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(int i2, int i3, int i4) {
        MotionEvent motionEvent = this.f15875g;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        DisplayMetrics displayMetrics = this.y;
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            this.f15875g = MotionEvent.obtain(0L, i4, 1, i2 * f2, i3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f15875g = null;
        }
        this.x = false;
    }
}
