import axios from "axios";
import React, { Component } from "react";
import './Get.css';


class Get extends Component {
  state = {
  data: []
  }

  componentDidMount() {
  axios.get('http://localhost:8087/showbill')
    .then(response => {
      this.setState({ data: response.data });
    })
    .catch(error => {
      console.log(error);
    });
}


  render() {   
    return (
        <center>
       <div className="lit"> 
      <table border={1}>
      <thead>
        <tr>
        <th>productId</th>
        <th>productName</th>
        <th>productBrand</th>
        <th>productEdition</th>
        <th>productWarrenty</th>
        </tr>
      </thead>
      <tbody>
        {this.state.data.map(user => (
            <tr key={user.productId}>
            <td>{user.productId}</td>
            <td>{user.productName}</td>
            <td>{user.productBrand}</td>
            <td>{user.productEdition}</td>
            <td>{user.productWarrenty}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
    </center>
    );
  }}
  
export default Get;