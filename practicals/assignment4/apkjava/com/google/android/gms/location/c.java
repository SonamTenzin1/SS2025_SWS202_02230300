package com.google.android.gms.location;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class c implements Comparator<ActivityTransition> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        ActivityTransition activityTransition3 = activityTransition;
        ActivityTransition activityTransition4 = activityTransition2;
        int y = activityTransition3.y();
        int y2 = activityTransition4.y();
        if (y != y2) {
            return y < y2 ? -1 : 1;
        }
        int z = activityTransition3.z();
        int z2 = activityTransition4.z();
        if (z == z2) {
            return 0;
        }
        return z < z2 ? -1 : 1;
    }
}
