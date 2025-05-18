package cm.aptoide.pt.account;

/* loaded from: classes.dex */
public class OAuthModeProvider {
    public String getAuthMode(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2001934:
                if (str.equals("ABAN")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1279756998:
                if (str.equals(FacebookSignUpAdapter.TYPE)) {
                    c2 = 1;
                    break;
                }
                break;
            case 2108052025:
                if (str.equals(GoogleSignUpAdapter.TYPE)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "aban";
            case 1:
                return "facebook";
            case 2:
                return "google";
            default:
                return null;
        }
    }
}
