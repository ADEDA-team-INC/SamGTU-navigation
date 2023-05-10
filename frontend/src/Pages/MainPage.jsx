import React, { useEffect } from "react";
import { useState } from 'react';

import { Infobar } from "../Components/UI/Infobar/Infobar";
import { Domain } from "../Components/UI/domains/domain";
import { useTranslation } from "react-i18next";
import { requestBuildings, requestOutdoorObjects } from "../redux/mainReducer"
import { connect } from 'react-redux'
import { Zoom } from '../Components/UI/zoom/zoom'
import { ObjectList } from "../Components/cards/ObjectsList";
import Modal from "../Modal/Modal";

const MainPage = ({ requestBuildings, requestOutdoorObjects, buildings, isFetching, outdoorObjects }) => {
    const [modalActive, setModalActive] = useState(true)
    const { t, i18n } = useTranslation();
    const changeLanguage = (language) => {
        i18n.changeLanguage(language);
    };

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
                    <ObjectList objectList = {buildings}/>
                    <ObjectList objectList = {outdoorObjects}/>
                    <button className="language" onClick={() => setModalActive(true)}>Сменить язык</button>
                </div>
                <div className="main__top__container">
                    <Infobar />
                </div>
                <div className="main__right__container">
                    <Domain />
                    <Zoom />
                </div>
            </div>
                <Modal active={modalActive} setActive={setModalActive}>
                <button className="ru" onClick={() => changeLanguage("ru")}>Русский</button>
                <button className="en" onClick={() => changeLanguage("en")}>English</button>
                </Modal>
        </div>
    );
};

const mapStateToProps = (state) => ({
    buildings: state.main.buildings,
    outdoorObjects: state.main.outdoorObjects,
    isFetching: state.main.isFetching
})

export const MainPageContainer = connect(mapStateToProps, {requestBuildings, requestOutdoorObjects})(MainPage)