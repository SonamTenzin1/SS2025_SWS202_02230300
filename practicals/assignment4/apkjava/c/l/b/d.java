package c.l.b;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.jvm.internal.m;

/* compiled from: PreferencesMapCompat.kt */
/* loaded from: classes.dex */
public final class d {
    public static final a a = new a(null);

    /* compiled from: PreferencesMapCompat.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a(InputStream inputStream) {
            m.f(inputStream, "input");
            try {
                f Q = f.Q(inputStream);
                m.e(Q, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return Q;
            } catch (InvalidProtocolBufferException e2) {
                throw new CorruptionException("Unable to parse preferences proto.", e2);
            }
        }
    }
}
