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
