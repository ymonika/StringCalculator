package com;

import java.util.Arrays;

public class StringCalculator {

    public int add(String str) {
        String defaultRegex = "\\s*,\\s*|\\s*\\n\\s*";

        if (str.startsWith("//")) {
            str = str.replace("//", "");
            defaultRegex = "\\s*;\\s*|\\s*\\n\\s*";
        }
        return Arrays.stream(str.split(defaultRegex))
                .filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(Integer::sum)
                .orElse(0);
    }
    
}