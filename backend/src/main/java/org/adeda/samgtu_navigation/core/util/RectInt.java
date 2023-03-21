package org.adeda.samgtu_navigation.core.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RectInt {
    @NonNull
    private Vector2i position;
    @NonNull
    private Vector2i size;

    public RectInt(int x, int y, int width, int height) {
        this.position = new Vector2i(x, y);
        this.size = new Vector2i(width, height);
    }

    public Vector2d getCenter() {
        return new Vector2d(
            position.getX() + size.getX() * 0.5,
            position.getY() + size.getY() * 0.5
        );
    }

    public int getWidth() {
        return size.getX();
    }

    public int getHeight() {
        return size.getY();
    }

    public int getTop() {
        return position.getY();
    }

    public int getBottom() {
        return position.getY() + size.getY();
    }

    public int getLeft() {
        return position.getX();
    }

    public int getRight() {
        return position.getX() + size.getX();
    }

    public boolean containsPoint(Vector2i point) {
        return point.getX() >= getLeft() &&
            point.getX() <= getRight() &&
            point.getY() >= getTop() &&
            point.getY() <= getBottom();
    }
}
