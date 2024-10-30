import React, {useState} from "react";
import styles from "./Profile.module.css";
interface Props {

}

const Profile: React.FC<Props> = () => {

    return (
        <div id={styles['profile-container']}>
            <div>
                <img src="https://images.unsplash.com/photo-1493406300581-484b937cdc41?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="cat"/>
            </div>
            
        </div>
    );
};

export default Profile;