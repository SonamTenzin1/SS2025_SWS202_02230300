package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: InvalidModuleException.kt */
/* loaded from: classes2.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        kotlin.jvm.internal.m.f(str, "message");
    }
}
