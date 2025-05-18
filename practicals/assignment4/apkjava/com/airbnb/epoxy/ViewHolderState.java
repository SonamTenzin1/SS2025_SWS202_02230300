package com.airbnb.epoxy;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewHolderState extends c.e.d<ViewState> implements Parcelable {
    public static final Parcelable.Creator<ViewHolderState> CREATOR = new a();

    /* loaded from: classes.dex */
    public static class ViewState extends SparseArray<Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ViewState> CREATOR = new a();

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<ViewState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ViewState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ViewState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                int readInt = parcel.readInt();
                int[] iArr = new int[readInt];
                parcel.readIntArray(iArr);
                return new ViewState(readInt, iArr, parcel.readParcelableArray(classLoader), null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ViewState[] newArray(int i2) {
                return new ViewState[i2];
            }
        }

        /* synthetic */ ViewState(int i2, int[] iArr, Parcelable[] parcelableArr, a aVar) {
            this(i2, iArr, parcelableArr);
        }

        private void e(View view) {
            if (view.getId() == -1) {
                view.setId(e.a.a.a.a);
            }
        }

        public void b(View view) {
            int id = view.getId();
            e(view);
            view.restoreHierarchyState(this);
            view.setId(id);
        }

        public void d(View view) {
            int id = view.getId();
            e(view);
            view.saveHierarchyState(this);
            view.setId(id);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int size = size();
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = keyAt(i3);
                parcelableArr[i3] = valueAt(i3);
            }
            parcel.writeInt(size);
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ViewState() {
        }

        private ViewState(int i2, int[] iArr, Parcelable[] parcelableArr) {
            super(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                put(iArr[i3], parcelableArr[i3]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<ViewHolderState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolderState createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ViewHolderState viewHolderState = new ViewHolderState(readInt, null);
            for (int i2 = 0; i2 < readInt; i2++) {
                viewHolderState.k(parcel.readLong(), (ViewState) parcel.readParcelable(ViewState.class.getClassLoader()));
            }
            return viewHolderState;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ViewHolderState[] newArray(int i2) {
            return new ViewHolderState[i2];
        }
    }

    /* synthetic */ ViewHolderState(int i2, a aVar) {
        this(i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void p(u uVar) {
        if (uVar.c().shouldSaveViewState()) {
            ViewState g2 = g(uVar.getItemId());
            if (g2 != null) {
                g2.b(uVar.itemView);
            } else {
                uVar.e();
            }
        }
    }

    public void q(u uVar) {
        if (uVar.c().shouldSaveViewState()) {
            ViewState g2 = g(uVar.getItemId());
            if (g2 == null) {
                g2 = new ViewState();
            }
            g2.d(uVar.itemView);
            k(uVar.getItemId(), g2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int n = n();
        parcel.writeInt(n);
        for (int i3 = 0; i3 < n; i3++) {
            parcel.writeLong(j(i3));
            parcel.writeParcelable(o(i3), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewHolderState() {
    }

    private ViewHolderState(int i2) {
        super(i2);
    }
}
