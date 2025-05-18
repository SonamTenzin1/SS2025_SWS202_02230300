package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.collections.n;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.s;
import kotlin.sequences.Sequence;
import okhttp3.HttpUrl;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\bø\u0001\u0000¢\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", HttpUrl.FRAGMENT_ENCODE_SET, "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", HttpUrl.FRAGMENT_ENCODE_SET, "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", HttpUrl.FRAGMENT_ENCODE_SET, "limit", "commonPrefixWith", HttpUrl.FRAGMENT_ENCODE_SET, "other", "ignoreCase", HttpUrl.FRAGMENT_ENCODE_SET, "commonSuffixWith", "contains", "char", HttpUrl.FRAGMENT_ENCODE_SET, "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", HttpUrl.FRAGMENT_ENCODE_SET, "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", HttpUrl.FRAGMENT_ENCODE_SET, "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", HttpUrl.FRAGMENT_ENCODE_SET, "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", HttpUrl.FRAGMENT_ENCODE_SET, "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public class v extends u {

    /* compiled from: Strings.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: f */
        final /* synthetic */ char[] f25085f;

        /* renamed from: g */
        final /* synthetic */ boolean f25086g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z) {
            super(2);
            this.f25085f = cArr;
            this.f25086g = z;
        }

        public final Pair<Integer, Integer> b(CharSequence charSequence, int i2) {
            m.f(charSequence, "$this$$receiver");
            int X = v.X(charSequence, this.f25085f, i2, this.f25086g);
            if (X < 0) {
                return null;
            }
            return s.a(Integer.valueOf(X), 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return b(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: f */
        final /* synthetic */ List<String> f25087f;

        /* renamed from: g */
        final /* synthetic */ boolean f25088g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z) {
            super(2);
            this.f25087f = list;
            this.f25088g = z;
        }

        public final Pair<Integer, Integer> b(CharSequence charSequence, int i2) {
            m.f(charSequence, "$this$$receiver");
            Pair O = v.O(charSequence, this.f25087f, i2, this.f25088g, false);
            if (O != null) {
                return s.a(O.c(), Integer.valueOf(((String) O.d()).length()));
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return b(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<IntRange, String> {

        /* renamed from: f */
        final /* synthetic */ CharSequence f25089f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f25089f = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(IntRange intRange) {
            m.f(intRange, "it");
            return v.C0(this.f25089f, intRange);
        }
    }

    public static /* synthetic */ boolean A0(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return y0(charSequence, c2, z);
    }

    public static /* synthetic */ boolean B0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return z0(charSequence, charSequence2, z);
    }

    public static final String C0(CharSequence charSequence, IntRange intRange) {
        m.f(charSequence, "<this>");
        m.f(intRange, "range");
        return charSequence.subSequence(intRange.r().intValue(), intRange.q().intValue() + 1).toString();
    }

    public static final String D0(String str, char c2, String str2) {
        int V;
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        V = V(str, c2, 0, false, 6, null);
        if (V == -1) {
            return str2;
        }
        String substring = str.substring(V + 1, str.length());
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String E0(String str, String str2, String str3) {
        int W;
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        W = W(str, str2, 0, false, 6, null);
        if (W == -1) {
            return str3;
        }
        String substring = str.substring(W + str2.length(), str.length());
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String F0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return D0(str, c2, str2);
    }

    public static final boolean G(CharSequence charSequence, char c2, boolean z) {
        int V;
        m.f(charSequence, "<this>");
        V = V(charSequence, c2, 0, z, 2, null);
        return V >= 0;
    }

    public static /* synthetic */ String G0(String str, String str2, String str3, int i2, Object obj) {
        String E0;
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        E0 = E0(str, str2, str3);
        return E0;
    }

    public static final boolean H(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        int W;
        m.f(charSequence, "<this>");
        m.f(charSequence2, "other");
        if (charSequence2 instanceof String) {
            W = W(charSequence, (String) charSequence2, 0, z, 2, null);
            if (W >= 0) {
                return true;
            }
        } else if (U(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static String H0(String str, char c2, String str2) {
        int a0;
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        a0 = a0(str, c2, 0, false, 6, null);
        if (a0 == -1) {
            return str2;
        }
        String substring = str.substring(a0 + 1, str.length());
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return G(charSequence, c2, z);
    }

    public static /* synthetic */ String I0(String str, char c2, String str2, int i2, Object obj) {
        String H0;
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        H0 = H0(str, c2, str2);
        return H0;
    }

    public static /* synthetic */ boolean J(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return H(charSequence, charSequence2, z);
    }

    public static final String J0(String str, char c2, String str2) {
        int V;
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        V = V(str, c2, 0, false, 6, null);
        if (V == -1) {
            return str2;
        }
        String substring = str.substring(0, V);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean K(CharSequence charSequence, char c2, boolean z) {
        int Q;
        m.f(charSequence, "<this>");
        if (charSequence.length() > 0) {
            Q = Q(charSequence);
            if (kotlin.text.c.e(charSequence.charAt(Q), c2, z)) {
                return true;
            }
        }
        return false;
    }

    public static final String K0(String str, String str2, String str3) {
        int W;
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        W = W(str, str2, 0, false, 6, null);
        if (W == -1) {
            return str3;
        }
        String substring = str.substring(0, W);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean L(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        boolean p;
        m.f(charSequence, "<this>");
        m.f(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            p = u.p((String) charSequence, (String) charSequence2, false, 2, null);
            return p;
        }
        return l0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ String L0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return J0(str, c2, str2);
    }

    public static /* synthetic */ boolean M(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return K(charSequence, c2, z);
    }

    public static /* synthetic */ String M0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return K0(str, str2, str3);
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return L(charSequence, charSequence2, z);
    }

    public static String N0(String str, String str2, String str3) {
        int b0;
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        b0 = b0(str, str2, 0, false, 6, null);
        if (b0 == -1) {
            return str3;
        }
        String substring = str.substring(0, b0);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final Pair<Integer, String> O(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int Q;
        int d2;
        IntProgression h2;
        Object obj;
        Object obj2;
        int b2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.s.r0(collection);
            int W = !z2 ? W(charSequence, str, i2, false, 4, null) : b0(charSequence, str, i2, false, 4, null);
            if (W < 0) {
                return null;
            }
            return s.a(Integer.valueOf(W), str);
        }
        if (z2) {
            Q = Q(charSequence);
            d2 = l.d(i2, Q);
            h2 = l.h(d2, 0);
        } else {
            b2 = l.b(i2, 0);
            h2 = new IntRange(b2, charSequence.length());
        }
        if (charSequence instanceof String) {
            int f22972g = h2.getF22972g();
            int f22973h = h2.getF22973h();
            int f22974i = h2.getF22974i();
            if ((f22974i > 0 && f22972g <= f22973h) || (f22974i < 0 && f22973h <= f22972g)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (u.u(str2, 0, (String) charSequence, f22972g, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (f22972g == f22973h) {
                            break;
                        }
                        f22972g += f22974i;
                    } else {
                        return s.a(Integer.valueOf(f22972g), str3);
                    }
                }
            }
        } else {
            int f22972g2 = h2.getF22972g();
            int f22973h2 = h2.getF22973h();
            int f22974i2 = h2.getF22974i();
            if ((f22974i2 > 0 && f22972g2 <= f22973h2) || (f22974i2 < 0 && f22973h2 <= f22972g2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (l0(str4, 0, charSequence, f22972g2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (f22972g2 == f22973h2) {
                            break;
                        }
                        f22972g2 += f22974i2;
                    } else {
                        return s.a(Integer.valueOf(f22972g2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static CharSequence O0(CharSequence charSequence) {
        boolean c2;
        m.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            c2 = kotlin.text.b.c(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!c2) {
                    break;
                }
                length--;
            } else if (c2) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static IntRange P(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int Q(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R(CharSequence charSequence, char c2, int i2, boolean z) {
        m.f(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return X(charSequence, new char[]{c2}, i2, z);
    }

    public static final int S(CharSequence charSequence, String str, int i2, boolean z) {
        m.f(charSequence, "<this>");
        m.f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return U(charSequence, str, i2, charSequence.length(), z, false, 16, null);
    }

    private static final int T(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        int Q;
        int d2;
        int b2;
        IntProgression h2;
        int b3;
        int d3;
        if (!z2) {
            b3 = l.b(i2, 0);
            d3 = l.d(i3, charSequence.length());
            h2 = new IntRange(b3, d3);
        } else {
            Q = Q(charSequence);
            d2 = l.d(i2, Q);
            b2 = l.b(i3, 0);
            h2 = l.h(d2, b2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int f22972g = h2.getF22972g();
            int f22973h = h2.getF22973h();
            int f22974i = h2.getF22974i();
            if ((f22974i <= 0 || f22972g > f22973h) && (f22974i >= 0 || f22973h > f22972g)) {
                return -1;
            }
            while (!u.u((String) charSequence2, 0, (String) charSequence, f22972g, charSequence2.length(), z)) {
                if (f22972g == f22973h) {
                    return -1;
                }
                f22972g += f22974i;
            }
            return f22972g;
        }
        int f22972g2 = h2.getF22972g();
        int f22973h2 = h2.getF22973h();
        int f22974i2 = h2.getF22974i();
        if ((f22974i2 <= 0 || f22972g2 > f22973h2) && (f22974i2 >= 0 || f22973h2 > f22972g2)) {
            return -1;
        }
        while (!l0(charSequence2, 0, charSequence, f22972g2, charSequence2.length(), z)) {
            if (f22972g2 == f22973h2) {
                return -1;
            }
            f22972g2 += f22974i2;
        }
        return f22972g2;
    }

    static /* synthetic */ int U(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return T(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int V(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return R(charSequence, c2, i2, z);
    }

    public static /* synthetic */ int W(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return S(charSequence, str, i2, z);
    }

    public static final int X(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        int b2;
        int Q;
        boolean z2;
        char M;
        m.f(charSequence, "<this>");
        m.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            M = n.M(cArr);
            return ((String) charSequence).indexOf(M, i2);
        }
        b2 = l.b(i2, 0);
        Q = Q(charSequence);
        IntIterator it = new IntRange(b2, Q).iterator();
        while (it.hasNext()) {
            int b3 = it.b();
            char charAt = charSequence.charAt(b3);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (kotlin.text.c.e(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return b3;
            }
        }
        return -1;
    }

    public static final int Y(CharSequence charSequence, char c2, int i2, boolean z) {
        m.f(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return c0(charSequence, new char[]{c2}, i2, z);
    }

    public static final int Z(CharSequence charSequence, String str, int i2, boolean z) {
        m.f(charSequence, "<this>");
        m.f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return T(charSequence, str, i2, 0, z, true);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Q(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Y(charSequence, c2, i2, z);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Q(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Z(charSequence, str, i2, z);
    }

    public static final int c0(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        int Q;
        int d2;
        char M;
        m.f(charSequence, "<this>");
        m.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            M = n.M(cArr);
            return ((String) charSequence).lastIndexOf(M, i2);
        }
        Q = Q(charSequence);
        for (d2 = l.d(i2, Q); -1 < d2; d2--) {
            char charAt = charSequence.charAt(d2);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (kotlin.text.c.e(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return d2;
            }
        }
        return -1;
    }

    public static final Sequence<String> d0(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return x0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> e0(CharSequence charSequence) {
        List<String> A;
        m.f(charSequence, "<this>");
        A = kotlin.sequences.n.A(d0(charSequence));
        return A;
    }

    public static final CharSequence f0(CharSequence charSequence, int i2, char c2) {
        m.f(charSequence, "<this>");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            IntIterator it = new IntRange(1, i2 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.b();
                sb.append(c2);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static String g0(String str, int i2, char c2) {
        m.f(str, "<this>");
        return f0(str, i2, c2).toString();
    }

    private static final Sequence<IntRange> h0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        q0(i3);
        return new DelimitedRangesSequence(charSequence, i2, i3, new a(cArr, z));
    }

    private static final Sequence<IntRange> i0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        List c2;
        q0(i3);
        c2 = kotlin.collections.m.c(strArr);
        return new DelimitedRangesSequence(charSequence, i2, i3, new b(c2, z));
    }

    static /* synthetic */ Sequence j0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return h0(charSequence, cArr, i2, z, i3);
    }

    static /* synthetic */ Sequence k0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return i0(charSequence, strArr, i2, z, i3);
    }

    public static final boolean l0(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!kotlin.text.c.e(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static String m0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "prefix");
        if (!B0(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        m.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String n0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "suffix");
        if (!N(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String o0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "delimiter");
        return p0(str, charSequence, charSequence);
    }

    public static final String p0(String str, CharSequence charSequence, CharSequence charSequence2) {
        m.f(str, "<this>");
        m.f(charSequence, "prefix");
        m.f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !B0(str, charSequence, false, 2, null) || !N(str, charSequence2, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void q0(int i2) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
    }

    public static final List<String> r0(CharSequence charSequence, char[] cArr, boolean z, int i2) {
        Iterable i3;
        int u;
        m.f(charSequence, "<this>");
        m.f(cArr, "delimiters");
        if (cArr.length == 1) {
            return t0(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        i3 = kotlin.sequences.n.i(j0(charSequence, cArr, 0, z, i2, 2, null));
        u = kotlin.collections.v.u(i3, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator it = i3.iterator();
        while (it.hasNext()) {
            arrayList.add(C0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List<String> s0(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        Iterable i3;
        int u;
        m.f(charSequence, "<this>");
        m.f(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return t0(charSequence, str, z, i2);
            }
        }
        i3 = kotlin.sequences.n.i(k0(charSequence, strArr, 0, z, i2, 2, null));
        u = kotlin.collections.v.u(i3, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator it = i3.iterator();
        while (it.hasNext()) {
            arrayList.add(C0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> t0(CharSequence charSequence, String str, boolean z, int i2) {
        List<String> e2;
        q0(i2);
        int i3 = 0;
        int S = S(charSequence, str, 0, z);
        if (S != -1 && i2 != 1) {
            boolean z2 = i2 > 0;
            ArrayList arrayList = new ArrayList(z2 ? l.d(i2, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i3, S).toString());
                i3 = str.length() + S;
                if (z2 && arrayList.size() == i2 - 1) {
                    break;
                }
                S = S(charSequence, str, i3, z);
            } while (S != -1);
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        e2 = t.e(charSequence.toString());
        return e2;
    }

    public static /* synthetic */ List u0(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return r0(charSequence, cArr, z, i2);
    }

    public static /* synthetic */ List v0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return s0(charSequence, strArr, z, i2);
    }

    public static final Sequence<String> w0(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        Sequence<String> u;
        m.f(charSequence, "<this>");
        m.f(strArr, "delimiters");
        u = kotlin.sequences.n.u(k0(charSequence, strArr, 0, z, i2, 2, null), new c(charSequence));
        return u;
    }

    public static /* synthetic */ Sequence x0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return w0(charSequence, strArr, z, i2);
    }

    public static final boolean y0(CharSequence charSequence, char c2, boolean z) {
        m.f(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.c.e(charSequence.charAt(0), c2, z);
    }

    public static final boolean z0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        boolean E;
        m.f(charSequence, "<this>");
        m.f(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            E = u.E((String) charSequence, (String) charSequence2, false, 2, null);
            return E;
        }
        return l0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }
}
