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
//handling price event
const handlePrice = async () => {
  const fromDate = moment(match.params.fromdate, "DD-MM-YYYY");
  const toDate = moment(match.params.todate, "DD-MM-YYYY");
  console.log("@@", fromDate._i, totalAmount, amenitiesAmount);
  const bookingDetails = {
    room,
    userid: JSON.parse(localStorage.getItem("currentUserId")),
    fromdate: fromDate._i,
    todate: toDate._i,
    guestCount,
    totalamount: totalAmount + amenitiesAmount,
    totaldays: totalDays,
    remainingAmount: room.rentperday,
    extracostapplied: "",
    offerapplied: "",
  };

  // console.log(JSON.stringify(bookingDetails))
  console.log(bookingDetails);

  axios
    .post("http://localhost:8080/api/bookings/getUpdatedPrice", bookingDetails)
    .then((result) => {
      console.log(result);
      console.log(typeof ((guestCount - 2) * 15));
      console.log(typeof result.data.body.totalAmount);

      var newRoomCost = 0;
      if (guestCount > 2) {
        newRoomCost =
          parseInt(result.data.body.totalAmount) + (guestCount - 2) * 15;
        if (roomCount > 1) {
          newRoomCost = newRoomCost * roomCount;
        }
      } else {
        newRoomCost = result.data.body.totalAmount;
        if (roomCount > 1) {
          newRoomCost = newRoomCost * roomCount;
        }
      }
      console.log(newRoomCost);
      setnewtotal(newRoomCost);
      setnewOffer(result.data.body.offerapplied);
      setExtra(result.data.body.extracostapplied);
      setDisplay(true);
      // setUpdateUserRewarrds(true);
      if (result.data.body.offerapplied !== "") {
        console.log(
          "====================================== RP" +
            Number(JSON.parse(localStorage.getItem("rewards"))) +
            5
        );
        // console.log(JSON.parse(localStorage.getItem("currentUser")).rewards);
        // const result = axios
        //   .put(
        //     "http://localhost:8080/api/users/updateUserRewards/" +
        //       JSON.parse(localStorage.getItem("currentUserId")),
        //     {
        //       rewardsPoints:
        //         Number(
        //           JSON.parse(localStorage.getItem("rewards"))
        //         ) + 5,
        //     }
        //   )
        //   .then((userRes) => {
        //     setIsRoomBooked(true);
        //     console.log(userRes);
        //     let rewards =
        //       Number(
        //         JSON.parse(localStorage.getItem("rewards"))
        //       ) + 5;
        //       //
        //     localStorage.setItem("rewards", JSON.stringify(rewards));
        //   })
        //   .catch((error) => {
        //     console.log(error);
        //   });
      }
    })
    .catch((error) => {
      console.log(error);
    });
};
