package cm.aptoide.pt.promotions;

import java.util.List;

/* loaded from: classes.dex */
public class ClaimStatusWrapper {
    private final List<Error> errors;
    private final Status status;

    /* loaded from: classes.dex */
    public enum Error {
        PROMOTION_CLAIMED,
        WRONG_ADDRESS,
        GENERIC,
        WALLET_NOT_VERIFIED
    }

    /* loaded from: classes.dex */
    public enum Status {
        OK,
        FAIL
    }

    public ClaimStatusWrapper(Status status, List<Error> list) {
        this.status = status;
        this.errors = list;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public Status getStatus() {
        return this.status;
    }
}
