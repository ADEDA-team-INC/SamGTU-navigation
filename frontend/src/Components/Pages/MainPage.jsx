import React, { useEffect } from "react";

import { Infobar } from "../Infobar/Infobar";
import { Domain } from "../UI/domains/domain";
import { Zoom } from "../UI/zoom/zoom";
import Search from "../Search/Search";
import { Map } from '../Map/Map'
import initialDetails from "../../data/initialDetails";
import { useTranslation } from "react-i18next";
import { mainAPI } from "../../api/api";

export const MainPage = () => {

    const { t, i18n } = useTranslation()

    mainAPI.getBuildings()

    return (
        <div className="main">
            {/* <Map translation={t} /> */}
            <div>
                <div className="main__left__container">
                    <Search details={initialDetails} translation={t} setTranslation={i18n} />
                </div>
                <div className="main__top__container">
                    <Infobar translation={t} />
                </div>
                <div className="main__right__container">
                    <Domain />
                    {/* <Zoom /> */}
                </div>
            </div>
        </div>
    );
};