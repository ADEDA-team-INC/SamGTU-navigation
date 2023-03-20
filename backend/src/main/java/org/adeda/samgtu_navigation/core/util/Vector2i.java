package org.adeda.samgtu_navigation.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2i {
    private int x;
    private int y;

    public Vector2d to2d() {
        return new Vector2d(x, y);
    }

    public Vector2i add(Vector2i v) {
        return new Vector2i(x + v.x,  y + v.y);
    }

    public Vector2i subtract(Vector2i v) {
        return new Vector2i(x - v.x, y - v.y);
    }

    public Vector2i multiply(Vector2i v) {
        return new Vector2i(x * v.x, y * v.y);
    }

    public Vector2i multiply(int s) {
        return new Vector2i(x * s, y * s);
    }

    public Vector2i divide(Vector2i v) {
        return new Vector2i(x / v.x, y / v.y);
    }

    public Vector2i divide(int s) {
        return new Vector2i(x / s, y / s);
    }
}
