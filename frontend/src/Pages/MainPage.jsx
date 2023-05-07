import React, { useEffect } from "react";

import { Infobar } from "../Components/UI/Infobar/Infobar";
import { Domain } from "../Components/UI/domains/domain";
import { useTranslation } from "react-i18next";
import { requestBuildings, requestOutdoorObjects } from "../redux/mainReducer"
import { connect } from 'react-redux'
import { Zoom } from '../Components/UI/zoom/zoom'
import { Buildings } from "../Components/cards/BuildingsList";
import { OutdoorObjects } from "../Components/cards/OutdoorObjectList";

const MainPage = ({ requestBuildings, requestOutdoorObjects, buildings, isFetching, outdoorObjects }) => {

    const { t, i18n } = useTranslation()

    useEffect(() => {
        requestBuildings()
        requestOutdoorObjects()
    }, [])

    if (isFetching) {
        return (
            <div style={{ color: '#000' }}>Загрузка</div>
        )
    }

    return (
        <div className="main">
            <div>
                <div className="main__left__container">
                    {/* <Buildings buildings={buildings} />
                    <OutdoorObjects outdoorObjects={outdoorObjects} /> */}
                </div>
                <div className="main__top__container">
                    <Infobar />
                </div>
                <div className="main__right__container">
                    <Domain />
                    <Zoom />
                </div>
            </div>
        </div>
    );
};

const mapStateToProps = (state) => ({
    buildings: state.main.buildings,
    outdoorObjects: state.main.outdoorObjects,
    isFetching: state.main.isFetching
})

export const MainPageContainer = connect(mapStateToProps, {requestBuildings, requestOutdoorObjects})(MainPage)