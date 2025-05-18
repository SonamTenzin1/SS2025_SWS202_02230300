package cm.aptoide.pt.home;

import cm.aptoide.pt.database.room.RoomAppComingSoonRegistration;

/* loaded from: classes.dex */
public interface AppComingSoonRegistrationPersistence {
    rx.e<Boolean> isRegisteredForApp(String str);

    rx.b registerForAppNotification(RoomAppComingSoonRegistration roomAppComingSoonRegistration);

    rx.b unregisterForAppNotification(RoomAppComingSoonRegistration roomAppComingSoonRegistration);
}
