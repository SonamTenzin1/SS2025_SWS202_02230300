package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: TracesSamplingDecision.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class q5 {
    private final Boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final Double f22683b;

    /* renamed from: c, reason: collision with root package name */
    private final Boolean f22684c;

    /* renamed from: d, reason: collision with root package name */
    private final Double f22685d;

    public q5(Boolean bool) {
        this(bool, null);
    }

    public Boolean a() {
        return this.f22684c;
    }

    public Double b() {
        return this.f22683b;
    }

    public Boolean c() {
        return this.a;
    }

    public q5(Boolean bool, Double d2) {
        this(bool, d2, Boolean.FALSE, null);
    }

    public q5(Boolean bool, Double d2, Boolean bool2, Double d3) {
        this.a = bool;
        this.f22683b = d2;
        this.f22684c = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.f22685d = d3;
    }
}
