package com.facebook.o0.r0;

import com.facebook.o0.r0.h;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.q0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.s;

/* compiled from: Model.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f10447b;

    /* renamed from: c, reason: collision with root package name */
    private final f f10448c;

    /* renamed from: d, reason: collision with root package name */
    private final f f10449d;

    /* renamed from: e, reason: collision with root package name */
    private final f f10450e;

    /* renamed from: f, reason: collision with root package name */
    private final f f10451f;

    /* renamed from: g, reason: collision with root package name */
    private final f f10452g;

    /* renamed from: h, reason: collision with root package name */
    private final f f10453h;

    /* renamed from: i, reason: collision with root package name */
    private final f f10454i;

    /* renamed from: j, reason: collision with root package name */
    private final f f10455j;

    /* renamed from: k, reason: collision with root package name */
    private final f f10456k;
    private final f l;
    private final f m;
    private final Map<String, f> n;

    /* compiled from: Model.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final Map<String, f> b(File file) {
            j jVar = j.a;
            Map<String, f> c2 = j.c(file);
            if (c2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Map map = g.f10447b;
            for (Map.Entry<String, f> entry : c2.entrySet()) {
                String key = entry.getKey();
                if (map.containsKey(entry.getKey()) && (key = (String) map.get(entry.getKey())) == null) {
                    return null;
                }
                hashMap.put(key, entry.getValue());
            }
            return hashMap;
        }

        public final g a(File file) {
            m.f(file, "file");
            Map<String, f> b2 = b(file);
            kotlin.jvm.internal.g gVar = null;
            if (b2 == null) {
                return null;
            }
            try {
                return new g(b2, gVar);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static {
        HashMap k2;
        k2 = q0.k(s.a("embedding.weight", "embed.weight"), s.a("dense1.weight", "fc1.weight"), s.a("dense2.weight", "fc2.weight"), s.a("dense3.weight", "fc3.weight"), s.a("dense1.bias", "fc1.bias"), s.a("dense2.bias", "fc2.bias"), s.a("dense3.bias", "fc3.bias"));
        f10447b = k2;
    }

    private g(Map<String, f> map) {
        Set<String> i2;
        f fVar = map.get("embed.weight");
        if (fVar != null) {
            this.f10448c = fVar;
            i iVar = i.a;
            f fVar2 = map.get("convs.0.weight");
            if (fVar2 != null) {
                this.f10449d = i.l(fVar2);
                f fVar3 = map.get("convs.1.weight");
                if (fVar3 != null) {
                    this.f10450e = i.l(fVar3);
                    f fVar4 = map.get("convs.2.weight");
                    if (fVar4 != null) {
                        this.f10451f = i.l(fVar4);
                        f fVar5 = map.get("convs.0.bias");
                        if (fVar5 != null) {
                            this.f10452g = fVar5;
                            f fVar6 = map.get("convs.1.bias");
                            if (fVar6 != null) {
                                this.f10453h = fVar6;
                                f fVar7 = map.get("convs.2.bias");
                                if (fVar7 != null) {
                                    this.f10454i = fVar7;
                                    f fVar8 = map.get("fc1.weight");
                                    if (fVar8 != null) {
                                        this.f10455j = i.k(fVar8);
                                        f fVar9 = map.get("fc2.weight");
                                        if (fVar9 != null) {
                                            this.f10456k = i.k(fVar9);
                                            f fVar10 = map.get("fc1.bias");
                                            if (fVar10 != null) {
                                                this.l = fVar10;
                                                f fVar11 = map.get("fc2.bias");
                                                if (fVar11 != null) {
                                                    this.m = fVar11;
                                                    this.n = new HashMap();
                                                    i2 = w0.i(h.a.MTML_INTEGRITY_DETECT.k(), h.a.MTML_APP_EVENT_PREDICTION.k());
                                                    for (String str : i2) {
                                                        String n = m.n(str, ".weight");
                                                        String n2 = m.n(str, ".bias");
                                                        f fVar12 = map.get(n);
                                                        f fVar13 = map.get(n2);
                                                        if (fVar12 != null) {
                                                            i iVar2 = i.a;
                                                            this.n.put(n, i.k(fVar12));
                                                        }
                                                        if (fVar13 != null) {
                                                            this.n.put(n2, fVar13);
                                                        }
                                                    }
                                                    return;
                                                }
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public /* synthetic */ g(Map map, kotlin.jvm.internal.g gVar) {
        this(map);
    }

    public final f b(f fVar, String[] strArr, String str) {
        m.f(fVar, "dense");
        m.f(strArr, "texts");
        m.f(str, "task");
        i iVar = i.a;
        f c2 = i.c(i.e(strArr, 128, this.f10448c), this.f10449d);
        i.a(c2, this.f10452g);
        i.i(c2);
        f c3 = i.c(c2, this.f10450e);
        i.a(c3, this.f10453h);
        i.i(c3);
        f g2 = i.g(c3, 2);
        f c4 = i.c(g2, this.f10451f);
        i.a(c4, this.f10454i);
        i.i(c4);
        f g3 = i.g(c2, c2.b(1));
        f g4 = i.g(g2, g2.b(1));
        f g5 = i.g(c4, c4.b(1));
        i.f(g3, 1);
        i.f(g4, 1);
        i.f(g5, 1);
        f d2 = i.d(i.b(new f[]{g3, g4, g5, fVar}), this.f10455j, this.l);
        i.i(d2);
        f d3 = i.d(d2, this.f10456k, this.m);
        i.i(d3);
        f fVar2 = this.n.get(m.n(str, ".weight"));
        f fVar3 = this.n.get(m.n(str, ".bias"));
        if (fVar2 == null || fVar3 == null) {
            return null;
        }
        f d4 = i.d(d3, fVar2, fVar3);
        i.j(d4);
        return d4;
    }
}
