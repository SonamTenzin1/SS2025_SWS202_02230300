package cm.aptoide.pt.comments.view;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.comments.CommentNode;
import cm.aptoide.pt.comments.ComplexComment;
import cm.aptoide.pt.comments.view.StoreLatestCommentsWidget;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.store.view.StoreLatestCommentsDisplayable;
import cm.aptoide.pt.util.CommentOperations;
import cm.aptoide.pt.view.FragmentProvider;
import cm.aptoide.pt.view.custom.HorizontalDividerItemDecoration;
import cm.aptoide.pt.view.recycler.BaseAdapter;
import cm.aptoide.pt.view.recycler.widget.Widget;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class StoreLatestCommentsWidget extends Widget<StoreLatestCommentsDisplayable> {
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Converter.Factory converterFactory;
    private OkHttpClient httpClient;
    private RecyclerView recyclerView;
    private long storeId;
    private String storeName;
    private TokenInvalidator tokenInvalidator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CommentListAdapter extends BaseAdapter {
        private final AptoideAccountManager accountManager;
        private AccountNavigator accountNavigator;

        CommentListAdapter(long j2, String str, List<Comment> list, FragmentManager fragmentManager, View view, rx.e<Void> eVar, AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, FragmentNavigator fragmentNavigator, FragmentProvider fragmentProvider) {
            this.accountManager = aptoideAccountManager;
            this.accountNavigator = accountNavigator;
            CommentOperations commentOperations = new CommentOperations();
            List<CommentNode> flattenByDepth = commentOperations.flattenByDepth(commentOperations.transform(list));
            ArrayList arrayList = new ArrayList(flattenByDepth.size());
            for (CommentNode commentNode : flattenByDepth) {
                arrayList.add(new CommentDisplayable(new ComplexComment(commentNode, showStoreCommentFragment(j2, commentNode.getComment(), str, fragmentManager, view, eVar)), fragmentNavigator, fragmentProvider));
            }
            addDisplayables(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showSignInMessage$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void n(View view) {
            this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.LATEST_COMMENTS_STORE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showSignInMessage$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void o(View view) {
            Snackbar.Z(view, R.string.you_need_to_be_logged_in, 0).b0(R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.comments.view.k1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StoreLatestCommentsWidget.CommentListAdapter.this.n(view2);
                }
            }).P();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ rx.e lambda$showStoreCommentFragment$2(rx.e eVar, com.trello.rxlifecycle.g.b bVar) {
            return eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showStoreCommentFragment$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ rx.b p(long j2, Comment comment, String str, final FragmentManager fragmentManager, final rx.e eVar, View view, Account account) {
            if (account.isLoggedIn()) {
                final CommentDialogFragment newInstanceStoreCommentReply = CommentDialogFragment.newInstanceStoreCommentReply(j2, comment.getId(), str);
                return newInstanceStoreCommentReply.lifecycle().y(new rx.m.a() { // from class: cm.aptoide.pt.comments.view.g1
                    @Override // rx.m.a
                    public final void call() {
                        CommentDialogFragment.this.show(fragmentManager, "fragment_comment_dialog_latest");
                    }
                }).D(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.f1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        Boolean valueOf;
                        valueOf = Boolean.valueOf(((com.trello.rxlifecycle.g.b) obj).equals(com.trello.rxlifecycle.g.b.DESTROY_VIEW));
                        return valueOf;
                    }
                }).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.j1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        rx.e eVar2 = rx.e.this;
                        StoreLatestCommentsWidget.CommentListAdapter.lambda$showStoreCommentFragment$2(eVar2, (com.trello.rxlifecycle.g.b) obj);
                        return eVar2;
                    }
                }).X0();
            }
            return showSignInMessage(view);
        }

        private rx.b showSignInMessage(final View view) {
            return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.comments.view.h1
                @Override // rx.m.a
                public final void call() {
                    StoreLatestCommentsWidget.CommentListAdapter.this.o(view);
                }
            });
        }

        private rx.b showStoreCommentFragment(final long j2, final Comment comment, final String str, final FragmentManager fragmentManager, final View view, final rx.e<Void> eVar) {
            return this.accountManager.accountStatus().E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.i1
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return StoreLatestCommentsWidget.CommentListAdapter.this.p(j2, comment, str, fragmentManager, eVar, view, (Account) obj);
                }
            });
        }
    }

    public StoreLatestCommentsWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadComments$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(ListComments listComments) {
        setAdapter(listComments.getDataList().getList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reloadComments, reason: merged with bridge method [inline-methods] */
    public Void b() {
        ManagerPreferences.setForceServerRefreshFlag(true, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.compositeSubscription.a(ListCommentsRequest.of(this.storeId, 0, 3, false, this.baseBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).observe().I0(Schedulers.io()).j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                StoreLatestCommentsWidget.this.a((ListComments) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.comments.view.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
        return null;
    }

    private void setAdapter(List<Comment> list) {
        RecyclerView recyclerView = this.recyclerView;
        long j2 = this.storeId;
        String str = this.storeName;
        FragmentManager supportFragmentManager = getContext().getSupportFragmentManager();
        RecyclerView recyclerView2 = this.recyclerView;
        rx.e P = rx.e.P(new Callable() { // from class: cm.aptoide.pt.comments.view.n1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return StoreLatestCommentsWidget.this.b();
            }
        });
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        AccountNavigator accountNavigator = this.accountNavigator;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        recyclerView.setAdapter(new CommentListAdapter(j2, str, list, supportFragmentManager, recyclerView2, P, aptoideAccountManager, accountNavigator, fragmentNavigator, AptoideApplication.getFragmentProvider()));
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.comments);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(StoreLatestCommentsDisplayable storeLatestCommentsDisplayable, int i2) {
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.recyclerView.getContext()));
        this.recyclerView.addItemDecoration(new HorizontalDividerItemDecoration(((ActivityResultNavigator) getContext()).getActivity(), storeLatestCommentsDisplayable.getThemeManager()));
        this.storeId = storeLatestCommentsDisplayable.getStoreId();
        this.storeName = storeLatestCommentsDisplayable.getStoreName();
        setAdapter(storeLatestCommentsDisplayable.getComments());
    }
}
