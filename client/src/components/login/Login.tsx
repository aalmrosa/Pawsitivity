import React, {useState} from "react";
import Navbar from "../Navbar";

interface Props {

}

const Login: React.FC<Props> = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (event: React.FormEvent<HTMLFormElement>): Promise<void> => {
        event.preventDefault()
        try {
            const response = await fetch("http://localhost:8080/api/login", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({'username': username, 'password': password})
            });
            if(response.ok){
                console.log("LOGGED IN TO ACCOUNT");
            }
            else{
                console.log("UNABLE TO LOGIN")
            }
        } catch (error){
            console.log("remove error", error);
        }

    }

    return (
        <div>
            {/*<i className="icon ion-md-home"></i>*/}
            <form method="post" onSubmit={handleLogin}>
                <label htmlFor="username">Username: </label>
                <input id="username" type="text" placeholder="Enter your username"
                       onChange={(e) => setUsername(e.target.value)}/>

                <label htmlFor="password">Password: </label>
                <input id="password" type="password" placeholder="Enter your password"
                       onChange={(e) => setPassword(e.target.value)}/>

                <input type="submit" value="Submit"/>
            </form>
        </div>
    );
};

export default Login;