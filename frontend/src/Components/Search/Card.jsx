import React from 'react';
import s from './search.module.scss';
import geo from '../../assets/img/GeoAltFill.svg';


function Card({ building }) {
  return (
    <div className={s.card}>
      <img className={s.card__geo} src={geo} />
      <div className={s.card__text}>
        <h3>{building.name}</h3>
        <span>{building.adress}</span>
      </div>
    </div>

  );
}

export default Card;