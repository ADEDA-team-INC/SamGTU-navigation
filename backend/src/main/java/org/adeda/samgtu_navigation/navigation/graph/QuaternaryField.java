package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.RectInt;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.core.util.Vector2i;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class QuaternaryField implements GraphField {
    private Rect domainRect;
    private RectInt fieldRect;
    private List<GraphField> children;
    private final QuaternaryField parent;

    public QuaternaryField(
        Rect domainRect,
        RectInt fieldRect,
        QuaternaryField parent,
        List<GraphField> children
    ) {
        if (children.size() != 4) {
            throw new InvalidFormatException("QuaternaryField must contain strictly four children");
        }

        setFieldRect(fieldRect);
        setDomainRect(domainRect);
        setChildren(children);

        this.parent = parent;
    }

    @Override
    public Rect getDomainRect() {
        return domainRect;
    }

    @Override
    public void setDomainRect(Rect domainRect) {
        if (Math.abs(domainRect.getWidth() - domainRect.getHeight()) > Math.ulp(1.0)) {
            throw new InvalidFormatException("domainRect must be a square");
        }

        this.domainRect = domainRect;

        var halfSize = domainRect.getSize().divide(2);

        children.get(0).setDomainRect(
            new Rect(domainRect.getPosition().add(halfSize.getX(), 0), halfSize)
        );
        children.get(1).setDomainRect(
            new Rect(domainRect.getPosition(), halfSize)
        );
        children.get(2).setDomainRect(
            new Rect(domainRect.getPosition().add(0, halfSize.getY()), halfSize)
        );
        children.get(3).setDomainRect(
            new Rect(domainRect.getPosition().add(halfSize), halfSize)
        );
    }

    @Override
    public RectInt getFieldRect() {
        return fieldRect;
    }

    @Override
    public void setFieldRect(RectInt fieldRect) {
        if (
            fieldRect.getWidth() != fieldRect.getHeight() ||
            fieldRect.getWidth() % 2 != 0 ||
            fieldRect.getHeight() % 2 != 0
        ) {
            throw new InvalidFormatException("fieldRect must be a square with even size");
        }

        this.fieldRect = fieldRect;

        var halfSize = fieldRect.getSize().divide(2);

        children.get(0).setFieldRect(
            new RectInt(fieldRect.getPosition().add(halfSize.getX(), 0), halfSize)
        );
        children.get(1).setFieldRect(
            new RectInt(fieldRect.getPosition(), halfSize)
        );
        children.get(2).setFieldRect(
            new RectInt(fieldRect.getPosition().add(0, halfSize.getY()), halfSize)
        );
        children.get(3).setFieldRect(
            new RectInt(fieldRect.getPosition().add(halfSize), halfSize)
        );
    }

    @Override
    public Optional<QuaternaryField> getParent() {
        return Optional.ofNullable(parent);
    }

    @Override
    public Optional<GraphField> findLowestGraphForPoint(Vector2d point) {
        for (var child : children) {
            if (child.containsPoint(point)) {
                return child.findLowestGraphForPoint(point);
            }
        }

        if (parent != null) {
            parent.findLowestGraphForPoint(point);
        }

        return Optional.empty();
    }

    @Override
    public Optional<GraphField> findLowestGraphForPoint(Vector2i point) {
        for (var child : children) {
            if (child.containsPoint(point)) {
                return child.findLowestGraphForPoint(point);
            }
        }

        if (parent != null) {
            parent.findLowestGraphForPoint(point);
        }

        return Optional.empty();
    }

    public List<GraphField> getChildren() {
        return children;
    }

    public void setChildren(List<GraphField> children) {
        this.children = Collections.unmodifiableList(children);

        // Обновляем размеры для дочерних полей
        setDomainRect(domainRect);
        setFieldRect(fieldRect);
    }
}
