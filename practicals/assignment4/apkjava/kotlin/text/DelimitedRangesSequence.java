package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.sequences.Sequence;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", HttpUrl.FRAGMENT_ENCODE_SET, "startIndex", HttpUrl.FRAGMENT_ENCODE_SET, "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.h0.e, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class DelimitedRangesSequence implements Sequence<IntRange> {
    private final CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    private final int f25062b;

    /* renamed from: c, reason: collision with root package name */
    private final int f25063c;

    /* renamed from: d, reason: collision with root package name */
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> f25064d;

    /* compiled from: Strings.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ranges/IntRange;", "counter", HttpUrl.FRAGMENT_ENCODE_SET, "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.h0.e$a */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<IntRange>, KMappedMarker {

        /* renamed from: f, reason: collision with root package name */
        private int f25065f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f25066g;

        /* renamed from: h, reason: collision with root package name */
        private int f25067h;

        /* renamed from: i, reason: collision with root package name */
        private IntRange f25068i;

        /* renamed from: j, reason: collision with root package name */
        private int f25069j;

        a() {
            int f2;
            f2 = l.f(DelimitedRangesSequence.this.f25062b, 0, DelimitedRangesSequence.this.a.length());
            this.f25066g = f2;
            this.f25067h = f2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f25070k.f25063c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void b() {
            IntRange k2;
            int Q;
            int Q2;
            if (this.f25067h >= 0) {
                if (DelimitedRangesSequence.this.f25063c > 0) {
                    int i2 = this.f25069j + 1;
                    this.f25069j = i2;
                }
                if (this.f25067h <= DelimitedRangesSequence.this.a.length()) {
                    Pair pair = (Pair) DelimitedRangesSequence.this.f25064d.invoke(DelimitedRangesSequence.this.a, Integer.valueOf(this.f25067h));
                    if (pair == null) {
                        int i3 = this.f25066g;
                        Q = v.Q(DelimitedRangesSequence.this.a);
                        this.f25068i = new IntRange(i3, Q);
                        this.f25067h = -1;
                    } else {
                        int intValue = ((Number) pair.a()).intValue();
                        int intValue2 = ((Number) pair.b()).intValue();
                        k2 = l.k(this.f25066g, intValue);
                        this.f25068i = k2;
                        int i4 = intValue + intValue2;
                        this.f25066g = i4;
                        this.f25067h = i4 + (intValue2 == 0 ? 1 : 0);
                    }
                    this.f25065f = 1;
                    return;
                }
                int i5 = this.f25066g;
                Q2 = v.Q(DelimitedRangesSequence.this.a);
                this.f25068i = new IntRange(i5, Q2);
                this.f25067h = -1;
                this.f25065f = 1;
                return;
            }
            this.f25065f = 0;
            this.f25068i = null;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public IntRange next() {
            if (this.f25065f == -1) {
                b();
            }
            if (this.f25065f != 0) {
                IntRange intRange = this.f25068i;
                m.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f25068i = null;
                this.f25065f = -1;
                return intRange;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25065f == -1) {
                b();
            }
            return this.f25065f == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence charSequence, int i2, int i3, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        m.f(charSequence, "input");
        m.f(function2, "getNextMatch");
        this.a = charSequence;
        this.f25062b = i2;
        this.f25063c = i3;
        this.f25064d = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new a();
    }
}
