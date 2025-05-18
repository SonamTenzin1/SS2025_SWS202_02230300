package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.e;
import com.google.auto.value.AutoValue;

/* compiled from: ClientInfo.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class k {

    /* compiled from: ClientInfo.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract k a();

        public abstract a b(com.google.android.datatransport.cct.f.a aVar);

        public abstract a c(b bVar);
    }

    /* compiled from: ClientInfo.java */
    /* loaded from: classes2.dex */
    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* renamed from: i, reason: collision with root package name */
        private final int f11282i;

        b(int i2) {
            this.f11282i = i2;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract com.google.android.datatransport.cct.f.a b();

    public abstract b c();
}
