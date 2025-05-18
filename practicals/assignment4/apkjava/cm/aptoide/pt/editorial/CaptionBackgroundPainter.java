package cm.aptoide.pt.editorial;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import cm.aptoide.pt.R;

/* loaded from: classes.dex */
public class CaptionBackgroundPainter {
    private final Resources resources;

    public CaptionBackgroundPainter(Resources resources) {
        this.resources = resources;
    }

    private void setDefaultBackgroundColor(CardView cardView) {
        cardView.setCardBackgroundColor(this.resources.getColor(R.color.curation_default));
    }

    public void addColorBackgroundToCaption(CardView cardView, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                cardView.setCardBackgroundColor(Color.parseColor(str));
                return;
            } catch (IllegalArgumentException unused) {
                setDefaultBackgroundColor(cardView);
                return;
            }
        }
        setDefaultBackgroundColor(cardView);
    }
}
