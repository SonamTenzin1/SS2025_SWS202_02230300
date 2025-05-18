package com.airbnb.epoxy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.epoxy.n;
import java.util.List;

/* compiled from: EpoxyModel.java */
/* loaded from: classes.dex */
public abstract class s<T> {
    private static long idCounter = -1;
    boolean addedToAdapter;
    n controllerToStageTo;
    private boolean currentlyInInterceptors;
    private n firstControllerAddedTo;
    private boolean hasDefaultId;
    private int hashCodeWhenAdded;
    private long id;
    private int layout;
    private boolean shown;
    private c spanSizeOverride;

    /* compiled from: EpoxyModel.java */
    /* loaded from: classes.dex */
    class a implements n.f {
        a() {
        }

        @Override // com.airbnb.epoxy.n.f
        public void a(n nVar) {
            s.this.currentlyInInterceptors = true;
        }

        @Override // com.airbnb.epoxy.n.f
        public void b(n nVar) {
            s sVar = s.this;
            sVar.hashCodeWhenAdded = sVar.hashCode();
            s.this.currentlyInInterceptors = false;
        }
    }

    /* compiled from: EpoxyModel.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a();
    }

    /* compiled from: EpoxyModel.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(long j2) {
        this.shown = true;
        id(j2);
    }

    private static int getPosition(n nVar, s<?> sVar) {
        if (nVar.isBuildingModels()) {
            return nVar.getFirstIndexOfModelInBuildingList(sVar);
        }
        return nVar.getAdapter().E(sVar);
    }

    public void addIf(boolean z, n nVar) {
        if (z) {
            addTo(nVar);
            return;
        }
        n nVar2 = this.controllerToStageTo;
        if (nVar2 != null) {
            nVar2.clearModelFromStaging(this);
            this.controllerToStageTo = null;
        }
    }

    public void addTo(n nVar) {
        nVar.addInternal(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addWithDebugValidation(n nVar) {
        if (nVar != null) {
            if (!nVar.isModelAddedMultipleTimes(this)) {
                if (this.firstControllerAddedTo == null) {
                    this.firstControllerAddedTo = nVar;
                    this.hashCodeWhenAdded = hashCode();
                    nVar.addAfterInterceptorCallback(new a());
                    return;
                }
                return;
            }
            throw new IllegalEpoxyUsage("This model was already added to the controller at position " + nVar.getFirstIndexOfModelInBuildingList(this));
        }
        throw new IllegalArgumentException("Controller cannot be null");
    }

    public void bind(T t) {
    }

    public void bind(T t, List<Object> list) {
        bind(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View buildView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(getLayout(), viewGroup, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.id == sVar.id && getViewType() == sVar.getViewType() && this.shown == sVar.shown;
    }

    protected abstract int getDefaultLayout();

    public final int getLayout() {
        int i2 = this.layout;
        return i2 == 0 ? getDefaultLayout() : i2;
    }

    public int getSpanSize(int i2, int i3, int i4) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getViewType() {
        return getLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasDefaultId() {
        return this.hasDefaultId;
    }

    public int hashCode() {
        long j2 = this.id;
        return (((((int) (j2 ^ (j2 >>> 32))) * 31) + getViewType()) * 31) + (this.shown ? 1 : 0);
    }

    public s<T> hide() {
        return show(false);
    }

    public long id() {
        return this.id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDebugValidationEnabled() {
        return this.firstControllerAddedTo != null;
    }

    public boolean isShown() {
        return this.shown;
    }

    public s<T> layout(int i2) {
        onMutation();
        this.layout = i2;
        return this;
    }

    public boolean onFailedToRecycleView(T t) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onMutation() {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors) {
            throw new z(this, getPosition(this.firstControllerAddedTo, this));
        }
        n nVar = this.controllerToStageTo;
        if (nVar != null) {
            nVar.setStagedModel(this);
        }
    }

    public void onViewAttachedToWindow(T t) {
    }

    public void onViewDetachedFromWindow(T t) {
    }

    public void onVisibilityChanged(float f2, float f3, int i2, int i3, T t) {
    }

    public void onVisibilityStateChanged(int i2, T t) {
    }

    public s<T> reset() {
        onMutation();
        this.layout = 0;
        this.shown = true;
        return this;
    }

    public boolean shouldSaveViewState() {
        return false;
    }

    public s<T> show() {
        return show(true);
    }

    public final int spanSize(int i2, int i3, int i4) {
        c cVar = this.spanSizeOverride;
        if (cVar != null) {
            return cVar.a(i2, i3, i4);
        }
        return getSpanSize(i2, i3, i4);
    }

    public s<T> spanSizeOverride(c cVar) {
        this.spanSizeOverride = cVar;
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.id + ", viewType=" + getViewType() + ", shown=" + this.shown + ", addedToAdapter=" + this.addedToAdapter + '}';
    }

    public void unbind(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void validateStateHasNotChangedSinceAdded(String str, int i2) {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors && this.hashCodeWhenAdded != hashCode()) {
            throw new z(this, str, i2);
        }
    }

    public void bind(T t, s<?> sVar) {
        bind(t);
    }

    public s<T> id(long j2) {
        if ((!this.addedToAdapter && this.firstControllerAddedTo == null) || j2 == this.id) {
            this.hasDefaultId = false;
            this.id = j2;
            return this;
        }
        throw new IllegalEpoxyUsage("Cannot change a model's id after it has been added to the adapter.");
    }

    public s<T> show(boolean z) {
        onMutation();
        this.shown = z;
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s() {
        this(r0);
        long j2 = idCounter;
        idCounter = j2 - 1;
        this.hasDefaultId = true;
    }

    public void addIf(b bVar, n nVar) {
        addIf(bVar.a(), nVar);
    }

    public s<T> id(Number... numberArr) {
        long j2 = 0;
        if (numberArr != null) {
            long j3 = 0;
            for (Number number : numberArr) {
                j3 = (j3 * 31) + y.a(number == null ? 0L : r6.hashCode());
            }
            j2 = j3;
        }
        return id(j2);
    }

    public s<T> id(long j2, long j3) {
        return id((y.a(j2) * 31) + y.a(j3));
    }

    public s<T> id(CharSequence charSequence) {
        id(y.b(charSequence));
        return this;
    }

    public s<T> id(CharSequence charSequence, CharSequence... charSequenceArr) {
        long b2 = y.b(charSequence);
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                b2 = (b2 * 31) + y.b(charSequence2);
            }
        }
        return id(b2);
    }

    public s<T> id(CharSequence charSequence, long j2) {
        id((y.b(charSequence) * 31) + y.a(j2));
        return this;
    }
}
