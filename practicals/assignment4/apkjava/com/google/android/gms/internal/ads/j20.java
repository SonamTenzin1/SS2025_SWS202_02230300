package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzpo;

/* loaded from: classes2.dex */
final class j20 {
    private static final int a = zzsy.i("nam");

    /* renamed from: b, reason: collision with root package name */
    private static final int f12799b = zzsy.i("trk");

    /* renamed from: c, reason: collision with root package name */
    private static final int f12800c = zzsy.i("cmt");

    /* renamed from: d, reason: collision with root package name */
    private static final int f12801d = zzsy.i("day");

    /* renamed from: e, reason: collision with root package name */
    private static final int f12802e = zzsy.i("ART");

    /* renamed from: f, reason: collision with root package name */
    private static final int f12803f = zzsy.i("too");

    /* renamed from: g, reason: collision with root package name */
    private static final int f12804g = zzsy.i("alb");

    /* renamed from: h, reason: collision with root package name */
    private static final int f12805h = zzsy.i("com");

    /* renamed from: i, reason: collision with root package name */
    private static final int f12806i = zzsy.i("wrt");

    /* renamed from: j, reason: collision with root package name */
    private static final int f12807j = zzsy.i("lyr");

    /* renamed from: k, reason: collision with root package name */
    private static final int f12808k = zzsy.i("gen");
    private static final int l = zzsy.i("covr");
    private static final int m = zzsy.i("gnre");
    private static final int n = zzsy.i("grp");
    private static final int o = zzsy.i("disk");
    private static final int p = zzsy.i("trkn");
    private static final int q = zzsy.i("tmpo");
    private static final int r = zzsy.i("cpil");
    private static final int s = zzsy.i("aART");
    private static final int t = zzsy.i("sonm");
    private static final int u = zzsy.i("soal");
    private static final int v = zzsy.i("soar");
    private static final int w = zzsy.i("soaa");
    private static final int x = zzsy.i("soco");
    private static final int y = zzsy.i("rtng");
    private static final int z = zzsy.i("pgap");
    private static final int A = zzsy.i("sosn");
    private static final int B = zzsy.i("tvsh");
    private static final int C = zzsy.i("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzpv a(int i2, String str, zzst zzstVar, boolean z2, boolean z3) {
        int e2 = e(zzstVar);
        if (z3) {
            e2 = Math.min(1, e2);
        }
        if (e2 >= 0) {
            if (z2) {
                return new zzpw(str, null, Integer.toString(e2));
            }
            return new zzps("und", str, Integer.toString(e2));
        }
        String valueOf = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzpw b(int i2, String str, zzst zzstVar) {
        int d2 = zzstVar.d();
        if (zzstVar.d() == y10.F0) {
            zzstVar.l(8);
            return new zzpw(str, null, zzstVar.p(d2 - 16));
        }
        String valueOf = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzpw c(int i2, String str, zzst zzstVar) {
        int d2 = zzstVar.d();
        if (zzstVar.d() == y10.F0 && d2 >= 22) {
            zzstVar.l(10);
            int h2 = zzstVar.h();
            if (h2 > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(h2);
                String sb2 = sb.toString();
                int h3 = zzstVar.h();
                if (h3 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(h3);
                    sb2 = sb3.toString();
                }
                return new zzpw(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[Catch: all -> 0x02bf, TryCatch #0 {all -> 0x02bf, blocks: (B:6:0x0023, B:8:0x0028, B:10:0x002e, B:12:0x0033, B:14:0x003a, B:18:0x0041, B:20:0x004a, B:22:0x004e, B:25:0x0058, B:27:0x005c, B:30:0x0066, B:32:0x006b, B:35:0x0075, B:37:0x0079, B:40:0x0083, B:42:0x0088, B:44:0x0094, B:48:0x00ad, B:51:0x00c4, B:56:0x00d5, B:57:0x00de, B:59:0x00e2, B:62:0x00ec, B:64:0x00f0, B:67:0x00fa, B:69:0x00fe, B:72:0x0108, B:74:0x010c, B:77:0x0116, B:79:0x011a, B:82:0x0124, B:84:0x0128, B:87:0x0132, B:89:0x0136, B:92:0x0140, B:94:0x0144, B:97:0x014e, B:99:0x0152, B:102:0x015c, B:104:0x0160, B:107:0x016a, B:110:0x0173, B:112:0x0179, B:128:0x018c, B:115:0x0193, B:125:0x0197, B:118:0x019e, B:121:0x01a4, B:131:0x01aa, B:133:0x01b2, B:137:0x01bd, B:140:0x028a, B:142:0x029a, B:143:0x02a4, B:146:0x029f, B:148:0x01d5, B:150:0x01d9, B:152:0x01e5, B:155:0x01f5, B:157:0x0205, B:158:0x020f, B:159:0x020a, B:160:0x0216, B:162:0x021a, B:165:0x0220, B:167:0x0224, B:170:0x022a, B:172:0x022e, B:175:0x0238, B:177:0x023c, B:180:0x0246, B:182:0x024a, B:185:0x0254, B:187:0x0258, B:190:0x0262, B:192:0x0266, B:195:0x0270, B:197:0x0274, B:200:0x027c, B:202:0x0280, B:205:0x02ab, B:208:0x02b5), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[Catch: all -> 0x02bf, TRY_LEAVE, TryCatch #0 {all -> 0x02bf, blocks: (B:6:0x0023, B:8:0x0028, B:10:0x002e, B:12:0x0033, B:14:0x003a, B:18:0x0041, B:20:0x004a, B:22:0x004e, B:25:0x0058, B:27:0x005c, B:30:0x0066, B:32:0x006b, B:35:0x0075, B:37:0x0079, B:40:0x0083, B:42:0x0088, B:44:0x0094, B:48:0x00ad, B:51:0x00c4, B:56:0x00d5, B:57:0x00de, B:59:0x00e2, B:62:0x00ec, B:64:0x00f0, B:67:0x00fa, B:69:0x00fe, B:72:0x0108, B:74:0x010c, B:77:0x0116, B:79:0x011a, B:82:0x0124, B:84:0x0128, B:87:0x0132, B:89:0x0136, B:92:0x0140, B:94:0x0144, B:97:0x014e, B:99:0x0152, B:102:0x015c, B:104:0x0160, B:107:0x016a, B:110:0x0173, B:112:0x0179, B:128:0x018c, B:115:0x0193, B:125:0x0197, B:118:0x019e, B:121:0x01a4, B:131:0x01aa, B:133:0x01b2, B:137:0x01bd, B:140:0x028a, B:142:0x029a, B:143:0x02a4, B:146:0x029f, B:148:0x01d5, B:150:0x01d9, B:152:0x01e5, B:155:0x01f5, B:157:0x0205, B:158:0x020f, B:159:0x020a, B:160:0x0216, B:162:0x021a, B:165:0x0220, B:167:0x0224, B:170:0x022a, B:172:0x022e, B:175:0x0238, B:177:0x023c, B:180:0x0246, B:182:0x024a, B:185:0x0254, B:187:0x0258, B:190:0x0262, B:192:0x0266, B:195:0x0270, B:197:0x0274, B:200:0x027c, B:202:0x0280, B:205:0x02ab, B:208:0x02b5), top: B:2:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzpo.zza d(zzst zzstVar) {
        String str;
        int b2 = zzstVar.b() + zzstVar.d();
        int d2 = zzstVar.d();
        int i2 = d2 >>> 24;
        zzpo.zza zzaVar = null;
        try {
            if (i2 != 169 && i2 != 65533) {
                if (d2 == m) {
                    int e2 = e(zzstVar);
                    if (e2 > 0) {
                        String[] strArr = D;
                        if (e2 <= strArr.length) {
                            str = strArr[e2 - 1];
                            if (str == null) {
                                zzaVar = new zzpw("TCON", null, str);
                            } else {
                                Log.w("MetadataUtil", "Failed to parse standard genre code");
                            }
                            return zzaVar;
                        }
                    }
                    str = null;
                    if (str == null) {
                    }
                    return zzaVar;
                }
                if (d2 == o) {
                    return c(d2, "TPOS", zzstVar);
                }
                if (d2 == p) {
                    return c(d2, "TRCK", zzstVar);
                }
                if (d2 == q) {
                    return a(d2, "TBPM", zzstVar, true, false);
                }
                if (d2 == r) {
                    return a(d2, "TCMP", zzstVar, true, true);
                }
                if (d2 == l) {
                    int d3 = zzstVar.d();
                    if (zzstVar.d() == y10.F0) {
                        int a2 = y10.a(zzstVar.d());
                        String str2 = a2 == 13 ? "image/jpeg" : a2 == 14 ? "image/png" : null;
                        if (str2 == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(a2);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            zzstVar.l(4);
                            int i3 = d3 - 16;
                            byte[] bArr = new byte[i3];
                            zzstVar.n(bArr, 0, i3);
                            zzaVar = new zzpq(str2, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    return zzaVar;
                }
                if (d2 == s) {
                    return b(d2, "TPE2", zzstVar);
                }
                if (d2 == t) {
                    return b(d2, "TSOT", zzstVar);
                }
                if (d2 == u) {
                    return b(d2, "TSO2", zzstVar);
                }
                if (d2 == v) {
                    return b(d2, "TSOA", zzstVar);
                }
                if (d2 == w) {
                    return b(d2, "TSOP", zzstVar);
                }
                if (d2 == x) {
                    return b(d2, "TSOC", zzstVar);
                }
                if (d2 == y) {
                    return a(d2, "ITUNESADVISORY", zzstVar, false, false);
                }
                if (d2 == z) {
                    return a(d2, "ITUNESGAPLESS", zzstVar, false, true);
                }
                if (d2 == A) {
                    return b(d2, "TVSHOWSORT", zzstVar);
                }
                if (d2 == B) {
                    return b(d2, "TVSHOW", zzstVar);
                }
                if (d2 == C) {
                    String str3 = null;
                    String str4 = null;
                    int i4 = -1;
                    int i5 = -1;
                    while (zzstVar.b() < b2) {
                        int b3 = zzstVar.b();
                        int d4 = zzstVar.d();
                        int d5 = zzstVar.d();
                        zzstVar.l(4);
                        if (d5 == y10.D0) {
                            str3 = zzstVar.p(d4 - 12);
                        } else if (d5 == y10.E0) {
                            str4 = zzstVar.p(d4 - 12);
                        } else {
                            if (d5 == y10.F0) {
                                i4 = b3;
                                i5 = d4;
                            }
                            zzstVar.l(d4 - 12);
                        }
                    }
                    if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i4 != -1) {
                        zzstVar.k(i4);
                        zzstVar.l(16);
                        zzaVar = new zzps("und", str4, zzstVar.p(i5 - 16));
                    }
                    return zzaVar;
                }
            } else {
                int i6 = 16777215 & d2;
                if (i6 == f12800c) {
                    int d6 = zzstVar.d();
                    if (zzstVar.d() == y10.F0) {
                        zzstVar.l(8);
                        String p2 = zzstVar.p(d6 - 16);
                        zzaVar = new zzps("und", p2, p2);
                    } else {
                        String valueOf = String.valueOf(y10.c(d2));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzaVar;
                }
                if (i6 != a && i6 != f12799b) {
                    if (i6 != f12805h && i6 != f12806i) {
                        if (i6 == f12801d) {
                            return b(d2, "TDRC", zzstVar);
                        }
                        if (i6 == f12802e) {
                            return b(d2, "TPE1", zzstVar);
                        }
                        if (i6 == f12803f) {
                            return b(d2, "TSSE", zzstVar);
                        }
                        if (i6 == f12804g) {
                            return b(d2, "TALB", zzstVar);
                        }
                        if (i6 == f12807j) {
                            return b(d2, "USLT", zzstVar);
                        }
                        if (i6 == f12808k) {
                            return b(d2, "TCON", zzstVar);
                        }
                        if (i6 == n) {
                            return b(d2, "TIT1", zzstVar);
                        }
                    }
                    return b(d2, "TCOM", zzstVar);
                }
                return b(d2, "TIT2", zzstVar);
            }
            String valueOf2 = String.valueOf(y10.c(d2));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzstVar.k(b2);
        }
    }

    private static int e(zzst zzstVar) {
        zzstVar.l(4);
        if (zzstVar.d() == y10.F0) {
            zzstVar.l(8);
            return zzstVar.g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
