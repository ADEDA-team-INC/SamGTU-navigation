import React from 'react'
import { Infobar } from '../Infobar/Infobar'
import { Domain } from '../UI/domains/domain'
import { Zoom } from '../UI/zoom/zoom'
import Search from '../Search/Search';
import initialDetails from '../../data/initialDetails';

export const MainPage = props => {
    return (
        <div className='main'>
            <div className='main__left__container'>
                <Search details={initialDetails} />
            </div>
            <div className='main__top__container'>
                <Infobar />
            </div>
            <div className='main__right__container'>
                <Domain />
                <Zoom />
            </div>
        </div>
    )
}