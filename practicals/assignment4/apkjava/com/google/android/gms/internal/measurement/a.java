package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class a extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17122j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17123k;
    private final /* synthetic */ Context l;
    private final /* synthetic */ Bundle m;
    private final /* synthetic */ zzx n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(zzx zzxVar, String str, String str2, Context context, Bundle bundle) {
        super(zzxVar);
        this.n = zzxVar;
        this.f17122j = str;
        this.f17123k = str2;
        this.l = context;
        this.m = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[Catch: RemoteException -> 0x009e, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0052, B:16:0x005e, B:18:0x006c, B:22:0x0081), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[Catch: RemoteException -> 0x009e, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0052, B:16:0x005e, B:18:0x006c, B:22:0x0081), top: B:2:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.zzx.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean J;
        String str;
        String str2;
        String str3;
        Boolean bool;
        boolean z;
        zzm zzmVar;
        int U;
        int S;
        boolean z2;
        int i2;
        zzm zzmVar2;
        String str4;
        String str5;
        try {
            this.n.l = new ArrayList();
            zzx zzxVar = this.n;
            J = zzx.J(this.f17122j, this.f17123k);
            if (J) {
                String str6 = this.f17123k;
                String str7 = this.f17122j;
                str5 = this.n.f17577h;
                str2 = str7;
                str3 = str6;
                str = str5;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            zzx.W(this.l);
            bool = zzx.f17572c;
            if (!bool.booleanValue() && str2 == null) {
                z = false;
                zzx zzxVar2 = this.n;
                zzxVar2.p = zzxVar2.b(this.l, z);
                zzmVar = this.n.p;
                if (zzmVar != null) {
                    str4 = this.n.f17577h;
                    Log.w(str4, "Failed to connect to measurement client.");
                    return;
                }
                U = zzx.U(this.l);
                S = zzx.S(this.l);
                if (z) {
                    i2 = Math.max(U, S);
                    z2 = S < U;
                } else {
                    if (U > 0) {
                        S = U;
                    }
                    z2 = U > 0;
                    i2 = S;
                }
                zzv zzvVar = new zzv(18202L, i2, z2, str, str2, str3, this.m);
                zzmVar2 = this.n.p;
                zzmVar2.initialize(ObjectWrapper.E0(this.l), zzvVar, this.f17581f);
                return;
            }
            z = true;
            zzx zzxVar22 = this.n;
            zzxVar22.p = zzxVar22.b(this.l, z);
            zzmVar = this.n.p;
            if (zzmVar != null) {
            }
        } catch (RemoteException e2) {
            this.n.p(e2, true, false);
        }
    }
}
