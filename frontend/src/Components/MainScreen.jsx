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
import { ShopPageContainer } from "./Pages/ShopPage";
import { CafePageContainer } from "./Pages/CafePage";
import { SightsPage } from "./Pages/SightsPage";
import { ResultPageContainer } from "./Pages/ResultPage";
import { SearchBar } from "./UI/SearchBar";

export const MainScreen = ({ }) => {
    const [modalActive, setModalActive] = useState(false)
    const [text, setText] = useState('Ничего')
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
                    }}>{t('languages.ru')}</button>
                    <button style={{ backgroundColor: '#f1f1f1', color: 'black' }} className="en" onClick={() => {
                        setModalActive(false)
                        changeLanguage("en")
                    }}>{t('languages.en')}</button>
                </Modal>
                <div className="main__left__container">
                    <BrowserRouter>
                        <SearchBar t={t} text={text} setText={setText} />
                        <Routes>
                            <Route path='/' element={<HomePage t={t} />} />
                            <Route path="/buildings" element={<BuildingsPageContainer t={t} />} />
                            <Route path="/shops" element={<ShopPageContainer t={t} />} />
                            <Route path="/cafes" element={<CafePageContainer t={t} />} />
                            <Route path="/sights" element={<SightsPage t={t} />} />
                            <Route path="/search" element={<ResultPageContainer t={t} info={text} />} /> 
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