import React, { useEffect } from "react";
import s from "./zoom.module.scss";
import { useDispatch, useSelector } from "react-redux";

export const Zoom = () => {

  const dispatch = useDispatch()
  const map = useSelector(state => state.map.map)

  const zoomCanvas = (map, state) => {
    const top = map.getCenter().top
    const left = map.getCenter().left

    if (state === 'plus') {
      var zoom = map.getZoom();
      if (zoom > 20) {
        zoom = 20
      } else {
        zoom += 0.1
      }
      map.zoomToPoint({ x: top, y: left }, zoom)
    } else {
      var zoom = map.getZoom();
      if (zoom < 0.01) {
        zoom = 0.01
      } else {
        zoom -= 0.1
      }
      map.zoomToPoint({ x: top, y: left }, zoom)
    }
    dispatch({ type: "MAP", payload: map })
  }
  return (
    <div className={s.zoom}>
      <div
        className={s.zoom__button}
        onClick={
          () => zoomCanvas(map, 'plus')
        }
      >
        <svg
          width="40"
          height="40"
          viewBox="0 0 40 40"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M20 0C20.663 0 21.2989 0.263393 21.7678 0.732234C22.2366 1.20107 22.5 1.83696 22.5 2.5V17.5H37.5C38.163 17.5 38.7989 17.7634 39.2678 18.2322C39.7366 18.7011 40 19.337 40 20C40 20.663 39.7366 21.2989 39.2678 21.7678C38.7989 22.2366 38.163 22.5 37.5 22.5H22.5V37.5C22.5 38.163 22.2366 38.7989 21.7678 39.2678C21.2989 39.7366 20.663 40 20 40C19.337 40 18.7011 39.7366 18.2322 39.2678C17.7634 38.7989 17.5 38.163 17.5 37.5V22.5H2.5C1.83696 22.5 1.20107 22.2366 0.732234 21.7678C0.263393 21.2989 0 20.663 0 20C0 19.337 0.263393 18.7011 0.732234 18.2322C1.20107 17.7634 1.83696 17.5 2.5 17.5H17.5V2.5C17.5 1.83696 17.7634 1.20107 18.2322 0.732234C18.7011 0.263393 19.337 0 20 0Z"
            fill="#444444"
          />
        </svg>
      </div>

      <div
        className={s.zoom__button}
        onClick={
          () => zoomCanvas(map, 'minus')
        }
      >
        <svg
          width="40"
          height="6"
          viewBox="0 0 40 6"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M0 3C0 2.33696 0.263393 1.70107 0.732234 1.23223C1.20107 0.763393 1.83696 0.5 2.5 0.5H37.5C38.163 0.5 38.7989 0.763393 39.2678 1.23223C39.7366 1.70107 40 2.33696 40 3C40 3.66304 39.7366 4.29893 39.2678 4.76777C38.7989 5.23661 38.163 5.5 37.5 5.5H2.5C1.83696 5.5 1.20107 5.23661 0.732234 4.76777C0.263393 4.29893 0 3.66304 0 3Z"
            fill="#444444"
          />
        </svg>
      </div>
    </div>
  );
};
