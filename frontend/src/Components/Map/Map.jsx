import React, { useEffect } from 'react'; 

export const Map = props => {
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
        <canvas id="map"></canvas>
    )
}