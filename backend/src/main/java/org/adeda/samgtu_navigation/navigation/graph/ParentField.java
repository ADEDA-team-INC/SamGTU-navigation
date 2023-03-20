package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.RectInt;
import org.adeda.samgtu_navigation.core.util.Vector2d;

import java.util.List;
import java.util.Optional;

public class ParentField implements GraphField {
    private final Rect domainRect;
    private final RectInt fieldRect;
    private final List<GraphField> children;

    public ParentField(
        Rect domainRect,
        RectInt fieldRect,
        List<GraphField> children
    ) {
        if (Math.abs(domainRect.getWidth() - fieldRect.getHeight()) > Math.ulp(1.0)) {
            throw new InvalidFormatException("Domain rect must be a square");
        }

        if (fieldRect.getWidth() != fieldRect.getHeight()) {
            throw new InvalidFormatException("Field rect must be a square");
        }

        if (children.size() != 4) {
            throw new InvalidFormatException("ParentField must contain strictly four children");
        }

        this.domainRect = domainRect;
        this.fieldRect = fieldRect;
        this.children = children;
    }

    @Override
    public Rect getDomainRect() {
        return domainRect;
    }

    @Override
    public RectInt getFieldRect() {
        return fieldRect;
    }

    @Override
    public Optional<GraphField> findLowestGraphForPoint(Vector2d point) {
        for (var child : children) {
            if (child.containsPoint(point)) {
                return child.findLowestGraphForPoint(point);
            }
        }

        return Optional.empty();
    }

    public List<GraphField> getChildren() {
        return children;
    }
}
