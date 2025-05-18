package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class u7 {
    private String a;

    /* renamed from: b, reason: collision with root package name */
    private Set<Integer> f17982b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, r7> f17983c = new c.e.a();

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ q7 f17984d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u7(q7 q7Var, String str) {
        this.f17984d = q7Var;
        this.a = str;
    }

    private final r7 a(int i2) {
        if (this.f17983c.containsKey(Integer.valueOf(i2))) {
            return this.f17983c.get(Integer.valueOf(i2));
        }
        r7 r7Var = new r7(this.f17984d, this.a, null);
        this.f17983c.put(Integer.valueOf(i2), r7Var);
        return r7Var;
    }

    private final boolean c(int i2, int i3) {
        BitSet bitSet;
        if (this.f17983c.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        bitSet = this.f17983c.get(Integer.valueOf(i2)).f17939c;
        return bitSet.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x076e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzbr.zza> b(List<zzbr.zzc> list, List<zzbr.zzk> list2, Long l) {
        boolean z;
        String str;
        Iterator<zzbr.zzc> it;
        h D;
        zzbr.zzc zzcVar;
        h hVar;
        Map<Integer, List<zzbj.zzb>> map;
        Iterator<Integer> it2;
        Iterator<zzbr.zzc> it3;
        Object obj;
        Long l2;
        ArrayList arrayList;
        SQLiteDatabase x;
        String[] strArr;
        Map<Integer, zzbr.zzi> map2;
        boolean z2;
        if (this.f17984d.n().y(this.a, zzap.w0) || this.f17984d.n().y(this.a, zzap.x0)) {
            Iterator<zzbr.zzc> it4 = list.iterator();
            while (it4.hasNext()) {
                if ("_s".equals(it4.next().U())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean y = this.f17984d.n().y(this.a, zzap.w0);
        boolean y2 = this.f17984d.n().y(this.a, zzap.x0);
        if (z && y2) {
            c q = this.f17984d.q();
            String str2 = this.a;
            q.t();
            q.d();
            Preconditions.g(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                q.x().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e2) {
                q.h().H().c("Error resetting session-scoped event counts. appId", zzet.x(str2), e2);
            }
        }
        Map<Integer, zzbr.zzi> u0 = this.f17984d.q().u0(this.a);
        if (u0 != null && !u0.isEmpty()) {
            HashSet hashSet = new HashSet(u0.keySet());
            if (y && z) {
                q7 q7Var = this.f17984d;
                String str3 = this.a;
                Preconditions.g(str3);
                Preconditions.k(u0);
                map2 = new c.e.a<>();
                if (!u0.isEmpty()) {
                    Map<Integer, List<Integer>> t0 = q7Var.q().t0(str3);
                    Iterator<Integer> it5 = u0.keySet().iterator();
                    while (it5.hasNext()) {
                        int intValue = it5.next().intValue();
                        zzbr.zzi zziVar = u0.get(Integer.valueOf(intValue));
                        List<Integer> list3 = t0.get(Integer.valueOf(intValue));
                        if (list3 != null && !list3.isEmpty()) {
                            List<Long> H = q7Var.p().H(zziVar.N(), list3);
                            if (!H.isEmpty()) {
                                zzbr.zzi.zza E = zziVar.v().C().E(H);
                                E.w().B(q7Var.p().H(zziVar.C(), list3));
                                for (int i2 = 0; i2 < zziVar.W(); i2++) {
                                    if (list3.contains(Integer.valueOf(zziVar.B(i2).G()))) {
                                        E.A(i2);
                                    }
                                }
                                for (int i3 = 0; i3 < zziVar.Z(); i3++) {
                                    if (list3.contains(Integer.valueOf(zziVar.I(i3).J()))) {
                                        E.D(i3);
                                    }
                                }
                                map2.put(Integer.valueOf(intValue), (zzbr.zzi) ((zzfd) E.y()));
                            }
                        } else {
                            map2.put(Integer.valueOf(intValue), zziVar);
                        }
                    }
                }
            } else {
                map2 = u0;
            }
            Iterator it6 = hashSet.iterator();
            while (it6.hasNext()) {
                int intValue2 = ((Integer) it6.next()).intValue();
                zzbr.zzi zziVar2 = map2.get(Integer.valueOf(intValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                c.e.a aVar = new c.e.a();
                if (zziVar2 != null && zziVar2.W() != 0) {
                    for (zzbr.zzb zzbVar : zziVar2.U()) {
                        if (zzbVar.F()) {
                            aVar.put(Integer.valueOf(zzbVar.G()), zzbVar.H() ? Long.valueOf(zzbVar.I()) : null);
                        }
                    }
                }
                if (zziVar2 != null) {
                    for (int i4 = 0; i4 < (zziVar2.H() << 6); i4++) {
                        if (zzkg.T(zziVar2.C(), i4)) {
                            this.f17984d.h().P().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i4));
                            bitSet2.set(i4);
                            if (zzkg.T(zziVar2.N(), i4)) {
                                bitSet.set(i4);
                                z2 = true;
                                if (z2) {
                                    aVar.remove(Integer.valueOf(i4));
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                if (y) {
                    zziVar2 = u0.get(Integer.valueOf(intValue2));
                }
                a(intValue2).e(zziVar2, bitSet, bitSet2, aVar);
            }
        }
        String str4 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            c.e.a aVar2 = new c.e.a();
            Iterator<zzbr.zzc> it7 = list.iterator();
            zzbr.zzc zzcVar2 = null;
            Long l3 = null;
            long j2 = 0;
            while (it7.hasNext()) {
                zzbr.zzc next = it7.next();
                String U = next.U();
                List<zzbr.zze> C = next.C();
                this.f17984d.p();
                Long l4 = (Long) zzkg.U(next, "_eid");
                boolean z3 = l4 != null;
                if (z3 && U.equals("_ep")) {
                    this.f17984d.p();
                    U = (String) zzkg.U(next, "_en");
                    if (TextUtils.isEmpty(U)) {
                        this.f17984d.h().H().b("Extra parameter without an event name. eventId", l4);
                        it3 = it7;
                    } else {
                        if (zzcVar2 == null || l3 == null || l4.longValue() != l3.longValue()) {
                            Pair<zzbr.zzc, Long> B = this.f17984d.q().B(this.a, l4);
                            if (B != null && (obj = B.first) != null) {
                                zzcVar2 = (zzbr.zzc) obj;
                                j2 = ((Long) B.second).longValue();
                                this.f17984d.p();
                                l3 = (Long) zzkg.U(zzcVar2, "_eid");
                            } else {
                                it3 = it7;
                                this.f17984d.h().H().c("Extra parameter without existing main event. eventName, eventId", U, l4);
                            }
                        }
                        zzbr.zzc zzcVar3 = zzcVar2;
                        j2--;
                        if (j2 <= 0) {
                            c q2 = this.f17984d.q();
                            String str5 = this.a;
                            q2.d();
                            q2.h().P().b("Clearing complex main event info. appId", str5);
                            try {
                                x = q2.x();
                                it = it7;
                                l2 = l3;
                                try {
                                    strArr = new String[1];
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    q2.h().H().b("Error clearing complex main event", e);
                                    arrayList = new ArrayList();
                                    while (r7.hasNext()) {
                                    }
                                    if (!arrayList.isEmpty()) {
                                    }
                                    zzcVar2 = zzcVar3;
                                    l3 = l2;
                                    q7 q7Var2 = this.f17984d;
                                    String str6 = this.a;
                                    boolean y3 = q7Var2.n().y(str6, zzap.x0);
                                    D = q7Var2.q().D(str6, next.U());
                                    if (D != null) {
                                    }
                                    this.f17984d.q().N(hVar);
                                    long j3 = hVar.f17785c;
                                    map = (Map) aVar2.get(U);
                                    if (map == null) {
                                    }
                                    it2 = map.keySet().iterator();
                                    while (it2.hasNext()) {
                                    }
                                    it7 = it;
                                    zzcVar2 = zzcVar;
                                }
                            } catch (SQLiteException e4) {
                                e = e4;
                                it = it7;
                                l2 = l3;
                            }
                            try {
                                strArr[0] = str5;
                                x.execSQL("delete from main_event_params where app_id=?", strArr);
                            } catch (SQLiteException e5) {
                                e = e5;
                                q2.h().H().b("Error clearing complex main event", e);
                                arrayList = new ArrayList();
                                while (r7.hasNext()) {
                                }
                                if (!arrayList.isEmpty()) {
                                }
                                zzcVar2 = zzcVar3;
                                l3 = l2;
                                q7 q7Var22 = this.f17984d;
                                String str62 = this.a;
                                boolean y32 = q7Var22.n().y(str62, zzap.x0);
                                D = q7Var22.q().D(str62, next.U());
                                if (D != null) {
                                }
                                this.f17984d.q().N(hVar);
                                long j32 = hVar.f17785c;
                                map = (Map) aVar2.get(U);
                                if (map == null) {
                                }
                                it2 = map.keySet().iterator();
                                while (it2.hasNext()) {
                                }
                                it7 = it;
                                zzcVar2 = zzcVar;
                            }
                        } else {
                            it = it7;
                            l2 = l3;
                            this.f17984d.q().X(this.a, l4, j2, zzcVar3);
                        }
                        arrayList = new ArrayList();
                        for (zzbr.zze zzeVar : zzcVar3.C()) {
                            this.f17984d.p();
                            if (zzkg.z(next, zzeVar.B()) == null) {
                                arrayList.add(zzeVar);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            arrayList.addAll(C);
                            C = arrayList;
                        } else {
                            this.f17984d.h().K().b("No unique parameters in main event. eventName", U);
                        }
                        zzcVar2 = zzcVar3;
                        l3 = l2;
                    }
                    it7 = it3;
                } else {
                    it = it7;
                    if (z3) {
                        this.f17984d.p();
                        Object U2 = zzkg.U(next, "_epc");
                        long longValue = ((Long) (U2 != null ? U2 : 0L)).longValue();
                        if (longValue <= 0) {
                            this.f17984d.h().K().b("Complex event with zero extra param count. eventName", U);
                        } else {
                            this.f17984d.q().X(this.a, l4, longValue, next);
                        }
                        j2 = longValue;
                        zzcVar2 = next;
                        l3 = l4;
                        q7 q7Var222 = this.f17984d;
                        String str622 = this.a;
                        boolean y322 = q7Var222.n().y(str622, zzap.x0);
                        D = q7Var222.q().D(str622, next.U());
                        if (D != null) {
                            zzcVar = zzcVar2;
                            q7Var222.h().K().c("Event aggregate wasn't created during raw event logging. appId, event", zzet.x(str622), q7Var222.k().y(U));
                            if (y322) {
                                hVar = new h(str622, next.U(), 1L, 1L, 1L, next.W(), 0L, null, null, null, null);
                            } else {
                                hVar = new h(str622, next.U(), 1L, 1L, next.W(), 0L, null, null, null, null);
                            }
                        } else {
                            zzcVar = zzcVar2;
                            if (y322) {
                                hVar = new h(D.a, D.f17784b, D.f17785c + 1, D.f17786d + 1, D.f17787e + 1, D.f17788f, D.f17789g, D.f17790h, D.f17791i, D.f17792j, D.f17793k);
                            } else {
                                hVar = new h(D.a, D.f17784b, D.f17785c + 1, D.f17786d + 1, D.f17787e, D.f17788f, D.f17789g, D.f17790h, D.f17791i, D.f17792j, D.f17793k);
                            }
                        }
                        this.f17984d.q().N(hVar);
                        long j322 = hVar.f17785c;
                        map = (Map) aVar2.get(U);
                        if (map == null) {
                            map = this.f17984d.q().v0(this.a, U);
                            if (map == null) {
                                map = new c.e.a<>();
                            }
                            aVar2.put(U, map);
                        }
                        it2 = map.keySet().iterator();
                        while (it2.hasNext()) {
                            int intValue3 = it2.next().intValue();
                            c.e.a aVar3 = aVar2;
                            Long l5 = l3;
                            if (this.f17982b.contains(Integer.valueOf(intValue3))) {
                                this.f17984d.h().P().b("Skipping failed audience ID", Integer.valueOf(intValue3));
                                aVar2 = aVar3;
                                l3 = l5;
                            } else {
                                Iterator<zzbj.zzb> it8 = map.get(Integer.valueOf(intValue3)).iterator();
                                boolean z4 = true;
                                while (it8.hasNext()) {
                                    zzbj.zzb next2 = it8.next();
                                    Iterator<zzbj.zzb> it9 = it8;
                                    t7 t7Var = new t7(this.f17984d, this.a, intValue3, next2);
                                    z4 = t7Var.i(next, U, C, j322, hVar, c(intValue3, next2.H()));
                                    a(intValue3).f(t7Var);
                                    it8 = it9;
                                    map = map;
                                    j2 = j2;
                                }
                                Map<Integer, List<zzbj.zzb>> map3 = map;
                                long j4 = j2;
                                if (!z4) {
                                    this.f17982b.add(Integer.valueOf(intValue3));
                                }
                                aVar2 = aVar3;
                                l3 = l5;
                                map = map3;
                                j2 = j4;
                            }
                        }
                        it7 = it;
                        zzcVar2 = zzcVar;
                    }
                }
                q7 q7Var2222 = this.f17984d;
                String str6222 = this.a;
                boolean y3222 = q7Var2222.n().y(str6222, zzap.x0);
                D = q7Var2222.q().D(str6222, next.U());
                if (D != null) {
                }
                this.f17984d.q().N(hVar);
                long j3222 = hVar.f17785c;
                map = (Map) aVar2.get(U);
                if (map == null) {
                }
                it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                }
                it7 = it;
                zzcVar2 = zzcVar;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!list2.isEmpty()) {
            c.e.a aVar4 = new c.e.a();
            for (zzbr.zzk zzkVar : list2) {
                arrayList2.add(zzkVar.P());
                String P = zzkVar.P();
                Map<Integer, List<zzbj.zze>> map4 = (Map) aVar4.get(P);
                if (map4 == null) {
                    map4 = this.f17984d.q().y0(this.a, P);
                    if (map4 == null) {
                        map4 = new c.e.a<>();
                    }
                    aVar4.put(P, map4);
                }
                Iterator<Integer> it10 = map4.keySet().iterator();
                while (true) {
                    if (it10.hasNext()) {
                        int intValue4 = it10.next().intValue();
                        if (this.f17982b.contains(Integer.valueOf(intValue4))) {
                            this.f17984d.h().P().b(str4, Integer.valueOf(intValue4));
                            break;
                        }
                        boolean z5 = true;
                        for (zzbj.zze zzeVar2 : map4.get(Integer.valueOf(intValue4))) {
                            if (this.f17984d.h().C(2)) {
                                str = str4;
                                this.f17984d.h().P().d("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), zzeVar2.D() ? Integer.valueOf(zzeVar2.E()) : null, this.f17984d.k().B(zzeVar2.F()));
                                this.f17984d.h().P().b("Filter definition", this.f17984d.p().C(zzeVar2));
                            } else {
                                str = str4;
                            }
                            if (zzeVar2.D() && zzeVar2.E() <= 256) {
                                v7 v7Var = new v7(this.f17984d, this.a, intValue4, zzeVar2);
                                z5 = v7Var.i(l, zzkVar, c(intValue4, zzeVar2.E()));
                                a(intValue4).f(v7Var);
                                str4 = str;
                            } else {
                                this.f17984d.h().K().c("Invalid property filter ID. appId, id", zzet.x(this.a), String.valueOf(zzeVar2.D() ? Integer.valueOf(zzeVar2.E()) : null));
                                z5 = false;
                                if (z5) {
                                    this.f17982b.add(Integer.valueOf(intValue4));
                                }
                                str4 = str;
                            }
                        }
                        str = str4;
                        if (z5) {
                        }
                        str4 = str;
                    }
                }
            }
        }
        boolean y4 = this.f17984d.n().y(this.a, zzap.C0);
        Map<Integer, List<Integer>> aVar5 = new c.e.a<>();
        if (y4) {
            aVar5 = this.f17984d.q().l0(this.a, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> keySet = this.f17983c.keySet();
        keySet.removeAll(this.f17982b);
        Iterator<Integer> it11 = keySet.iterator();
        while (it11.hasNext()) {
            int intValue5 = it11.next().intValue();
            zzbr.zza a = this.f17983c.get(Integer.valueOf(intValue5)).a(intValue5, z, aVar5.get(Integer.valueOf(intValue5)));
            arrayList3.add(a);
            c q3 = this.f17984d.q();
            String str7 = this.a;
            zzbr.zzi L = a.L();
            q3.t();
            q3.d();
            Preconditions.g(str7);
            Preconditions.k(L);
            byte[] j5 = L.j();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(RateAndReviewsFragment.BundleCons.APP_ID, str7);
            contentValues2.put("audience_id", Integer.valueOf(intValue5));
            contentValues2.put("current_results", j5);
            try {
            } catch (SQLiteException e6) {
                e = e6;
            }
            try {
                if (q3.x().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                    q3.h().H().b("Failed to insert filter results (got -1). appId", zzet.x(str7));
                }
            } catch (SQLiteException e7) {
                e = e7;
                q3.h().H().c("Error storing filter results. appId", zzet.x(str7), e);
            }
        }
        return arrayList3;
    }
}
