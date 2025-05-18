package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: OptionsContainer.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class i3<T> {
    private final Class<T> a;

    private i3(Class<T> cls) {
        this.a = cls;
    }

    public static <T> i3<T> a(Class<T> cls) {
        return new i3<>(cls);
    }

    public T b() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return this.a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
}
