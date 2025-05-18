package c.g.b.k.m;

import c.g.b.k.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun.java */
/* loaded from: classes.dex */
public class c extends p {

    /* renamed from: k, reason: collision with root package name */
    ArrayList<p> f3095k;
    private int l;

    public c(c.g.b.k.e eVar, int i2) {
        super(eVar);
        this.f3095k = new ArrayList<>();
        this.f3146f = i2;
        q();
    }

    private void q() {
        c.g.b.k.e eVar;
        c.g.b.k.e eVar2 = this.f3142b;
        c.g.b.k.e J = eVar2.J(this.f3146f);
        while (true) {
            c.g.b.k.e eVar3 = J;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                J = eVar2.J(this.f3146f);
            }
        }
        this.f3142b = eVar;
        this.f3095k.add(eVar.L(this.f3146f));
        c.g.b.k.e H = eVar.H(this.f3146f);
        while (H != null) {
            this.f3095k.add(H.L(this.f3146f));
            H = H.H(this.f3146f);
        }
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            p next = it.next();
            int i2 = this.f3146f;
            if (i2 == 0) {
                next.f3142b.f3069d = this;
            } else if (i2 == 1) {
                next.f3142b.f3070e = this;
            }
        }
        if ((this.f3146f == 0 && ((c.g.b.k.f) this.f3142b.I()).x1()) && this.f3095k.size() > 1) {
            ArrayList<p> arrayList = this.f3095k;
            this.f3142b = arrayList.get(arrayList.size() - 1).f3142b;
        }
        this.l = this.f3146f == 0 ? this.f3142b.x() : this.f3142b.N();
    }

    private c.g.b.k.e r() {
        for (int i2 = 0; i2 < this.f3095k.size(); i2++) {
            p pVar = this.f3095k.get(i2);
            if (pVar.f3142b.Q() != 8) {
                return pVar.f3142b;
            }
        }
        return null;
    }

    private c.g.b.k.e s() {
        for (int size = this.f3095k.size() - 1; size >= 0; size--) {
            p pVar = this.f3095k.get(size);
            if (pVar.f3142b.Q() != 8) {
                return pVar.f3142b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a6, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d1, code lost:
    
        r9.f3145e.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ce, code lost:
    
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cc, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x041a, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        float f3;
        int i13;
        int max;
        int i14;
        int i15;
        if (this.f3148h.f3112j && this.f3149i.f3112j) {
            c.g.b.k.e I = this.f3142b.I();
            boolean x1 = (I == null || !(I instanceof c.g.b.k.f)) ? false : ((c.g.b.k.f) I).x1();
            int i16 = this.f3149i.f3109g - this.f3148h.f3109g;
            int size = this.f3095k.size();
            int i17 = 0;
            while (true) {
                i2 = -1;
                i3 = 8;
                if (i17 >= size) {
                    i17 = -1;
                    break;
                } else if (this.f3095k.get(i17).f3142b.Q() != 8) {
                    break;
                } else {
                    i17++;
                }
            }
            int i18 = size - 1;
            int i19 = i18;
            while (true) {
                if (i19 < 0) {
                    break;
                }
                if (this.f3095k.get(i19).f3142b.Q() != 8) {
                    i2 = i19;
                    break;
                }
                i19--;
            }
            int i20 = 0;
            while (i20 < 2) {
                int i21 = 0;
                i5 = 0;
                i6 = 0;
                int i22 = 0;
                f2 = 0.0f;
                while (i21 < size) {
                    p pVar = this.f3095k.get(i21);
                    if (pVar.f3142b.Q() != i3) {
                        i22++;
                        if (i21 > 0 && i21 >= i17) {
                            i5 += pVar.f3148h.f3108f;
                        }
                        g gVar = pVar.f3145e;
                        int i23 = gVar.f3109g;
                        boolean z3 = pVar.f3144d != e.b.MATCH_CONSTRAINT;
                        if (z3) {
                            int i24 = this.f3146f;
                            if (i24 == 0 && !pVar.f3142b.f3071f.f3145e.f3112j) {
                                return;
                            }
                            if (i24 == 1 && !pVar.f3142b.f3072g.f3145e.f3112j) {
                                return;
                            } else {
                                i14 = i23;
                            }
                        } else {
                            i14 = i23;
                            if (pVar.a == 1 && i20 == 0) {
                                i15 = gVar.m;
                                i6++;
                            } else if (gVar.f3112j) {
                                i15 = i14;
                            }
                            z3 = true;
                            if (z3) {
                                i6++;
                                float f4 = pVar.f3142b.w0[this.f3146f];
                                if (f4 >= 0.0f) {
                                    f2 += f4;
                                }
                            } else {
                                i5 += i15;
                            }
                            if (i21 < i18 && i21 < i2) {
                                i5 += -pVar.f3149i.f3108f;
                            }
                        }
                        i15 = i14;
                        if (z3) {
                        }
                        if (i21 < i18) {
                            i5 += -pVar.f3149i.f3108f;
                        }
                    }
                    i21++;
                    i3 = 8;
                }
                if (i5 < i16 || i6 == 0) {
                    i4 = i22;
                    break;
                } else {
                    i20++;
                    i3 = 8;
                }
            }
            i4 = 0;
            i5 = 0;
            i6 = 0;
            f2 = 0.0f;
            int i25 = this.f3148h.f3109g;
            if (x1) {
                i25 = this.f3149i.f3109g;
            }
            if (i5 > i16) {
                i25 = x1 ? i25 + ((int) (((i5 - i16) / 2.0f) + 0.5f)) : i25 - ((int) (((i5 - i16) / 2.0f) + 0.5f));
            }
            if (i6 > 0) {
                float f5 = i16 - i5;
                int i26 = (int) ((f5 / i6) + 0.5f);
                int i27 = 0;
                int i28 = 0;
                while (i27 < size) {
                    p pVar2 = this.f3095k.get(i27);
                    int i29 = i26;
                    int i30 = i5;
                    if (pVar2.f3142b.Q() != 8 && pVar2.f3144d == e.b.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f3145e;
                        if (!gVar2.f3112j) {
                            if (f2 > 0.0f) {
                                i12 = i25;
                                i13 = (int) (((pVar2.f3142b.w0[this.f3146f] * f5) / f2) + 0.5f);
                            } else {
                                i12 = i25;
                                i13 = i29;
                            }
                            if (this.f3146f == 0) {
                                c.g.b.k.e eVar = pVar2.f3142b;
                                f3 = f5;
                                int i31 = eVar.u;
                                z2 = x1;
                                i11 = i4;
                                max = Math.max(eVar.t, pVar2.a == 1 ? Math.min(i13, gVar2.m) : i13);
                                if (i31 > 0) {
                                    max = Math.min(i31, max);
                                }
                            } else {
                                z2 = x1;
                                i11 = i4;
                                f3 = f5;
                                c.g.b.k.e eVar2 = pVar2.f3142b;
                                int i32 = eVar2.x;
                                max = Math.max(eVar2.w, pVar2.a == 1 ? Math.min(i13, gVar2.m) : i13);
                                if (i32 > 0) {
                                    max = Math.min(i32, max);
                                }
                            }
                        }
                    }
                    z2 = x1;
                    i11 = i4;
                    i12 = i25;
                    f3 = f5;
                    i27++;
                    i26 = i29;
                    i5 = i30;
                    i25 = i12;
                    f5 = f3;
                    x1 = z2;
                    i4 = i11;
                }
                z = x1;
                i7 = i4;
                i8 = i25;
                int i33 = i5;
                if (i28 > 0) {
                    i6 -= i28;
                    int i34 = 0;
                    for (int i35 = 0; i35 < size; i35++) {
                        p pVar3 = this.f3095k.get(i35);
                        if (pVar3.f3142b.Q() != 8) {
                            if (i35 > 0 && i35 >= i17) {
                                i34 += pVar3.f3148h.f3108f;
                            }
                            i34 += pVar3.f3145e.f3109g;
                            if (i35 < i18 && i35 < i2) {
                                i34 += -pVar3.f3149i.f3108f;
                            }
                        }
                    }
                    i5 = i34;
                } else {
                    i5 = i33;
                }
                i9 = 2;
                if (this.l == 2 && i28 == 0) {
                    this.l = 0;
                }
            } else {
                z = x1;
                i7 = i4;
                i8 = i25;
                i9 = 2;
            }
            if (i5 > i16) {
                this.l = i9;
            }
            if (i7 > 0 && i6 == 0 && i17 == i2) {
                this.l = i9;
            }
            int i36 = this.l;
            if (i36 == 1) {
                int i37 = i7;
                if (i37 > 1) {
                    i10 = (i16 - i5) / (i37 - 1);
                } else {
                    i10 = i37 == 1 ? (i16 - i5) / 2 : 0;
                }
                if (i6 > 0) {
                    i10 = 0;
                }
                int i38 = i8;
                for (int i39 = 0; i39 < size; i39++) {
                    p pVar4 = this.f3095k.get(z ? size - (i39 + 1) : i39);
                    if (pVar4.f3142b.Q() == 8) {
                        pVar4.f3148h.d(i38);
                        pVar4.f3149i.d(i38);
                    } else {
                        if (i39 > 0) {
                            i38 = z ? i38 - i10 : i38 + i10;
                        }
                        if (i39 > 0 && i39 >= i17) {
                            if (z) {
                                i38 -= pVar4.f3148h.f3108f;
                            } else {
                                i38 += pVar4.f3148h.f3108f;
                            }
                        }
                        if (z) {
                            pVar4.f3149i.d(i38);
                        } else {
                            pVar4.f3148h.d(i38);
                        }
                        g gVar3 = pVar4.f3145e;
                        int i40 = gVar3.f3109g;
                        if (pVar4.f3144d == e.b.MATCH_CONSTRAINT && pVar4.a == 1) {
                            i40 = gVar3.m;
                        }
                        i38 = z ? i38 - i40 : i38 + i40;
                        if (z) {
                            pVar4.f3148h.d(i38);
                        } else {
                            pVar4.f3149i.d(i38);
                        }
                        pVar4.f3147g = true;
                        if (i39 < i18 && i39 < i2) {
                            if (z) {
                                i38 -= -pVar4.f3149i.f3108f;
                            } else {
                                i38 += -pVar4.f3149i.f3108f;
                            }
                        }
                    }
                }
                return;
            }
            int i41 = i7;
            if (i36 == 0) {
                int i42 = (i16 - i5) / (i41 + 1);
                if (i6 > 0) {
                    i42 = 0;
                }
                int i43 = i8;
                for (int i44 = 0; i44 < size; i44++) {
                    p pVar5 = this.f3095k.get(z ? size - (i44 + 1) : i44);
                    if (pVar5.f3142b.Q() == 8) {
                        pVar5.f3148h.d(i43);
                        pVar5.f3149i.d(i43);
                    } else {
                        int i45 = z ? i43 - i42 : i43 + i42;
                        if (i44 > 0 && i44 >= i17) {
                            if (z) {
                                i45 -= pVar5.f3148h.f3108f;
                            } else {
                                i45 += pVar5.f3148h.f3108f;
                            }
                        }
                        if (z) {
                            pVar5.f3149i.d(i45);
                        } else {
                            pVar5.f3148h.d(i45);
                        }
                        g gVar4 = pVar5.f3145e;
                        int i46 = gVar4.f3109g;
                        if (pVar5.f3144d == e.b.MATCH_CONSTRAINT && pVar5.a == 1) {
                            i46 = Math.min(i46, gVar4.m);
                        }
                        i43 = z ? i45 - i46 : i45 + i46;
                        if (z) {
                            pVar5.f3148h.d(i43);
                        } else {
                            pVar5.f3149i.d(i43);
                        }
                        if (i44 < i18 && i44 < i2) {
                            if (z) {
                                i43 -= -pVar5.f3149i.f3108f;
                            } else {
                                i43 += -pVar5.f3149i.f3108f;
                            }
                        }
                    }
                }
                return;
            }
            if (i36 == 2) {
                float w = this.f3146f == 0 ? this.f3142b.w() : this.f3142b.M();
                if (z) {
                    w = 1.0f - w;
                }
                int i47 = (int) (((i16 - i5) * w) + 0.5f);
                if (i47 < 0 || i6 > 0) {
                    i47 = 0;
                }
                int i48 = z ? i8 - i47 : i8 + i47;
                for (int i49 = 0; i49 < size; i49++) {
                    p pVar6 = this.f3095k.get(z ? size - (i49 + 1) : i49);
                    if (pVar6.f3142b.Q() == 8) {
                        pVar6.f3148h.d(i48);
                        pVar6.f3149i.d(i48);
                    } else {
                        if (i49 > 0 && i49 >= i17) {
                            if (z) {
                                i48 -= pVar6.f3148h.f3108f;
                            } else {
                                i48 += pVar6.f3148h.f3108f;
                            }
                        }
                        if (z) {
                            pVar6.f3149i.d(i48);
                        } else {
                            pVar6.f3148h.d(i48);
                        }
                        g gVar5 = pVar6.f3145e;
                        int i50 = gVar5.f3109g;
                        if (pVar6.f3144d == e.b.MATCH_CONSTRAINT && pVar6.a == 1) {
                            i50 = gVar5.m;
                        }
                        i48 += i50;
                        if (z) {
                            pVar6.f3148h.d(i48);
                        } else {
                            pVar6.f3149i.d(i48);
                        }
                        if (i49 < i18 && i49 < i2) {
                            if (z) {
                                i48 -= -pVar6.f3149i.f3108f;
                            } else {
                                i48 += -pVar6.f3149i.f3108f;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void d() {
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f3095k.size();
        if (size < 1) {
            return;
        }
        c.g.b.k.e eVar = this.f3095k.get(0).f3142b;
        c.g.b.k.e eVar2 = this.f3095k.get(size - 1).f3142b;
        if (this.f3146f == 0) {
            c.g.b.k.d dVar = eVar.I;
            c.g.b.k.d dVar2 = eVar2.K;
            f i2 = i(dVar, 0);
            int e2 = dVar.e();
            c.g.b.k.e r = r();
            if (r != null) {
                e2 = r.I.e();
            }
            if (i2 != null) {
                b(this.f3148h, i2, e2);
            }
            f i3 = i(dVar2, 0);
            int e3 = dVar2.e();
            c.g.b.k.e s = s();
            if (s != null) {
                e3 = s.K.e();
            }
            if (i3 != null) {
                b(this.f3149i, i3, -e3);
            }
        } else {
            c.g.b.k.d dVar3 = eVar.J;
            c.g.b.k.d dVar4 = eVar2.L;
            f i4 = i(dVar3, 1);
            int e4 = dVar3.e();
            c.g.b.k.e r2 = r();
            if (r2 != null) {
                e4 = r2.J.e();
            }
            if (i4 != null) {
                b(this.f3148h, i4, e4);
            }
            f i5 = i(dVar4, 1);
            int e5 = dVar4.e();
            c.g.b.k.e s2 = s();
            if (s2 != null) {
                e5 = s2.L.e();
            }
            if (i5 != null) {
                b(this.f3149i, i5, -e5);
            }
        }
        this.f3148h.a = this;
        this.f3149i.a = this;
    }

    @Override // c.g.b.k.m.p
    public void e() {
        for (int i2 = 0; i2 < this.f3095k.size(); i2++) {
            this.f3095k.get(i2).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void f() {
        this.f3143c = null;
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // c.g.b.k.m.p
    public long j() {
        int size = this.f3095k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = j2 + r4.f3148h.f3108f + this.f3095k.get(i2).j() + r4.f3149i.f3108f;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public boolean m() {
        int size = this.f3095k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f3095k.get(i2).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f3146f == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            String str = sb2 + "<";
            sb2 = (str + it.next()) + "> ";
        }
        return sb2;
    }
}
