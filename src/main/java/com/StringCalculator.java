package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String str) {
        String defaultRegex = "\\s*,\\s*|\\s*\\n\\s*";

        if (str.startsWith("//")) {
            str = str.replace("//", "");
            defaultRegex = "\\s*;\\s*|\\s*\\n\\s*";
        }
        List<Integer> nums = Arrays.stream(str.split(defaultRegex))
                .filter(s -> !s.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> negativeNums = nums.stream().filter(num -> num < 0).collect(Collectors.toList());
        if (negativeNums.size() > 0) {
            throw new RuntimeException("negative numbers not allowed " + negativeNums);
        }

        return Arrays.stream(str.split(defaultRegex))
                .filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(Integer::sum)
                .orElse(0);
    }

}