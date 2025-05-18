package cm.aptoide.pt.networking.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.o.c.e;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class ShadowCircleTransformation extends e {
    private static final String ID = "cm.aptoide.pt.networking.image.ShadowCircleTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);
    private final int shadowColor;
    private final float spaceBetween;
    private final float strokeSize;

    public ShadowCircleTransformation(Context context, View view) {
        view.setLayerType(1, null);
        this.shadowColor = -1;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.0f;
    }

    private Bitmap circleCrop(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap d2 = eVar.d(min, min, Bitmap.Config.ARGB_8888);
        if (d2 == null) {
            d2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d2);
        float f2 = min;
        float f3 = f2 / 2.0f;
        Paint paint = new Paint();
        paint.setColor(this.shadowColor);
        paint.setStyle(Paint.Style.FILL);
        float f4 = 0.02f * f2;
        paint.setShadowLayer(f4, 0.0f, 0.0f, -7829368);
        paint.setAntiAlias(true);
        float f5 = f3 - f4;
        canvas.drawCircle(f3, f3, f5, paint);
        paint.setColor(-1);
        canvas.drawCircle(f3, f3, f5 * this.spaceBetween, paint);
        Paint paint2 = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint2.setAntiAlias(true);
        canvas.drawCircle(f3, f3, f3 - (f2 * this.strokeSize), paint2);
        return d2;
    }

    public String getId() {
        return getClass().getName();
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return 1388573390;
    }

    @Override // com.bumptech.glide.load.o.c.e
    protected Bitmap transform(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3) {
        return circleCrop(eVar, bitmap);
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }

    public ShadowCircleTransformation(Context context) {
        this.shadowColor = -1;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.0f;
    }

    public ShadowCircleTransformation(Context context, View view, int i2, float f2, float f3) {
        this.strokeSize = f3;
        view.setLayerType(1, null);
        this.shadowColor = i2;
        this.spaceBetween = f2;
    }

    public ShadowCircleTransformation(Context context, View view, int i2) {
        view.setLayerType(1, null);
        this.shadowColor = i2;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.95f;
    }

    public ShadowCircleTransformation(Context context, View view, float f2) {
        view.setLayerType(1, null);
        this.strokeSize = f2;
        this.shadowColor = -1;
        this.spaceBetween = 0.95f;
    }
}
