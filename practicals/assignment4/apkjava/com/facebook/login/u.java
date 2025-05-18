package com.facebook.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* compiled from: LoginConfiguration.kt */
/* loaded from: classes2.dex */
public final class u {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f10036b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10037c;

    /* renamed from: d, reason: collision with root package name */
    private final String f10038d;

    /* compiled from: LoginConfiguration.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ u(Collection collection, String str, int i2, kotlin.jvm.internal.g gVar) {
        this(collection, str);
        if ((i2 & 2) != 0) {
            str = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.e(str, "randomUUID().toString()");
        }
    }

    public final String a() {
        return this.f10038d;
    }

    public final String b() {
        return this.f10037c;
    }

    public final Set<String> c() {
        return this.f10036b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(Collection<String> collection, String str) {
        this(collection, str, b0.c());
        kotlin.jvm.internal.m.f(str, "nonce");
        b0 b0Var = b0.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u(Collection<String> collection, String str, String str2) {
        boolean z;
        kotlin.jvm.internal.m.f(str, "nonce");
        kotlin.jvm.internal.m.f(str2, "codeVerifier");
        a0 a0Var = a0.a;
        if (a0.a(str)) {
            b0 b0Var = b0.a;
            if (b0.d(str2)) {
                z = true;
                if (!z) {
                    HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
                    hashSet.add("openid");
                    Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
                    kotlin.jvm.internal.m.e(unmodifiableSet, "unmodifiableSet(permissions)");
                    this.f10036b = unmodifiableSet;
                    this.f10037c = str;
                    this.f10038d = str2;
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        z = false;
        if (!z) {
        }
    }
}
