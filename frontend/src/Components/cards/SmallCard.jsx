import React from 'react'

export const Card = ({ info }) => {
    return (
        <div style={{display: 'flex',color: '#000', cursor: 'pointer', padding: 12, borderRadius: 10}}>
            <img src={info.images[0]} style = {{maxWidth: 150, borderRadius: 10, objectFit: 'contain'}} />
            <div style = {{marginLeft: 10}}>
                <h3>
                    {info.displayName}
                </h3>
                <p>
                    {info.displayDescription}
                </p>
            </div>
        </div>
    )
}