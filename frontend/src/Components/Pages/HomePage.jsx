import React from 'react'
import { NavLink } from 'react-router-dom'
import { SearchBar } from '../UI/SearchBar'

export const HomePage = ({ t }) => {
    return (
        <div className='home'>
            <SearchBar t = {t}/>
            <ul className='home__list'>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link' to={'/cafes'}>
                        <svg fill="#000" viewBox="0 0 32 32" id="icon" xmlns="http://www.w3.org/2000/svg">
                            <g id="SVGRepo_bgCarrier" stroke-width="0">
                            </g>
                            <g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round">
                            </g>
                            <g id="SVGRepo_iconCarrier">
                                <rect x="2" y="28" width="28" height="2">
                                </rect>
                                <path d="M24.5,11H8a2.002,2.002,0,0,0-2,2v8a5.0059,5.0059,0,0,0,5,5h8a5.0059,5.0059,0,0,0,5-5V20h.5a4.5,4.5,0,0,0,0-9ZM22,21a3.0033,3.0033,0,0,1-3,3H11a3.0033,3.0033,0,0,1-3-3V13H22Zm2.5-3H24V13h.5a2.5,2.5,0,0,1,0,5Z" transform="translate(0 0)">
                                </path>
                                <path d="M19,9H17V8.854a1.9883,1.9883,0,0,0-1.1055-1.7886L13.2109,5.7236A3.9788,3.9788,0,0,1,11,2.146V1h2V2.146a1.9892,1.9892,0,0,0,1.1055,1.7886l2.6836,1.3418A3.9792,3.9792,0,0,1,19,8.854Z" transform="translate(0 0)">
                                </path>
                                <rect id="_Transparent_Rectangle_" data-name="<Transparent Rectangle>" fill='none' width="32" height="32">
                                </rect>
                            </g>
                        </svg>
                        <div>
                            {t('main_page.cafes')}
                        </div>
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink to={"/buildings"} className='home__list__item__link'>
                        <svg fill="#000000" width="40px" height="40px" viewBox="0 0 50.00 50.00" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round" stroke="#CCCCCC" stroke-width="0.4"></g><g id="SVGRepo_iconCarrier"><path d="M9 0C7.355469 0 6 1.355469 6 3L6 50L44 50L44 3C44 1.355469 42.644531 0 41 0 Z M 9 2L41 2C41.554688 2 42 2.445313 42 3L42 48L38 48L38 36L27 36L27 48L8 48L8 3C8 2.445313 8.445313 2 9 2 Z M 12 6L12 14L23 14L23 6 Z M 27 6L27 14L38 14L38 6 Z M 14 8L21 8L21 12L14 12 Z M 29 8L36 8L36 12L29 12 Z M 12 16L12 24L23 24L23 16 Z M 27 16L27 24L38 24L38 16 Z M 14 18L21 18L21 22L14 22 Z M 29 18L36 18L36 22L29 22 Z M 12 26L12 34L23 34L23 26 Z M 27 26L27 34L38 34L38 26 Z M 14 28L21 28L21 32L14 32 Z M 29 28L36 28L36 32L29 32 Z M 12 36L12 44L23 44L23 36 Z M 14 38L21 38L21 42L14 42 Z M 29 38L36 38L36 48L29 48Z"></path></g></svg>
                        <div>
                            {t('main_page.buildings')}
                        </div>
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link' to={'/sights'}>
                        <svg viewBox="0 0 512 512" id="Layer_1" version="1.1" width='40px' height='40px' xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"><g> <g> <path class="st0" fill='#000' d="M37.1,461.5h79c15.7-22.1,31.8-50,47.3-80.9h-60.1C83.3,410.2,61.3,437.9,37.1,461.5z M230.4,218.7h-41.8 c-12.3,29.3-26.6,60.2-42.8,90.7H196C208.7,279.3,220.4,248.4,230.4,218.7z M256,131.7c1.3,5.1,2.7,10.4,4.1,15.7h35.8 c-9.6-27.1-17-50.6-22.1-67.9c-3.4-11.6-5.8-20.5-7.3-25.9L256,50.5l-10.6,3.2c-1.4,5.4-3.8,14.3-7.3,25.9 c-5.1,17.3-12.5,40.7-22.1,67.9h35.8C253.3,142.1,254.7,136.8,256,131.7z M281.6,218.7c10,29.7,21.7,60.6,34.3,90.7h50.3 c-16.3-30.5-30.5-61.4-42.8-90.7H281.6z M408.8,380.6h-60.2c15.5,30.9,31.6,58.7,47.3,80.9h79 C450.7,437.9,428.7,410.2,408.8,380.6z M432,323.4H80v43.2h352V323.4z M359.5,161.5H152.5v43.2h207.1V161.5z"></path> </g> </g> </g></svg>
                        <div>
                        {t('main_page.sights')}
                        </div>
                    </NavLink>
                </li>
                <li className='home__list__item'>
                    <NavLink className='home__list__item__link' to={'/shops'}>
                        <svg version="1.1" id="_x32_" width='40px' height="40px" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 512 512" xml:space="preserve" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"><g> <path class="st0" d="M147.244,207.801c21.256,0,38.485-17.237,38.485-38.485l14.052-147.244h-61.569l-29.454,147.244 C108.759,190.564,125.988,207.801,147.244,207.801z"></path> <path class="st0" d="M256.004,207.801c21.248,0,38.477-17.237,38.477-38.485l-7.689-147.244h-61.576l-7.697,147.244 C217.518,190.564,234.748,207.801,256.004,207.801z"></path> <path class="st0" fill='#000000' d="M364.763,207.801c21.249,0,38.478-17.237,38.478-38.485L373.794,22.071h-61.568l14.052,147.244 C326.278,190.564,343.507,207.801,364.763,207.801z"></path> <path class="st0" d="M460.798,22.071h-61.569l35.808,147.244c0,17.988,12.391,32.972,29.075,37.188V457.73h-57.997V287.744H259.818 V457.73H47.896V206.504c16.675-4.216,29.074-19.201,29.074-37.188l35.801-147.244H51.202L0,169.316 c0,12.687,6.218,23.85,15.698,30.864v289.75H496.31v-289.75c9.471-7.014,15.69-18.177,15.69-30.864L460.798,22.071z M381.969,457.73h-98.006V311.896h98.006V457.73z"></path> <rect x="109.404" y="276.338" class="st0" width="85.577" height="85.577"></rect> </g> </g></svg>
                        <div>
                        {t('main_page.shops')}
                        </div>
                    </NavLink>
                </li>
            </ul>
        </div>
    )
}