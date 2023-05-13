import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestOutdoorObjects } from '../../redux/mainReducer'
import { ObjectList } from '../cards/ObjectsList'
import { SearchBar } from '../UI/SearchBar'

const CafePage = ({ requestOutdoorObjects, outdoorObjects, isFetching, t}) => {

    const cafe = outdoorObjects.filter(object => object.type == "CAFE")

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
            <ObjectList objectList={cafe} />
        </div>
    )
}

const mapStateToProps = (state) => ({
    outdoorObjects: state.main.outdoorObjects,
    isFetching: state.main.isFetching
})

export const CafePageContainer = connect(mapStateToProps, { requestOutdoorObjects })(CafePage)