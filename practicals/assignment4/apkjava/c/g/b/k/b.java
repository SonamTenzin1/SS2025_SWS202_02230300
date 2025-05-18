package c.g.b.k;

import c.g.b.k.e;
import java.util.ArrayList;

/* compiled from: Chain.java */
/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r8 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x003c, code lost:
    
        if (r8 == 2) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0258 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0507 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x039b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d1  */
    /* JADX WARN: Type inference failed for: r2v56, types: [c.g.b.k.e] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [c.g.b.k.e] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(f fVar, c.g.b.d dVar, int i2, int i3, c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<e> arrayList;
        e eVar;
        d dVar2;
        d dVar3;
        d dVar4;
        int i4;
        e eVar2;
        int i5;
        d dVar5;
        c.g.b.i iVar;
        c.g.b.i iVar2;
        e eVar3;
        d dVar6;
        c.g.b.i iVar3;
        c.g.b.i iVar4;
        e eVar4;
        c.g.b.i iVar5;
        float f2;
        int size;
        int i6;
        ArrayList<e> arrayList2;
        boolean z4;
        boolean z5;
        boolean z6;
        e eVar5;
        e eVar6;
        int i7;
        e eVar7 = cVar.a;
        e eVar8 = cVar.f3044c;
        e eVar9 = cVar.f3043b;
        e eVar10 = cVar.f3045d;
        e eVar11 = cVar.f3046e;
        float f3 = cVar.f3052k;
        boolean z7 = fVar.T[i2] == e.b.WRAP_CONTENT;
        if (i2 == 0) {
            int i8 = eVar11.s0;
            z = i8 == 0;
            z2 = i8 == 1;
        } else {
            int i9 = eVar11.t0;
            z = i9 == 0;
            z2 = i9 == 1;
        }
        ?? r7 = eVar7;
        boolean z8 = false;
        while (true) {
            if (z8) {
                break;
            }
            d dVar7 = r7.Q[i3];
            int i10 = z3 ? 1 : 4;
            int e2 = dVar7.e();
            float f4 = f3;
            e.b bVar = r7.T[i2];
            boolean z9 = z8;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && r7.s[i2] == 0) {
                z4 = z2;
                z5 = true;
            } else {
                z4 = z2;
                z5 = false;
            }
            d dVar8 = dVar7.f3057f;
            if (dVar8 != null && r7 != eVar7) {
                e2 += dVar8.e();
            }
            int i11 = e2;
            if (!z3 || r7 == eVar7 || r7 == eVar9) {
                z6 = z;
            } else {
                z6 = z;
                i10 = 8;
            }
            d dVar9 = dVar7.f3057f;
            if (dVar9 != null) {
                if (r7 == eVar9) {
                    eVar5 = eVar11;
                    eVar6 = eVar7;
                    dVar.h(dVar7.f3060i, dVar9.f3060i, i11, 6);
                } else {
                    eVar5 = eVar11;
                    eVar6 = eVar7;
                    dVar.h(dVar7.f3060i, dVar9.f3060i, i11, 8);
                }
                dVar.e(dVar7.f3060i, dVar7.f3057f.f3060i, i11, (!z5 || z3) ? i10 : 5);
            } else {
                eVar5 = eVar11;
                eVar6 = eVar7;
            }
            if (z7) {
                if (r7.Q() == 8 || r7.T[i2] != bVar2) {
                    i7 = 0;
                } else {
                    d[] dVarArr = r7.Q;
                    i7 = 0;
                    dVar.h(dVarArr[i3 + 1].f3060i, dVarArr[i3].f3060i, 0, 5);
                }
                dVar.h(r7.Q[i3].f3060i, fVar.Q[i3].f3060i, i7, 8);
            }
            d dVar10 = r7.Q[i3 + 1].f3057f;
            if (dVar10 != null) {
                ?? r2 = dVar10.f3055d;
                d[] dVarArr2 = r2.Q;
                if (dVarArr2[i3].f3057f != null && dVarArr2[i3].f3057f.f3055d == r7) {
                    r21 = r2;
                }
            }
            if (r21 != null) {
                r7 = r21;
                z8 = z9;
            } else {
                z8 = true;
            }
            z = z6;
            f3 = f4;
            z2 = z4;
            eVar11 = eVar5;
            eVar7 = eVar6;
            r7 = r7;
        }
        e eVar12 = eVar11;
        float f5 = f3;
        e eVar13 = eVar7;
        boolean z10 = z;
        boolean z11 = z2;
        if (eVar10 != null) {
            int i12 = i3 + 1;
            if (eVar8.Q[i12].f3057f != null) {
                d dVar11 = eVar10.Q[i12];
                if ((eVar10.T[i2] == e.b.MATCH_CONSTRAINT && eVar10.s[i2] == 0) && !z3) {
                    d dVar12 = dVar11.f3057f;
                    if (dVar12.f3055d == fVar) {
                        dVar.e(dVar11.f3060i, dVar12.f3060i, -dVar11.e(), 5);
                        dVar.j(dVar11.f3060i, eVar8.Q[i12].f3057f.f3060i, -dVar11.e(), 6);
                        if (z7) {
                            int i13 = i3 + 1;
                            c.g.b.i iVar6 = fVar.Q[i13].f3060i;
                            d[] dVarArr3 = eVar8.Q;
                            dVar.h(iVar6, dVarArr3[i13].f3060i, dVarArr3[i13].e(), 8);
                        }
                        arrayList = cVar.f3049h;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f6 = (cVar.r || cVar.t) ? f5 : cVar.f3051j;
                            float f7 = 0.0f;
                            e eVar14 = null;
                            i6 = 0;
                            float f8 = 0.0f;
                            while (i6 < size) {
                                e eVar15 = arrayList.get(i6);
                                float f9 = eVar15.w0[i2];
                                if (f9 < f7) {
                                    if (cVar.t) {
                                        d[] dVarArr4 = eVar15.Q;
                                        dVar.e(dVarArr4[i3 + 1].f3060i, dVarArr4[i3].f3060i, 0, 4);
                                        arrayList2 = arrayList;
                                        i6++;
                                        arrayList = arrayList2;
                                        f7 = 0.0f;
                                    } else {
                                        f9 = 1.0f;
                                    }
                                }
                                if (f9 == f7) {
                                    d[] dVarArr5 = eVar15.Q;
                                    dVar.e(dVarArr5[i3 + 1].f3060i, dVarArr5[i3].f3060i, 0, 8);
                                    arrayList2 = arrayList;
                                    i6++;
                                    arrayList = arrayList2;
                                    f7 = 0.0f;
                                } else {
                                    if (eVar14 != null) {
                                        d[] dVarArr6 = eVar14.Q;
                                        c.g.b.i iVar7 = dVarArr6[i3].f3060i;
                                        int i14 = i3 + 1;
                                        c.g.b.i iVar8 = dVarArr6[i14].f3060i;
                                        d[] dVarArr7 = eVar15.Q;
                                        c.g.b.i iVar9 = dVarArr7[i3].f3060i;
                                        c.g.b.i iVar10 = dVarArr7[i14].f3060i;
                                        arrayList2 = arrayList;
                                        c.g.b.b r = dVar.r();
                                        r.l(f8, f6, f9, iVar7, iVar8, iVar9, iVar10);
                                        dVar.d(r);
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    eVar14 = eVar15;
                                    f8 = f9;
                                    i6++;
                                    arrayList = arrayList2;
                                    f7 = 0.0f;
                                }
                            }
                        }
                        if (eVar9 == null && (eVar9 == eVar10 || z3)) {
                            d dVar13 = eVar13.Q[i3];
                            int i15 = i3 + 1;
                            d dVar14 = eVar8.Q[i15];
                            d dVar15 = dVar13.f3057f;
                            c.g.b.i iVar11 = dVar15 != null ? dVar15.f3060i : null;
                            d dVar16 = dVar14.f3057f;
                            c.g.b.i iVar12 = dVar16 != null ? dVar16.f3060i : null;
                            d dVar17 = eVar9.Q[i3];
                            d dVar18 = eVar10.Q[i15];
                            if (iVar11 != null && iVar12 != null) {
                                if (i2 == 0) {
                                    f2 = eVar12.i0;
                                } else {
                                    f2 = eVar12.j0;
                                }
                                dVar.c(dVar17.f3060i, iVar11, dVar17.e(), f2, iVar12, dVar18.f3060i, dVar18.e(), 7);
                            }
                        } else if (z10 || eVar9 == null) {
                            int i16 = 8;
                            if (z11 && eVar9 != null) {
                                int i17 = cVar.f3051j;
                                boolean z12 = i17 <= 0 && cVar.f3050i == i17;
                                eVar = eVar9;
                                e eVar16 = eVar;
                                while (eVar != null) {
                                    e eVar17 = eVar.y0[i2];
                                    while (eVar17 != null && eVar17.Q() == i16) {
                                        eVar17 = eVar17.y0[i2];
                                    }
                                    if (eVar == eVar9 || eVar == eVar10 || eVar17 == null) {
                                        eVar2 = eVar16;
                                        i5 = 8;
                                    } else {
                                        e eVar18 = eVar17 == eVar10 ? null : eVar17;
                                        d dVar19 = eVar.Q[i3];
                                        c.g.b.i iVar13 = dVar19.f3060i;
                                        d dVar20 = dVar19.f3057f;
                                        if (dVar20 != null) {
                                            c.g.b.i iVar14 = dVar20.f3060i;
                                        }
                                        int i18 = i3 + 1;
                                        c.g.b.i iVar15 = eVar16.Q[i18].f3060i;
                                        int e3 = dVar19.e();
                                        int e4 = eVar.Q[i18].e();
                                        if (eVar18 != null) {
                                            dVar5 = eVar18.Q[i3];
                                            iVar = dVar5.f3060i;
                                            d dVar21 = dVar5.f3057f;
                                            iVar2 = dVar21 != null ? dVar21.f3060i : null;
                                        } else {
                                            dVar5 = eVar10.Q[i3];
                                            iVar = dVar5 != null ? dVar5.f3060i : null;
                                            iVar2 = eVar.Q[i18].f3060i;
                                        }
                                        if (dVar5 != null) {
                                            e4 += dVar5.e();
                                        }
                                        int i19 = e4;
                                        int e5 = eVar16.Q[i18].e() + e3;
                                        int i20 = z12 ? 8 : 4;
                                        if (iVar13 == null || iVar15 == null || iVar == null || iVar2 == null) {
                                            eVar3 = eVar18;
                                            eVar2 = eVar16;
                                            i5 = 8;
                                        } else {
                                            eVar3 = eVar18;
                                            eVar2 = eVar16;
                                            i5 = 8;
                                            dVar.c(iVar13, iVar15, e5, 0.5f, iVar, iVar2, i19, i20);
                                        }
                                        eVar17 = eVar3;
                                    }
                                    if (eVar.Q() == i5) {
                                        eVar = eVar2;
                                    }
                                    eVar16 = eVar;
                                    i16 = 8;
                                    eVar = eVar17;
                                }
                                d dVar22 = eVar9.Q[i3];
                                dVar2 = eVar13.Q[i3].f3057f;
                                int i21 = i3 + 1;
                                dVar3 = eVar10.Q[i21];
                                dVar4 = eVar8.Q[i21].f3057f;
                                if (dVar2 != null) {
                                    i4 = 5;
                                } else if (eVar9 != eVar10) {
                                    i4 = 5;
                                    dVar.e(dVar22.f3060i, dVar2.f3060i, dVar22.e(), 5);
                                } else {
                                    i4 = 5;
                                    if (dVar4 != null) {
                                        dVar.c(dVar22.f3060i, dVar2.f3060i, dVar22.e(), 0.5f, dVar3.f3060i, dVar4.f3060i, dVar3.e(), 5);
                                    }
                                }
                                if (dVar4 != null && eVar9 != eVar10) {
                                    dVar.e(dVar3.f3060i, dVar4.f3060i, -dVar3.e(), i4);
                                }
                            }
                        } else {
                            int i22 = cVar.f3051j;
                            boolean z13 = i22 > 0 && cVar.f3050i == i22;
                            e eVar19 = eVar9;
                            e eVar20 = eVar19;
                            while (eVar19 != null) {
                                e eVar21 = eVar19.y0[i2];
                                while (eVar21 != null && eVar21.Q() == 8) {
                                    eVar21 = eVar21.y0[i2];
                                }
                                if (eVar21 != null || eVar19 == eVar10) {
                                    d dVar23 = eVar19.Q[i3];
                                    c.g.b.i iVar16 = dVar23.f3060i;
                                    d dVar24 = dVar23.f3057f;
                                    c.g.b.i iVar17 = dVar24 != null ? dVar24.f3060i : null;
                                    if (eVar20 != eVar19) {
                                        iVar17 = eVar20.Q[i3 + 1].f3060i;
                                    } else if (eVar19 == eVar9 && eVar20 == eVar19) {
                                        d[] dVarArr8 = eVar13.Q;
                                        iVar17 = dVarArr8[i3].f3057f != null ? dVarArr8[i3].f3057f.f3060i : null;
                                    }
                                    int e6 = dVar23.e();
                                    int i23 = i3 + 1;
                                    int e7 = eVar19.Q[i23].e();
                                    if (eVar21 != null) {
                                        dVar6 = eVar21.Q[i3];
                                        c.g.b.i iVar18 = dVar6.f3060i;
                                        iVar4 = eVar19.Q[i23].f3060i;
                                        iVar3 = iVar18;
                                    } else {
                                        dVar6 = eVar8.Q[i23].f3057f;
                                        iVar3 = dVar6 != null ? dVar6.f3060i : null;
                                        iVar4 = eVar19.Q[i23].f3060i;
                                    }
                                    if (dVar6 != null) {
                                        e7 += dVar6.e();
                                    }
                                    if (eVar20 != null) {
                                        e6 += eVar20.Q[i23].e();
                                    }
                                    if (iVar16 != null && iVar17 != null && iVar3 != null && iVar4 != null) {
                                        if (eVar19 == eVar9) {
                                            e6 = eVar9.Q[i3].e();
                                        }
                                        int i24 = e6;
                                        eVar4 = eVar21;
                                        dVar.c(iVar16, iVar17, i24, 0.5f, iVar3, iVar4, eVar19 == eVar10 ? eVar10.Q[i23].e() : e7, z13 ? 8 : 5);
                                        if (eVar19.Q() == 8) {
                                            eVar20 = eVar19;
                                        }
                                        eVar19 = eVar4;
                                    }
                                }
                                eVar4 = eVar21;
                                if (eVar19.Q() == 8) {
                                }
                                eVar19 = eVar4;
                            }
                        }
                        if ((z10 && !z11) || eVar9 == null || eVar9 == eVar10) {
                            return;
                        }
                        d[] dVarArr9 = eVar9.Q;
                        d dVar25 = dVarArr9[i3];
                        int i25 = i3 + 1;
                        d dVar26 = eVar10.Q[i25];
                        d dVar27 = dVar25.f3057f;
                        iVar5 = dVar27 != null ? dVar27.f3060i : null;
                        d dVar28 = dVar26.f3057f;
                        c.g.b.i iVar19 = dVar28 != null ? dVar28.f3060i : null;
                        if (eVar8 != eVar10) {
                            d dVar29 = eVar8.Q[i25].f3057f;
                            iVar19 = dVar29 != null ? dVar29.f3060i : null;
                        }
                        if (eVar9 == eVar10) {
                            dVar25 = dVarArr9[i3];
                            dVar26 = dVarArr9[i25];
                        }
                        if (iVar5 == null || iVar19 == null) {
                            return;
                        }
                        dVar.c(dVar25.f3060i, iVar5, dVar25.e(), 0.5f, iVar19, dVar26.f3060i, eVar10.Q[i25].e(), 5);
                        return;
                    }
                }
                if (z3) {
                    d dVar30 = dVar11.f3057f;
                    if (dVar30.f3055d == fVar) {
                        dVar.e(dVar11.f3060i, dVar30.f3060i, -dVar11.e(), 4);
                    }
                }
                dVar.j(dVar11.f3060i, eVar8.Q[i12].f3057f.f3060i, -dVar11.e(), 6);
                if (z7) {
                }
                arrayList = cVar.f3049h;
                if (arrayList != null) {
                    if (cVar.r) {
                    }
                    float f72 = 0.0f;
                    e eVar142 = null;
                    i6 = 0;
                    float f82 = 0.0f;
                    while (i6 < size) {
                    }
                }
                if (eVar9 == null) {
                }
                if (z10) {
                }
                int i162 = 8;
                if (z11) {
                    int i172 = cVar.f3051j;
                    if (i172 <= 0) {
                    }
                    eVar = eVar9;
                    e eVar162 = eVar;
                    while (eVar != null) {
                    }
                    d dVar222 = eVar9.Q[i3];
                    dVar2 = eVar13.Q[i3].f3057f;
                    int i212 = i3 + 1;
                    dVar3 = eVar10.Q[i212];
                    dVar4 = eVar8.Q[i212].f3057f;
                    if (dVar2 != null) {
                    }
                    if (dVar4 != null) {
                        dVar.e(dVar3.f3060i, dVar4.f3060i, -dVar3.e(), i4);
                    }
                }
                if (z10) {
                }
                d[] dVarArr92 = eVar9.Q;
                d dVar252 = dVarArr92[i3];
                int i252 = i3 + 1;
                d dVar262 = eVar10.Q[i252];
                d dVar272 = dVar252.f3057f;
                if (dVar272 != null) {
                }
                d dVar282 = dVar262.f3057f;
                if (dVar282 != null) {
                }
                if (eVar8 != eVar10) {
                }
                if (eVar9 == eVar10) {
                }
                if (iVar5 == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        if (z7) {
        }
        arrayList = cVar.f3049h;
        if (arrayList != null) {
        }
        if (eVar9 == null) {
        }
        if (z10) {
        }
        int i1622 = 8;
        if (z11) {
        }
        if (z10) {
        }
        d[] dVarArr922 = eVar9.Q;
        d dVar2522 = dVarArr922[i3];
        int i2522 = i3 + 1;
        d dVar2622 = eVar10.Q[i2522];
        d dVar2722 = dVar2522.f3057f;
        if (dVar2722 != null) {
        }
        d dVar2822 = dVar2622.f3057f;
        if (dVar2822 != null) {
        }
        if (eVar8 != eVar10) {
        }
        if (eVar9 == eVar10) {
        }
        if (iVar5 == null) {
        }
    }

    public static void b(f fVar, c.g.b.d dVar, ArrayList<e> arrayList, int i2) {
        c[] cVarArr;
        int i3;
        int i4;
        if (i2 == 0) {
            i3 = fVar.O0;
            cVarArr = fVar.R0;
            i4 = 0;
        } else {
            int i5 = fVar.P0;
            cVarArr = fVar.Q0;
            i3 = i5;
            i4 = 2;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            c cVar = cVarArr[i6];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.a)) {
                a(fVar, dVar, i2, i4, cVar);
            }
        }
    }
}
