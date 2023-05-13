import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestOutdoorObjects } from '../../redux/mainReducer'
import { ObjectList } from '../cards/ObjectsList'
import { SearchBar } from '../UI/SearchBar'

const ShopPage = ({ requestOutdoorObjects, outdoorObjects, isFetching, t }) => {

    const shops = outdoorObjects.filter(object => object.type == "SHOP")

    useEffect(() => {
        requestOutdoorObjects()
    }, [])

    if (isFetching) {
        return (
            <div style={{ color: '#000', alignSelf: 'center' }}>
                <Back />
                <SearchBar t = {t}/>
                <p>
                    Загрузка
                </p>
            </div>
        )
    }

    return (
        <div style={{ color: '#000' }}>
            <Back />
            <SearchBar t = {t}/>
            <ObjectList objectList={shops} />
        </div>
    )
}

const mapStateToProps = (state) => ({
    outdoorObjects: state.main.outdoorObjects,
    isFetching: state.main.isFetching
})

export const ShopPageContainer = connect(mapStateToProps, { requestOutdoorObjects })(ShopPage)