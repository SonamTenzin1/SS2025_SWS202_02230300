package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class d4 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzdu zzduVar) {
        g4 g4Var = new g4(zzduVar);
        StringBuilder sb = new StringBuilder(g4Var.a());
        for (int i2 = 0; i2 < g4Var.a(); i2++) {
            byte d2 = g4Var.d(i2);
            if (d2 == 34) {
                sb.append("\\\"");
            } else if (d2 == 39) {
                sb.append("\\'");
            } else if (d2 != 92) {
                switch (d2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (d2 >= 32 && d2 <= 126) {
                            sb.append((char) d2);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((d2 >>> 6) & 3) + 48));
                            sb.append((char) (((d2 >>> 3) & 7) + 48));
                            sb.append((char) ((d2 & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
