import React from 'react'

export const Card = ({ info }) => {
    return (
        <div style = {{color: '#000', cursor: 'pointer', padding: 12, backgroundColor: '#f1f1f1', borderRadius: 10}}>
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