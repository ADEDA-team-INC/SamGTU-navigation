import React from 'react'
import { NavLink } from 'react-router-dom'

export const HomePage = ({ }) => {
    return (
        <div className='home'>
            <ul>
                <li>
                    <NavLink>
                        Кафе
                    </NavLink>
                </li>
                <li>
                    <NavLink to={"/buildings"}>
                        Корпуса
                    </NavLink>
                </li>
                <li>
                    <NavLink>
                        Достопримечательности
                    </NavLink>
                </li>
                <li>
                    <NavLink>
                        Магазины
                    </NavLink>
                </li>
            </ul>
        </div>
    )
}