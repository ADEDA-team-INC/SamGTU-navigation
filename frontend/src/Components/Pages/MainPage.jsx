import React, { useEffect } from 'react'
import { fabric } from 'fabric'

import { Infobar } from '../Infobar/Infobar'
import { Domain } from '../UI/domains/domain'
import { Zoom } from '../UI/zoom/zoom'
import Search from '../Search/Search';
import initialDetails from '../../data/initialDetails';

export const MainPage = props => {

    const onAddMap = (rect) => {
        canvas.add(rect);
        console.log('privet')
    }

    useEffect(() => {
        const canvas = new fabric.Canvas('map', {
            backgroundImage: 'https://img3.akspic.ru/previews/7/4/2/8/6/168247/168247-kosti_3d-igra_v_kosti_3d-azartnaya_igra-pitevaya_igra-kazino-500x.jpg'
        })
        const rect = new fabric.Rect({
            left: 100,
            top: 100,
            fill: 'red',
            width: 20,
            height: 20
        });
        canvas.add(rect);
        onAddMap;
    }, [])

    return (
        <div className='main'>
            <canvas id='map'></canvas>
            <div>
                <div className='main__left__container'>
                    <Search details={initialDetails} addMap={onAddMap} />
                </div>
                <div className='main__top__container'>
                    <Infobar />
                </div>
                <div className='main__right__container'>
                    <Domain />
                    <Zoom />
                </div>
            </div>
        </div>
    )
}