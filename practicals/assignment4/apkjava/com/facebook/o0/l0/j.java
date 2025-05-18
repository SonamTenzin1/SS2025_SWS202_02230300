package com.facebook.o0.l0;

import cm.aptoide.pt.search.analytics.SearchAnalytics;
import java.util.Arrays;

/* compiled from: AppEventsConversionsAPITransformer.kt */
/* loaded from: classes.dex */
public enum j {
    UNLOCKED_ACHIEVEMENT("AchievementUnlocked"),
    ACTIVATED_APP("ActivateApp"),
    ADDED_PAYMENT_INFO("AddPaymentInfo"),
    ADDED_TO_CART("AddToCart"),
    ADDED_TO_WISHLIST("AddToWishlist"),
    COMPLETED_REGISTRATION("CompleteRegistration"),
    VIEWED_CONTENT("ViewContent"),
    INITIATED_CHECKOUT("InitiateCheckout"),
    ACHIEVED_LEVEL("LevelAchieved"),
    PURCHASED("Purchase"),
    RATED("Rate"),
    SEARCHED(SearchAnalytics.SEARCH),
    SPENT_CREDITS("SpentCredits"),
    COMPLETED_TUTORIAL("TutorialCompletion");

    private final String u;

    j(String str) {
        this.u = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static j[] valuesCustom() {
        j[] valuesCustom = values();
        return (j[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final String k() {
        return this.u;
    }
}
