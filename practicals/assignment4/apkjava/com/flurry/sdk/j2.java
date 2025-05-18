package com.flurry.sdk;

import com.flurry.sdk.g0;
import com.flurry.sdk.i2;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class j2 extends l2 implements v6 {
    private PriorityQueue<String> o;
    private p0 p;
    private p0 q;

    /* loaded from: classes2.dex */
    final class a extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f10844h;

        a(List list) {
            this.f10844h = list;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            j2.this.o.addAll(this.f10844h);
            j2.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements o0 {
        b() {
        }

        @Override // com.flurry.sdk.o0
        public final void a() {
            j2.t(true);
        }

        @Override // com.flurry.sdk.o0
        public final void d() {
            j2.t(false);
        }
    }

    public j2() {
        super("FrameLogDataSender", i2.a(i2.b.CORE));
        this.o = null;
        this.o = new PriorityQueue<>(4, new s2());
        this.p = new u0();
        this.q = new t0();
    }

    private synchronized void h(String str) {
        d1.l("FrameLogDataSender", "File upload status: ".concat(String.valueOf(str)));
        d1.c(2, "FrameLogDataSender", "Deleting file " + str + " deleted " + q2.b(str));
        w();
    }

    static /* synthetic */ void t(boolean z) {
        m2.a().b(new e6(new f6(z)));
    }

    private static byte[] u(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                int read = fileInputStream.read(bArr, 0, length);
                if (read < length) {
                    int i2 = length - read;
                    while (i2 > 0) {
                        int read2 = fileInputStream.read(bArr2, 0, i2);
                        System.arraycopy(bArr2, 0, bArr, length - i2, read2);
                        i2 -= read2;
                    }
                }
            } catch (IOException e2) {
                d1.c(6, "FrameLogDataSender", "Error reading file. ".concat(String.valueOf(e2)));
            }
            return bArr;
        } finally {
            fileInputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        d1.l("FrameLogDataSender", " Starting processNextFile " + this.o.size());
        if (this.o.peek() == null) {
            d1.l("FrameLogDataSender", "No file present to process.");
            return;
        }
        String poll = this.o.poll();
        if (q2.d(poll)) {
            d1.l("FrameLogDataSender", "Starting to upload file: ".concat(String.valueOf(poll)));
            byte[] bArr = new byte[0];
            try {
                bArr = u(new File(poll));
            } catch (IOException e2) {
                d1.c(6, "FrameLogDataSender", "Error in getting bytes form the file: " + e2.getMessage());
            }
            String b2 = k0.a().b();
            StringBuilder sb = new StringBuilder();
            n0.a();
            sb.append(328);
            this.p.w(bArr, b2, sb.toString());
            this.p.v(new b());
            h(poll);
            d1.l("FrameLogDataSender", "File appended for upload: ".concat(String.valueOf(poll)));
            return;
        }
        d1.c(6, "FrameLogDataSender", "Something wrong with the file. File does not exist.");
    }

    @Override // com.flurry.sdk.v6
    public final void a() {
        this.p.a();
        this.q.a();
    }

    @Override // com.flurry.sdk.v6
    public final g0.c d() {
        p0 p0Var = this.p;
        g0.c cVar = new g0.c();
        Iterator<String> it = p0Var.s.a().iterator();
        while (it.hasNext()) {
            cVar.a(p0Var.s.k(it.next()).size());
        }
        return cVar;
    }

    @Override // com.flurry.sdk.v6
    public final void e(List<String> list) {
        if (list.size() == 0) {
            d1.c(6, "FrameLogDataSender", "File List is null or empty");
            return;
        }
        d1.l("FrameLogDataSender", "Number of files being added:" + list.toString());
        m(new a(list));
    }
}
