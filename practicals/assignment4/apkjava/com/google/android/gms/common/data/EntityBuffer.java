package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
/* loaded from: classes2.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: g, reason: collision with root package name */
    private boolean f11920g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f11921h;

    private final void i() {
        synchronized (this) {
            if (!this.f11920g) {
                int count = this.f11896f.getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f11921h = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String h2 = h();
                    String Y = this.f11896f.Y(h2, 0, this.f11896f.e0(0));
                    for (int i2 = 1; i2 < count; i2++) {
                        int e0 = this.f11896f.e0(i2);
                        String Y2 = this.f11896f.Y(h2, i2, e0);
                        if (Y2 != null) {
                            if (!Y2.equals(Y)) {
                                this.f11921h.add(Integer.valueOf(i2));
                                Y = Y2;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(h2);
                            sb.append(", at row: ");
                            sb.append(i2);
                            sb.append(", for window: ");
                            sb.append(e0);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.f11920g = true;
            }
        }
    }

    private final int n(int i2) {
        if (i2 >= 0 && i2 < this.f11921h.size()) {
            return this.f11921h.get(i2).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i2);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    @KeepForSdk
    protected String f() {
        return null;
    }

    @KeepForSdk
    protected abstract T g(int i2, int i3);

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:
    
        if (r6.f11896f.Y(r4, r7, r3) == null) goto L19;
     */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T get(int i2) {
        int intValue;
        int intValue2;
        i();
        int n = n(i2);
        int i3 = 0;
        if (i2 >= 0 && i2 != this.f11921h.size()) {
            if (i2 == this.f11921h.size() - 1) {
                intValue = this.f11896f.getCount();
                intValue2 = this.f11921h.get(i2).intValue();
            } else {
                intValue = this.f11921h.get(i2 + 1).intValue();
                intValue2 = this.f11921h.get(i2).intValue();
            }
            int i4 = intValue - intValue2;
            if (i4 == 1) {
                int n2 = n(i2);
                int e0 = this.f11896f.e0(n2);
                String f2 = f();
                if (f2 != null) {
                }
            }
            i3 = i4;
        }
        return g(n, i3);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        i();
        return this.f11921h.size();
    }

    @KeepForSdk
    protected abstract String h();
}
