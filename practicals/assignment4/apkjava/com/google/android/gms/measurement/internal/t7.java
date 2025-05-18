package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class t7 extends w7 {

    /* renamed from: g, reason: collision with root package name */
    private zzbj.zzb f17970g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q7 f17971h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t7(q7 q7Var, String str, int i2, zzbj.zzb zzbVar) {
        super(str, i2);
        this.f17971h = q7Var;
        this.f17970g = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.w7
    public final int a() {
        return this.f17970g.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(zzbr.zzc zzcVar, String str, List<zzbr.zze> list, long j2, h hVar, boolean z) {
        Boolean e2;
        boolean y = this.f17971h.n().y(this.a, zzap.w0);
        if (this.f17971h.n().y(this.a, zzap.x0) && y && this.f17970g.Q()) {
            j2 = hVar.f17787e;
        }
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        Boolean bool = null;
        if (this.f17971h.h().C(2)) {
            this.f17971h.h().P().d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f18009b), this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null, this.f17971h.k().y(this.f17970g.I()));
            this.f17971h.h().P().b("Filter definition", this.f17971h.p().B(this.f17970g));
        }
        if (this.f17970g.G() && this.f17970g.H() <= 256) {
            boolean N = this.f17970g.N();
            boolean O = this.f17970g.O();
            boolean z2 = N || O || (y && this.f17970g.Q());
            if (z && !z2) {
                this.f17971h.h().P().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f18009b), this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null);
                return true;
            }
            zzbj.zzb zzbVar = this.f17970g;
            if (zzbVar.L()) {
                Boolean c2 = w7.c(j2, zzbVar.M());
                if (c2 != null) {
                    if (!c2.booleanValue()) {
                        bool = Boolean.FALSE;
                    }
                }
                this.f17971h.h().P().b("Event filter result", bool != null ? "null" : bool);
                if (bool != null) {
                    return false;
                }
                Boolean bool2 = Boolean.TRUE;
                this.f18010c = bool2;
                if (!bool.booleanValue()) {
                    return true;
                }
                this.f18011d = bool2;
                if (z2 && zzcVar.V()) {
                    if (O) {
                        this.f18013f = Long.valueOf(zzcVar.W());
                    } else {
                        this.f18012e = Long.valueOf(zzcVar.W());
                    }
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator<zzbj.zzc> it = zzbVar.J().iterator();
            while (true) {
                if (it.hasNext()) {
                    zzbj.zzc next = it.next();
                    if (next.J().isEmpty()) {
                        this.f17971h.h().K().b("null or empty param name in filter. event", this.f17971h.k().y(str));
                        break;
                    }
                    hashSet.add(next.J());
                } else {
                    c.e.a aVar = new c.e.a();
                    Iterator<zzbr.zze> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            zzbr.zze next2 = it2.next();
                            if (hashSet.contains(next2.B())) {
                                if (next2.P()) {
                                    aVar.put(next2.B(), next2.P() ? Long.valueOf(next2.Q()) : null);
                                } else if (next2.R()) {
                                    aVar.put(next2.B(), next2.R() ? Double.valueOf(next2.S()) : null);
                                } else if (next2.M()) {
                                    aVar.put(next2.B(), next2.N());
                                } else {
                                    this.f17971h.h().K().c("Unknown value for param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(next2.B()));
                                    break;
                                }
                            }
                        } else {
                            Iterator<zzbj.zzc> it3 = zzbVar.J().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    zzbj.zzc next3 = it3.next();
                                    boolean z3 = next3.H() && next3.I();
                                    String J = next3.J();
                                    if (J.isEmpty()) {
                                        this.f17971h.h().K().b("Event has empty param name. event", this.f17971h.k().y(str));
                                        break;
                                    }
                                    Object obj = aVar.get(J);
                                    if (obj instanceof Long) {
                                        if (!next3.F()) {
                                            this.f17971h.h().K().c("No number filter for long param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                            break;
                                        }
                                        Boolean c3 = w7.c(((Long) obj).longValue(), next3.G());
                                        if (c3 == null) {
                                            break;
                                        }
                                        if (c3.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj instanceof Double) {
                                        if (!next3.F()) {
                                            this.f17971h.h().K().c("No number filter for double param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                            break;
                                        }
                                        Boolean b2 = w7.b(((Double) obj).doubleValue(), next3.G());
                                        if (b2 == null) {
                                            break;
                                        }
                                        if (b2.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj instanceof String) {
                                        if (next3.D()) {
                                            e2 = w7.g((String) obj, next3.E(), this.f17971h.h());
                                        } else if (next3.F()) {
                                            String str2 = (String) obj;
                                            if (zzkg.S(str2)) {
                                                e2 = w7.e(str2, next3.G());
                                            } else {
                                                this.f17971h.h().K().c("Invalid param value for number filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                                break;
                                            }
                                        } else {
                                            this.f17971h.h().K().c("No filter for String param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                            break;
                                        }
                                        if (e2 == null) {
                                            break;
                                        }
                                        if (e2.booleanValue() == z3) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj == null) {
                                        this.f17971h.h().P().c("Missing param for filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                        bool = Boolean.FALSE;
                                    } else {
                                        this.f17971h.h().K().c("Unknown param type. event, param", this.f17971h.k().y(str), this.f17971h.k().A(J));
                                    }
                                } else {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.f17971h.h().P().b("Event filter result", bool != null ? "null" : bool);
            if (bool != null) {
            }
        } else {
            this.f17971h.h().K().c("Invalid event filter ID. appId, id", zzet.x(this.a), String.valueOf(this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null));
            return true;
        }
    }
}
