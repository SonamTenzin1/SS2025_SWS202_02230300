package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Code128Writer.java */
/* loaded from: classes2.dex */
public final class d extends n {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Code128Writer.java */
    /* loaded from: classes2.dex */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int f(CharSequence charSequence, int i2, int i3) {
        a g2;
        a g3;
        char charAt;
        a g4 = g(charSequence, i2);
        a aVar = a.ONE_DIGIT;
        if (g4 == aVar) {
            return 100;
        }
        a aVar2 = a.UNCODABLE;
        if (g4 == aVar2) {
            return (i2 >= charSequence.length() || ((charAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || charAt >= '`'))) ? 100 : 101;
        }
        if (i3 == 99) {
            return 99;
        }
        if (i3 == 100) {
            a aVar3 = a.FNC_1;
            if (g4 == aVar3 || (g2 = g(charSequence, i2 + 2)) == aVar2 || g2 == aVar) {
                return 100;
            }
            if (g2 == aVar3) {
                return g(charSequence, i2 + 3) == a.TWO_DIGITS ? 99 : 100;
            }
            int i4 = i2 + 4;
            while (true) {
                g3 = g(charSequence, i4);
                if (g3 != a.TWO_DIGITS) {
                    break;
                }
                i4 += 2;
            }
            return g3 == a.ONE_DIGIT ? 100 : 99;
        }
        if (g4 == a.FNC_1) {
            g4 = g(charSequence, i2 + 1);
        }
        return g4 == a.TWO_DIGITS ? 99 : 100;
    }

    private static a g(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return a.TWO_DIGITS;
        }
        return a.ONE_DIGIT;
    }

    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (charAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        }
                        break;
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (true) {
                int i8 = 103;
                if (i4 < length) {
                    int f2 = f(str, i4, i6);
                    int i9 = 100;
                    if (f2 == i6) {
                        switch (str.charAt(i4)) {
                            case 241:
                                i9 = 102;
                                break;
                            case 242:
                                i9 = 97;
                                break;
                            case 243:
                                i9 = 96;
                                break;
                            case 244:
                                if (i6 == 101) {
                                    i9 = 101;
                                    break;
                                }
                                break;
                            default:
                                if (i6 != 100) {
                                    if (i6 == 101) {
                                        i9 = str.charAt(i4) - ' ';
                                        if (i9 < 0) {
                                            i9 += 96;
                                            break;
                                        }
                                    } else {
                                        i9 = Integer.parseInt(str.substring(i4, i4 + 2));
                                        i4++;
                                        break;
                                    }
                                } else {
                                    i9 = str.charAt(i4) - ' ';
                                    break;
                                }
                                break;
                        }
                        i4++;
                    } else {
                        if (i6 != 0) {
                            i8 = f2;
                        } else if (f2 == 100) {
                            i8 = 104;
                        } else if (f2 != 101) {
                            i8 = 105;
                        }
                        i9 = i8;
                        i6 = f2;
                    }
                    arrayList.add(c.a[i9]);
                    i5 += i9 * i7;
                    if (i4 != 0) {
                        i7++;
                    }
                } else {
                    int[][] iArr = c.a;
                    arrayList.add(iArr[i5 % 103]);
                    arrayList.add(iArr[106]);
                    int i10 = 0;
                    for (int[] iArr2 : arrayList) {
                        for (int i11 : iArr2) {
                            i10 += i11;
                        }
                    }
                    boolean[] zArr = new boolean[i10];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        i2 += n.b(zArr, i2, (int[]) it.next(), true);
                    }
                    return zArr;
                }
            }
        } else {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
    }
}
