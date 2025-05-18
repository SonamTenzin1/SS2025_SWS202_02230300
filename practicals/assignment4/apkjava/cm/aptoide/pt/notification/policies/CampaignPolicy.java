package cm.aptoide.pt.notification.policies;

import cm.aptoide.pt.install.InstalledAppsRepository;
import cm.aptoide.pt.notification.Policy;
import h.a.j;
import h.a.l;
import h.a.s;
import h.a.w;
import h.a.y.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.Single;

/* compiled from: CampaignPolicy.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcm/aptoide/pt/notification/policies/CampaignPolicy;", "Lcm/aptoide/pt/notification/Policy;", "whitelistedPackages", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "installedAppsRepository", "Lcm/aptoide/pt/install/InstalledAppsRepository;", "(Ljava/util/List;Lcm/aptoide/pt/install/InstalledAppsRepository;)V", "getCommonPackages", "Lio/reactivex/Maybe;", "installed", "shouldShow", "Lrx/Single;", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CampaignPolicy implements Policy {
    private final InstalledAppsRepository installedAppsRepository;
    private final List<String> whitelistedPackages;

    public CampaignPolicy(List<String> list, InstalledAppsRepository installedAppsRepository) {
        m.f(list, "whitelistedPackages");
        m.f(installedAppsRepository, "installedAppsRepository");
        this.whitelistedPackages = list;
        this.installedAppsRepository = installedAppsRepository;
    }

    private final j<String> getCommonPackages(String str) {
        for (String str2 : this.whitelistedPackages) {
            if (m.a(str, str2)) {
                j<String> d2 = j.d(str2);
                m.e(d2, "just(it)");
                return d2;
            }
        }
        j<String> b2 = j.b();
        m.e(b2, "empty()");
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldShow$lambda-0, reason: not valid java name */
    public static final Iterable m290shouldShow$lambda0(List list) {
        m.f(list, "it");
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldShow$lambda-1, reason: not valid java name */
    public static final l m291shouldShow$lambda1(CampaignPolicy campaignPolicy, String str) {
        m.f(campaignPolicy, "this$0");
        m.f(str, "installed");
        return campaignPolicy.getCommonPackages(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldShow$lambda-2, reason: not valid java name */
    public static final w m292shouldShow$lambda2(List list) {
        m.f(list, "it");
        return s.f(Boolean.valueOf(!list.isEmpty()));
    }

    @Override // cm.aptoide.pt.notification.Policy
    public Single<Boolean> shouldShow() {
        if (this.whitelistedPackages.isEmpty()) {
            Single<Boolean> m = Single.m(Boolean.TRUE);
            m.e(m, "just(true)");
            return m;
        }
        Single<Boolean> d2 = g.a.a.a.d.d(this.installedAppsRepository.getInstalledAppsNames().j().p(new f() { // from class: cm.aptoide.pt.notification.policies.a
            @Override // h.a.y.f
            public final Object a(Object obj) {
                Iterable m290shouldShow$lambda0;
                m290shouldShow$lambda0 = CampaignPolicy.m290shouldShow$lambda0((List) obj);
                return m290shouldShow$lambda0;
            }
        }).q(new f() { // from class: cm.aptoide.pt.notification.policies.c
            @Override // h.a.y.f
            public final Object a(Object obj) {
                l m291shouldShow$lambda1;
                m291shouldShow$lambda1 = CampaignPolicy.m291shouldShow$lambda1(CampaignPolicy.this, (String) obj);
                return m291shouldShow$lambda1;
            }
        }).A().d(new f() { // from class: cm.aptoide.pt.notification.policies.b
            @Override // h.a.y.f
            public final Object a(Object obj) {
                w m292shouldShow$lambda2;
                m292shouldShow$lambda2 = CampaignPolicy.m292shouldShow$lambda2((List) obj);
                return m292shouldShow$lambda2;
            }
        }));
        m.e(d2, "toV1Single(installedApps…tEmpty())\n        }\n    )");
        return d2;
    }
}
