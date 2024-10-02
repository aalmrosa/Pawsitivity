import React, {useState} from "react";
import styles from "./Post.module.css";
interface Props {

}

const Post: React.FC<Props> = () => {

    return (
        <div id={styles["post-container"]}>
            <div className={styles["post-details"]}>
                <div className={styles["prof-pic-container"]}>
                    <img className={styles["prof-pic"]}
                          src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                          uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                          alt="profile picture"/>
                </div>
                <div className={styles["poster-details"]}>
                    <span className={styles["poster-name"]}>Luke Meowton</span>
                    <span className={styles["post-time"]}>9/15/2014</span>
                </div>
            </div>
            <div className={styles["post-contents"]}>
                <div className={styles["img-container"]}>
                    <img className={styles["post-image"]}
                         src="https://images.unsplash.com/photo-1511694009171-3cdddf4484ff?q=80&w=2070&a
                     uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                         alt="cat picture"/>
                </div>
                <div>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam at autem deserunt error excepturi iusto, molestiae neque nobis numquam odio placeat qui quos recusandae reiciendis sapiente sed sequi sunt voluptates. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab, aliquam atque, consectetur debitis eligendi illum incidunt labore, mollitia necessitatibus nisi optio perspiciatis quod rerum sed sunt unde voluptate. Deserunt, illum!
                </div>

            </div>
        </div>
    );
};

export default Post;