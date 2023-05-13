import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestOutdoorObjects } from '../../redux/mainReducer'
import { ObjectList } from '../cards/ObjectsList'

const ShopPage = ({ requestOutdoorObjects, outdoorObjects, isFetching }) => {

    const shops = outdoorObjects.filter(object => object.type == "SHOP")

    useEffect(() => {
        requestOutdoorObjects()
    }, [])

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
        <div style={{ color: '#000' }}>
            <Back />
            <ObjectList objectList={shops} />
        </div>
    )
}

const mapStateToProps = (state) => ({
    outdoorObjects: state.main.outdoorObjects,
    isFetching: state.main.isFetching
})

export const ShopPageContainer = connect(mapStateToProps, { requestOutdoorObjects })(ShopPage)