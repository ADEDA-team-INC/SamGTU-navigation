package org.adeda.samgtu_navigation.core.util;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Embeddable
public class Rect {
    @NonNull
    private Vector2d position;
    @NonNull
    private Vector2d size;

    public Rect(double x, double y, double width, double height) {
        this.position = new Vector2d(x, y);
        this.size = new Vector2d(width, height);
    }

    public Vector2d getCenter() {
        return new Vector2d(
            position.getX() + size.getX() * 0.5,
            position.getY() + size.getY() * 0.5
        );
    }

    public double getWidth() {
        return size.getX();
    }

    public double getHeight() {
        return size.getY();
    }

    public double getTop() {
        return position.getY();
    }

    public double getBottom() {
        return position.getY() + size.getY();
    }

    public double getLeft() {
        return position.getX();
    }

    public double getRight() {
        return position.getX() + size.getX();
    }

    public boolean containsPoint(Vector2d point) {
        return point.getX() >= getLeft() &&
            point.getX() <= getRight() &&
            point.getY() >= getTop() &&
            point.getY() <= getBottom();
    }
}
