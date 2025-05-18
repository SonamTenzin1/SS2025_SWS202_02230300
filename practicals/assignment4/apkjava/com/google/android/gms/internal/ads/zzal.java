package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzal {
    private static final Comparator<byte[]> a = new k2();

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f13942b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<byte[]> f13943c = new ArrayList(64);

    /* renamed from: d, reason: collision with root package name */
    private int f13944d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final int f13945e = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;

    public zzal(int i2) {
    }

    private final synchronized void c() {
        while (this.f13944d > this.f13945e) {
            byte[] remove = this.f13942b.remove(0);
            this.f13943c.remove(remove);
            this.f13944d -= remove.length;
        }
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f13945e) {
                this.f13942b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f13943c, bArr, a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f13943c.add(binarySearch, bArr);
                this.f13944d += bArr.length;
                c();
            }
        }
    }

    public final synchronized byte[] b(int i2) {
        for (int i3 = 0; i3 < this.f13943c.size(); i3++) {
            byte[] bArr = this.f13943c.get(i3);
            if (bArr.length >= i2) {
                this.f13944d -= bArr.length;
                this.f13943c.remove(i3);
                this.f13942b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
