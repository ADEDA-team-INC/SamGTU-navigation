package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.RectInt;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.core.util.Vector2i;

import java.util.List;
import java.util.Optional;

public class NodesField implements GraphField {
    private Rect domainRect;
    private RectInt fieldRect;
    private final QuaternaryField parent;
    private final List<GraphNode> nodes;

    public NodesField(
        Rect domainRect,
        RectInt fieldRect,
        QuaternaryField parent,
        List<GraphNode> nodes
    ) {
        setDomainRect(domainRect);
        setFieldRect(fieldRect);

        this.parent = parent;
        this.nodes = nodes;
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
    }

    @Override
    public RectInt getFieldRect() {
        return fieldRect;
    }

    @Override
    public void setFieldRect(RectInt fieldRect) {
        if (fieldRect.getWidth() != 1 || fieldRect.getHeight() != 1) {
            throw new InvalidFormatException("fieldRect must be a square with size 1");
        }

        this.fieldRect = fieldRect;
    }

    @Override
    public Optional<QuaternaryField> getParent() {
        return Optional.ofNullable(parent);
    }

    @Override
    public Optional<GraphField> findLowestGraphForPoint(Vector2d point) {
        if (containsPoint(point)) {
            return Optional.of(this);
        }

        if (parent != null) {
            return parent.findLowestGraphForPoint(point);
        }

        return Optional.empty();
    }

    @Override
    public Optional<GraphField> findLowestGraphForPoint(Vector2i point) {
        if (containsPoint(point)) {
            return Optional.of(this);
        }

        if (parent != null) {
            return parent.findLowestGraphForPoint(point);
        }

        return Optional.empty();
    }

    public List<NodesField> findNeighbours() {
        throw new UnsupportedOperationException();
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }
}
