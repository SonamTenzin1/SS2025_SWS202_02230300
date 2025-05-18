package com.google.android.gms.internal.ads;

import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzbge extends zzbft {

    /* renamed from: i, reason: collision with root package name */
    private static final Set<String> f14433i = Collections.synchronizedSet(new HashSet());

    /* renamed from: j, reason: collision with root package name */
    private static final DecimalFormat f14434j = new DecimalFormat("#,###");

    /* renamed from: k, reason: collision with root package name */
    private File f14435k;
    private boolean l;

    public zzbge(zzbdf zzbdfVar) {
        super(zzbdfVar);
        File cacheDir = this.f14430f.getCacheDir();
        if (cacheDir == null) {
            zzbad.i("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.f14435k = file;
        if (!file.isDirectory() && !this.f14435k.mkdirs()) {
            String valueOf = String.valueOf(this.f14435k.getAbsolutePath());
            zzbad.i(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.f14435k = null;
        } else {
            if (this.f14435k.setReadable(true, false) && this.f14435k.setExecutable(true, false)) {
                return;
            }
            String valueOf2 = String.valueOf(this.f14435k.getAbsolutePath());
            zzbad.i(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.f14435k = null;
        }
    }

    private final File B(File file) {
        return new File(this.f14435k, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.l = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x01e0, code lost:
    
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01e6, code lost:
    
        if (r1 < 400) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01e8, code lost:
    
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01f8, code lost:
    
        if (r2.length() == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01fa, code lost:
    
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0205, code lost:
    
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x022d, code lost:
    
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0230, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x022e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0200, code lost:
    
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0232, code lost:
    
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0236, code lost:
    
        if (r7 >= 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0238, code lost:
    
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0242, code lost:
    
        if (r1.length() == 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0244, code lost:
    
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x024f, code lost:
    
        com.google.android.gms.internal.ads.zzbad.i(r0);
        q(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbge.f14433i.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0260, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0249, code lost:
    
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0261, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbge.f14434j.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzyt.e().c(com.google.android.gms.internal.ads.zzacu.C)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0278, code lost:
    
        if (r7 <= r3) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x027a, code lost:
    
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzbad.i(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02b3, code lost:
    
        if (r1.length() == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02b5, code lost:
    
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02c0, code lost:
    
        q(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbge.f14433i.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ce, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02ba, code lost:
    
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02cf, code lost:
    
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzbad.e(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x030a, code lost:
    
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(cm.aptoide.pt.file.CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
        r16 = com.google.android.gms.ads.internal.zzk.zzln();
        r17 = r16.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0328, code lost:
    
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0329, code lost:
    
        r6 = new com.google.android.gms.internal.ads.zzazj(((java.lang.Long) com.google.android.gms.internal.ads.zzyt.e().c(com.google.android.gms.internal.ads.zzacu.F)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzyt.e().c(com.google.android.gms.internal.ads.zzacu.E)).longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0342, code lost:
    
        r20 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0346, code lost:
    
        if (r20 < 0) goto L321;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0348, code lost:
    
        r11 = r11 + r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x034a, code lost:
    
        if (r11 <= r3) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x034c, code lost:
    
        r15 = "sizeExceeded";
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x035c, code lost:
    
        if (r1.length() == 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x035e, code lost:
    
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0370, code lost:
    
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0373, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0374, code lost:
    
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x037c, code lost:
    
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0364, code lost:
    
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0379, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x037a, code lost:
    
        r1 = r10;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x037f, code lost:
    
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0386, code lost:
    
        if (r2.write(r1) > 0) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0388, code lost:
    
        r1.clear();
        r24 = ((r16.a() - r17) > (1000 * r13) ? 1 : ((r16.a() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0397, code lost:
    
        if (r24 > 0) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0399, code lost:
    
        r20 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x039d, code lost:
    
        if (r30.l != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03a3, code lost:
    
        if (r6.a() == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03ab, code lost:
    
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03af, code lost:
    
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03cd, code lost:
    
        com.google.android.gms.internal.ads.zzazt.a.post(new com.google.android.gms.internal.ads.z9(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03ee, code lost:
    
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04a6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04a9, code lost:
    
        r15 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04ab, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04a8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03d6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03d7, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03d4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03dc, code lost:
    
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0411, code lost:
    
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0412, code lost:
    
        r27 = r4;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0418, code lost:
    
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x041a, code lost:
    
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0445, code lost:
    
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0448, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0449, code lost:
    
        r2 = r10;
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0452, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0450, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0454, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0457, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x045e, code lost:
    
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0466, code lost:
    
        r27.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x046d, code lost:
    
        if (com.google.android.gms.internal.ads.zzbad.a(3) == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x046f, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbge.f14434j.format(r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzbad.e(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x04b0, code lost:
    
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04b7, code lost:
    
        if (r0.isFile() == false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04b9, code lost:
    
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04c1, code lost:
    
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04d8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x04db, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04e0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04e3, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04ed, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x04e7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x04ea, code lost:
    
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x050c: MOVE (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:281:0x050c */
    /* JADX WARN: Removed duplicated region for block: B:111:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0551  */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.net.URLConnection] */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean y(String str) {
        int i2;
        File file;
        String str2;
        String str3;
        String str4;
        String str5;
        ?? intValue;
        URL url;
        int i3;
        String str6;
        FileOutputStream fileOutputStream;
        ?? r24;
        String str7;
        boolean delete;
        FileOutputStream fileOutputStream2 = null;
        int i4 = 0;
        if (this.f14435k == null) {
            q(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file2 = this.f14435k;
            if (file2 == null) {
                i2 = 0;
            } else {
                i2 = 0;
                for (File file3 : file2.listFiles()) {
                    if (!file3.getName().endsWith(".done")) {
                        i2++;
                    }
                }
            }
            if (i2 > ((Integer) zzyt.e().c(zzacu.B)).intValue()) {
                File file4 = this.f14435k;
                if (file4 != null) {
                    long j2 = Long.MAX_VALUE;
                    File file5 = null;
                    for (File file6 : file4.listFiles()) {
                        if (!file6.getName().endsWith(".done")) {
                            long lastModified = file6.lastModified();
                            if (lastModified < j2) {
                                file5 = file6;
                                j2 = lastModified;
                            }
                        }
                    }
                    if (file5 != null) {
                        delete = file5.delete();
                        File B = B(file5);
                        if (B.isFile()) {
                            delete &= B.delete();
                        }
                    }
                }
                delete = false;
            } else {
                file = new File(this.f14435k, z(str));
                File B2 = B(file);
                if (file.isFile() && B2.isFile()) {
                    int length = (int) file.length();
                    String valueOf = String.valueOf(str);
                    zzbad.e(valueOf.length() != 0 ? "Stream cache hit at ".concat(valueOf) : new String("Stream cache hit at "));
                    j(str, file.getAbsolutePath(), length);
                    return true;
                }
                String valueOf2 = String.valueOf(this.f14435k.getAbsolutePath());
                String valueOf3 = String.valueOf(str);
                String concat = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                Set<String> set = f14433i;
                synchronized (set) {
                    if (set.contains(concat)) {
                        String valueOf4 = String.valueOf(str);
                        zzbad.i(valueOf4.length() != 0 ? "Stream cache already in progress at ".concat(valueOf4) : new String("Stream cache already in progress at "));
                        q(str, file.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(concat);
                    str2 = "error";
                    try {
                        zzk.zzls();
                        intValue = ((Integer) zzyt.e().c(zzacu.G)).intValue();
                        url = new URL(str);
                        i3 = 0;
                    } catch (IOException | RuntimeException e2) {
                        e = e2;
                        str3 = concat;
                    }
                    while (true) {
                        i3++;
                        try {
                        } catch (IOException | RuntimeException e3) {
                            e = e3;
                            str2 = str6;
                            str3 = intValue;
                            str4 = null;
                            fileOutputStream2 = null;
                            str5 = str3;
                            if (e instanceof RuntimeException) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException | NullPointerException unused) {
                            }
                            if (this.l) {
                            }
                            if (file.exists()) {
                            }
                            q(str, file.getAbsolutePath(), str2, str4);
                            f14433i.remove(str5);
                            return false;
                        }
                        if (i3 <= 20) {
                            ?? openConnection = url.openConnection();
                            openConnection.setConnectTimeout(intValue);
                            openConnection.setReadTimeout(intValue);
                            if (openConnection instanceof HttpURLConnection) {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                                zzazx zzazxVar = new zzazx();
                                zzazxVar.i(httpURLConnection, null);
                                httpURLConnection.setInstanceFollowRedirects(false);
                                int responseCode = httpURLConnection.getResponseCode();
                                zzazxVar.h(httpURLConnection, responseCode);
                                if (responseCode / 100 != 3) {
                                    break;
                                }
                                try {
                                    String headerField = httpURLConnection.getHeaderField("Location");
                                    if (headerField != null) {
                                        URL url2 = new URL(url, headerField);
                                        String protocol = url2.getProtocol();
                                        if (protocol != null) {
                                            if (!protocol.equals("http") && !protocol.equals(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME)) {
                                                throw new IOException(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                                            }
                                            zzbad.e(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
                                            httpURLConnection.disconnect();
                                            url = url2;
                                        } else {
                                            throw new IOException("Protocol is null");
                                        }
                                    } else {
                                        throw new IOException("Missing Location header in redirect");
                                    }
                                } catch (IOException | RuntimeException e4) {
                                    e = e4;
                                    str4 = null;
                                }
                                str5 = concat;
                                if (e instanceof RuntimeException) {
                                    zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                }
                                fileOutputStream2.close();
                                if (this.l) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
                                    sb.append("Preload aborted for URL \"");
                                    sb.append(str);
                                    sb.append("\"");
                                    zzbad.h(sb.toString());
                                } else {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25);
                                    sb2.append("Preload failed for URL \"");
                                    sb2.append(str);
                                    sb2.append("\"");
                                    zzbad.d(sb2.toString(), e);
                                }
                                if (file.exists() && !file.delete()) {
                                    String valueOf5 = String.valueOf(file.getAbsolutePath());
                                    zzbad.i(valueOf5.length() == 0 ? "Could not delete partial cache file at ".concat(valueOf5) : new String("Could not delete partial cache file at "));
                                }
                                q(str, file.getAbsolutePath(), str2, str4);
                                f14433i.remove(str5);
                                return false;
                            }
                            throw new IOException("Invalid protocol.");
                        }
                        throw new IOException("Too many redirects (20)");
                    }
                }
            }
        } while (delete);
        zzbad.i("Unable to expire stream cache");
        q(str, null, "expireFailed", null);
        return false;
        j(str, file.getAbsolutePath(), i4);
        String str8 = r24;
        try {
            f14433i.remove(str8);
            return true;
        } catch (IOException e5) {
            e = e5;
            str2 = str7;
            String str9 = str8;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            str5 = str9;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.l) {
            }
            if (file.exists()) {
            }
            q(str, file.getAbsolutePath(), str2, str4);
            f14433i.remove(str5);
            return false;
        } catch (RuntimeException e6) {
            e = e6;
            str2 = str7;
            String str92 = str8;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            str5 = str92;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.l) {
            }
            if (file.exists()) {
            }
            q(str, file.getAbsolutePath(), str2, str4);
            f14433i.remove(str5);
            return false;
        }
    }
}
