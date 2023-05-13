import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { Back } from '../UI/Back'
import { requestBuildings } from '../../redux/mainReducer'
import { ObjectList } from '../cards/ObjectsList'

const BuildingsPage = ({ requestBuildings, buildings, isFetching, t}) => {

    useEffect(() => {
        requestBuildings()
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
            <ObjectList objectList={buildings} />
        </div>
    )
}

const mapStateToProps = (state) => ({
    buildings: state.main.buildings,
    isFetching: state.main.isFetching
})

export const BuildingsPageContainer = connect(mapStateToProps, { requestBuildings })(BuildingsPage)