package d5;

/* loaded from: classes.dex */
public abstract class j extends i {
    public static final String l1(int i7, String str) {
        v4.a.n(str, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
        }
        int length = str.length();
        if (i7 > length) {
            i7 = length;
        }
        String substring = str.substring(0, i7);
        v4.a.m(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}