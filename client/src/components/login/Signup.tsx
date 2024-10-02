import React, {useState} from "react";

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
        <div>
            <form method="post" onSubmit={handleSignup}>
                <label htmlFor="username">Username: </label>
                <input id="username" type="text" placeholder="Enter your username" onChange={(e) => setUsername(e.target.value)}/>

                <label htmlFor="password">Password: </label>
                <input id="password" type="password" placeholder="Enter your password" onChange={(e) => setPassword(e.target.value)}/>

                <label htmlFor="confirmPassword">Confirm Password: </label>
                <input id="confirmPassword" type="password" placeholder="Please confirm your password" onChange={(e) => setConfirmPassword(e.target.value)}/>

                <input type="submit" value="Submit"/>
            </form>
        </div>
    );
};

export default Signup;