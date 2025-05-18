package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class zzak implements zzm {
    private static final boolean a = zzag.f13871b;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private final zzas f13929b;

    /* renamed from: c, reason: collision with root package name */
    private final zzaj f13930c;

    /* renamed from: d, reason: collision with root package name */
    private final zzal f13931d;

    @Deprecated
    public zzak(zzas zzasVar) {
        this(zzasVar, new zzal(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
    }

    private static void b(String str, zzr<?> zzrVar, zzaf zzafVar) throws zzaf {
        zzac R = zzrVar.R();
        int Q = zzrVar.Q();
        try {
            R.a(zzafVar);
            zzrVar.I(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(Q)));
        } catch (zzaf e2) {
            zzrVar.I(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(Q)));
            throw e2;
        }
    }

    private final byte[] c(InputStream inputStream, int i2) throws IOException, zzad {
        zzaw zzawVar = new zzaw(this.f13931d, i2);
        try {
            if (inputStream != null) {
                byte[] b2 = this.f13931d.b(1024);
                while (true) {
                    int read = inputStream.read(b2);
                    if (read == -1) {
                        break;
                    }
                    zzawVar.write(b2, 0, read);
                }
                byte[] byteArray = zzawVar.toByteArray();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    zzag.c("Error occurred when closing InputStream", new Object[0]);
                }
                this.f13931d.a(b2);
                zzawVar.close();
                return byteArray;
            }
            throw new zzad();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzag.c("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f13931d.a(null);
            zzawVar.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fe A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzp a(zzr<?> zzrVar) throws zzaf {
        List<zzl> list;
        zzar zzarVar;
        byte[] bArr;
        Map<String, String> map;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List<zzl> emptyList = Collections.emptyList();
            try {
                try {
                    zzc N = zzrVar.N();
                    if (N == null) {
                        map = Collections.emptyMap();
                    } else {
                        HashMap hashMap = new HashMap();
                        String str = N.f14946b;
                        if (str != null) {
                            hashMap.put("If-None-Match", str);
                        }
                        long j2 = N.f14948d;
                        if (j2 > 0) {
                            hashMap.put("If-Modified-Since", zzaq.b(j2));
                        }
                        map = hashMap;
                    }
                    zzar b2 = this.f13930c.b(zzrVar, map);
                    try {
                        int c2 = b2.c();
                        List<zzl> d2 = b2.d();
                        if (c2 == 304) {
                            zzc N2 = zzrVar.N();
                            if (N2 == null) {
                                return new zzp(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, d2);
                            }
                            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                            if (!d2.isEmpty()) {
                                Iterator<zzl> it = d2.iterator();
                                while (it.hasNext()) {
                                    treeSet.add(it.next().a());
                                }
                            }
                            ArrayList arrayList = new ArrayList(d2);
                            List<zzl> list2 = N2.f14952h;
                            if (list2 != null) {
                                if (!list2.isEmpty()) {
                                    for (zzl zzlVar : N2.f14952h) {
                                        if (!treeSet.contains(zzlVar.a())) {
                                            arrayList.add(zzlVar);
                                        }
                                    }
                                }
                            } else if (!N2.f14951g.isEmpty()) {
                                for (Map.Entry<String, String> entry : N2.f14951g.entrySet()) {
                                    if (!treeSet.contains(entry.getKey())) {
                                        arrayList.add(new zzl(entry.getKey(), entry.getValue()));
                                    }
                                }
                            }
                            return new zzp(304, N2.a, true, SystemClock.elapsedRealtime() - elapsedRealtime, (List<zzl>) arrayList);
                        }
                        InputStream a2 = b2.a();
                        byte[] c3 = a2 != null ? c(a2, b2.b()) : new byte[0];
                        try {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            if (a || elapsedRealtime2 > 3000) {
                                Object[] objArr = new Object[5];
                                objArr[0] = zzrVar;
                                objArr[1] = Long.valueOf(elapsedRealtime2);
                                objArr[2] = c3 != null ? Integer.valueOf(c3.length) : "null";
                                objArr[3] = Integer.valueOf(c2);
                                objArr[4] = Integer.valueOf(zzrVar.R().c());
                                zzag.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            }
                            if (c2 >= 200 && c2 <= 299) {
                                return new zzp(c2, c3, false, SystemClock.elapsedRealtime() - elapsedRealtime, d2);
                            }
                            throw new IOException();
                        } catch (IOException e2) {
                            e = e2;
                            list = d2;
                            bArr = c3;
                            zzarVar = b2;
                            if (zzarVar == null) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        list = emptyList;
                        zzarVar = b2;
                        bArr = null;
                        if (zzarVar == null) {
                            int c4 = zzarVar.c();
                            zzag.b("Unexpected response code %d for %s", Integer.valueOf(c4), zzrVar.q());
                            if (bArr != null) {
                                zzp zzpVar = new zzp(c4, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                                if (c4 != 401 && c4 != 403) {
                                    if (c4 >= 400 && c4 <= 499) {
                                        throw new zzg(zzpVar);
                                    }
                                    if (c4 >= 500 && c4 <= 599) {
                                        throw new zzad(zzpVar);
                                    }
                                    throw new zzad(zzpVar);
                                }
                                b("auth", zzrVar, new zza(zzpVar));
                            } else {
                                b("network", zzrVar, new zzo());
                            }
                        } else {
                            throw new zzq(e);
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    list = emptyList;
                    zzarVar = null;
                }
            } catch (MalformedURLException e5) {
                String valueOf = String.valueOf(zzrVar.q());
                throw new RuntimeException(valueOf.length() != 0 ? "Bad URL ".concat(valueOf) : new String("Bad URL "), e5);
            } catch (SocketTimeoutException unused) {
                b("socket", zzrVar, new zzae());
            }
        }
    }

    @Deprecated
    private zzak(zzas zzasVar, zzal zzalVar) {
        this.f13929b = zzasVar;
        this.f13930c = new o0(zzasVar);
        this.f13931d = zzalVar;
    }

    public zzak(zzaj zzajVar) {
        this(zzajVar, new zzal(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
    }

    private zzak(zzaj zzajVar, zzal zzalVar) {
        this.f13930c = zzajVar;
        this.f13929b = zzajVar;
        this.f13931d = zzalVar;
    }
}
