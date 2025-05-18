package cm.aptoide.pt.dataprovider.ws.v7.analyticsbody;

/* loaded from: classes.dex */
public class Result {
    private ResultError error;
    private ResultStatus status;

    /* loaded from: classes.dex */
    public enum ResultStatus {
        SUCC,
        FAIL
    }

    public ResultError getError() {
        return this.error;
    }

    public ResultStatus getStatus() {
        return this.status;
    }

    public void setError(ResultError resultError) {
        this.error = resultError;
    }

    public void setStatus(ResultStatus resultStatus) {
        this.status = resultStatus;
    }
}
