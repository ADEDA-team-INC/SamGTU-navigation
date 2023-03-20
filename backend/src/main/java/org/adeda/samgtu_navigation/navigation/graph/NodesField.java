package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.RectInt;
import org.adeda.samgtu_navigation.core.util.Vector2d;

import java.util.List;
import java.util.Optional;

public class NodesField implements GraphField {
    private final Rect domainRect;
    private final RectInt fieldRect;
    private final List<GraphNode> nodes;

    public NodesField(
        Rect domainRect,
        RectInt fieldRect,
        List<GraphNode> nodes
    ) {
        if (Math.abs(domainRect.getWidth() - fieldRect.getHeight()) > Math.ulp(1.0)) {
            throw new InvalidFormatException("Domain rect must be a square");
        }

        if (fieldRect.getWidth() != fieldRect.getHeight()) {
            throw new InvalidFormatException("Field rect must be a square");
        }

        this.domainRect = domainRect;
        this.fieldRect = fieldRect;
        this.nodes = nodes;
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
        return containsPoint(point) ? Optional.of(this) : Optional.empty();
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }
}
