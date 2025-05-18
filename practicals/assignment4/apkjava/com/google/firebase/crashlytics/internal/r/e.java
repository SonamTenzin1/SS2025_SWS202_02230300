package com.google.firebase.crashlytics.internal.r;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.b0;
import com.google.firebase.crashlytics.internal.n.v;
import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.p.h0.j;
import com.google.firebase.crashlytics.internal.t.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;

/* compiled from: CrashlyticsReportPersistence.java */
/* loaded from: classes2.dex */
public class e {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private static final int f19507b = 15;

    /* renamed from: c, reason: collision with root package name */
    private static final j f19508c = new j();

    /* renamed from: d, reason: collision with root package name */
    private static final Comparator<? super File> f19509d = new Comparator() { // from class: com.google.firebase.crashlytics.h.r.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compareTo;
            compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
            return compareTo;
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final FilenameFilter f19510e = new FilenameFilter() { // from class: com.google.firebase.crashlytics.h.r.d
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean startsWith;
            startsWith = str.startsWith("event");
            return startsWith;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f19511f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private final f f19512g;

    /* renamed from: h, reason: collision with root package name */
    private final i f19513h;

    /* renamed from: i, reason: collision with root package name */
    private final v f19514i;

    public e(f fVar, i iVar, v vVar) {
        this.f19512g = fVar;
        this.f19513h = iVar;
        this.f19514i = vVar;
    }

    private void A(String str, long j2) {
        boolean z;
        List<File> p = this.f19512g.p(str, f19510e);
        if (p.isEmpty()) {
            h.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(p);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z = false;
            for (File file : p) {
                try {
                    arrayList.add(f19508c.a(y(file)));
                } catch (IOException e2) {
                    h.f().l("Could not add event to report for " + file, e2);
                }
                if (z || o(file.getName())) {
                    z = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            h.f().k("Could not parse event files for session " + str);
            return;
        }
        B(this.f19512g.o(str, "report"), arrayList, j2, z, l.i(str, this.f19512g), this.f19514i.d(str));
    }

    private void B(File file, List<f0.e.d> list, long j2, boolean z, String str, String str2) {
        File l;
        try {
            j jVar = f19508c;
            f0 q = jVar.L(y(file)).t(j2, z, str).o(str2).q(list);
            f0.e m = q.m();
            if (m == null) {
                return;
            }
            h.f().b("appQualitySessionId: " + str2);
            if (z) {
                l = this.f19512g.j(m.i());
            } else {
                l = this.f19512g.l(m.i());
            }
            D(l, jVar.M(q));
        } catch (IOException e2) {
            h.f().l("Could not synthesize final report file for " + file, e2);
        }
    }

    private int C(String str, int i2) {
        List<File> p = this.f19512g.p(str, new FilenameFilter() { // from class: com.google.firebase.crashlytics.h.r.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean p2;
                p2 = e.p(file, str2);
                return p2;
            }
        });
        Collections.sort(p, new Comparator() { // from class: com.google.firebase.crashlytics.h.r.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int v;
                v = e.v((File) obj, (File) obj2);
                return v;
            }
        });
        return b(p, i2);
    }

    private static void D(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), a);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private static void E(File file, String str, long j2) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), a);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(d(j2));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private SortedSet<String> a(String str) {
        this.f19512g.b();
        SortedSet<String> l = l();
        if (str != null) {
            l.remove(str);
        }
        if (l.size() <= 8) {
            return l;
        }
        while (l.size() > 8) {
            String last = l.last();
            h.f().b("Removing session over cap: " + last);
            this.f19512g.c(last);
            l.remove(last);
        }
        return l;
    }

    private static int b(List<File> list, int i2) {
        int size = list.size();
        for (File file : list) {
            if (size <= i2) {
                return size;
            }
            f.s(file);
            size--;
        }
        return size;
    }

    private void c() {
        int i2 = this.f19513h.b().a.f19554b;
        List<File> j2 = j();
        int size = j2.size();
        if (size <= i2) {
            return;
        }
        Iterator<File> it = j2.subList(i2, size).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    private static long d(long j2) {
        return j2 * 1000;
    }

    private void f(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    private static String i(int i2, boolean z) {
        return "event" + String.format(Locale.US, "%010d", Integer.valueOf(i2)) + (z ? "_" : HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private List<File> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f19512g.k());
        arrayList.addAll(this.f19512g.h());
        Comparator<? super File> comparator = f19509d;
        Collections.sort(arrayList, comparator);
        List<File> m = this.f19512g.m();
        Collections.sort(m, comparator);
        arrayList.addAll(m);
        return arrayList;
    }

    private static String k(String str) {
        return str.substring(0, f19507b);
    }

    private static boolean o(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int v(File file, File file2) {
        return k(file.getName()).compareTo(k(file2.getName()));
    }

    private static String y(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), a);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
    }

    private void z(File file, f0.d dVar, String str, f0.a aVar) {
        String d2 = this.f19514i.d(str);
        try {
            j jVar = f19508c;
            D(this.f19512g.g(str), jVar.M(jVar.L(y(file)).s(dVar).p(aVar).o(d2)));
        } catch (IOException e2) {
            h.f().l("Could not synthesize final native report file for " + file, e2);
        }
    }

    public void e() {
        f(this.f19512g.m());
        f(this.f19512g.k());
        f(this.f19512g.h());
    }

    public void g(String str, long j2) {
        for (String str2 : a(str)) {
            h.f().i("Finalizing report for session " + str2);
            A(str2, j2);
            this.f19512g.c(str2);
        }
        c();
    }

    public void h(String str, f0.d dVar, f0.a aVar) {
        File o = this.f19512g.o(str, "report");
        h.f().b("Writing native session report for " + str + " to file: " + o);
        z(o, dVar, str, aVar);
    }

    public SortedSet<String> l() {
        return new TreeSet(this.f19512g.d()).descendingSet();
    }

    public long m(String str) {
        return this.f19512g.o(str, "start-time").lastModified();
    }

    public boolean n() {
        return (this.f19512g.m().isEmpty() && this.f19512g.k().isEmpty() && this.f19512g.h().isEmpty()) ? false : true;
    }

    public List<b0> u() {
        List<File> j2 = j();
        ArrayList arrayList = new ArrayList();
        for (File file : j2) {
            try {
                arrayList.add(b0.a(f19508c.L(y(file)), file.getName(), file));
            } catch (IOException e2) {
                h.f().l("Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        return arrayList;
    }

    public void w(f0.e.d dVar, String str, boolean z) {
        int i2 = this.f19513h.b().a.a;
        try {
            D(this.f19512g.o(str, i(this.f19511f.getAndIncrement(), z)), f19508c.b(dVar));
        } catch (IOException e2) {
            h.f().l("Could not persist event for session " + str, e2);
        }
        C(str, i2);
    }

    public void x(f0 f0Var) {
        f0.e m = f0Var.m();
        if (m == null) {
            h.f().b("Could not get session for report");
            return;
        }
        String i2 = m.i();
        try {
            D(this.f19512g.o(i2, "report"), f19508c.M(f0Var));
            E(this.f19512g.o(i2, "start-time"), HttpUrl.FRAGMENT_ENCODE_SET, m.l());
        } catch (IOException e2) {
            h.f().c("Could not persist report for session " + i2, e2);
        }
    }
}
