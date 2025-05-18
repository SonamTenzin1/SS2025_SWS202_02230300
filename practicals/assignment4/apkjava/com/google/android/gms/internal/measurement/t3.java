package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class t3<FieldDescriptorType> extends u3<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.measurement.u3
    public final void e() {
        if (!j()) {
            for (int i2 = 0; i2 < k(); i2++) {
                Map.Entry<FieldDescriptorType, Object> i3 = i(i2);
                if (((zzey) i3.getKey()).d()) {
                    i3.setValue(Collections.unmodifiableList((List) i3.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                if (((zzey) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }
}
