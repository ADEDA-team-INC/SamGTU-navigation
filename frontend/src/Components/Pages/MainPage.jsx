import React from 'react'
import { Domain } from '../UI/domains/domain'
import { Zoom } from '../UI/zoom/zoom'

export const MainPage = props => {
    return (
        <div className='main'>
            <div className='main__right__container'>
                <Domain />
                <Zoom />
            </div>
        </div>
    )
}