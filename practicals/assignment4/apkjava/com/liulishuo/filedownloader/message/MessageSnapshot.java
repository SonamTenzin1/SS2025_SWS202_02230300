package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import e.h.a.k0.f;

/* loaded from: classes2.dex */
public abstract class MessageSnapshot implements Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private final int f20474f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f20475g;

    /* loaded from: classes2.dex */
    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(f.o("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k()), messageSnapshot.getClass().getName()));
        }
    }

    /* loaded from: classes2.dex */
    public static class StartedMessageSnapshot extends MessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StartedMessageSnapshot(int i2) {
            super(i2);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 6;
        }

        StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<MessageSnapshot> {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot warnMessageSnapshot;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            if (readByte != -4) {
                if (readByte != -3) {
                    if (readByte != -1) {
                        if (readByte != 1) {
                            if (readByte != 2) {
                                if (readByte != 3) {
                                    if (readByte != 5) {
                                        if (readByte != 6) {
                                            messageSnapshot = null;
                                            if (messageSnapshot == null) {
                                                messageSnapshot.f20475g = z;
                                                return messageSnapshot;
                                            }
                                            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
                                        }
                                        warnMessageSnapshot = new StartedMessageSnapshot(parcel);
                                    } else if (z) {
                                        warnMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(parcel);
                                    } else {
                                        warnMessageSnapshot = new SmallMessageSnapshot.RetryMessageSnapshot(parcel);
                                    }
                                } else if (z) {
                                    warnMessageSnapshot = new LargeMessageSnapshot.ProgressMessageSnapshot(parcel);
                                } else {
                                    warnMessageSnapshot = new SmallMessageSnapshot.ProgressMessageSnapshot(parcel);
                                }
                            } else if (z) {
                                warnMessageSnapshot = new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel);
                            } else {
                                warnMessageSnapshot = new SmallMessageSnapshot.ConnectedMessageSnapshot(parcel);
                            }
                        } else if (z) {
                            warnMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(parcel);
                        } else {
                            warnMessageSnapshot = new SmallMessageSnapshot.PendingMessageSnapshot(parcel);
                        }
                    } else if (z) {
                        warnMessageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(parcel);
                    } else {
                        warnMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(parcel);
                    }
                } else if (z) {
                    warnMessageSnapshot = new LargeMessageSnapshot.CompletedSnapshot(parcel);
                } else {
                    warnMessageSnapshot = new SmallMessageSnapshot.CompletedSnapshot(parcel);
                }
            } else if (z) {
                warnMessageSnapshot = new LargeMessageSnapshot.WarnMessageSnapshot(parcel);
            } else {
                warnMessageSnapshot = new SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            }
            messageSnapshot = warnMessageSnapshot;
            if (messageSnapshot == null) {
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageSnapshot[] newArray(int i2) {
            return new MessageSnapshot[i2];
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        MessageSnapshot a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(int i2) {
        this.f20474f = i2;
    }

    public String c() {
        throw new NoFieldException("getEtag", this);
    }

    public String d() {
        throw new NoFieldException("getFileName", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f20474f;
    }

    public long f() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public long g() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int h() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int i() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int j() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public abstract /* synthetic */ byte k();

    public Throwable l() {
        throw new NoFieldException("getThrowable", this);
    }

    public boolean m() {
        return this.f20475g;
    }

    public boolean n() {
        throw new NoFieldException("isResuming", this);
    }

    public boolean o() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f20475g ? (byte) 1 : (byte) 0);
        parcel.writeByte(k());
        parcel.writeInt(this.f20474f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(Parcel parcel) {
        this.f20474f = parcel.readInt();
    }
}
