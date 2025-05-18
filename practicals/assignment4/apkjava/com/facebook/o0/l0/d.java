package com.facebook.o0.l0;

import java.util.Arrays;

/* compiled from: AppEventsConversionsAPITransformer.kt */
/* loaded from: classes.dex */
public enum d {
    MOBILE_APP_INSTALL,
    CUSTOM,
    OTHER;


    /* renamed from: f, reason: collision with root package name */
    public static final a f10166f = new a(null);

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final d a(String str) {
            kotlin.jvm.internal.m.f(str, "rawValue");
            return kotlin.jvm.internal.m.a(str, "MOBILE_APP_INSTALL") ? d.MOBILE_APP_INSTALL : kotlin.jvm.internal.m.a(str, "CUSTOM_APP_EVENTS") ? d.CUSTOM : d.OTHER;
        }
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static d[] valuesCustom() {
        d[] valuesCustom = values();
        return (d[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
