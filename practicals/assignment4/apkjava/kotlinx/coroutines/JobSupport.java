package kotlinx.coroutines;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.HttpUrl;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bZ\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\bj\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b¢\u0006\u0004\bm\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010-J\u0019\u0010q\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bp\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\br\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\bv\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082\b¢\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00018F¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Õ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", HttpUrl.FRAGMENT_ENCODE_SET, "active", "<init>", "(Z)V", HttpUrl.FRAGMENT_ENCODE_SET, "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "rootCause", HttpUrl.FRAGMENT_ENCODE_SET, "exceptions", HttpUrl.FRAGMENT_ENCODE_SET, "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", HttpUrl.FRAGMENT_ENCODE_SET, "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", HttpUrl.FRAGMENT_ENCODE_SET, "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", HttpUrl.FRAGMENT_ENCODE_SET, "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", RoomNotification.KEY, "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.f2, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25746f = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", HttpUrl.FRAGMENT_ENCODE_SET, "parent", "Lkotlinx/coroutines/Job;", "nameString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.f2$a */
    /* loaded from: classes3.dex */
    public static final class a<T> extends CancellableContinuationImpl<T> {
        private final JobSupport n;

        public a(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.n = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String F() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable v(Job job) {
            Throwable f2;
            Object X = this.n.X();
            return (!(X instanceof c) || (f2 = ((c) X).f()) == null) ? X instanceof CompletedExceptionally ? ((CompletedExceptionally) X).f25646b : job.j() : f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.f2$b */
    /* loaded from: classes3.dex */
    public static final class b extends JobNode {

        /* renamed from: j, reason: collision with root package name */
        private final JobSupport f25747j;

        /* renamed from: k, reason: collision with root package name */
        private final c f25748k;
        private final ChildHandleNode l;
        private final Object m;

        public b(JobSupport jobSupport, c cVar, ChildHandleNode childHandleNode, Object obj) {
            this.f25747j = jobSupport;
            this.f25748k = cVar;
            this.l = childHandleNode;
            this.m = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void E(Throwable th) {
            this.f25747j.N(this.f25748k, this.l, this.m);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            E(th);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", HttpUrl.FRAGMENT_ENCODE_SET, "isCompleting", HttpUrl.FRAGMENT_ENCODE_SET, "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", HttpUrl.FRAGMENT_ENCODE_SET, "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.f2$c */
    /* loaded from: classes3.dex */
    public static final class c implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: f, reason: collision with root package name */
        private final NodeList f25749f;

        public c(NodeList nodeList, boolean z, Throwable th) {
            this.f25749f = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        /* renamed from: d, reason: from getter */
        private final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(Throwable th) {
            Throwable f2 = f();
            if (f2 == null) {
                m(th);
                return;
            }
            if (th == f2) {
                return;
            }
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                l(th);
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> c2 = c();
                c2.add(obj);
                c2.add(th);
                l(c2);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + obj).toString());
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: b */
        public boolean getF25782f() {
            return f() == null;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: e, reason: from getter */
        public NodeList getF25879f() {
            return this.f25749f;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            Symbol symbol;
            Object obj = get_exceptionsHolder();
            symbol = g2.f25775e;
            return obj == symbol;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            Symbol symbol;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayList = c();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> c2 = c();
                c2.add(obj);
                arrayList = c2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable f2 = f();
            if (f2 != null) {
                arrayList.add(0, f2);
            }
            if (th != null && !kotlin.jvm.internal.m.a(th, f2)) {
                arrayList.add(th);
            }
            symbol = g2.f25775e;
            l(symbol);
            return arrayList;
        }

        public final void k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getF25879f() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", HttpUrl.FRAGMENT_ENCODE_SET, "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.f2$d */
    /* loaded from: classes3.dex */
    public static final class d extends LockFreeLinkedListNode.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JobSupport f25750d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f25751e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f25750d = jobSupport;
            this.f25751e = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f25750d.X() == this.f25751e) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? g2.f25777g : g2.f25776f;
        this._parentHandle = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object A0(Incomplete incomplete, Object obj) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        NodeList V = V(incomplete);
        if (V == null) {
            symbol3 = g2.f25773c;
            return symbol3;
        }
        c cVar = incomplete instanceof c ? (c) incomplete : null;
        if (cVar == null) {
            cVar = new c(V, false, null);
        }
        kotlin.jvm.internal.f0 f0Var = new kotlin.jvm.internal.f0();
        synchronized (cVar) {
            if (cVar.h()) {
                symbol2 = g2.a;
                return symbol2;
            }
            cVar.k(true);
            if (cVar != incomplete && !f25746f.compareAndSet(this, incomplete, cVar)) {
                symbol = g2.f25773c;
                return symbol;
            }
            if (s0.a() && !(!cVar.i())) {
                throw new AssertionError();
            }
            boolean g2 = cVar.g();
            CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
            if (completedExceptionally != null) {
                cVar.a(completedExceptionally.f25646b);
            }
            T f2 = Boolean.valueOf(g2 ? false : true).booleanValue() ? cVar.f() : 0;
            f0Var.f22943f = f2;
            kotlin.u uVar = kotlin.u.a;
            Throwable th = (Throwable) f2;
            if (th != null) {
                j0(V, th);
            }
            ChildHandleNode Q = Q(incomplete);
            if (Q != null && B0(cVar, Q, obj)) {
                return g2.f25772b;
            }
            return P(cVar, obj);
        }
    }

    private final boolean B0(c cVar, ChildHandleNode childHandleNode, Object obj) {
        while (Job.a.d(childHandleNode.f25880j, false, false, new b(this, cVar, childHandleNode, obj), 1, null) == NonDisposableHandle.f25852f) {
            childHandleNode = i0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final Object F(Object obj) {
        Symbol symbol;
        Object z0;
        Symbol symbol2;
        do {
            Object X = X();
            if (!(X instanceof Incomplete) || ((X instanceof c) && ((c) X).h())) {
                symbol = g2.a;
                return symbol;
            }
            z0 = z0(X, new CompletedExceptionally(O(obj), false, 2, null));
            symbol2 = g2.f25773c;
        } while (z0 == symbol2);
        return z0;
    }

    private final boolean G(Throwable th) {
        if (c0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle W = W();
        return (W == null || W == NonDisposableHandle.f25852f) ? z : W.u(th) || z;
    }

    private final void M(Incomplete incomplete, Object obj) {
        ChildHandle W = W();
        if (W != null) {
            W.k();
            r0(NonDisposableHandle.f25852f);
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f25646b : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).E(th);
                return;
            } catch (Throwable th2) {
                Z(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList f25879f = incomplete.getF25879f();
        if (f25879f != null) {
            k0(f25879f, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(c cVar, ChildHandleNode childHandleNode, Object obj) {
        if (s0.a()) {
            if (!(X() == cVar)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode i0 = i0(childHandleNode);
        if (i0 == null || !B0(cVar, i0, obj)) {
            v(P(cVar, obj));
        }
    }

    private final Throwable O(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(K(), null, this) : th;
        }
        if (obj != null) {
            return ((ParentJob) obj).D();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object P(c cVar, Object obj) {
        boolean g2;
        Throwable S;
        boolean z = true;
        if (s0.a()) {
            if (!(X() == cVar)) {
                throw new AssertionError();
            }
        }
        if (s0.a() && !(!cVar.i())) {
            throw new AssertionError();
        }
        if (s0.a() && !cVar.h()) {
            throw new AssertionError();
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f25646b : null;
        synchronized (cVar) {
            g2 = cVar.g();
            List<Throwable> j2 = cVar.j(th);
            S = S(cVar, j2);
            if (S != null) {
                u(S, j2);
            }
        }
        if (S != null && S != th) {
            obj = new CompletedExceptionally(S, false, 2, null);
        }
        if (S != null) {
            if (!G(S) && !Y(S)) {
                z = false;
            }
            if (z) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((CompletedExceptionally) obj).b();
            }
        }
        if (!g2) {
            l0(S);
        }
        m0(obj);
        boolean compareAndSet = f25746f.compareAndSet(this, cVar, g2.g(obj));
        if (s0.a() && !compareAndSet) {
            throw new AssertionError();
        }
        M(cVar, obj);
        return obj;
    }

    private final ChildHandleNode Q(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList f25879f = incomplete.getF25879f();
        if (f25879f != null) {
            return i0(f25879f);
        }
        return null;
    }

    private final Throwable R(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f25646b;
        }
        return null;
    }

    private final Throwable S(c cVar, List<? extends Throwable> list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.g()) {
                return new JobCancellationException(K(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final NodeList V(Incomplete incomplete) {
        NodeList f25879f = incomplete.getF25879f();
        if (f25879f != null) {
            return f25879f;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            p0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final Object d0(Object obj) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Throwable th = null;
        while (true) {
            Object X = X();
            if (X instanceof c) {
                synchronized (X) {
                    if (((c) X).i()) {
                        symbol2 = g2.f25774d;
                        return symbol2;
                    }
                    boolean g2 = ((c) X).g();
                    if (obj != null || !g2) {
                        if (th == null) {
                            th = O(obj);
                        }
                        ((c) X).a(th);
                    }
                    Throwable f2 = g2 ^ true ? ((c) X).f() : null;
                    if (f2 != null) {
                        j0(((c) X).getF25879f(), f2);
                    }
                    symbol = g2.a;
                    return symbol;
                }
            }
            if (!(X instanceof Incomplete)) {
                symbol3 = g2.f25774d;
                return symbol3;
            }
            if (th == null) {
                th = O(obj);
            }
            Incomplete incomplete = (Incomplete) X;
            if (incomplete.getF25782f()) {
                if (y0(incomplete, th)) {
                    symbol4 = g2.a;
                    return symbol4;
                }
            } else {
                Object z0 = z0(X, new CompletedExceptionally(th, false, 2, null));
                symbol5 = g2.a;
                if (z0 != symbol5) {
                    symbol6 = g2.f25773c;
                    if (z0 != symbol6) {
                        return z0;
                    }
                } else {
                    throw new IllegalStateException(("Cannot happen in " + X).toString());
                }
            }
        }
    }

    private final JobNode g0(Function1<? super Throwable, kotlin.u> function1, boolean z) {
        JobNode jobNode;
        if (z) {
            jobNode = function1 instanceof JobCancellingNode ? (JobCancellingNode) function1 : null;
            if (jobNode == null) {
                jobNode = new InvokeOnCancelling(function1);
            }
        } else {
            jobNode = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (jobNode != null) {
                if (s0.a() && !(!(jobNode instanceof JobCancellingNode))) {
                    throw new AssertionError();
                }
            } else {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.G(this);
        return jobNode;
    }

    private final ChildHandleNode i0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.y()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.v();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.r();
            if (!lockFreeLinkedListNode.y()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void j0(NodeList nodeList, Throwable th) {
        l0(th);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.r()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.E(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        kotlin.u uVar = kotlin.u.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Z(completionHandlerException);
        }
        G(th);
    }

    private final void k0(NodeList nodeList, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.r()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.E(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        kotlin.u uVar = kotlin.u.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Z(completionHandlerException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.s1] */
    private final void o0(Empty empty) {
        NodeList nodeList = new NodeList();
        if (!empty.getF25782f()) {
            nodeList = new InactiveNodeList(nodeList);
        }
        f25746f.compareAndSet(this, empty, nodeList);
    }

    private final void p0(JobNode jobNode) {
        jobNode.m(new NodeList());
        f25746f.compareAndSet(this, jobNode, jobNode.r());
    }

    private final int s0(Object obj) {
        Empty empty;
        if (obj instanceof Empty) {
            if (((Empty) obj).getF25782f()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25746f;
            empty = g2.f25777g;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                return -1;
            }
            n0();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        if (!f25746f.compareAndSet(this, obj, ((InactiveNodeList) obj).getF25879f())) {
            return -1;
        }
        n0();
        return 1;
    }

    private final boolean t(Object obj, NodeList nodeList, JobNode jobNode) {
        int D;
        d dVar = new d(jobNode, this, obj);
        do {
            D = nodeList.v().D(jobNode, nodeList, dVar);
            if (D == 1) {
                return true;
            }
        } while (D != 2);
        return false;
    }

    private final String t0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).getF25782f() ? "Active" : "New" : obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.g() ? "Cancelling" : cVar.h() ? "Completing" : "Active";
    }

    private final void u(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable l = !s0.d() ? th : kotlinx.coroutines.internal.d0.l(th);
        for (Throwable th2 : list) {
            if (s0.d()) {
                th2 = kotlinx.coroutines.internal.d0.l(th2);
            }
            if (th2 != th && th2 != l && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.b.a(th, th2);
            }
        }
    }

    public static /* synthetic */ CancellationException v0(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return jobSupport.u0(th, str);
    }

    private final Object x(Continuation<Object> continuation) {
        a aVar = new a(kotlin.coroutines.intrinsics.b.b(continuation), this);
        aVar.z();
        q.a(aVar, m(new ResumeAwaitOnCompletion(aVar)));
        Object w = aVar.w();
        if (w == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.j.internal.h.c(continuation);
        }
        return w;
    }

    private final boolean x0(Incomplete incomplete, Object obj) {
        if (s0.a()) {
            if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (s0.a() && !(!(obj instanceof CompletedExceptionally))) {
            throw new AssertionError();
        }
        if (!f25746f.compareAndSet(this, incomplete, g2.g(obj))) {
            return false;
        }
        l0(null);
        m0(obj);
        M(incomplete, obj);
        return true;
    }

    private final boolean y0(Incomplete incomplete, Throwable th) {
        if (s0.a() && !(!(incomplete instanceof c))) {
            throw new AssertionError();
        }
        if (s0.a() && !incomplete.getF25782f()) {
            throw new AssertionError();
        }
        NodeList V = V(incomplete);
        if (V == null) {
            return false;
        }
        if (!f25746f.compareAndSet(this, incomplete, new c(V, false, th))) {
            return false;
        }
        j0(V, th);
        return true;
    }

    private final Object z0(Object obj, Object obj2) {
        Symbol symbol;
        Symbol symbol2;
        if (!(obj instanceof Incomplete)) {
            symbol2 = g2.a;
            return symbol2;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            if (x0((Incomplete) obj, obj2)) {
                return obj2;
            }
            symbol = g2.f25773c;
            return symbol;
        }
        return A0((Incomplete) obj, obj2);
    }

    public final boolean C(Object obj) {
        Object obj2;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        obj2 = g2.a;
        if (U() && (obj2 = F(obj)) == g2.f25772b) {
            return true;
        }
        symbol = g2.a;
        if (obj2 == symbol) {
            obj2 = d0(obj);
        }
        symbol2 = g2.a;
        if (obj2 == symbol2 || obj2 == g2.f25772b) {
            return true;
        }
        symbol3 = g2.f25774d;
        if (obj2 == symbol3) {
            return false;
        }
        v(obj2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    public CancellationException D() {
        CancellationException cancellationException;
        Object X = X();
        if (X instanceof c) {
            cancellationException = ((c) X).f();
        } else if (X instanceof CompletedExceptionally) {
            cancellationException = ((CompletedExceptionally) X).f25646b;
        } else {
            if (X instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + X).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + t0(X), cancellationException, this);
    }

    public void E(Throwable th) {
        C(th);
    }

    @Override // kotlinx.coroutines.Job
    public void H(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(K(), null, this);
        }
        E(cancellationException);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle J(ChildJob childJob) {
        return (ChildHandle) Job.a.d(this, true, false, new ChildHandleNode(childJob), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String K() {
        return "Job was cancelled";
    }

    public boolean L(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return C(th) && getF25637g();
    }

    /* renamed from: T */
    public boolean getF25637g() {
        return true;
    }

    public boolean U() {
        return false;
    }

    public final ChildHandle W() {
        return (ChildHandle) this._parentHandle;
    }

    public final Object X() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    protected boolean Y(Throwable th) {
        return false;
    }

    public void Z(Throwable th) {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a0(Job job) {
        if (s0.a()) {
            if (!(W() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            r0(NonDisposableHandle.f25852f);
            return;
        }
        job.start();
        ChildHandle J = job.J(this);
        r0(J);
        if (b0()) {
            J.k();
            r0(NonDisposableHandle.f25852f);
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean b() {
        Object X = X();
        return (X instanceof Incomplete) && ((Incomplete) X).getF25782f();
    }

    public final boolean b0() {
        return !(X() instanceof Incomplete);
    }

    protected boolean c0() {
        return false;
    }

    public final boolean e0(Object obj) {
        Object z0;
        Symbol symbol;
        Symbol symbol2;
        do {
            z0 = z0(X(), obj);
            symbol = g2.a;
            if (z0 == symbol) {
                return false;
            }
            if (z0 == g2.f25772b) {
                return true;
            }
            symbol2 = g2.f25773c;
        } while (z0 == symbol2);
        v(z0);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle f(boolean z, boolean z2, Function1<? super Throwable, kotlin.u> function1) {
        JobNode g0 = g0(function1, z);
        while (true) {
            Object X = X();
            if (X instanceof Empty) {
                Empty empty = (Empty) X;
                if (empty.getF25782f()) {
                    if (f25746f.compareAndSet(this, X, g0)) {
                        return g0;
                    }
                } else {
                    o0(empty);
                }
            } else {
                if (X instanceof Incomplete) {
                    NodeList f25879f = ((Incomplete) X).getF25879f();
                    if (f25879f != null) {
                        DisposableHandle disposableHandle = NonDisposableHandle.f25852f;
                        if (z && (X instanceof c)) {
                            synchronized (X) {
                                r3 = ((c) X).f();
                                if (r3 == null || ((function1 instanceof ChildHandleNode) && !((c) X).h())) {
                                    if (t(X, f25879f, g0)) {
                                        if (r3 == null) {
                                            return g0;
                                        }
                                        disposableHandle = g0;
                                    }
                                }
                                kotlin.u uVar = kotlin.u.a;
                            }
                        }
                        if (r3 != null) {
                            if (z2) {
                                function1.invoke(r3);
                            }
                            return disposableHandle;
                        }
                        if (t(X, f25879f, g0)) {
                            return g0;
                        }
                    } else {
                        if (X == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        }
                        p0((JobNode) X);
                    }
                } else {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = X instanceof CompletedExceptionally ? (CompletedExceptionally) X : null;
                        function1.invoke(completedExceptionally != null ? completedExceptionally.f25646b : null);
                    }
                    return NonDisposableHandle.f25852f;
                }
            }
        }
    }

    public final Object f0(Object obj) {
        Object z0;
        Symbol symbol;
        Symbol symbol2;
        do {
            z0 = z0(X(), obj);
            symbol = g2.a;
            if (z0 != symbol) {
                symbol2 = g2.f25773c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, R(obj));
            }
        } while (z0 == symbol2);
        return z0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        return (R) Job.a.b(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.b, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.b> E get(CoroutineContext.c<E> cVar) {
        return (E) Job.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.b
    public final CoroutineContext.c<?> getKey() {
        return Job.f25890e;
    }

    public String h0() {
        return t0.a(this);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object X = X();
        return (X instanceof CompletedExceptionally) || ((X instanceof c) && ((c) X).g());
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException j() {
        Object X = X();
        if (X instanceof c) {
            Throwable f2 = ((c) X).f();
            if (f2 != null) {
                CancellationException u0 = u0(f2, t0.a(this) + " is cancelling");
                if (u0 != null) {
                    return u0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(X instanceof Incomplete)) {
            if (X instanceof CompletedExceptionally) {
                return v0(this, ((CompletedExceptionally) X).f25646b, null, 1, null);
            }
            return new JobCancellationException(t0.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void l(ParentJob parentJob) {
        C(parentJob);
    }

    protected void l0(Throwable th) {
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle m(Function1<? super Throwable, kotlin.u> function1) {
        return f(false, true, function1);
    }

    protected void m0(Object obj) {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.c<?> cVar) {
        return Job.a.e(this, cVar);
    }

    protected void n0() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.a.f(this, coroutineContext);
    }

    public final void q0(JobNode jobNode) {
        Object X;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Empty empty;
        do {
            X = X();
            if (!(X instanceof JobNode)) {
                if (!(X instanceof Incomplete) || ((Incomplete) X).getF25879f() == null) {
                    return;
                }
                jobNode.z();
                return;
            }
            if (X != jobNode) {
                return;
            }
            atomicReferenceFieldUpdater = f25746f;
            empty = g2.f25777g;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, X, empty));
    }

    public final void r0(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int s0;
        do {
            s0 = s0(X());
            if (s0 == 0) {
                return false;
            }
        } while (s0 != 1);
        return true;
    }

    public String toString() {
        return w0() + '@' + t0.b(this);
    }

    protected final CancellationException u0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = K();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(Object obj) {
    }

    public final Object w(Continuation<Object> continuation) {
        Object X;
        do {
            X = X();
            if (!(X instanceof Incomplete)) {
                if (X instanceof CompletedExceptionally) {
                    Throwable th = ((CompletedExceptionally) X).f25646b;
                    if (s0.d()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            throw kotlinx.coroutines.internal.d0.a(th, (CoroutineStackFrame) continuation);
                        }
                        throw th;
                    }
                    throw th;
                }
                return g2.h(X);
            }
        } while (s0(X) < 0);
        return x(continuation);
    }

    public final String w0() {
        return h0() + '{' + t0(X()) + '}';
    }

    public final boolean y(Throwable th) {
        return C(th);
    }
}
