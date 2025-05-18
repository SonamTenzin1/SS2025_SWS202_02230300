package cm.aptoide.pt.view.recycler;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse;

/* loaded from: classes.dex */
public class MultiLangPatch {
    private int total;
    private int totalWaiting;

    public int getTotal() {
        return this.total;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateOffset() {
        this.total = this.totalWaiting;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateTotal(BaseV7EndlessResponse baseV7EndlessResponse) {
        this.totalWaiting += baseV7EndlessResponse.getTotal();
    }
}
