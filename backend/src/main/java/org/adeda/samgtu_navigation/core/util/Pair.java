package org.adeda.samgtu_navigation.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Pair<T, V> {
    private T first;
    private V second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return (Objects.equals(first, pair.first)
                    && Objects.equals(second, pair.second))
                ||
                (Objects.equals(first, pair.second)
                    && Objects.equals(second, pair.first));
    }
}
