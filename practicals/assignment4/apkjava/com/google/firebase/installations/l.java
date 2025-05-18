package com.google.firebase.installations;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.f;

/* compiled from: InstallationTokenResult.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class l {

    /* compiled from: InstallationTokenResult.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract l a();

        public abstract a b(String str);

        public abstract a c(long j2);

        public abstract a d(long j2);
    }

    public static a a() {
        return new f.b();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
