import React from 'react'
import { Back } from '../UI/Back'
import { SearchBar } from '../UI/SearchBar'

export const SightsPage = ({t}) => {
    return (
        <div>
            <Back />
            <p style={{color: '#000'}}>
                {t('searching.empty')}
            </p>
        </div>
    )
}