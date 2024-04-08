package f0;

import n.e;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: l  reason: collision with root package name */
    public final Object f2256l;

    public d(int i7) {
        super(i7, 1);
        this.f2256l = new Object();
    }

    @Override // n.e, f0.c
    public final boolean c(Object obj) {
        boolean c7;
        synchronized (this.f2256l) {
            c7 = super.c(obj);
        }
        return c7;
    }

    @Override // n.e, f0.c
    public final Object e() {
        Object e2;
        synchronized (this.f2256l) {
            e2 = super.e();
        }
        return e2;
    }
}