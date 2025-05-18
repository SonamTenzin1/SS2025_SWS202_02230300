package com.google.zxing.k.b;

/* compiled from: Mode.java */
/* loaded from: classes2.dex */
public enum b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int[] q;
    private final int r;

    b(int[] iArr, int i2) {
        this.q = iArr;
        this.r = i2;
    }

    public int g() {
        return this.r;
    }

    public int k(c cVar) {
        int f2 = cVar.f();
        return this.q[f2 <= 9 ? (char) 0 : f2 <= 26 ? (char) 1 : (char) 2];
    }
}
