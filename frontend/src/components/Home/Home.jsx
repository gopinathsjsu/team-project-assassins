import { Redirect } from 'react-router-dom';
import React from 'react';

require("./Home.css")

export default function Home() {
  return (
    <div>
      <p>  hi  </p>
      <Redirect to="/login" />
    </div>
  );
}
