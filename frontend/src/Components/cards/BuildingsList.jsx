import React from 'react'
import { Card } from './SmallCard'

export const Buildings = ({ buildings }) => {
    return (
        <div>
            {buildings.map(
                building => (
                    <Card key = {building.id} info = {building.info} />
                )
            )}
        </div>
    )
}