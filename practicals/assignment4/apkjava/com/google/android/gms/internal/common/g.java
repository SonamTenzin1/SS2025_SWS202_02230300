package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@NullMarked
/* loaded from: classes.dex */
abstract class g extends zzak {

    /* renamed from: f, reason: collision with root package name */
    private final int f17069f;

    /* renamed from: g, reason: collision with root package name */
    private int f17070g;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i2, int i3) {
        zzs.b(i3, i2, "index");
        this.f17069f = i2;
        this.f17070g = i3;
    }

    protected abstract Object b(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f17070g < this.f17069f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17070g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i2 = this.f17070g;
            this.f17070g = i2 + 1;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17070g;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i2 = this.f17070g - 1;
            this.f17070g = i2;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17070g - 1;
    }
}
