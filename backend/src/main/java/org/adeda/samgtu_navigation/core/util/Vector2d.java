package org.adeda.samgtu_navigation.core.util;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
public class Vector2d {
    private double x;
    private double y;

    public Vector2d() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Vector2d add(Vector2d v) {
        return new Vector2d(x + v.x,  y + v.y);
    }

    public Vector2d add(double x, double y) {
        return new Vector2d(this.x + x,  this.y + y);
    }

    public Vector2d subtract(Vector2d v) {
        return new Vector2d(x - v.x, y - v.y);
    }

    public Vector2d subtract(double x, double y) {
        return new Vector2d(this.x - x, this.y - y);
    }

    public Vector2d multiply(Vector2d v) {
        return new Vector2d(x * v.x, y * v.y);
    }

    public Vector2d multiply(double x, double y) {
        return new Vector2d(this.x * x, this.y * y);
    }

    public Vector2d multiply(double s) {
        return new Vector2d(x * s, y * s);
    }

    public Vector2d divide(Vector2d v) {
        return new Vector2d(x / v.x, y / v.y);
    }

    public Vector2d divide(double x, double y) {
        return new Vector2d(this.x / x, this.y / y);
    }

    public Vector2d divide(double s) {
        return new Vector2d(x / s, y / s);
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public static Vector2d one() {
        return new Vector2d(1.0, 1.0);
    }
}
