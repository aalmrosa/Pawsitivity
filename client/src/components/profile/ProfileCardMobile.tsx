import React, {useState} from "react";
import styles from "./ProfileCardMobile.module.css";
interface Props {

}

const ProfileCardMobile: React.FC<Props> = () => {

    return (
        <div id={styles['profileCard-container']}>
            <div>
                <div>
                    <img src="https://plus.unsplash.com/premium_photo-1673967796686-154ab5ad9ca1?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="cat paw"/>
                </div>
                <div id={styles['name-container']}>
                    <span className={styles['first-name']}>Luke</span>
                    <span className={styles['last-name']}>Meowton</span>
                </div>
            </div>
            <div className={styles['profile-buttons']}>
                <button>
                    <span>Edit Profile</span>
                    <img /> 
                </button>
            </div>
        </div>
    );
};

export default ProfileCardMobile;