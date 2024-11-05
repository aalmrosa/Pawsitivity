import React, {useState} from "react";
import styles from "./Profile.module.css";
import ProfileCardMobile from "./ProfileCardMobile";
import Post from "../common/Post";
import SideProfile from "../common/SideProfile";
interface Props {

}

const Profile: React.FC<Props> = () => {

    return (
        <div id={styles['profile-container']}>
            <section className={styles['profile-banner-container']}>
                <img className={styles['banner-pic']}
                src="https://images.unsplash.com/photo-1493406300581-484b937cdc41?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="cat at sea" />
                <div className={styles['banner-gradient']}></div>
            </section>
            <section className={styles['prof-card-mobile-container']}>
                <ProfileCardMobile/>
            </section>
            <div className={styles['desktop-main-container']}>
                <section className={styles['prof-card-desktop-container']}>
                    <SideProfile/>
                </section>
                <section className={styles['post-history-container']}>
                    <h2>Post History</h2>
                    <Post/>
                </section>
            </div>
            
        </div>
    );
};

export default Profile;