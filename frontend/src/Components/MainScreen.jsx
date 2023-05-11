import React from "react";
import { useState } from 'react';
import { useTranslation } from "react-i18next";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import { Infobar } from "./UI/Infobar/Infobar";
import { Domain } from "./UI/domains/domain";
import { Zoom } from './UI/zoom/zoom'
import Modal from "./UI/Modal/Modal";
import { HomePage } from "./Pages/HomePage";
import { BuildingsPageContainer } from "./Pages/BuildingsPage";
import Map from "../Components/map/Map"

export const MainScreen = ({ }) => {
    const [modalActive, setModalActive] = useState(false)
    const { t, i18n } = useTranslation();
    const changeLanguage = (language) => {
        i18n.changeLanguage(language);
    };
    const svgData = 'D:/ЗАГРУЗКИ/Other/9 корпус.svg';

    return (
        <div className="main">
            <Map svgData={svgData} />
            <div>
                <Modal active={modalActive} setActive={setModalActive}>
                    <button style={{ backgroundColor: '#f1f1f1', color: 'black', marginBottom: 10 }} className="ru" onClick={() => {
                        setModalActive(false)
                        changeLanguage("ru")
                    }}>Русский</button>
                    <button style={{ backgroundColor: '#f1f1f1', color: 'black' }} className="en" onClick={() => {
                        setModalActive(false)
                        changeLanguage("en")
                    }}>English</button>
                </Modal>
                <div className="main__left__container">
                    <BrowserRouter>
                        <Routes>
                            <Route path='/' element={<HomePage />} />
                            <Route path="/buildings" element={<BuildingsPageContainer />} />
                        </Routes>
                    </BrowserRouter>
                </div>
                <div className="main__top__container">
                    <Infobar />
                </div>
                <div className="main__right__container">
                    <Domain />
                    <Zoom />
                    <button style={{ backgroundColor: '#f1f1f1', color: 'black' }} className="language" onClick={() => setModalActive(true)}>&#9774;</button>
                </div>
            </div>
        </div>
    );
};