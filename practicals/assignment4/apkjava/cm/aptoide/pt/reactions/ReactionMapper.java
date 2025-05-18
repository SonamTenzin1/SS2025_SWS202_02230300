package cm.aptoide.pt.reactions;

import cm.aptoide.pt.R;
import cm.aptoide.pt.reactions.data.ReactionType;

/* loaded from: classes.dex */
public class ReactionMapper {

    /* renamed from: cm.aptoide.pt.reactions.ReactionMapper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType;

        static {
            int[] iArr = new int[ReactionType.values().length];
            $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType = iArr;
            try {
                iArr[ReactionType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[ReactionType.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int mapReaction(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1117280700:
                if (str.equals("thumbs_down")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3327858:
                if (str.equals("love")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3559430:
                if (str.equals("thug")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 102745729:
                if (str.equals("laugh")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1330679997:
                if (str.equals("thumbs_up")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return R.drawable.ic_react_thumbs_down;
            case 1:
                return R.drawable.ic_react_love;
            case 2:
                return R.drawable.ic_react_thug;
            case 3:
                return R.drawable.ic_react_laugh;
            case 4:
                return R.drawable.ic_react_thumbs_up;
            default:
                return -1;
        }
    }

    public static String mapUserReaction(ReactionType reactionType) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[reactionType.ordinal()];
        return i2 != 1 ? i2 != 2 ? reactionType.toString().toLowerCase() : "thumbs_down" : "thumbs_up";
    }
}
