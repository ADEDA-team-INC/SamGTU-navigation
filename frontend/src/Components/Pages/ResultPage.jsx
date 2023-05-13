import React, { useEffect, useState, useRef } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestSearch } from '../../redux/mainReducer'
import { ObjectList } from '../../Components/cards/ObjectsList'

const ResultPage = ({ requestSearch, search, isFetching, t, info }) => {
    const [result, setResult] = useState([])

    useEffect(() => {
        requestSearch(info)
    }, [])

    useEffect(() => {
        if (
            search.mapBuildings.length == 0 &&
            search.mapObjects.length == 0 &&
            search.outdoorObjects.length == 0
        ) {
            setResult([])
        } else if (
            search.mapBuildings.length == 0 &&
            search.mapObjects.length == 0
        ){
            setResult(search.outdoorObjects)
        } else if (
            search.mapBuildings.length == 0 
        ) {
            setResult(search.mapObjects)
        } else {
            setResult(search.mapBuildings)
        }
    }, [search])

    if (isFetching) {
        return (
            <div style={{ color: '#000', alignSelf: 'center' }}>
                <Back />
                <p>
                    Загрузка
                </p>
            </div>
        )
    }

    return (
        <>
            {result.length > 0 ? <div style={{ color: '#000' }}>
                <Back />
                <ObjectList objectList={result} />
            </div> : <div style={{ color: '#000' }}>
                <Back />
                {t('searching.empty')}
            </div>}
        </>
    )
}

const mapStateToProps = (state) => ({
    search: state.main.search,
    isFetching: state.main.isFetching
})

export const ResultPageContainer = connect(mapStateToProps, { requestSearch })(ResultPage)