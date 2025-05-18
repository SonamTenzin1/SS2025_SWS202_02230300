package e.h.a.k0;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: FileDownloadProperties.java */
/* loaded from: classes2.dex */
public class e {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21364b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21365c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21366d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21367e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f21368f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21369g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21370h;

    /* compiled from: FileDownloadProperties.java */
    /* loaded from: classes2.dex */
    public static class b {
        private static final e a = new e();
    }

    public static e a() {
        return b.a;
    }

    public static int b(int i2) {
        if (i2 > 12) {
            d.i(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
            return 12;
        }
        if (i2 >= 1) {
            return i2;
        }
        d.i(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00ad A[Catch: all -> 0x0294, TryCatch #5 {all -> 0x0294, blocks: (B:77:0x0036, B:80:0x003d, B:83:0x0041, B:86:0x0045, B:89:0x0049, B:92:0x004d, B:95:0x0051, B:98:0x0055, B:102:0x00a9, B:104:0x00ad, B:106:0x00b1, B:115:0x00bf), top: B:76:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00bf A[Catch: all -> 0x0294, TRY_LEAVE, TryCatch #5 {all -> 0x0294, blocks: (B:77:0x0036, B:80:0x003d, B:83:0x0041, B:86:0x0045, B:89:0x0049, B:92:0x004d, B:95:0x0051, B:98:0x0055, B:102:0x00a9, B:104:0x00ad, B:106:0x00b1, B:115:0x00bf), top: B:76:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0117  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private e() {
        Throwable th;
        InputStream inputStream;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        String str9;
        String str10;
        String str11;
        String str12;
        Object obj2;
        Object obj3;
        ?? r10;
        Object obj4;
        long j2;
        int i2;
        ?? r9;
        String str13;
        String property;
        if (c.a() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Properties properties = new Properties();
            try {
                inputStream = c.a().getAssets().open("filedownloader.properties");
                if (inputStream != null) {
                    try {
                        try {
                            properties.load(inputStream);
                            str = properties.getProperty("http.lenient");
                        } catch (IOException e2) {
                            e = e2;
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                                if (d.a) {
                                    str8 = str;
                                    d.a(e.class, "not found filedownloader.properties", new Object[0]);
                                } else {
                                    str8 = str;
                                }
                            } else {
                                str8 = str;
                                e.printStackTrace();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str2 = properties.getProperty("process.non-separate");
                        } catch (IOException e4) {
                            e = e4;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str3 = properties.getProperty("download.min-progress-step");
                        } catch (IOException e5) {
                            e = e5;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str4 = properties.getProperty("download.min-progress-time");
                        } catch (IOException e6) {
                            e = e6;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str5 = properties.getProperty("download.max-network-thread-count");
                        } catch (IOException e7) {
                            e = e7;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str6 = properties.getProperty("file.non-pre-allocation");
                        } catch (IOException e8) {
                            e = e8;
                            str6 = null;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str7 = properties.getProperty("broadcast.completed");
                        } catch (IOException e9) {
                            e = e9;
                            str7 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                        try {
                            str13 = str2;
                            property = properties.getProperty("download.trial-connection-head-method");
                        } catch (IOException e10) {
                            e = e10;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            if (inputStream != null) {
                            }
                            obj = e.class;
                            str9 = str2;
                            str10 = str6;
                            str11 = str7;
                            str = str8;
                            str12 = null;
                            obj2 = "download.max-network-thread-count";
                            if (str != null) {
                            }
                            if (str9 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str5 != null) {
                            }
                            if (str10 != null) {
                            }
                            if (str11 != null) {
                            }
                            if (str12 != null) {
                            }
                            if (d.a) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } else {
                    str = null;
                    str13 = null;
                    property = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                str9 = str13;
                str12 = property;
                str10 = str6;
                obj2 = "download.max-network-thread-count";
                obj = e.class;
                str11 = str7;
            } catch (IOException e13) {
                e = e13;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (str != null) {
                if (!str.equals("true") && !str.equals(AdultContentAnalytics.UNLOCK)) {
                    throw new IllegalStateException(f.o("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", AdultContentAnalytics.UNLOCK));
                }
                obj3 = "http.lenient";
                r10 = 0;
                this.f21365c = str.equals("true");
            } else {
                obj3 = "http.lenient";
                r10 = 0;
                this.f21365c = false;
            }
            if (str9 != null) {
                if (!str9.equals("true") && !str9.equals(AdultContentAnalytics.UNLOCK)) {
                    Object[] objArr = new Object[3];
                    objArr[r10] = "process.non-separate";
                    objArr[1] = "true";
                    objArr[2] = AdultContentAnalytics.UNLOCK;
                    throw new IllegalStateException(f.o("the value of '%s' must be '%s' or '%s'", objArr));
                }
                this.f21366d = str9.equals("true");
            } else {
                this.f21366d = r10;
            }
            if (str3 != null) {
                this.a = Math.max((int) r10, Integer.valueOf(str3).intValue());
            } else {
                this.a = 65536;
            }
            if (str4 != null) {
                obj4 = "process.non-separate";
                j2 = currentTimeMillis;
                this.f21364b = Math.max(0L, Long.valueOf(str4).longValue());
            } else {
                obj4 = "process.non-separate";
                j2 = currentTimeMillis;
                this.f21364b = 2000L;
            }
            if (str5 != null) {
                this.f21367e = b(Integer.valueOf(str5).intValue());
                i2 = 3;
            } else {
                i2 = 3;
                this.f21367e = 3;
            }
            if (str10 != null) {
                if (!str10.equals("true") && !str10.equals(AdultContentAnalytics.UNLOCK)) {
                    Object[] objArr2 = new Object[i2];
                    objArr2[0] = "file.non-pre-allocation";
                    objArr2[1] = "true";
                    objArr2[2] = AdultContentAnalytics.UNLOCK;
                    throw new IllegalStateException(f.o("the value of '%s' must be '%s' or '%s'", objArr2));
                }
                r9 = 0;
                this.f21368f = str10.equals("true");
            } else {
                r9 = 0;
                this.f21368f = false;
            }
            if (str11 != null) {
                if (!str11.equals("true") && !str11.equals(AdultContentAnalytics.UNLOCK)) {
                    Object[] objArr3 = new Object[3];
                    objArr3[r9] = "broadcast.completed";
                    objArr3[1] = "true";
                    objArr3[2] = AdultContentAnalytics.UNLOCK;
                    throw new IllegalStateException(f.o("the value of '%s' must be '%s' or '%s'", objArr3));
                }
                this.f21369g = str11.equals("true");
            } else {
                this.f21369g = r9;
            }
            if (str12 != null) {
                if (!str12.equals("true") && !str12.equals(AdultContentAnalytics.UNLOCK)) {
                    Object[] objArr4 = new Object[3];
                    objArr4[r9] = "download.trial-connection-head-method";
                    objArr4[1] = "true";
                    objArr4[2] = AdultContentAnalytics.UNLOCK;
                    throw new IllegalStateException(f.o("the value of '%s' must be '%s' or '%s'", objArr4));
                }
                this.f21370h = str12.equals("true");
            } else {
                this.f21370h = r9;
            }
            if (d.a) {
                Object[] objArr5 = new Object[17];
                objArr5[r9] = Long.valueOf(System.currentTimeMillis() - j2);
                objArr5[1] = obj3;
                objArr5[2] = Boolean.valueOf(this.f21365c);
                objArr5[3] = obj4;
                objArr5[4] = Boolean.valueOf(this.f21366d);
                objArr5[5] = "download.min-progress-step";
                objArr5[6] = Integer.valueOf(this.a);
                objArr5[7] = "download.min-progress-time";
                objArr5[8] = Long.valueOf(this.f21364b);
                objArr5[9] = obj2;
                objArr5[10] = Integer.valueOf(this.f21367e);
                objArr5[11] = "file.non-pre-allocation";
                objArr5[12] = Boolean.valueOf(this.f21368f);
                objArr5[13] = "broadcast.completed";
                objArr5[14] = Boolean.valueOf(this.f21369g);
                objArr5[15] = "download.trial-connection-head-method";
                objArr5[16] = Boolean.valueOf(this.f21370h);
                d.e(obj, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", objArr5);
                return;
            }
            return;
        }
        throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
    }
}
