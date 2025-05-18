package com.liulishuo.filedownloader.services;

import e.h.a.k0.c;

/* compiled from: DefaultIdGenerator.java */
/* loaded from: classes2.dex */
public class b implements c.d {
    @Override // e.h.a.k0.c.d
    public int a(String str, String str2, boolean z) {
        if (z) {
            return e.h.a.k0.f.O(e.h.a.k0.f.o("%sp%s@dir", str, str2)).hashCode();
        }
        return e.h.a.k0.f.O(e.h.a.k0.f.o("%sp%s", str, str2)).hashCode();
    }

    @Override // e.h.a.k0.c.d
    public int b(int i2, String str, String str2, boolean z) {
        return a(str, str2, z);
    }
}
