import React from 'react';
import logo from './logo.svg';
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

import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Container from '@material-ui/core/Container';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

const tableHeadRankingCustomers = () => 
  <TableRow>
    <TableCell>id</TableCell>
    <TableCell align="right">Customer</TableCell>
    <TableCell align="right">Orders</TableCell>
    <TableCell align="right">Product(s)</TableCell>
  </TableRow>

const tableHeadRankingProducts = () => 
  <TableRow>
    <TableCell>id</TableCell>
    <TableCell align="right">Product</TableCell>
    <TableCell align="right">Orders</TableCell>
    <TableCell align="right">Client(s)</TableCell>
  </TableRow>

const tableHeadRankingOrders = () => 
  <TableRow>
    <TableCell>id</TableCell>
    <TableCell align="right">Customer</TableCell>
    <TableCell align="right">Date</TableCell>
    <TableCell align="right">Product(s)</TableCell>
  </TableRow>

const table = (tableHead) =>
  <Table>
    <TableHead>
      {tableHead()}
    </TableHead>
    <TableBody>
      {tableHead()}
      {tableHead()}
      {tableHead()}
    </TableBody>
  </Table>

function App() {
  return (
    <div className="App">

      <Grid container spacing={2}>
        <Grid item xs={6}>
          {table(tableHeadRankingOrders)}
        </Grid>
        <Grid item xs={3}>
          {table(tableHeadRankingCustomers)}
        </Grid>
        <Grid item xs={3}>
          {table(tableHeadRankingProducts)}
        </Grid>
      </Grid>
      
  
    </div>
  );
}

export default App;
