package com.squareup.moshi;

import com.squareup.moshi.i;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: JsonValueReader.java */
/* loaded from: classes2.dex */
final class m extends i {
    private static final Object l = new Object();
    private Object[] m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonValueReader.java */
    /* loaded from: classes2.dex */
    public static final class a implements Iterator<Object>, Cloneable {

        /* renamed from: f, reason: collision with root package name */
        final i.b f20569f;

        /* renamed from: g, reason: collision with root package name */
        final Object[] f20570g;

        /* renamed from: h, reason: collision with root package name */
        int f20571h;

        a(i.b bVar, Object[] objArr, int i2) {
            this.f20569f = bVar;
            this.f20570g = objArr;
            this.f20571h = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a clone() {
            return new a(this.f20569f, this.f20570g, this.f20571h);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20571h < this.f20570g.length;
        }

        @Override // java.util.Iterator
        public Object next() {
            Object[] objArr = this.f20570g;
            int i2 = this.f20571h;
            this.f20571h = i2 + 1;
            return objArr[i2];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Object obj) {
        int[] iArr = this.f20557g;
        int i2 = this.f20556f;
        iArr[i2] = 7;
        Object[] objArr = new Object[32];
        this.m = objArr;
        this.f20556f = i2 + 1;
        objArr[i2] = obj;
    }

    private void Z(Object obj) {
        int i2 = this.f20556f;
        if (i2 == this.m.length) {
            if (i2 != 256) {
                int[] iArr = this.f20557g;
                this.f20557g = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f20558h;
                this.f20558h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f20559i;
                this.f20559i = Arrays.copyOf(iArr2, iArr2.length * 2);
                Object[] objArr = this.m;
                this.m = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + g());
            }
        }
        Object[] objArr2 = this.m;
        int i3 = this.f20556f;
        this.f20556f = i3 + 1;
        objArr2[i3] = obj;
    }

    private void a0() {
        int i2 = this.f20556f - 1;
        this.f20556f = i2;
        Object[] objArr = this.m;
        objArr[i2] = null;
        this.f20557g[i2] = 0;
        if (i2 > 0) {
            int[] iArr = this.f20559i;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            Object obj = objArr[i2 - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    Z(it.next());
                }
            }
        }
    }

    private <T> T e0(Class<T> cls, i.b bVar) throws IOException {
        int i2 = this.f20556f;
        Object obj = i2 != 0 ? this.m[i2 - 1] : null;
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && bVar == i.b.NULL) {
            return null;
        }
        if (obj == l) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw W(obj, bVar);
    }

    private String f0(Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw W(key, i.b.NAME);
    }

    @Override // com.squareup.moshi.i
    public i.b A() throws IOException {
        int i2 = this.f20556f;
        if (i2 == 0) {
            return i.b.END_DOCUMENT;
        }
        Object obj = this.m[i2 - 1];
        if (obj instanceof a) {
            return ((a) obj).f20569f;
        }
        if (obj instanceof List) {
            return i.b.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return i.b.BEGIN_OBJECT;
        }
        if (obj instanceof Map.Entry) {
            return i.b.NAME;
        }
        if (obj instanceof String) {
            return i.b.STRING;
        }
        if (obj instanceof Boolean) {
            return i.b.BOOLEAN;
        }
        if (obj instanceof Number) {
            return i.b.NUMBER;
        }
        if (obj == null) {
            return i.b.NULL;
        }
        if (obj == l) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw W(obj, "a JSON value");
    }

    @Override // com.squareup.moshi.i
    public void B() throws IOException {
        if (f()) {
            Z(Y());
        }
    }

    @Override // com.squareup.moshi.i
    public int H(i.a aVar) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) e0(Map.Entry.class, i.b.NAME);
        String f0 = f0(entry);
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (aVar.a[i2].equals(f0)) {
                this.m[this.f20556f - 1] = entry.getValue();
                this.f20558h[this.f20556f - 2] = f0;
                return i2;
            }
        }
        return -1;
    }

    @Override // com.squareup.moshi.i
    public int I(i.a aVar) throws IOException {
        int i2 = this.f20556f;
        Object obj = i2 != 0 ? this.m[i2 - 1] : null;
        if (!(obj instanceof String)) {
            if (obj != l) {
                return -1;
            }
            throw new IllegalStateException("JsonReader is closed");
        }
        String str = (String) obj;
        int length = aVar.a.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (aVar.a[i3].equals(str)) {
                a0();
                return i3;
            }
        }
        return -1;
    }

    @Override // com.squareup.moshi.i
    public void N() throws IOException {
        if (!this.f20561k) {
            this.m[this.f20556f - 1] = ((Map.Entry) e0(Map.Entry.class, i.b.NAME)).getValue();
            this.f20558h[this.f20556f - 2] = "null";
            return;
        }
        i.b A = A();
        Y();
        throw new JsonDataException("Cannot skip unexpected " + A + " at " + g());
    }

    @Override // com.squareup.moshi.i
    public void Q() throws IOException {
        if (!this.f20561k) {
            int i2 = this.f20556f;
            if (i2 > 1) {
                this.f20558h[i2 - 2] = "null";
            }
            Object obj = i2 != 0 ? this.m[i2 - 1] : null;
            if (!(obj instanceof a)) {
                if (obj instanceof Map.Entry) {
                    Object[] objArr = this.m;
                    objArr[i2 - 1] = ((Map.Entry) objArr[i2 - 1]).getValue();
                    return;
                } else {
                    if (i2 > 0) {
                        a0();
                        return;
                    }
                    throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                }
            }
            throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
        }
        throw new JsonDataException("Cannot skip unexpected " + A() + " at " + g());
    }

    public String Y() throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) e0(Map.Entry.class, i.b.NAME);
        String f0 = f0(entry);
        this.m[this.f20556f - 1] = entry.getValue();
        this.f20558h[this.f20556f - 2] = f0;
        return f0;
    }

    @Override // com.squareup.moshi.i
    public void a() throws IOException {
        List list = (List) e0(List.class, i.b.BEGIN_ARRAY);
        a aVar = new a(i.b.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        Object[] objArr = this.m;
        int i2 = this.f20556f;
        objArr[i2 - 1] = aVar;
        this.f20557g[i2 - 1] = 1;
        this.f20559i[i2 - 1] = 0;
        if (aVar.hasNext()) {
            Z(aVar.next());
        }
    }

    @Override // com.squareup.moshi.i
    public void b() throws IOException {
        Map map = (Map) e0(Map.class, i.b.BEGIN_OBJECT);
        a aVar = new a(i.b.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        Object[] objArr = this.m;
        int i2 = this.f20556f;
        objArr[i2 - 1] = aVar;
        this.f20557g[i2 - 1] = 3;
        if (aVar.hasNext()) {
            Z(aVar.next());
        }
    }

    @Override // com.squareup.moshi.i
    public void c() throws IOException {
        i.b bVar = i.b.END_ARRAY;
        a aVar = (a) e0(a.class, bVar);
        if (aVar.f20569f == bVar && !aVar.hasNext()) {
            a0();
            return;
        }
        throw W(aVar, bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Arrays.fill(this.m, 0, this.f20556f, (Object) null);
        this.m[0] = l;
        this.f20557g[0] = 8;
        this.f20556f = 1;
    }

    @Override // com.squareup.moshi.i
    public void d() throws IOException {
        i.b bVar = i.b.END_OBJECT;
        a aVar = (a) e0(a.class, bVar);
        if (aVar.f20569f == bVar && !aVar.hasNext()) {
            this.f20558h[this.f20556f - 1] = null;
            a0();
            return;
        }
        throw W(aVar, bVar);
    }

    @Override // com.squareup.moshi.i
    public boolean f() throws IOException {
        int i2 = this.f20556f;
        if (i2 == 0) {
            return false;
        }
        Object obj = this.m[i2 - 1];
        return !(obj instanceof Iterator) || ((Iterator) obj).hasNext();
    }

    @Override // com.squareup.moshi.i
    public boolean k() throws IOException {
        Boolean bool = (Boolean) e0(Boolean.class, i.b.BOOLEAN);
        a0();
        return bool.booleanValue();
    }

    @Override // com.squareup.moshi.i
    public double l() throws IOException {
        double parseDouble;
        i.b bVar = i.b.NUMBER;
        Object e0 = e0(Object.class, bVar);
        if (e0 instanceof Number) {
            parseDouble = ((Number) e0).doubleValue();
        } else if (e0 instanceof String) {
            try {
                parseDouble = Double.parseDouble((String) e0);
            } catch (NumberFormatException unused) {
                throw W(e0, i.b.NUMBER);
            }
        } else {
            throw W(e0, bVar);
        }
        if (!this.f20560j && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + g());
        }
        a0();
        return parseDouble;
    }

    @Override // com.squareup.moshi.i
    public int m() throws IOException {
        int intValueExact;
        i.b bVar = i.b.NUMBER;
        Object e0 = e0(Object.class, bVar);
        if (e0 instanceof Number) {
            intValueExact = ((Number) e0).intValue();
        } else if (e0 instanceof String) {
            try {
                try {
                    intValueExact = Integer.parseInt((String) e0);
                } catch (NumberFormatException unused) {
                    throw W(e0, i.b.NUMBER);
                }
            } catch (NumberFormatException unused2) {
                intValueExact = new BigDecimal((String) e0).intValueExact();
            }
        } else {
            throw W(e0, bVar);
        }
        a0();
        return intValueExact;
    }

    @Override // com.squareup.moshi.i
    public long p() throws IOException {
        long longValueExact;
        i.b bVar = i.b.NUMBER;
        Object e0 = e0(Object.class, bVar);
        if (e0 instanceof Number) {
            longValueExact = ((Number) e0).longValue();
        } else if (e0 instanceof String) {
            try {
                try {
                    longValueExact = Long.parseLong((String) e0);
                } catch (NumberFormatException unused) {
                    throw W(e0, i.b.NUMBER);
                }
            } catch (NumberFormatException unused2) {
                longValueExact = new BigDecimal((String) e0).longValueExact();
            }
        } else {
            throw W(e0, bVar);
        }
        a0();
        return longValueExact;
    }

    @Override // com.squareup.moshi.i
    public <T> T x() throws IOException {
        e0(Void.class, i.b.NULL);
        a0();
        return null;
    }

    @Override // com.squareup.moshi.i
    public String y() throws IOException {
        int i2 = this.f20556f;
        Object obj = i2 != 0 ? this.m[i2 - 1] : null;
        if (obj instanceof String) {
            a0();
            return (String) obj;
        }
        if (obj instanceof Number) {
            a0();
            return obj.toString();
        }
        if (obj == l) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw W(obj, i.b.STRING);
    }
}
