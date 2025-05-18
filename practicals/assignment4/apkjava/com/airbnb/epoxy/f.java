package com.airbnb.epoxy;

import com.airbnb.epoxy.n;
import java.util.List;

/* compiled from: ControllerHelper.java */
/* loaded from: classes.dex */
public abstract class f<T extends n> {
    public abstract void resetAutoModels();

    protected void setControllerToStageTo(s<?> sVar, T t) {
        sVar.controllerToStageTo = t;
    }

    protected void validateModelHashCodesHaveNotChanged(T t) {
        List<s<?>> D = t.getAdapter().D();
        for (int i2 = 0; i2 < D.size(); i2++) {
            D.get(i2).validateStateHasNotChangedSinceAdded("Model has changed since it was added to the controller.", i2);
        }
    }
}
