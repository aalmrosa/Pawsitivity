import React, {useState} from "react";
import styles from "./Homepage.module.css";
import Post from "../common/Post";
import SideProfile from "./SideProfile";
interface Props {

}

const Homepage: React.FC<Props> = () => {

    return (
        <div className={styles["container"]}>
            <div className={styles["sticky-panels"]}>
                <section className={styles["side-profile-container"]}>
                <SideProfile/>
                </section>

                <section className={styles['right-container']}>
                    <div style={{backgroundColor: "white", height: "600px", borderRadius: "15px"}}>Hello</div>
                </section>
            </div>
            <section className={styles["feed-container"]}>
                <section className={styles["create-post"]}>
                    <div className={styles["prof-pic-container"]}>
                        <img className={styles["prof-pic"]}
                            src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            alt="profile picture"/>
                    </div>
                    <textarea className={styles["new-post-text"]}
                        placeholder={"What are your pet peeves regarding humans? Do share!"}></textarea>
                </section>
                <section className={styles["feed-posts-container"]}>
                    <Post/>
                    <Post/>
                </section>
                <span className={styles["load-btn"]}>Load more</span>
            </section>
        </div>
    );
};

export default Homepage;