package com.google.firebase.r;

/* compiled from: HeartBeatInfo.java */
/* loaded from: classes2.dex */
public interface j {

    /* compiled from: HeartBeatInfo.java */
    /* loaded from: classes2.dex */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* renamed from: k, reason: collision with root package name */
        private final int f19903k;

        a(int i2) {
            this.f19903k = i2;
        }

        public int g() {
            return this.f19903k;
        }
    }

    a b(String str);
}
