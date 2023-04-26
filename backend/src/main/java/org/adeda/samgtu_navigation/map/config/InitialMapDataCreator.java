package org.adeda.samgtu_navigation.map.config;

import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.schema.info.InfoCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.DomainImageSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.BoundingBoxSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectCreateSchema;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectCreateSchema;
import org.adeda.samgtu_navigation.map.service.MapBuildingService;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.adeda.samgtu_navigation.map.service.OutdoorObjectService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class InitialMapDataCreator implements ApplicationRunner {
    private record DomainData (Integer buildingId, MapDomainCreateSchema schema) { }
    private record MapObjectData (Integer domainId, MapObjectCreateSchema schema) { }

    private final List<MapBuildingCreateSchema> buildings = List.of(
        new MapBuildingCreateSchema(
            53.207565, 50.128729,
            new InfoCreateSchema(
                List.of(
                    "https://avatars.mds.yandex.net/get-altay/4255939/2a0000017c207a4036e1c15835b7eae85536/XXXL",
                    "https://avatars.mds.yandex.net/get-altay/5254653/2a0000017b1cd9ac3352aefd70021bab1c54/XXXL"
                ),
                "9th_building_name",
                "9th_building_descr"
            )
        )
    );
    private final List<DomainData> domains = List.of(
        new DomainData(1, new MapDomainCreateSchema(
            1, new DomainImageSchema(
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gR2VuZXJhdG9yOiBBZG9iZSBJbGx1c3RyYXRvciAyNi4wLjMsIFNWRyBFeHBvcnQgUGx1Zy1JbiAuIFNWRyBWZXJzaW9uOiA2LjAwIEJ1aWxkIDApICAtLT4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0i0KHQu9C+0LlfMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeD0iMHB4IiB5PSIwcHgiDQoJIHZpZXdCb3g9IjAgMCA2NjkgMjc3IiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCA2NjkgMjc3OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjY2OSIgaGVpZ2h0PSIyNzciPg0KPHN0eWxlIHR5cGU9InRleHQvY3NzIj4NCgkuc3Qwe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDAwMDt9DQo8L3N0eWxlPg0KPGc+DQoJPGxpbmUgaWQ9InN2Z18zIiBjbGFzcz0ic3QwIiB4MT0iLTYzIiB5MT0iLTYzIiB4Mj0iLTYzIiB5Mj0iLTYzIi8+DQoJPGxpbmUgaWQ9InN2Z18yIiBjbGFzcz0ic3QwIiB4MT0iMC4yIiB5MT0iMCIgeDI9IjAuMiIgeTI9IjI3NyIvPg0KCTxsaW5lIGlkPSJzdmdfNSIgY2xhc3M9InN0MCIgeDE9IjAiIHkxPSIwIiB4Mj0iMjg3IiB5Mj0iMCIvPg0KCTxsaW5lIGlkPSJzdmdfNiIgY2xhc3M9InN0MCIgeDE9IjI4NyIgeTE9IjAiIHgyPSIyODciIHkyPSIxMjMuNCIvPg0KCTxsaW5lIGlkPSJzdmdfNyIgY2xhc3M9InN0MCIgeDE9IjI4Ny4zIiB5MT0iMTIzIiB4Mj0iNDEwLjUiIHkyPSIxMjMiLz4NCgk8bGluZSBpZD0ic3ZnXzgiIGNsYXNzPSJzdDAiIHgxPSI0MTAiIHkxPSIxMjIuNyIgeDI9IjQxMCIgeTI9Ijg4LjMiLz4NCgk8bGluZSBpZD0ic3ZnXzkiIGNsYXNzPSJzdDAiIHgxPSI0MDkuMyIgeTE9Ijg4LjYiIHgyPSI2NjkuNCIgeTI9Ijg4LjYiLz4NCgk8bGluZSBpZD0ic3ZnXzEwIiBjbGFzcz0ic3QwIiB4MT0iNjY5LjMiIHkxPSI4OSIgeDI9IjY2OS4zIiB5Mj0iMjc3Ii8+DQoJPGxpbmUgaWQ9InN2Z18xMSIgY2xhc3M9InN0MCIgeDE9IjAuMiIgeTE9IjI3NyIgeDI9IjY2OSIgeTI9IjI3NyIvPg0KCTxsaW5lIGlkPSJzdmdfMTIiIGNsYXNzPSJzdDAiIHgxPSIxNjAuOSIgeTE9IjAuNSIgeDI9IjE2MC45IiB5Mj0iMzciLz4NCgk8bGluZSBpZD0ic3ZnXzEzIiBjbGFzcz0ic3QwIiB4MT0iMTYxIiB5MT0iMzciIHgyPSIyMTYuOSIgeTI9IjM3Ii8+DQoJPGxpbmUgaWQ9InN2Z18xNCIgY2xhc3M9InN0MCIgeDE9IjIzNi40IiB5MT0iMzciIHgyPSIyODcuMSIgeTI9IjM3Ii8+DQoJPGxpbmUgaWQ9InN2Z180IiBjbGFzcz0ic3QwIiB4MT0iMjg2LjYiIHkxPSI3NyIgeDI9IjE2MC44IiB5Mj0iNzciLz4NCgk8bGluZSBpZD0ic3ZnXzE1IiBjbGFzcz0ic3QwIiB4MT0iMjg3IiB5MT0iMTIzIiB4Mj0iMTYxIiB5Mj0iMTIzIi8+DQoJPGxpbmUgaWQ9InN2Z18xNiIgY2xhc3M9InN0MCIgeDE9IjE2MC44IiB5MT0iMzYuNiIgeDI9IjE2MC44IiB5Mj0iNTIiLz4NCgk8bGluZSBpZD0ic3ZnXzE3IiBjbGFzcz0ic3QwIiB4MT0iMTYxIiB5MT0iNzciIHgyPSIxNjEiIHkyPSI2NCIvPg0KCTxsaW5lIGlkPSJzdmdfMTgiIGNsYXNzPSJzdDAiIHgxPSIxNjEiIHkxPSI3NyIgeDI9IjE2MSIgeTI9Ijk1Ii8+DQoJPGxpbmUgaWQ9InN2Z18xOSIgY2xhc3M9InN0MCIgeDE9IjE2MC45IiB5MT0iMTA1IiB4Mj0iMTYwLjkiIHkyPSIxMjMiLz4NCgk8bGluZSBpZD0ic3ZnXzIwIiBjbGFzcz0ic3QwIiB4MT0iMTAwIiB5MT0iMC4xIiB4Mj0iMTAwIiB5Mj0iMTguNiIvPg0KCTxsaW5lIGlkPSJzdmdfMjEiIGNsYXNzPSJzdDAiIHgxPSIxMDAuNSIgeTE9IjMxLjIiIHgyPSIxMDAuNSIgeTI9Ijk1Ii8+DQoJPGxpbmUgaWQ9InN2Z18yMiIgY2xhc3M9InN0MCIgeDE9IjEwMCIgeTE9Ijc3IiB4Mj0iLTAuMSIgeTI9Ijc3Ii8+DQoJPGxpbmUgaWQ9InN2Z18yNCIgY2xhc3M9InN0MCIgeDE9IjIxMiIgeTE9IjE3Mi4yIiB4Mj0iMzA3LjQiIHkyPSIxNzIuMiIvPg0KCTxsaW5lIGlkPSJzdmdfMjUiIGNsYXNzPSJzdDAiIHgxPSIyMTIiIHkxPSIxMjIuNSIgeDI9IjIxMiIgeTI9IjEzOS40Ii8+DQoJPGxpbmUgaWQ9InN2Z18yNiIgY2xhc3M9InN0MCIgeDE9IjIxMiIgeTE9IjE1My42IiB4Mj0iMjEyIiB5Mj0iMTcyLjMiLz4NCgk8bGluZSBpZD0ic3ZnXzI3IiBjbGFzcz0ic3QwIiB4MT0iMzA3IiB5MT0iMTIzIiB4Mj0iMzA3IiB5Mj0iMTcyLjIiLz4NCgk8bGluZSBpZD0ic3ZnXzI4IiBjbGFzcz0ic3QwIiB4MT0iNDA5LjgiIHkxPSIxMjEuOSIgeDI9IjQwOS44IiB5Mj0iMTcyLjMiLz4NCgk8bGluZSBpZD0ic3ZnXzI5IiBjbGFzcz0ic3QwIiB4MT0iMzM4LjgiIHkxPSIxNzEuNiIgeDI9IjQzNy4xIiB5Mj0iMTcyIi8+DQoJPGxpbmUgaWQ9InN2Z18zMCIgY2xhc3M9InN0MCIgeDE9IjMwNy4xIiB5MT0iMTcyLjIiIHgyPSIzMjMuNSIgeTI9IjE3Mi4yIi8+DQoJPGxpbmUgaWQ9InN2Z18zMSIgY2xhc3M9InN0MCIgeDE9IjEwMCIgeTE9IjEwNy44IiB4Mj0iMTAwIiB5Mj0iMTIxIi8+DQoJPGxpbmUgaWQ9InN2Z18zMiIgY2xhc3M9InN0MCIgeDE9IjAuMiIgeTE9IjEyMSIgeDI9IjEwMCIgeTI9IjEyMSIvPg0KCTxsaW5lIGlkPSJzdmdfMzMiIGNsYXNzPSJzdDAiIHgxPSIxMDAiIHkxPSIxMjEiIHgyPSIxMDAiIHkyPSIxODIiLz4NCgk8bGluZSBpZD0ic3ZnXzM0IiBjbGFzcz0ic3QwIiB4MT0iOTkuNiIgeTE9IjE5NS4xIiB4Mj0iOTkuNiIgeTI9IjIyNyIvPg0KCTxsaW5lIGlkPSJzdmdfMzUiIGNsYXNzPSJzdDAiIHgxPSI5OS42IiB5MT0iMjQxLjgiIHgyPSI5OS42IiB5Mj0iMjc3Ii8+DQoJPGxpbmUgaWQ9InN2Z18zNiIgY2xhc3M9InN0MCIgeDE9Ijk5LjYiIHkxPSIyMTAuMiIgeDI9IjAuMiIgeTI9IjIxMC4yIi8+DQoJPGxpbmUgaWQ9InN2Z18zNyIgY2xhc3M9InN0MCIgeDE9IjE2MC40IiB5MT0iMjEwIiB4Mj0iMTYwLjQiIHkyPSIyMjciLz4NCgk8bGluZSBpZD0ic3ZnXzM4IiBjbGFzcz0ic3QwIiB4MT0iMTYxIiB5MT0iMjQxLjgiIHgyPSIxNjEiIHkyPSIyNzciLz4NCgk8bGluZSBpZD0ic3ZnXzM5IiBjbGFzcz0ic3QwIiB4MT0iNDEwIiB5MT0iMjEwIiB4Mj0iNDEwIiB5Mj0iMjc2LjUiLz4NCgk8bGluZSBpZD0ic3ZnXzQwIiBjbGFzcz0ic3QwIiB4MT0iMzg5LjIiIHkxPSIyMDkuOCIgeDI9IjQxMC40IiB5Mj0iMjA5LjgiLz4NCgk8bGluZSBpZD0ic3ZnXzQxIiBjbGFzcz0ic3QwIiB4MT0iMTYwIiB5MT0iMjA5LjgiIHgyPSIzNjcuNiIgeTI9IjIwOS44Ii8+DQoJPGxpbmUgaWQ9InN2Z180MiIgY2xhc3M9InN0MCIgeDE9IjI1NS4zIiB5MT0iMjA5LjgiIHgyPSIyNTUuMyIgeTI9IjI3NyIvPg0KCTxsaW5lIGlkPSJzdmdfNDMiIGNsYXNzPSJzdDAiIHgxPSI0MTAuMyIgeTE9IjIwOS44IiB4Mj0iNDQ4LjMiIHkyPSIyMDkuOCIvPg0KCTxsaW5lIGlkPSJzdmdfNDQiIGNsYXNzPSJzdDAiIHgxPSI0NjcuNiIgeTE9IjIxMCIgeDI9IjU1My4yIiB5Mj0iMjEwIi8+DQoJPGxpbmUgaWQ9InN2Z180NSIgY2xhc3M9InN0MCIgeDE9IjU3NS4zIiB5MT0iMjEwIiB4Mj0iNjY5LjIiIHkyPSIyMTAiLz4NCgk8bGluZSBpZD0ic3ZnXzQ2IiBjbGFzcz0ic3QwIiB4MT0iNDk4LjciIHkxPSIyMDkuOCIgeDI9IjQ5OC43IiB5Mj0iMjc3Ii8+DQoJPGxpbmUgaWQ9InN2Z180NyIgY2xhc3M9InN0MCIgeDE9IjUzMiIgeTE9Ijg4LjciIHgyPSI1MzIiIHkyPSIxNzIiLz4NCgk8bGluZSBpZD0ic3ZnXzQ4IiBjbGFzcz0ic3QwIiB4MT0iNDU4LjEiIHkxPSIxNzIiIHgyPSI1NDQiIHkyPSIxNzIiLz4NCgk8bGluZSBpZD0ic3ZnXzQ5IiBjbGFzcz0ic3QwIiB4MT0iNjE0LjgiIHkxPSI4OC43IiB4Mj0iNjE0LjgiIHkyPSIxNzIiLz4NCgk8bGluZSBpZD0ic3ZnXzUwIiBjbGFzcz0ic3QwIiB4MT0iNjU2LjQiIHkxPSIxNzIiIHgyPSI2NjkuMiIgeTI9IjE3MiIvPg0KCTxsaW5lIGlkPSJzdmdfNTEiIGNsYXNzPSJzdDAiIHgxPSI1NTciIHkxPSIxNzIiIHgyPSI1ODAiIHkyPSIxNzIiLz4NCgk8bGluZSBpZD0ic3ZnXzUyIiBjbGFzcz0ic3QwIiB4MT0iNTk3IiB5MT0iMTcyIiB4Mj0iNjM0LjIiIHkyPSIxNzIiLz4NCgk8bGluZSBpZD0ic3ZnXzU0IiBjbGFzcz0ic3QwIiB4MT0iNTY3IiB5MT0iMTcyIiB4Mj0iNTY3IiB5Mj0iMTM1Ii8+DQoJPGxpbmUgaWQ9InN2Z181NSIgY2xhc3M9InN0MCIgeDE9IjU3NyIgeTE9Ijg4LjciIHgyPSI1NzciIHkyPSI5NyIvPg0KCTxsaW5lIGlkPSJzdmdfNTYiIGNsYXNzPSJzdDAiIHgxPSI1NzciIHkxPSIxMDciIHgyPSI1NzciIHkyPSIxMjAiLz4NCgk8bGluZSBpZD0ic3ZnXzU3IiBjbGFzcz0ic3QwIiB4MT0iNTY3IiB5MT0iMTYwIiB4Mj0iNTgwIiB5Mj0iMTYwIi8+DQoJPGxpbmUgaWQ9InN2Z181OCIgY2xhc3M9InN0MCIgeDE9IjU5NCIgeTE9IjE2MCIgeDI9IjYxNC44IiB5Mj0iMTYwIi8+DQoJPGxpbmUgaWQ9InN2Z181OSIgY2xhc3M9InN0MCIgeDE9IjU3NyIgeTE9IjExMiIgeDI9IjYxNSIgeTI9IjExMiIvPg0KCTxsaW5lIGlkPSJzdmdfNjAiIGNsYXNzPSJzdDAiIHgxPSI1NjciIHkxPSIxMzUiIHgyPSI2MTQuOCIgeTI9IjEzNSIvPg0KCTxnIGlkPSJzdmdfNzAiPg0KCQk8cmVjdCBpZD0ic3ZnXzYyIiB4PSIyMTkiIHk9IjEyOSIgY2xhc3M9InN0MCIgd2lkdGg9Ijc2IiBoZWlnaHQ9IjM2Ii8+DQoJCTxsaW5lIGlkPSJzdmdfNjMiIGNsYXNzPSJzdDAiIHgxPSIyMTkuNCIgeTE9IjE0NyIgeDI9IjI5NS40IiB5Mj0iMTQ3Ii8+DQoJCTxsaW5lIGlkPSJzdmdfNjQiIGNsYXNzPSJzdDAiIHgxPSIyMjciIHkxPSIxMjkiIHgyPSIyMjciIHkyPSIxNjQuNyIvPg0KCQk8bGluZSBpZD0ic3ZnXzY1IiBjbGFzcz0ic3QwIiB4MT0iMjM1IiB5MT0iMTI5IiB4Mj0iMjM1IiB5Mj0iMTY1Ii8+DQoJCTxsaW5lIGlkPSJzdmdfNjYiIGNsYXNzPSJzdDAiIHgxPSIyNDMiIHkxPSIxMjkiIHgyPSIyNDMiIHkyPSIxNjQuOCIvPg0KCQk8bGluZSBpZD0ic3ZnXzY3IiBjbGFzcz0ic3QwIiB4MT0iMjUxIiB5MT0iMTI4LjgiIHgyPSIyNTEiIHkyPSIxNjQuNyIvPg0KCQk8bGluZSBpZD0ic3ZnXzY4IiBjbGFzcz0ic3QwIiB4MT0iMjU5IiB5MT0iMTI5IiB4Mj0iMjU5IiB5Mj0iMTY0LjgiLz4NCgkJPGxpbmUgaWQ9InN2Z182OSIgY2xhc3M9InN0MCIgeDE9IjI3NyIgeTE9IjEyOSIgeDI9IjI3NyIgeTI9IjE2NS4xIi8+DQoJPC9nPg0KCTxnIGlkPSJzdmdfNzkiIHRyYW5zZm9ybT0icm90YXRlKC05MCA3MDUuNzI1IDE5My4xMzgpIj4NCgkJDQoJCQk8cmVjdCBpZD0ic3ZnXzcxIiB4PSI3NTAuNSIgeT0iOTIuMiIgdHJhbnNmb3JtPSJtYXRyaXgoLTIuNTM1MTgyZS0wNiAtMSAxIC0yLjUzNTE4MmUtMDYgNjM4LjM0NTggODk4LjczMDkpIiBjbGFzcz0ic3QwIiB3aWR0aD0iMzYiIGhlaWdodD0iNzYiLz4NCgkJPGxpbmUgaWQ9InN2Z183MiIgY2xhc3M9InN0MCIgeDE9IjczMC45IiB5MT0iMTMwLjIiIHgyPSI4MDYuOSIgeTI9IjEzMC4yIi8+DQoJCTxsaW5lIGlkPSJzdmdfNzMiIGNsYXNzPSJzdDAiIHgxPSI3MzguNSIgeTE9IjExMi4yIiB4Mj0iNzM4LjUiIHkyPSIxNDcuOSIvPg0KCQk8bGluZSBpZD0ic3ZnXzc0IiBjbGFzcz0ic3QwIiB4MT0iNzQ2LjUiIHkxPSIxMTIuMiIgeDI9Ijc0Ni41IiB5Mj0iMTQ4LjIiLz4NCgkJPGxpbmUgaWQ9InN2Z183NSIgY2xhc3M9InN0MCIgeDE9Ijc1NC41IiB5MT0iMTEyLjIiIHgyPSI3NTQuNSIgeTI9IjE0OCIvPg0KCQk8bGluZSBpZD0ic3ZnXzc2IiBjbGFzcz0ic3QwIiB4MT0iNzYyLjUiIHkxPSIxMTIiIHgyPSI3NjIuNSIgeTI9IjE0Ny45Ii8+DQoJCTxsaW5lIGlkPSJzdmdfNzciIGNsYXNzPSJzdDAiIHgxPSI3NzAuNSIgeTE9IjExMi4yIiB4Mj0iNzcwLjUiIHkyPSIxNDgiLz4NCgkJPGxpbmUgaWQ9InN2Z183OCIgY2xhc3M9InN0MCIgeDE9Ijc4OC41IiB5MT0iMTEyLjIiIHgyPSI3ODguNSIgeTI9IjE0OC4zIi8+DQoJPC9nPg0KPC9nPg0KPC9zdmc+DQo=",
                669.0, 277.0, 0.0, 0.0
        )))
    );
    private final List<MapObjectData> mapObjects = List.of(
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(0.0, 0.0, 100.0, 77.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(0.0, 77.0, 100.0, 44.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(0.0, 121.0, 100.0, 89.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(0.0, 210.0, 100.0, 77.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(161.0, 0.0, 126.0, 37.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(161.0, 37.0, 126.0, 40.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(161.0, 77.0, 126.0, 46.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(161.0, 210.0, 94.0, 67.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.STAIRS,
            new InfoCreateSchema(
                List.of(), "null", "null"
            ),
            List.of(new BoundingBoxSchema(212.0, 123.0, 95.0, 49.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(255.0, 210.0, 155.0, 67.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(307.0, 123.0, 103.0, 49.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(410.0, 89.0, 122.0, 83.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(410.0, 210.0, 89.0, 67.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "room_name", "room_descr"
            ),
            List.of(new BoundingBoxSchema(499.0, 210.0, 170.0, 67.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.ROOM,
            new InfoCreateSchema(
                List.of(), "restroom_name", "restroom_descr"
            ),
            List.of(new BoundingBoxSchema(532.0, 89.0, 83.0, 83.0))
        )),
        new MapObjectData(1, new MapObjectCreateSchema(
            MapObjectType.STAIRS,
            new InfoCreateSchema(
                List.of(), "null", "null"
            ),
            List.of(new BoundingBoxSchema(615.0, 89.0, 54.0, 83.0))
        ))
    );
    private final List<OutdoorObjectCreateSchema> outdoorObjects = List.of(
        new OutdoorObjectCreateSchema(
            OutdoorObjectType.SHOP,
            53.207851, 50.124784,
            new InfoCreateSchema(
                List.of(
                "https://avatars.mds.yandex.net/get-altay/8075227/2a00000185beafa7b10326fa38e4c07bf0a3/XXXL"
                ),
                "magnit_shop_name",
                "magnit_shop_descr"
            )
        ),
        new OutdoorObjectCreateSchema(
            OutdoorObjectType.CAFE,
            53.207305, 50.128367,
            new InfoCreateSchema(
                List.of(
                    "https://avatars.mds.yandex.net/get-altay/1871013/2a0000016a1b39f4c5b7e4099539959da020/XXXL",
                    "https://avatars.mds.yandex.net/get-altay/859900/2a0000015f52007fd6f9a3e6271549eb7b83/XXXL"
                ),
                "dodo_cafe_name",
                "dodo_cafe_descr"
            )
        )
    );

    private final MapBuildingService buildingService;
    private final MapDomainService domainService;
    private final MapObjectService mapObjectService;
    private final OutdoorObjectService outdoorObjectService;

    public InitialMapDataCreator(
        MapBuildingService buildingService,
        MapDomainService domainService,
        MapObjectService mapObjectService,
        OutdoorObjectService outdoorObjectService
    ) {
        this.buildingService = buildingService;
        this.domainService = domainService;
        this.mapObjectService = mapObjectService;
        this.outdoorObjectService = outdoorObjectService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= buildings.size(); ++i) {
            if (buildingService.getById(i).isEmpty()) {
                buildingService.create(buildings.get(i - 1));
            }
        }

        for (int i = 1; i <= domains.size(); ++i) {
            if (domainService.getById(i).isEmpty()) {
                var domain = domains.get(i - 1);
                domainService.create(domain.buildingId, domain.schema);
            }
        }

        for (int i = 1; i <= mapObjects.size(); ++i) {
            if (mapObjectService.getById(i).isEmpty()) {
                var mapObject = mapObjects.get(i - 1);
                mapObjectService.create(mapObject.domainId, mapObject.schema);
            }
        }

        for (int i = 1; i <= outdoorObjects.size(); ++i) {
            if (outdoorObjectService.getById(i).isEmpty()) {
                outdoorObjectService.create(outdoorObjects.get(i - 1));
            }
        }
    }
}
