import React from 'react';
import Card from './Card';
import s from './search.module.scss'

function SearchList({ filteredBuildings }) {
  const filtered = filteredBuildings.map(building => <Card key={building.id} building={building} />);
  return (
    <div>
      {filtered}
    </div>
  );
}

export default SearchList;