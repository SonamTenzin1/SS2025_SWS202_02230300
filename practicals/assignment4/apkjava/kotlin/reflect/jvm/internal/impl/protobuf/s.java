package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RopeByteString.java */
/* loaded from: classes3.dex */
public class s extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f25453g;

    /* renamed from: h, reason: collision with root package name */
    private final int f25454h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f25455i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f25456j;

    /* renamed from: k, reason: collision with root package name */
    private final int f25457k;
    private final int l;
    private int m;

    /* compiled from: RopeByteString.java */
    /* loaded from: classes3.dex */
    private static class b {
        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> a;

        private b() {
            this.a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.a.pop();
            while (!this.a.isEmpty()) {
                pop = new s(this.a.pop(), pop);
            }
            return pop;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.s()) {
                e(dVar);
                return;
            }
            if (dVar instanceof s) {
                s sVar = (s) dVar;
                c(sVar.f25455i);
                c(sVar.f25456j);
            } else {
                String valueOf = String.valueOf(dVar.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i2) {
            int binarySearch = Arrays.binarySearch(s.f25453g, i2);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int d2 = d(dVar.size());
            int i2 = s.f25453g[d2 + 1];
            if (!this.a.isEmpty() && this.a.peek().size() < i2) {
                int i3 = s.f25453g[d2];
                kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.a.pop();
                while (true) {
                    if (this.a.isEmpty() || this.a.peek().size() >= i3) {
                        break;
                    } else {
                        pop = new s(this.a.pop(), pop);
                    }
                }
                s sVar = new s(pop, dVar);
                while (!this.a.isEmpty()) {
                    if (this.a.peek().size() >= s.f25453g[d(sVar.size()) + 1]) {
                        break;
                    } else {
                        sVar = new s(this.a.pop(), sVar);
                    }
                }
                this.a.push(sVar);
                return;
            }
            this.a.push(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: classes3.dex */
    public static class c implements Iterator<n> {

        /* renamed from: f, reason: collision with root package name */
        private final Stack<s> f25458f;

        /* renamed from: g, reason: collision with root package name */
        private n f25459g;

        private n b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof s) {
                s sVar = (s) dVar;
                this.f25458f.push(sVar);
                dVar = sVar.f25455i;
            }
            return (n) dVar;
        }

        private n c() {
            while (!this.f25458f.isEmpty()) {
                n b2 = b(this.f25458f.pop().f25456j);
                if (!b2.isEmpty()) {
                    return b2;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public n next() {
            n nVar = this.f25459g;
            if (nVar != null) {
                this.f25459g = c();
                return nVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25459g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f25458f = new Stack<>();
            this.f25459g = b(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: classes3.dex */
    public class d implements d.a {

        /* renamed from: f, reason: collision with root package name */
        private final c f25460f;

        /* renamed from: g, reason: collision with root package name */
        private d.a f25461g;

        /* renamed from: h, reason: collision with root package name */
        int f25462h;

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(f());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte f() {
            if (!this.f25461g.hasNext()) {
                this.f25461g = this.f25460f.next().iterator();
            }
            this.f25462h--;
            return this.f25461g.f();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25462h > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private d() {
            c cVar = new c(s.this);
            this.f25460f = cVar;
            this.f25461g = cVar.next().iterator();
            this.f25462h = s.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            int i4 = i3 + i2;
            i3 = i2;
            i2 = i4;
        }
        arrayList.add(Integer.MAX_VALUE);
        f25453g = new int[arrayList.size()];
        int i5 = 0;
        while (true) {
            int[] iArr = f25453g;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kotlin.reflect.jvm.internal.impl.protobuf.d O(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        s sVar = dVar instanceof s ? (s) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return P(dVar, dVar2);
            }
            if (sVar != null && sVar.f25456j.size() + dVar2.size() < 128) {
                dVar2 = new s(sVar.f25455i, P(sVar.f25456j, dVar2));
            } else if (sVar != null && sVar.f25455i.r() > sVar.f25456j.r() && sVar.r() > dVar2.r()) {
                dVar2 = new s(sVar.f25455i, new s(sVar.f25456j, dVar2));
            } else {
                if (size < f25453g[Math.max(dVar.r(), dVar2.r()) + 1]) {
                    return new b().b(dVar, dVar2);
                }
                return new s(dVar, dVar2);
            }
        }
        return dVar2;
    }

    private static n P(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.o(bArr, 0, 0, size);
        dVar2.o(bArr, 0, size, size2);
        return new n(bArr);
    }

    private boolean R(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        n next = cVar.next();
        c cVar2 = new c(dVar);
        n next2 = cVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = next.size() - i2;
            int size2 = next2.size() - i3;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? next.L(next2, i3, min) : next2.L(next, i2, min))) {
                return false;
            }
            i4 += min;
            int i5 = this.f25454h;
            if (i4 >= i5) {
                if (i4 == i5) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = cVar.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i3 = 0;
            } else {
                i3 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String C(String str) throws UnsupportedEncodingException {
        return new String(A(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void F(OutputStream outputStream, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = this.f25457k;
        if (i4 <= i5) {
            this.f25455i.F(outputStream, i2, i3);
        } else {
            if (i2 >= i5) {
                this.f25456j.F(outputStream, i2 - i5, i3);
                return;
            }
            int i6 = i5 - i2;
            this.f25455i.F(outputStream, i2, i6);
            this.f25456j.F(outputStream, 0, i3 - i6);
        }
    }

    public boolean equals(Object obj) {
        int z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
        if (this.f25454h != dVar.size()) {
            return false;
        }
        if (this.f25454h == 0) {
            return true;
        }
        if (this.m == 0 || (z = dVar.z()) == 0 || this.m == z) {
            return R(dVar);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.m;
        if (i2 == 0) {
            int i3 = this.f25454h;
            i2 = x(i3, 0, i3);
            if (i2 == 0) {
                i2 = 1;
            }
            this.m = i2;
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void q(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.f25457k;
        if (i5 <= i6) {
            this.f25455i.q(bArr, i2, i3, i4);
        } else {
            if (i2 >= i6) {
                this.f25456j.q(bArr, i2 - i6, i3, i4);
                return;
            }
            int i7 = i6 - i2;
            this.f25455i.q(bArr, i2, i3, i7);
            this.f25456j.q(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int r() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean s() {
        return this.f25454h >= f25453g[this.l];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f25454h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean t() {
        int y = this.f25455i.y(0, 0, this.f25457k);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.f25456j;
        return dVar.y(y, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: u */
    public d.a iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e v() {
        return kotlin.reflect.jvm.internal.impl.protobuf.e.g(new e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f25457k;
        if (i5 <= i6) {
            return this.f25455i.x(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f25456j.x(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f25456j.x(this.f25455i.x(i2, i3, i7), 0, i4 - i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int y(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f25457k;
        if (i5 <= i6) {
            return this.f25455i.y(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f25456j.y(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f25456j.y(this.f25455i.y(i2, i3, i7), 0, i4 - i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int z() {
        return this.m;
    }

    private s(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.m = 0;
        this.f25455i = dVar;
        this.f25456j = dVar2;
        int size = dVar.size();
        this.f25457k = size;
        this.f25454h = size + dVar2.size();
        this.l = Math.max(dVar.r(), dVar2.r()) + 1;
    }

    /* compiled from: RopeByteString.java */
    /* loaded from: classes3.dex */
    private class e extends InputStream {

        /* renamed from: f, reason: collision with root package name */
        private c f25464f;

        /* renamed from: g, reason: collision with root package name */
        private n f25465g;

        /* renamed from: h, reason: collision with root package name */
        private int f25466h;

        /* renamed from: i, reason: collision with root package name */
        private int f25467i;

        /* renamed from: j, reason: collision with root package name */
        private int f25468j;

        /* renamed from: k, reason: collision with root package name */
        private int f25469k;

        public e() {
            b();
        }

        private void a() {
            if (this.f25465g != null) {
                int i2 = this.f25467i;
                int i3 = this.f25466h;
                if (i2 == i3) {
                    this.f25468j += i3;
                    this.f25467i = 0;
                    if (this.f25464f.hasNext()) {
                        n next = this.f25464f.next();
                        this.f25465g = next;
                        this.f25466h = next.size();
                    } else {
                        this.f25465g = null;
                        this.f25466h = 0;
                    }
                }
            }
        }

        private void b() {
            c cVar = new c(s.this);
            this.f25464f = cVar;
            n next = cVar.next();
            this.f25465g = next;
            this.f25466h = next.size();
            this.f25467i = 0;
            this.f25468j = 0;
        }

        private int c(byte[] bArr, int i2, int i3) {
            int i4 = i3;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                a();
                if (this.f25465g != null) {
                    int min = Math.min(this.f25466h - this.f25467i, i4);
                    if (bArr != null) {
                        this.f25465g.o(bArr, this.f25467i, i2, min);
                        i2 += min;
                    }
                    this.f25467i += min;
                    i4 -= min;
                } else if (i4 == i3) {
                    return -1;
                }
            }
            return i3 - i4;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return s.this.size() - (this.f25468j + this.f25467i);
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            this.f25469k = this.f25468j + this.f25467i;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            bArr.getClass();
            if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
                return c(bArr, i2, i3);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            b();
            c(null, 0, this.f25469k);
        }

        @Override // java.io.InputStream
        public long skip(long j2) {
            if (j2 >= 0) {
                if (j2 > 2147483647L) {
                    j2 = 2147483647L;
                }
                return c(null, 0, (int) j2);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            n nVar = this.f25465g;
            if (nVar == null) {
                return -1;
            }
            int i2 = this.f25467i;
            this.f25467i = i2 + 1;
            return nVar.G(i2) & 255;
        }
    }
}
