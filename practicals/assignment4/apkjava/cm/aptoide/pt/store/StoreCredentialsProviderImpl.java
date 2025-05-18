package cm.aptoide.pt.store;

import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.V7Url;

/* loaded from: classes.dex */
public class StoreCredentialsProviderImpl implements StoreCredentialsProvider {
    private final RoomStoreRepository storeRepository;

    public StoreCredentialsProviderImpl(RoomStoreRepository roomStoreRepository) {
        this.storeRepository = roomStoreRepository;
    }

    @Override // cm.aptoide.pt.store.StoreCredentialsProvider
    public BaseRequestWithStore.StoreCredentials fromUrl(String str) {
        V7Url v7Url = new V7Url(str);
        Long storeId = v7Url.getStoreId();
        String storeName = v7Url.getStoreName();
        if (storeId != null) {
            return get(storeId.longValue());
        }
        if (storeName != null) {
            return get(storeName);
        }
        return new BaseRequestWithStore.StoreCredentials();
    }

    @Override // cm.aptoide.pt.store.StoreCredentialsProvider
    public BaseRequestWithStore.StoreCredentials get(long j2) {
        RoomStore b2 = this.storeRepository.get(Long.valueOf(j2)).y().b();
        if (b2 != null) {
            return new BaseRequestWithStore.StoreCredentials(j2, b2.getStoreName(), b2.getUsername(), b2.getPasswordSha1());
        }
        return new BaseRequestWithStore.StoreCredentials(j2, (String) null, (String) null);
    }

    @Override // cm.aptoide.pt.store.StoreCredentialsProvider
    public BaseRequestWithStore.StoreCredentials get(String str) {
        RoomStore b2 = this.storeRepository.get(str).y().b();
        if (b2 != null) {
            return new BaseRequestWithStore.StoreCredentials(b2.getStoreId(), str, b2.getUsername(), b2.getPasswordSha1());
        }
        return new BaseRequestWithStore.StoreCredentials(str, (String) null, (String) null);
    }
}
