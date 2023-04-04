package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;

@Entity
@Table(name = "outdoor_objects", indexes = {
    @Index(columnList = "type")
})
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class OutdoorObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @NonNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private OutdoorObjectType type;

    @NonNull
    @Column(nullable = false)
    private String displayName;

    @NonNull
    @Column(nullable = false)
    private String displayDescription;
}
