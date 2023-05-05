import { Provider } from 'react-redux'
import './App.scss'
import { MainPageContainer } from './Components/Pages/MainPage'
import { store } from '../src/redux/store'

function App() {

  return (
    <Provider store={store}>
      <MainPageContainer />
    </Provider>
  )
}

export default App
