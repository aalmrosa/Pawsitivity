import React, {useState} from "react";
import styles from "./Login.module.css"
import { Link } from "react-router-dom";

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
        <div id={styles["container"]}>
            <header>
                <div id={styles["header-1"]}>Login To</div>
                <div id={styles["header-2"]}>Pawsitivity</div>
            </header>
            <form method="post" onSubmit={handleLogin}>
                <div className={styles["user-info"]}>
                    <label htmlFor="username"></label>
                    <input id="username" className={styles["text-input"]} type="text" placeholder="username"
                            onChange={(e) => setUsername(e.target.value)}/>

                    <label htmlFor="password"></label>
                    <input id="password" className={styles["text-input"]} type="password" placeholder="password"
                            onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <input id={styles["submit-form"]} type="submit" value="Login"/>
            </form>
            <div className={styles["links"]}>
                <Link to="/">
                    <div>Forgot your password?</div>
                </Link>
                <Link to="/signup">
                    <div>Don't have an account?</div>
                </Link>
            </div>
        </div>
    );
};

export default Login;