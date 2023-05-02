import React, { useState } from 'react';

import Scroll from '../UI/scroll/Scroll';
import SearchList from './SearchList';
import s from "./search.module.scss";
import pointer from '../../assets/img/point.svg'
import up from '../../assets/img/up.svg'


function Search({ details, addMap, translation, setTranslation}) {
    const [searchField, setSearchField] = useState("");
    const [ifPointer, setIfPointer] = useState(false);

    const filteredBuildings = details.korpusa.filter(
        building => {
            return (
                building
                    .name
                    .toLowerCase()
                    .includes(searchField.toLowerCase()) ||
                building
                    .adress
                    .toLowerCase()
                    .includes(searchField.toLowerCase())
            );
        }
    );

    const handleChange = e => {
        setSearchField(e.target.value);
        setIfPointer(false);
    };

    const changeLanguage = (language) => {
        setTranslation.changeLanguage(language)
    }

    return (
        <section className={!ifPointer ? s.search : s.search__active}>
            <input type="search" className={s.search__input} placeholder={translation("Search")}
                onChange={handleChange} />
            <Scroll>
                <div className={s.search__container}>
                    <h1 className={s.search__title}>
                        {translation('results')}:
                    </h1>
                    <a href="##" onClick={
                        ifPointer ? () => (setIfPointer(false)) : () => (setIfPointer(true))
                    } >
                        <img className={!ifPointer ? s.search__pointer : s.off} src={pointer} />
                        <img className={ifPointer ? s.search__up : s.off} src={up} />
                    </a>
                </div>
                <>
                    {filteredBuildings.length > 0 ? <SearchList filteredBuildings={filteredBuildings} addMap={addMap} translation = {translation}/> : <div className={s.nothing__text}> {translation('nothing')} </div>}
                </>
            </Scroll>


            <button onClick={() => changeLanguage('en')}>EN</button>
            <button onClick={() => changeLanguage('ru')}>RU</button>
        </section>

    );
}

export default Search;