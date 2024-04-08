package d5;

import java.util.Iterator;
import w4.p;

/* loaded from: classes.dex */
public final class c implements c5.c {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f1971a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1972b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1973c;

    /* renamed from: d  reason: collision with root package name */
    public final p f1974d;

    public c(CharSequence charSequence, int i7, int i8, h hVar) {
        v4.a.n(charSequence, "input");
        this.f1971a = charSequence;
        this.f1972b = i7;
        this.f1973c = i8;
        this.f1974d = hVar;
    }

    @Override // c5.c
    public final Iterator iterator() {
        return new b(this);
    }
}