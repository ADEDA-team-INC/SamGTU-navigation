import React from 'react'
import { NavLink } from 'react-router-dom'

export const SearchBar = ({ t, setText, text }) => {
    return (
        <div style={{ width: '100%', display: 'flex', alignItems: 'center' }}>
            <input placeholder={t('search')} onChange={(e) => setText(e.target.value)} />
            <NavLink href='#' style={{ padding: '10px' }} to={`/search?${text}`} onClick={() => {
                setText(text)
            }}>
                <svg width="20px" height="20px" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <title>search_left [#1506]</title> <desc>Created with Sketch.</desc> <defs> </defs> <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"> <g id="Dribbble-Light-Preview" transform="translate(-219.000000, -280.000000)" fill="#000000"> <g id="icons" transform="translate(56.000000, 160.000000)"> <path d="M184,138.586 L182.5153,140 L176.57545,134.343 L178.06015,132.929 L184,138.586 Z M170.35,132 C167.45515,132 165.1,129.757 165.1,127 C165.1,124.243 167.45515,122 170.35,122 C173.24485,122 175.6,124.243 175.6,127 C175.6,129.757 173.24485,132 170.35,132 L170.35,132 Z M170.35,120 C166.2907,120 163,123.134 163,127 C163,130.866 166.2907,134 170.35,134 C174.4093,134 177.7,130.866 177.7,127 C177.7,123.134 174.4093,120 170.35,120 L170.35,120 Z" id="search_left-[#1506]"> </path> </g> </g> </g> </g></svg>
            </NavLink>
        </div>
    )
}