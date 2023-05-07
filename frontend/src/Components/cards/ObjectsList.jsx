import React from 'react'
import { Card } from './SmallCard'

export const ObjectList = ({ objectList }) => {
    return (
        <div>
            {objectList.map(
                object => (
                    <Card key = {object.id} info = {object.info} />
                )
            )}
        </div>
    )
}