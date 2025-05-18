package com.facebook.login;

import java.util.Arrays;

/* compiled from: LoginTargetApp.kt */
/* loaded from: classes2.dex */
public enum z {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram");


    /* renamed from: f, reason: collision with root package name */
    public static final a f10065f = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private final String f10069j;

    /* compiled from: LoginTargetApp.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final z a(String str) {
            z[] valuesCustom = z.valuesCustom();
            int length = valuesCustom.length;
            int i2 = 0;
            while (i2 < length) {
                z zVar = valuesCustom[i2];
                i2++;
                if (kotlin.jvm.internal.m.a(zVar.toString(), str)) {
                    return zVar;
                }
            }
            return z.FACEBOOK;
        }
    }

    z(String str) {
        this.f10069j = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static z[] valuesCustom() {
        z[] valuesCustom = values();
        return (z[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f10069j;
    }
}
