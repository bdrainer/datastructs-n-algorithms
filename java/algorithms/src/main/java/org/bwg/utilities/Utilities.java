package org.bwg.utilities;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utilities {

    public static String replace(String source, int idx) {
        return new StringBuilder(source).deleteCharAt(idx).toString();
    }

    public static String[] concatArrays(String[] a, String[] b) {
        return Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray(String[]::new);
//        return Stream.of(a, b).flatMap(Stream::of).toArray(String[]::new);
    }
}
