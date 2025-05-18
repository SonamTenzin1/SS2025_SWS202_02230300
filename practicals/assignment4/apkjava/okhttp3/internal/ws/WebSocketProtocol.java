package okhttp3.internal.ws;

import cm.aptoide.pt.database.room.RoomNotification;
import j.f;
import j.i;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* compiled from: WebSocketProtocol.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0016\u0010 \u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0016\u0010\"\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0016\u0010#\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010$\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010\u0016R\u0016\u0010%\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010\u0016R\u0016\u0010&\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u0016R\u0016\u0010(\u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010\u0014R\u0016\u0010)\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010\u0016R\u0016\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010\u0016R\u0016\u0010+\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010\u0016¨\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", HttpUrl.FRAGMENT_ENCODE_SET, "Lj/f$a;", "cursor", HttpUrl.FRAGMENT_ENCODE_SET, RoomNotification.KEY, "Lkotlin/u;", "toggleMask", "(Lj/f$a;[B)V", HttpUrl.FRAGMENT_ENCODE_SET, "code", HttpUrl.FRAGMENT_ENCODE_SET, "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "PAYLOAD_BYTE_MAX", "J", "CLOSE_CLIENT_GOING_AWAY", "I", "OPCODE_CONTINUATION", "ACCEPT_MAGIC", "Ljava/lang/String;", "OPCODE_TEXT", "CLOSE_MESSAGE_MAX", "OPCODE_FLAG_CONTROL", "PAYLOAD_SHORT", "B0_FLAG_RSV1", "B1_FLAG_MASK", "B1_MASK_LENGTH", "PAYLOAD_LONG", "OPCODE_CONTROL_PONG", "B0_FLAG_RSV2", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "OPCODE_BINARY", "CLOSE_NO_STATUS_CODE", "PAYLOAD_SHORT_MAX", "OPCODE_CONTROL_PING", "B0_FLAG_FIN", "OPCODE_CONTROL_CLOSE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        m.f(key, RoomNotification.KEY);
        return i.f22842g.d(key + ACCEPT_MAGIC).N().g();
    }

    public final String closeCodeExceptionMessage(int code) {
        if (code < 1000 || code >= 5000) {
            return "Code must be in range [1000,5000): " + code;
        }
        if ((1004 > code || 1006 < code) && (1015 > code || 2999 < code)) {
            return null;
        }
        return "Code " + code + " is reserved and may not be used.";
    }

    public final void toggleMask(f.a cursor, byte[] key) {
        m.f(cursor, "cursor");
        m.f(key, RoomNotification.KEY);
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.f22837j;
            int i3 = cursor.f22838k;
            int i4 = cursor.l;
            if (bArr != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr[i3] = (byte) (bArr[i3] ^ key[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
        } while (cursor.b() != -1);
    }

    public final void validateCloseCode(int code) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(code);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        m.c(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
