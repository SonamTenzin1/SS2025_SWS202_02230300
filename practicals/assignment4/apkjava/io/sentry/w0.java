package io.sentry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircularFifoQueue.java */
/* loaded from: classes2.dex */
public final class w0<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private transient E[] f22798f;

    /* renamed from: g, reason: collision with root package name */
    private transient int f22799g;

    /* renamed from: h, reason: collision with root package name */
    private transient int f22800h;

    /* renamed from: i, reason: collision with root package name */
    private transient boolean f22801i;

    /* renamed from: j, reason: collision with root package name */
    private final int f22802j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularFifoQueue.java */
    /* loaded from: classes2.dex */
    public class a implements Iterator<E> {

        /* renamed from: f, reason: collision with root package name */
        private int f22803f;

        /* renamed from: g, reason: collision with root package name */
        private int f22804g = -1;

        /* renamed from: h, reason: collision with root package name */
        private boolean f22805h;

        a() {
            this.f22803f = w0.this.f22799g;
            this.f22805h = w0.this.f22801i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22805h || this.f22803f != w0.this.f22800h;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                this.f22805h = false;
                int i2 = this.f22803f;
                this.f22804g = i2;
                this.f22803f = w0.this.t(i2);
                return (E) w0.this.f22798f[this.f22804g];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i2 = this.f22804g;
            if (i2 != -1) {
                if (i2 == w0.this.f22799g) {
                    w0.this.remove();
                    this.f22804g = -1;
                    return;
                }
                int i3 = this.f22804g + 1;
                if (w0.this.f22799g >= this.f22804g || i3 >= w0.this.f22800h) {
                    while (i3 != w0.this.f22800h) {
                        if (i3 >= w0.this.f22802j) {
                            w0.this.f22798f[i3 - 1] = w0.this.f22798f[0];
                            i3 = 0;
                        } else {
                            w0.this.f22798f[w0.this.s(i3)] = w0.this.f22798f[i3];
                            i3 = w0.this.t(i3);
                        }
                    }
                } else {
                    System.arraycopy(w0.this.f22798f, i3, w0.this.f22798f, this.f22804g, w0.this.f22800h - i3);
                }
                this.f22804g = -1;
                w0 w0Var = w0.this;
                w0Var.f22800h = w0Var.s(w0Var.f22800h);
                w0.this.f22798f[w0.this.f22800h] = null;
                w0.this.f22801i = false;
                this.f22803f = w0.this.s(this.f22803f);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public w0() {
        this(32);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f22798f = (E[]) new Object[this.f22802j];
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            ((E[]) this.f22798f)[i2] = objectInputStream.readObject();
        }
        this.f22799g = 0;
        boolean z = readInt == this.f22802j;
        this.f22801i = z;
        if (z) {
            this.f22800h = 0;
        } else {
            this.f22800h = readInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(int i2) {
        int i3 = i2 - 1;
        return i3 < 0 ? this.f22802j - 1 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.f22802j) {
            return 0;
        }
        return i3;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        if (e2 != null) {
            if (u()) {
                remove();
            }
            E[] eArr = this.f22798f;
            int i2 = this.f22800h;
            int i3 = i2 + 1;
            this.f22800h = i3;
            eArr[i2] = e2;
            if (i3 >= this.f22802j) {
                this.f22800h = 0;
            }
            if (this.f22800h == this.f22799g) {
                this.f22801i = true;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to queue");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f22801i = false;
        this.f22799g = 0;
        this.f22800h = 0;
        Arrays.fill(this.f22798f, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        return add(e2);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f22798f[this.f22799g];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.f22798f;
            int i2 = this.f22799g;
            E e2 = eArr[i2];
            if (e2 != null) {
                int i3 = i2 + 1;
                this.f22799g = i3;
                eArr[i2] = null;
                if (i3 >= this.f22802j) {
                    this.f22799g = 0;
                }
                this.f22801i = false;
            }
            return e2;
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i2 = this.f22800h;
        int i3 = this.f22799g;
        if (i2 < i3) {
            return (this.f22802j - i3) + i2;
        }
        if (i2 != i3) {
            return i2 - i3;
        }
        if (this.f22801i) {
            return this.f22802j;
        }
        return 0;
    }

    public boolean u() {
        return size() == this.f22802j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(int i2) {
        this.f22799g = 0;
        this.f22800h = 0;
        this.f22801i = false;
        if (i2 > 0) {
            E[] eArr = (E[]) new Object[i2];
            this.f22798f = eArr;
            this.f22802j = eArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }
}
