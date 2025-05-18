package cm.aptoide.pt.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class HorizontalHeaderItemDecoration extends RecyclerView.n {
    private static final float PARALLAX_RATIO = 0.3f;
    private static final int VERTICAL_OFFSET = 20;
    private int headerSize;
    private View layout;
    private int margin;

    public HorizontalHeaderItemDecoration(Context context, RecyclerView recyclerView, int i2, int i3, int i4) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        View inflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) recyclerView, false);
        this.layout = inflate;
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.headerSize = i3;
        this.margin = i4;
        View view = this.layout;
        view.layout(0, 0, view.getMeasuredWidth(), this.layout.getMeasuredHeight());
    }

    private float getPercentage(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2 = this.margin;
        rect.set(i2, i2, 0, i2);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.headerSize;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f2;
        super.onDraw(canvas, recyclerView, zVar);
        float f3 = -(this.layout.getMeasuredWidth() / 2.0f);
        float measuredWidth = (((this.headerSize / 2.0f) - (this.layout.getMeasuredWidth() / 2.0f)) - (this.margin / 2.0f)) * PARALLAX_RATIO;
        boolean z = false;
        int i2 = 0;
        float f4 = 0.0f;
        while (true) {
            if (i2 >= recyclerView.getChildCount()) {
                f2 = 0.0f;
                break;
            }
            View childAt = recyclerView.getChildAt(i2);
            if (f4 == 0.0f) {
                f4 = (childAt.getTop() + (childAt.getMeasuredHeight() / 2.0f)) - (this.layout.getMeasuredWidth() / 2.0f);
            }
            if (recyclerView.getChildAdapterPosition(childAt) == 0) {
                f2 = (((childAt.getLeft() - (this.headerSize / 2.0f)) - (this.layout.getMeasuredWidth() / 2.0f)) - (this.margin / 2.0f)) * PARALLAX_RATIO;
                if (f2 < f3) {
                    f2 = f3;
                }
                z = true;
            } else {
                i2++;
            }
        }
        if (!z) {
            f2 = f3;
        }
        int max = Math.max((int) (getPercentage(f3, measuredWidth, f2) * 255.0f), 1);
        canvas.save();
        canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, this.headerSize - 2, canvas.getHeight()), max, 31);
        canvas.translate(f2, f4 - 20.0f);
        this.layout.draw(canvas);
        canvas.restore();
    }
}
