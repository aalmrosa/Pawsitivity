import React, {useState} from "react";
import styles from "./Homepage.module.css";
import Post from "./Post";
interface Props {

}

const Homepage: React.FC<Props> = () => {

    return (
        <div id={styles["homepage-container"]}>
            <div id={styles["feed-container"]}>
                <Post/>
                <Post/>
            </div>
            <div id={styles["right-contents"]}>
                <div id={styles["create-post"]}>
                    <div className={styles["prof-pic-container"]}>
                        <img className={styles["prof-pic"]}
                             src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                         uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                             alt="profile picture"/>
                    </div>
                    <textarea id={styles["post-text"]}
                              placeholder={"What are your pet peeves regarding humans? Do share!"}></textarea>
                </div>
                <div id={styles["trending"]}>
                    <h2>Trending Mews</h2>
                </div>
            </div>
        </div>
    );
};

export default Homepage;