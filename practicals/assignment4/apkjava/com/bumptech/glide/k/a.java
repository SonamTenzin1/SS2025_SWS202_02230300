package com.bumptech.glide.k;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final File f8960f;

    /* renamed from: g, reason: collision with root package name */
    private final File f8961g;

    /* renamed from: h, reason: collision with root package name */
    private final File f8962h;

    /* renamed from: i, reason: collision with root package name */
    private final File f8963i;

    /* renamed from: j, reason: collision with root package name */
    private final int f8964j;

    /* renamed from: k, reason: collision with root package name */
    private long f8965k;
    private final int l;
    private Writer n;
    private int p;
    private long m = 0;
    private final LinkedHashMap<String, d> o = new LinkedHashMap<>(0, 0.75f, true);
    private long q = 0;
    final ThreadPoolExecutor r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> s = new CallableC0121a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0121a implements Callable<Void> {
        CallableC0121a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.n == null) {
                    return null;
                }
                a.this.T();
                if (a.this.B()) {
                    a.this.K();
                    a.this.p = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0121a callableC0121a) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {
        private final d a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f8967b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8968c;

        /* synthetic */ c(a aVar, d dVar, CallableC0121a callableC0121a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.m(this, false);
        }

        public void b() {
            if (this.f8968c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.m(this, true);
            this.f8968c = true;
        }

        public File f(int i2) throws IOException {
            File k2;
            synchronized (a.this) {
                if (this.a.f8974f == this) {
                    if (!this.a.f8973e) {
                        this.f8967b[i2] = true;
                    }
                    k2 = this.a.k(i2);
                    if (!a.this.f8960f.exists()) {
                        a.this.f8960f.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k2;
        }

        private c(d dVar) {
            this.a = dVar;
            this.f8967b = dVar.f8973e ? null : new boolean[a.this.l];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f8970b;

        /* renamed from: c, reason: collision with root package name */
        File[] f8971c;

        /* renamed from: d, reason: collision with root package name */
        File[] f8972d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f8973e;

        /* renamed from: f, reason: collision with root package name */
        private c f8974f;

        /* renamed from: g, reason: collision with root package name */
        private long f8975g;

        /* synthetic */ d(a aVar, String str, CallableC0121a callableC0121a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.l) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f8970b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i2) {
            return this.f8971c[i2];
        }

        public File k(int i2) {
            return this.f8972d[i2];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f8970b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private d(String str) {
            this.a = str;
            this.f8970b = new long[a.this.l];
            this.f8971c = new File[a.this.l];
            this.f8972d = new File[a.this.l];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.l; i2++) {
                sb.append(i2);
                this.f8971c[i2] = new File(a.this.f8960f, sb.toString());
                sb.append(".tmp");
                this.f8972d[i2] = new File(a.this.f8960f, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8977b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f8978c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f8979d;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0121a callableC0121a) {
            this(str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return this.f8979d[i2];
        }

        private e(String str, long j2, File[] fileArr, long[] jArr) {
            this.a = str;
            this.f8977b = j2;
            this.f8979d = fileArr;
            this.f8978c = jArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.f8960f = file;
        this.f8964j = i2;
        this.f8961g = new File(file, "journal");
        this.f8962h = new File(file, "journal.tmp");
        this.f8963i = new File(file, "journal.bkp");
        this.l = i3;
        this.f8965k = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        int i2 = this.p;
        return i2 >= 2000 && i2 >= this.o.size();
    }

    public static a D(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    Q(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f8961g.exists()) {
                try {
                    aVar.I();
                    aVar.H();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.p();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.K();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void H() throws IOException {
        x(this.f8962h);
        Iterator<d> it = this.o.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f8974f != null) {
                next.f8974f = null;
                while (i2 < this.l) {
                    x(next.j(i2));
                    x(next.k(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.l) {
                    this.m += next.f8970b[i2];
                    i2++;
                }
            }
        }
    }

    private void I() throws IOException {
        com.bumptech.glide.k.b bVar = new com.bumptech.glide.k.b(new FileInputStream(this.f8961g), com.bumptech.glide.k.c.a);
        try {
            String d2 = bVar.d();
            String d3 = bVar.d();
            String d4 = bVar.d();
            String d5 = bVar.d();
            String d6 = bVar.d();
            if (!"libcore.io.DiskLruCache".equals(d2) || !"1".equals(d3) || !Integer.toString(this.f8964j).equals(d4) || !Integer.toString(this.l).equals(d5) || !HttpUrl.FRAGMENT_ENCODE_SET.equals(d6)) {
                throw new IOException("unexpected journal header: [" + d2 + ", " + d3 + ", " + d5 + ", " + d6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    J(bVar.d());
                    i2++;
                } catch (EOFException unused) {
                    this.p = i2 - this.o.size();
                    if (bVar.c()) {
                        K();
                    } else {
                        this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8961g, true), com.bumptech.glide.k.c.a));
                    }
                    com.bumptech.glide.k.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.k.c.a(bVar);
            throw th;
        }
    }

    private void J(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.o.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            d dVar = this.o.get(substring);
            CallableC0121a callableC0121a = null;
            if (dVar == null) {
                dVar = new d(this, substring, callableC0121a);
                this.o.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f8973e = true;
                dVar.f8974f = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f8974f = new c(this, dVar, callableC0121a);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void K() throws IOException {
        Writer writer = this.n;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8962h), com.bumptech.glide.k.c.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f8964j));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.l));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.o.values()) {
                if (dVar.f8974f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f8961g.exists()) {
                Q(this.f8961g, this.f8963i, true);
            }
            Q(this.f8962h, this.f8961g, false);
            this.f8963i.delete();
            this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8961g, true), com.bumptech.glide.k.c.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void Q(File file, File file2, boolean z) throws IOException {
        if (z) {
            x(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() throws IOException {
        while (this.m > this.f8965k) {
            N(this.o.entrySet().iterator().next().getKey());
        }
    }

    private void l() {
        if (this.n == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f8974f == cVar) {
            if (z && !dVar.f8973e) {
                for (int i2 = 0; i2 < this.l; i2++) {
                    if (cVar.f8967b[i2]) {
                        if (!dVar.k(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.l; i3++) {
                File k2 = dVar.k(i3);
                if (z) {
                    if (k2.exists()) {
                        File j2 = dVar.j(i3);
                        k2.renameTo(j2);
                        long j3 = dVar.f8970b[i3];
                        long length = j2.length();
                        dVar.f8970b[i3] = length;
                        this.m = (this.m - j3) + length;
                    }
                } else {
                    x(k2);
                }
            }
            this.p++;
            dVar.f8974f = null;
            if (dVar.f8973e | z) {
                dVar.f8973e = true;
                this.n.append((CharSequence) "CLEAN");
                this.n.append(' ');
                this.n.append((CharSequence) dVar.a);
                this.n.append((CharSequence) dVar.l());
                this.n.append('\n');
                if (z) {
                    long j4 = this.q;
                    this.q = 1 + j4;
                    dVar.f8975g = j4;
                }
            } else {
                this.o.remove(dVar.a);
                this.n.append((CharSequence) "REMOVE");
                this.n.append(' ');
                this.n.append((CharSequence) dVar.a);
                this.n.append('\n');
            }
            this.n.flush();
            if (this.m > this.f8965k || B()) {
                this.r.submit(this.s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void x(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c z(String str, long j2) throws IOException {
        l();
        d dVar = this.o.get(str);
        CallableC0121a callableC0121a = null;
        if (j2 != -1 && (dVar == null || dVar.f8975g != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f8974f != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, callableC0121a);
            this.o.put(str, dVar);
        }
        c cVar = new c(this, dVar, callableC0121a);
        dVar.f8974f = cVar;
        this.n.append((CharSequence) "DIRTY");
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        this.n.flush();
        return cVar;
    }

    public synchronized e A(String str) throws IOException {
        l();
        d dVar = this.o.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f8973e) {
            return null;
        }
        for (File file : dVar.f8971c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.p++;
        this.n.append((CharSequence) "READ");
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        if (B()) {
            this.r.submit(this.s);
        }
        return new e(this, str, dVar.f8975g, dVar.f8971c, dVar.f8970b, null);
    }

    public synchronized boolean N(String str) throws IOException {
        l();
        d dVar = this.o.get(str);
        if (dVar != null && dVar.f8974f == null) {
            for (int i2 = 0; i2 < this.l; i2++) {
                File j2 = dVar.j(i2);
                if (j2.exists() && !j2.delete()) {
                    throw new IOException("failed to delete " + j2);
                }
                this.m -= dVar.f8970b[i2];
                dVar.f8970b[i2] = 0;
            }
            this.p++;
            this.n.append((CharSequence) "REMOVE");
            this.n.append(' ');
            this.n.append((CharSequence) str);
            this.n.append('\n');
            this.o.remove(str);
            if (B()) {
                this.r.submit(this.s);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.n == null) {
            return;
        }
        Iterator it = new ArrayList(this.o.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f8974f != null) {
                dVar.f8974f.a();
            }
        }
        T();
        this.n.close();
        this.n = null;
    }

    public void p() throws IOException {
        close();
        com.bumptech.glide.k.c.b(this.f8960f);
    }

    public c y(String str) throws IOException {
        return z(str, -1L);
    }
}
