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

    public Vector2i add(int x, int y) {
        return new Vector2i(this.x + x,  this.y + y);
    }

    public Vector2i subtract(Vector2i v) {
        return new Vector2i(x - v.x, y - v.y);
    }

    public Vector2i subtract(int x, int y) {
        return new Vector2i(this.x - x, this.y - y);
    }

    public Vector2i multiply(Vector2i v) {
        return new Vector2i(x * v.x, y * v.y);
    }

    public Vector2i multiply(int x, int y) {
        return new Vector2i(this.x * x, this.y * y);
    }

    public Vector2i multiply(int s) {
        return new Vector2i(x * s, y * s);
    }

    public Vector2i divide(Vector2i v) {
        return new Vector2i(x / v.x, y / v.y);
    }

    public Vector2i divide(int x, int y) {
        return new Vector2i(this.x / x, this.y / y);
    }

    public Vector2i divide(int s) {
        return new Vector2i(x / s, y / s);
    }

    public static Vector2i zero() {
        return new Vector2i(0, 0);
    }

    public static Vector2i one() {
        return new Vector2i(1, 1);
    }
}
