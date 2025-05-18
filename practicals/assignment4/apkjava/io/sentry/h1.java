package io.sentry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: EnvelopeReader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class h1 implements s1 {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final c2 f22421b;

    public h1(c2 c2Var) {
        this.f22421b = c2Var;
    }

    private i4 b(byte[] bArr, int i2, int i3) {
        StringReader stringReader = new StringReader(new String(bArr, i2, i3, a));
        try {
            i4 i4Var = (i4) this.f22421b.c(stringReader, i4.class);
            stringReader.close();
            return i4Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private k4 c(byte[] bArr, int i2, int i3) {
        StringReader stringReader = new StringReader(new String(bArr, i2, i3, a));
        try {
            k4 k4Var = (k4) this.f22421b.c(stringReader, k4.class);
            stringReader.close();
            return k4Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        r11 = new io.sentry.h4(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e2, code lost:
    
        throw new java.lang.IllegalArgumentException("Item header at index '" + r2.size() + "' is null or empty.");
     */
    @Override // io.sentry.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h4 a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                int i4 = 0;
                while (true) {
                    if (i2 == -1 && i4 < read) {
                        if (bArr[i4] == 10) {
                            i2 = i3 + i4;
                            break;
                        }
                        i4++;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i3 += read;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length == 0) {
            throw new IllegalArgumentException("Empty stream.");
        }
        if (i2 != -1) {
            i4 b2 = b(byteArray, 0, i2);
            if (b2 != null) {
                int i5 = i2 + 1;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int i6 = i5;
                    while (true) {
                        if (i6 >= byteArray.length) {
                            i6 = -1;
                            break;
                        }
                        if (byteArray[i6] == 10) {
                            break;
                        }
                        i6++;
                    }
                    if (i6 != -1) {
                        k4 c2 = c(byteArray, i5, i6 - i5);
                        if (c2 == null || c2.a() <= 0) {
                            break;
                        }
                        int a2 = c2.a() + i6 + 1;
                        if (a2 <= byteArray.length) {
                            arrayList.add(new j4(c2, Arrays.copyOfRange(byteArray, i6 + 1, a2)));
                            if (a2 == byteArray.length) {
                                break;
                            }
                            i5 = a2 + 1;
                            if (i5 == byteArray.length) {
                                if (byteArray[a2] != 10) {
                                    throw new IllegalArgumentException("Envelope has invalid data following an item.");
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid length for item at index '" + arrayList.size() + "'. Item is '" + a2 + "' bytes. There are '" + byteArray.length + "' in the buffer.");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid envelope. Item at index '" + arrayList.size() + "'. has no header delimiter.");
                    }
                }
            } else {
                throw new IllegalArgumentException("Envelope header is null.");
            }
        } else {
            throw new IllegalArgumentException("Envelope contains no header.");
        }
    }
}
