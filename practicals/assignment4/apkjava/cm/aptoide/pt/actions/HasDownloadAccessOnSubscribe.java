package cm.aptoide.pt.actions;

import rx.e;
import rx.j;

/* loaded from: classes.dex */
public class HasDownloadAccessOnSubscribe implements e.a<Boolean> {
    private final PermissionService permissionService;

    public HasDownloadAccessOnSubscribe(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$call$0(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onNext(Boolean.TRUE);
        jVar.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$call$1(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onNext(Boolean.FALSE);
        jVar.onCompleted();
    }

    @Override // rx.m.b
    public void call(final j<? super Boolean> jVar) {
        this.permissionService.hasDownloadAccess(new rx.m.a() { // from class: cm.aptoide.pt.actions.b
            @Override // rx.m.a
            public final void call() {
                HasDownloadAccessOnSubscribe.lambda$call$0(j.this);
            }
        }, new rx.m.a() { // from class: cm.aptoide.pt.actions.a
            @Override // rx.m.a
            public final void call() {
                HasDownloadAccessOnSubscribe.lambda$call$1(j.this);
            }
        });
    }
}
