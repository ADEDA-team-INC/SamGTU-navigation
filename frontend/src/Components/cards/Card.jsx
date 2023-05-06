import React from 'react'

export const Card = ({ info }) => {
    return (
        <div style = {{color: '#000', cursor: 'pointer', border: '1px solid #000', padding: 10}}>
            <img src={info.images[0]} style={{maxWidth: 300}} />
            <h3>
                {info.displayName}
            </h3>
            <p>
                {info.displayDescription}
            </p>
        </div>
    )
}