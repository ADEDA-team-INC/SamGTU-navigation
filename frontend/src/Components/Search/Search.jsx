import React, { useState } from 'react';
import Scroll from '../UI/scroll/Scroll';
import SearchList from './SearchList';
import s from "./search.module.scss";
import pointer from '../../assets/img/point.svg'
import up from '../../assets/img/up.svg'

function Search({ details }) {
    const [searchField, setSearchField] = useState("");
    const [ifPointer, setIfPointer] = useState(false);

    const filteredBuildings = details.filter(
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

    return (
        <section className={!ifPointer ? s.search : s.search__active}>
            <input type="search" className={s.search__input} placeholder="Поиск"
                onChange={handleChange} />
            <Scroll>
                <div className={s.search__container}>
                    <h1 className={s.search__title}>
                        Результаты:
                    </h1>
                    <a href="##" onClick={
                        ifPointer ? () => (setIfPointer(false)) : () => (setIfPointer(true))
                    } >
                        <img className={!ifPointer ? s.search__pointer : s.off} src={pointer} />
                        <img className={ifPointer ? s.search__up : s.off} src={up} />
                    </a>
                </div>
                <>
                    {filteredBuildings.length > 0 ? <SearchList filteredBuildings={filteredBuildings} /> : <div className={s.nothing__text}> Ничего не найдено </div>}
                </>
            </Scroll>
        </section>

    );
}

export default Search;