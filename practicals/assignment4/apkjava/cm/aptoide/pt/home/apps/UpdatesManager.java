package cm.aptoide.pt.home.apps;

import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.updates.UpdateRepository;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Single;

/* loaded from: classes.dex */
public class UpdatesManager {
    private UpdateRepository updateRepository;

    public UpdatesManager(UpdateRepository updateRepository) {
        this.updateRepository = updateRepository;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Single lambda$filterUpdates$0(RoomInstalled roomInstalled, Boolean bool) {
        if (bool.booleanValue()) {
            return Single.m(null);
        }
        return Single.m(roomInstalled);
    }

    public rx.b excludeUpdate(String str) {
        return this.updateRepository.setExcluded(str);
    }

    public Single<RoomInstalled> filterUpdates(final RoomInstalled roomInstalled) {
        return this.updateRepository.contains(roomInstalled.getPackageName(), false).i(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.u3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdatesManager.lambda$filterUpdates$0(RoomInstalled.this, (Boolean) obj);
            }
        });
    }

    public Single<RoomUpdate> getUpdate(String str) {
        return this.updateRepository.get(str);
    }

    public rx.e<List<RoomUpdate>> getUpdatesList() {
        return this.updateRepository.getAll(false).u0(750L, TimeUnit.MILLISECONDS);
    }

    public rx.e<Integer> getUpdatesNumber() {
        return getUpdatesList().X(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.t3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((List) obj).size());
                return valueOf;
            }
        });
    }

    public rx.b refreshUpdates() {
        return this.updateRepository.sync(true, false, true);
    }
}
