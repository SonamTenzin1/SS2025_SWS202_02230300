package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class v10 {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    private String N;
    public zznw O;
    public int P;
    public String a;

    /* renamed from: b */
    public int f13419b;

    /* renamed from: c */
    public int f13420c;

    /* renamed from: d */
    public int f13421d;

    /* renamed from: e */
    public boolean f13422e;

    /* renamed from: f */
    public byte[] f13423f;

    /* renamed from: g */
    public zznx f13424g;

    /* renamed from: h */
    public byte[] f13425h;

    /* renamed from: i */
    public zzne f13426i;

    /* renamed from: j */
    public int f13427j;

    /* renamed from: k */
    public int f13428k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private v10() {
        this.f13427j = -1;
        this.f13428k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = 8000;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.N = "eng";
    }

    public static /* synthetic */ String a(v10 v10Var, String str) {
        v10Var.N = str;
        return str;
    }

    private static List<byte[]> b(zzst zzstVar) throws zzlm {
        try {
            zzstVar.l(16);
            if (zzstVar.w() != 826496599) {
                return null;
            }
            byte[] bArr = zzstVar.a;
            for (int b2 = zzstVar.b() + 20; b2 < bArr.length - 4; b2++) {
                if (bArr[b2] == 0 && bArr[b2 + 1] == 0 && bArr[b2 + 2] == 1 && bArr[b2 + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, b2, bArr.length));
                }
            }
            throw new zzlm("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing FourCC VC1 codec private");
        }
    }

    private static boolean d(zzst zzstVar) throws zzlm {
        UUID uuid;
        UUID uuid2;
        try {
            int v = zzstVar.v();
            if (v == 1) {
                return true;
            }
            if (v == 65534) {
                zzstVar.k(24);
                long e2 = zzstVar.e();
                uuid = zzod.f16530d;
                if (e2 == uuid.getMostSignificantBits()) {
                    long e3 = zzstVar.e();
                    uuid2 = zzod.f16530d;
                    if (e3 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> e(byte[] bArr) throws zzlm {
        try {
            if (bArr[0] == 2) {
                int i2 = 1;
                int i3 = 0;
                while (bArr[i2] == -1) {
                    i3 += 255;
                    i2++;
                }
                int i4 = i2 + 1;
                int i5 = i3 + bArr[i2];
                int i6 = 0;
                while (bArr[i4] == -1) {
                    i6 += 255;
                    i4++;
                }
                int i7 = i4 + 1;
                int i8 = i6 + bArr[i4];
                if (bArr[i7] == 1) {
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, i7, bArr2, 0, i5);
                    int i9 = i7 + i5;
                    if (bArr[i9] == 3) {
                        int i10 = i9 + i8;
                        if (bArr[i10] == 5) {
                            byte[] bArr3 = new byte[bArr.length - i10];
                            System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzlm("Error parsing vorbis codec private");
                    }
                    throw new zzlm("Error parsing vorbis codec private");
                }
                throw new zzlm("Error parsing vorbis codec private");
            }
            throw new zzlm("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing vorbis codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0198. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(zznp zznpVar, int i2) throws zzlm {
        char c2;
        String str;
        List<byte[]> singletonList;
        int o;
        int i3;
        int i4;
        List<byte[]> list;
        zzlh h2;
        int i5;
        zztb zztbVar;
        byte[] bArr;
        int i6;
        String str2 = this.a;
        str2.hashCode();
        int i7 = 1;
        switch (str2.hashCode()) {
            case -2095576542:
                if (str2.equals("V_MPEG4/ISO/AP")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -2095575984:
                if (str2.equals("V_MPEG4/ISO/SP")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1985379776:
                if (str2.equals("A_MS/ACM")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1784763192:
                if (str2.equals("A_TRUEHD")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1730367663:
                if (str2.equals("A_VORBIS")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1482641358:
                if (str2.equals("A_MPEG/L2")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1482641357:
                if (str2.equals("A_MPEG/L3")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1373388978:
                if (str2.equals("V_MS/VFW/FOURCC")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -933872740:
                if (str2.equals("S_DVBSUB")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -538363189:
                if (str2.equals("V_MPEG4/ISO/ASP")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -538363109:
                if (str2.equals("V_MPEG4/ISO/AVC")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -425012669:
                if (str2.equals("S_VOBSUB")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -356037306:
                if (str2.equals("A_DTS/LOSSLESS")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 62923557:
                if (str2.equals("A_AAC")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 62923603:
                if (str2.equals("A_AC3")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 62927045:
                if (str2.equals("A_DTS")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 82338133:
                if (str2.equals("V_VP8")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 82338134:
                if (str2.equals("V_VP9")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 99146302:
                if (str2.equals("S_HDMV/PGS")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 444813526:
                if (str2.equals("V_THEORA")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 542569478:
                if (str2.equals("A_DTS/EXPRESS")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 725957860:
                if (str2.equals("A_PCM/INT/LIT")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 855502857:
                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 1422270023:
                if (str2.equals("S_TEXT/UTF8")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 1809237540:
                if (str2.equals("V_MPEG2")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 1950749482:
                if (str2.equals("A_EAC3")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case 1950789798:
                if (str2.equals("A_FLAC")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 1951062397:
                if (str2.equals("A_OPUS")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        String str3 = "audio/raw";
        switch (c2) {
            case 0:
            case 1:
            case '\t':
                str = "application/pgs";
                byte[] bArr2 = this.f13425h;
                singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str3 = "video/mp4v-es";
                i3 = -1;
                i4 = -1;
                int i8 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                    h2 = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, singletonList, this.f13426i, i8, this.N);
                } else if (zzsp.c(str3)) {
                    if (this.n == 0) {
                        int i9 = this.l;
                        i5 = -1;
                        if (i9 == -1) {
                            i9 = this.f13427j;
                        }
                        this.l = i9;
                        int i10 = this.m;
                        if (i10 == -1) {
                            i10 = this.f13428k;
                        }
                        this.m = i10;
                    } else {
                        i5 = -1;
                    }
                    float f2 = (this.l == i5 || (i6 = this.m) == i5) ? -1.0f : (this.f13428k * r2) / (this.f13427j * i6);
                    if (this.q) {
                        if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            wrap.put((byte) 0);
                            wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                            wrap.putShort((short) (this.E + 0.5f));
                            wrap.putShort((short) (this.F + 0.5f));
                            wrap.putShort((short) this.u);
                            wrap.putShort((short) this.v);
                        }
                        zztbVar = new zztb(this.r, this.t, this.s, bArr);
                    } else {
                        zztbVar = null;
                    }
                    h2 = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, singletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                    i7 = 2;
                } else {
                    if ("application/x-subrip".equals(str3)) {
                        h2 = zzlh.f(Integer.toString(i2), str3, null, -1, i8, this.N, this.f13426i);
                    } else {
                        if (!"application/vobsub".equals(str3) && !str.equals(str3) && !"application/dvbsubs".equals(str3)) {
                            throw new zzlm("Unexpected MIME type.");
                        }
                        h2 = zzlh.h(Integer.toString(i2), str3, null, -1, singletonList, this.N, this.f13426i);
                    }
                    i7 = 3;
                }
                zznw y = zznpVar.y(this.f13419b, i7);
                this.O = y;
                y.a(h2);
                return;
            case 2:
                str = "application/pgs";
                if (d(new zzst(this.f13425h))) {
                    o = zzsy.o(this.H);
                    if (o == 0) {
                        int i11 = this.H;
                        StringBuilder sb = new StringBuilder("audio/x-unknown".length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i11);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                    }
                    i3 = o;
                    singletonList = null;
                    i4 = -1;
                    int i82 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (zzsp.b(str3)) {
                    }
                    zznw y2 = zznpVar.y(this.f13419b, i7);
                    this.O = y2;
                    y2.a(h2);
                    return;
                }
                Log.w("MatroskaExtractor", "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                str3 = "audio/x-unknown";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i822 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22 = zznpVar.y(this.f13419b, i7);
                this.O = y22;
                y22.a(h2);
                return;
            case 3:
                str = "application/pgs";
                str3 = "audio/true-hd";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i8222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222 = zznpVar.y(this.f13419b, i7);
                this.O = y222;
                y222.a(h2);
                return;
            case 4:
                str = "application/pgs";
                singletonList = e(this.f13425h);
                str3 = "audio/vorbis";
                i3 = -1;
                i4 = 8192;
                int i82222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222;
                y2222.a(h2);
                return;
            case 5:
                str = "application/pgs";
                str3 = "audio/mpeg-L2";
                singletonList = null;
                i3 = -1;
                i4 = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                int i822222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222;
                y22222.a(h2);
                return;
            case 6:
                str = "application/pgs";
                str3 = "audio/mpeg";
                singletonList = null;
                i3 = -1;
                i4 = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                int i8222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222;
                y222222.a(h2);
                return;
            case 7:
                str = "application/pgs";
                singletonList = b(new zzst(this.f13425h));
                if (singletonList != null) {
                    str3 = "video/wvc1";
                } else {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str3 = "video/x-unknown";
                }
                i3 = -1;
                i4 = -1;
                int i82222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222;
                y2222222.a(h2);
                return;
            case '\b':
                str = "application/pgs";
                byte[] bArr3 = this.f13425h;
                singletonList = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str3 = "application/dvbsubs";
                i3 = -1;
                i4 = -1;
                int i822222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222;
                y22222222.a(h2);
                return;
            case '\n':
                str = "application/pgs";
                zzta a = zzta.a(new zzst(this.f13425h));
                list = a.a;
                this.P = a.f16748b;
                str3 = "video/avc";
                singletonList = list;
                i3 = -1;
                i4 = -1;
                int i8222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222;
                y222222222.a(h2);
                return;
            case 11:
                str = "application/pgs";
                singletonList = Collections.singletonList(this.f13425h);
                str3 = "application/vobsub";
                i3 = -1;
                i4 = -1;
                int i82222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222222;
                y2222222222.a(h2);
                return;
            case '\f':
                str = "application/pgs";
                str3 = "audio/vnd.dts.hd";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i822222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222;
                y22222222222.a(h2);
                return;
            case '\r':
                str = "application/pgs";
                singletonList = Collections.singletonList(this.f13425h);
                str3 = "audio/mp4a-latm";
                i3 = -1;
                i4 = -1;
                int i8222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222222;
                y222222222222.a(h2);
                return;
            case 14:
                str = "application/pgs";
                str3 = "audio/ac3";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i82222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222222222;
                y2222222222222.a(h2);
                return;
            case 15:
            case 20:
                str = "application/pgs";
                str3 = "audio/vnd.dts";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i822222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222222;
                y22222222222222.a(h2);
                return;
            case 16:
                str = "application/pgs";
                str3 = "video/x-vnd.on2.vp8";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i8222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222222222;
                y222222222222222.a(h2);
                return;
            case 17:
                str = "application/pgs";
                str3 = "video/x-vnd.on2.vp9";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i82222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222222222222;
                y2222222222222222.a(h2);
                return;
            case 18:
                str = "application/pgs";
                singletonList = null;
                str3 = str;
                i3 = -1;
                i4 = -1;
                int i822222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222222222;
                y22222222222222222.a(h2);
                return;
            case 19:
                str = "application/pgs";
                str3 = "video/x-unknown";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i8222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222222222222;
                y222222222222222222.a(h2);
                return;
            case 21:
                str = "application/pgs";
                o = zzsy.o(this.H);
                if (o == 0) {
                    int i12 = this.H;
                    StringBuilder sb2 = new StringBuilder("audio/x-unknown".length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i12);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str3 = "audio/x-unknown";
                    singletonList = null;
                    i3 = -1;
                    i4 = -1;
                    int i82222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (zzsp.b(str3)) {
                    }
                    zznw y2222222222222222222 = zznpVar.y(this.f13419b, i7);
                    this.O = y2222222222222222222;
                    y2222222222222222222.a(h2);
                    return;
                }
                i3 = o;
                singletonList = null;
                i4 = -1;
                int i822222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222222222222;
                y22222222222222222222.a(h2);
                return;
            case 22:
                str = "application/pgs";
                zztg a2 = zztg.a(new zzst(this.f13425h));
                list = a2.a;
                this.P = a2.f16762b;
                str3 = "video/hevc";
                singletonList = list;
                i3 = -1;
                i4 = -1;
                int i8222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222222222222222;
                y222222222222222222222.a(h2);
                return;
            case 23:
                str = "application/pgs";
                str3 = "application/x-subrip";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i82222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222222222222222222;
                y2222222222222222222222.a(h2);
                return;
            case 24:
                str = "application/pgs";
                str3 = "video/mpeg2";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i822222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222222222222222;
                y22222222222222222222222.a(h2);
                return;
            case 25:
                str = "application/pgs";
                str3 = "audio/eac3";
                singletonList = null;
                i3 = -1;
                i4 = -1;
                int i8222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y222222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y222222222222222222222222;
                y222222222222222222222222.a(h2);
                return;
            case 26:
                str = "application/pgs";
                singletonList = Collections.singletonList(this.f13425h);
                str3 = "audio/x-flac";
                i3 = -1;
                i4 = -1;
                int i82222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y2222222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y2222222222222222222222222;
                y2222222222222222222222222.a(h2);
                return;
            case 27:
                singletonList = new ArrayList<>(3);
                singletonList.add(this.f13425h);
                str = "application/pgs";
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                str3 = "audio/opus";
                i3 = -1;
                i4 = 5760;
                int i822222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (zzsp.b(str3)) {
                }
                zznw y22222222222222222222222222 = zznpVar.y(this.f13419b, i7);
                this.O = y22222222222222222222222222;
                y22222222222222222222222222.a(h2);
                return;
            default:
                throw new zzlm("Unrecognized codec identifier.");
        }
    }

    public /* synthetic */ v10(t10 t10Var) {
        this();
    }
}
