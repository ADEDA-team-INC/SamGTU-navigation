import React from 'react'
import s from './domain.module.scss'

export const Domain = props => {
    return (
        <div className={s.domain}>
            <button className={s.domain__button} onClick={() => console.log('1')}>
                1
            </button>
        </div>
    )
}