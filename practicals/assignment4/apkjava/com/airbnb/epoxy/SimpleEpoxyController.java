package com.airbnb.epoxy;

import java.util.List;

/* loaded from: classes.dex */
public class SimpleEpoxyController extends n {
    private List<? extends s<?>> currentModels;
    private boolean insideSetModels;

    @Override // com.airbnb.epoxy.n
    protected final void buildModels() {
        if (isBuildingModels()) {
            add(this.currentModels);
            return;
        }
        throw new IllegalEpoxyUsage("You cannot call `buildModels` directly. Call `setModels` instead.");
    }

    @Override // com.airbnb.epoxy.n
    public final void requestModelBuild() {
        if (this.insideSetModels) {
            super.requestModelBuild();
            return;
        }
        throw new IllegalEpoxyUsage("You cannot call `requestModelBuild` directly. Call `setModels` instead.");
    }

    public void setModels(List<? extends s<?>> list) {
        this.currentModels = list;
        this.insideSetModels = true;
        requestModelBuild();
        this.insideSetModels = false;
    }
}
