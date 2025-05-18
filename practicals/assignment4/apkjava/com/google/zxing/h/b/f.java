package com.google.zxing.h.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EdifactEncoder.java */
/* loaded from: classes2.dex */
public final class f implements g {
    private static void b(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            j.e(c2);
        }
    }

    private static String c(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            int charAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
            char c2 = (char) ((charAt >> 16) & 255);
            char c3 = (char) ((charAt >> 8) & 255);
            char c4 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c2);
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.p();
                int a = hVar.g().a() - hVar.a();
                int f2 = hVar.f();
                if (f2 > a) {
                    hVar.q(hVar.a() + 1);
                    a = hVar.g().a() - hVar.a();
                }
                if (f2 <= a && a <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i2 = length - 1;
                String c2 = c(charSequence, 0);
                if (!(!hVar.i()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    hVar.q(hVar.a() + i2);
                    if (hVar.g().a() - hVar.a() >= 3) {
                        hVar.q(hVar.a() + c2.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.k();
                    hVar.f20358f -= i2;
                } else {
                    hVar.s(c2);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.o(0);
        }
    }

    @Override // com.google.zxing.h.b.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            b(hVar.c(), sb);
            hVar.f20358f++;
            if (sb.length() >= 4) {
                hVar.s(c(sb, 0));
                sb.delete(0, 4);
                if (j.n(hVar.d(), hVar.f20358f, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    public int d() {
        return 4;
    }
}
