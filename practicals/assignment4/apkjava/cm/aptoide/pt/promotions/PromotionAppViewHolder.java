package cm.aptoide.pt.promotions;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.promotions.PromotionAppClick;
import cm.aptoide.pt.themes.ThemeManager;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class PromotionAppViewHolder extends RecyclerView.c0 {
    private TextView appDescription;
    private ImageView appIcon;
    private TextView appName;
    private TextView appRewardMessage;
    private int appState;
    private Button promotionAction;
    private final rx.s.b<PromotionAppClick> promotionAppClick;
    private final ThemeManager themeManager;

    public PromotionAppViewHolder(View view, int i2, rx.s.b<PromotionAppClick> bVar, ThemeManager themeManager) {
        super(view);
        this.appState = i2;
        this.appIcon = (ImageView) view.findViewById(R.id.app_icon);
        this.appName = (TextView) view.findViewById(R.id.app_name);
        this.appDescription = (TextView) view.findViewById(R.id.app_description);
        this.appRewardMessage = (TextView) view.findViewById(R.id.app_reward);
        this.promotionAction = (Button) view.findViewById(R.id.promotion_app_action_button);
        this.promotionAppClick = bVar;
        this.themeManager = themeManager;
    }

    private int getButtonMessage(int i2) {
        if (i2 == 0) {
            return R.string.appview_button_update;
        }
        if (i2 != 1 && i2 != 3) {
            if (i2 == 4) {
                return R.string.promotion_claim_button;
            }
            if (i2 == 5) {
                return R.string.holidayspromotion_button_claimed;
            }
            if (i2 != 6) {
                throw new IllegalArgumentException("Wrong view type of promotion app");
            }
        }
        return R.string.install;
    }

    private PromotionAppClick.ClickType getClickType(int i2) {
        if (i2 == 0) {
            return PromotionAppClick.ClickType.UPDATE;
        }
        if (i2 == 1) {
            return PromotionAppClick.ClickType.DOWNLOAD;
        }
        if (i2 == 3) {
            return PromotionAppClick.ClickType.INSTALL_APP;
        }
        if (i2 == 4) {
            return PromotionAppClick.ClickType.CLAIM;
        }
        if (i2 == 6) {
            return PromotionAppClick.ClickType.DOWNGRADE;
        }
        throw new IllegalArgumentException("Wrong view type of promotion app");
    }

    private SpannableString handleRewardMessage(float f2, String str, double d2, boolean z) {
        String string;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String num = Integer.toString(Math.round(f2));
        if (z) {
            string = this.itemView.getContext().getString(R.string.FIATpromotion_update_to_get_short, num, str + decimalFormat.format(d2));
        } else {
            string = this.itemView.getContext().getString(R.string.FIATpromotion_install_to_get_short, num, str + decimalFormat.format(d2));
        }
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(this.itemView.getContext().getResources().getColor(R.color.promotions_reward)), string.indexOf(num), string.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(PromotionViewApp promotionViewApp, View view) {
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, PromotionAppClick.ClickType.NAVIGATE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setApp$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(PromotionViewApp promotionViewApp, View view) {
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, getClickType(this.appState)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setApp$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(PromotionViewApp promotionViewApp, View view) {
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, getClickType(this.appState)));
    }

    private void lockInstallButton(boolean z) {
        if (z) {
            this.promotionAction.setEnabled(false);
            this.promotionAction.setBackground(this.itemView.getResources().getDrawable(this.themeManager.getAttributeForTheme(R.attr.lockedButton).resourceId));
            this.promotionAction.setTextColor(this.itemView.getContext().getResources().getColor(R.color.grey_fog_light));
        } else {
            this.promotionAction.setEnabled(true);
            this.promotionAction.setBackground(this.itemView.getContext().getResources().getDrawable(R.drawable.appc_gradient_rounded));
        }
    }

    private void setAppCardHeader(PromotionViewApp promotionViewApp) {
        ImageLoader.with(this.itemView.getContext()).load(promotionViewApp.getAppIcon(), this.appIcon);
        this.appName.setText(promotionViewApp.getName());
        this.appDescription.setText(promotionViewApp.getDescription());
        this.appRewardMessage.setText(handleRewardMessage(promotionViewApp.getAppcValue(), promotionViewApp.getFiatSymbol(), promotionViewApp.getFiatValue(), this.appState == 0));
    }

    public void setApp(final PromotionViewApp promotionViewApp, boolean z) {
        setAppCardHeader(promotionViewApp);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.promotions.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionAppViewHolder.this.a(promotionViewApp, view);
            }
        });
        this.promotionAction.setText(this.itemView.getContext().getString(getButtonMessage(this.appState), Float.valueOf(promotionViewApp.getAppcValue())));
        if (!z && this.appState != 5) {
            lockInstallButton(true);
            return;
        }
        int i2 = this.appState;
        if (i2 != 5) {
            if (i2 == 4) {
                this.promotionAction.setEnabled(true);
                this.promotionAction.setBackgroundDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.card_border_rounded_green));
                this.promotionAction.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.promotions.f1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PromotionAppViewHolder.this.b(promotionViewApp, view);
                    }
                });
                return;
            } else {
                lockInstallButton(false);
                this.promotionAction.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.promotions.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PromotionAppViewHolder.this.c(promotionViewApp, view);
                    }
                });
                return;
            }
        }
        lockInstallButton(true);
        this.promotionAction.setBackground(this.itemView.getResources().getDrawable(this.themeManager.getAttributeForTheme(R.attr.claimedButton).resourceId));
        this.promotionAction.setTextColor(this.themeManager.getAttributeForTheme(android.R.attr.textColorPrimary).data);
        SpannableString spannableString = new SpannableString("  " + this.itemView.getResources().getString(R.string.holidayspromotion_button_claimed).toUpperCase());
        Drawable d2 = c.a.k.a.a.d(this.itemView.getContext(), R.drawable.ic_promotion_claimed_check);
        d2.setBounds(0, 0, d2.getIntrinsicWidth(), d2.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(d2, 1), 0, 1, 18);
        this.promotionAction.setTransformationMethod(null);
        this.promotionAction.setText(spannableString);
    }
}
