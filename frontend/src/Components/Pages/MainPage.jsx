import React, { useEffect } from "react";

import { Infobar } from "../Infobar/Infobar";
import { Domain } from "../UI/domains/domain";
import Search from "../Search/Search";
import initialDetails from "../../data/initialDetails";
import { useTranslation } from "react-i18next";
import { mainAPI } from "../../api/api";
import { requestBuildings } from "../../redux/mainReducer";
import { connect } from 'react-redux'

const MainPage = ({ requestBuildings, buildings, isFetching}) => {

    const { t, i18n } = useTranslation()
    useEffect(() => {
        requestBuildings()
    }, [])

    if (isFetching) {
        return (
            <div>Загрузка</div>
        )
    }
    return (
        <div className="main">
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

const mapStateToProps = (state) => ({
    buildings: state.main.buildings,
    isFetching: state.main.isFetching
  }) 

export const MainPageContainer = connect(mapStateToProps, { requestBuildings })(MainPage)