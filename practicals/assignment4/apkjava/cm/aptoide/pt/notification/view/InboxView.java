package cm.aptoide.pt.notification.view;

import cm.aptoide.pt.notification.AptoideNotification;
import cm.aptoide.pt.presenter.View;
import java.util.List;

/* loaded from: classes.dex */
public interface InboxView extends View {
    rx.e<AptoideNotification> notificationSelection();

    void showEmptyState();

    void showNotifications(List<AptoideNotification> list);
}
