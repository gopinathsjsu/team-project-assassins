import logo from './logo.svg';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Home from './components/Home/Home';
import Login from './components/Login/Login';
import SignUp from './components/SignUp/SignUp';

function NotFound() {
  return <div>not found man!!</div>;
}
function App() {
  return (
    <Router>
      <Switch>
      <Route exact path="/">
          <Home />
        </Route>        
        <Route path="/signup">
          <SignUp />
        </Route>
        <Route path="/login">
          <Login />
        </Route>  
        
        <Route path="*" component={NotFound} />
      </Switch>
    </Router>
  );
}

export default App;
