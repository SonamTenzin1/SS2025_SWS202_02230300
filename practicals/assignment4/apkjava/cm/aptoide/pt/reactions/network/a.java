package cm.aptoide.pt.reactions.network;

import retrofit2.Response;
import rx.m.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ReactionsRemoteService f7242f;

    public /* synthetic */ a(ReactionsRemoteService reactionsRemoteService) {
        this.f7242f = reactionsRemoteService;
    }

    @Override // rx.m.e
    public final Object call(Object obj) {
        ReactionsResponse mapResponse;
        mapResponse = this.f7242f.mapResponse((Response) obj);
        return mapResponse;
    }
}
