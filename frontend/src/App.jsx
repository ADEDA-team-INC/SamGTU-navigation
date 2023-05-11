import { Provider } from 'react-redux'
import './App.scss'
import { MainPage } from './Pages/MainPage'
import { store } from '../src/redux/store'

function App() {

  return (
    <Provider store={store}>
      <MainPage />
    </Provider>
  )
}

export default App
