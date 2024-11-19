import React, {useState} from "react";
import styles from "./ViewPost.module.css";
import Post from "../common/Post";
interface Props {

}

const ViewPost = (props: Props) => {

    return (
        <div id={styles['post-container']}>
            <Post page={"ViewPost"}/>
            <section className={styles["create-comment-container"]}>
                <div className={styles["comment-details"]}>
                    <div className={styles["prof-pic-container"]}>
                        <img className={styles["prof-pic"]}
                        src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                        uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        alt="profile"/>
                    </div>
                    <textarea></textarea>
                </div>
                <button>Comment</button>
            </section>
        </div>
    );
};

export default ViewPost;