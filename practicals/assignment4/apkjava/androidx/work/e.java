package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Data.java */
/* loaded from: classes.dex */
public final class e {
    private static final String a = n.f("Data");

    /* renamed from: b, reason: collision with root package name */
    public static final e f2327b = new a().a();

    /* renamed from: c, reason: collision with root package name */
    Map<String, Object> f2328c;

    /* compiled from: Data.java */
    /* loaded from: classes.dex */
    public static final class a {
        private Map<String, Object> a = new HashMap();

        public e a() {
            e eVar = new e((Map<String, ?>) this.a);
            e.l(eVar);
            return eVar;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls != Boolean.class && cls != Byte.class && cls != Integer.class && cls != Long.class && cls != Float.class && cls != Double.class && cls != String.class && cls != Boolean[].class && cls != Byte[].class && cls != Integer[].class && cls != Long[].class && cls != Float[].class && cls != Double[].class && cls != String[].class) {
                    if (cls == boolean[].class) {
                        this.a.put(str, e.a((boolean[]) obj));
                    } else if (cls == byte[].class) {
                        this.a.put(str, e.b((byte[]) obj));
                    } else if (cls == int[].class) {
                        this.a.put(str, e.e((int[]) obj));
                    } else if (cls == long[].class) {
                        this.a.put(str, e.f((long[]) obj));
                    } else if (cls == float[].class) {
                        this.a.put(str, e.d((float[]) obj));
                    } else if (cls == double[].class) {
                        this.a.put(str, e.c((double[]) obj));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                    }
                } else {
                    this.a.put(str, obj);
                }
            }
            return this;
        }

        public a c(e eVar) {
            d(eVar.f2328c);
            return this;
        }

        public a d(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a e(String str, boolean z) {
            this.a.put(str, Boolean.valueOf(z));
            return this;
        }

        public a f(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }
    }

    e() {
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x005d -> B:16:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e g(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable e2;
        if (bArr.length <= 10240) {
            HashMap hashMap = new HashMap();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (IOException e3) {
                Log.e(a, "Error in Data#fromByteArray: ", e3);
            }
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                            hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e4) {
                            Log.e(a, "Error in Data#fromByteArray: ", e4);
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                        e2 = e5;
                        Log.e(a, "Error in Data#fromByteArray: ", e2);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e6) {
                                Log.e(a, "Error in Data#fromByteArray: ", e6);
                            }
                        }
                        byteArrayInputStream.close();
                        return new e(hashMap);
                    } catch (ClassNotFoundException e7) {
                        e2 = e7;
                        Log.e(a, "Error in Data#fromByteArray: ", e2);
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return new e(hashMap);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e8) {
                            Log.e(a, "Error in Data#fromByteArray: ", e8);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e9) {
                        Log.e(a, "Error in Data#fromByteArray: ", e9);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                Throwable th3 = e;
                objectInputStream = null;
                e2 = th3;
                Log.e(a, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (ClassNotFoundException e11) {
                e = e11;
                Throwable th32 = e;
                objectInputStream = null;
                e2 = th32;
                Log.e(a, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (Throwable th4) {
                th = th4;
                if (0 != 0) {
                }
                byteArrayInputStream.close();
                throw th;
            }
            return new e(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public static byte[] l(e eVar) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            objectOutputStream.writeInt(eVar.k());
            for (Map.Entry<String, Object> entry : eVar.f2328c.entrySet()) {
                objectOutputStream.writeUTF(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e3) {
                Log.e(a, "Error in Data#toByteArray: ", e3);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                Log.e(a, "Error in Data#toByteArray: ", e4);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e5) {
            e = e5;
            objectOutputStream2 = objectOutputStream;
            Log.e(a, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e6) {
                    Log.e(a, "Error in Data#toByteArray: ", e6);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e7) {
                Log.e(a, "Error in Data#toByteArray: ", e7);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e8) {
                    Log.e(a, "Error in Data#toByteArray: ", e8);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e9) {
                Log.e(a, "Error in Data#toByteArray: ", e9);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        Set<String> keySet = this.f2328c.keySet();
        if (!keySet.equals(eVar.f2328c.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f2328c.get(str);
            Object obj3 = eVar.f2328c.get(str);
            if (obj2 == null || obj3 == null) {
                z = obj2 == obj3;
            } else if ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
            } else {
                z = obj2.equals(obj3);
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public boolean h(String str, boolean z) {
        Object obj = this.f2328c.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public int hashCode() {
        return this.f2328c.hashCode() * 31;
    }

    public Map<String, Object> i() {
        return Collections.unmodifiableMap(this.f2328c);
    }

    public String j(String str) {
        Object obj = this.f2328c.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int k() {
        return this.f2328c.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f2328c.isEmpty()) {
            for (String str : this.f2328c.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f2328c.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public e(e eVar) {
        this.f2328c = new HashMap(eVar.f2328c);
    }

    public e(Map<String, ?> map) {
        this.f2328c = new HashMap(map);
    }
}
