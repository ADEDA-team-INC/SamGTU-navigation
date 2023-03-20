package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.RectInt;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.core.util.Vector2i;

import java.util.Optional;

public interface GraphField {
    Rect getDomainRect();

    RectInt getFieldRect();

    default boolean containsPoint(Vector2d point) {
        return getDomainRect().containsPoint(point);
    }

    default boolean containsPoint(Vector2i point) {
        return getFieldRect().containsPoint(point);
    }

    default Vector2i domainPointToField(Vector2d point) {
        var ratio = getFieldRect().getSize().to2d().divide(getDomainRect().getSize());

        var offset = point.subtract(getDomainRect().getPosition()).multiply(ratio);

        return offset.to2i().add(getFieldRect().getPosition());
    }

    Optional<GraphField> findLowestGraphForPoint(Vector2d point);
}
