import React, { useState } from 'react';
import Scroll from '../UI/scroll/Scroll';
import SearchList from './SearchList';
import s from "./search.module.scss";

function Search({ details }) {
    const [searchField, setSearchField] = useState("");

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
    };

    return (
        <section className={s.search}>
            <input type="search" className={s.search__input} placeholder="Поиск"
                onChange={handleChange} />
            <Scroll>
                <h1 className={s.search__title}>
                    Результаты
                </h1>
                <>
                    {filteredBuildings.length > 0 ? <SearchList filteredBuildings={filteredBuildings} /> : <div className={s.nothing__text}> Ничего не найдено </div>}
                </>
            </Scroll>
        </section>

    );
}

export default Search;