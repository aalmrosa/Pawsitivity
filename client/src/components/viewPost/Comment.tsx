import React, {useState} from "react";
import styles from "./Comment.module.css";
interface Props {

}

const Comment = (props: Props) => {

    return (
        <div id={styles['comment-container']}>
            <div className={styles["poster-details"]}>
                <span className={styles["poster-name"]}>Luke Meowton</span>
                <div>
                    <span className={styles["post-time"]}>9/15/2014</span>
                    <span> &middot; </span>
                    <span>11:30AM</span> 
                </div>
                
            </div>
        </div>
    );
};

export default Comment;