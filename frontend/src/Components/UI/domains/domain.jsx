import React from 'react'
import s from './domain.module.scss'

export const Domain = props => {
    return (
        <div className={s.domain}>
            <div className={s.domain__button} onClick={() => console.log('1')}>
                1
            </div>
            <div className={s.domain__button} onClick={() => console.log('2')}>
                2
            </div>
            <div className={s.domain__button} onClick={() => console.log('3')}>
                3
            </div>
        </div>
    )
}