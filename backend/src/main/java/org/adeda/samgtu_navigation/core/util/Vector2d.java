package org.adeda.samgtu_navigation.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2d {
    private double x;
    private double y;

    public Vector2i to2i() {
        return new Vector2i((int)x, (int)y);
    }

    public Vector2d add(Vector2d v) {
        return new Vector2d(x + v.x,  y + v.y);
    }

    public Vector2d subtract(Vector2d v) {
        return new Vector2d(x - v.x, y - v.y);
    }

    public Vector2d multiply(Vector2d v) {
        return new Vector2d(x * v.x, y * v.y);
    }

    public Vector2d multiply(double s) {
        return new Vector2d(x * s, y * s);
    }

    public Vector2d divide(Vector2d v) {
        return new Vector2d(x / v.x, y / v.y);
    }

    public Vector2d divide(double s) {
        return new Vector2d(x / s, y / s);
    }
}
