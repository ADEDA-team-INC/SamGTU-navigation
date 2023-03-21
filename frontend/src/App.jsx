import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.scss'
import { MainPage } from './Components/Pages/MainPage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <MainPage />
  )
}

export default App
