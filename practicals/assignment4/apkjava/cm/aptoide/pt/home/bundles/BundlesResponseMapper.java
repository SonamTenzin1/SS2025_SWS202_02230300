package cm.aptoide.pt.home.bundles;

import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.ListAppCoinsCampaigns;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.listapp.AppCoinsInfo;
import cm.aptoide.pt.dataprovider.ws.v7.AppPromoItem;
import cm.aptoide.pt.dataprovider.ws.v7.NewAppCoinsAppPromoItem;
import cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemData;
import cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemResponse;
import cm.aptoide.pt.dataprovider.ws.v7.home.BonusAppcBundle;
import cm.aptoide.pt.dataprovider.ws.v7.home.EditorialActionItem;
import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import cm.aptoide.pt.home.bundles.ads.AdBundle;
import cm.aptoide.pt.home.bundles.ads.AdsTagWrapper;
import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.bundles.base.ActionBundle;
import cm.aptoide.pt.home.bundles.base.ActionItem;
import cm.aptoide.pt.home.bundles.base.AppBundle;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.BonusPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.EditorialActionBundle;
import cm.aptoide.pt.home.bundles.base.FeaturedAppcBundle;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.VersionPromotionalBundle;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.view.app.Application;
import cm.aptoide.pt.view.app.ApplicationGraphic;
import cm.aptoide.pt.view.app.FeatureGraphicApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class BundlesResponseMapper {
    private final AppComingSoonRegistrationManager appComingSoonRegistrationManager;
    private final BlacklistManager blacklistManager;
    private final DownloadStateParser downloadStateParser;
    private final InstallManager installManager;
    private final WalletAdsOfferCardManager walletAdsOfferCardManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cm.aptoide.pt.home.bundles.BundlesResponseMapper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = iArr;
            try {
                iArr[Type.APPS_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPCOINS_ADS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPCOINS_FEATURED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_TOP_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.NEW_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.NEW_APP_VERSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[Layout.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout = iArr2;
            try {
                iArr2[Layout.APPC_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[Layout.CURATION_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[Layout.WALLET_ADS_OFFER.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[Layout.PROMO_GRAPHIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public BundlesResponseMapper(InstallManager installManager, WalletAdsOfferCardManager walletAdsOfferCardManager, BlacklistManager blacklistManager, DownloadStateParser downloadStateParser, AppComingSoonRegistrationManager appComingSoonRegistrationManager) {
        this.installManager = installManager;
        this.walletAdsOfferCardManager = walletAdsOfferCardManager;
        this.blacklistManager = blacklistManager;
        this.downloadStateParser = downloadStateParser;
        this.appComingSoonRegistrationManager = appComingSoonRegistrationManager;
    }

    private HomeBundle.BundleType actionItemTypeMapper(GetStoreWidgets.WSWidget wSWidget) {
        if (wSWidget.getData() != null) {
            int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[wSWidget.getData().getLayout().ordinal()];
            if (i2 == 1) {
                return HomeBundle.BundleType.INFO_BUNDLE;
            }
            if (i2 == 2) {
                return HomeBundle.BundleType.EDITORIAL;
            }
            if (i2 == 3) {
                return HomeBundle.BundleType.WALLET_ADS_OFFER;
            }
            if (i2 == 4) {
                if (wSWidget.getType().equals(Type.NEWS_ITEM)) {
                    return HomeBundle.BundleType.NEWS_ITEM;
                }
                if (wSWidget.getType().equals(Type.IN_GAME_EVENT)) {
                    return HomeBundle.BundleType.IN_GAME_EVENT;
                }
                if (wSWidget.getType().equals(Type.APP_COMING_SOON)) {
                    return HomeBundle.BundleType.APP_COMING_SOON;
                }
            }
        }
        return HomeBundle.BundleType.UNKNOWN;
    }

    private HomeBundle.BundleType bundleTypeMapper(Type type, GetStoreWidgets.WSWidget.Data data) {
        if (type == null) {
            return HomeBundle.BundleType.UNKNOWN;
        }
        switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[type.ordinal()]) {
            case 1:
                if (data == null) {
                    return HomeBundle.BundleType.UNKNOWN;
                }
                if (data.getLayout().equals(Layout.BRICK)) {
                    return HomeBundle.BundleType.EDITORS;
                }
                return HomeBundle.BundleType.APPS;
            case 2:
                return HomeBundle.BundleType.APPCOINS_ADS;
            case 3:
                return HomeBundle.BundleType.FEATURED_BONUS_APPC;
            case 4:
                return HomeBundle.BundleType.ADS;
            case 5:
                return HomeBundle.BundleType.TOP;
            case 6:
                return HomeBundle.BundleType.NEW_APP;
            case 7:
                return HomeBundle.BundleType.NEW_APP_VERSION;
            default:
                return HomeBundle.BundleType.APPS;
        }
    }

    private Event getEvent(GetStoreWidgets.WSWidget wSWidget) {
        if (wSWidget.getActions() == null || wSWidget.getActions().size() <= 0) {
            return null;
        }
        return wSWidget.getActions().get(0).getEvent();
    }

    private Install getInstall(AppPromoItem appPromoItem, ApplicationGraphic applicationGraphic) {
        return this.installManager.getInstall(appPromoItem.getGetApp().getNodes().getMeta().getData().getMd5(), applicationGraphic.getPackageName(), appPromoItem.getGetApp().getNodes().getMeta().getData().getFile().getVercode()).W0().b();
    }

    private String getWidgetActionTag(GetStoreWidgets.WSWidget wSWidget) {
        return wSWidget.hasActions() ? wSWidget.getActions().get(0).getTag() : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    private ApplicationGraphic map(GetAppMeta.App app, String str) {
        return new ApplicationGraphic(app.getName(), app.getIcon(), app.getStats().getGlobalRating().getAvg(), app.getStats().getPdownloads(), app.getPackageName(), app.getId(), str, app.hasBilling(), app.getGraphic());
    }

    private RewardApp.Reward mapReward(AppCoinsCampaign.Reward reward) {
        AppCoinsCampaign.Fiat fiat = reward.getFiat();
        return new RewardApp.Reward(reward.getAppc(), new RewardApp.Fiat(fiat.getAmount(), fiat.getCurrency(), fiat.getSymbol()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0343, code lost:
    
        r7 = map(((cm.aptoide.pt.dataprovider.model.v7.ListApps) r5).getDataList().getList(), r8, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<HomeBundle> fromWidgetsToBundles(List<GetStoreWidgets.WSWidget> list) {
        HomeBundle.BundleType actionItemTypeMapper;
        HomeBundle.BundleType bundleType;
        List<Application> list2;
        ArrayList arrayList = new ArrayList();
        for (GetStoreWidgets.WSWidget wSWidget : list) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
                Logger.getInstance().d(getClass().getName(), "Something went wrong with widget to bundle mapping : " + e2.getMessage());
            }
            if (!wSWidget.getType().equals(Type.ACTION_ITEM) && !wSWidget.getType().equals(Type.NEWS_ITEM) && !wSWidget.getType().equals(Type.IN_GAME_EVENT) && !wSWidget.getType().equals(Type.APP_COMING_SOON)) {
                actionItemTypeMapper = bundleTypeMapper(wSWidget.getType(), wSWidget.getData());
                bundleType = actionItemTypeMapper;
                if (bundleType.equals(HomeBundle.BundleType.UNKNOWN)) {
                    Event event = getEvent(wSWidget);
                    String tag = wSWidget.getTag();
                    String widgetActionTag = getWidgetActionTag(wSWidget);
                    Object viewObject = wSWidget.getViewObject();
                    String title = wSWidget.getTitle();
                    if (event != null && event.getName().equals(Event.Name.getStoreWidgets)) {
                        event.setName(Event.Name.getMoreBundle);
                    }
                    HomeBundle.BundleType bundleType2 = HomeBundle.BundleType.APPS;
                    if (!bundleType.equals(bundleType2) && !bundleType.equals(HomeBundle.BundleType.EDITORS) && !bundleType.equals(HomeBundle.BundleType.TOP)) {
                        if (bundleType.equals(HomeBundle.BundleType.FEATURED_BONUS_APPC)) {
                            int i2 = -1;
                            boolean z = true;
                            if (viewObject instanceof BonusAppcBundle) {
                                BonusAppcBundle bonusAppcBundle = (BonusAppcBundle) viewObject;
                                z = bonusAppcBundle.getBonusAppcModel().getHasBonusAppc();
                                list2 = map(bonusAppcBundle.getListApps().getDataList().getList(), bundleType, tag);
                                i2 = bonusAppcBundle.getBonusAppcModel().getBonusPercentage();
                            } else {
                                list2 = null;
                            }
                            if (z) {
                                arrayList.add(new FeaturedAppcBundle(title, list2, bundleType, event, tag, widgetActionTag, i2));
                            } else {
                                arrayList.add(new AppBundle(title, list2, bundleType2, event, tag, widgetActionTag));
                            }
                        } else {
                            HomeBundle.BundleType bundleType3 = HomeBundle.BundleType.APPCOINS_ADS;
                            if (bundleType.equals(bundleType3)) {
                                List<Application> map = viewObject != null ? map(((ListAppCoinsCampaigns) viewObject).getDataList().getList(), tag) : null;
                                if (map == null || !map.isEmpty()) {
                                    arrayList.add(new AppBundle(title, map, bundleType3, new Event().setName(Event.Name.getAppCoinsAds), tag, widgetActionTag));
                                }
                            } else if (bundleType.equals(HomeBundle.BundleType.ADS)) {
                                arrayList.add(new AdBundle(title, new AdsTagWrapper(viewObject != null ? ((GetAdsResponse) viewObject).getAds() : null, tag), new Event().setName(Event.Name.getAds), tag));
                            } else {
                                if (!bundleType.equals(HomeBundle.BundleType.EDITORIAL) && !bundleType.equals(HomeBundle.BundleType.NEWS_ITEM) && !bundleType.equals(HomeBundle.BundleType.IN_GAME_EVENT)) {
                                    if (bundleType.equals(HomeBundle.BundleType.INFO_BUNDLE)) {
                                        ActionItem map2 = map((ActionItemResponse) viewObject);
                                        if (map2 == null || !this.blacklistManager.isBlacklisted(bundleType.toString(), map2.getCardId())) {
                                            arrayList.add(new ActionBundle(title, bundleType, event, tag, map2));
                                        }
                                    } else if (bundleType.equals(HomeBundle.BundleType.WALLET_ADS_OFFER)) {
                                        ActionItem map3 = map((ActionItemResponse) viewObject);
                                        if (map3 == null || this.walletAdsOfferCardManager.shouldShowWalletOfferCard(bundleType.toString(), map3.getCardId())) {
                                            arrayList.add(new ActionBundle(title, bundleType, event, tag, map3));
                                        }
                                    } else if (bundleType.equals(HomeBundle.BundleType.NEW_APP)) {
                                        NewAppCoinsAppPromoItem newAppCoinsAppPromoItem = (NewAppCoinsAppPromoItem) viewObject;
                                        if (newAppCoinsAppPromoItem != null) {
                                            ApplicationGraphic map4 = map(newAppCoinsAppPromoItem.getGetApp().getNodes().getMeta().getData(), tag);
                                            Install install = getInstall(newAppCoinsAppPromoItem, map4);
                                            arrayList.add(new BonusPromotionalBundle(title, bundleType, event, tag, map4, new DownloadModel(this.downloadStateParser.parseDownloadType(install.getType(), false), install.getProgress(), this.downloadStateParser.parseDownloadState(install.getState(), install.isIndeterminate()), install.getAppSize()), newAppCoinsAppPromoItem.getBonusAppcModel().getBonusPercentage()));
                                        } else {
                                            arrayList.add(new BonusPromotionalBundle(title, bundleType, event, tag, null, null, 0));
                                        }
                                    } else if (bundleType.equals(HomeBundle.BundleType.NEW_APP_VERSION)) {
                                        AppPromoItem appPromoItem = (AppPromoItem) viewObject;
                                        if (appPromoItem != null) {
                                            ApplicationGraphic map5 = map(appPromoItem.getGetApp().getNodes().getMeta().getData(), tag);
                                            Install install2 = getInstall(appPromoItem, map5);
                                            arrayList.add(new VersionPromotionalBundle(title, bundleType, event, tag, map5, appPromoItem.getGetApp().getNodes().getMeta().getData().getFile().getVername(), new DownloadModel(this.downloadStateParser.parseDownloadType(install2.getType(), false), install2.getProgress(), this.downloadStateParser.parseDownloadState(install2.getState(), install2.isIndeterminate()), install2.getAppSize())));
                                        } else {
                                            arrayList.add(new VersionPromotionalBundle(title, bundleType, event, tag, null, null, null));
                                        }
                                    } else if (bundleType.equals(HomeBundle.BundleType.APP_COMING_SOON)) {
                                        ActionItem map6 = map((ActionItemResponse) viewObject);
                                        arrayList.add(new AppComingSoonPromotionalBundle(title, bundleType, event, tag, map6, this.appComingSoonRegistrationManager.isNotificationScheduled(map6.getPackageName()).W0().b().booleanValue()));
                                    }
                                }
                                if (viewObject instanceof EditorialActionItem) {
                                    EditorialActionItem editorialActionItem = (EditorialActionItem) viewObject;
                                    arrayList.add(new EditorialActionBundle(title, bundleType, event, tag, map(editorialActionItem.getActionItemResponse()), editorialActionItem.getBonusAppcModel()));
                                } else {
                                    arrayList.add(new ActionBundle(title, bundleType, event, tag, map((ActionItemResponse) viewObject)));
                                }
                            }
                        }
                    }
                    List<Application> list3 = null;
                    arrayList.add(new AppBundle(title, list3, bundleType, event, tag, widgetActionTag));
                }
            }
            actionItemTypeMapper = actionItemTypeMapper(wSWidget);
            bundleType = actionItemTypeMapper;
            if (bundleType.equals(HomeBundle.BundleType.UNKNOWN)) {
            }
        }
        return arrayList;
    }

    private ActionItem map(ActionItemResponse actionItemResponse) {
        if (actionItemResponse == null) {
            return null;
        }
        ActionItemData actionItemData = actionItemResponse.getDataList().getList().get(0);
        return new ActionItem(actionItemData.getId(), actionItemData.getType() != null ? actionItemData.getType() : HttpUrl.FRAGMENT_ENCODE_SET, actionItemData.getTitle(), actionItemData.getCaption(), actionItemData.getIcon(), actionItemData.getUrl(), actionItemData.getViews(), actionItemData.getDate(), actionItemData.getAppearance() != null ? actionItemData.getAppearance().getCaption().getTheme() : HttpUrl.FRAGMENT_ENCODE_SET, actionItemData.getFlair() != null ? actionItemData.getFlair() : HttpUrl.FRAGMENT_ENCODE_SET, actionItemData.getSummary(), actionItemData.getPackageName(), actionItemData.getGraphic());
    }

    private List<Application> map(List<App> list, HomeBundle.BundleType bundleType, String str) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (App app : list) {
                try {
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    if (bundleType.equals(HomeBundle.BundleType.EDITORS)) {
                        AppCoinsInfo appcoins = app.getAppcoins();
                        arrayList.add(new FeatureGraphicApplication(app.getName(), app.getIcon(), app.getStats().getRating().getAvg(), app.getStats().getPdownloads(), app.getPackageName(), app.getId(), app.getGraphic(), str, appcoins != null && appcoins.hasBilling(), appcoins != null && appcoins.hasAdvertising()));
                    } else {
                        AppCoinsInfo appcoins2 = app.getAppcoins();
                        arrayList.add(new Application(app.getName(), app.getIcon(), app.getStats().getRating().getAvg(), app.getStats().getPdownloads(), app.getPackageName(), app.getId(), str, appcoins2 != null && appcoins2.hasBilling()));
                    }
                } catch (Exception e3) {
                    e = e3;
                    Logger.getInstance().d(getClass().getName(), "Something went wrong while parsing apps to applications: " + e.getMessage());
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private List<Application> map(List<AppCoinsCampaign> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (AppCoinsCampaign appCoinsCampaign : list) {
            AppCoinsCampaign.CampaignApp app = appCoinsCampaign.getApp();
            if (!this.installManager.wasAppEverInstalled(app.getPackageName())) {
                arrayList.add(new RewardApp(app.getName(), app.getIcon(), app.getStats().getRating().getAvg(), app.getStats().getPdownloads(), app.getPackageName(), app.getId(), str, app.getAppcoins() != null, app.getAppcoins().getClicks().getClick(), app.getAppcoins().getClicks().getInstall(), mapReward(appCoinsCampaign.getReward()), app.getGraphic()));
            }
        }
        return arrayList;
    }
}
