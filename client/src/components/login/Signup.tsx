import React, {useState} from "react";
import styles from "./Login.module.css"
import { Link } from "react-router-dom";

interface Props {

}

const Signup: React.FC<Props> = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const handleSignup = async (event: React.FormEvent<HTMLFormElement>): Promise<void> => {
        event.preventDefault()
        try {
            const response = await fetch("http://localhost:8080/api/signup", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({'username': username, 'password': password, 'confirmPassword': confirmPassword})
            });
            if(response.ok){
                console.log("REGISTERED ACCOUNT");
            }
            else{
                console.log("UNABLE TO REGISTER")
            }
        } catch (error){
            console.log("remove error", error);
        }

    }


    return (
        <div id={styles["container"]}>
            <header>
                <div id={styles["header-1"]}>Sign-up To</div>
                <div id={styles["header-2"]}>Pawsitivity</div>
            </header>
            <form method="post" onSubmit={handleSignup}>
                <label htmlFor="username"></label>
                <input id="username" className={styles["text-input"]} type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)}/>

                <label htmlFor="password"></label>
                <input id="password" className={styles["text-input"]} type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>

                <label htmlFor="confirmPassword"></label>
                <input id="confirmPassword" className={styles["text-input"]} type="password" placeholder="Confirm Password" onChange={(e) => setConfirmPassword(e.target.value)}/>

                <input id={styles["submit-form"]} type="submit" value="Sign-up"/>
            </form>
            <div className={styles["links"]}>
                <Link to="/login">
                    <div>Already have an account?</div>
                </Link>
            </div>
        </div>
    );
};

export default Signup;