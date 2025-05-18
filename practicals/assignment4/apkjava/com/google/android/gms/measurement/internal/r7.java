package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzmd;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class r7 {
    private String a;

    /* renamed from: b, reason: collision with root package name */
    private zzbr.zza f17938b;

    /* renamed from: c, reason: collision with root package name */
    private BitSet f17939c;

    /* renamed from: d, reason: collision with root package name */
    private BitSet f17940d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Long> f17941e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, List<Long>> f17942f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ q7 f17943g;

    private r7(q7 q7Var, String str) {
        this.f17943g = q7Var;
        this.a = str;
        this.f17938b = (zzbr.zza) ((zzfd) zzbr.zza.Q().C(true).y());
        this.f17939c = new BitSet();
        this.f17940d = new BitSet();
        this.f17941e = new c.e.a();
        this.f17942f = new c.e.a();
    }

    private final List<zzbr.zzb> c() {
        if (this.f17941e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f17941e.size());
        Iterator<Integer> it = this.f17941e.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            arrayList.add((zzbr.zzb) ((zzfd) zzbr.zzb.J().w(intValue).A(this.f17941e.get(Integer.valueOf(intValue)).longValue()).y()));
        }
        return arrayList;
    }

    private static List<zzbr.zzj> d(List<zzbr.zzj> list, List<zzbr.zzj> list2, List<Integer> list3) {
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list2);
        c.e.a aVar = new c.e.a();
        for (zzbr.zzj zzjVar : list) {
            if (zzjVar.I() && zzjVar.M() > 0) {
                aVar.put(Integer.valueOf(zzjVar.J()), Long.valueOf(zzjVar.B(zzjVar.M() - 1)));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzbr.zzj zzjVar2 = (zzbr.zzj) arrayList.get(i2);
            Long l = (Long) aVar.remove(zzjVar2.I() ? Integer.valueOf(zzjVar2.J()) : null);
            if (l != null && (list3 == null || !list3.contains(Integer.valueOf(zzjVar2.J())))) {
                ArrayList arrayList2 = new ArrayList();
                if (l.longValue() < zzjVar2.B(0)) {
                    arrayList2.add(l);
                }
                arrayList2.addAll(zzjVar2.L());
                arrayList.set(i2, (zzbr.zzj) ((zzfd) zzjVar2.v().w().C(arrayList2).y()));
            }
        }
        for (Integer num : aVar.keySet()) {
            arrayList.add((zzbr.zzj) ((zzfd) zzbr.zzj.N().A(num.intValue()).B(((Long) aVar.get(num)).longValue()).y()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b4, code lost:
    
        if (r9 != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzbr.zza a(int i2, boolean z, List<Integer> list) {
        zzbr.zza.C0191zza c0191zza;
        ?? arrayList;
        zzbr.zza zzaVar = this.f17938b;
        if (zzaVar == null) {
            c0191zza = zzbr.zza.Q();
        } else {
            c0191zza = zzaVar.v();
        }
        c0191zza.w(i2);
        zzbr.zzi.zza B = zzbr.zzi.a0().E(zzkg.F(this.f17939c)).B(zzkg.F(this.f17940d));
        B.F(c());
        if (this.f17942f == null) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(this.f17942f.size());
            for (Integer num : this.f17942f.keySet()) {
                zzbr.zzj.zza A = zzbr.zzj.N().A(num.intValue());
                List<Long> list2 = this.f17942f.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    Iterator<Long> it = list2.iterator();
                    while (it.hasNext()) {
                        A.B(it.next().longValue());
                    }
                }
                arrayList.add((zzbr.zzj) ((zzfd) A.y()));
            }
        }
        List<zzbr.zzj> list3 = arrayList;
        if (c0191zza.D()) {
            if (zzmd.b()) {
                list3 = arrayList;
                if (this.f17943g.n().y(this.a, zzap.D0)) {
                }
            }
            list3 = d(c0191zza.E().X(), arrayList, list);
        }
        B.G(list3);
        c0191zza.A(B);
        return (zzbr.zza) ((zzfd) c0191zza.y());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map) {
        this.f17939c = bitSet;
        this.f17940d = bitSet2;
        this.f17941e = map;
        zzbr.zzi.zza B = zzbr.zzi.a0().E(zzkg.F(bitSet)).B(zzkg.F(bitSet2));
        B.F(c());
        this.f17938b = (zzbr.zza) ((zzfd) zzbr.zza.Q().C(false).B(zziVar).A(B).y());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(w7 w7Var) {
        int a = w7Var.a();
        Boolean bool = w7Var.f18010c;
        if (bool != null) {
            this.f17940d.set(a, bool.booleanValue());
        }
        Boolean bool2 = w7Var.f18011d;
        if (bool2 != null) {
            this.f17939c.set(a, bool2.booleanValue());
        }
        if (w7Var.f18012e != null) {
            Long l = this.f17941e.get(Integer.valueOf(a));
            long longValue = w7Var.f18012e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f17941e.put(Integer.valueOf(a), Long.valueOf(longValue));
            }
        }
        if (w7Var.f18013f != null) {
            List<Long> list = this.f17942f.get(Integer.valueOf(a));
            if (list == null) {
                list = new ArrayList<>();
                this.f17942f.put(Integer.valueOf(a), list);
            }
            list.add(Long.valueOf(w7Var.f18013f.longValue() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r7(q7 q7Var, String str, s7 s7Var) {
        this(q7Var, str);
    }
}
