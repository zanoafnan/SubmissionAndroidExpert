package d5;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import w4.p;

/* loaded from: classes.dex */
public final class h extends x4.h implements p {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f1976j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f1977k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1978l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Object obj, boolean z6, int i7) {
        super(2);
        this.f1976j = i7;
        this.f1978l = obj;
        this.f1977k = z6;
    }

    public final k4.e b(int i7, CharSequence charSequence) {
        Object obj;
        k4.e eVar;
        Object obj2;
        int i8 = this.f1976j;
        Object obj3 = this.f1978l;
        switch (i8) {
            case 0:
                v4.a.n(charSequence, "$this$$receiver");
                int V0 = i.V0(i7, charSequence, this.f1977k, (char[]) obj3);
                if (V0 < 0) {
                    return null;
                }
                return new k4.e(Integer.valueOf(V0), 1);
            default:
                v4.a.n(charSequence, "$this$$receiver");
                List list = (List) obj3;
                boolean z6 = this.f1977k;
                if (z6 || list.size() != 1) {
                    if (i7 < 0) {
                        i7 = 0;
                    }
                    a5.c cVar = new a5.c(i7, charSequence.length());
                    boolean z7 = charSequence instanceof String;
                    int i9 = cVar.f230k;
                    int i10 = cVar.f229j;
                    if (z7) {
                        if ((i9 > 0 && i7 <= i10) || (i9 < 0 && i10 <= i7)) {
                            while (true) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj2 = it.next();
                                        String str = (String) obj2;
                                        if (i.Z0(0, i7, str.length(), str, (String) charSequence, z6)) {
                                        }
                                    } else {
                                        obj2 = null;
                                    }
                                }
                                String str2 = (String) obj2;
                                if (str2 != null) {
                                    eVar = new k4.e(Integer.valueOf(i7), str2);
                                } else if (i7 != i10) {
                                    i7 += i9;
                                }
                            }
                        }
                        eVar = null;
                    } else {
                        if ((i9 > 0 && i7 <= i10) || (i9 < 0 && i10 <= i7)) {
                            while (true) {
                                Iterator it2 = list.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        obj = it2.next();
                                        String str3 = (String) obj;
                                        if (i.a1(str3, 0, charSequence, i7, str3.length(), z6)) {
                                        }
                                    } else {
                                        obj = null;
                                    }
                                }
                                String str4 = (String) obj;
                                if (str4 != null) {
                                    eVar = new k4.e(Integer.valueOf(i7), str4);
                                } else if (i7 != i10) {
                                    i7 += i9;
                                }
                            }
                        }
                        eVar = null;
                    }
                } else {
                    int size = list.size();
                    if (size == 0) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    if (size != 1) {
                        throw new IllegalArgumentException("List has more than one element.");
                    }
                    String str5 = (String) list.get(0);
                    int U0 = i.U0(charSequence, str5, i7, false, 4);
                    if (U0 >= 0) {
                        eVar = new k4.e(Integer.valueOf(U0), str5);
                    }
                    eVar = null;
                }
                if (eVar != null) {
                    return new k4.e(eVar.f3311i, Integer.valueOf(((String) eVar.f3312j).length()));
                }
                return null;
        }
    }

    @Override // w4.p
    public final Object g(Object obj, Object obj2) {
        switch (this.f1976j) {
            case 0:
                return b(((Number) obj2).intValue(), (CharSequence) obj);
            case 1:
                return b(((Number) obj2).intValue(), (CharSequence) obj);
            default:
                return ((o4.h) obj).x((o4.f) obj2);
        }
    }
}