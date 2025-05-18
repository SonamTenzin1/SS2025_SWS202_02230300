package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes2.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12123f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Parcel f12124g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12125h = 2;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final zak f12126i;

    /* renamed from: j, reason: collision with root package name */
    private final String f12127j;

    /* renamed from: k, reason: collision with root package name */
    private int f12128k;
    private int l;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zak zakVar) {
        this.f12123f = i2;
        this.f12124g = (Parcel) Preconditions.k(parcel);
        this.f12126i = zakVar;
        if (zakVar == null) {
            this.f12127j = null;
        } else {
            this.f12127j = zakVar.z();
        }
        this.f12128k = 2;
    }

    private static void h(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void i(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().p0(), entry);
        }
        sb.append('{');
        int L = SafeParcelReader.L(parcel);
        boolean z = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.v(C));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.a1()) {
                    switch (field.f12110i) {
                        case 0:
                            j(sb, field, FastJsonResponse.g(field, Integer.valueOf(SafeParcelReader.E(parcel, C))));
                            break;
                        case 1:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.c(parcel, C)));
                            break;
                        case 2:
                            j(sb, field, FastJsonResponse.g(field, Long.valueOf(SafeParcelReader.G(parcel, C))));
                            break;
                        case 3:
                            j(sb, field, FastJsonResponse.g(field, Float.valueOf(SafeParcelReader.A(parcel, C))));
                            break;
                        case 4:
                            j(sb, field, FastJsonResponse.g(field, Double.valueOf(SafeParcelReader.y(parcel, C))));
                            break;
                        case 5:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.a(parcel, C)));
                            break;
                        case 6:
                            j(sb, field, FastJsonResponse.g(field, Boolean.valueOf(SafeParcelReader.w(parcel, C))));
                            break;
                        case 7:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.p(parcel, C)));
                            break;
                        case 8:
                        case 9:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.g(parcel, C)));
                            break;
                        case 10:
                            Bundle f2 = SafeParcelReader.f(parcel, C);
                            HashMap hashMap = new HashMap();
                            for (String str2 : f2.keySet()) {
                                hashMap.put(str2, f2.getString(str2));
                            }
                            j(sb, field, FastJsonResponse.g(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i2 = field.f12110i;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i2);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f12111j) {
                    sb.append("[");
                    switch (field.f12110i) {
                        case 0:
                            ArrayUtils.e(sb, SafeParcelReader.j(parcel, C));
                            break;
                        case 1:
                            ArrayUtils.g(sb, SafeParcelReader.d(parcel, C));
                            break;
                        case 2:
                            ArrayUtils.f(sb, SafeParcelReader.l(parcel, C));
                            break;
                        case 3:
                            ArrayUtils.d(sb, SafeParcelReader.i(parcel, C));
                            break;
                        case 4:
                            ArrayUtils.c(sb, SafeParcelReader.h(parcel, C));
                            break;
                        case 5:
                            ArrayUtils.g(sb, SafeParcelReader.b(parcel, C));
                            break;
                        case 6:
                            ArrayUtils.h(sb, SafeParcelReader.e(parcel, C));
                            break;
                        case 7:
                            ArrayUtils.i(sb, SafeParcelReader.q(parcel, C));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] n = SafeParcelReader.n(parcel, C);
                            int length = n.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (i3 > 0) {
                                    sb.append(",");
                                }
                                n[i3].setDataPosition(0);
                                i(sb, field.r1(), n[i3]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f12110i) {
                        case 0:
                            sb.append(SafeParcelReader.E(parcel, C));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, C));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.G(parcel, C));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.A(parcel, C));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.y(parcel, C));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, C));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.w(parcel, C));
                            break;
                        case 7:
                            String p = SafeParcelReader.p(parcel, C);
                            sb.append("\"");
                            sb.append(JsonUtils.a(p));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] g2 = SafeParcelReader.g(parcel, C);
                            sb.append("\"");
                            sb.append(Base64Utils.a(g2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] g3 = SafeParcelReader.g(parcel, C);
                            sb.append("\"");
                            sb.append(Base64Utils.b(g3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle f3 = SafeParcelReader.f(parcel, C);
                            Set<String> keySet = f3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(JsonUtils.a(f3.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel m = SafeParcelReader.m(parcel, C);
                            m.setDataPosition(0);
                            i(sb, field.r1(), m);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == L) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(L);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void j(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f12109h) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                h(sb, field.f12108g, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        h(sb, field.f12108g, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r0 != 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Parcel k() {
        int i2 = this.f12128k;
        if (i2 == 0) {
            this.l = SafeParcelWriter.a(this.f12124g);
        }
        SafeParcelWriter.b(this.f12124g, this.l);
        this.f12128k = 2;
        return this.f12124g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zak zakVar = this.f12126i;
        if (zakVar == null) {
            return null;
        }
        return zakVar.W(this.f12127j);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean e(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        Preconditions.l(this.f12126i, "Cannot convert to JSON on client side.");
        Parcel k2 = k();
        k2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        i(sb, this.f12126i.W(this.f12127j), k2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zak zakVar;
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12123f);
        SafeParcelWriter.r(parcel, 2, k(), false);
        int i3 = this.f12125h;
        if (i3 == 0) {
            zakVar = null;
        } else if (i3 == 1) {
            zakVar = this.f12126i;
        } else if (i3 == 2) {
            zakVar = this.f12126i;
        } else {
            int i4 = this.f12125h;
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
        SafeParcelWriter.s(parcel, 3, zakVar, i2, false);
        SafeParcelWriter.b(parcel, a);
    }
}
