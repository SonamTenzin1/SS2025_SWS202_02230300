package com.facebook.o0.r0;

import kotlin.jvm.internal.m;

/* compiled from: Operator.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    public static final void a(f fVar, f fVar2) {
        m.f(fVar, "x");
        m.f(fVar2, "b");
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        int b4 = fVar.b(2);
        float[] a2 = fVar.a();
        float[] a3 = fVar2.a();
        if (b2 <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (b3 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (b4 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            int i8 = (i2 * b3 * b4) + (i4 * b4) + i6;
                            a2[i8] = a2[i8] + a3[i6];
                            if (i7 >= b4) {
                                break;
                            } else {
                                i6 = i7;
                            }
                        }
                    }
                    if (i5 >= b3) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
            }
            if (i3 >= b2) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final f b(f[] fVarArr) {
        int i2;
        m.f(fVarArr, "tensors");
        int b2 = fVarArr[0].b(0);
        int length = fVarArr.length - 1;
        if (length >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                int i4 = i3 + 1;
                i2 += fVarArr[i3].b(1);
                if (i4 > length) {
                    break;
                }
                i3 = i4;
            }
        } else {
            i2 = 0;
        }
        f fVar = new f(new int[]{b2, i2});
        float[] a2 = fVar.a();
        if (b2 > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                int i7 = i5 * i2;
                int length2 = fVarArr.length - 1;
                if (length2 >= 0) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8 + 1;
                        float[] a3 = fVarArr[i8].a();
                        int b3 = fVarArr[i8].b(1);
                        System.arraycopy(a3, i5 * b3, a2, i7, b3);
                        i7 += b3;
                        if (i9 > length2) {
                            break;
                        }
                        i8 = i9;
                    }
                }
                if (i6 >= b2) {
                    break;
                }
                i5 = i6;
            }
        }
        return fVar;
    }

    public static final f c(f fVar, f fVar2) {
        f fVar3;
        int i2;
        int i3;
        m.f(fVar, "x");
        m.f(fVar2, "w");
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        int b4 = fVar.b(2);
        int b5 = fVar2.b(0);
        int i4 = (b3 - b5) + 1;
        int b6 = fVar2.b(2);
        f fVar4 = new f(new int[]{b2, i4, b6});
        float[] a2 = fVar.a();
        float[] a3 = fVar4.a();
        float[] a4 = fVar2.a();
        if (b2 <= 0) {
            return fVar4;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (b6 > 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i4 > 0) {
                        int i9 = 0;
                        while (true) {
                            int i10 = i9 + 1;
                            float f2 = 0.0f;
                            if (b5 > 0) {
                                int i11 = 0;
                                while (true) {
                                    fVar3 = fVar4;
                                    int i12 = i11 + 1;
                                    if (b4 > 0) {
                                        int i13 = 0;
                                        while (true) {
                                            i3 = b2;
                                            int i14 = i13 + 1;
                                            f2 += a2[(b3 * b4 * i5) + ((i11 + i9) * b4) + i13] * a4[(((i11 * b4) + i13) * b6) + i7];
                                            if (i14 >= b4) {
                                                break;
                                            }
                                            i13 = i14;
                                            b2 = i3;
                                        }
                                    } else {
                                        i3 = b2;
                                    }
                                    if (i12 >= b5) {
                                        break;
                                    }
                                    i11 = i12;
                                    fVar4 = fVar3;
                                    b2 = i3;
                                }
                            } else {
                                i3 = b2;
                                fVar3 = fVar4;
                            }
                            a3[(i4 * b6 * i5) + (i9 * b6) + i7] = f2;
                            if (i10 >= i4) {
                                break;
                            }
                            i9 = i10;
                            fVar4 = fVar3;
                            b2 = i3;
                        }
                    } else {
                        i3 = b2;
                        fVar3 = fVar4;
                    }
                    if (i8 >= b6) {
                        break;
                    }
                    i7 = i8;
                    fVar4 = fVar3;
                    b2 = i3;
                }
                i2 = i3;
            } else {
                fVar3 = fVar4;
                i2 = b2;
            }
            if (i6 >= i2) {
                return fVar3;
            }
            b2 = i2;
            i5 = i6;
            fVar4 = fVar3;
        }
    }

    public static final f d(f fVar, f fVar2, f fVar3) {
        m.f(fVar, "x");
        m.f(fVar2, "w");
        m.f(fVar3, "b");
        int b2 = fVar.b(0);
        int b3 = fVar3.b(0);
        f h2 = h(fVar, fVar2);
        float[] a2 = fVar3.a();
        float[] a3 = h2.a();
        if (b2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (b3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int i6 = (i2 * b3) + i4;
                        a3[i6] = a3[i6] + a2[i4];
                        if (i5 >= b3) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= b2) {
                    break;
                }
                i2 = i3;
            }
        }
        return h2;
    }

    public static final f e(String[] strArr, int i2, f fVar) {
        m.f(strArr, "texts");
        m.f(fVar, "w");
        int length = strArr.length;
        int b2 = fVar.b(1);
        f fVar2 = new f(new int[]{length, i2, b2});
        float[] a2 = fVar2.a();
        float[] a3 = fVar.a();
        if (length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                int[] d2 = j.a.d(strArr[i3], i2);
                if (i2 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        System.arraycopy(a3, d2[i5] * b2, a2, (b2 * i2 * i3) + (i5 * b2), b2);
                        if (i6 >= i2) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                if (i4 >= length) {
                    break;
                }
                i3 = i4;
            }
        }
        return fVar2;
    }

    public static final void f(f fVar, int i2) {
        m.f(fVar, "x");
        if (i2 >= fVar.c()) {
            return;
        }
        int c2 = fVar.c();
        int i3 = 1;
        if (i2 < c2) {
            int i4 = i2;
            while (true) {
                int i5 = i4 + 1;
                i3 *= fVar.b(i4);
                if (i5 >= c2) {
                    break;
                } else {
                    i4 = i5;
                }
            }
        }
        int[] iArr = new int[i2 + 1];
        int i6 = 0;
        if (i2 > 0) {
            while (true) {
                int i7 = i6 + 1;
                iArr[i6] = fVar.b(i6);
                if (i7 >= i2) {
                    break;
                } else {
                    i6 = i7;
                }
            }
        }
        iArr[i2] = i3;
        fVar.d(iArr);
    }

    public static final f g(f fVar, int i2) {
        int i3;
        m.f(fVar, "x");
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        int b4 = fVar.b(2);
        int i4 = (b3 - i2) + 1;
        f fVar2 = new f(new int[]{b2, i4, b4});
        float[] a2 = fVar.a();
        float[] a3 = fVar2.a();
        if (b2 > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (b4 > 0) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7 + 1;
                        if (i4 > 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                int i11 = i9 * b4;
                                int i12 = (i5 * i4 * b4) + i11 + i7;
                                int i13 = (i5 * b3 * b4) + i11 + i7;
                                a3[i12] = Float.MIN_VALUE;
                                if (i2 > 0) {
                                    int i14 = 0;
                                    while (true) {
                                        int i15 = i14 + 1;
                                        i3 = b3;
                                        a3[i12] = Math.max(a3[i12], a2[i13 + (i14 * b4)]);
                                        if (i15 >= i2) {
                                            break;
                                        }
                                        i14 = i15;
                                        b3 = i3;
                                    }
                                } else {
                                    i3 = b3;
                                }
                                if (i10 >= i4) {
                                    break;
                                }
                                i9 = i10;
                                b3 = i3;
                            }
                        } else {
                            i3 = b3;
                        }
                        if (i8 >= b4) {
                            break;
                        }
                        i7 = i8;
                        b3 = i3;
                    }
                } else {
                    i3 = b3;
                }
                if (i6 >= b2) {
                    break;
                }
                i5 = i6;
                b3 = i3;
            }
        }
        return fVar2;
    }

    public static final f h(f fVar, f fVar2) {
        m.f(fVar, "x");
        m.f(fVar2, "w");
        int b2 = fVar.b(0);
        int b3 = fVar2.b(0);
        int b4 = fVar2.b(1);
        f fVar3 = new f(new int[]{b2, b4});
        float[] a2 = fVar.a();
        float[] a3 = fVar2.a();
        float[] a4 = fVar3.a();
        if (b2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (b4 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int i6 = (i2 * b4) + i4;
                        a4[i6] = 0.0f;
                        if (b3 > 0) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7 + 1;
                                a4[i6] = a4[i6] + (a2[(i2 * b3) + i7] * a3[(i7 * b4) + i4]);
                                if (i8 >= b3) {
                                    break;
                                }
                                i7 = i8;
                            }
                        }
                        if (i5 >= b4) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= b2) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar3;
    }

    public static final void i(f fVar) {
        m.f(fVar, "x");
        float[] a2 = fVar.a();
        int length = a2.length - 1;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (a2[i2] < 0.0f) {
                a2[i2] = 0.0f;
            }
            if (i3 > length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final void j(f fVar) {
        m.f(fVar, "x");
        int i2 = 0;
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        float[] a2 = fVar.a();
        if (b2 <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = i2 * b3;
            int i5 = i4 + b3;
            float f2 = Float.MIN_VALUE;
            float f3 = 0.0f;
            if (i4 < i5) {
                int i6 = i4;
                while (true) {
                    int i7 = i6 + 1;
                    if (a2[i6] > f2) {
                        f2 = a2[i6];
                    }
                    if (i7 >= i5) {
                        break;
                    } else {
                        i6 = i7;
                    }
                }
            }
            if (i4 < i5) {
                int i8 = i4;
                while (true) {
                    int i9 = i8 + 1;
                    a2[i8] = (float) Math.exp(a2[i8] - f2);
                    f3 += a2[i8];
                    if (i9 >= i5) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            if (i4 < i5) {
                while (true) {
                    int i10 = i4 + 1;
                    a2[i4] = a2[i4] / f3;
                    if (i10 >= i5) {
                        break;
                    } else {
                        i4 = i10;
                    }
                }
            }
            if (i3 >= b2) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final f k(f fVar) {
        m.f(fVar, "x");
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        f fVar2 = new f(new int[]{b3, b2});
        float[] a2 = fVar.a();
        float[] a3 = fVar2.a();
        if (b2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (b3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        a3[(i4 * b2) + i2] = a2[(i2 * b3) + i4];
                        if (i5 >= b3) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= b2) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar2;
    }

    public static final f l(f fVar) {
        m.f(fVar, "x");
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        int b4 = fVar.b(2);
        f fVar2 = new f(new int[]{b4, b3, b2});
        float[] a2 = fVar.a();
        float[] a3 = fVar2.a();
        if (b2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (b3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (b4 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                a3[(i6 * b2 * b3) + (i4 * b2) + i2] = a2[(i2 * b3 * b4) + (i4 * b4) + i6];
                                if (i7 >= b4) {
                                    break;
                                }
                                i6 = i7;
                            }
                        }
                        if (i5 >= b3) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= b2) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar2;
    }
}
