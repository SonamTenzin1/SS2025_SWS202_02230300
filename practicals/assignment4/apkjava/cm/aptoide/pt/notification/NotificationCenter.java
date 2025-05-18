package cm.aptoide.pt.notification;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.List;
import rx.Single;

/* loaded from: classes.dex */
public class NotificationCenter {
    private NotificationAnalytics notificationAnalytics;
    private NotificationPolicyFactory notificationPolicyFactory;
    private NotificationProvider notificationProvider;
    private NotificationSyncScheduler notificationSyncScheduler;

    public NotificationCenter(NotificationProvider notificationProvider, NotificationSyncScheduler notificationSyncScheduler, NotificationPolicyFactory notificationPolicyFactory, NotificationAnalytics notificationAnalytics) {
        this.notificationSyncScheduler = notificationSyncScheduler;
        this.notificationProvider = notificationProvider;
        this.notificationPolicyFactory = notificationPolicyFactory;
        this.notificationAnalytics = notificationAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$getNewNotifications$0(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getNewNotifications$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(AptoideNotification aptoideNotification) {
        if (aptoideNotification.getType() != 7 && aptoideNotification.getType() != 8 && aptoideNotification.getType() != 9) {
            this.notificationAnalytics.sendPushNotificationReceivedEvent(aptoideNotification.getType(), aptoideNotification.getAbTestingGroup(), aptoideNotification.getCampaignId(), aptoideNotification.getUrl());
        }
        aptoideNotification.setProcessed(true);
        return this.notificationProvider.save(aptoideNotification).O(aptoideNotification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ rx.e lambda$getNewNotifications$3(AptoideNotification aptoideNotification, Boolean bool) {
        if (bool.booleanValue()) {
            return rx.e.S(aptoideNotification);
        }
        return rx.e.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getNewNotifications$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(final AptoideNotification aptoideNotification) {
        return this.notificationPolicyFactory.getPolicy(aptoideNotification).shouldShow().k(new rx.m.e() { // from class: cm.aptoide.pt.notification.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.lambda$getNewNotifications$3(AptoideNotification.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ rx.e lambda$getNewNotifications$5(Throwable th) {
        th.printStackTrace();
        return rx.e.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$notificationDismissed$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(RoomNotification roomNotification) {
        roomNotification.setDismissed(System.currentTimeMillis());
        return this.notificationProvider.save(roomNotification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$setAllNotificationsRead$8(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setAllNotificationsRead$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b d(RoomNotification roomNotification) {
        if (roomNotification.getDismissed() == -1) {
            roomNotification.setDismissed(System.currentTimeMillis());
            return this.notificationProvider.save(roomNotification);
        }
        return rx.b.e();
    }

    public rx.e<List<AptoideNotification>> getInboxNotifications(int i2) {
        return this.notificationProvider.getNotifications(i2);
    }

    public rx.e<AptoideNotification> getNewNotifications() {
        return this.notificationProvider.getAptoideNotifications().J(new rx.m.e() { // from class: cm.aptoide.pt.notification.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                NotificationCenter.lambda$getNewNotifications$0(list);
                return list;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.notification.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                AptoideNotification aptoideNotification = (AptoideNotification) obj;
                valueOf = Boolean.valueOf(!aptoideNotification.isProcessed());
                return valueOf;
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.notification.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.this.a((AptoideNotification) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.this.b((AptoideNotification) obj);
            }
        }).o0(new rx.m.e() { // from class: cm.aptoide.pt.notification.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.lambda$getNewNotifications$5((Throwable) obj);
            }
        });
    }

    public rx.e<Boolean> haveNotifications() {
        return this.notificationProvider.getNotifications(1).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                List list = (List) obj;
                valueOf = Boolean.valueOf(!list.isEmpty());
                return valueOf;
            }
        });
    }

    public rx.b notificationDismissed(Integer[] numArr) {
        return this.notificationProvider.getLastShowed(numArr).j(new rx.m.e() { // from class: cm.aptoide.pt.notification.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.this.c((RoomNotification) obj);
            }
        });
    }

    public rx.b setAllNotificationsRead() {
        return this.notificationProvider.getNotifications().E().J(new rx.m.e() { // from class: cm.aptoide.pt.notification.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                NotificationCenter.lambda$setAllNotificationsRead$8(list);
                return list;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return NotificationCenter.this.d((RoomNotification) obj);
            }
        }).X0();
    }

    public void setup() {
        this.notificationSyncScheduler.schedule();
    }
}
