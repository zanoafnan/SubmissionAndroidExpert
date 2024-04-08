package g6;

import a.g;
import java.util.List;
import k4.i;
import w4.p;
import x4.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final n6.c f2532a;

    /* renamed from: b  reason: collision with root package name */
    public final b5.b f2533b;

    /* renamed from: c  reason: collision with root package name */
    public final m6.a f2534c;

    /* renamed from: d  reason: collision with root package name */
    public final p f2535d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2536e;

    /* renamed from: f  reason: collision with root package name */
    public final List f2537f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2538g;

    /* renamed from: h  reason: collision with root package name */
    public final c f2539h;

    public a(n6.c cVar, d dVar, p pVar, int i7, b bVar) {
        l4.p pVar2 = l4.p.f3472i;
        c cVar2 = new c();
        v4.a.q(cVar, "scopeDefinition");
        g.s(i7, "kind");
        this.f2532a = cVar;
        this.f2533b = dVar;
        this.f2534c = null;
        this.f2535d = pVar;
        this.f2536e = i7;
        this.f2537f = pVar2;
        this.f2538g = bVar;
        this.f2539h = cVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            a aVar = (a) obj;
            return ((v4.a.f(this.f2533b, aVar.f2533b) ^ true) || (v4.a.f(this.f2534c, aVar.f2534c) ^ true) || (v4.a.f(this.f2532a, aVar.f2532a) ^ true)) ? false : true;
        }
        throw new i("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public final int hashCode() {
        m6.a aVar = this.f2534c;
        int hashCode = aVar != null ? aVar.hashCode() : 0;
        return this.f2532a.hashCode() + ((((d) this.f2533b).hashCode() + (hashCode * 31)) * 31);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0033, code lost:
        if (r3 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r12 = this;
            int r0 = r12.f2536e
            java.lang.String r0 = a.g.u(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "'"
            r1.<init>(r2)
            b5.b r2 = r12.f2533b
            java.lang.String r2 = o6.a.a(r2)
            r1.append(r2)
            r2 = 39
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = ""
            m6.a r3 = r12.f2534c
            if (r3 == 0) goto L36
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = ",qualifier:"
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            if (r3 == 0) goto L36
            goto L37
        L36:
            r3 = r2
        L37:
            n6.c r4 = r12.f2532a
            boolean r5 = r4.f4016b
            if (r5 == 0) goto L3f
            r4 = r2
            goto L4f
        L3f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = ",scope:"
            r5.<init>(r6)
            m6.a r4 = r4.f4015a
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L4f:
            java.util.List r5 = r12.f2537f
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L6d
            java.util.List r6 = r12.f2537f
            java.lang.String r7 = ","
            r8 = 0
            r9 = 0
            a1.a r10 = a1.a.f79s
            r11 = 30
            java.lang.String r2 = l4.n.Q0(r6, r7, r8, r9, r10, r11)
            java.lang.String r5 = ",binds:"
            java.lang.String r2 = r5.concat(r2)
        L6d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "["
            r5.<init>(r6)
            r5.append(r0)
            r0 = 58
            r5.append(r0)
            r5.append(r1)
            r5.append(r3)
            r5.append(r4)
            r5.append(r2)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.toString():java.lang.String");
    }
}