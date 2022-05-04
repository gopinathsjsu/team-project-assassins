import React, { useState, useEffect } from "react";
import axios from "axios";
import Swal from "sweetalert2";
import { Tag } from "antd";

import Loader from "../../common-components/Loader";
import Error from "../../common-components/Error";

function MyBookingScreen() {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const userId = JSON.parse(localStorage.getItem("currentUserId"));

  async function fetchMyAPI() {
    setError("");
    setLoading(true);
    try {
      const data = (
        await axios.get(
          "http://localhost:8080/api/bookings/getCustomerBookings/"+userId,
        )
      ).data;
      console.log(data)
      setBookings(data);
    } catch (error) {
      console.log(error);
      setError(error);
    }
    setLoading(false);
  }

  useEffect(() => {
    fetchMyAPI();
  }, []);

  async function cancelBooking(bookingid, roomid) {
    setError("");
    setLoading(true);
    try {
      const data = (
        await axios.put("http://localhost:8080/api/bookings/cancelBooking/"+bookingid)
      ).data;
      setLoading(false);
      Swal.fire(
        "Congratulations",
        "Your Room Cancelled Successfully",
        "success"
      ).then((result) => {
        fetchMyAPI();
      });
    } catch (error) {
      console.log(error);
      //setError(error);
      Swal.fire("Opps", "Error:" + error, "error");
    }
    setLoading(false);
  }

  async function editBooking(bookingid, roomid) {
    console.log("eDIT BOOKING Details");
    window.location.pathname = `/editBookings/${bookingid}`;
  }

  return (
    <div>
      {loading ? (
        <Loader></Loader>
      ) : error.length > 0 ? (
        <Error msg={error}></Error>
      ) : (
        <div style={{ marginLeft: "30%" }} className="row">
          <div className="col-md-6  ml-5">
            {bookings &&
              bookings.map((booking) => {
                console.log(booking)
                return (
                  <div className="bs">
                    {/* <h1 style={{ textAlign: "center" }}>{booking.room}</h1> */}
                    <p>
                      <b>BookingId:</b> {booking.id}
                    </p>
                    <p>
                      <b>CheckIn:</b> {booking.fromdate}
                    </p>
                    <p>
                      <b>CheckOut:</b> {booking.todate}
                    </p>
                    <p>
                      <b>Amount:</b> {booking.totalamount}
                    </p>
                    <p>
                      <b>Status:</b>{" "}
                      {booking.status === "booked" ? (
                        <Tag color="green">CONFIRMED</Tag>
                      ) : (
                        <Tag color="red">CANCELLED</Tag>
                      )}
                    </p>
                    {booking.status === "booked" && (
                      <div className="text-right">
                        <button
                          style={{ border: "none" }}
                          className="btn btn-danger"
                          onClick={() => {
                            editBooking(booking.id, booking.roomid);
                          }}
                        >
                          Edit 
                        </button>

                        <button
                          style={{ border: "none", marginLeft: "10px" }}
                          className="btn btn-danger"
                          onClick={() => {
                            cancelBooking(booking.id, booking.roomid);
                          }}
                        >
                          Cancel 
                        </button>
                      </div>
                    )}
                  </div>
                );
              })}
          </div>
        </div>
      )}
    </div>
  );
}

export default MyBookingScreen;
