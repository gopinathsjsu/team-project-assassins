import React, { useState, useEffect } from "react";
import axios from "axios";
import "antd/dist/antd.css";
import { DatePicker, Space } from "antd";
import {
    Col, Container, Ratio, Row, Navbar, Nav, NavDropdown, Button, Modal
} from 'react-bootstrap';
import moment from "moment";

import Room from "../../common-components/Room";
import Loader from "../../common-components/Loader";
import Error from "../../common-components/Error";

import AOS from "aos";
import "aos/dist/aos.css"; // You can also use <link> for styles
function Homescreen() {
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [rooms, setRooms] = useState([]);

    const [fromDate, setFromDate] = useState();
    const [toDate, setToDate] = useState();
    const [duplicateRooms, setDuplicateRooms] = useState([]);
    const [searchKey, setSearchKey] = useState("");
    const [type, setType] = useState("all");
    const [guestCount, setGuestCount] = useState(1);
    const [roomCount, setRoomCount] = useState(1);
    useEffect(() => {
        async function fetchMyAPI() {
            try {
                setError("");
                setLoading(true);
                const data = (
                    await axios.get("http://localhost:8080/api/room/getallrooms")
                ).data;
                //console.log(data);
                setRooms(data);
                setDuplicateRooms(data);
            } catch (error) {
                console.log(error);
                setError(error);
            }
            setLoading(false);
        }

        fetchMyAPI();
    }, []);
    function changeDates(dates) {
        try {
            setFromDate(moment(dates[0]).format("DD-MM-YYYY"));
            setToDate(moment(dates[1]).format("DD-MM-YYYY"));
        } catch (e) {
            console.log(e);
        }
    }
    function filterByDate(dates) {
        try {
            if (!dates) {
                setFromDate(null);
                setToDate(null);
                return;
            }
            setFromDate(moment(dates[0]).format("DD-MM-YYYY"));
            setToDate(moment(dates[1]).format("DD-MM-YYYY"));

            var tempRooms = [];
            for (const room of duplicateRooms) {
                var availability = false;
                if (room.currentbookings.length > 0) {
                    for (const booking of room.currentbookings) {
                        if (
                            !moment(moment(dates[0]).format("DD-MM-YYYY")).isBetween(
                                booking.fromdate,
                                booking.todate
                            ) &&
                            !moment(moment(dates[1]).format("DD-MM-YYYY")).isBetween(
                                booking.fromdate,
                                booking.todate
                            )
                        ) {
                            if (
                                moment(dates[0]).format("DD-MM-YYYY") !== booking.fromdate &&
                                moment(dates[0]).format("DD-MM-YYYY") !== booking.todate &&
                                moment(dates[1]).format("DD-MM-YYYY") !== booking.fromdate &&
                                moment(dates[1]).format("DD-MM-YYYY") !== booking.todate
                            ) {
                                availability = true;
                            }
                        }
                    }
                }
                //
                if (availability == true || room.currentbookings.length == 0) {
                    tempRooms.push(room);
                }
            }
            setRooms(tempRooms);
        } catch (error) {}
    }


    function filterBySearch() {
        const tempRooms = duplicateRooms.filter((x) =>
            x.location.toLowerCase().includes(searchKey.toLowerCase())
        );
        console.log(tempRooms);
        setRooms(tempRooms);
    }
    function filterByType(type) {
        setType(type);
        console.log(type);
        if (type !== "all") {
            const tempRooms = duplicateRooms.filter(
                (x) => x.type.toLowerCase() === type.toLowerCase()
            );
            setRooms(tempRooms);
        } else {
            setRooms(duplicateRooms);
        }
    }
return(
    <>
    </>
)
}
export default Homescreen;
