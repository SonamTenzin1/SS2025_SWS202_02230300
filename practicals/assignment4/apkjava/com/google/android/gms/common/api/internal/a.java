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
public final class a implements OnCompleteListener<Map<zai<?>, String>> {
    private SignInConnectionListener a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zax f11741b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zax zaxVar, SignInConnectionListener signInConnectionListener) {
        this.f11741b = zaxVar;
        this.a = signInConnectionListener;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        Map map;
        Map map2;
        boolean l;
        Map map3;
        Map map4;
        Map map5;
        Map map6;
        ConnectionResult r;
        Condition condition;
        Map map7;
        Map map8;
        Map map9;
        lock = this.f11741b.f11886k;
        lock.lock();
        try {
            z = this.f11741b.s;
            if (!z) {
                this.a.a();
                return;
            }
            if (task.n()) {
                zax zaxVar = this.f11741b;
                map7 = zaxVar.f11882g;
                zaxVar.u = new c.e.a(map7.size());
                map8 = this.f11741b.f11882g;
                for (zaw zawVar : map8.values()) {
                    map9 = this.f11741b.u;
                    map9.put(zawVar.l(), ConnectionResult.f11619f);
                }
            } else if (task.i() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.i();
                z2 = this.f11741b.q;
                if (!z2) {
                    this.f11741b.u = availabilityException.b();
                } else {
                    zax zaxVar2 = this.f11741b;
                    map = zaxVar2.f11882g;
                    zaxVar2.u = new c.e.a(map.size());
                    map2 = this.f11741b.f11882g;
                    for (zaw zawVar2 : map2.values()) {
                        Object l2 = zawVar2.l();
                        ConnectionResult a = availabilityException.a(zawVar2);
                        l = this.f11741b.l(zawVar2, a);
                        if (l) {
                            map3 = this.f11741b.u;
                            map3.put(l2, new ConnectionResult(16));
                        } else {
                            map4 = this.f11741b.u;
                            map4.put(l2, a);
                        }
                    }
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.i());
                this.f11741b.u = Collections.emptyMap();
            }
            if (this.f11741b.isConnected()) {
                map5 = this.f11741b.t;
                map6 = this.f11741b.u;
                map5.putAll(map6);
                r = this.f11741b.r();
                if (r == null) {
                    this.f11741b.p();
                    this.f11741b.q();
                    condition = this.f11741b.n;
                    condition.signalAll();
                }
            }
            this.a.a();
        } finally {
            lock2 = this.f11741b.f11886k;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.a.a();
    }
}
