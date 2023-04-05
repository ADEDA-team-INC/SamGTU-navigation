import React, { useEffect } from 'react'
import { FabricJSCanvas, useFabricJSEditor } from 'fabricjs-react'

import { Infobar } from '../Infobar/Infobar'
import { Domain } from '../UI/domains/domain'
import { Zoom } from '../UI/zoom/zoom'
import Search from '../Search/Search';
import initialDetails from '../../data/initialDetails';

export const MainPage = props => {

    const { editor, onReady } = useFabricJSEditor()

    const onAddMap = () =>{
        editor.addCircle()
    }

    return (
        <div className='main'>
            <FabricJSCanvas className="sample-canvas" onReady={onReady} />
            <div>
                <div className='main__left__container'>
                    <Search details={initialDetails} addMap ={onAddMap}/>
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