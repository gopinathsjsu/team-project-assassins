import React, { useState, useEffect } from "react";
import axios from "axios";
import moment, { max } from "moment";
import StripeCheckout from "react-stripe-checkout";
import Swal from "sweetalert2";
import Loader from "../../common-components/Loader";
import Error from "../../common-components/Error";
import "../../App.css";
import { amenities } from "../../common-components/Amenities";
const getFormattedPrice = (price) => `$${price.toFixed(2)}`;

useEffect(() => {
  const user = JSON.parse(localStorage.getItem("currentUserName"));

  if (!user) {
    window.location.href = "/login";
  }
  async function fetchMyAPI() {
    try {
      setError("");
      setLoading(true);
      const data = (
        await axios.get(
          "http://localhost:8080/api/room/getroombyid/" + match.params.roomid
        )
      ).data;
      console.log(data);
      setRoom(data);
    } catch (error) {
      console.log(error);
      setError(error);
    }
    setLoading(false);
  }
  fetchMyAPI();
}, []);

useEffect(() => {
  const totaldays = moment.duration(todate.diff(fromdate)).asDays() + 1;
  console.log("totalDays", totalDays);
  setTotalDays(totaldays);
  const roomrent = totalDays * room.rentPerDay;
  setTotalAmount(roomrent);
}, [room]);

const handleUseReedem = () => {
  console.log(useRewards);
  setDisplay(false);
  setUseRewards(!useRewards);
  const rewards = JSON.parse(localStorage.getItem("rewards"));
  console.log(useRewards);
  if (useRewards === true) {
    const updatedCostAfterRewards = totalAmount - rewards;
    setTotalAmount(updatedCostAfterRewards);
    setRewards(0);
  } else {
    setRewards(rewards);
    const updatedCostAfterRewards = totalAmount + rewards;
    setTotalAmount(updatedCostAfterRewards);
  }
};
