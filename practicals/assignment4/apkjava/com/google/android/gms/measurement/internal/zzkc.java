package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.notification.PullingContentService;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzmd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public class zzkc implements s4 {
    private static volatile zzkc a;

    /* renamed from: b, reason: collision with root package name */
    private zzfr f18209b;

    /* renamed from: c, reason: collision with root package name */
    private zzex f18210c;

    /* renamed from: d, reason: collision with root package name */
    private c f18211d;

    /* renamed from: e, reason: collision with root package name */
    private p3 f18212e;

    /* renamed from: f, reason: collision with root package name */
    private zzjy f18213f;

    /* renamed from: g, reason: collision with root package name */
    private q7 f18214g;

    /* renamed from: h, reason: collision with root package name */
    private final zzkg f18215h;

    /* renamed from: i, reason: collision with root package name */
    private s5 f18216i;

    /* renamed from: j, reason: collision with root package name */
    private final zzfx f18217j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f18218k;
    private boolean l;
    private boolean m;

    @VisibleForTesting
    private long n;
    private List<Runnable> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private FileLock u;
    private FileChannel v;
    private List<Long> w;
    private List<Long> x;
    private long y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    /* loaded from: classes2.dex */
    public class a implements e {
        zzbr.zzg a;

        /* renamed from: b, reason: collision with root package name */
        List<Long> f18219b;

        /* renamed from: c, reason: collision with root package name */
        List<zzbr.zzc> f18220c;

        /* renamed from: d, reason: collision with root package name */
        private long f18221d;

        private a() {
        }

        private static long c(zzbr.zzc zzcVar) {
            return ((zzcVar.W() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.measurement.internal.e
        public final void a(zzbr.zzg zzgVar) {
            Preconditions.k(zzgVar);
            this.a = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.e
        public final boolean b(long j2, zzbr.zzc zzcVar) {
            Preconditions.k(zzcVar);
            if (this.f18220c == null) {
                this.f18220c = new ArrayList();
            }
            if (this.f18219b == null) {
                this.f18219b = new ArrayList();
            }
            if (this.f18220c.size() > 0 && c(this.f18220c.get(0)) != c(zzcVar)) {
                return false;
            }
            long i2 = this.f18221d + zzcVar.i();
            if (i2 >= Math.max(0, zzap.p.a(null).intValue())) {
                return false;
            }
            this.f18221d = i2;
            this.f18220c.add(zzcVar);
            this.f18219b.add(Long.valueOf(j2));
            return this.f18220c.size() < Math.max(1, zzap.q.a(null).intValue());
        }

        /* synthetic */ a(zzkc zzkcVar, i7 i7Var) {
            this();
        }
    }

    private zzkc(zzkh zzkhVar) {
        this(zzkhVar, null);
    }

    @VisibleForTesting
    private final boolean C(int i2, FileChannel fileChannel) {
        j0();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.flip();
            try {
                fileChannel.truncate(0L);
                fileChannel.write(allocate);
                fileChannel.force(true);
                if (fileChannel.size() != 4) {
                    this.f18217j.h().H().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                }
                return true;
            } catch (IOException e2) {
                this.f18217j.h().H().b("Failed to write to channel", e2);
                return false;
            }
        }
        this.f18217j.h().H().a("Bad channel to read from");
        return false;
    }

    private final boolean D(zzbr.zzc.zza zzaVar, zzbr.zzc.zza zzaVar2) {
        Preconditions.a("_e".equals(zzaVar.K()));
        Z();
        zzbr.zze z = zzkg.z((zzbr.zzc) ((zzfd) zzaVar.y()), "_sc");
        String N = z == null ? null : z.N();
        Z();
        zzbr.zze z2 = zzkg.z((zzbr.zzc) ((zzfd) zzaVar2.y()), "_pc");
        String N2 = z2 != null ? z2.N() : null;
        if (N2 == null || !N2.equals(N)) {
            return false;
        }
        L(zzaVar, zzaVar2);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(8:10|(2:567|568)(1:12)|13|(1:15)|16|17|18|(5:20|21|(2:26|(31:28|(3:29|30|(4:32|33|(6:35|(4:40|(1:44)|45|46)|48|(2:42|44)|45|46)(24:49|50|(2:52|(2:54|(6:56|(3:220|(1:217)(1:65)|(1:67)(13:216|95|(14:97|(5:101|(2:103|104)(2:106|(2:108|109)(1:110))|105|98|99)|111|112|(2:114|(11:119|(1:121)(3:177|(4:180|(3:183|(2:186|187)(1:185)|181)|188|189)(0)|179)|(1:123)|124|(7:126|(2:128|(6:(2:133|(6:135|136|(2:140|(1:142)(2:143|(1:145)(3:146|147|148)))|149|147|148))|150|(3:138|140|(0)(0))|149|147|148)(2:151|152))(2:155|(3:157|(6:(2:162|(6:164|136|(0)|149|147|148))|165|(0)|149|147|148)|152)(2:166|(2:170|(1:175))))|154|(0)|149|147|148)(1:176)|153|154|(0)|149|147|148)(1:118))|190|124|(0)(0)|153|154|(0)|149|147|148)|191|190|124|(0)(0)|153|154|(0)|149|147|148))|59|(1:61)|217|(0)(0))(6:221|(4:223|(0)|217|(0)(0))|59|(0)|217|(0)(0)))(6:224|(4:226|(0)|217|(0)(0))|59|(0)|217|(0)(0)))(1:227)|68|(3:69|70|(3:72|(2:74|75)(2:77|(2:79|80)(2:81|82))|76)(1:83))|84|(1:87)|(1:89)|90|(1:92)(1:215)|93|(4:195|(4:198|(2:200|201)(2:203|(2:205|206)(1:207))|202|196)|208|(1:(1:213)(1:214))(1:211))|95|(0)|191|190|124|(0)(0)|153|154|(0)|149|147|148)|47)(1:228))|229|(4:231|(5:233|(2:235|(3:237|238|239))|240|(1:253)(3:242|(1:244)(1:252)|(2:248|249))|239)|254|255)(1:502)|256|257|(6:259|(2:260|(2:262|(2:264|265)(1:496))(2:497|498))|(1:267)|268|(3:272|(1:274)(1:494)|(2:276|(1:278)))|495)(2:499|(1:501))|279|(2:281|(3:289|(2:290|(2:292|(2:295|296)(1:294))(2:299|300))|(1:298)))|301|(1:303)|304|(9:368|369|(7:372|373|(5:375|(1:377)|378|(5:380|(1:382)|383|(1:387)|388)|389)(5:393|(2:396|(2:397|(2:399|(3:402|403|(1:413)(0))(1:401))(1:478)))(0)|479|(1:415)(1:477)|(1:417)(7:418|(1:476)(2:422|(1:424)(1:475))|425|(1:427)(1:474)|428|429|(3:431|(1:439)|440)(5:441|(4:443|(1:445)|446|447)(5:450|451|(3:453|(2:455|456)(1:470)|457)(3:471|(2:473|459)|469)|(3:461|(1:463)|464)(2:466|(1:468))|465)|448|449|392)))|390|391|392|370)|480|481|(1:483)|484|(2:487|485)|488)|306|307|(1:309)|310|(1:312)(2:349|(9:351|(1:353)(1:367)|354|(1:356)(1:366)|357|(1:359)(1:365)|360|(1:362)(1:364)|363))|313|(5:315|(2:320|321)|322|(1:324)(1:325)|321)|326|(3:(2:330|331)(1:333)|332|327)|334|335|(1:337)|338|339|340|341|342|343)(3:503|504|505))|506|(0)(0))(4:507|508|509|510))(7:572|(1:574)(1:584)|575|(1:577)|578|579|(5:581|21|(3:23|26|(0)(0))|506|(0)(0))(2:582|583))|511|512|(2:514|515)(11:516|517|518|519|(1:521)|522|(1:524)(1:547)|525|526|(2:528|529)|(8:530|531|532|533|534|(2:541|542)|536|(2:538|539)(1:540)))|21|(0)|506|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0d01, code lost:
    
        if (r5 != r14) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0237, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x025b, code lost:
    
        r9.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0686 A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x07ae A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x07be A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x07d8 A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0262 A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x026e A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0f66 A[Catch: all -> 0x0f7f, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:558:0x025b A[Catch: all -> 0x0f7f, TRY_ENTER, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x05af A[Catch: all -> 0x0f7f, TryCatch #12 {all -> 0x0f7f, blocks: (B:3:0x000b, B:20:0x0086, B:21:0x025e, B:23:0x0262, B:28:0x026e, B:29:0x0296, B:32:0x02aa, B:35:0x02d0, B:37:0x0309, B:42:0x031f, B:44:0x0329, B:47:0x0822, B:49:0x0352, B:52:0x036a, B:69:0x03cd, B:72:0x03d7, B:74:0x03e5, B:76:0x0438, B:77:0x0406, B:79:0x0415, B:87:0x0447, B:89:0x0477, B:90:0x04a5, B:92:0x04d9, B:93:0x04df, B:97:0x05af, B:98:0x05bb, B:101:0x05c5, B:105:0x05e8, B:106:0x05d7, B:114:0x05ee, B:116:0x05fa, B:118:0x0606, B:123:0x0655, B:124:0x0672, B:126:0x0686, B:128:0x0692, B:131:0x06a5, B:133:0x06b7, B:135:0x06c5, B:138:0x07ae, B:140:0x07b8, B:142:0x07be, B:143:0x07d8, B:145:0x07eb, B:146:0x0805, B:147:0x080e, B:155:0x06ee, B:157:0x06fe, B:160:0x0713, B:162:0x0725, B:164:0x0733, B:166:0x0743, B:168:0x075b, B:170:0x0767, B:173:0x077a, B:175:0x078e, B:177:0x0627, B:181:0x063b, B:183:0x0641, B:185:0x064c, B:193:0x04eb, B:195:0x0520, B:196:0x053d, B:198:0x0543, B:200:0x0551, B:202:0x0565, B:203:0x055a, B:211:0x056c, B:213:0x0573, B:214:0x0592, B:218:0x038c, B:221:0x0396, B:224:0x03a0, B:233:0x083f, B:235:0x084d, B:237:0x0856, B:239:0x0888, B:240:0x085e, B:242:0x0867, B:244:0x086d, B:246:0x0879, B:248:0x0883, B:256:0x088f, B:259:0x08a7, B:260:0x08af, B:262:0x08b5, B:267:0x08cc, B:268:0x08d7, B:270:0x08dd, B:272:0x08ef, B:276:0x08fc, B:278:0x0902, B:279:0x0941, B:281:0x0953, B:283:0x0972, B:285:0x0980, B:287:0x0986, B:289:0x0990, B:290:0x09c2, B:292:0x09c8, B:296:0x09d6, B:298:0x09e1, B:294:0x09db, B:301:0x09e4, B:303:0x09f6, B:304:0x09f9, B:375:0x0a64, B:377:0x0a7f, B:378:0x0a90, B:380:0x0a94, B:382:0x0aa0, B:383:0x0aa8, B:385:0x0aac, B:387:0x0ab2, B:388:0x0ac0, B:389:0x0acb, B:396:0x0b0c, B:397:0x0b14, B:399:0x0b1a, B:403:0x0b2c, B:405:0x0b3a, B:407:0x0b3e, B:409:0x0b48, B:411:0x0b4c, B:415:0x0b62, B:417:0x0b78, B:420:0x0bab, B:422:0x0bbf, B:424:0x0bee, B:431:0x0c59, B:433:0x0c6a, B:435:0x0c6e, B:437:0x0c72, B:439:0x0c76, B:440:0x0c82, B:443:0x0c8d, B:445:0x0ca9, B:446:0x0cb2, B:455:0x0ce7, B:475:0x0c14, B:307:0x0dc5, B:309:0x0dd7, B:310:0x0dda, B:312:0x0dea, B:313:0x0e5f, B:315:0x0e65, B:317:0x0e7a, B:320:0x0e81, B:321:0x0eb4, B:322:0x0e89, B:324:0x0e95, B:325:0x0e9b, B:326:0x0ec5, B:327:0x0edc, B:330:0x0ee4, B:332:0x0ee9, B:335:0x0ef9, B:337:0x0f13, B:338:0x0f2c, B:340:0x0f34, B:341:0x0f56, B:348:0x0f45, B:349:0x0e04, B:351:0x0e0a, B:353:0x0e14, B:354:0x0e1b, B:359:0x0e2b, B:360:0x0e32, B:362:0x0e51, B:363:0x0e58, B:364:0x0e55, B:365:0x0e2f, B:367:0x0e18, B:495:0x091f, B:499:0x0924, B:501:0x0936, B:503:0x0f66, B:515:0x012b, B:529:0x01c9, B:542:0x01ff, B:539:0x021c, B:552:0x0233, B:558:0x025b, B:562:0x0f7b, B:563:0x0f7e, B:581:0x00df, B:518:0x0134), top: B:2:0x000b, inners: #6, #9 }] */
    /* JADX WARN: Type inference failed for: r13v31, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v21, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v42, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r7v35, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v56 */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v68 */
    /* JADX WARN: Type inference failed for: r9v69 */
    /* JADX WARN: Type inference failed for: r9v70 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean E(String str, long j2) {
        Throwable th;
        SQLiteException sQLiteException;
        String str2;
        Cursor cursor;
        List<zzbr.zzc> list;
        boolean z;
        boolean z2;
        long j3;
        long j4;
        boolean z3;
        long j5;
        SecureRandom secureRandom;
        HashMap hashMap;
        boolean z4;
        HashMap hashMap2;
        int i2;
        long v;
        z3 j0;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        int i4;
        zzbr.zzg.zza zzaVar;
        zzbr.zzc.zza zzaVar2;
        zzbr.zzc.zza zzaVar3;
        String str3;
        int i5;
        zzbr.zzg.zza zzaVar4;
        int i6;
        zzbr.zzc.zza zzaVar5;
        int i7;
        boolean z8;
        int i8;
        zzbr.zzc.zza zzaVar6;
        char c2;
        boolean z9;
        ?? x;
        boolean isEmpty;
        String str4;
        ?? r9;
        String str5;
        String[] strArr;
        String[] strArr2;
        zzkc zzkcVar = this;
        String str6 = "_npa";
        W().w0();
        try {
            i7 i7Var = null;
            Cursor cursor2 = null;
            a aVar = new a(zzkcVar, i7Var);
            c W = W();
            long j6 = zzkcVar.y;
            Preconditions.k(aVar);
            W.d();
            W.t();
            try {
                x = W.x();
                isEmpty = TextUtils.isEmpty(null);
                str4 = HttpUrl.FRAGMENT_ENCODE_SET;
                try {
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        r9 = i7Var;
                        str2 = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e3) {
                sQLiteException = e3;
                str2 = null;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = null;
            }
            try {
                if (isEmpty) {
                    if (j6 != -1) {
                        try {
                            strArr2 = new String[]{String.valueOf(j6), String.valueOf(j2)};
                        } catch (SQLiteException e4) {
                            e = e4;
                            str2 = null;
                            r9 = null;
                            sQLiteException = e;
                            cursor = r9;
                            W.h().H().c("Data loss. Error selecting raw event. appId", zzet.x(str2), sQLiteException);
                            if (cursor != null) {
                            }
                            list = aVar.f18220c;
                            if (list != null) {
                            }
                            z = true;
                            if (z) {
                            }
                        }
                    } else {
                        strArr2 = new String[]{String.valueOf(j2)};
                    }
                    if (j6 != -1) {
                        str4 = "rowid <= ? and ";
                    }
                    String str7 = str4;
                    StringBuilder sb = new StringBuilder(str7.length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str7);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    Cursor rawQuery = x.rawQuery(sb.toString(), strArr2);
                    if (!rawQuery.moveToFirst()) {
                        rawQuery.close();
                        list = aVar.f18220c;
                        if (list != null && !list.isEmpty()) {
                            z = false;
                            if (z) {
                                zzbr.zzg.zza R = aVar.a.v().R();
                                boolean B = zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.j0);
                                int i9 = -1;
                                zzbr.zzc.zza zzaVar7 = null;
                                zzbr.zzc.zza zzaVar8 = null;
                                int i10 = -1;
                                int i11 = 0;
                                boolean z10 = false;
                                long j7 = 0;
                                int i12 = 0;
                                while (true) {
                                    z2 = z10;
                                    j3 = j7;
                                    if (i11 >= aVar.f18220c.size()) {
                                        break;
                                    }
                                    zzbr.zzc.zza v2 = aVar.f18220c.get(i11).v();
                                    String str8 = str6;
                                    if (S().C(aVar.a.L2(), v2.K())) {
                                        int i13 = i11;
                                        zzkcVar.f18217j.h().K().c("Dropping blacklisted raw event. appId", zzet.x(aVar.a.L2()), zzkcVar.f18217j.J().y(v2.K()));
                                        if (!S().K(aVar.a.L2()) && !S().L(aVar.a.L2())) {
                                            z9 = false;
                                            if (!z9 && !"_err".equals(v2.K())) {
                                                zzkcVar.f18217j.I().T(aVar.a.L2(), 11, "_ev", v2.K(), 0);
                                            }
                                            z7 = B;
                                            zzaVar2 = zzaVar7;
                                            zzaVar5 = zzaVar8;
                                            z10 = z2;
                                            j7 = j3;
                                            i7 = i13;
                                            zzaVar4 = R;
                                        }
                                        z9 = true;
                                        if (!z9) {
                                            zzkcVar.f18217j.I().T(aVar.a.L2(), 11, "_ev", v2.K(), 0);
                                        }
                                        z7 = B;
                                        zzaVar2 = zzaVar7;
                                        zzaVar5 = zzaVar8;
                                        z10 = z2;
                                        j7 = j3;
                                        i7 = i13;
                                        zzaVar4 = R;
                                    } else {
                                        int i14 = i11;
                                        boolean E = S().E(aVar.a.L2(), v2.K());
                                        if (E) {
                                            z7 = B;
                                            i3 = i10;
                                        } else {
                                            Z();
                                            String K = v2.K();
                                            Preconditions.g(K);
                                            z7 = B;
                                            int hashCode = K.hashCode();
                                            i3 = i10;
                                            if (hashCode == 94660) {
                                                if (K.equals("_in")) {
                                                    c2 = 0;
                                                    if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                    }
                                                }
                                                c2 = 65535;
                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                }
                                            } else if (hashCode != 95025) {
                                                if (hashCode == 95027 && K.equals("_ui")) {
                                                    c2 = 1;
                                                    if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                        zzaVar = R;
                                                        i4 = i9;
                                                        zzaVar2 = zzaVar7;
                                                        zzaVar3 = zzaVar8;
                                                        z10 = z2;
                                                        if (E) {
                                                            ArrayList arrayList = new ArrayList(v2.G());
                                                            int i15 = -1;
                                                            int i16 = -1;
                                                            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                                                if ("value".equals(((zzbr.zze) arrayList.get(i17)).B())) {
                                                                    i15 = i17;
                                                                } else if ("currency".equals(((zzbr.zze) arrayList.get(i17)).B())) {
                                                                    i16 = i17;
                                                                }
                                                            }
                                                            if (i15 != -1) {
                                                                if (!((zzbr.zze) arrayList.get(i15)).P() && !((zzbr.zze) arrayList.get(i15)).R()) {
                                                                    zzkcVar.f18217j.h().M().a("Value must be specified with a numeric type.");
                                                                    v2.I(i15);
                                                                    m(v2, "_c");
                                                                    l(v2, 18, "value");
                                                                } else {
                                                                    if (i16 != -1) {
                                                                        String N = ((zzbr.zze) arrayList.get(i16)).N();
                                                                        if (N.length() == 3) {
                                                                            int i18 = 0;
                                                                            while (i18 < N.length()) {
                                                                                int codePointAt = N.codePointAt(i18);
                                                                                if (Character.isLetter(codePointAt)) {
                                                                                    i18 += Character.charCount(codePointAt);
                                                                                }
                                                                            }
                                                                            z8 = false;
                                                                        }
                                                                        z8 = true;
                                                                        break;
                                                                    }
                                                                    z8 = true;
                                                                    if (z8) {
                                                                        zzkcVar.f18217j.h().M().a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                        v2.I(i15);
                                                                        m(v2, "_c");
                                                                        l(v2, 19, "currency");
                                                                    }
                                                                    if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.i0)) {
                                                                        str3 = "_et";
                                                                        i5 = i3;
                                                                        zzaVar4 = zzaVar;
                                                                        i6 = i4;
                                                                    } else {
                                                                        if ("_e".equals(v2.K())) {
                                                                            Z();
                                                                            if (zzkg.z((zzbr.zzc) ((zzfd) v2.y()), "_fr") == null) {
                                                                                if (zzaVar3 != null && Math.abs(zzaVar3.M() - v2.M()) <= 1000) {
                                                                                    zzbr.zzc.zza zzaVar9 = (zzbr.zzc.zza) ((zzfd.zzb) zzaVar3.clone());
                                                                                    if (zzkcVar.D(v2, zzaVar9)) {
                                                                                        zzaVar4 = zzaVar;
                                                                                        int i19 = i4;
                                                                                        zzaVar4.A(i19, zzaVar9);
                                                                                        i9 = i19;
                                                                                        str3 = "_et";
                                                                                        i10 = i3;
                                                                                        zzaVar5 = null;
                                                                                        zzaVar2 = null;
                                                                                        if (!z7 && "_e".equals(v2.K())) {
                                                                                            if (v2.H() != 0) {
                                                                                                zzkcVar.f18217j.h().K().b("Engagement event does not contain any parameters. appId", zzet.x(aVar.a.L2()));
                                                                                            } else {
                                                                                                Z();
                                                                                                Long l = (Long) zzkg.U((zzbr.zzc) ((zzfd) v2.y()), str3);
                                                                                                if (l == null) {
                                                                                                    zzkcVar.f18217j.h().K().b("Engagement event does not include duration. appId", zzet.x(aVar.a.L2()));
                                                                                                } else {
                                                                                                    j7 = j3 + l.longValue();
                                                                                                    i7 = i14;
                                                                                                    aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                                                    i12++;
                                                                                                    zzaVar4.D(v2);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        j7 = j3;
                                                                                        i7 = i14;
                                                                                        aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                                        i12++;
                                                                                        zzaVar4.D(v2);
                                                                                    }
                                                                                }
                                                                                zzaVar4 = zzaVar;
                                                                                zzaVar2 = v2;
                                                                                i9 = i4;
                                                                                zzaVar5 = zzaVar3;
                                                                                str3 = "_et";
                                                                                i10 = i12;
                                                                                if (!z7) {
                                                                                    if (v2.H() != 0) {
                                                                                    }
                                                                                }
                                                                                j7 = j3;
                                                                                i7 = i14;
                                                                                aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                                i12++;
                                                                                zzaVar4.D(v2);
                                                                            } else {
                                                                                zzaVar4 = zzaVar;
                                                                                i6 = i4;
                                                                                str3 = "_et";
                                                                                i5 = i3;
                                                                            }
                                                                        } else {
                                                                            zzaVar4 = zzaVar;
                                                                            i6 = i4;
                                                                            if ("_vs".equals(v2.K())) {
                                                                                Z();
                                                                                str3 = "_et";
                                                                                if (zzkg.z((zzbr.zzc) ((zzfd) v2.y()), str3) == null) {
                                                                                    if (zzaVar2 != null && Math.abs(zzaVar2.M() - v2.M()) <= 1000) {
                                                                                        zzbr.zzc.zza zzaVar10 = (zzbr.zzc.zza) ((zzfd.zzb) zzaVar2.clone());
                                                                                        if (zzkcVar.D(zzaVar10, v2)) {
                                                                                            int i20 = i3;
                                                                                            zzaVar4.A(i20, zzaVar10);
                                                                                            i10 = i20;
                                                                                            i9 = i6;
                                                                                            zzaVar5 = null;
                                                                                            zzaVar2 = null;
                                                                                            if (!z7) {
                                                                                            }
                                                                                            j7 = j3;
                                                                                            i7 = i14;
                                                                                            aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                                            i12++;
                                                                                            zzaVar4.D(v2);
                                                                                        }
                                                                                    }
                                                                                    i10 = i3;
                                                                                    zzaVar5 = v2;
                                                                                    i9 = i12;
                                                                                    if (!z7) {
                                                                                    }
                                                                                    j7 = j3;
                                                                                    i7 = i14;
                                                                                    aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                                    i12++;
                                                                                    zzaVar4.D(v2);
                                                                                }
                                                                                i5 = i3;
                                                                            } else {
                                                                                str3 = "_et";
                                                                                i5 = i3;
                                                                                if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.R0) && "_ab".equals(v2.K())) {
                                                                                    Z();
                                                                                    if (zzkg.z((zzbr.zzc) ((zzfd) v2.y()), str3) == null && zzaVar2 != null && Math.abs(zzaVar2.M() - v2.M()) <= 4000) {
                                                                                        zzbr.zzc.zza zzaVar11 = (zzbr.zzc.zza) ((zzfd.zzb) zzaVar2.clone());
                                                                                        zzkcVar.L(zzaVar11, v2);
                                                                                        zzaVar4.A(i5, zzaVar11);
                                                                                        i9 = i6;
                                                                                        zzaVar5 = zzaVar3;
                                                                                        zzaVar2 = null;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        i10 = i5;
                                                                        if (!z7) {
                                                                        }
                                                                        j7 = j3;
                                                                        i7 = i14;
                                                                        aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                        i12++;
                                                                        zzaVar4.D(v2);
                                                                    }
                                                                    i9 = i6;
                                                                    zzaVar5 = zzaVar3;
                                                                    i10 = i5;
                                                                    if (!z7) {
                                                                    }
                                                                    j7 = j3;
                                                                    i7 = i14;
                                                                    aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                                    i12++;
                                                                    zzaVar4.D(v2);
                                                                }
                                                            }
                                                            if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.i0)) {
                                                            }
                                                            i9 = i6;
                                                            zzaVar5 = zzaVar3;
                                                            i10 = i5;
                                                            if (!z7) {
                                                            }
                                                            j7 = j3;
                                                            i7 = i14;
                                                            aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                            i12++;
                                                            zzaVar4.D(v2);
                                                        }
                                                        if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.i0)) {
                                                        }
                                                        i9 = i6;
                                                        zzaVar5 = zzaVar3;
                                                        i10 = i5;
                                                        if (!z7) {
                                                        }
                                                        j7 = j3;
                                                        i7 = i14;
                                                        aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                                        i12++;
                                                        zzaVar4.D(v2);
                                                    }
                                                }
                                                c2 = 65535;
                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                }
                                            } else {
                                                if (K.equals("_ug")) {
                                                    c2 = 2;
                                                    if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                    }
                                                }
                                                c2 = 65535;
                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                }
                                            }
                                        }
                                        zzaVar2 = zzaVar7;
                                        boolean z11 = false;
                                        boolean z12 = false;
                                        int i21 = 0;
                                        while (true) {
                                            zzaVar = R;
                                            if (i21 >= v2.H()) {
                                                break;
                                            }
                                            if ("_c".equals(v2.F(i21).B())) {
                                                v2.A(i21, (zzbr.zze) ((zzfd) v2.F(i21).v().B(1L).y()));
                                                i8 = i9;
                                                zzaVar6 = zzaVar8;
                                                z11 = true;
                                            } else {
                                                int i22 = i9;
                                                if ("_r".equals(v2.F(i21).B())) {
                                                    i8 = i22;
                                                    zzaVar6 = zzaVar8;
                                                    v2.A(i21, (zzbr.zze) ((zzfd) v2.F(i21).v().B(1L).y()));
                                                    z12 = true;
                                                } else {
                                                    i8 = i22;
                                                    zzaVar6 = zzaVar8;
                                                }
                                            }
                                            i21++;
                                            zzaVar8 = zzaVar6;
                                            R = zzaVar;
                                            i9 = i8;
                                        }
                                        i4 = i9;
                                        zzbr.zzc.zza zzaVar12 = zzaVar8;
                                        if (!z11 && E) {
                                            zzkcVar.f18217j.h().P().b("Marking event as conversion", zzkcVar.f18217j.J().y(v2.K()));
                                            v2.C(zzbr.zze.T().C("_c").B(1L));
                                        }
                                        if (!z12) {
                                            zzkcVar.f18217j.h().P().b("Marking event as real-time", zzkcVar.f18217j.J().y(v2.K()));
                                            v2.C(zzbr.zze.T().C("_r").B(1L));
                                        }
                                        zzaVar3 = zzaVar12;
                                        if (W().C(k0(), aVar.a.L2(), false, false, false, false, true).f18054e > zzkcVar.f18217j.y().o(aVar.a.L2())) {
                                            m(v2, "_r");
                                        } else {
                                            z2 = true;
                                        }
                                        if (zzkk.Y(v2.K()) && E && W().C(k0(), aVar.a.L2(), false, false, true, false, false).f18052c > zzkcVar.f18217j.y().t(aVar.a.L2(), zzap.u)) {
                                            zzkcVar.f18217j.h().K().b("Too many conversions. Not logging as conversion. appId", zzet.x(aVar.a.L2()));
                                            boolean z13 = false;
                                            int i23 = -1;
                                            zzbr.zze.zza zzaVar13 = null;
                                            for (int i24 = 0; i24 < v2.H(); i24++) {
                                                zzbr.zze F = v2.F(i24);
                                                if ("_c".equals(F.B())) {
                                                    zzaVar13 = F.v();
                                                    i23 = i24;
                                                } else if ("_err".equals(F.B())) {
                                                    z13 = true;
                                                }
                                            }
                                            if (z13 && zzaVar13 != null) {
                                                v2.I(i23);
                                            } else if (zzaVar13 != null) {
                                                v2.A(i23, (zzbr.zze) ((zzfd) ((zzbr.zze.zza) ((zzfd.zzb) zzaVar13.clone())).C("_err").B(10L).y()));
                                            } else {
                                                zzkcVar.f18217j.h().H().b("Did not find conversion parameter. appId", zzet.x(aVar.a.L2()));
                                            }
                                        }
                                        z10 = z2;
                                        if (E) {
                                        }
                                        if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.i0)) {
                                        }
                                        i9 = i6;
                                        zzaVar5 = zzaVar3;
                                        i10 = i5;
                                        if (!z7) {
                                        }
                                        j7 = j3;
                                        i7 = i14;
                                        aVar.f18220c.set(i7, (zzbr.zzc) ((zzfd) v2.y()));
                                        i12++;
                                        zzaVar4.D(v2);
                                    }
                                    i11 = i7 + 1;
                                    R = zzaVar4;
                                    B = z7;
                                    zzaVar7 = zzaVar2;
                                    zzaVar8 = zzaVar5;
                                    str6 = str8;
                                }
                                String str9 = str6;
                                zzbr.zzg.zza zzaVar14 = R;
                                if (B) {
                                    int i25 = i12;
                                    long j8 = j3;
                                    int i26 = 0;
                                    while (i26 < i25) {
                                        zzbr.zzc M = zzaVar14.M(i26);
                                        if ("_e".equals(M.U())) {
                                            Z();
                                            if (zzkg.z(M, "_fr") != null) {
                                                zzaVar14.S(i26);
                                                i25--;
                                                i26--;
                                                i26++;
                                            }
                                        }
                                        Z();
                                        zzbr.zze z14 = zzkg.z(M, "_et");
                                        if (z14 != null) {
                                            Long valueOf = z14.P() ? Long.valueOf(z14.Q()) : null;
                                            if (valueOf != null && valueOf.longValue() > 0) {
                                                j8 += valueOf.longValue();
                                            }
                                        }
                                        i26++;
                                    }
                                    j4 = j8;
                                } else {
                                    j4 = j3;
                                }
                                zzkcVar.o(zzaVar14, j4, false);
                                if (zzkcVar.f18217j.y().B(zzaVar14.C0(), zzap.y0)) {
                                    Iterator<zzbr.zzc> it = zzaVar14.K().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            z6 = false;
                                            break;
                                        }
                                        if ("_s".equals(it.next().U())) {
                                            z6 = true;
                                            break;
                                        }
                                    }
                                    if (z6) {
                                        W().m0(zzaVar14.C0(), "_se");
                                    }
                                    if (zzmd.b() && zzkcVar.f18217j.y().B(zzaVar14.C0(), zzap.z0)) {
                                        if (!(zzkg.w(zzaVar14, "_sid") >= 0)) {
                                            int w = zzkg.w(zzaVar14, "_se");
                                            if (w >= 0) {
                                                zzaVar14.f0(w);
                                                zzkcVar.f18217j.h().K().b("Session engagement user property is in the bundle without session ID. appId", zzet.x(aVar.a.L2()));
                                            }
                                        }
                                    }
                                    zzkcVar.o(zzaVar14, j4, true);
                                } else if (zzkcVar.f18217j.y().B(zzaVar14.C0(), zzap.B0)) {
                                    W().m0(zzaVar14.C0(), "_se");
                                }
                                if (zzkcVar.f18217j.y().B(zzaVar14.C0(), zzap.k0)) {
                                    zzkg Z = Z();
                                    Z.h().P().a("Checking account type status for ad personalization signals");
                                    if (Z.r().I(zzaVar14.C0()) && (j0 = Z.q().j0(zzaVar14.C0())) != null && j0.l() && Z.e().z()) {
                                        Z.h().O().a("Turning off ad personalization due to account type");
                                        zzbr.zzk zzkVar = (zzbr.zzk) ((zzfd) zzbr.zzk.X().C(str9).B(Z.e().x()).E(1L).y());
                                        int i27 = 0;
                                        while (true) {
                                            if (i27 >= zzaVar14.d0()) {
                                                z5 = false;
                                                break;
                                            }
                                            if (str9.equals(zzaVar14.b0(i27).P())) {
                                                zzaVar14.B(i27, zzkVar);
                                                z5 = true;
                                                break;
                                            }
                                            i27++;
                                        }
                                        if (!z5) {
                                            zzaVar14.G(zzkVar);
                                        }
                                    }
                                }
                                if (zzkcVar.f18217j.y().B(zzaVar14.C0(), zzap.M0)) {
                                    n(zzaVar14);
                                }
                                zzbr.zzg.zza K0 = zzaVar14.K0();
                                String C0 = zzaVar14.C0();
                                List<zzbr.zzk> c0 = zzaVar14.c0();
                                List<zzbr.zzc> K2 = zzaVar14.K();
                                long j02 = zzaVar14.j0();
                                Preconditions.g(C0);
                                K0.U(X().w(C0, K2, c0, Long.valueOf(j02)));
                                if (zzkcVar.f18217j.y().A(aVar.a.L2())) {
                                    try {
                                        HashMap hashMap3 = new HashMap();
                                        ArrayList arrayList2 = new ArrayList();
                                        SecureRandom z0 = zzkcVar.f18217j.I().z0();
                                        int i28 = 0;
                                        while (i28 < zzaVar14.L()) {
                                            zzbr.zzc.zza v3 = zzaVar14.M(i28).v();
                                            if (v3.K().equals("_ep")) {
                                                Z();
                                                String str10 = (String) zzkg.U((zzbr.zzc) ((zzfd) v3.y()), "_en");
                                                h hVar = (h) hashMap3.get(str10);
                                                if (hVar == null) {
                                                    hVar = W().D(aVar.a.L2(), str10);
                                                    hashMap3.put(str10, hVar);
                                                }
                                                if (hVar.f17791i == null) {
                                                    if (hVar.f17792j.longValue() > 1) {
                                                        Z();
                                                        zzkg.I(v3, "_sr", hVar.f17792j);
                                                    }
                                                    Boolean bool = hVar.f17793k;
                                                    if (bool != null && bool.booleanValue()) {
                                                        Z();
                                                        zzkg.I(v3, "_efs", 1L);
                                                    }
                                                    arrayList2.add((zzbr.zzc) ((zzfd) v3.y()));
                                                }
                                                zzaVar14.A(i28, v3);
                                            } else {
                                                long J = S().J(aVar.a.L2());
                                                zzkcVar.f18217j.I();
                                                long v4 = zzkk.v(v3.M(), J);
                                                zzbr.zzc zzcVar = (zzbr.zzc) ((zzfd) v3.y());
                                                Long l2 = 1L;
                                                if (!TextUtils.isEmpty("_dbg") && l2 != null) {
                                                    Iterator<zzbr.zze> it2 = zzcVar.C().iterator();
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            break;
                                                        }
                                                        zzbr.zze next = it2.next();
                                                        Iterator<zzbr.zze> it3 = it2;
                                                        if (!"_dbg".equals(next.B())) {
                                                            it2 = it3;
                                                        } else if (l2.equals(Long.valueOf(next.Q())) || (((l2 instanceof String) && l2.equals(next.N())) || ((l2 instanceof Double) && l2.equals(Double.valueOf(next.S()))))) {
                                                            z3 = true;
                                                        }
                                                    }
                                                }
                                                z3 = false;
                                                int F2 = !z3 ? S().F(aVar.a.L2(), v3.K()) : 1;
                                                if (F2 <= 0) {
                                                    zzkcVar.f18217j.h().K().c("Sample rate must be positive. event, rate", v3.K(), Integer.valueOf(F2));
                                                    arrayList2.add((zzbr.zzc) ((zzfd) v3.y()));
                                                    zzaVar14.A(i28, v3);
                                                } else {
                                                    h hVar2 = (h) hashMap3.get(v3.K());
                                                    if (hVar2 == null && (hVar2 = W().D(aVar.a.L2(), v3.K())) == null) {
                                                        j5 = v4;
                                                        zzkcVar.f18217j.h().K().c("Event being bundled has no eventAggregate. appId, eventName", aVar.a.L2(), v3.K());
                                                        if (zzkcVar.f18217j.y().B(aVar.a.L2(), zzap.x0)) {
                                                            hVar2 = new h(aVar.a.L2(), v3.K(), 1L, 1L, 1L, v3.M(), 0L, null, null, null, null);
                                                        } else {
                                                            hVar2 = new h(aVar.a.L2(), v3.K(), 1L, 1L, v3.M(), 0L, null, null, null, null);
                                                        }
                                                    } else {
                                                        j5 = v4;
                                                    }
                                                    Z();
                                                    Long l3 = (Long) zzkg.U((zzbr.zzc) ((zzfd) v3.y()), "_eid");
                                                    Boolean valueOf2 = Boolean.valueOf(l3 != null);
                                                    if (F2 == 1) {
                                                        arrayList2.add((zzbr.zzc) ((zzfd) v3.y()));
                                                        if (valueOf2.booleanValue() && (hVar2.f17791i != null || hVar2.f17792j != null || hVar2.f17793k != null)) {
                                                            hashMap3.put(v3.K(), hVar2.c(null, null, null));
                                                        }
                                                        zzaVar14.A(i28, v3);
                                                    } else {
                                                        if (z0.nextInt(F2) == 0) {
                                                            Z();
                                                            long j9 = F2;
                                                            zzkg.I(v3, "_sr", Long.valueOf(j9));
                                                            arrayList2.add((zzbr.zzc) ((zzfd) v3.y()));
                                                            if (valueOf2.booleanValue()) {
                                                                hVar2 = hVar2.c(null, Long.valueOf(j9), null);
                                                            }
                                                            hashMap3.put(v3.K(), hVar2.b(v3.M(), j5));
                                                            hashMap2 = hashMap3;
                                                            secureRandom = z0;
                                                            i2 = i28;
                                                        } else {
                                                            long j10 = j5;
                                                            secureRandom = z0;
                                                            int i29 = i28;
                                                            if (zzkcVar.f18217j.y().O(aVar.a.L2())) {
                                                                Long l4 = hVar2.f17790h;
                                                                if (l4 != null) {
                                                                    v = l4.longValue();
                                                                    hashMap = hashMap3;
                                                                } else {
                                                                    zzkcVar.f18217j.I();
                                                                    hashMap = hashMap3;
                                                                    v = zzkk.v(v3.N(), J);
                                                                }
                                                            } else {
                                                                hashMap = hashMap3;
                                                                z4 = Math.abs(v3.M() - hVar2.f17789g) >= PullingContentService.UPDATES_INTERVAL;
                                                            }
                                                            if (z4) {
                                                                Z();
                                                                zzkg.I(v3, "_efs", 1L);
                                                                Z();
                                                                long j11 = F2;
                                                                zzkg.I(v3, "_sr", Long.valueOf(j11));
                                                                arrayList2.add((zzbr.zzc) ((zzfd) v3.y()));
                                                                if (valueOf2.booleanValue()) {
                                                                    hVar2 = hVar2.c(null, Long.valueOf(j11), Boolean.TRUE);
                                                                }
                                                                hashMap2 = hashMap;
                                                                hashMap2.put(v3.K(), hVar2.b(v3.M(), j10));
                                                            } else {
                                                                hashMap2 = hashMap;
                                                                if (valueOf2.booleanValue()) {
                                                                    hashMap2.put(v3.K(), hVar2.c(l3, null, null));
                                                                }
                                                            }
                                                            i2 = i29;
                                                        }
                                                        zzaVar14.A(i2, v3);
                                                        i28 = i2 + 1;
                                                        hashMap3 = hashMap2;
                                                        z0 = secureRandom;
                                                        zzkcVar = this;
                                                    }
                                                }
                                            }
                                            hashMap2 = hashMap3;
                                            secureRandom = z0;
                                            i2 = i28;
                                            i28 = i2 + 1;
                                            hashMap3 = hashMap2;
                                            z0 = secureRandom;
                                            zzkcVar = this;
                                        }
                                        HashMap hashMap4 = hashMap3;
                                        if (arrayList2.size() < zzaVar14.L()) {
                                            zzaVar14.R().H(arrayList2);
                                        }
                                        Iterator it4 = hashMap4.entrySet().iterator();
                                        while (it4.hasNext()) {
                                            W().N((h) ((Map.Entry) it4.next()).getValue());
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        Throwable th5 = th;
                                        W().A0();
                                        throw th5;
                                    }
                                }
                                if (!this.f18217j.y().B(zzaVar14.C0(), zzap.M0)) {
                                    n(zzaVar14);
                                }
                                String L2 = aVar.a.L2();
                                z3 j03 = W().j0(L2);
                                if (j03 == null) {
                                    this.f18217j.h().H().b("Bundling raw events w/o app info. appId", zzet.x(aVar.a.L2()));
                                } else if (zzaVar14.L() > 0) {
                                    long R2 = j03.R();
                                    if (R2 != 0) {
                                        zzaVar14.g0(R2);
                                    } else {
                                        zzaVar14.w0();
                                    }
                                    long P = j03.P();
                                    if (P != 0) {
                                        R2 = P;
                                    }
                                    if (R2 != 0) {
                                        zzaVar14.X(R2);
                                    } else {
                                        zzaVar14.s0();
                                    }
                                    j03.i0();
                                    zzaVar14.o0((int) j03.f0());
                                    j03.a(zzaVar14.j0());
                                    j03.q(zzaVar14.n0());
                                    String j12 = j03.j();
                                    if (j12 != null) {
                                        zzaVar14.B0(j12);
                                    } else {
                                        zzaVar14.D0();
                                    }
                                    W().O(j03);
                                }
                                if (zzaVar14.L() > 0) {
                                    this.f18217j.G();
                                    zzbo.zzb w2 = S().w(aVar.a.L2());
                                    if (w2 != null && w2.F()) {
                                        zzaVar14.y0(w2.G());
                                        W().R((zzbr.zzg) ((zzfd) zzaVar14.y()), z2);
                                    }
                                    if (TextUtils.isEmpty(aVar.a.n0())) {
                                        zzaVar14.y0(-1L);
                                    } else {
                                        this.f18217j.h().K().b("Did not find measurement config or missing version info. appId", zzet.x(aVar.a.L2()));
                                    }
                                    W().R((zzbr.zzg) ((zzfd) zzaVar14.y()), z2);
                                }
                                c W2 = W();
                                List<Long> list2 = aVar.f18219b;
                                Preconditions.k(list2);
                                W2.d();
                                W2.t();
                                StringBuilder sb2 = new StringBuilder("rowid in (");
                                for (int i30 = 0; i30 < list2.size(); i30++) {
                                    if (i30 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(list2.get(i30).longValue());
                                }
                                sb2.append(")");
                                int delete = W2.x().delete("raw_events", sb2.toString(), null);
                                if (delete != list2.size()) {
                                    W2.h().H().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list2.size()));
                                }
                                c W3 = W();
                                try {
                                    W3.x().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{L2, L2});
                                } catch (SQLiteException e5) {
                                    W3.h().H().c("Failed to remove unused event metadata. appId", zzet.x(L2), e5);
                                }
                                W().w();
                                W().A0();
                                return true;
                            }
                            W().w();
                            W().A0();
                            return false;
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        str2 = rawQuery.getString(0);
                        try {
                            ?? string = rawQuery.getString(1);
                            rawQuery.close();
                            r9 = rawQuery;
                            i7Var = string;
                        } catch (SQLiteException e6) {
                            e = e6;
                            r9 = rawQuery;
                            sQLiteException = e;
                            cursor = r9;
                            W.h().H().c("Data loss. Error selecting raw event. appId", zzet.x(str2), sQLiteException);
                            if (cursor != null) {
                            }
                            list = aVar.f18220c;
                            if (list != null) {
                            }
                            z = true;
                            if (z) {
                            }
                        }
                    }
                } else {
                    String[] strArr3 = j6 != -1 ? new String[]{null, String.valueOf(j6)} : new String[]{null};
                    if (j6 != -1) {
                        str4 = " and rowid <= ?";
                    }
                    String str11 = str4;
                    StringBuilder sb3 = new StringBuilder(str11.length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str11);
                    sb3.append(" order by rowid limit 1;");
                    Cursor rawQuery2 = x.rawQuery(sb3.toString(), strArr3);
                    if (!rawQuery2.moveToFirst()) {
                        rawQuery2.close();
                        list = aVar.f18220c;
                        if (list != null) {
                            z = false;
                            if (z) {
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    } else {
                        ?? string2 = rawQuery2.getString(0);
                        rawQuery2.close();
                        r9 = rawQuery2;
                        i7Var = string2;
                        str2 = null;
                    }
                }
                Cursor query = x.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str2, i7Var}, null, null, "rowid", "2");
                if (!query.moveToFirst()) {
                    W.h().H().b("Raw event metadata record is missing. appId", zzet.x(str2));
                    query.close();
                } else {
                    try {
                        zzbr.zzg zzgVar = (zzbr.zzg) ((zzfd) ((zzbr.zzg.zza) zzkg.A(zzbr.zzg.R0(), query.getBlob(0))).y());
                        if (query.moveToNext()) {
                            W.h().K().b("Get multiple raw event metadata records, expected one. appId", zzet.x(str2));
                        }
                        query.close();
                        aVar.a(zzgVar);
                        if (j6 != -1) {
                            str5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                            strArr = new String[]{str2, i7Var, String.valueOf(j6)};
                        } else {
                            str5 = "app_id = ? and metadata_fingerprint = ?";
                            strArr = new String[]{str2, i7Var};
                        }
                        Cursor query2 = x.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str5, strArr, null, null, "rowid", null);
                        if (!query2.moveToFirst()) {
                            W.h().K().b("Raw event data disappeared while in transaction. appId", zzet.x(str2));
                            query2.close();
                        }
                        while (true) {
                            long j13 = query2.getLong(0);
                            try {
                                zzbr.zzc.zza zzaVar15 = (zzbr.zzc.zza) zzkg.A(zzbr.zzc.c0(), query2.getBlob(3));
                                zzaVar15.E(query2.getString(1)).B(query2.getLong(2));
                                if (!aVar.b(j13, (zzbr.zzc) ((zzfd) zzaVar15.y()))) {
                                    query2.close();
                                    break;
                                }
                            } catch (IOException e7) {
                                W.h().H().c("Data loss. Failed to merge raw event. appId", zzet.x(str2), e7);
                            }
                            if (!query2.moveToNext()) {
                                query2.close();
                                break;
                            }
                        }
                    } catch (IOException e8) {
                        W.h().H().c("Data loss. Failed to merge raw event metadata. appId", zzet.x(str2), e8);
                        query.close();
                    }
                }
                list = aVar.f18220c;
                if (list != null) {
                }
                z = true;
                if (z) {
                }
            } catch (Throwable th6) {
                th = th6;
                cursor2 = r9;
                if (cursor2 == null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            Throwable th52 = th;
            W().A0();
            throw th52;
        }
    }

    private final void F() {
        j0();
        if (!this.r && !this.s && !this.t) {
            this.f18217j.h().P().a("Stopping uploading service(s)");
            List<Runnable> list = this.o;
            if (list == null) {
                return;
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.o.clear();
            return;
        }
        this.f18217j.h().P().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t));
    }

    @VisibleForTesting
    private final boolean H() {
        FileLock fileLock;
        j0();
        if (this.f18217j.y().r(zzap.L0) && (fileLock = this.u) != null && fileLock.isValid()) {
            this.f18217j.h().P().a("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f18217j.f().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.v = channel;
            FileLock tryLock = channel.tryLock();
            this.u = tryLock;
            if (tryLock != null) {
                this.f18217j.h().P().a("Storage concurrent access okay");
                return true;
            }
            this.f18217j.h().H().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.f18217j.h().H().b("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.f18217j.h().H().b("Failed to access storage lock file", e3);
            return false;
        } catch (OverlappingFileLockException e4) {
            this.f18217j.h().K().b("Storage lock already acquired", e4);
            return false;
        }
    }

    private final boolean I() {
        j0();
        c0();
        return this.l;
    }

    private final Boolean K(z3 z3Var) {
        try {
            if (z3Var.V() != -2147483648L) {
                if (z3Var.V() == Wrappers.a(this.f18217j.f()).e(z3Var.t(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.a(this.f18217j.f()).e(z3Var.t(), 0).versionName;
                if (z3Var.T() != null && z3Var.T().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void L(zzbr.zzc.zza zzaVar, zzbr.zzc.zza zzaVar2) {
        Preconditions.a("_e".equals(zzaVar.K()));
        Z();
        zzbr.zze z = zzkg.z((zzbr.zzc) ((zzfd) zzaVar.y()), "_et");
        if (!z.P() || z.Q() <= 0) {
            return;
        }
        long Q = z.Q();
        Z();
        zzbr.zze z2 = zzkg.z((zzbr.zzc) ((zzfd) zzaVar2.y()), "_et");
        if (z2 != null && z2.Q() > 0) {
            Q += z2.Q();
        }
        Z();
        zzkg.I(zzaVar2, "_et", Long.valueOf(Q));
        Z();
        zzkg.I(zzaVar, "_fr", 1L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:225|(1:227)(1:251)|228|(2:230|(1:232)(8:233|234|235|(1:237)|238|(0)|43|(0)(0)))|243|244|245|246|234|235|(0)|238|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0234, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0236, code lost:
    
        r7.h().H().c("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzet.x(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0845 A[Catch: all -> 0x08ba, TryCatch #2 {all -> 0x08ba, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b1, B:45:0x02f0, B:47:0x02f5, B:48:0x030e, B:52:0x031f, B:54:0x0334, B:56:0x033b, B:57:0x0354, B:61:0x0377, B:65:0x039f, B:66:0x03b8, B:69:0x03c8, B:72:0x03eb, B:73:0x0409, B:76:0x0413, B:78:0x0421, B:80:0x042d, B:82:0x0433, B:83:0x043e, B:85:0x0446, B:87:0x0456, B:89:0x0464, B:90:0x046f, B:92:0x047b, B:93:0x0492, B:95:0x04bf, B:98:0x04cf, B:101:0x050b, B:102:0x0533, B:104:0x056d, B:105:0x0572, B:107:0x057a, B:108:0x057f, B:110:0x0587, B:111:0x058c, B:113:0x0595, B:114:0x0599, B:116:0x05a6, B:117:0x05ab, B:119:0x05b9, B:121:0x05c3, B:123:0x05cb, B:124:0x05de, B:126:0x05e6, B:127:0x05e9, B:129:0x05fe, B:131:0x0608, B:132:0x060b, B:134:0x0619, B:136:0x0623, B:138:0x0627, B:140:0x0632, B:141:0x069e, B:143:0x06e6, B:145:0x06ec, B:147:0x06f5, B:148:0x06fa, B:150:0x0706, B:151:0x076d, B:153:0x0777, B:154:0x077e, B:156:0x0788, B:157:0x078f, B:158:0x079a, B:160:0x07a0, B:163:0x07d1, B:164:0x07e1, B:166:0x07e9, B:167:0x07ed, B:169:0x07f3, B:174:0x083f, B:176:0x0845, B:177:0x0861, B:179:0x0875, B:183:0x0806, B:185:0x082a, B:191:0x0849, B:192:0x063c, B:194:0x064e, B:196:0x0652, B:198:0x0664, B:199:0x069b, B:200:0x067e, B:202:0x0684, B:203:0x05d1, B:205:0x05d9, B:206:0x0525, B:209:0x0125, B:212:0x0137, B:214:0x014e, B:220:0x016a, B:221:0x0196, B:223:0x019c, B:225:0x01aa, B:227:0x01b2, B:228:0x01bc, B:230:0x01c7, B:233:0x01ce, B:235:0x0261, B:237:0x026b, B:240:0x02a2, B:243:0x01fb, B:245:0x0219, B:246:0x0247, B:250:0x0236, B:251:0x01b7, B:253:0x016f, B:254:0x018c), top: B:35:0x0108, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0875 A[Catch: all -> 0x08ba, TRY_LEAVE, TryCatch #2 {all -> 0x08ba, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b1, B:45:0x02f0, B:47:0x02f5, B:48:0x030e, B:52:0x031f, B:54:0x0334, B:56:0x033b, B:57:0x0354, B:61:0x0377, B:65:0x039f, B:66:0x03b8, B:69:0x03c8, B:72:0x03eb, B:73:0x0409, B:76:0x0413, B:78:0x0421, B:80:0x042d, B:82:0x0433, B:83:0x043e, B:85:0x0446, B:87:0x0456, B:89:0x0464, B:90:0x046f, B:92:0x047b, B:93:0x0492, B:95:0x04bf, B:98:0x04cf, B:101:0x050b, B:102:0x0533, B:104:0x056d, B:105:0x0572, B:107:0x057a, B:108:0x057f, B:110:0x0587, B:111:0x058c, B:113:0x0595, B:114:0x0599, B:116:0x05a6, B:117:0x05ab, B:119:0x05b9, B:121:0x05c3, B:123:0x05cb, B:124:0x05de, B:126:0x05e6, B:127:0x05e9, B:129:0x05fe, B:131:0x0608, B:132:0x060b, B:134:0x0619, B:136:0x0623, B:138:0x0627, B:140:0x0632, B:141:0x069e, B:143:0x06e6, B:145:0x06ec, B:147:0x06f5, B:148:0x06fa, B:150:0x0706, B:151:0x076d, B:153:0x0777, B:154:0x077e, B:156:0x0788, B:157:0x078f, B:158:0x079a, B:160:0x07a0, B:163:0x07d1, B:164:0x07e1, B:166:0x07e9, B:167:0x07ed, B:169:0x07f3, B:174:0x083f, B:176:0x0845, B:177:0x0861, B:179:0x0875, B:183:0x0806, B:185:0x082a, B:191:0x0849, B:192:0x063c, B:194:0x064e, B:196:0x0652, B:198:0x0664, B:199:0x069b, B:200:0x067e, B:202:0x0684, B:203:0x05d1, B:205:0x05d9, B:206:0x0525, B:209:0x0125, B:212:0x0137, B:214:0x014e, B:220:0x016a, B:221:0x0196, B:223:0x019c, B:225:0x01aa, B:227:0x01b2, B:228:0x01bc, B:230:0x01c7, B:233:0x01ce, B:235:0x0261, B:237:0x026b, B:240:0x02a2, B:243:0x01fb, B:245:0x0219, B:246:0x0247, B:250:0x0236, B:251:0x01b7, B:253:0x016f, B:254:0x018c), top: B:35:0x0108, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x026b A[Catch: all -> 0x08ba, TryCatch #2 {all -> 0x08ba, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b1, B:45:0x02f0, B:47:0x02f5, B:48:0x030e, B:52:0x031f, B:54:0x0334, B:56:0x033b, B:57:0x0354, B:61:0x0377, B:65:0x039f, B:66:0x03b8, B:69:0x03c8, B:72:0x03eb, B:73:0x0409, B:76:0x0413, B:78:0x0421, B:80:0x042d, B:82:0x0433, B:83:0x043e, B:85:0x0446, B:87:0x0456, B:89:0x0464, B:90:0x046f, B:92:0x047b, B:93:0x0492, B:95:0x04bf, B:98:0x04cf, B:101:0x050b, B:102:0x0533, B:104:0x056d, B:105:0x0572, B:107:0x057a, B:108:0x057f, B:110:0x0587, B:111:0x058c, B:113:0x0595, B:114:0x0599, B:116:0x05a6, B:117:0x05ab, B:119:0x05b9, B:121:0x05c3, B:123:0x05cb, B:124:0x05de, B:126:0x05e6, B:127:0x05e9, B:129:0x05fe, B:131:0x0608, B:132:0x060b, B:134:0x0619, B:136:0x0623, B:138:0x0627, B:140:0x0632, B:141:0x069e, B:143:0x06e6, B:145:0x06ec, B:147:0x06f5, B:148:0x06fa, B:150:0x0706, B:151:0x076d, B:153:0x0777, B:154:0x077e, B:156:0x0788, B:157:0x078f, B:158:0x079a, B:160:0x07a0, B:163:0x07d1, B:164:0x07e1, B:166:0x07e9, B:167:0x07ed, B:169:0x07f3, B:174:0x083f, B:176:0x0845, B:177:0x0861, B:179:0x0875, B:183:0x0806, B:185:0x082a, B:191:0x0849, B:192:0x063c, B:194:0x064e, B:196:0x0652, B:198:0x0664, B:199:0x069b, B:200:0x067e, B:202:0x0684, B:203:0x05d1, B:205:0x05d9, B:206:0x0525, B:209:0x0125, B:212:0x0137, B:214:0x014e, B:220:0x016a, B:221:0x0196, B:223:0x019c, B:225:0x01aa, B:227:0x01b2, B:228:0x01bc, B:230:0x01c7, B:233:0x01ce, B:235:0x0261, B:237:0x026b, B:240:0x02a2, B:243:0x01fb, B:245:0x0219, B:246:0x0247, B:250:0x0236, B:251:0x01b7, B:253:0x016f, B:254:0x018c), top: B:35:0x0108, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02a2 A[Catch: all -> 0x08ba, TRY_LEAVE, TryCatch #2 {all -> 0x08ba, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b1, B:45:0x02f0, B:47:0x02f5, B:48:0x030e, B:52:0x031f, B:54:0x0334, B:56:0x033b, B:57:0x0354, B:61:0x0377, B:65:0x039f, B:66:0x03b8, B:69:0x03c8, B:72:0x03eb, B:73:0x0409, B:76:0x0413, B:78:0x0421, B:80:0x042d, B:82:0x0433, B:83:0x043e, B:85:0x0446, B:87:0x0456, B:89:0x0464, B:90:0x046f, B:92:0x047b, B:93:0x0492, B:95:0x04bf, B:98:0x04cf, B:101:0x050b, B:102:0x0533, B:104:0x056d, B:105:0x0572, B:107:0x057a, B:108:0x057f, B:110:0x0587, B:111:0x058c, B:113:0x0595, B:114:0x0599, B:116:0x05a6, B:117:0x05ab, B:119:0x05b9, B:121:0x05c3, B:123:0x05cb, B:124:0x05de, B:126:0x05e6, B:127:0x05e9, B:129:0x05fe, B:131:0x0608, B:132:0x060b, B:134:0x0619, B:136:0x0623, B:138:0x0627, B:140:0x0632, B:141:0x069e, B:143:0x06e6, B:145:0x06ec, B:147:0x06f5, B:148:0x06fa, B:150:0x0706, B:151:0x076d, B:153:0x0777, B:154:0x077e, B:156:0x0788, B:157:0x078f, B:158:0x079a, B:160:0x07a0, B:163:0x07d1, B:164:0x07e1, B:166:0x07e9, B:167:0x07ed, B:169:0x07f3, B:174:0x083f, B:176:0x0845, B:177:0x0861, B:179:0x0875, B:183:0x0806, B:185:0x082a, B:191:0x0849, B:192:0x063c, B:194:0x064e, B:196:0x0652, B:198:0x0664, B:199:0x069b, B:200:0x067e, B:202:0x0684, B:203:0x05d1, B:205:0x05d9, B:206:0x0525, B:209:0x0125, B:212:0x0137, B:214:0x014e, B:220:0x016a, B:221:0x0196, B:223:0x019c, B:225:0x01aa, B:227:0x01b2, B:228:0x01bc, B:230:0x01c7, B:233:0x01ce, B:235:0x0261, B:237:0x026b, B:240:0x02a2, B:243:0x01fb, B:245:0x0219, B:246:0x0247, B:250:0x0236, B:251:0x01b7, B:253:0x016f, B:254:0x018c), top: B:35:0x0108, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02f0 A[Catch: all -> 0x08ba, TryCatch #2 {all -> 0x08ba, blocks: (B:36:0x0108, B:39:0x0117, B:43:0x02b1, B:45:0x02f0, B:47:0x02f5, B:48:0x030e, B:52:0x031f, B:54:0x0334, B:56:0x033b, B:57:0x0354, B:61:0x0377, B:65:0x039f, B:66:0x03b8, B:69:0x03c8, B:72:0x03eb, B:73:0x0409, B:76:0x0413, B:78:0x0421, B:80:0x042d, B:82:0x0433, B:83:0x043e, B:85:0x0446, B:87:0x0456, B:89:0x0464, B:90:0x046f, B:92:0x047b, B:93:0x0492, B:95:0x04bf, B:98:0x04cf, B:101:0x050b, B:102:0x0533, B:104:0x056d, B:105:0x0572, B:107:0x057a, B:108:0x057f, B:110:0x0587, B:111:0x058c, B:113:0x0595, B:114:0x0599, B:116:0x05a6, B:117:0x05ab, B:119:0x05b9, B:121:0x05c3, B:123:0x05cb, B:124:0x05de, B:126:0x05e6, B:127:0x05e9, B:129:0x05fe, B:131:0x0608, B:132:0x060b, B:134:0x0619, B:136:0x0623, B:138:0x0627, B:140:0x0632, B:141:0x069e, B:143:0x06e6, B:145:0x06ec, B:147:0x06f5, B:148:0x06fa, B:150:0x0706, B:151:0x076d, B:153:0x0777, B:154:0x077e, B:156:0x0788, B:157:0x078f, B:158:0x079a, B:160:0x07a0, B:163:0x07d1, B:164:0x07e1, B:166:0x07e9, B:167:0x07ed, B:169:0x07f3, B:174:0x083f, B:176:0x0845, B:177:0x0861, B:179:0x0875, B:183:0x0806, B:185:0x082a, B:191:0x0849, B:192:0x063c, B:194:0x064e, B:196:0x0652, B:198:0x0664, B:199:0x069b, B:200:0x067e, B:202:0x0684, B:203:0x05d1, B:205:0x05d9, B:206:0x0525, B:209:0x0125, B:212:0x0137, B:214:0x014e, B:220:0x016a, B:221:0x0196, B:223:0x019c, B:225:0x01aa, B:227:0x01b2, B:228:0x01bc, B:230:0x01c7, B:233:0x01ce, B:235:0x0261, B:237:0x026b, B:240:0x02a2, B:243:0x01fb, B:245:0x0219, B:246:0x0247, B:250:0x0236, B:251:0x01b7, B:253:0x016f, B:254:0x018c), top: B:35:0x0108, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x031d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M(zzan zzanVar, zzm zzmVar) {
        long longValue;
        long j2;
        boolean z;
        m7 m7Var;
        m7 m7Var2;
        long intValue;
        String str;
        h a2;
        long z2;
        c W;
        zzam zzamVar;
        boolean z3;
        List<Integer> X;
        m7 o0;
        z3 j0;
        Preconditions.k(zzmVar);
        Preconditions.g(zzmVar.f18234f);
        long nanoTime = System.nanoTime();
        j0();
        c0();
        String str2 = zzmVar.f18234f;
        if (!Z().R(zzanVar, zzmVar)) {
            return;
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        if (S().C(str2, zzanVar.f18067f)) {
            this.f18217j.h().K().c("Dropping blacklisted event. appId", zzet.x(str2), this.f18217j.J().y(zzanVar.f18067f));
            boolean z4 = S().K(str2) || S().L(str2);
            if (!z4 && !"_err".equals(zzanVar.f18067f)) {
                this.f18217j.I().T(str2, 11, "_ev", zzanVar.f18067f, 0);
            }
            if (!z4 || (j0 = W().j0(str2)) == null || Math.abs(this.f18217j.j().a() - Math.max(j0.h0(), j0.g0())) <= zzap.G.a(null).longValue()) {
                return;
            }
            this.f18217j.h().O().a("Fetching config for blacklisted app");
            r(j0);
            return;
        }
        if (this.f18217j.h().C(2)) {
            this.f18217j.h().P().b("Logging event", this.f18217j.J().x(zzanVar));
        }
        W().w0();
        try {
            T(zzmVar);
            if (!"_iap".equals(zzanVar.f18067f) && !"ecommerce_purchase".equals(zzanVar.f18067f)) {
                j2 = nanoTime;
                boolean Y = zzkk.Y(zzanVar.f18067f);
                boolean equals = "_err".equals(zzanVar.f18067f);
                zzab C = W().C(k0(), str2, true, Y, false, equals, false);
                intValue = C.f18051b - zzap.r.a(null).intValue();
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        this.f18217j.h().H().c("Data loss. Too many events logged. appId, count", zzet.x(str2), Long.valueOf(C.f18051b));
                    }
                    W().w();
                    return;
                }
                if (Y) {
                    long intValue2 = C.a - zzap.t.a(null).intValue();
                    if (intValue2 > 0) {
                        if (intValue2 % 1000 == 1) {
                            this.f18217j.h().H().c("Data loss. Too many public events logged. appId, count", zzet.x(str2), Long.valueOf(C.a));
                        }
                        this.f18217j.I().T(str2, 16, "_ev", zzanVar.f18067f, 0);
                        W().w();
                        return;
                    }
                }
                if (equals) {
                    long max = C.f18053d - Math.max(0, Math.min(1000000, this.f18217j.y().t(zzmVar.f18234f, zzap.s)));
                    if (max > 0) {
                        if (max == 1) {
                            this.f18217j.h().H().c("Too many error events logged. appId, count", zzet.x(str2), Long.valueOf(C.f18053d));
                        }
                        W().w();
                        return;
                    }
                }
                Bundle Y2 = zzanVar.f18068g.Y();
                this.f18217j.I().L(Y2, "_o", zzanVar.f18069h);
                if (this.f18217j.I().v0(str2)) {
                    this.f18217j.I().L(Y2, "_dbg", 1L);
                    this.f18217j.I().L(Y2, "_r", 1L);
                }
                if ("_s".equals(zzanVar.f18067f) && this.f18217j.y().Q(zzmVar.f18234f) && (o0 = W().o0(zzmVar.f18234f, "_sno")) != null && (o0.f17875e instanceof Long)) {
                    this.f18217j.I().L(Y2, "_sno", o0.f17875e);
                }
                if ("_s".equals(zzanVar.f18067f) && this.f18217j.y().B(zzmVar.f18234f, zzap.e0) && !this.f18217j.y().Q(zzmVar.f18234f)) {
                    str = null;
                    O(new zzkj("_sno", 0L, null), zzmVar);
                } else {
                    str = null;
                }
                long n0 = W().n0(str2);
                if (n0 > 0) {
                    this.f18217j.h().K().c("Data lost. Too many events stored on disk, deleted. appId", zzet.x(str2), Long.valueOf(n0));
                }
                String str3 = "_r";
                String str4 = str;
                zzak zzakVar = new zzak(this.f18217j, zzanVar.f18069h, str2, zzanVar.f18067f, zzanVar.f18070i, 0L, Y2);
                h D = W().D(str2, zzakVar.f18061b);
                if (D == null) {
                    if (W().x0(str2) >= 500 && Y) {
                        this.f18217j.h().H().d("Too many event names used, ignoring event. appId, name, supported count", zzet.x(str2), this.f18217j.J().y(zzakVar.f18061b), 500);
                        this.f18217j.I().T(str2, 8, null, null, 0);
                        return;
                    }
                    a2 = new h(str2, zzakVar.f18061b, 0L, 0L, zzakVar.f18063d, 0L, null, null, null, null);
                } else {
                    zzakVar = zzakVar.a(this.f18217j, D.f17788f);
                    a2 = D.a(zzakVar.f18063d);
                }
                W().N(a2);
                j0();
                c0();
                Preconditions.k(zzakVar);
                Preconditions.k(zzmVar);
                Preconditions.g(zzakVar.a);
                Preconditions.a(zzakVar.a.equals(zzmVar.f18234f));
                zzbr.zzg.zza I = zzbr.zzg.R0().w(1).I("android");
                if (!TextUtils.isEmpty(zzmVar.f18234f)) {
                    I.m0(zzmVar.f18234f);
                }
                if (!TextUtils.isEmpty(zzmVar.f18237i)) {
                    I.h0(zzmVar.f18237i);
                }
                if (!TextUtils.isEmpty(zzmVar.f18236h)) {
                    I.r0(zzmVar.f18236h);
                }
                long j3 = zzmVar.o;
                if (j3 != -2147483648L) {
                    I.t0((int) j3);
                }
                I.l0(zzmVar.f18238j);
                if (!TextUtils.isEmpty(zzmVar.f18235g)) {
                    I.F0(zzmVar.f18235g);
                }
                if (this.f18217j.y().r(zzap.r0)) {
                    if (TextUtils.isEmpty(I.I0()) && !TextUtils.isEmpty(zzmVar.w)) {
                        I.P0(zzmVar.w);
                    }
                } else if (!TextUtils.isEmpty(zzmVar.w)) {
                    I.P0(zzmVar.w);
                }
                long j4 = zzmVar.f18239k;
                if (j4 != 0) {
                    I.u0(j4);
                }
                I.E0(zzmVar.y);
                if (this.f18217j.y().B(zzmVar.f18234f, zzap.o0) && (X = Z().X()) != null) {
                    I.Z(X);
                }
                Pair<String, Boolean> v = this.f18217j.B().v(zzmVar.f18234f);
                if (v != null && !TextUtils.isEmpty((CharSequence) v.first)) {
                    if (zzmVar.t) {
                        I.v0((String) v.first);
                        Object obj = v.second;
                        if (obj != null) {
                            I.J(((Boolean) obj).booleanValue());
                        }
                    }
                } else if (!this.f18217j.S().u(this.f18217j.f()) && zzmVar.u) {
                    String string = Settings.Secure.getString(this.f18217j.f().getContentResolver(), "android_id");
                    if (string == null) {
                        this.f18217j.h().K().b("null secure ID. appId", zzet.x(I.C0()));
                        string = "null";
                    } else if (string.isEmpty()) {
                        this.f18217j.h().K().b("empty secure ID. appId", zzet.x(I.C0()));
                    }
                    I.L0(string);
                }
                this.f18217j.S().p();
                zzbr.zzg.zza V = I.V(Build.MODEL);
                this.f18217j.S().p();
                V.P(Build.VERSION.RELEASE).k0((int) this.f18217j.S().v()).a0(this.f18217j.S().w()).A0(zzmVar.q);
                if (this.f18217j.p() && zzx.X()) {
                    I.C0();
                    if (!TextUtils.isEmpty(str4)) {
                        I.O0(str4);
                    }
                }
                z3 j02 = W().j0(zzmVar.f18234f);
                if (j02 == null) {
                    j02 = new z3(this.f18217j, zzmVar.f18234f);
                    j02.c(this.f18217j.I().C0());
                    j02.F(zzmVar.p);
                    j02.r(zzmVar.f18235g);
                    j02.C(this.f18217j.B().y(zzmVar.f18234f));
                    j02.H(0L);
                    j02.a(0L);
                    j02.q(0L);
                    j02.I(zzmVar.f18236h);
                    j02.u(zzmVar.o);
                    j02.L(zzmVar.f18237i);
                    j02.y(zzmVar.f18238j);
                    j02.B(zzmVar.f18239k);
                    j02.e(zzmVar.m);
                    j02.c0(zzmVar.q);
                    j02.E(zzmVar.y);
                    W().O(j02);
                }
                if (!TextUtils.isEmpty(j02.x())) {
                    I.z0(j02.x());
                }
                if (!TextUtils.isEmpty(j02.M())) {
                    I.H0(j02.M());
                }
                List<m7> I2 = W().I(zzmVar.f18234f);
                for (int i2 = 0; i2 < I2.size(); i2++) {
                    zzbr.zzk.zza B = zzbr.zzk.X().C(I2.get(i2).f17873c).B(I2.get(i2).f17874d);
                    Z().K(B, I2.get(i2).f17875e);
                    I.F(B);
                }
                try {
                    z2 = W().z((zzbr.zzg) ((zzfd) I.y()));
                    W = W();
                    zzamVar = zzakVar.f18065f;
                } catch (IOException e2) {
                    this.f18217j.h().H().c("Data loss. Failed to insert raw event metadata. appId", zzet.x(I.C0()), e2);
                }
                if (zzamVar != null) {
                    Iterator<String> it = zzamVar.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String str5 = str3;
                            if (str5.equals(it.next())) {
                                break;
                            } else {
                                str3 = str5;
                            }
                        } else {
                            boolean E = S().E(zzakVar.a, zzakVar.f18061b);
                            zzab C2 = W().C(k0(), zzakVar.a, false, false, false, false, false);
                            if (E && C2.f18054e < this.f18217j.y().o(zzakVar.a)) {
                            }
                        }
                    }
                    z3 = true;
                    if (W.S(zzakVar, z2, z3)) {
                        this.n = 0L;
                    }
                    W().w();
                    if (this.f18217j.h().C(2)) {
                        this.f18217j.h().P().b("Event recorded", this.f18217j.J().v(zzakVar));
                    }
                    W().A0();
                    m0();
                    this.f18217j.h().P().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j2) + 500000) / 1000000));
                    return;
                }
                z3 = false;
                if (W.S(zzakVar, z2, z3)) {
                }
                W().w();
                if (this.f18217j.h().C(2)) {
                }
                W().A0();
                m0();
                this.f18217j.h().P().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j2) + 500000) / 1000000));
                return;
            }
            String p0 = zzanVar.f18068g.p0("currency");
            if ("ecommerce_purchase".equals(zzanVar.f18067f)) {
                double doubleValue = zzanVar.f18068g.i0("value").doubleValue() * 1000000.0d;
                if (doubleValue == 0.0d) {
                    double longValue2 = zzanVar.f18068g.e0("value").longValue();
                    Double.isNaN(longValue2);
                    doubleValue = longValue2 * 1000000.0d;
                }
                if (doubleValue <= 9.223372036854776E18d && doubleValue >= -9.223372036854776E18d) {
                    longValue = Math.round(doubleValue);
                } else {
                    this.f18217j.h().K().c("Data lost. Currency value is too big. appId", zzet.x(str2), Double.valueOf(doubleValue));
                    j2 = nanoTime;
                    z = false;
                    if (!z) {
                        W().w();
                        return;
                    }
                    boolean Y3 = zzkk.Y(zzanVar.f18067f);
                    boolean equals2 = "_err".equals(zzanVar.f18067f);
                    zzab C3 = W().C(k0(), str2, true, Y3, false, equals2, false);
                    intValue = C3.f18051b - zzap.r.a(null).intValue();
                    if (intValue > 0) {
                    }
                }
            } else {
                longValue = zzanVar.f18068g.e0("value").longValue();
            }
            if (!TextUtils.isEmpty(p0)) {
                String upperCase = p0.toUpperCase(Locale.US);
                if (upperCase.matches("[A-Z]{3}")) {
                    String concat = upperCase.length() != 0 ? "_ltv_".concat(upperCase) : new String("_ltv_");
                    m7 o02 = W().o0(str2, concat);
                    if (o02 != null) {
                        Object obj2 = o02.f17875e;
                        if (obj2 instanceof Long) {
                            j2 = nanoTime;
                            m7Var = new m7(str2, zzanVar.f18069h, concat, this.f18217j.j().a(), Long.valueOf(((Long) obj2).longValue() + longValue));
                            m7Var2 = m7Var;
                            if (!W().T(m7Var2)) {
                                this.f18217j.h().H().d("Too many unique user properties are set. Ignoring user property. appId", zzet.x(str2), this.f18217j.J().B(m7Var2.f17873c), m7Var2.f17875e);
                                this.f18217j.I().T(str2, 9, null, null, 0);
                            }
                            z = true;
                            if (!z) {
                            }
                            boolean Y32 = zzkk.Y(zzanVar.f18067f);
                            boolean equals22 = "_err".equals(zzanVar.f18067f);
                            zzab C32 = W().C(k0(), str2, true, Y32, false, equals22, false);
                            intValue = C32.f18051b - zzap.r.a(null).intValue();
                            if (intValue > 0) {
                            }
                        }
                    }
                    j2 = nanoTime;
                    c W2 = W();
                    int t = this.f18217j.y().t(str2, zzap.L) - 1;
                    Preconditions.g(str2);
                    W2.d();
                    W2.t();
                    W2.x().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str2, str2, String.valueOf(t)});
                    m7Var = new m7(str2, zzanVar.f18069h, concat, this.f18217j.j().a(), Long.valueOf(longValue));
                    m7Var2 = m7Var;
                    if (!W().T(m7Var2)) {
                    }
                    z = true;
                    if (!z) {
                    }
                    boolean Y322 = zzkk.Y(zzanVar.f18067f);
                    boolean equals222 = "_err".equals(zzanVar.f18067f);
                    zzab C322 = W().C(k0(), str2, true, Y322, false, equals222, false);
                    intValue = C322.f18051b - zzap.r.a(null).intValue();
                    if (intValue > 0) {
                    }
                }
            }
            j2 = nanoTime;
            z = true;
            if (!z) {
            }
            boolean Y3222 = zzkk.Y(zzanVar.f18067f);
            boolean equals2222 = "_err".equals(zzanVar.f18067f);
            zzab C3222 = W().C(k0(), str2, true, Y3222, false, equals2222, false);
            intValue = C3222.f18051b - zzap.r.a(null).intValue();
            if (intValue > 0) {
            }
        } finally {
            W().A0();
        }
    }

    private static void N(f7 f7Var) {
        if (f7Var != null) {
            if (f7Var.s()) {
                return;
            }
            String valueOf = String.valueOf(f7Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Upload Component not created");
    }

    @VisibleForTesting
    private final int a(FileChannel fileChannel) {
        j0();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    return allocate.getInt();
                }
                if (read != -1) {
                    this.f18217j.h().K().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            } catch (IOException e2) {
                this.f18217j.h().H().b("Failed to read from channel", e2);
                return 0;
            }
        }
        this.f18217j.h().H().a("Bad channel to read from");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final z3 b(zzm zzmVar, z3 z3Var, String str) {
        boolean z;
        long j2;
        String str2;
        long j3;
        boolean z2 = true;
        if (z3Var == null) {
            z3Var = new z3(this.f18217j, zzmVar.f18234f);
            z3Var.c(this.f18217j.I().C0());
            z3Var.C(str);
        } else if (!str.equals(z3Var.J())) {
            z3Var.C(str);
            z3Var.c(this.f18217j.I().C0());
        } else {
            z = false;
            if (!TextUtils.equals(zzmVar.f18235g, z3Var.A())) {
                z3Var.r(zzmVar.f18235g);
                z = true;
            }
            if (!TextUtils.equals(zzmVar.w, z3Var.D())) {
                z3Var.v(zzmVar.w);
                z = true;
            }
            if (zzky.b() && this.f18217j.y().B(z3Var.t(), zzap.N0) && !TextUtils.equals(zzmVar.A, z3Var.G())) {
                z3Var.z(zzmVar.A);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.p) && !zzmVar.p.equals(z3Var.M())) {
                z3Var.F(zzmVar.p);
                z = true;
            }
            j2 = zzmVar.f18238j;
            if (j2 != 0 && j2 != z3Var.Z()) {
                z3Var.y(zzmVar.f18238j);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.f18236h) && !zzmVar.f18236h.equals(z3Var.T())) {
                z3Var.I(zzmVar.f18236h);
                z = true;
            }
            if (zzmVar.o != z3Var.V()) {
                z3Var.u(zzmVar.o);
                z = true;
            }
            str2 = zzmVar.f18237i;
            if (str2 != null && !str2.equals(z3Var.X())) {
                z3Var.L(zzmVar.f18237i);
                z = true;
            }
            if (zzmVar.f18239k != z3Var.b0()) {
                z3Var.B(zzmVar.f18239k);
                z = true;
            }
            if (zzmVar.m != z3Var.e0()) {
                z3Var.e(zzmVar.m);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.l) && !zzmVar.l.equals(z3Var.i())) {
                z3Var.O(zzmVar.l);
                z = true;
            }
            if (zzmVar.q != z3Var.k()) {
                z3Var.c0(zzmVar.q);
                z = true;
            }
            if (zzmVar.t != z3Var.l()) {
                z3Var.s(zzmVar.t);
                z = true;
            }
            if (zzmVar.u != z3Var.m()) {
                z3Var.w(zzmVar.u);
                z = true;
            }
            if (this.f18217j.y().B(zzmVar.f18234f, zzap.k0) && zzmVar.x != z3Var.n()) {
                z3Var.b(zzmVar.x);
                z = true;
            }
            j3 = zzmVar.y;
            if (j3 != 0 || j3 == z3Var.d0()) {
                z2 = z;
            } else {
                z3Var.E(zzmVar.y);
            }
            if (z2) {
                W().O(z3Var);
            }
            return z3Var;
        }
        z = true;
        if (!TextUtils.equals(zzmVar.f18235g, z3Var.A())) {
        }
        if (!TextUtils.equals(zzmVar.w, z3Var.D())) {
        }
        if (zzky.b()) {
            z3Var.z(zzmVar.A);
            z = true;
        }
        if (!TextUtils.isEmpty(zzmVar.p)) {
            z3Var.F(zzmVar.p);
            z = true;
        }
        j2 = zzmVar.f18238j;
        if (j2 != 0) {
            z3Var.y(zzmVar.f18238j);
            z = true;
        }
        if (!TextUtils.isEmpty(zzmVar.f18236h)) {
            z3Var.I(zzmVar.f18236h);
            z = true;
        }
        if (zzmVar.o != z3Var.V()) {
        }
        str2 = zzmVar.f18237i;
        if (str2 != null) {
            z3Var.L(zzmVar.f18237i);
            z = true;
        }
        if (zzmVar.f18239k != z3Var.b0()) {
        }
        if (zzmVar.m != z3Var.e0()) {
        }
        if (!TextUtils.isEmpty(zzmVar.l)) {
            z3Var.O(zzmVar.l);
            z = true;
        }
        if (zzmVar.q != z3Var.k()) {
        }
        if (zzmVar.t != z3Var.l()) {
        }
        if (zzmVar.u != z3Var.m()) {
        }
        if (this.f18217j.y().B(zzmVar.f18234f, zzap.k0)) {
            z3Var.b(zzmVar.x);
            z = true;
        }
        j3 = zzmVar.y;
        if (j3 != 0) {
        }
        z2 = z;
        if (z2) {
        }
        return z3Var;
    }

    public static zzkc c(Context context) {
        Preconditions.k(context);
        Preconditions.k(context.getApplicationContext());
        if (a == null) {
            synchronized (zzkc.class) {
                if (a == null) {
                    a = new zzkc(new zzkh(context));
                }
            }
        }
        return a;
    }

    private final zzm d(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j2, String str3, String str4) {
        String str5;
        String str6;
        int i2;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.f18217j.h().H().a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            this.f18217j.h().H().b("Error retrieving installer package name. appId", zzet.x(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str5 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str7 = str5;
        try {
            PackageInfo e2 = Wrappers.a(context).e(str, 0);
            if (e2 != null) {
                CharSequence d2 = Wrappers.a(context).d(str);
                if (!TextUtils.isEmpty(d2)) {
                    d2.toString();
                }
                str6 = e2.versionName;
                i2 = e2.versionCode;
            } else {
                str6 = "Unknown";
                i2 = Integer.MIN_VALUE;
            }
            this.f18217j.G();
            return new zzm(str, str2, str6, i2, str7, this.f18217j.y().C(), this.f18217j.I().w(context, str), (String) null, z, false, HttpUrl.FRAGMENT_ENCODE_SET, 0L, this.f18217j.y().K(str) ? j2 : 0L, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null, (zzky.b() && this.f18217j.y().B(str, zzap.N0)) ? str4 : null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.f18217j.h().H().c("Error retrieving newly installed package info. appId, appName", zzet.x(str), "Unknown");
            return null;
        }
    }

    private final zzm e(String str) {
        z3 j0 = W().j0(str);
        if (j0 != null && !TextUtils.isEmpty(j0.T())) {
            Boolean K = K(j0);
            if (K != null && !K.booleanValue()) {
                this.f18217j.h().H().b("App version does not match; dropping. appId", zzet.x(str));
                return null;
            }
            return new zzm(str, j0.A(), j0.T(), j0.V(), j0.X(), j0.Z(), j0.b0(), (String) null, j0.e0(), false, j0.M(), j0.k(), 0L, 0, j0.l(), j0.m(), false, j0.D(), j0.n(), j0.d0(), j0.o(), (zzky.b() && this.f18217j.y().B(str, zzap.N0)) ? j0.G() : null);
        }
        this.f18217j.h().O().b("No app data available; dropping", str);
        return null;
    }

    private final p3 h0() {
        p3 p3Var = this.f18212e;
        if (p3Var != null) {
            return p3Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjy i0() {
        N(this.f18213f);
        return this.f18213f;
    }

    private final void j0() {
        this.f18217j.g().d();
    }

    private final long k0() {
        long a2 = this.f18217j.j().a();
        r3 B = this.f18217j.B();
        B.p();
        B.d();
        long a3 = B.f17926j.a();
        if (a3 == 0) {
            a3 = 1 + B.l().z0().nextInt(86400000);
            B.f17926j.b(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    @VisibleForTesting
    private static void l(zzbr.zzc.zza zzaVar, int i2, String str) {
        List<zzbr.zze> G = zzaVar.G();
        for (int i3 = 0; i3 < G.size(); i3++) {
            if ("_err".equals(G.get(i3).B())) {
                return;
            }
        }
        zzaVar.D((zzbr.zze) ((zzfd) zzbr.zze.T().C("_err").B(Long.valueOf(i2).longValue()).y())).D((zzbr.zze) ((zzfd) zzbr.zze.T().C("_ev").E(str).y()));
    }

    private final boolean l0() {
        j0();
        c0();
        return W().F0() || !TextUtils.isEmpty(W().y());
    }

    @VisibleForTesting
    private static void m(zzbr.zzc.zza zzaVar, String str) {
        List<zzbr.zze> G = zzaVar.G();
        for (int i2 = 0; i2 < G.size(); i2++) {
            if (str.equals(G.get(i2).B())) {
                zzaVar.I(i2);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m0() {
        long max;
        long j2;
        j0();
        c0();
        if (!I() && !this.f18217j.y().r(zzap.n0)) {
            return;
        }
        if (this.n > 0) {
            long abs = 3600000 - Math.abs(this.f18217j.j().b() - this.n);
            if (abs > 0) {
                this.f18217j.h().P().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                h0().c();
                i0().x();
                return;
            }
            this.n = 0L;
        }
        if (this.f18217j.u() && l0()) {
            long a2 = this.f18217j.j().a();
            long max2 = Math.max(0L, zzap.H.a(null).longValue());
            boolean z = W().G0() || W().B0();
            if (z) {
                String V = this.f18217j.y().V();
                if (!TextUtils.isEmpty(V) && !".none.".equals(V)) {
                    max = Math.max(0L, zzap.C.a(null).longValue());
                } else {
                    max = Math.max(0L, zzap.B.a(null).longValue());
                }
            } else {
                max = Math.max(0L, zzap.A.a(null).longValue());
            }
            long a3 = this.f18217j.B().f17922f.a();
            long a4 = this.f18217j.B().f17923g.a();
            long j3 = max;
            long max3 = Math.max(W().D0(), W().E0());
            if (max3 != 0) {
                long abs2 = a2 - Math.abs(max3 - a2);
                long abs3 = a2 - Math.abs(a3 - a2);
                long abs4 = a2 - Math.abs(a4 - a2);
                long max4 = Math.max(abs3, abs4);
                j2 = abs2 + max2;
                if (z && max4 > 0) {
                    j2 = Math.min(abs2, max4) + j3;
                }
                if (!Z().Q(max4, j3)) {
                    j2 = max4 + j3;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    for (int i2 = 0; i2 < Math.min(20, Math.max(0, zzap.J.a(null).intValue())); i2++) {
                        j2 += Math.max(0L, zzap.I.a(null).longValue()) * (1 << i2);
                        if (j2 > abs4) {
                            break;
                        }
                    }
                }
                if (j2 != 0) {
                    this.f18217j.h().P().a("Next upload time is 0");
                    h0().c();
                    i0().x();
                    return;
                }
                if (!U().z()) {
                    this.f18217j.h().P().a("No network");
                    h0().b();
                    i0().x();
                    return;
                }
                long a5 = this.f18217j.B().f17924h.a();
                long max5 = Math.max(0L, zzap.y.a(null).longValue());
                if (!Z().Q(a5, max5)) {
                    j2 = Math.max(j2, a5 + max5);
                }
                h0().c();
                long a6 = j2 - this.f18217j.j().a();
                if (a6 <= 0) {
                    a6 = Math.max(0L, zzap.D.a(null).longValue());
                    this.f18217j.B().f17922f.b(this.f18217j.j().a());
                }
                this.f18217j.h().P().b("Upload scheduled in approximately ms", Long.valueOf(a6));
                i0().w(a6);
                return;
            }
            j2 = 0;
            if (j2 != 0) {
            }
        } else {
            this.f18217j.h().P().a("Nothing to upload or uploading impossible");
            h0().c();
            i0().x();
        }
    }

    private static void n(zzbr.zzg.zza zzaVar) {
        zzaVar.N(Long.MAX_VALUE).T(Long.MIN_VALUE);
        for (int i2 = 0; i2 < zzaVar.L(); i2++) {
            zzbr.zzc M = zzaVar.M(i2);
            if (M.W() < zzaVar.j0()) {
                zzaVar.N(M.W());
            }
            if (M.W() > zzaVar.n0()) {
                zzaVar.T(M.W());
            }
        }
    }

    @VisibleForTesting
    private final void o(zzbr.zzg.zza zzaVar, long j2, boolean z) {
        m7 m7Var;
        String str = z ? "_se" : "_lte";
        m7 o0 = W().o0(zzaVar.C0(), str);
        if (o0 != null && o0.f17875e != null) {
            m7Var = new m7(zzaVar.C0(), "auto", str, this.f18217j.j().a(), Long.valueOf(((Long) o0.f17875e).longValue() + j2));
        } else {
            m7Var = new m7(zzaVar.C0(), "auto", str, this.f18217j.j().a(), Long.valueOf(j2));
        }
        zzbr.zzk zzkVar = (zzbr.zzk) ((zzfd) zzbr.zzk.X().C(str).B(this.f18217j.j().a()).E(((Long) m7Var.f17875e).longValue()).y());
        boolean z2 = false;
        int w = zzkg.w(zzaVar, str);
        if (w >= 0) {
            zzaVar.B(w, zzkVar);
            z2 = true;
        }
        if (!z2) {
            zzaVar.G(zzkVar);
        }
        if (j2 > 0) {
            W().T(m7Var);
            this.f18217j.h().O().c("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", m7Var.f17875e);
        }
    }

    private final void r(z3 z3Var) {
        j0();
        if (TextUtils.isEmpty(z3Var.A()) && TextUtils.isEmpty(z3Var.D())) {
            A(z3Var.t(), 204, null, null, null);
            return;
        }
        zzx y = this.f18217j.y();
        Uri.Builder builder = new Uri.Builder();
        String A = z3Var.A();
        if (TextUtils.isEmpty(A)) {
            A = z3Var.D();
        }
        c.e.a aVar = null;
        Uri.Builder encodedAuthority = builder.scheme(zzap.l.a(null)).encodedAuthority(zzap.m.a(null));
        String valueOf = String.valueOf(A);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", z3Var.x()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(y.C()));
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            this.f18217j.h().P().b("Fetching remote configuration", z3Var.t());
            zzbo.zzb w = S().w(z3Var.t());
            String B = S().B(z3Var.t());
            if (w != null && !TextUtils.isEmpty(B)) {
                aVar = new c.e.a();
                aVar.put("If-Modified-Since", B);
            }
            this.r = true;
            zzex U = U();
            String t = z3Var.t();
            j7 j7Var = new j7(this);
            U.d();
            U.t();
            Preconditions.k(url);
            Preconditions.k(j7Var);
            U.g().C(new m3(U, t, url, null, aVar, j7Var));
        } catch (MalformedURLException unused) {
            this.f18217j.h().H().c("Failed to parse config URL. Not fetching. appId", zzet.x(z3Var.t()), uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(zzkh zzkhVar) {
        this.f18217j.g().d();
        c cVar = new c(this);
        cVar.u();
        this.f18211d = cVar;
        this.f18217j.y().q(this.f18209b);
        q7 q7Var = new q7(this);
        q7Var.u();
        this.f18214g = q7Var;
        s5 s5Var = new s5(this);
        s5Var.u();
        this.f18216i = s5Var;
        zzjy zzjyVar = new zzjy(this);
        zzjyVar.u();
        this.f18213f = zzjyVar;
        this.f18212e = new p3(this);
        if (this.p != this.q) {
            this.f18217j.h().H().c("Not all upload components initialized", Integer.valueOf(this.p), Integer.valueOf(this.q));
        }
        this.f18218k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r6.f18217j.B().f17924h.b(r6.f18217j.j().a());
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        j0();
        c0();
        Preconditions.g(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.r = false;
                F();
            }
        }
        this.f18217j.h().P().b("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        W().w0();
        try {
            z3 j0 = W().j0(str);
            boolean z = true;
            boolean z2 = (i2 == 200 || i2 == 204 || i2 == 304) && th == null;
            if (j0 == null) {
                this.f18217j.h().K().b("App does not exist in onConfigFetched. appId", zzet.x(str));
            } else {
                if (!z2 && i2 != 404) {
                    j0.N(this.f18217j.j().a());
                    W().O(j0);
                    this.f18217j.h().P().c("Fetching config failed. code, error", Integer.valueOf(i2), th);
                    S().D(str);
                    this.f18217j.B().f17923g.b(this.f18217j.j().a());
                    if (i2 != 503 && i2 != 429) {
                        z = false;
                    }
                    m0();
                }
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i2 != 404 && i2 != 304) {
                    if (!S().A(str, bArr, str2)) {
                        return;
                    }
                    j0.K(this.f18217j.j().a());
                    W().O(j0);
                    if (i2 != 404) {
                        this.f18217j.h().M().b("Config not found. Using empty config. appId", str);
                    } else {
                        this.f18217j.h().P().c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                    }
                    if (!U().z() && l0()) {
                        d0();
                    } else {
                        m0();
                    }
                }
                if (S().w(str) == null && !S().A(str, null, null)) {
                    return;
                }
                j0.K(this.f18217j.j().a());
                W().O(j0);
                if (i2 != 404) {
                }
                if (!U().z()) {
                }
                m0();
            }
            W().w();
        } finally {
            W().A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(boolean z) {
        m0();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzw G() {
        return this.f18217j.G();
    }

    public final zzx J() {
        return this.f18217j.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(zzkj zzkjVar, zzm zzmVar) {
        j0();
        c0();
        if (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) {
            return;
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        if (this.f18217j.y().B(zzmVar.f18234f, zzap.k0)) {
            if ("_npa".equals(zzkjVar.f18224g) && zzmVar.x != null) {
                this.f18217j.h().O().a("Falling back to manifest metadata value for ad personalization");
                v(new zzkj("_npa", this.f18217j.j().a(), Long.valueOf(zzmVar.x.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                return;
            }
            this.f18217j.h().O().b("Removing user property", this.f18217j.J().B(zzkjVar.f18224g));
            W().w0();
            try {
                T(zzmVar);
                W().m0(zzmVar.f18234f, zzkjVar.f18224g);
                W().w();
                this.f18217j.h().O().b("User property removed", this.f18217j.J().B(zzkjVar.f18224g));
                return;
            } finally {
            }
        }
        this.f18217j.h().O().b("Removing user property", this.f18217j.J().B(zzkjVar.f18224g));
        W().w0();
        try {
            T(zzmVar);
            W().m0(zzmVar.f18234f, zzkjVar.f18224g);
            W().w();
            this.f18217j.h().O().b("User property removed", this.f18217j.J().B(zzkjVar.f18224g));
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:108|109|(2:111|(8:113|(3:115|(2:117|(1:119))(1:138)|120)(1:139)|121|(1:123)(1:137)|124|125|126|(4:128|(1:130)|131|(1:133))))|140|125|126|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03be, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03bf, code lost:
    
        r21.f18217j.h().H().c("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.zzet.x(r22.f18234f), r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03d7 A[Catch: all -> 0x04d5, TryCatch #0 {all -> 0x04d5, blocks: (B:30:0x00b9, B:32:0x00c9, B:34:0x00d7, B:36:0x00e1, B:38:0x00e5, B:41:0x00f6, B:43:0x010e, B:45:0x0136, B:47:0x0142, B:49:0x0159, B:51:0x0181, B:53:0x01cb, B:57:0x01de, B:59:0x01f2, B:61:0x01fd, B:64:0x020c, B:66:0x0214, B:68:0x021a, B:71:0x0229, B:73:0x022c, B:74:0x0250, B:76:0x0255, B:78:0x0275, B:81:0x0289, B:83:0x02aa, B:84:0x02b8, B:86:0x02e9, B:87:0x02f1, B:89:0x02f5, B:90:0x02f8, B:92:0x0319, B:96:0x03f3, B:97:0x03f6, B:98:0x0465, B:100:0x0475, B:102:0x048d, B:103:0x0494, B:104:0x04c6, B:109:0x0332, B:111:0x035d, B:113:0x0365, B:115:0x036d, B:119:0x0381, B:121:0x038f, B:124:0x039a, B:126:0x03ac, B:136:0x03bf, B:128:0x03d7, B:130:0x03dd, B:131:0x03e2, B:133:0x03e8, B:138:0x0387, B:143:0x0345, B:147:0x040e, B:149:0x0442, B:150:0x044a, B:152:0x044e, B:153:0x0451, B:155:0x04a9, B:157:0x04ad, B:160:0x0265, B:166:0x0118, B:170:0x0122), top: B:29:0x00b9, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022c A[Catch: all -> 0x04d5, TryCatch #0 {all -> 0x04d5, blocks: (B:30:0x00b9, B:32:0x00c9, B:34:0x00d7, B:36:0x00e1, B:38:0x00e5, B:41:0x00f6, B:43:0x010e, B:45:0x0136, B:47:0x0142, B:49:0x0159, B:51:0x0181, B:53:0x01cb, B:57:0x01de, B:59:0x01f2, B:61:0x01fd, B:64:0x020c, B:66:0x0214, B:68:0x021a, B:71:0x0229, B:73:0x022c, B:74:0x0250, B:76:0x0255, B:78:0x0275, B:81:0x0289, B:83:0x02aa, B:84:0x02b8, B:86:0x02e9, B:87:0x02f1, B:89:0x02f5, B:90:0x02f8, B:92:0x0319, B:96:0x03f3, B:97:0x03f6, B:98:0x0465, B:100:0x0475, B:102:0x048d, B:103:0x0494, B:104:0x04c6, B:109:0x0332, B:111:0x035d, B:113:0x0365, B:115:0x036d, B:119:0x0381, B:121:0x038f, B:124:0x039a, B:126:0x03ac, B:136:0x03bf, B:128:0x03d7, B:130:0x03dd, B:131:0x03e2, B:133:0x03e8, B:138:0x0387, B:143:0x0345, B:147:0x040e, B:149:0x0442, B:150:0x044a, B:152:0x044e, B:153:0x0451, B:155:0x04a9, B:157:0x04ad, B:160:0x0265, B:166:0x0118, B:170:0x0122), top: B:29:0x00b9, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(zzm zzmVar) {
        String str;
        int i2;
        String str2;
        h D;
        long j2;
        long j3;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        boolean z2;
        m7 o0;
        j0();
        c0();
        Preconditions.k(zzmVar);
        Preconditions.g(zzmVar.f18234f);
        if (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) {
            return;
        }
        z3 j0 = W().j0(zzmVar.f18234f);
        if (j0 != null && TextUtils.isEmpty(j0.A()) && !TextUtils.isEmpty(zzmVar.f18235g)) {
            j0.K(0L);
            W().O(j0);
            S().H(zzmVar.f18234f);
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        long j4 = zzmVar.r;
        if (j4 == 0) {
            j4 = this.f18217j.j().a();
        }
        if (this.f18217j.y().B(zzmVar.f18234f, zzap.k0)) {
            this.f18217j.S().y();
        }
        int i3 = zzmVar.s;
        if (i3 != 0 && i3 != 1) {
            this.f18217j.h().K().c("Incorrect app type, assuming installed app. appId, appType", zzet.x(zzmVar.f18234f), Integer.valueOf(i3));
            i3 = 0;
        }
        W().w0();
        try {
            if (!this.f18217j.y().B(zzmVar.f18234f, zzap.k0) || ((o0 = W().o0(zzmVar.f18234f, "_npa")) != null && !"auto".equals(o0.f17872b))) {
                str = "_sysu";
                i2 = 1;
            } else if (zzmVar.x != null) {
                str = "_sysu";
                i2 = 1;
                zzkj zzkjVar = new zzkj("_npa", j4, Long.valueOf(zzmVar.x.booleanValue() ? 1L : 0L), "auto");
                if (o0 == null || !o0.f17875e.equals(zzkjVar.f18226i)) {
                    v(zzkjVar, zzmVar);
                }
            } else {
                str = "_sysu";
                i2 = 1;
                if (o0 != null) {
                    O(new zzkj("_npa", j4, null, "auto"), zzmVar);
                }
            }
            z3 j02 = W().j0(zzmVar.f18234f);
            if (j02 != null) {
                this.f18217j.I();
                if (zzkk.d0(zzmVar.f18235g, j02.A(), zzmVar.w, j02.D())) {
                    this.f18217j.h().K().b("New GMP App Id passed in. Removing cached database data. appId", zzet.x(j02.t()));
                    c W = W();
                    String t = j02.t();
                    W.t();
                    W.d();
                    Preconditions.g(t);
                    try {
                        SQLiteDatabase x = W.x();
                        String[] strArr = new String[i2];
                        strArr[0] = t;
                        int delete = x.delete("events", "app_id=?", strArr) + 0 + x.delete("user_attributes", "app_id=?", strArr) + x.delete("conditional_properties", "app_id=?", strArr) + x.delete(DeepLinkIntentReceiver.DeepLinksTargets.APPS, "app_id=?", strArr) + x.delete("raw_events", "app_id=?", strArr) + x.delete("raw_events_metadata", "app_id=?", strArr) + x.delete("event_filters", "app_id=?", strArr) + x.delete("property_filters", "app_id=?", strArr) + x.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            W.h().P().c("Deleted application data. app, records", t, Integer.valueOf(delete));
                        }
                    } catch (SQLiteException e2) {
                        W.h().H().c("Error deleting application data. appId, error", zzet.x(t), e2);
                    }
                    j02 = null;
                }
            }
            if (j02 != null) {
                if (j02.V() != -2147483648L) {
                    str2 = "_sys";
                    if (j02.V() != zzmVar.o) {
                        z2 = true;
                        if (z2 | ((j02.V() == -2147483648L || j02.T() == null || j02.T().equals(zzmVar.f18236h)) ? false : true)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", j02.T());
                            p(new zzan("_au", new zzam(bundle), "auto", j4), zzmVar);
                        }
                    }
                } else {
                    str2 = "_sys";
                }
                z2 = false;
                if (z2 | ((j02.V() == -2147483648L || j02.T() == null || j02.T().equals(zzmVar.f18236h)) ? false : true)) {
                }
            } else {
                str2 = "_sys";
            }
            T(zzmVar);
            if (i3 == 0) {
                D = W().D(zzmVar.f18234f, "_f");
            } else {
                D = i3 == 1 ? W().D(zzmVar.f18234f, "_v") : null;
            }
            if (D == null) {
                long j5 = ((j4 / 3600000) + 1) * 3600000;
                if (i3 == 0) {
                    v(new zzkj("_fot", j4, Long.valueOf(j5), "auto"), zzmVar);
                    if (this.f18217j.y().M(zzmVar.f18235g)) {
                        j0();
                        this.f18217j.E().b(zzmVar.f18234f);
                    }
                    j0();
                    c0();
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("_c", 1L);
                    bundle2.putLong("_r", 1L);
                    bundle2.putLong("_uwa", 0L);
                    bundle2.putLong("_pfo", 0L);
                    bundle2.putLong(str2, 0L);
                    String str4 = str;
                    bundle2.putLong(str4, 0L);
                    if (this.f18217j.y().T(zzmVar.f18234f)) {
                        j3 = 1;
                        bundle2.putLong("_et", 1L);
                    } else {
                        j3 = 1;
                    }
                    if (zzmVar.v) {
                        bundle2.putLong("_dac", j3);
                    }
                    c W2 = W();
                    String str5 = zzmVar.f18234f;
                    Preconditions.g(str5);
                    W2.d();
                    W2.t();
                    long z0 = W2.z0(str5, "first_open_count");
                    if (this.f18217j.f().getPackageManager() == null) {
                        this.f18217j.h().H().b("PackageManager is null, first open report might be inaccurate. appId", zzet.x(zzmVar.f18234f));
                    } else {
                        try {
                            packageInfo = Wrappers.a(this.f18217j.f()).e(zzmVar.f18234f, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            this.f18217j.h().H().c("Package info is null, first open report might be inaccurate. appId", zzet.x(zzmVar.f18234f), e3);
                            packageInfo = null;
                        }
                        if (packageInfo != null) {
                            long j6 = packageInfo.firstInstallTime;
                            if (j6 != 0) {
                                if (j6 != packageInfo.lastUpdateTime) {
                                    if (!this.f18217j.y().r(zzap.T0)) {
                                        bundle2.putLong("_uwa", 1L);
                                    } else if (z0 == 0) {
                                        bundle2.putLong("_uwa", 1L);
                                    }
                                    z = false;
                                } else {
                                    z = true;
                                }
                                str3 = str4;
                                v(new zzkj("_fi", j4, Long.valueOf(z ? 1L : 0L), "auto"), zzmVar);
                                applicationInfo = Wrappers.a(this.f18217j.f()).c(zzmVar.f18234f, 0);
                                if (applicationInfo != null) {
                                    if ((applicationInfo.flags & 1) != 0) {
                                        bundle2.putLong(str2, 1L);
                                    }
                                    if ((applicationInfo.flags & 128) != 0) {
                                        bundle2.putLong(str3, 1L);
                                    }
                                }
                            }
                        }
                        str3 = str4;
                        applicationInfo = Wrappers.a(this.f18217j.f()).c(zzmVar.f18234f, 0);
                        if (applicationInfo != null) {
                        }
                    }
                    if (z0 >= 0) {
                        bundle2.putLong("_pfo", z0);
                    }
                    p(new zzan("_f", new zzam(bundle2), "auto", j4), zzmVar);
                } else if (i3 == 1) {
                    v(new zzkj("_fvt", j4, Long.valueOf(j5), "auto"), zzmVar);
                    j0();
                    c0();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1L);
                    bundle3.putLong("_r", 1L);
                    if (this.f18217j.y().T(zzmVar.f18234f)) {
                        j2 = 1;
                        bundle3.putLong("_et", 1L);
                    } else {
                        j2 = 1;
                    }
                    if (zzmVar.v) {
                        bundle3.putLong("_dac", j2);
                    }
                    p(new zzan("_v", new zzam(bundle3), "auto", j4), zzmVar);
                }
                if (!this.f18217j.y().B(zzmVar.f18234f, zzap.j0)) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("_et", 1L);
                    if (this.f18217j.y().T(zzmVar.f18234f)) {
                        bundle4.putLong("_fr", 1L);
                    }
                    p(new zzan("_e", new zzam(bundle4), "auto", j4), zzmVar);
                }
            } else if (zzmVar.n) {
                p(new zzan("_cd", new zzam(new Bundle()), "auto", j4), zzmVar);
            }
            W().w();
        } finally {
            W().A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(zzv zzvVar) {
        zzm e2 = e(zzvVar.f18240f);
        if (e2 != null) {
            R(zzvVar, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void R(zzv zzvVar, zzm zzmVar) {
        Preconditions.k(zzvVar);
        Preconditions.g(zzvVar.f18240f);
        Preconditions.k(zzvVar.f18242h);
        Preconditions.g(zzvVar.f18242h.f18224g);
        j0();
        c0();
        if (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) {
            return;
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        W().w0();
        try {
            T(zzmVar);
            zzv q0 = W().q0(zzvVar.f18240f, zzvVar.f18242h.f18224g);
            if (q0 != null) {
                this.f18217j.h().O().c("Removing conditional user property", zzvVar.f18240f, this.f18217j.J().B(zzvVar.f18242h.f18224g));
                W().s0(zzvVar.f18240f, zzvVar.f18242h.f18224g);
                if (q0.f18244j) {
                    W().m0(zzvVar.f18240f, zzvVar.f18242h.f18224g);
                }
                zzan zzanVar = zzvVar.p;
                if (zzanVar != null) {
                    zzam zzamVar = zzanVar.f18068g;
                    Bundle Y = zzamVar != null ? zzamVar.Y() : null;
                    zzkk I = this.f18217j.I();
                    String str = zzvVar.f18240f;
                    zzan zzanVar2 = zzvVar.p;
                    M(I.C(str, zzanVar2.f18067f, Y, q0.f18241g, zzanVar2.f18070i, true, false), zzmVar);
                }
            } else {
                this.f18217j.h().K().c("Conditional user property doesn't exist", zzet.x(zzvVar.f18240f), this.f18217j.J().B(zzvVar.f18242h.f18224g));
            }
            W().w();
        } finally {
            W().A0();
        }
    }

    public final zzfr S() {
        N(this.f18209b);
        return this.f18209b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final z3 T(zzm zzmVar) {
        j0();
        c0();
        Preconditions.k(zzmVar);
        Preconditions.g(zzmVar.f18234f);
        z3 j0 = W().j0(zzmVar.f18234f);
        String y = this.f18217j.B().y(zzmVar.f18234f);
        if (zzkm.b() && zzap.V0.a(null).booleanValue()) {
            if (j0 == null) {
                j0 = new z3(this.f18217j, zzmVar.f18234f);
                j0.c(this.f18217j.I().C0());
                j0.C(y);
            } else if (!y.equals(j0.J())) {
                j0.C(y);
                j0.c(this.f18217j.I().C0());
            }
            j0.r(zzmVar.f18235g);
            j0.v(zzmVar.w);
            if (zzky.b() && this.f18217j.y().B(j0.t(), zzap.N0)) {
                j0.z(zzmVar.A);
            }
            if (!TextUtils.isEmpty(zzmVar.p)) {
                j0.F(zzmVar.p);
            }
            long j2 = zzmVar.f18238j;
            if (j2 != 0) {
                j0.y(j2);
            }
            if (!TextUtils.isEmpty(zzmVar.f18236h)) {
                j0.I(zzmVar.f18236h);
            }
            j0.u(zzmVar.o);
            String str = zzmVar.f18237i;
            if (str != null) {
                j0.L(str);
            }
            j0.B(zzmVar.f18239k);
            j0.e(zzmVar.m);
            if (!TextUtils.isEmpty(zzmVar.l)) {
                j0.O(zzmVar.l);
            }
            j0.c0(zzmVar.q);
            j0.s(zzmVar.t);
            j0.w(zzmVar.u);
            if (this.f18217j.y().B(zzmVar.f18234f, zzap.k0)) {
                j0.b(zzmVar.x);
            }
            j0.E(zzmVar.y);
            if (j0.f()) {
                W().O(j0);
            }
            return j0;
        }
        return b(zzmVar, j0, y);
    }

    public final zzex U() {
        N(this.f18210c);
        return this.f18210c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String V(zzm zzmVar) {
        try {
            return (String) this.f18217j.g().w(new l7(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.f18217j.h().H().c("Failed to get app instance id. appId", zzet.x(zzmVar.f18234f), e2);
            return null;
        }
    }

    public final c W() {
        N(this.f18211d);
        return this.f18211d;
    }

    public final q7 X() {
        N(this.f18214g);
        return this.f18214g;
    }

    public final s5 Y() {
        N(this.f18216i);
        return this.f18216i;
    }

    public final zzkg Z() {
        N(this.f18215h);
        return this.f18215h;
    }

    public final zzer a0() {
        return this.f18217j.J();
    }

    public final zzkk b0() {
        return this.f18217j.I();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c0() {
        if (!this.f18218k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d0() {
        z3 j0;
        String str;
        j0();
        c0();
        this.t = true;
        try {
            this.f18217j.G();
            Boolean a0 = this.f18217j.R().a0();
            if (a0 == null) {
                this.f18217j.h().K().a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (a0.booleanValue()) {
                this.f18217j.h().H().a("Upload called in the client side when service should be used");
                return;
            }
            if (this.n > 0) {
                m0();
                return;
            }
            j0();
            if (this.w != null) {
                this.f18217j.h().P().a("Uploading requested multiple times");
                return;
            }
            if (!U().z()) {
                this.f18217j.h().P().a("Network not connected, ignoring upload request");
                m0();
                return;
            }
            long a2 = this.f18217j.j().a();
            E(null, a2 - zzx.U());
            long a3 = this.f18217j.B().f17922f.a();
            if (a3 != 0) {
                this.f18217j.h().O().b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a2 - a3)));
            }
            String y = W().y();
            if (!TextUtils.isEmpty(y)) {
                if (this.y == -1) {
                    this.y = W().Y();
                }
                List<Pair<zzbr.zzg, Long>> J = W().J(y, this.f18217j.y().t(y, zzap.n), Math.max(0, this.f18217j.y().t(y, zzap.o)));
                if (!J.isEmpty()) {
                    Iterator<Pair<zzbr.zzg, Long>> it = J.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        zzbr.zzg zzgVar = (zzbr.zzg) it.next().first;
                        if (!TextUtils.isEmpty(zzgVar.d0())) {
                            str = zzgVar.d0();
                            break;
                        }
                    }
                    if (str != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= J.size()) {
                                break;
                            }
                            zzbr.zzg zzgVar2 = (zzbr.zzg) J.get(i2).first;
                            if (!TextUtils.isEmpty(zzgVar2.d0()) && !zzgVar2.d0().equals(str)) {
                                J = J.subList(0, i2);
                                break;
                            }
                            i2++;
                        }
                    }
                    zzbr.zzf.zza F = zzbr.zzf.F();
                    int size = J.size();
                    ArrayList arrayList = new ArrayList(J.size());
                    boolean z = zzx.X() && this.f18217j.y().x(y);
                    for (int i3 = 0; i3 < size; i3++) {
                        zzbr.zzg.zza v = ((zzbr.zzg) J.get(i3).first).v();
                        arrayList.add((Long) J.get(i3).second);
                        zzbr.zzg.zza C = v.q0(this.f18217j.y().C()).C(a2);
                        this.f18217j.G();
                        C.Q(false);
                        if (!z) {
                            v.N0();
                        }
                        if (this.f18217j.y().B(y, zzap.q0)) {
                            v.G0(Z().x(((zzbr.zzg) ((zzfd) v.y())).j()));
                        }
                        F.w(v);
                    }
                    String D = this.f18217j.h().C(2) ? Z().D((zzbr.zzf) ((zzfd) F.y())) : null;
                    Z();
                    byte[] j2 = ((zzbr.zzf) ((zzfd) F.y())).j();
                    String a4 = zzap.x.a(null);
                    try {
                        URL url = new URL(a4);
                        Preconditions.a(!arrayList.isEmpty());
                        if (this.w != null) {
                            this.f18217j.h().H().a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList);
                        }
                        this.f18217j.B().f17923g.b(a2);
                        this.f18217j.h().P().d("Uploading data. app, uncompressed size, data", size > 0 ? F.A(0).L2() : "?", Integer.valueOf(j2.length), D);
                        this.s = true;
                        zzex U = U();
                        k7 k7Var = new k7(this, y);
                        U.d();
                        U.t();
                        Preconditions.k(url);
                        Preconditions.k(j2);
                        Preconditions.k(k7Var);
                        U.g().C(new m3(U, y, url, j2, null, k7Var));
                    } catch (MalformedURLException unused) {
                        this.f18217j.h().H().c("Failed to parse upload URL. Not uploading. appId", zzet.x(y), a4);
                    }
                }
            } else {
                this.y = -1L;
                String H = W().H(a2 - zzx.U());
                if (!TextUtils.isEmpty(H) && (j0 = W().j0(H)) != null) {
                    r(j0);
                }
            }
        } finally {
            this.t = false;
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e0() {
        j0();
        c0();
        if (!this.m) {
            this.m = true;
            j0();
            c0();
            if ((this.f18217j.y().r(zzap.n0) || I()) && H()) {
                int a2 = a(this.v);
                int F = this.f18217j.T().F();
                j0();
                if (a2 > F) {
                    this.f18217j.h().H().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                } else if (a2 < F) {
                    if (C(F, this.v)) {
                        this.f18217j.h().P().c("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                    } else {
                        this.f18217j.h().H().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                    }
                }
            }
        }
        if (this.l || this.f18217j.y().r(zzap.n0)) {
            return;
        }
        this.f18217j.h().N().a("This instance being marked as an uploader");
        this.l = true;
        m0();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final Context f() {
        return this.f18217j.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f0() {
        this.q++;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzfu g() {
        return this.f18217j.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfx g0() {
        return this.f18217j;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzet h() {
        return this.f18217j.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        this.f18217j.g().d();
        W().C0();
        if (this.f18217j.B().f17922f.a() == 0) {
            this.f18217j.B().f17922f.b(this.f18217j.j().a());
        }
        m0();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final Clock j() {
        return this.f18217j.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0156, code lost:
    
        r8.f18217j.B().f17924h.b(r8.f18217j.j().a());
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i2, Throwable th, byte[] bArr, String str) {
        c W;
        long longValue;
        j0();
        c0();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.s = false;
                F();
            }
        }
        List<Long> list = this.w;
        this.w = null;
        boolean z = true;
        if ((i2 == 200 || i2 == 204) && th == null) {
            try {
                this.f18217j.B().f17922f.b(this.f18217j.j().a());
                this.f18217j.B().f17923g.b(0L);
                m0();
                this.f18217j.h().P().c("Successful upload. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                W().w0();
                try {
                    for (Long l : list) {
                        try {
                            W = W();
                            longValue = l.longValue();
                            W.d();
                            W.t();
                            try {
                            } catch (SQLiteException e2) {
                                W.h().H().b("Failed to delete a bundle in a queue table", e2);
                                throw e2;
                                break;
                            }
                        } catch (SQLiteException e3) {
                            List<Long> list2 = this.x;
                            if (list2 == null || !list2.contains(l)) {
                                throw e3;
                            }
                        }
                        if (W.x().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                            break;
                        }
                    }
                    W().w();
                    W().A0();
                    this.x = null;
                    if (U().z() && l0()) {
                        d0();
                    } else {
                        this.y = -1L;
                        m0();
                    }
                    this.n = 0L;
                } catch (Throwable th2) {
                    W().A0();
                    throw th2;
                }
            } catch (SQLiteException e4) {
                this.f18217j.h().H().b("Database error while trying to delete uploaded bundles", e4);
                this.n = this.f18217j.j().b();
                this.f18217j.h().P().b("Disable upload, time", Long.valueOf(this.n));
            }
        } else {
            this.f18217j.h().P().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
            this.f18217j.B().f17923g.b(this.f18217j.j().a());
            if (i2 != 503 && i2 != 429) {
                z = false;
            }
            W().Q(list);
            m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(zzan zzanVar, zzm zzmVar) {
        List<zzv> L;
        List<zzv> L2;
        List<zzv> L3;
        List<String> list;
        zzan zzanVar2 = zzanVar;
        Preconditions.k(zzmVar);
        Preconditions.g(zzmVar.f18234f);
        j0();
        c0();
        String str = zzmVar.f18234f;
        long j2 = zzanVar2.f18070i;
        if (Z().R(zzanVar2, zzmVar)) {
            if (!zzmVar.m) {
                T(zzmVar);
                return;
            }
            if (this.f18217j.y().B(str, zzap.v0) && (list = zzmVar.z) != null) {
                if (list.contains(zzanVar2.f18067f)) {
                    Bundle Y = zzanVar2.f18068g.Y();
                    Y.putLong("ga_safelisted", 1L);
                    zzanVar2 = new zzan(zzanVar2.f18067f, new zzam(Y), zzanVar2.f18069h, zzanVar2.f18070i);
                } else {
                    this.f18217j.h().O().d("Dropping non-safelisted event. appId, event name, origin", str, zzanVar2.f18067f, zzanVar2.f18069h);
                    return;
                }
            }
            W().w0();
            try {
                c W = W();
                Preconditions.g(str);
                W.d();
                W.t();
                if (j2 < 0) {
                    W.h().K().c("Invalid time querying timed out conditional properties", zzet.x(str), Long.valueOf(j2));
                    L = Collections.emptyList();
                } else {
                    L = W.L("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (zzv zzvVar : L) {
                    if (zzvVar != null) {
                        this.f18217j.h().O().d("User property timed out", zzvVar.f18240f, this.f18217j.J().B(zzvVar.f18242h.f18224g), zzvVar.f18242h.y());
                        if (zzvVar.l != null) {
                            M(new zzan(zzvVar.l, j2), zzmVar);
                        }
                        W().s0(str, zzvVar.f18242h.f18224g);
                    }
                }
                c W2 = W();
                Preconditions.g(str);
                W2.d();
                W2.t();
                if (j2 < 0) {
                    W2.h().K().c("Invalid time querying expired conditional properties", zzet.x(str), Long.valueOf(j2));
                    L2 = Collections.emptyList();
                } else {
                    L2 = W2.L("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(L2.size());
                for (zzv zzvVar2 : L2) {
                    if (zzvVar2 != null) {
                        this.f18217j.h().O().d("User property expired", zzvVar2.f18240f, this.f18217j.J().B(zzvVar2.f18242h.f18224g), zzvVar2.f18242h.y());
                        W().m0(str, zzvVar2.f18242h.f18224g);
                        zzan zzanVar3 = zzvVar2.p;
                        if (zzanVar3 != null) {
                            arrayList.add(zzanVar3);
                        }
                        W().s0(str, zzvVar2.f18242h.f18224g);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    M(new zzan((zzan) obj, j2), zzmVar);
                }
                c W3 = W();
                String str2 = zzanVar2.f18067f;
                Preconditions.g(str);
                Preconditions.g(str2);
                W3.d();
                W3.t();
                if (j2 < 0) {
                    W3.h().K().d("Invalid time querying triggered conditional properties", zzet.x(str), W3.k().y(str2), Long.valueOf(j2));
                    L3 = Collections.emptyList();
                } else {
                    L3 = W3.L("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(L3.size());
                for (zzv zzvVar3 : L3) {
                    if (zzvVar3 != null) {
                        zzkj zzkjVar = zzvVar3.f18242h;
                        m7 m7Var = new m7(zzvVar3.f18240f, zzvVar3.f18241g, zzkjVar.f18224g, j2, zzkjVar.y());
                        if (W().T(m7Var)) {
                            this.f18217j.h().O().d("User property triggered", zzvVar3.f18240f, this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
                        } else {
                            this.f18217j.h().H().d("Too many active user properties, ignoring", zzet.x(zzvVar3.f18240f), this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
                        }
                        zzan zzanVar4 = zzvVar3.n;
                        if (zzanVar4 != null) {
                            arrayList2.add(zzanVar4);
                        }
                        zzvVar3.f18242h = new zzkj(m7Var);
                        zzvVar3.f18244j = true;
                        W().U(zzvVar3);
                    }
                }
                M(zzanVar2, zzmVar);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    M(new zzan((zzan) obj2, j2), zzmVar);
                }
                W().w();
            } finally {
                W().A0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(zzan zzanVar, String str) {
        z3 j0 = W().j0(str);
        if (j0 != null && !TextUtils.isEmpty(j0.T())) {
            Boolean K = K(j0);
            if (K == null) {
                if (!"_ui".equals(zzanVar.f18067f)) {
                    this.f18217j.h().K().b("Could not find package. appId", zzet.x(str));
                }
            } else if (!K.booleanValue()) {
                this.f18217j.h().H().b("App version does not match; dropping event. appId", zzet.x(str));
                return;
            }
            p(zzanVar, new zzm(str, j0.A(), j0.T(), j0.V(), j0.X(), j0.Z(), j0.b0(), (String) null, j0.e0(), false, j0.M(), j0.k(), 0L, 0, j0.l(), j0.m(), false, j0.D(), j0.n(), j0.d0(), j0.o(), (zzky.b() && this.f18217j.y().B(j0.t(), zzap.N0)) ? j0.G() : null));
            return;
        }
        this.f18217j.h().O().b("No app data available; dropping event", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(f7 f7Var) {
        this.p++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v(zzkj zzkjVar, zzm zzmVar) {
        h D;
        j0();
        c0();
        if (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) {
            return;
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        int o0 = this.f18217j.I().o0(zzkjVar.f18224g);
        if (o0 != 0) {
            this.f18217j.I();
            String F = zzkk.F(zzkjVar.f18224g, 24, true);
            String str = zzkjVar.f18224g;
            this.f18217j.I().T(zzmVar.f18234f, o0, "_ev", F, str != null ? str.length() : 0);
            return;
        }
        int j0 = this.f18217j.I().j0(zzkjVar.f18224g, zzkjVar.y());
        if (j0 != 0) {
            this.f18217j.I();
            String F2 = zzkk.F(zzkjVar.f18224g, 24, true);
            Object y = zzkjVar.y();
            this.f18217j.I().T(zzmVar.f18234f, j0, "_ev", F2, (y == null || !((y instanceof String) || (y instanceof CharSequence))) ? 0 : String.valueOf(y).length());
            return;
        }
        Object p0 = this.f18217j.I().p0(zzkjVar.f18224g, zzkjVar.y());
        if (p0 == null) {
            return;
        }
        if ("_sid".equals(zzkjVar.f18224g) && this.f18217j.y().Q(zzmVar.f18234f)) {
            long j2 = zzkjVar.f18225h;
            String str2 = zzkjVar.l;
            long j3 = 0;
            m7 o02 = W().o0(zzmVar.f18234f, "_sno");
            if (o02 != null) {
                Object obj = o02.f17875e;
                if (obj instanceof Long) {
                    j3 = ((Long) obj).longValue();
                    v(new zzkj("_sno", j2, Long.valueOf(j3 + 1), str2), zzmVar);
                }
            }
            if (o02 != null) {
                this.f18217j.h().K().b("Retrieved last session number from database does not contain a valid (long) value", o02.f17875e);
            }
            if (this.f18217j.y().B(zzmVar.f18234f, zzap.d0) && (D = W().D(zzmVar.f18234f, "_s")) != null) {
                j3 = D.f17785c;
                this.f18217j.h().P().b("Backfill the session number. Last used session number", Long.valueOf(j3));
            }
            v(new zzkj("_sno", j2, Long.valueOf(j3 + 1), str2), zzmVar);
        }
        m7 m7Var = new m7(zzmVar.f18234f, zzkjVar.l, zzkjVar.f18224g, zzkjVar.f18225h, p0);
        this.f18217j.h().O().c("Setting user property", this.f18217j.J().B(m7Var.f17873c), p0);
        W().w0();
        try {
            T(zzmVar);
            boolean T = W().T(m7Var);
            W().w();
            if (T) {
                this.f18217j.h().O().c("User property set", this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
            } else {
                this.f18217j.h().H().c("Too many unique user properties are set. Ignoring user property", this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
                this.f18217j.I().T(zzmVar.f18234f, 9, null, null, 0);
            }
        } finally {
            W().A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void w(zzm zzmVar) {
        if (this.w != null) {
            ArrayList arrayList = new ArrayList();
            this.x = arrayList;
            arrayList.addAll(this.w);
        }
        c W = W();
        String str = zzmVar.f18234f;
        Preconditions.g(str);
        W.d();
        W.t();
        try {
            SQLiteDatabase x = W.x();
            String[] strArr = {str};
            int delete = x.delete(DeepLinkIntentReceiver.DeepLinksTargets.APPS, "app_id=?", strArr) + 0 + x.delete("events", "app_id=?", strArr) + x.delete("user_attributes", "app_id=?", strArr) + x.delete("conditional_properties", "app_id=?", strArr) + x.delete("raw_events", "app_id=?", strArr) + x.delete("raw_events_metadata", "app_id=?", strArr) + x.delete("queue", "app_id=?", strArr) + x.delete("audience_filter_values", "app_id=?", strArr) + x.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                W.h().P().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            W.h().H().c("Error resetting analytics data. appId, error", zzet.x(str), e2);
        }
        if (com.google.android.gms.internal.measurement.zzkh.b() && this.f18217j.y().r(zzap.S0)) {
            if (zzmVar.m) {
                P(zzmVar);
            }
        } else {
            zzm d2 = d(this.f18217j.f(), zzmVar.f18234f, zzmVar.f18235g, zzmVar.m, zzmVar.t, zzmVar.u, zzmVar.r, zzmVar.w, zzmVar.A);
            if (zzmVar.m) {
                P(d2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(zzv zzvVar) {
        zzm e2 = e(zzvVar.f18240f);
        if (e2 != null) {
            y(zzvVar, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(zzv zzvVar, zzm zzmVar) {
        boolean z;
        Preconditions.k(zzvVar);
        Preconditions.g(zzvVar.f18240f);
        Preconditions.k(zzvVar.f18241g);
        Preconditions.k(zzvVar.f18242h);
        Preconditions.g(zzvVar.f18242h.f18224g);
        j0();
        c0();
        if (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) {
            return;
        }
        if (!zzmVar.m) {
            T(zzmVar);
            return;
        }
        zzv zzvVar2 = new zzv(zzvVar);
        boolean z2 = false;
        zzvVar2.f18244j = false;
        W().w0();
        try {
            zzv q0 = W().q0(zzvVar2.f18240f, zzvVar2.f18242h.f18224g);
            if (q0 != null && !q0.f18241g.equals(zzvVar2.f18241g)) {
                this.f18217j.h().K().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f18217j.J().B(zzvVar2.f18242h.f18224g), zzvVar2.f18241g, q0.f18241g);
            }
            if (q0 != null && (z = q0.f18244j)) {
                zzvVar2.f18241g = q0.f18241g;
                zzvVar2.f18243i = q0.f18243i;
                zzvVar2.m = q0.m;
                zzvVar2.f18245k = q0.f18245k;
                zzvVar2.n = q0.n;
                zzvVar2.f18244j = z;
                zzkj zzkjVar = zzvVar2.f18242h;
                zzvVar2.f18242h = new zzkj(zzkjVar.f18224g, q0.f18242h.f18225h, zzkjVar.y(), q0.f18242h.l);
            } else if (TextUtils.isEmpty(zzvVar2.f18245k)) {
                zzkj zzkjVar2 = zzvVar2.f18242h;
                zzvVar2.f18242h = new zzkj(zzkjVar2.f18224g, zzvVar2.f18243i, zzkjVar2.y(), zzvVar2.f18242h.l);
                zzvVar2.f18244j = true;
                z2 = true;
            }
            if (zzvVar2.f18244j) {
                zzkj zzkjVar3 = zzvVar2.f18242h;
                m7 m7Var = new m7(zzvVar2.f18240f, zzvVar2.f18241g, zzkjVar3.f18224g, zzkjVar3.f18225h, zzkjVar3.y());
                if (W().T(m7Var)) {
                    this.f18217j.h().O().d("User property updated immediately", zzvVar2.f18240f, this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
                } else {
                    this.f18217j.h().H().d("(2)Too many active user properties, ignoring", zzet.x(zzvVar2.f18240f), this.f18217j.J().B(m7Var.f17873c), m7Var.f17875e);
                }
                if (z2 && zzvVar2.n != null) {
                    M(new zzan(zzvVar2.n, zzvVar2.f18243i), zzmVar);
                }
            }
            if (W().U(zzvVar2)) {
                this.f18217j.h().O().d("Conditional property added", zzvVar2.f18240f, this.f18217j.J().B(zzvVar2.f18242h.f18224g), zzvVar2.f18242h.y());
            } else {
                this.f18217j.h().H().d("Too many conditional properties, ignoring", zzet.x(zzvVar2.f18240f), this.f18217j.J().B(zzvVar2.f18242h.f18224g), zzvVar2.f18242h.y());
            }
            W().w();
        } finally {
            W().A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(Runnable runnable) {
        j0();
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(runnable);
    }

    private zzkc(zzkh zzkhVar, zzfx zzfxVar) {
        this.f18218k = false;
        Preconditions.k(zzkhVar);
        zzfx a2 = zzfx.a(zzkhVar.a, null);
        this.f18217j = a2;
        this.y = -1L;
        zzkg zzkgVar = new zzkg(this);
        zzkgVar.u();
        this.f18215h = zzkgVar;
        zzex zzexVar = new zzex(this);
        zzexVar.u();
        this.f18210c = zzexVar;
        zzfr zzfrVar = new zzfr(this);
        zzfrVar.u();
        this.f18209b = zzfrVar;
        a2.g().z(new i7(this, zzkhVar));
    }
}
