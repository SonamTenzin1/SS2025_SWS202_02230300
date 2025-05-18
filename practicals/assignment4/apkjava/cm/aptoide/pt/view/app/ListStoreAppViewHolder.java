package cm.aptoide.pt.view.app;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class ListStoreAppViewHolder extends RecyclerView.c0 {
    public ListStoreAppViewHolder(View view) {
        super(view);
    }

    public abstract void setApp(Application application);
}
