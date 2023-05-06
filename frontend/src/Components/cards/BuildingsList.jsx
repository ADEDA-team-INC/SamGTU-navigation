import React from 'react'
import { Card } from './Card'

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