package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

/* compiled from: CallableMemberDescriptor.java */
/* loaded from: classes2.dex */
public interface b extends kotlin.reflect.jvm.internal.impl.descriptors.a, c0 {

    /* compiled from: CallableMemberDescriptor.java */
    /* loaded from: classes2.dex */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean g() {
            return this != FAKE_OVERRIDE;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.m
    b a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends b> e();

    a i();

    b k0(m mVar, d0 d0Var, u uVar, a aVar, boolean z);

    void x0(Collection<? extends b> collection);
}
