import React from 'react'
import { Card } from './SmallCard'

export const OutdoorObjects = ({ outdoorObjects }) => {
    return (
        <div>
            {outdoorObjects.map(
                outdoorObject => (
                    <Card key = {outdoorObjects.id} info = {outdoorObjects.info} />
                )
            )}
        </div>
    )
}