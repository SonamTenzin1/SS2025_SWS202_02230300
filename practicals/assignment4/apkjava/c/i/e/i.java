package c.i.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.d.c;
import c.i.h.f;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public class i extends j {
    @Override // c.i.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        try {
            c.C0022c[] a = bVar.a();
            int length = a.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                c.C0022c c0022c = a[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0022c.b()).setWeight(c0022c.e());
                    if (!c0022c.f()) {
                        i4 = 0;
                    }
                    Font build = weight.setSlant(i4).setTtcIndex(c0022c.c()).setFontVariationSettings(c0022c.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005a, code lost:
    
        if (r4 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        if ((r14 & 1) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
    
        r12 = 700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006a, code lost:
    
        if ((r14 & 2) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        return new android.graphics.Typeface.CustomFallbackBuilder(r4.build()).setStyle(new android.graphics.fonts.FontStyle(r12, r2)).build();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0066, code lost:
    
        r12 = 400;
     */
    @Override // c.i.e.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        int i3;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            int i4 = 0;
            FontFamily.Builder builder = null;
            while (true) {
                int i5 = 1;
                if (i3 >= length) {
                    break;
                }
                f.b bVar = bVarArr[i3];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.e());
                        if (!bVar.f()) {
                            i5 = 0;
                        }
                        Font build = weight.setSlant(i5).setTtcIndex(bVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable unused2) {
                        }
                        throw th;
                        break;
                    }
                } else {
                    i3 = openFileDescriptor == null ? i3 + 1 : 0;
                }
                openFileDescriptor.close();
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.i.e.j
    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // c.i.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.i.e.j
    public f.b h(f.b[] bVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
