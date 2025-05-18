package com.google.firebase.components;

import java.util.List;

/* compiled from: ComponentRegistrarProcessor.java */
/* loaded from: classes2.dex */
public interface s {
    public static final s a = new s() { // from class: com.google.firebase.components.m
        @Override // com.google.firebase.components.s
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List<n<?>> a(ComponentRegistrar componentRegistrar);
}
