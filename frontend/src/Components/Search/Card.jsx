import React from 'react';
import s from './search.module.scss';
import geo from '../../assets/img/GeoAltFill.svg';


function Card({ building, addMap, translation}) {

  return (
    <div className={s.card} onClick={
      () => {
        console.log(building.cabinets)
      }
    }>
      <img className={s.card__geo} src={geo} />
      <div className={s.card__text}>
        <img src={building.img} alt="fjdjfdjf" />
        <h3>{translation(`korpusa.${building.id-1}.name`)}</h3>
        <span>{translation(`korpusa.${building.id-1}.adress`)}</span>
      </div>
    </div>

  );
}

export default Card;