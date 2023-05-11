import React, { useEffect } from "react";
import { useState } from 'react';

import { Infobar } from "../Components/UI/Infobar/Infobar";
import { Domain } from "../Components/UI/domains/domain";
import { useTranslation } from "react-i18next";
import { requestBuildings, requestOutdoorObjects } from "../redux/mainReducer"
import { connect } from 'react-redux'
import { Zoom } from '../Components/UI/zoom/zoom'
import Modal from "../Components/UI/Modal/Modal";

export const MainPage = ({ }) => {
    const [modalActive, setModalActive] = useState(false)
    const { t, i18n } = useTranslation();
    const changeLanguage = (language) => {
        i18n.changeLanguage(language);
    };

    return (
        <div className="main">
            <Modal active={modalActive} setActive={setModalActive}>
                <button style={{backgroundColor: '#f1f1f1'}} className="ru" onClick={() => changeLanguage("ru")}>Русский</button>
                <button style={{backgroundColor: '#f1f1f1'}} className="en" onClick={() => changeLanguage("en")}>English</button>
            </Modal>
            <div>
                <div className="main__left__container">
                </div>
                <div className="main__top__container">
                    <Infobar />
                </div>
                <div className="main__right__container">
                    <Domain />
                    <Zoom />
                    <button style={{backgroundColor: '#f1f1f1', color: 'black'}} className="language" onClick={() => setModalActive(true)}>&#9774;</button>
                </div>
            </div>
        </div>
    );
};