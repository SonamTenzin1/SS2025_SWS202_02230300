package kotlin.coroutines.j.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", HttpUrl.FRAGMENT_ENCODE_SET, "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.y.j.a.i, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class ModuleNameRetriever {
    public static final ModuleNameRetriever a = new ModuleNameRetriever();

    /* renamed from: b, reason: collision with root package name */
    private static final a f25621b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f25622c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", HttpUrl.FRAGMENT_ENCODE_SET, "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.y.j.a.i$a */
    /* loaded from: classes2.dex */
    public static final class a {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f25623b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f25624c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.f25623b = method2;
            this.f25624c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f25622c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f25621b;
            f25622c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        m.f(baseContinuationImpl, "continuation");
        a aVar = f25622c;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar == f25621b) {
            return null;
        }
        Method method = aVar.a;
        Object invoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f25623b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f25624c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
