import React from 'react';
import Card from './Card';

function SearchList({ filteredBuildings, addMap, translation}) {
  const filtered = filteredBuildings.map(building => <Card key={building.id} building={building} addMap = {addMap} translation = {translation}/>);
  return (
    <div>
      {filtered}
    </div>
  );
}

export default SearchList;