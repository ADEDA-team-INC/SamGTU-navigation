package org.adeda.samgtu_navigation.core.util;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@Embeddable
public class Rect {
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private double positionX;
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private double positionY;
    private double width;
    private double height;

    public Rect() {
        this.positionX = 0.0;
        this.positionY = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    public Rect(Vector2d position, Vector2d size) {
        setPosition(position);
        setSize(size);
    }

    public Vector2d getPosition() {
        return new Vector2d(positionX, positionY);
    }

    public void setPosition(Vector2d position) {
        positionX = position.getX();
        positionY = position.getY();
    }

    public Vector2d getSize() {
        return new Vector2d(width, height);
    }

    public void setSize(Vector2d size) {
        width = size.getX();
        height = size.getY();
    }

    public Vector2d getCenter() {
        return new Vector2d(
            positionX + width * 0.5,
            positionY + height * 0.5
        );
    }

    public double getTop() {
        return positionY;
    }

    public double getBottom() {
        return positionY + height;
    }

    public double getLeft() {
        return positionX;
    }

    public double getRight() {
        return positionX + width;
    }

    public boolean containsPoint(Vector2d point) {
        return point.getX() >= positionX &&
            point.getX() <= positionX + width &&
            point.getY() >= positionY &&
            point.getY() <= positionY + height;
    }
}
