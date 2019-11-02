import React from 'react';
import './App.css';

// import { ApolloClient } from 'apollo-client';
// import { HttpLink } from 'apollo-link-http';
// const link = new HttpLink({
//   uri: 'http://localhost:4000/'
// });

// const client = new ApolloClient({link});

// const customersQuery = gql`
//   query CustomersQuery {
//     customers {
//       id
//       name
//     }
//   }
// `

// const CustomersList = ({ data: { loading, error, customers }}) => {
//   if(loading) {
//     return <p>loading</p>
//   }
//   if(error){
//     return <p>{error.message}</p>
//   }

//   return <ul>
//     { customers.map((customer) => <li key={customer.id}>{customer.name}</li>)}
//   </ul>
// }

//import CssBaseline from '@material-ui/core/CssBaseline';
//import Grid from '@material-ui/core/Grid';
// import Container from '@material-ui/core/Container';

import Tables from './Tables/Tables'

const tables = {
  tableOrders: {
    title: ['id', 'customer', 'products', 'date'],
    values: [
      ['1', 'dunga', '3', '2019-01-02'],
      ['2', 'metri', '1', '2018-01-02']
    ]
  },
  tableCustomers: {
    title: ['id', 'customer', 'quantity'],
    values: [
      ['1', 'dunga', '3'],
      ['2', 'metri', '1']
    ]
  },
  tableProducts: {
    title: ['id', 'product', 'quantity'],
    values: [
      ['1', 'dunga', '3'],
      ['2', 'metri', '1']
    ]
  }
}

const App = () =>
  <div className="App">
    <Tables tables={tables} />
  </div>

export default App;
