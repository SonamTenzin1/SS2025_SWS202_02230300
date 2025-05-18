package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    /* loaded from: classes2.dex */
    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedFlowDirectlySnapshot(int i2, boolean z, int i3) {
            super(i2, z, i3);
        }
    }

    /* loaded from: classes2.dex */
    public static class PausedSnapshot extends PendingMessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public PausedSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -2;
        }
    }

    /* loaded from: classes2.dex */
    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: h, reason: collision with root package name */
        private final int f20484h;

        /* renamed from: i, reason: collision with root package name */
        private final int f20485i;

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.e(), pendingMessageSnapshot.i(), pendingMessageSnapshot.j());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20484h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20485i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20484h);
            parcel.writeInt(this.f20485i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(int i2, int i3, int i4) {
            super(i2);
            this.f20484h = i3;
            this.f20485i = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20484h = parcel.readInt();
            this.f20485i = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnFlowDirectlySnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.b
        public MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    SmallMessageSnapshot(int i2) {
        super(i2);
        this.f20475g = false;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long f() {
        return i();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long g() {
        return j();
    }

    /* loaded from: classes2.dex */
    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: h, reason: collision with root package name */
        private final int f20486h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(int i2, int i3) {
            super(i2);
            this.f20486h = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20486h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20486h);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20486h = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: j, reason: collision with root package name */
        private final int f20487j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f20487j = i4;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int h() {
            return this.f20487j;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20487j);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20487j = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* renamed from: h, reason: collision with root package name */
        private final boolean f20476h;

        /* renamed from: i, reason: collision with root package name */
        private final int f20477i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(int i2, boolean z, int i3) {
            super(i2);
            this.f20476h = z;
            this.f20477i = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20477i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean o() {
            return this.f20476h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20476h ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f20477i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f20476h = parcel.readByte() != 0;
            this.f20477i = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: h, reason: collision with root package name */
        private final int f20482h;

        /* renamed from: i, reason: collision with root package name */
        private final Throwable f20483i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(int i2, int i3, Throwable th) {
            super(i2);
            this.f20482h = i3;
            this.f20483i = th;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20482h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public Throwable l() {
            return this.f20483i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20482h);
            parcel.writeSerializable(this.f20483i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20482h = parcel.readInt();
            this.f20483i = (Throwable) parcel.readSerializable();
        }
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes2.dex */
    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: h, reason: collision with root package name */
        private final boolean f20478h;

        /* renamed from: i, reason: collision with root package name */
        private final int f20479i;

        /* renamed from: j, reason: collision with root package name */
        private final String f20480j;

        /* renamed from: k, reason: collision with root package name */
        private final String f20481k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.f20478h = z;
            this.f20479i = i3;
            this.f20480j = str;
            this.f20481k = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String c() {
            return this.f20480j;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String d() {
            return this.f20481k;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20479i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean n() {
            return this.f20478h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20478h ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f20479i);
            parcel.writeString(this.f20480j);
            parcel.writeString(this.f20481k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20478h = parcel.readByte() != 0;
            this.f20479i = parcel.readInt();
            this.f20480j = parcel.readString();
            this.f20481k = parcel.readString();
        }
    }
}
