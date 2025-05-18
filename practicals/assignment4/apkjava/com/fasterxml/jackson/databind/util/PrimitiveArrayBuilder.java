package com.fasterxml.jackson.databind.util;

/* loaded from: classes2.dex */
public abstract class PrimitiveArrayBuilder<T> {
    protected Node<T> _bufferHead;
    protected Node<T> _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Node<T> {
        final T _data;
        final int _dataLength;
        Node<T> _next;

        public Node(T t, int i2) {
            this._data = t;
            this._dataLength = i2;
        }

        public int copyData(T t, int i2) {
            System.arraycopy(this._data, 0, t, i2, this._dataLength);
            return i2 + this._dataLength;
        }

        public T getData() {
            return this._data;
        }

        public void linkNext(Node<T> node) {
            if (this._next == null) {
                this._next = node;
                return;
            }
            throw new IllegalStateException();
        }

        public Node<T> next() {
            return this._next;
        }
    }

    protected abstract T _constructArray(int i2);

    protected void _reset() {
        Node<T> node = this._bufferTail;
        if (node != null) {
            this._freeBuffer = node.getData();
        }
        this._bufferTail = null;
        this._bufferHead = null;
        this._bufferedEntryCount = 0;
    }

    public final T appendCompletedChunk(T t, int i2) {
        Node<T> node = new Node<>(t, i2);
        if (this._bufferHead == null) {
            this._bufferTail = node;
            this._bufferHead = node;
        } else {
            this._bufferTail.linkNext(node);
            this._bufferTail = node;
        }
        this._bufferedEntryCount += i2;
        return _constructArray(i2 < 16384 ? i2 + i2 : i2 + (i2 >> 2));
    }

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T completeAndClearBuffer(T t, int i2) {
        int i3 = this._bufferedEntryCount + i2;
        T _constructArray = _constructArray(i3);
        int i4 = 0;
        for (Node<T> node = this._bufferHead; node != null; node = node.next()) {
            i4 = node.copyData(_constructArray, i4);
        }
        System.arraycopy(t, 0, _constructArray, i4, i2);
        int i5 = i4 + i2;
        if (i5 == i3) {
            return _constructArray;
        }
        throw new IllegalStateException("Should have gotten " + i3 + " entries, got " + i5);
    }

    public T resetAndStart() {
        _reset();
        T t = this._freeBuffer;
        return t == null ? _constructArray(12) : t;
    }
}
