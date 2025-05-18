package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzup {

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private int f16817b;
    private final Object a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private List<zzuo> f16818c = new LinkedList();

    public final boolean a(zzuo zzuoVar) {
        synchronized (this.a) {
            return this.f16818c.contains(zzuoVar);
        }
    }

    public final boolean b(zzuo zzuoVar) {
        synchronized (this.a) {
            Iterator<zzuo> it = this.f16818c.iterator();
            while (it.hasNext()) {
                zzuo next = it.next();
                if (!zzk.zzlk().r().k()) {
                    if (zzuoVar != next && next.i().equals(zzuoVar.i())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzk.zzlk().r().b() && zzuoVar != next && next.k().equals(zzuoVar.k())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void c(zzuo zzuoVar) {
        synchronized (this.a) {
            if (this.f16818c.size() >= 10) {
                int size = this.f16818c.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzbad.e(sb.toString());
                this.f16818c.remove(0);
            }
            int i2 = this.f16817b;
            this.f16817b = i2 + 1;
            zzuoVar.e(i2);
            zzuoVar.o();
            this.f16818c.add(zzuoVar);
        }
    }

    public final zzuo d(boolean z) {
        synchronized (this.a) {
            zzuo zzuoVar = null;
            if (this.f16818c.size() == 0) {
                zzbad.e("Queue empty");
                return null;
            }
            int i2 = 0;
            if (this.f16818c.size() >= 2) {
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                for (zzuo zzuoVar2 : this.f16818c) {
                    int a = zzuoVar2.a();
                    if (a > i3) {
                        i2 = i4;
                        zzuoVar = zzuoVar2;
                        i3 = a;
                    }
                    i4++;
                }
                this.f16818c.remove(i2);
                return zzuoVar;
            }
            zzuo zzuoVar3 = this.f16818c.get(0);
            if (z) {
                this.f16818c.remove(0);
            } else {
                zzuoVar3.l();
            }
            return zzuoVar3;
        }
    }
}
