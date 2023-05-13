import React from 'react'
import { NavLink } from 'react-router-dom'

export const HomePage = ({ }) => {
    return (
        <div className='home'>
            <ul className='home__list'>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link'>
                        Кафе
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink to={"/buildings"} className='home__list__item__link'>
                        Корпуса
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link'>
                        Места
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link'>
                        Магазины
                    </NavLink>
                </li>
            </ul>
        </div>
    )
}