package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes2.dex */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static float A(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float B(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        if (J == 0) {
            return null;
        }
        M(parcel, i2, J, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int C(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder D(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + J);
        return readStrongBinder;
    }

    public static int E(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readInt();
    }

    public static Integer F(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        if (J == 0) {
            return null;
        }
        M(parcel, i2, J, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long G(Parcel parcel, int i2) {
        N(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long H(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        if (J == 0) {
            return null;
        }
        M(parcel, i2, J, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short I(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    public static int J(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static void K(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + J(parcel, i2));
    }

    public static int L(Parcel parcel) {
        int C = C(parcel);
        int J = J(parcel, C);
        int dataPosition = parcel.dataPosition();
        if (v(C) == 20293) {
            int i2 = J + dataPosition;
            if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
                return i2;
            }
            throw new ParseException("Size read is invalid start=" + dataPosition + " end=" + i2, parcel);
        }
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(C))), parcel);
    }

    private static void M(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        throw new ParseException("Expected size " + i4 + " got " + i3 + " (0x" + Integer.toHexString(i3) + ")", parcel);
    }

    private static void N(Parcel parcel, int i2, int i3) {
        int J = J(parcel, i2);
        if (J == i3) {
            return;
        }
        throw new ParseException("Expected size " + i3 + " got " + J + " (0x" + Integer.toHexString(J) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + J);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] b(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + J);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + J);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + J);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + J);
        return createBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + J);
        return readBundle;
    }

    public static byte[] g(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + J);
        return createByteArray;
    }

    public static double[] h(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + J);
        return createDoubleArray;
    }

    public static float[] i(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + J);
        return createFloatArray;
    }

    public static int[] j(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + J);
        return createIntArray;
    }

    public static ArrayList<Integer> k(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + J);
        return arrayList;
    }

    public static long[] l(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + J);
        return createLongArray;
    }

    public static Parcel m(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, J);
        parcel.setDataPosition(dataPosition + J);
        return obtain;
    }

    public static Parcel[] n(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + J);
        return parcelArr;
    }

    public static <T extends Parcelable> T o(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + J);
        return createFromParcel;
    }

    public static String p(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + J);
        return readString;
    }

    public static String[] q(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + J);
        return createStringArray;
    }

    public static ArrayList<String> r(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + J);
        return createStringArrayList;
    }

    public static <T> T[] s(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + J);
        return tArr;
    }

    public static <T> ArrayList<T> t(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int J = J(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (J == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + J);
        return createTypedArrayList;
    }

    public static void u(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i2, parcel);
    }

    public static int v(int i2) {
        return (char) i2;
    }

    public static boolean w(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean x(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        if (J == 0) {
            return null;
        }
        M(parcel, i2, J, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double y(Parcel parcel, int i2) {
        N(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static Double z(Parcel parcel, int i2) {
        int J = J(parcel, i2);
        if (J == 0) {
            return null;
        }
        M(parcel, i2, J, 8);
        return Double.valueOf(parcel.readDouble());
    }
}
