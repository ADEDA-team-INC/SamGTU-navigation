import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { NavLink } from 'react-router-dom'
import { requestBuildings } from '../../redux/mainReducer'
import { ObjectList } from '../cards/ObjectsList'

const BuildingsPage = ({ requestBuildings, buildings, isFetching }) => {

    useEffect(() => {
        requestBuildings()
    }, [])

    if (isFetching) {
        return (
            <div style={{ color: '#000', alignSelf: 'center' }}>Загрузка</div>
        )
    }

    return (
        <div style={{ color: '#000' }}>
            <NavLink to={'/'}>
                Домой
            </NavLink>
            <ObjectList objectList={buildings} />
        </div>
    )
}

const mapStateToProps = (state) => ({
    buildings: state.main.buildings,
    isFetching: state.main.isFetching
})

export const BuildingsPageContainer = connect(mapStateToProps, { requestBuildings })(BuildingsPage)