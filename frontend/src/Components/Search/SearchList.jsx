import React from 'react';
import Card from './Card';
import s from './search.module.scss'

function SearchList({ filteredBuildings, addMap}) {
  const filtered = filteredBuildings.map(building => <Card key={building.id} building={building} addMap = {addMap}/>);
  return (
    <div>
      {filtered}
    </div>
  );
}

export default SearchList;