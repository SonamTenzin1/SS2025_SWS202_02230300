package cm.aptoide.pt.view.recycler.displayable;

import android.content.res.Resources;
import android.view.WindowManager;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.widget.WidgetFactory;
import java.util.List;

/* loaded from: classes.dex */
public class DisplayableGroup extends Displayable {
    private final List<Displayable> children;
    private final Resources resources;
    private final WindowManager windowManager;

    public DisplayableGroup(List<Displayable> list, WindowManager windowManager, Resources resources) {
        this(list, true, windowManager, resources);
    }

    private void computeLeftSpaces() {
        int columnSize = WidgetFactory.getColumnSize(this.resources, this.windowManager);
        int i2 = 0;
        for (Displayable displayable : this.children) {
            if (displayable.getSpanSize(this.windowManager, this.resources) + i2 > columnSize) {
                i2 = displayable.getSpanSize(this.windowManager, this.resources);
            } else {
                i2 += displayable.getSpanSize(this.windowManager, this.resources);
            }
        }
        if (i2 < columnSize) {
            this.children.add(new EmptyDisplayable(columnSize - i2));
        }
    }

    public List<Displayable> getChildren() {
        return this.children;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getDefaultPerLineCount() {
        throw new IllegalStateException("getDefaultPerLineCount() on DisplayableGroup should not be called!");
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        throw new IllegalStateException("getViewLayout() on DisplayableGroup should not be called!");
    }

    DisplayableGroup(List<Displayable> list, boolean z, WindowManager windowManager, Resources resources) {
        this.children = list;
        this.windowManager = windowManager;
        this.resources = resources;
        if (z) {
            computeLeftSpaces();
        }
    }
}
