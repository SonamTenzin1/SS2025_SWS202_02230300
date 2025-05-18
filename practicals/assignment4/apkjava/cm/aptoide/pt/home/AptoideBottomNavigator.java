package cm.aptoide.pt.home;

import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;

/* loaded from: classes.dex */
public interface AptoideBottomNavigator {
    void hideBottomNavigation();

    rx.e<Integer> navigationEvent();

    void requestFocus(BottomNavigationItem bottomNavigationItem);

    void showFragment(Integer num);

    void toggleBottomNavigation();
}
