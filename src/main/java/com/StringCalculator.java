package com;

import java.util.Arrays;

public class StringCalculator {

    public int add(String str) {
        return Arrays.stream(str.split("\\s*,\\s*|\\s*\\n\\s*"))
                .filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(Integer::sum)
                .orElse(0);

    }

}