import { Provider } from 'react-redux'
import './App.scss'
import { MainScreen } from './Components/MainScreen'
import { store } from '../src/redux/store'

function App() {

  return (
    <Provider store={store}>
      <MainScreen />
    </Provider>
  )
}

export default App
