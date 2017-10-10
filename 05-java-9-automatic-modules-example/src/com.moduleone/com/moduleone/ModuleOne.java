package com.moduleone;

import java.util.List;
import com.google.common.collect.FluentIterable;

class ModuleOne {

    public static void main(String[] args) {
        FluentIterable.from(List.of(1, 2, 3, 4, 5, 6, 7))
            .filter(input -> input % 2 == 0)
            .stream()
            .forEach(System.out::println);
    }
}