package d5;

import androidx.lifecycle.e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class i extends g {
    public static boolean N0(CharSequence charSequence, String str) {
        v4.a.n(charSequence, "<this>");
        return U0(charSequence, str, 0, false, 2) >= 0;
    }

    public static boolean O0(String str, String str2) {
        v4.a.n(str, "<this>");
        v4.a.n(str2, "suffix");
        return str.endsWith(str2);
    }

    public static final boolean P0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final int Q0(CharSequence charSequence) {
        v4.a.n(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R0(int i7, CharSequence charSequence, String str, boolean z6) {
        v4.a.n(charSequence, "<this>");
        v4.a.n(str, "string");
        return (z6 || !(charSequence instanceof String)) ? S0(charSequence, str, i7, charSequence.length(), z6, false) : ((String) charSequence).indexOf(str, i7);
    }

    public static final int S0(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z6, boolean z7) {
        a5.a aVar;
        if (z7) {
            int Q0 = Q0(charSequence);
            if (i7 > Q0) {
                i7 = Q0;
            }
            if (i8 < 0) {
                i8 = 0;
            }
            aVar = new a5.a(i7, i8, -1);
        } else {
            if (i7 < 0) {
                i7 = 0;
            }
            int length = charSequence.length();
            if (i8 > length) {
                i8 = length;
            }
            aVar = new a5.c(i7, i8);
        }
        boolean z8 = charSequence instanceof String;
        int i9 = aVar.f228i;
        int i10 = aVar.f230k;
        int i11 = aVar.f229j;
        if (z8 && (charSequence2 instanceof String)) {
            if ((i10 > 0 && i9 <= i11) || (i10 < 0 && i11 <= i9)) {
                while (!Z0(0, i9, charSequence2.length(), (String) charSequence2, (String) charSequence, z6)) {
                    if (i9 != i11) {
                        i9 += i10;
                    }
                }
                return i9;
            }
        } else if ((i10 > 0 && i9 <= i11) || (i10 < 0 && i11 <= i9)) {
            while (!a1(charSequence2, 0, charSequence, i9, charSequence2.length(), z6)) {
                if (i9 != i11) {
                    i9 += i10;
                }
            }
            return i9;
        }
        return -1;
    }

    public static int T0(CharSequence charSequence, char c7, int i7, boolean z6, int i8) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z6 = false;
        }
        v4.a.n(charSequence, "<this>");
        return (z6 || !(charSequence instanceof String)) ? V0(i7, charSequence, z6, new char[]{c7}) : ((String) charSequence).indexOf(c7, i7);
    }

    public static /* synthetic */ int U0(CharSequence charSequence, String str, int i7, boolean z6, int i8) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z6 = false;
        }
        return R0(i7, charSequence, str, z6);
    }

    public static final int V0(int i7, CharSequence charSequence, boolean z6, char[] cArr) {
        int i8;
        boolean z7;
        v4.a.n(charSequence, "<this>");
        v4.a.n(cArr, "chars");
        if (!z6 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(l4.j.t0(cArr), i7);
        }
        if (i7 < 0) {
            i7 = 0;
        }
        a5.c cVar = new a5.c(i7, Q0(charSequence));
        int i9 = cVar.f229j;
        int i10 = cVar.f230k;
        boolean z8 = i10 <= 0 ? i7 >= i9 : i7 <= i9;
        if (!z8) {
            i7 = i9;
        }
        while (z8) {
            if (i7 != i9) {
                i8 = i10 + i7;
            } else if (!z8) {
                throw new NoSuchElementException();
            } else {
                i8 = i7;
                z8 = false;
            }
            char charAt = charSequence.charAt(i7);
            int length = cArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z7 = false;
                    break;
                } else if (com.bumptech.glide.c.t(cArr[i11], charAt, z6)) {
                    z7 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z7) {
                return i7;
            }
            i7 = i8;
        }
        return -1;
    }

    public static final boolean W0(String str) {
        boolean z6;
        v4.a.n(str, "<this>");
        if (str.length() != 0) {
            a5.c cVar = new a5.c(0, str.length() - 1);
            if (!(cVar instanceof Collection) || !((Collection) cVar).isEmpty()) {
                Iterator it = cVar.iterator();
                while (((a5.b) it).f233c) {
                    if (!com.bumptech.glide.c.C(str.charAt(((a5.b) it).b()))) {
                        z6 = false;
                        break;
                    }
                }
            }
            z6 = true;
            return z6;
        }
        return true;
    }

    public static int X0(CharSequence charSequence, char c7, int i7, int i8) {
        if ((i8 & 2) != 0) {
            i7 = Q0(charSequence);
        }
        v4.a.n(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c7, i7);
        }
        char[] cArr = {c7};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(l4.j.t0(cArr), i7);
        }
        int Q0 = Q0(charSequence);
        if (i7 > Q0) {
            i7 = Q0;
        }
        while (-1 < i7) {
            if (com.bumptech.glide.c.t(cArr[0], charSequence.charAt(i7), false)) {
                return i7;
            }
            i7--;
        }
        return -1;
    }

    public static final List Y0(CharSequence charSequence) {
        v4.a.n(charSequence, "<this>");
        d1(0);
        return c5.d.M0(new c5.h(new c(charSequence, 0, 0, new h(l4.j.o0(new String[]{"\r\n", "\n", "\r"}), false, 1)), new e1(4, charSequence)));
    }

    public static final boolean Z0(int i7, int i8, int i9, String str, String str2, boolean z6) {
        v4.a.n(str, "<this>");
        v4.a.n(str2, "other");
        return !z6 ? str.regionMatches(i7, str2, i8, i9) : str.regionMatches(z6, i7, str2, i8, i9);
    }

    public static final boolean a1(CharSequence charSequence, int i7, CharSequence charSequence2, int i8, int i9, boolean z6) {
        v4.a.n(charSequence, "<this>");
        v4.a.n(charSequence2, "other");
        if (i8 < 0 || i7 < 0 || i7 > charSequence.length() - i9 || i8 > charSequence2.length() - i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!com.bumptech.glide.c.t(charSequence.charAt(i7 + i10), charSequence2.charAt(i8 + i10), z6)) {
                return false;
            }
        }
        return true;
    }

    public static final String b1(String str, String str2) {
        if (g1(str2, str)) {
            String substring = str2.substring(str.length());
            v4.a.m(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str2;
    }

    public static String c1(String str, String str2, String str3) {
        v4.a.n(str, "<this>");
        int R0 = R0(0, str, str2, false);
        if (R0 < 0) {
            return str;
        }
        int length = str2.length();
        int i7 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            int i8 = 0;
            do {
                sb.append((CharSequence) str, i8, R0);
                sb.append(str3);
                i8 = R0 + length;
                if (R0 >= str.length()) {
                    break;
                }
                R0 = R0(R0 + i7, str, str2, false);
            } while (R0 > 0);
            sb.append((CharSequence) str, i8, str.length());
            String sb2 = sb.toString();
            v4.a.m(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static final void d1(int i7) {
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(a.g.h("Limit must be non-negative, but was ", i7).toString());
        }
    }

    public static List e1(CharSequence charSequence, char[] cArr) {
        v4.a.n(charSequence, "<this>");
        if (cArr.length != 1) {
            d1(0);
            c5.f fVar = new c5.f(new c(charSequence, 0, 0, new h(cArr, false, 0)));
            ArrayList arrayList = new ArrayList(e.M0(fVar));
            Iterator it = fVar.iterator();
            while (it.hasNext()) {
                arrayList.add(h1(charSequence, (a5.c) it.next()));
            }
            return arrayList;
        }
        String valueOf = String.valueOf(cArr[0]);
        d1(0);
        int R0 = R0(0, charSequence, valueOf, false);
        if (R0 != -1) {
            ArrayList arrayList2 = new ArrayList(10);
            int i7 = 0;
            do {
                arrayList2.add(charSequence.subSequence(i7, R0).toString());
                i7 = valueOf.length() + R0;
                R0 = R0(i7, charSequence, valueOf, false);
            } while (R0 != -1);
            arrayList2.add(charSequence.subSequence(i7, charSequence.length()).toString());
            return arrayList2;
        }
        return v4.a.T(charSequence.toString());
    }

    public static final boolean f1(String str, String str2, int i7, boolean z6) {
        v4.a.n(str, "<this>");
        return !z6 ? str.startsWith(str2, i7) : Z0(i7, 0, str2.length(), str, str2, z6);
    }

    public static boolean g1(String str, String str2) {
        v4.a.n(str, "<this>");
        v4.a.n(str2, "prefix");
        return str.startsWith(str2);
    }

    public static final String h1(CharSequence charSequence, a5.c cVar) {
        v4.a.n(charSequence, "<this>");
        v4.a.n(cVar, "range");
        return charSequence.subSequence(Integer.valueOf(cVar.f228i).intValue(), Integer.valueOf(cVar.f229j).intValue() + 1).toString();
    }

    public static String i1(String str, String str2) {
        v4.a.n(str2, "delimiter");
        int U0 = U0(str, str2, 0, false, 6);
        if (U0 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + U0, str.length());
        v4.a.m(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String j1(String str) {
        v4.a.n(str, "<this>");
        v4.a.n(str, "missingDelimiterValue");
        int X0 = X0(str, '.', 0, 6);
        if (X0 == -1) {
            return str;
        }
        String substring = str.substring(X0 + 1, str.length());
        v4.a.m(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence k1(CharSequence charSequence) {
        v4.a.n(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z6 = false;
        while (i7 <= length) {
            boolean C = com.bumptech.glide.c.C(charSequence.charAt(!z6 ? i7 : length));
            if (z6) {
                if (!C) {
                    break;
                }
                length--;
            } else if (C) {
                i7++;
            } else {
                z6 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }
}