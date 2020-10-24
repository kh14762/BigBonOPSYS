import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

//import * as serviceWorker from './serviceWorker';
/* This throws followind error: 
    ./src/index.js
Module not found: Can't resolve './serviceWorker' in 'C:\Users\kevin\git\BigBonOPSYS\bigbonapp_react\src'
*/
// so uncommented


var element = React.createElement('h1', { className: 'greeting' }, 'Hello World...');
ReactDOM.render( element, document.getElementById('root'));

//serviceWorker.unregister();

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
