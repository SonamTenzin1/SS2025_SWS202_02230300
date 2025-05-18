package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* loaded from: classes2.dex */
final class p00 implements Handler.Callback, zzqk, zzqm, zzrq {
    private int C;
    private int D;
    private long E;
    private int F;
    private r00 G;
    private long H;
    private q00 I;
    private q00 J;
    private q00 K;
    private zzlr L;

    /* renamed from: f, reason: collision with root package name */
    private final zzlo[] f13133f;

    /* renamed from: g, reason: collision with root package name */
    private final zzlp[] f13134g;

    /* renamed from: h, reason: collision with root package name */
    private final zzrp f13135h;

    /* renamed from: i, reason: collision with root package name */
    private final zzll f13136i;

    /* renamed from: j, reason: collision with root package name */
    private final zzsw f13137j;

    /* renamed from: k, reason: collision with root package name */
    private final Handler f13138k;
    private final HandlerThread l;
    private final Handler m;
    private final zzkv n;
    private final zzlu o;
    private final zzlt p;
    private zzle q;
    private zzln r;
    private zzlo s;
    private zzso t;
    private zzql u;
    private zzlo[] v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    private int B = 0;
    private int A = 1;

    public p00(zzlo[] zzloVarArr, zzrp zzrpVar, zzll zzllVar, boolean z, int i2, Handler handler, zzle zzleVar, zzkv zzkvVar) {
        this.f13133f = zzloVarArr;
        this.f13135h = zzrpVar;
        this.f13136i = zzllVar;
        this.x = z;
        this.m = handler;
        this.q = zzleVar;
        this.n = zzkvVar;
        this.f13134g = new zzlp[zzloVarArr.length];
        for (int i3 = 0; i3 < zzloVarArr.length; i3++) {
            zzloVarArr[i3].D(i3);
            this.f13134g[i3] = zzloVarArr[i3].G();
        }
        this.f13137j = new zzsw();
        this.v = new zzlo[0];
        this.o = new zzlu();
        this.p = new zzlt();
        zzrpVar.c(this);
        this.r = zzln.a;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.l = handlerThread;
        handlerThread.start();
        this.f13138k = new Handler(handlerThread.getLooper(), this);
    }

    private final void A() throws zzku {
        this.f13137j.b();
        for (zzlo zzloVar : this.v) {
            l(zzloVar);
        }
    }

    private final void B() {
        J(true);
        this.f13136i.f();
        c(1);
    }

    private final Pair<Integer, Long> C(int i2, long j2) {
        return s(this.L, i2, -9223372036854775807L);
    }

    private final void D(long j2) throws zzku {
        q00 q00Var = this.K;
        long e2 = j2 + (q00Var == null ? 60000000L : q00Var.e());
        this.H = e2;
        this.f13137j.g(e2);
        for (zzlo zzloVar : this.v) {
            zzloVar.M(this.H);
        }
    }

    private final boolean E(long j2) {
        if (j2 == -9223372036854775807L || this.q.f16417c < j2) {
            return true;
        }
        q00 q00Var = this.K.l;
        return q00Var != null && q00Var.f13208j;
    }

    private final void F() throws zzku {
        q00 q00Var = this.K;
        if (q00Var == null) {
            return;
        }
        long e2 = q00Var.a.e();
        if (e2 != -9223372036854775807L) {
            D(e2);
        } else {
            zzlo zzloVar = this.s;
            if (zzloVar != null && !zzloVar.C()) {
                long d2 = this.t.d();
                this.H = d2;
                this.f13137j.g(d2);
            } else {
                this.H = this.f13137j.d();
            }
            e2 = this.H - this.K.e();
        }
        this.q.f16417c = e2;
        this.E = SystemClock.elapsedRealtime() * 1000;
        long r = this.v.length == 0 ? Long.MIN_VALUE : this.K.a.r();
        zzle zzleVar = this.q;
        if (r == Long.MIN_VALUE) {
            r = this.L.c(this.K.f13205g, this.p, false).f16437d;
        }
        zzleVar.f16418d = r;
    }

    private final void G() throws IOException {
        q00 q00Var = this.I;
        if (q00Var == null || q00Var.f13208j) {
            return;
        }
        q00 q00Var2 = this.J;
        if (q00Var2 == null || q00Var2.l == q00Var) {
            for (zzlo zzloVar : this.v) {
                if (!zzloVar.Q()) {
                    return;
                }
            }
            this.I.a.f();
        }
    }

    private final void H() {
        q00 q00Var = this.I;
        long a = !q00Var.f13208j ? 0L : q00Var.a.a();
        if (a == Long.MIN_VALUE) {
            I(false);
            return;
        }
        long e2 = this.H - this.I.e();
        boolean d2 = this.f13136i.d(a - e2);
        I(d2);
        if (d2) {
            this.I.a.b(e2);
        }
    }

    private final void I(boolean z) {
        if (this.z != z) {
            this.z = z;
            this.m.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void J(boolean z) {
        this.f13138k.removeMessages(2);
        this.y = false;
        this.f13137j.b();
        this.t = null;
        this.s = null;
        this.H = 60000000L;
        for (zzlo zzloVar : this.v) {
            try {
                l(zzloVar);
                zzloVar.L();
            } catch (zzku | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.v = new zzlo[0];
        q00 q00Var = this.K;
        if (q00Var == null) {
            q00Var = this.I;
        }
        k(q00Var);
        this.I = null;
        this.J = null;
        this.K = null;
        I(false);
        if (z) {
            zzql zzqlVar = this.u;
            if (zzqlVar != null) {
                zzqlVar.d();
                this.u = null;
            }
            this.L = null;
        }
    }

    private final void c(int i2) {
        if (this.A != i2) {
            this.A = i2;
            this.m.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    private final int h(int i2, zzlr zzlrVar, zzlr zzlrVar2) {
        int h2 = zzlrVar.h();
        int i3 = -1;
        for (int i4 = 0; i4 < h2 && i3 == -1; i4++) {
            i2 = zzlrVar.b(i2, this.p, this.o, this.B);
            i3 = zzlrVar2.f(zzlrVar.c(i2, this.p, true).f16435b);
        }
        return i3;
    }

    private final Pair<Integer, Long> i(r00 r00Var) {
        zzlr zzlrVar = r00Var.a;
        if (zzlrVar.a()) {
            zzlrVar = this.L;
        }
        try {
            Pair<Integer, Long> s = s(zzlrVar, r00Var.f13249b, r00Var.f13250c);
            zzlr zzlrVar2 = this.L;
            if (zzlrVar2 == zzlrVar) {
                return s;
            }
            int f2 = zzlrVar2.f(zzlrVar.c(((Integer) s.first).intValue(), this.p, true).f16435b);
            if (f2 != -1) {
                return Pair.create(Integer.valueOf(f2), (Long) s.second);
            }
            int h2 = h(((Integer) s.first).intValue(), zzlrVar, this.L);
            if (h2 == -1) {
                return null;
            }
            this.L.c(h2, this.p, false);
            return C(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzlk(this.L, r00Var.f13249b, r00Var.f13250c);
        }
    }

    private final Pair<Integer, Long> j(zzlr zzlrVar, int i2, long j2, long j3) {
        zzsk.g(i2, 0, zzlrVar.g());
        zzlrVar.e(i2, this.o, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = this.o.f16446h;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        long j4 = this.o.f16448j + j2;
        zzlrVar.c(0, this.p, false);
        return Pair.create(0, Long.valueOf(j4));
    }

    private static void k(q00 q00Var) {
        while (q00Var != null) {
            q00Var.a();
            q00Var = q00Var.l;
        }
    }

    private static void l(zzlo zzloVar) throws zzku {
        if (zzloVar.getState() == 2) {
            zzloVar.stop();
        }
    }

    private final void o(Object obj, int i2) {
        this.q = new zzle(0, 0L);
        v(obj, i2);
        this.q = new zzle(0, -9223372036854775807L);
        c(4);
        J(false);
    }

    private final void q(boolean[] zArr, int i2) throws zzku {
        this.v = new zzlo[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            zzlo[] zzloVarArr = this.f13133f;
            if (i3 >= zzloVarArr.length) {
                return;
            }
            zzlo zzloVar = zzloVarArr[i3];
            zzrm a = this.K.m.f16676b.a(i3);
            if (a != null) {
                int i5 = i4 + 1;
                this.v[i4] = zzloVar;
                if (zzloVar.getState() == 0) {
                    zzlq zzlqVar = this.K.m.f16678d[i3];
                    boolean z = this.x && this.A == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = a.length();
                    zzlh[] zzlhVarArr = new zzlh[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        zzlhVarArr[i6] = a.c(i6);
                    }
                    q00 q00Var = this.K;
                    zzloVar.F(zzlqVar, zzlhVarArr, q00Var.f13202d[i3], this.H, z2, q00Var.e());
                    zzso H = zzloVar.H();
                    if (H != null) {
                        if (this.t == null) {
                            this.t = H;
                            this.s = zzloVar;
                            H.c(this.r);
                        } else {
                            throw zzku.c(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzloVar.start();
                    }
                }
                i4 = i5;
            }
            i3++;
        }
    }

    private final boolean r(int i2) {
        this.L.c(i2, this.p, false);
        return !this.L.d(0, this.o, false).f16443e && this.L.b(i2, this.p, this.o, this.B) == -1;
    }

    private final Pair<Integer, Long> s(zzlr zzlrVar, int i2, long j2) {
        return j(zzlrVar, i2, j2, 0L);
    }

    private final void t(long j2, long j3) {
        this.f13138k.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f13138k.sendEmptyMessage(2);
        } else {
            this.f13138k.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final void u(q00 q00Var) throws zzku {
        if (this.K == q00Var) {
            return;
        }
        boolean[] zArr = new boolean[this.f13133f.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzlo[] zzloVarArr = this.f13133f;
            if (i2 < zzloVarArr.length) {
                zzlo zzloVar = zzloVarArr[i2];
                zArr[i2] = zzloVar.getState() != 0;
                zzrm a = q00Var.m.f16676b.a(i2);
                if (a != null) {
                    i3++;
                }
                if (zArr[i2] && (a == null || (zzloVar.K() && zzloVar.N() == this.K.f13202d[i2]))) {
                    if (zzloVar == this.s) {
                        this.f13137j.f(this.t);
                        this.t = null;
                        this.s = null;
                    }
                    l(zzloVar);
                    zzloVar.L();
                }
                i2++;
            } else {
                this.K = q00Var;
                this.m.obtainMessage(3, q00Var.m).sendToTarget();
                q(zArr, i3);
                return;
            }
        }
    }

    private final void v(Object obj, int i2) {
        this.m.obtainMessage(6, new zzlg(this.L, obj, this.q, i2)).sendToTarget();
    }

    private final long x(int i2, long j2) throws zzku {
        q00 q00Var;
        A();
        this.y = false;
        c(2);
        q00 q00Var2 = this.K;
        if (q00Var2 == null) {
            q00 q00Var3 = this.I;
            if (q00Var3 != null) {
                q00Var3.a();
            }
            q00Var = null;
        } else {
            q00Var = null;
            while (q00Var2 != null) {
                if (q00Var2.f13205g == i2 && q00Var2.f13208j) {
                    q00Var = q00Var2;
                } else {
                    q00Var2.a();
                }
                q00Var2 = q00Var2.l;
            }
        }
        q00 q00Var4 = this.K;
        if (q00Var4 != q00Var || q00Var4 != this.J) {
            for (zzlo zzloVar : this.v) {
                zzloVar.L();
            }
            this.v = new zzlo[0];
            this.t = null;
            this.s = null;
            this.K = null;
        }
        if (q00Var != null) {
            q00Var.l = null;
            this.I = q00Var;
            this.J = q00Var;
            u(q00Var);
            q00 q00Var5 = this.K;
            if (q00Var5.f13209k) {
                j2 = q00Var5.a.h(j2);
            }
            D(j2);
            H();
        } else {
            this.I = null;
            this.J = null;
            this.K = null;
            D(j2);
        }
        this.f13138k.sendEmptyMessage(2);
        return j2;
    }

    private final void z() throws zzku {
        this.y = false;
        this.f13137j.a();
        for (zzlo zzloVar : this.v) {
            zzloVar.start();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrq
    public final void a() {
        this.f13138k.sendEmptyMessage(10);
    }

    public final synchronized void b() {
        if (this.w) {
            return;
        }
        this.f13138k.sendEmptyMessage(6);
        while (!this.w) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.l.quit();
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void d(zzqj zzqjVar) {
        this.f13138k.obtainMessage(8, zzqjVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzqm
    public final void e(zzlr zzlrVar, Object obj) {
        this.f13138k.obtainMessage(7, Pair.create(zzlrVar, obj)).sendToTarget();
    }

    public final void f() {
        this.f13138k.sendEmptyMessage(5);
    }

    @Override // com.google.android.gms.internal.ads.zzqy
    public final /* synthetic */ void g(zzqj zzqjVar) {
        this.f13138k.obtainMessage(9, zzqjVar).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        k(r12);
        r2.l = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0267 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0263 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06b5 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0558 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0572 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, LOOP:9: B:414:0x0572->B:418:0x0582, LOOP_START, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x04ed A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0548 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:502:0x050f A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x04f4 A[Catch: IOException -> 0x082f, zzku -> 0x0834, RuntimeException -> 0x0839, TryCatch #8 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:9:0x0019, B:13:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:28:0x0051, B:32:0x0059, B:38:0x005e, B:39:0x0063, B:41:0x006d, B:43:0x0071, B:45:0x0075, B:46:0x0086, B:49:0x008c, B:55:0x0022, B:56:0x0090, B:66:0x00ae, B:75:0x00bc, B:78:0x00bf, B:82:0x00c9, B:87:0x00cd, B:88:0x00ce, B:92:0x00d5, B:94:0x00db, B:96:0x00e1, B:100:0x00e6, B:104:0x00eb, B:107:0x00f4, B:109:0x0116, B:110:0x011d, B:111:0x0124, B:113:0x0129, B:116:0x0134, B:118:0x013e, B:119:0x0140, B:121:0x0144, B:123:0x014a, B:126:0x0150, B:127:0x0157, B:128:0x015b, B:131:0x0162, B:133:0x0166, B:130:0x016b, B:139:0x016e, B:140:0x01a3, B:142:0x017d, B:144:0x0183, B:146:0x0189, B:148:0x0191, B:153:0x01af, B:155:0x01b7, B:158:0x01bc, B:160:0x01c0, B:162:0x01c8, B:165:0x01cd, B:167:0x01de, B:168:0x01ec, B:170:0x01f0, B:172:0x0200, B:174:0x0204, B:176:0x0212, B:178:0x0217, B:179:0x025e, B:183:0x0267, B:185:0x0271, B:187:0x027b, B:188:0x0280, B:189:0x02a8, B:191:0x02ac, B:195:0x02b7, B:199:0x02ba, B:200:0x02c7, B:203:0x02d5, B:205:0x02db, B:207:0x02ec, B:209:0x02f0, B:211:0x02fe, B:213:0x0310, B:217:0x031e, B:222:0x0323, B:223:0x0337, B:227:0x033e, B:228:0x0263, B:229:0x022f, B:231:0x0237, B:233:0x023d, B:234:0x0242, B:236:0x0342, B:237:0x034d, B:246:0x0358, B:247:0x0359, B:249:0x035d, B:251:0x0365, B:252:0x0370, B:254:0x036a, B:255:0x037c, B:257:0x0384, B:259:0x038d, B:261:0x0393, B:262:0x03b1, B:265:0x03ba, B:272:0x03db, B:275:0x03e9, B:282:0x03fd, B:285:0x040b, B:290:0x0414, B:293:0x0423, B:294:0x042a, B:297:0x042b, B:299:0x0433, B:300:0x0666, B:302:0x066c, B:304:0x0674, B:306:0x068f, B:308:0x069a, B:311:0x06a3, B:313:0x06a9, B:318:0x06b5, B:323:0x06bf, B:330:0x06c6, B:331:0x06c9, B:333:0x06cd, B:335:0x06d9, B:336:0x06ec, B:340:0x0705, B:342:0x070d, B:344:0x0713, B:345:0x0795, B:347:0x0799, B:349:0x079e, B:351:0x07a6, B:353:0x07aa, B:355:0x07b3, B:356:0x07c9, B:357:0x07af, B:359:0x07b9, B:361:0x07be, B:362:0x07c4, B:363:0x071d, B:365:0x0722, B:368:0x0729, B:370:0x0731, B:373:0x0740, B:379:0x0770, B:381:0x0778, B:382:0x0748, B:383:0x0754, B:384:0x0734, B:386:0x076a, B:389:0x077f, B:393:0x078b, B:394:0x0785, B:395:0x043b, B:397:0x043f, B:398:0x047a, B:400:0x0482, B:402:0x0554, B:404:0x0558, B:407:0x055f, B:409:0x0563, B:411:0x0567, B:412:0x056e, B:414:0x0572, B:416:0x0578, B:418:0x0582, B:420:0x05a9, B:423:0x05ae, B:425:0x05b3, B:427:0x05bd, B:429:0x05c3, B:431:0x05c9, B:433:0x05cc, B:439:0x05d0, B:441:0x05d5, B:444:0x05e5, B:449:0x05ed, B:453:0x05f0, B:455:0x05f6, B:457:0x05fa, B:461:0x0613, B:463:0x0618, B:466:0x0624, B:468:0x062a, B:470:0x063a, B:472:0x0640, B:474:0x0649, B:476:0x0652, B:480:0x0660, B:478:0x0663, B:486:0x056b, B:487:0x048a, B:489:0x048e, B:491:0x04e9, B:493:0x04ed, B:495:0x0508, B:498:0x0514, B:500:0x0548, B:501:0x054a, B:502:0x050f, B:503:0x04f4, B:504:0x0494, B:507:0x04a5, B:509:0x04d8, B:510:0x0444, B:512:0x044a, B:514:0x0450, B:517:0x045f, B:519:0x0463, B:521:0x046e, B:522:0x07cd, B:525:0x07d5, B:527:0x07db, B:529:0x07e2, B:531:0x07e7, B:533:0x07f2, B:535:0x07f8, B:538:0x0804, B:540:0x0813, B:541:0x081f), top: B:2:0x0005 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        int i2;
        IOException iOException;
        int i3;
        zzku zzkuVar;
        long j2;
        int i4;
        q00 q00Var;
        int b2;
        long j3;
        q00 q00Var2;
        q00 q00Var3;
        int i5;
        q00 q00Var4;
        int i6;
        boolean E;
        long r;
        boolean c2;
        boolean z;
        zzln c3;
        int i7;
        q00 q00Var5;
        q00 q00Var6;
        q00 q00Var7;
        try {
            try {
                j2 = 0;
                i4 = 0;
            } catch (RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Internal runtime error.", e2);
                this.m.obtainMessage(8, zzku.c(e2)).sendToTarget();
                B();
                return true;
            }
        } catch (zzku e3) {
            i3 = 8;
            zzkuVar = e3;
        } catch (IOException e4) {
            i2 = 8;
            iOException = e4;
        }
        try {
            switch (message.what) {
                case 0:
                    zzql zzqlVar = (zzql) message.obj;
                    boolean z2 = message.arg1 != 0;
                    this.m.sendEmptyMessage(0);
                    J(true);
                    this.f13136i.a();
                    if (z2) {
                        this.q = new zzle(0, -9223372036854775807L);
                    }
                    this.u = zzqlVar;
                    zzqlVar.a(this.n, true, this);
                    c(2);
                    this.f13138k.sendEmptyMessage(2);
                    return true;
                case 1:
                    boolean z3 = message.arg1 != 0;
                    this.y = false;
                    this.x = z3;
                    if (!z3) {
                        A();
                        F();
                    } else {
                        int i8 = this.A;
                        if (i8 == 3) {
                            z();
                            this.f13138k.sendEmptyMessage(2);
                        } else if (i8 == 2) {
                            this.f13138k.sendEmptyMessage(2);
                        }
                    }
                    return true;
                case 2:
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.L == null) {
                        this.u.f();
                        j3 = elapsedRealtime;
                    } else {
                        q00 q00Var8 = this.I;
                        if (q00Var8 == null) {
                            b2 = this.q.a;
                        } else {
                            int i9 = q00Var8.f13205g;
                            if (!q00Var8.f13207i && q00Var8.f() && this.L.c(i9, this.p, false).f16437d != -9223372036854775807L && ((q00Var = this.K) == null || this.I.f13201c - q00Var.f13201c != 100)) {
                                b2 = this.L.b(i9, this.p, this.o, this.B);
                            }
                            j3 = elapsedRealtime;
                            q00Var2 = this.I;
                            if (q00Var2 != null && !q00Var2.f()) {
                                if (this.I != null && !this.z) {
                                    H();
                                }
                                if (this.K != null) {
                                    while (true) {
                                        q00 q00Var9 = this.K;
                                        q00Var3 = this.J;
                                        if (q00Var9 != q00Var3 && this.H >= q00Var9.l.f13204f) {
                                            q00Var9.a();
                                            u(this.K.l);
                                            q00 q00Var10 = this.K;
                                            this.q = new zzle(q00Var10.f13205g, q00Var10.f13206h);
                                            F();
                                            this.m.obtainMessage(5, this.q).sendToTarget();
                                        }
                                    }
                                    if (q00Var3.f13207i) {
                                        int i10 = 0;
                                        while (true) {
                                            zzlo[] zzloVarArr = this.f13133f;
                                            if (i10 < zzloVarArr.length) {
                                                zzlo zzloVar = zzloVarArr[i10];
                                                zzqw zzqwVar = this.J.f13202d[i10];
                                                if (zzqwVar != null && zzloVar.N() == zzqwVar && zzloVar.Q()) {
                                                    zzloVar.J();
                                                }
                                                i10++;
                                            }
                                        }
                                    } else {
                                        while (true) {
                                            zzlo[] zzloVarArr2 = this.f13133f;
                                            if (i5 < zzloVarArr2.length) {
                                                zzlo zzloVar2 = zzloVarArr2[i5];
                                                zzqw zzqwVar2 = this.J.f13202d[i5];
                                                i5 = (zzloVar2.N() == zzqwVar2 && (zzqwVar2 == null || zzloVar2.Q())) ? i5 + 1 : 0;
                                            } else {
                                                q00 q00Var11 = this.J;
                                                q00 q00Var12 = q00Var11.l;
                                                if (q00Var12 != null && q00Var12.f13208j) {
                                                    zzrr zzrrVar = q00Var11.m;
                                                    this.J = q00Var12;
                                                    zzrr zzrrVar2 = q00Var12.m;
                                                    boolean z4 = q00Var12.a.e() != -9223372036854775807L;
                                                    int i11 = 0;
                                                    while (true) {
                                                        zzlo[] zzloVarArr3 = this.f13133f;
                                                        if (i11 < zzloVarArr3.length) {
                                                            zzlo zzloVar3 = zzloVarArr3[i11];
                                                            if (zzrrVar.f16676b.a(i11) != null) {
                                                                if (!z4) {
                                                                    if (!zzloVar3.K()) {
                                                                        zzrm a = zzrrVar2.f16676b.a(i11);
                                                                        zzlq zzlqVar = zzrrVar.f16678d[i11];
                                                                        zzlq zzlqVar2 = zzrrVar2.f16678d[i11];
                                                                        if (a != null && zzlqVar2.equals(zzlqVar)) {
                                                                            int length = a.length();
                                                                            zzlh[] zzlhVarArr = new zzlh[length];
                                                                            for (int i12 = 0; i12 < length; i12++) {
                                                                                zzlhVarArr[i12] = a.c(i12);
                                                                            }
                                                                            q00 q00Var13 = this.J;
                                                                            zzloVar3.P(zzlhVarArr, q00Var13.f13202d[i11], q00Var13.e());
                                                                        }
                                                                    }
                                                                }
                                                                zzloVar3.J();
                                                            }
                                                            i11++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            I(false);
                            if (this.K != null) {
                            }
                        }
                        if (b2 >= this.L.h()) {
                            this.u.f();
                            j3 = elapsedRealtime;
                            q00Var2 = this.I;
                            if (q00Var2 != null) {
                                if (this.I != null) {
                                    H();
                                }
                                if (this.K != null) {
                                }
                            }
                            I(false);
                            if (this.K != null) {
                            }
                        } else {
                            if (this.I == null) {
                                j2 = this.q.f16417c;
                            } else {
                                this.L.c(b2, this.p, false);
                                this.L.d(0, this.o, false);
                                if (b2 == 0) {
                                    j3 = elapsedRealtime;
                                    Pair<Integer, Long> j4 = j(this.L, 0, -9223372036854775807L, Math.max(0L, (this.I.e() + this.L.c(this.I.f13205g, this.p, false).f16437d) - this.H));
                                    if (j4 != null) {
                                        int intValue = ((Integer) j4.first).intValue();
                                        j2 = ((Long) j4.second).longValue();
                                        b2 = intValue;
                                        q00 q00Var14 = this.I;
                                        long e5 = q00Var14 != null ? 60000000 + j2 : q00Var14.e() + this.L.c(this.I.f13205g, this.p, false).f16437d;
                                        q00 q00Var15 = this.I;
                                        int i13 = q00Var15 != null ? 0 : q00Var15.f13201c + 1;
                                        boolean r2 = r(b2);
                                        this.L.c(b2, this.p, true);
                                        q00 q00Var16 = new q00(this.f13133f, this.f13134g, e5, this.f13135h, this.f13136i, this.u, this.p.f16435b, i13, b2, r2, j2);
                                        q00Var4 = this.I;
                                        if (q00Var4 != null) {
                                            q00Var4.l = q00Var16;
                                        }
                                        this.I = q00Var16;
                                        q00Var16.a.j(this, j2);
                                        I(true);
                                    }
                                    q00Var2 = this.I;
                                    if (q00Var2 != null) {
                                    }
                                    I(false);
                                    if (this.K != null) {
                                    }
                                }
                            }
                            j3 = elapsedRealtime;
                            q00 q00Var142 = this.I;
                            long e52 = q00Var142 != null ? 60000000 + j2 : q00Var142.e() + this.L.c(this.I.f13205g, this.p, false).f16437d;
                            q00 q00Var152 = this.I;
                            if (q00Var152 != null) {
                            }
                            boolean r22 = r(b2);
                            this.L.c(b2, this.p, true);
                            q00 q00Var162 = new q00(this.f13133f, this.f13134g, e52, this.f13135h, this.f13136i, this.u, this.p.f16435b, i13, b2, r22, j2);
                            q00Var4 = this.I;
                            if (q00Var4 != null) {
                            }
                            this.I = q00Var162;
                            q00Var162.a.j(this, j2);
                            I(true);
                            q00Var2 = this.I;
                            if (q00Var2 != null) {
                            }
                            I(false);
                            if (this.K != null) {
                            }
                        }
                    }
                    if (this.K == null) {
                        G();
                        t(j3, 10L);
                    } else {
                        zzsx.a("doSomeWork");
                        F();
                        this.K.a.k(this.q.f16417c);
                        boolean z5 = true;
                        boolean z6 = true;
                        for (zzlo zzloVar4 : this.v) {
                            zzloVar4.O(this.H, this.E);
                            z6 = z6 && zzloVar4.C();
                            if (!zzloVar4.B() && !zzloVar4.C()) {
                                z = false;
                                if (!z) {
                                    zzloVar4.I();
                                }
                                z5 = !z5 && z;
                            }
                            z = true;
                            if (!z) {
                            }
                            if (z5) {
                            }
                        }
                        if (!z5) {
                            G();
                        }
                        zzso zzsoVar = this.t;
                        if (zzsoVar != null) {
                            zzln e6 = zzsoVar.e();
                            if (!e6.equals(this.r)) {
                                this.r = e6;
                                this.f13137j.f(this.t);
                                this.m.obtainMessage(7, e6).sendToTarget();
                            }
                        }
                        long j5 = this.L.c(this.K.f13205g, this.p, false).f16437d;
                        if (z6 && ((j5 == -9223372036854775807L || j5 <= this.q.f16417c) && this.K.f13207i)) {
                            c(4);
                            A();
                            i6 = 2;
                        } else {
                            int i14 = this.A;
                            i6 = 2;
                            if (i14 == 2) {
                                if (this.v.length > 0) {
                                    if (z5) {
                                        boolean z7 = this.y;
                                        q00 q00Var17 = this.I;
                                        if (!q00Var17.f13208j) {
                                            r = q00Var17.f13206h;
                                        } else {
                                            r = q00Var17.a.r();
                                        }
                                        if (r == Long.MIN_VALUE) {
                                            q00 q00Var18 = this.I;
                                            if (q00Var18.f13207i) {
                                                c2 = true;
                                                if (c2) {
                                                    E = true;
                                                }
                                            } else {
                                                r = this.L.c(q00Var18.f13205g, this.p, false).f16437d;
                                            }
                                        }
                                        c2 = this.f13136i.c(r - (this.H - this.I.e()), z7);
                                        if (c2) {
                                        }
                                    }
                                    E = false;
                                } else {
                                    E = E(j5);
                                }
                                if (E) {
                                    c(3);
                                    if (this.x) {
                                        z();
                                    }
                                }
                            } else if (i14 == 3) {
                                if (this.v.length <= 0) {
                                    z5 = E(j5);
                                }
                                if (!z5) {
                                    this.y = this.x;
                                    c(2);
                                    A();
                                }
                            }
                        }
                        if (this.A == i6) {
                            zzlo[] zzloVarArr4 = this.v;
                            int length2 = zzloVarArr4.length;
                            while (i4 < length2) {
                                zzloVarArr4[i4].I();
                                i4++;
                            }
                        }
                        if ((this.x && this.A == 3) || this.A == i6) {
                            t(j3, 10L);
                        } else if (this.v.length != 0) {
                            t(j3, 1000L);
                        } else {
                            this.f13138k.removeMessages(i6);
                        }
                        zzsx.b();
                    }
                    return true;
                case 3:
                    r00 r00Var = (r00) message.obj;
                    if (this.L == null) {
                        this.F++;
                        this.G = r00Var;
                    } else {
                        Pair<Integer, Long> i15 = i(r00Var);
                        if (i15 == null) {
                            zzle zzleVar = new zzle(0, 0L);
                            this.q = zzleVar;
                            this.m.obtainMessage(4, 1, 0, zzleVar).sendToTarget();
                            this.q = new zzle(0, -9223372036854775807L);
                            c(4);
                            J(false);
                        } else {
                            boolean z8 = r00Var.f13250c == -9223372036854775807L;
                            int intValue2 = ((Integer) i15.first).intValue();
                            long longValue = ((Long) i15.second).longValue();
                            try {
                                zzle zzleVar2 = this.q;
                                if (intValue2 != zzleVar2.a || longValue / 1000 != zzleVar2.f16417c / 1000) {
                                    long x = x(intValue2, longValue);
                                    boolean z9 = z8 | (longValue != x);
                                    zzle zzleVar3 = new zzle(intValue2, x);
                                    this.q = zzleVar3;
                                    this.m.obtainMessage(4, z9 ? 1 : 0, 0, zzleVar3).sendToTarget();
                                }
                            } finally {
                                zzle zzleVar4 = new zzle(intValue2, longValue);
                                this.q = zzleVar4;
                                this.m.obtainMessage(4, z8 ? 1 : 0, 0, zzleVar4).sendToTarget();
                            }
                        }
                    }
                    return true;
                case 4:
                    zzln zzlnVar = (zzln) message.obj;
                    zzso zzsoVar2 = this.t;
                    if (zzsoVar2 != null) {
                        c3 = zzsoVar2.c(zzlnVar);
                    } else {
                        c3 = this.f13137j.c(zzlnVar);
                    }
                    this.r = c3;
                    this.m.obtainMessage(7, c3).sendToTarget();
                    return true;
                case 5:
                    B();
                    return true;
                case 6:
                    J(true);
                    this.f13136i.e();
                    c(1);
                    synchronized (this) {
                        this.w = true;
                        notifyAll();
                    }
                    return true;
                case 7:
                    Pair pair = (Pair) message.obj;
                    zzlr zzlrVar = this.L;
                    zzlr zzlrVar2 = (zzlr) pair.first;
                    this.L = zzlrVar2;
                    Object obj = pair.second;
                    if (zzlrVar == null) {
                        if (this.F > 0) {
                            Pair<Integer, Long> i16 = i(this.G);
                            i7 = this.F;
                            this.F = 0;
                            this.G = null;
                            if (i16 == null) {
                                o(obj, i7);
                            } else {
                                this.q = new zzle(((Integer) i16.first).intValue(), ((Long) i16.second).longValue());
                                q00Var5 = this.K;
                                if (q00Var5 != null) {
                                    q00Var5 = this.I;
                                }
                                if (q00Var5 != null) {
                                    int f2 = this.L.f(q00Var5.f13200b);
                                    if (f2 == -1) {
                                        int h2 = h(q00Var5.f13205g, zzlrVar, this.L);
                                        if (h2 == -1) {
                                            o(obj, i7);
                                        } else {
                                            this.L.c(h2, this.p, false);
                                            Pair<Integer, Long> C = C(0, -9223372036854775807L);
                                            int intValue3 = ((Integer) C.first).intValue();
                                            long longValue2 = ((Long) C.second).longValue();
                                            this.L.c(intValue3, this.p, true);
                                            Object obj2 = this.p.f16435b;
                                            q00Var5.f13205g = -1;
                                            while (true) {
                                                q00Var5 = q00Var5.l;
                                                if (q00Var5 != null) {
                                                    q00Var5.f13205g = q00Var5.f13200b.equals(obj2) ? intValue3 : -1;
                                                } else {
                                                    this.q = new zzle(intValue3, x(intValue3, longValue2));
                                                }
                                            }
                                        }
                                    } else {
                                        q00Var5.c(f2, r(f2));
                                        boolean z10 = q00Var5 == this.J;
                                        zzle zzleVar5 = this.q;
                                        if (f2 != zzleVar5.a) {
                                            zzle zzleVar6 = new zzle(f2, zzleVar5.f16416b);
                                            zzleVar6.f16417c = zzleVar5.f16417c;
                                            zzleVar6.f16418d = zzleVar5.f16418d;
                                            this.q = zzleVar6;
                                        }
                                        while (true) {
                                            q00Var6 = q00Var5.l;
                                            if (q00Var6 != null) {
                                                f2 = this.L.b(f2, this.p, this.o, this.B);
                                                if (f2 != -1 && q00Var6.f13200b.equals(this.L.c(f2, this.p, true).f16435b)) {
                                                    q00Var6.c(f2, r(f2));
                                                    z10 |= q00Var6 == this.J;
                                                    q00Var5 = q00Var6;
                                                }
                                            }
                                        }
                                        if (!z10) {
                                            int i17 = this.K.f13205g;
                                            this.q = new zzle(i17, x(i17, this.q.f16417c));
                                        } else {
                                            this.I = q00Var5;
                                            q00Var5.l = null;
                                            k(q00Var6);
                                        }
                                    }
                                }
                                v(obj, i7);
                            }
                        } else if (this.q.f16416b == -9223372036854775807L) {
                            if (zzlrVar2.a()) {
                                o(obj, 0);
                            } else {
                                Pair<Integer, Long> C2 = C(0, -9223372036854775807L);
                                this.q = new zzle(((Integer) C2.first).intValue(), ((Long) C2.second).longValue());
                            }
                        }
                        return true;
                    }
                    i7 = 0;
                    q00Var5 = this.K;
                    if (q00Var5 != null) {
                    }
                    if (q00Var5 != null) {
                    }
                    v(obj, i7);
                    return true;
                case 8:
                    zzqj zzqjVar = (zzqj) message.obj;
                    q00 q00Var19 = this.I;
                    if (q00Var19 != null && q00Var19.a == zzqjVar) {
                        q00Var19.f13208j = true;
                        q00Var19.g();
                        q00Var19.f13206h = q00Var19.d(q00Var19.f13206h, false);
                        if (this.K == null) {
                            q00 q00Var20 = this.I;
                            this.J = q00Var20;
                            D(q00Var20.f13206h);
                            u(this.J);
                        }
                        H();
                    }
                    return true;
                case 9:
                    zzqj zzqjVar2 = (zzqj) message.obj;
                    q00 q00Var21 = this.I;
                    if (q00Var21 != null && q00Var21.a == zzqjVar2) {
                        H();
                    }
                    return true;
                case 10:
                    q00 q00Var22 = this.K;
                    if (q00Var22 != null) {
                        boolean z11 = true;
                        while (true) {
                            if (q00Var22 != null && q00Var22.f13208j) {
                                if (!q00Var22.g()) {
                                    if (q00Var22 == this.J) {
                                        z11 = false;
                                    }
                                    q00Var22 = q00Var22.l;
                                } else {
                                    if (z11) {
                                        q00 q00Var23 = this.J;
                                        q00 q00Var24 = this.K;
                                        boolean z12 = q00Var23 != q00Var24;
                                        k(q00Var24.l);
                                        q00 q00Var25 = this.K;
                                        q00Var25.l = null;
                                        this.I = q00Var25;
                                        this.J = q00Var25;
                                        boolean[] zArr = new boolean[this.f13133f.length];
                                        long b3 = q00Var25.b(this.q.f16417c, z12, zArr);
                                        if (b3 != this.q.f16417c) {
                                            this.q.f16417c = b3;
                                            D(b3);
                                        }
                                        boolean[] zArr2 = new boolean[this.f13133f.length];
                                        int i18 = 0;
                                        int i19 = 0;
                                        while (true) {
                                            zzlo[] zzloVarArr5 = this.f13133f;
                                            if (i18 < zzloVarArr5.length) {
                                                zzlo zzloVar5 = zzloVarArr5[i18];
                                                zArr2[i18] = zzloVar5.getState() != 0;
                                                zzqw zzqwVar3 = this.K.f13202d[i18];
                                                if (zzqwVar3 != null) {
                                                    i19++;
                                                }
                                                if (zArr2[i18]) {
                                                    if (zzqwVar3 != zzloVar5.N()) {
                                                        if (zzloVar5 == this.s) {
                                                            if (zzqwVar3 == null) {
                                                                this.f13137j.f(this.t);
                                                            }
                                                            this.t = null;
                                                            this.s = null;
                                                        }
                                                        l(zzloVar5);
                                                        zzloVar5.L();
                                                    } else if (zArr[i18]) {
                                                        zzloVar5.M(this.H);
                                                    }
                                                }
                                                i18++;
                                            } else {
                                                this.m.obtainMessage(3, q00Var22.m).sendToTarget();
                                                q(zArr2, i19);
                                            }
                                        }
                                    } else {
                                        this.I = q00Var22;
                                        for (q00 q00Var26 = q00Var22.l; q00Var26 != null; q00Var26 = q00Var26.l) {
                                            q00Var26.a();
                                        }
                                        q00 q00Var27 = this.I;
                                        q00Var27.l = null;
                                        if (q00Var27.f13208j) {
                                            this.I.d(Math.max(q00Var27.f13206h, this.H - q00Var27.e()), false);
                                        }
                                    }
                                    H();
                                    F();
                                    this.f13138k.sendEmptyMessage(2);
                                }
                            }
                        }
                    }
                    return true;
                case 11:
                    zzky[] zzkyVarArr = (zzky[]) message.obj;
                    try {
                        int length3 = zzkyVarArr.length;
                        while (i4 < length3) {
                            zzky zzkyVar = zzkyVarArr[i4];
                            zzkyVar.a.f(zzkyVar.f16413b, zzkyVar.f16414c);
                            i4++;
                        }
                        if (this.u != null) {
                            this.f13138k.sendEmptyMessage(2);
                        }
                        synchronized (this) {
                            this.D++;
                            notifyAll();
                        }
                        return true;
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.D++;
                            notifyAll();
                            throw th;
                        }
                    }
                case 12:
                    int i20 = message.arg1;
                    this.B = i20;
                    q00 q00Var28 = this.K;
                    if (q00Var28 == null) {
                        q00Var28 = this.I;
                    }
                    if (q00Var28 != null) {
                        boolean z13 = q00Var28 == this.J;
                        boolean z14 = q00Var28 == this.I;
                        while (true) {
                            int b4 = this.L.b(q00Var28.f13205g, this.p, this.o, i20);
                            q00 q00Var29 = q00Var28.l;
                            if (q00Var29 != null && b4 != -1 && q00Var29.f13205g == b4) {
                                z13 |= q00Var29 == this.J;
                                z14 |= q00Var29 == this.I;
                                q00Var28 = q00Var29;
                            }
                        }
                        q00Var28.f13207i = r(q00Var28.f13205g);
                        if (!z14) {
                            this.I = q00Var28;
                        }
                        if (!z13 && (q00Var7 = this.K) != null) {
                            int i21 = q00Var7.f13205g;
                            this.q = new zzle(i21, x(i21, this.q.f16417c));
                        }
                        if (this.A == 4 && i20 != 0) {
                            c(2);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        } catch (zzku e7) {
            zzkuVar = e7;
            i3 = 8;
            Log.e("ExoPlayerImplInternal", "Renderer error.", zzkuVar);
            this.m.obtainMessage(i3, zzkuVar).sendToTarget();
            B();
            return true;
        } catch (IOException e8) {
            iOException = e8;
            i2 = 8;
            Log.e("ExoPlayerImplInternal", "Source error.", iOException);
            this.m.obtainMessage(i2, zzku.a(iOException)).sendToTarget();
            B();
            return true;
        }
    }

    public final void m(zzlr zzlrVar, int i2, long j2) {
        this.f13138k.obtainMessage(3, new r00(zzlrVar, i2, j2)).sendToTarget();
    }

    public final void n(zzql zzqlVar, boolean z) {
        this.f13138k.obtainMessage(0, 1, 0, zzqlVar).sendToTarget();
    }

    public final void p(zzky... zzkyVarArr) {
        if (this.w) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.C++;
            this.f13138k.obtainMessage(11, zzkyVarArr).sendToTarget();
        }
    }

    public final synchronized void w(zzky... zzkyVarArr) {
        if (this.w) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i2 = this.C;
        this.C = i2 + 1;
        this.f13138k.obtainMessage(11, zzkyVarArr).sendToTarget();
        while (this.D <= i2) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void y(boolean z) {
        this.f13138k.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }
}
