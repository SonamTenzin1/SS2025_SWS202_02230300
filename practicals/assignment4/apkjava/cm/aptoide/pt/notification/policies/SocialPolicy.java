package cm.aptoide.pt.notification.policies;

import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.Policy;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.m.f;

/* loaded from: classes.dex */
public class SocialPolicy implements Policy {
    private static final int police1Occurrences = 1;
    private static final int police2Occurrences = 3;
    private NotificationProvider notificationProvider;
    private Integer[] notificationsTypes;
    private static final long police1timeFrame = TimeUnit.HOURS.toMillis(1);
    private static final long police2timeFrame = TimeUnit.DAYS.toMillis(1);

    public SocialPolicy(NotificationProvider notificationProvider, Integer[] numArr) {
        this.notificationProvider = notificationProvider;
        this.notificationsTypes = numArr;
    }

    private Single<Boolean> createPolicy(Integer[] numArr, long j2, long j3, final int i2) {
        return this.notificationProvider.getDismissedNotifications(numArr, j3, j2).n(new rx.m.e() { // from class: cm.aptoide.pt.notification.policies.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                int i3 = i2;
                valueOf = Boolean.valueOf(r1.size() < r0);
                return valueOf;
            }
        });
    }

    @Override // cm.aptoide.pt.notification.Policy
    public Single<Boolean> shouldShow() {
        long currentTimeMillis = System.currentTimeMillis();
        return Single.C(createPolicy(this.notificationsTypes, currentTimeMillis, currentTimeMillis - police1timeFrame, 1), createPolicy(this.notificationsTypes, currentTimeMillis, currentTimeMillis - police2timeFrame, 3), new f() { // from class: cm.aptoide.pt.notification.policies.e
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        });
    }
}
