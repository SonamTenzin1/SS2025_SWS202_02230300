package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PickerFragment.java */
/* loaded from: classes2.dex */
public abstract class l<S> extends Fragment {

    /* renamed from: f, reason: collision with root package name */
    protected final LinkedHashSet<k<S>> f18621f = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(k<S> kVar) {
        return this.f18621f.add(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f18621f.clear();
    }
}
