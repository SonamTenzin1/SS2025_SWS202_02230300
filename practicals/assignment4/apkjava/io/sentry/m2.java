package io.sentry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: JsonObjectDeserializer.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class m2 {
    private final ArrayList<c> a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.sentry.vendor.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[io.sentry.vendor.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public interface b {
        Object a() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public interface c {
        Object getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public static final class f implements c {
        final String a;

        f(String str) {
            this.a = str;
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public static final class g implements c {
        final Object a;

        g(Object obj) {
            this.a = obj;
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }
    }

    private c b() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(r0.size() - 1);
    }

    private boolean c() {
        if (e()) {
            return true;
        }
        c b2 = b();
        m();
        if (b() instanceof f) {
            f fVar = (f) b();
            m();
            e eVar = (e) b();
            if (fVar == null || b2 == null || eVar == null) {
                return false;
            }
            eVar.a.put(fVar.a, b2.getValue());
            return false;
        }
        if (!(b() instanceof d)) {
            return false;
        }
        d dVar = (d) b();
        if (b2 == null || dVar == null) {
            return false;
        }
        dVar.a.add(b2.getValue());
        return false;
    }

    private boolean d(b bVar) throws IOException {
        Object a2 = bVar.a();
        if (b() == null && a2 != null) {
            n(new g(a2));
            return true;
        }
        if (b() instanceof f) {
            f fVar = (f) b();
            m();
            ((e) b()).a.put(fVar.a, a2);
            return false;
        }
        if (!(b() instanceof d)) {
            return false;
        }
        ((d) b()).a.add(a2);
        return false;
    }

    private boolean e() {
        return this.a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object j() throws IOException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Object h(n2 n2Var) throws IOException {
        try {
            try {
                return Integer.valueOf(n2Var.z());
            } catch (Exception unused) {
                return Double.valueOf(n2Var.y());
            }
        } catch (Exception unused2) {
            return Long.valueOf(n2Var.A());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void l(final n2 n2Var) throws IOException {
        boolean z;
        a aVar = null;
        switch (a.a[n2Var.N().ordinal()]) {
            case 1:
                n2Var.a();
                n(new d(aVar));
                z = false;
                break;
            case 2:
                n2Var.f();
                z = c();
                break;
            case 3:
                n2Var.b();
                n(new e(aVar));
                z = false;
                break;
            case 4:
                n2Var.j();
                z = c();
                break;
            case 5:
                n(new f(n2Var.B()));
                z = false;
                break;
            case 6:
                z = d(new b() { // from class: io.sentry.k
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        Object J;
                        J = n2.this.J();
                        return J;
                    }
                });
                break;
            case 7:
                z = d(new b() { // from class: io.sentry.l
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        return m2.this.h(n2Var);
                    }
                });
                break;
            case 8:
                z = d(new b() { // from class: io.sentry.m
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        Object valueOf;
                        valueOf = Boolean.valueOf(n2.this.x());
                        return valueOf;
                    }
                });
                break;
            case 9:
                n2Var.H();
                z = d(new b() { // from class: io.sentry.j
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        m2.j();
                        return null;
                    }
                });
                break;
            case 10:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            return;
        }
        l(n2Var);
    }

    private void m() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.remove(r0.size() - 1);
    }

    private void n(c cVar) {
        this.a.add(cVar);
    }

    public Object a(n2 n2Var) throws IOException {
        l(n2Var);
        c b2 = b();
        if (b2 != null) {
            return b2.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public static final class d implements c {
        final ArrayList<Object> a;

        private d() {
            this.a = new ArrayList<>();
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonObjectDeserializer.java */
    /* loaded from: classes2.dex */
    public static final class e implements c {
        final HashMap<String, Object> a;

        private e() {
            this.a = new HashMap<>();
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
