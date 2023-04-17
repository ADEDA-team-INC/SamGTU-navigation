package org.adeda.samgtu_navigation.map.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.model.MapDomain;
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

import java.util.List;

@Component
public class InitialDataCreator implements ApplicationRunner {
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
                "data:image/svg+xml,%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22utf-8%22%3F%3E%0D%0A%3C%21--%20Generator%3A%20Adobe%20Illustrator%2026.0.3%2C%20SVG%20Export%20Plug-In%20.%20SVG%20Version%3A%206.00%20Build%200%29%20%20--%3E%0D%0A%3Csvg%20version%3D%221.1%22%20id%3D%22%D0%A1%D0%BB%D0%BE%D0%B9_1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20x%3D%220px%22%20y%3D%220px%22%0D%0A%09%20viewBox%3D%220%200%20669%20277%22%20style%3D%22enable-background%3Anew%200%200%20669%20277%3B%22%20xml%3Aspace%3D%22preserve%22%3E%0D%0A%3Cstyle%20type%3D%22text%2Fcss%22%3E%0D%0A%09.st0%7Bfill%3Anone%3Bstroke%3A%23000000%3B%7D%0D%0A%3C%2Fstyle%3E%0D%0A%3Cg%3E%0D%0A%09%3Cline%20id%3D%22svg_3%22%20class%3D%22st0%22%20x1%3D%22-63%22%20y1%3D%22-63%22%20x2%3D%22-63%22%20y2%3D%22-63%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_2%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%220%22%20x2%3D%220.2%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_5%22%20class%3D%22st0%22%20x1%3D%220%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%220%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_6%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%220%22%20x2%3D%22287%22%20y2%3D%22123.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_7%22%20class%3D%22st0%22%20x1%3D%22287.3%22%20y1%3D%22123%22%20x2%3D%22410.5%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_8%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22122.7%22%20x2%3D%22410%22%20y2%3D%2288.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_9%22%20class%3D%22st0%22%20x1%3D%22409.3%22%20y1%3D%2288.6%22%20x2%3D%22669.4%22%20y2%3D%2288.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_10%22%20class%3D%22st0%22%20x1%3D%22669.3%22%20y1%3D%2289%22%20x2%3D%22669.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_11%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22277%22%20x2%3D%22669%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_12%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%220.5%22%20x2%3D%22160.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_13%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2237%22%20x2%3D%22216.9%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_14%22%20class%3D%22st0%22%20x1%3D%22236.4%22%20y1%3D%2237%22%20x2%3D%22287.1%22%20y2%3D%2237%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_4%22%20class%3D%22st0%22%20x1%3D%22286.6%22%20y1%3D%2277%22%20x2%3D%22160.8%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_15%22%20class%3D%22st0%22%20x1%3D%22287%22%20y1%3D%22123%22%20x2%3D%22161%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_16%22%20class%3D%22st0%22%20x1%3D%22160.8%22%20y1%3D%2236.6%22%20x2%3D%22160.8%22%20y2%3D%2252%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_17%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2264%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_18%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%2277%22%20x2%3D%22161%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_19%22%20class%3D%22st0%22%20x1%3D%22160.9%22%20y1%3D%22105%22%20x2%3D%22160.9%22%20y2%3D%22123%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_20%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%220.1%22%20x2%3D%22100%22%20y2%3D%2218.6%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_21%22%20class%3D%22st0%22%20x1%3D%22100.5%22%20y1%3D%2231.2%22%20x2%3D%22100.5%22%20y2%3D%2295%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_22%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%2277%22%20x2%3D%22-0.1%22%20y2%3D%2277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_24%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22172.2%22%20x2%3D%22307.4%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_25%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22122.5%22%20x2%3D%22212%22%20y2%3D%22139.4%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_26%22%20class%3D%22st0%22%20x1%3D%22212%22%20y1%3D%22153.6%22%20x2%3D%22212%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_27%22%20class%3D%22st0%22%20x1%3D%22307%22%20y1%3D%22123%22%20x2%3D%22307%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_28%22%20class%3D%22st0%22%20x1%3D%22409.8%22%20y1%3D%22121.9%22%20x2%3D%22409.8%22%20y2%3D%22172.3%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_29%22%20class%3D%22st0%22%20x1%3D%22338.8%22%20y1%3D%22171.6%22%20x2%3D%22437.1%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_30%22%20class%3D%22st0%22%20x1%3D%22307.1%22%20y1%3D%22172.2%22%20x2%3D%22323.5%22%20y2%3D%22172.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_31%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22107.8%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_32%22%20class%3D%22st0%22%20x1%3D%220.2%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22121%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_33%22%20class%3D%22st0%22%20x1%3D%22100%22%20y1%3D%22121%22%20x2%3D%22100%22%20y2%3D%22182%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_34%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22195.1%22%20x2%3D%2299.6%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_35%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22241.8%22%20x2%3D%2299.6%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_36%22%20class%3D%22st0%22%20x1%3D%2299.6%22%20y1%3D%22210.2%22%20x2%3D%220.2%22%20y2%3D%22210.2%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_37%22%20class%3D%22st0%22%20x1%3D%22160.4%22%20y1%3D%22210%22%20x2%3D%22160.4%22%20y2%3D%22227%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_38%22%20class%3D%22st0%22%20x1%3D%22161%22%20y1%3D%22241.8%22%20x2%3D%22161%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_39%22%20class%3D%22st0%22%20x1%3D%22410%22%20y1%3D%22210%22%20x2%3D%22410%22%20y2%3D%22276.5%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_40%22%20class%3D%22st0%22%20x1%3D%22389.2%22%20y1%3D%22209.8%22%20x2%3D%22410.4%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_41%22%20class%3D%22st0%22%20x1%3D%22160%22%20y1%3D%22209.8%22%20x2%3D%22367.6%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_42%22%20class%3D%22st0%22%20x1%3D%22255.3%22%20y1%3D%22209.8%22%20x2%3D%22255.3%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_43%22%20class%3D%22st0%22%20x1%3D%22410.3%22%20y1%3D%22209.8%22%20x2%3D%22448.3%22%20y2%3D%22209.8%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_44%22%20class%3D%22st0%22%20x1%3D%22467.6%22%20y1%3D%22210%22%20x2%3D%22553.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_45%22%20class%3D%22st0%22%20x1%3D%22575.3%22%20y1%3D%22210%22%20x2%3D%22669.2%22%20y2%3D%22210%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_46%22%20class%3D%22st0%22%20x1%3D%22498.7%22%20y1%3D%22209.8%22%20x2%3D%22498.7%22%20y2%3D%22277%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_47%22%20class%3D%22st0%22%20x1%3D%22532%22%20y1%3D%2288.7%22%20x2%3D%22532%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_48%22%20class%3D%22st0%22%20x1%3D%22458.1%22%20y1%3D%22172%22%20x2%3D%22544%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_49%22%20class%3D%22st0%22%20x1%3D%22614.8%22%20y1%3D%2288.7%22%20x2%3D%22614.8%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_50%22%20class%3D%22st0%22%20x1%3D%22656.4%22%20y1%3D%22172%22%20x2%3D%22669.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_51%22%20class%3D%22st0%22%20x1%3D%22557%22%20y1%3D%22172%22%20x2%3D%22580%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_52%22%20class%3D%22st0%22%20x1%3D%22597%22%20y1%3D%22172%22%20x2%3D%22634.2%22%20y2%3D%22172%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_54%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22172%22%20x2%3D%22567%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_55%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%2288.7%22%20x2%3D%22577%22%20y2%3D%2297%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_56%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22107%22%20x2%3D%22577%22%20y2%3D%22120%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_57%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22160%22%20x2%3D%22580%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_58%22%20class%3D%22st0%22%20x1%3D%22594%22%20y1%3D%22160%22%20x2%3D%22614.8%22%20y2%3D%22160%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_59%22%20class%3D%22st0%22%20x1%3D%22577%22%20y1%3D%22112%22%20x2%3D%22615%22%20y2%3D%22112%22%2F%3E%0D%0A%09%3Cline%20id%3D%22svg_60%22%20class%3D%22st0%22%20x1%3D%22567%22%20y1%3D%22135%22%20x2%3D%22614.8%22%20y2%3D%22135%22%2F%3E%0D%0A%09%3Cg%20id%3D%22svg_70%22%3E%0D%0A%09%09%3Crect%20id%3D%22svg_62%22%20x%3D%22219%22%20y%3D%22129%22%20class%3D%22st0%22%20width%3D%2276%22%20height%3D%2236%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_63%22%20class%3D%22st0%22%20x1%3D%22219.4%22%20y1%3D%22147%22%20x2%3D%22295.4%22%20y2%3D%22147%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_64%22%20class%3D%22st0%22%20x1%3D%22227%22%20y1%3D%22129%22%20x2%3D%22227%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_65%22%20class%3D%22st0%22%20x1%3D%22235%22%20y1%3D%22129%22%20x2%3D%22235%22%20y2%3D%22165%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_66%22%20class%3D%22st0%22%20x1%3D%22243%22%20y1%3D%22129%22%20x2%3D%22243%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_67%22%20class%3D%22st0%22%20x1%3D%22251%22%20y1%3D%22128.8%22%20x2%3D%22251%22%20y2%3D%22164.7%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_68%22%20class%3D%22st0%22%20x1%3D%22259%22%20y1%3D%22129%22%20x2%3D%22259%22%20y2%3D%22164.8%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_69%22%20class%3D%22st0%22%20x1%3D%22277%22%20y1%3D%22129%22%20x2%3D%22277%22%20y2%3D%22165.1%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%09%3Cg%20id%3D%22svg_79%22%20transform%3D%22rotate%28-90%20705.725%20193.138%29%22%3E%0D%0A%09%09%0D%0A%09%09%09%3Crect%20id%3D%22svg_71%22%20x%3D%22750.5%22%20y%3D%2292.2%22%20transform%3D%22matrix%28-2.535182e-06%20-1%201%20-2.535182e-06%20638.3458%20898.7309%29%22%20class%3D%22st0%22%20width%3D%2236%22%20height%3D%2276%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_72%22%20class%3D%22st0%22%20x1%3D%22730.9%22%20y1%3D%22130.2%22%20x2%3D%22806.9%22%20y2%3D%22130.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_73%22%20class%3D%22st0%22%20x1%3D%22738.5%22%20y1%3D%22112.2%22%20x2%3D%22738.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_74%22%20class%3D%22st0%22%20x1%3D%22746.5%22%20y1%3D%22112.2%22%20x2%3D%22746.5%22%20y2%3D%22148.2%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_75%22%20class%3D%22st0%22%20x1%3D%22754.5%22%20y1%3D%22112.2%22%20x2%3D%22754.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_76%22%20class%3D%22st0%22%20x1%3D%22762.5%22%20y1%3D%22112%22%20x2%3D%22762.5%22%20y2%3D%22147.9%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_77%22%20class%3D%22st0%22%20x1%3D%22770.5%22%20y1%3D%22112.2%22%20x2%3D%22770.5%22%20y2%3D%22148%22%2F%3E%0D%0A%09%09%3Cline%20id%3D%22svg_78%22%20class%3D%22st0%22%20x1%3D%22788.5%22%20y1%3D%22112.2%22%20x2%3D%22788.5%22%20y2%3D%22148.3%22%2F%3E%0D%0A%09%3C%2Fg%3E%0D%0A%3C%2Fg%3E%0D%0A%3C%2Fsvg%3E%0D%0A",
                669.0, 0.0, 0.0
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

    public InitialDataCreator(
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
