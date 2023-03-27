import React from 'react';
import s from './scroll.module.scss'

const Scroll = (props) => {
  return( 
    <div className={s.scroll}>
      {props.children}
    </div>	
  );
}

export default Scroll;