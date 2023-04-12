import React, { useEffect, useState, useRef } from "react";
import { fabric } from "fabric";

import { Infobar } from "../Infobar/Infobar";
import { Domain } from "../UI/domains/domain";
import { Zoom } from "../UI/zoom/zoom";
import Search from "../Search/Search";
import initialDetails from "../../data/initialDetails";

export const MainPage = (props) => {

  useEffect(() => {
    const canvas = new fabric.Canvas('map', {
        width: window.innerWidth,
        height: window.innerHeight,
    })

    fabric.Image.fromURL('https://sun9-20.userapi.com/impg/ETeepUo26XEVhYsdIiRGgIslOWGxGEw4oBPMAg/pWSZdOtya44.jpg?size=1404x664&quality=96&sign=287b1f00efe07ab05a02e30278e1d8de&type=album', function (oImg) {
        oImg.lockScalingX = false,
        oImg.lockScalingY = false,
        oImg.lockRotation = false,
        oImg.hasBorders = false,
        oImg.hasControls = false,
        canvas.add(oImg);
    });

    canvas.on("mouse:wheel", function (opt) {
        var delta = opt.e.deltaY;
        var zoom = canvas.getZoom();
        zoom *= 0.999 ** delta;
        if (zoom > 20) zoom = 20;
        if (zoom < 0.01) zoom = 0.01;
        canvas.zoomToPoint({ x: opt.e.offsetX, y: opt.e.offsetY }, zoom);
        opt.e.preventDefault();
        opt.e.stopPropagation();
      });

}, [])

  return (
    <div className="main">
      <canvas id="map"></canvas>
      <div>
        <div className="main__left__container">
          <Search details={initialDetails} />
        </div>
        <div className="main__top__container">
          <Infobar />
        </div>
        <div className="main__right__container">
          <Domain />
          <Zoom/>
        </div>
      </div>
    </div>
  );
};
