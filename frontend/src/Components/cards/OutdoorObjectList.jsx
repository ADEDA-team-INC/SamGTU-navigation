import React from 'react'
import { Card } from './SmallCard'

export const OutdoorObjects = ({ outdoorObjects }) => {
    return (
        <div>
            {outdoorObjects.map(
                outdoorObject => (
                    <Card key = {outdoorObject.id} info = {outdoorObject.info} />
                )
            )}
        </div>
    )
}