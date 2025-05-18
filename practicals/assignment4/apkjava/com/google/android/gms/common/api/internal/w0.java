package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w0 implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax a;

    private w0(zax zaxVar) {
        this.a = zaxVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        ConnectionResult r;
        Map map;
        Map map2;
        boolean l;
        Map map3;
        Map map4;
        Map map5;
        ConnectionResult connectionResult;
        zaaw zaawVar;
        ConnectionResult connectionResult2;
        Condition condition;
        Map map6;
        Map map7;
        ConnectionResult r2;
        Map map8;
        Map map9;
        Map map10;
        lock = this.a.f11886k;
        lock.lock();
        try {
            z = this.a.s;
            if (z) {
                if (task.n()) {
                    zax zaxVar = this.a;
                    map8 = zaxVar.f11881f;
                    zaxVar.t = new c.e.a(map8.size());
                    map9 = this.a.f11881f;
                    for (zaw zawVar : map9.values()) {
                        map10 = this.a.t;
                        map10.put(zawVar.l(), ConnectionResult.f11619f);
                    }
                } else if (task.i() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.i();
                    z2 = this.a.q;
                    if (!z2) {
                        this.a.t = availabilityException.b();
                    } else {
                        zax zaxVar2 = this.a;
                        map = zaxVar2.f11881f;
                        zaxVar2.t = new c.e.a(map.size());
                        map2 = this.a.f11881f;
                        for (zaw zawVar2 : map2.values()) {
                            Object l2 = zawVar2.l();
                            ConnectionResult a = availabilityException.a(zawVar2);
                            l = this.a.l(zawVar2, a);
                            if (l) {
                                map3 = this.a.t;
                                map3.put(l2, new ConnectionResult(16));
                            } else {
                                map4 = this.a.t;
                                map4.put(l2, a);
                            }
                        }
                    }
                    zax zaxVar3 = this.a;
                    r = zaxVar3.r();
                    zaxVar3.w = r;
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.i());
                    this.a.t = Collections.emptyMap();
                    this.a.w = new ConnectionResult(8);
                }
                map5 = this.a.u;
                if (map5 != null) {
                    map6 = this.a.t;
                    map7 = this.a.u;
                    map6.putAll(map7);
                    zax zaxVar4 = this.a;
                    r2 = zaxVar4.r();
                    zaxVar4.w = r2;
                }
                connectionResult = this.a.w;
                if (connectionResult == null) {
                    this.a.p();
                    this.a.q();
                } else {
                    zax.n(this.a, false);
                    zaawVar = this.a.f11885j;
                    connectionResult2 = this.a.w;
                    zaawVar.a(connectionResult2);
                }
                condition = this.a.n;
                condition.signalAll();
            }
        } finally {
            lock2 = this.a.f11886k;
            lock2.unlock();
        }
    }
}
