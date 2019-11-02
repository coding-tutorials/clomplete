import React from 'react';
import './Ranking.css';
 
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

const generateRows = (values, i = 0) => 
  <TableRow key={i}>
    {values && values.map((value, i) => <TableCell key={i}>{value}</TableCell>)}
  </TableRow>

const Ranking = ({ table }) =>
  //<div className="Table">
    <Table>
      <TableHead>
        {table && table.title && generateRows(table.title)}
      </TableHead>
      <TableBody>
        {table && table.values && table.values.map(generateRows)}
      </TableBody>
    </Table>
 // </div>

export default Ranking;
