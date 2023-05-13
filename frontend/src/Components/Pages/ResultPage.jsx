import React, { useEffect, useState, useRef } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestSearch } from '../../redux/mainReducer'
import { SearchBar } from '../UI/SearchBar'
import { ObjectList } from '../../Components/cards/ObjectsList'

const ResultPage = ({ requestSearch, search, isFetching, t }) => {
    const text = 'Корпус'
    const [result, setResult] = useState([])

    useEffect(() => {
        requestSearch(text)
        setResult(search.mapBuildings)
    }, [setResult])

if (isFetching) {
    return (
        <div style={{ color: '#000', alignSelf: 'center' }}>
            <Back />
            <SearchBar t={t} />
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
            <SearchBar t={t} />
            <ObjectList objectList={result} />
        </div> : <div style={{ color: '#000' }}>
            <Back />
            <SearchBar t={t} />
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