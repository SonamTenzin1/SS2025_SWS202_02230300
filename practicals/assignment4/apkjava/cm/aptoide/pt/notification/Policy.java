package cm.aptoide.pt.notification;

import rx.Single;

/* loaded from: classes.dex */
public interface Policy {
    Single<Boolean> shouldShow();
}
