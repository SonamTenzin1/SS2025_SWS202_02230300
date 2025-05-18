package com.airbnb.epoxy;

import com.airbnb.epoxy.c0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerModelList.java */
/* loaded from: classes.dex */
public class h extends c0 {

    /* renamed from: h, reason: collision with root package name */
    private static final c0.d f8433h = new a();

    /* compiled from: ControllerModelList.java */
    /* loaded from: classes.dex */
    static class a implements c0.d {
        a() {
        }

        @Override // com.airbnb.epoxy.c0.d
        public void a(int i2, int i3) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }

        @Override // com.airbnb.epoxy.c0.d
        public void b(int i2, int i3) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i2) {
        super(i2);
        S();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0() {
        b0(f8433h);
        V();
    }
}
