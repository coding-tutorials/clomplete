import React from 'react';
import './Tables.css';

import Grid from '@material-ui/core/Grid';
//import Container from '@material-ui/core/Container';

import Ranking from '../Ranking/Ranking'


const Tables = ({ tables: { tableOrders, tableCustomers, tableProducts }}) =>
  //<div className="Tables">
    <Grid container spacing={2}>
      <Grid item xs={6}>
        <Ranking table={tableOrders} />
      </Grid>
      <Grid item xs={3}>
        <Ranking table={tableCustomers} />
      </Grid>
      <Grid item xs={3}>
        <Ranking table={tableProducts} />
      </Grid>
    </Grid>
  //</div>

export default Tables;
