package io.sentry;

import io.sentry.clientreport.b;
import io.sentry.d5;
import io.sentry.f5;
import io.sentry.h5;
import io.sentry.i4;
import io.sentry.j5;
import io.sentry.k4;
import io.sentry.l4;
import io.sentry.m3;
import io.sentry.n3;
import io.sentry.profilemeasurements.a;
import io.sentry.profilemeasurements.b;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.a;
import io.sentry.protocol.a0;
import io.sentry.protocol.b;
import io.sentry.protocol.b0;
import io.sentry.protocol.c;
import io.sentry.protocol.c0;
import io.sentry.protocol.d;
import io.sentry.protocol.e;
import io.sentry.protocol.f;
import io.sentry.protocol.g;
import io.sentry.protocol.h;
import io.sentry.protocol.i;
import io.sentry.protocol.j;
import io.sentry.protocol.k;
import io.sentry.protocol.l;
import io.sentry.protocol.n;
import io.sentry.protocol.o;
import io.sentry.protocol.p;
import io.sentry.protocol.r;
import io.sentry.protocol.s;
import io.sentry.protocol.t;
import io.sentry.protocol.u;
import io.sentry.protocol.v;
import io.sentry.protocol.w;
import io.sentry.protocol.x;
import io.sentry.r4;
import io.sentry.s4;
import io.sentry.t4;
import io.sentry.v0;
import io.sentry.w5;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: JsonSerializer.java */
/* loaded from: classes2.dex */
public final class s2 implements c2 {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22696b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, l2<?>> f22697c;

    public s2(x4 x4Var) {
        this.f22696b = x4Var;
        HashMap hashMap = new HashMap();
        this.f22697c = hashMap;
        hashMap.put(io.sentry.protocol.a.class, new a.C0308a());
        hashMap.put(v0.class, new v0.a());
        hashMap.put(io.sentry.protocol.b.class, new b.a());
        hashMap.put(io.sentry.protocol.c.class, new c.a());
        hashMap.put(DebugImage.class, new DebugImage.a());
        hashMap.put(io.sentry.protocol.d.class, new d.a());
        hashMap.put(io.sentry.protocol.e.class, new e.a());
        hashMap.put(e.b.class, new e.b.a());
        hashMap.put(io.sentry.protocol.g.class, new g.a());
        hashMap.put(io.sentry.protocol.h.class, new h.a());
        hashMap.put(io.sentry.protocol.i.class, new i.a());
        hashMap.put(io.sentry.protocol.j.class, new j.a());
        hashMap.put(io.sentry.protocol.k.class, new k.a());
        hashMap.put(m3.class, new m3.b());
        hashMap.put(n3.class, new n3.a());
        hashMap.put(io.sentry.profilemeasurements.a.class, new a.C0307a());
        hashMap.put(io.sentry.profilemeasurements.b.class, new b.a());
        hashMap.put(io.sentry.protocol.l.class, new l.a());
        hashMap.put(io.sentry.protocol.n.class, new n.a());
        hashMap.put(io.sentry.protocol.o.class, new o.a());
        hashMap.put(i4.class, new i4.a());
        hashMap.put(k4.class, new k4.a());
        hashMap.put(l4.class, new l4.a());
        hashMap.put(io.sentry.protocol.p.class, new p.a());
        hashMap.put(r4.class, new r4.a());
        hashMap.put(s4.class, new s4.a());
        hashMap.put(t4.class, new t4.a());
        hashMap.put(io.sentry.protocol.r.class, new r.a());
        hashMap.put(io.sentry.protocol.s.class, new s.a());
        hashMap.put(io.sentry.protocol.t.class, new t.a());
        hashMap.put(io.sentry.protocol.u.class, new u.a());
        hashMap.put(io.sentry.protocol.v.class, new v.a());
        hashMap.put(io.sentry.protocol.w.class, new w.a());
        hashMap.put(io.sentry.protocol.x.class, new x.a());
        hashMap.put(d5.class, new d5.a());
        hashMap.put(f5.class, new f5.a());
        hashMap.put(h5.class, new h5.a());
        hashMap.put(j5.class, new j5.a());
        hashMap.put(io.sentry.protocol.a0.class, new a0.a());
        hashMap.put(io.sentry.protocol.f.class, new f.a());
        hashMap.put(w5.class, new w5.a());
        hashMap.put(io.sentry.clientreport.b.class, new b.a());
        hashMap.put(io.sentry.protocol.c0.class, new c0.a());
        hashMap.put(io.sentry.protocol.b0.class, new b0.a());
    }

    private <T> boolean g(Class<T> cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || String.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    private String h(Object obj, boolean z) throws IOException {
        StringWriter stringWriter = new StringWriter();
        p2 p2Var = new p2(stringWriter, this.f22696b.getMaxDepth());
        if (z) {
            p2Var.s("\t");
        }
        p2Var.g(this.f22696b.getLogger(), obj);
        return stringWriter.toString();
    }

    @Override // io.sentry.c2
    public <T> void a(T t, Writer writer) throws IOException {
        io.sentry.util.q.c(t, "The entity is required.");
        io.sentry.util.q.c(writer, "The Writer object is required.");
        w1 logger = this.f22696b.getLogger();
        s4 s4Var = s4.DEBUG;
        if (logger.d(s4Var)) {
            this.f22696b.getLogger().c(s4Var, "Serializing object: %s", h(t, this.f22696b.isEnablePrettySerializationOutput()));
        }
        new p2(writer, this.f22696b.getMaxDepth()).g(this.f22696b.getLogger(), t);
        writer.flush();
    }

    @Override // io.sentry.c2
    public void b(h4 h4Var, OutputStream outputStream) throws Exception {
        io.sentry.util.q.c(h4Var, "The SentryEnvelope object is required.");
        io.sentry.util.q.c(outputStream, "The Stream object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), a));
        try {
            h4Var.b().serialize(new p2(bufferedWriter, this.f22696b.getMaxDepth()), this.f22696b.getLogger());
            bufferedWriter.write("\n");
            for (j4 j4Var : h4Var.c()) {
                try {
                    byte[] h2 = j4Var.h();
                    j4Var.i().serialize(new p2(bufferedWriter, this.f22696b.getMaxDepth()), this.f22696b.getLogger());
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                    outputStream.write(h2);
                    bufferedWriter.write("\n");
                } catch (Exception e2) {
                    this.f22696b.getLogger().b(s4.ERROR, "Failed to create envelope item. Dropping it.", e2);
                }
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    @Override // io.sentry.c2
    public <T> T c(Reader reader, Class<T> cls) {
        try {
            n2 n2Var = new n2(reader);
            try {
                l2<?> l2Var = this.f22697c.get(cls);
                if (l2Var != null) {
                    T cast = cls.cast(l2Var.a(n2Var, this.f22696b.getLogger()));
                    n2Var.close();
                    return cast;
                }
                if (!g(cls)) {
                    n2Var.close();
                    return null;
                }
                T t = (T) n2Var.K0();
                n2Var.close();
                return t;
            } catch (Throwable th) {
                try {
                    n2Var.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error when deserializing", e2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public h4 d(InputStream inputStream) {
        io.sentry.util.q.c(inputStream, "The InputStream object is required.");
        try {
            return this.f22696b.getEnvelopeReader().a(inputStream);
        } catch (IOException e2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error deserializing envelope.", e2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public <T, R> T e(Reader reader, Class<T> cls, l2<R> l2Var) {
        try {
            n2 n2Var = new n2(reader);
            try {
                if (!Collection.class.isAssignableFrom(cls)) {
                    T t = (T) n2Var.K0();
                    n2Var.close();
                    return t;
                }
                if (l2Var == null) {
                    T t2 = (T) n2Var.K0();
                    n2Var.close();
                    return t2;
                }
                T t3 = (T) n2Var.F0(this.f22696b.getLogger(), l2Var);
                n2Var.close();
                return t3;
            } catch (Throwable th) {
                try {
                    n2Var.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error when deserializing", th2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public String f(Map<String, Object> map) throws Exception {
        return h(map, false);
    }
}
