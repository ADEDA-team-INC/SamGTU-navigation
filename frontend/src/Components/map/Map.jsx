import React, { useRef, useEffect } from 'react';
import * as PIXI from 'pixi.js';

export const Map = ({ svgData }) => {
    const containerRef = useRef(null);

    useEffect(() => {
      const app = new PIXI.Application({
        width: 800, // Ширина контейнера
        height: 600, // Высота контейнера
        backgroundColor: 0xffffff, // Цвет фона
      });
  
      const container = containerRef.current;
      container.appendChild(app.view);
  
      const imageTexture = PIXI.Texture.from(svgData);
      const imageSprite = new PIXI.Sprite(imageTexture);
      app.stage.addChild(imageSprite);
  
      return () => {
        app.destroy(true);
      };
    }, [svgData]);
  
    return <div ref={containerRef} />;
  };

export default Map;