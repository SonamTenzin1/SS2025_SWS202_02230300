package com.google.firebase.crashlytics.internal.n;

import com.google.auto.value.AutoValue;

/* compiled from: InstallIdProvider.java */
/* loaded from: classes2.dex */
public interface j0 {

    /* compiled from: InstallIdProvider.java */
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(String str, String str2) {
            return new n(str, str2);
        }

        public static a b(String str) {
            return a(str, null);
        }

        public abstract String c();

        public abstract String d();
    }

    a a();
}
