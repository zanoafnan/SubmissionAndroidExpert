package a6;

import z5.g;
import z5.p;
import z5.s;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f243a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(d5.a.f1962a);
        v4.a.m(bytes, "this as java.lang.String).getBytes(charset)");
        f243a = bytes;
    }

    public static final String a(g gVar, long j3) {
        v4.a.n(gVar, "<this>");
        if (j3 > 0) {
            long j6 = j3 - 1;
            if (gVar.G(j6) == ((byte) 13)) {
                String K = gVar.K(j6, d5.a.f1962a);
                gVar.a(2L);
                return K;
            }
        }
        String K2 = gVar.K(j3, d5.a.f1962a);
        gVar.a(1L);
        return K2;
    }

    public static final int b(g gVar, p pVar, boolean z6) {
        int i7;
        int i8;
        byte[] bArr;
        int i9;
        s sVar;
        v4.a.n(gVar, "<this>");
        v4.a.n(pVar, "options");
        s sVar2 = gVar.f6708i;
        int i10 = -2;
        if (sVar2 == null) {
            return z6 ? -2 : -1;
        }
        int i11 = sVar2.f6735b;
        int i12 = sVar2.f6736c;
        byte[] bArr2 = sVar2.f6734a;
        s sVar3 = sVar2;
        int i13 = -1;
        int i14 = 0;
        loop0: while (true) {
            int i15 = i14 + 1;
            int[] iArr = pVar.f6727j;
            int i16 = iArr[i14];
            int i17 = i15 + 1;
            int i18 = iArr[i15];
            if (i18 != -1) {
                i13 = i18;
            }
            if (sVar3 == null) {
                break;
            }
            if (i16 >= 0) {
                int i19 = i11 + 1;
                int i20 = bArr2[i11] & 255;
                int i21 = i17 + i16;
                while (i17 != i21) {
                    if (i20 == iArr[i17]) {
                        i7 = iArr[i17 + i16];
                        if (i19 == i12) {
                            sVar3 = sVar3.f6739f;
                            v4.a.k(sVar3);
                            i8 = sVar3.f6735b;
                            i12 = sVar3.f6736c;
                            bArr2 = sVar3.f6734a;
                            if (sVar3 == sVar2) {
                                sVar3 = null;
                            }
                        } else {
                            i8 = i19;
                        }
                    } else {
                        i17++;
                    }
                }
                return i13;
            }
            int i22 = (i16 * (-1)) + i17;
            while (true) {
                int i23 = i11 + 1;
                int i24 = i17 + 1;
                if ((bArr2[i11] & 255) != iArr[i17]) {
                    return i13;
                }
                boolean z7 = i24 == i22;
                if (i23 == i12) {
                    v4.a.k(sVar3);
                    s sVar4 = sVar3.f6739f;
                    v4.a.k(sVar4);
                    i9 = sVar4.f6735b;
                    int i25 = sVar4.f6736c;
                    bArr = sVar4.f6734a;
                    if (sVar4 != sVar2) {
                        sVar = sVar4;
                        i12 = i25;
                    } else if (!z7) {
                        break loop0;
                    } else {
                        i12 = i25;
                        sVar = null;
                    }
                } else {
                    s sVar5 = sVar3;
                    bArr = bArr2;
                    i9 = i23;
                    sVar = sVar5;
                }
                if (z7) {
                    i7 = iArr[i24];
                    i8 = i9;
                    bArr2 = bArr;
                    sVar3 = sVar;
                    break;
                }
                i11 = i9;
                bArr2 = bArr;
                i17 = i24;
                sVar3 = sVar;
            }
            if (i7 >= 0) {
                return i7;
            }
            i14 = -i7;
            i11 = i8;
            i10 = -2;
        }
        return z6 ? i10 : i13;
    }
}