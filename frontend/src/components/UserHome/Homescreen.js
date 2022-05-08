import React, {Component} from 'react';

class Homescreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            userId: '',
            isAdmin: '',
            rewards: ''
        }
    }

    componentDidMount() {
        let userName = JSON.parse(localStorage.getItem("currentUserName"));
        let userId = JSON.parse(localStorage.getItem("currentUserId"));
        let isAdmin = JSON.parse(localStorage.getItem("isAdmin"));
        let rewards = JSON.parse(localStorage.getItem("rewards"));
        this.setState({ userId, userName, isAdmin, rewards })
    }

    render() {
        return (
            <div>
                
            </div>
        );
    }
}

export default Homescreen;