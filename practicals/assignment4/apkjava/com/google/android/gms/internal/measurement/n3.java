package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class n3 implements e3 {
    private final zzgo a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17227b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f17228c;

    /* renamed from: d, reason: collision with root package name */
    private final int f17229d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n3(zzgo zzgoVar, String str, Object[] objArr) {
        this.a = zzgoVar;
        this.f17227b = str;
        this.f17228c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f17229d = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.f17229d = i2 | (charAt2 << i3);
                return;
            } else {
                i2 |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final int a() {
        return (this.f17229d & 1) == 1 ? zzfd.zze.f17404i : zzfd.zze.f17405j;
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final boolean b() {
        return (this.f17229d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final zzgo c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f17227b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f17228c;
    }
}
