import React, {useState} from "react";
import styles from "./Post.module.css";
interface Props {
    page?: string;
}

const Post = (props: Props) => {

    return (
        <div className={`${styles["post-container"]} ${(props.page === "ViewPost") ? styles["no-bot-radius"]: ""}`} >
            {/* picture, name, time */}
            <div className={styles["post-details"]}>
                <div className={styles["prof-pic-container"]}>
                    <img className={styles["prof-pic"]}
                          src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                          uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                          alt="profile"/>
                </div>
                <div className={styles["poster-details"]}>
                    <span className={styles["poster-name"]}>Luke Meowton</span>
                    <div>
                        <span className={styles["post-time"]}>9/15/2014</span>
                        <span> &middot; </span>
                        <span>11:30AM</span> 
                    </div>
                    
                </div>
            </div>
            {/* image, text */}
            <div className={styles["post-contents"]}>
                <div className={styles["img-container"]}>
                    <img className={styles["post-image"]}
                         src="https://images.unsplash.com/photo-1511694009171-3cdddf4484ff?q=80&w=2070&a
                     uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                         alt="cat"/>
                </div>
                <div>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam at autem deserunt
                    error excepturi iusto, molestiae neque nobis...
                </div>
            </div>
            <section id={styles.tags}>
                <span className={styles.tag}>Cat</span>
                <span className={styles.tag}>Nap</span>
                <span className={styles.tag}>Catnip</span>
                <span className={styles.tag}>Humans are annoying</span>
                <span className={styles.tag}>Sunny day</span>
            </section>
            <section id={styles.interactions}>
                <div id={styles['favorite-container']}>
                    <i className={'material-symbols-outlined'}>favorite</i>
                    <span>10k</span>
                </div>
                <div id={styles['comment-container']}>
                    <i className={'material-symbols-outlined'}>comment</i>
                    <span>504</span>
                </div>
                <div id={styles['share-container']}>
                    <i className={'material-symbols-outlined'}>share</i>
                    <span>43</span>
                </div>
            </section>
            <hr/>
            <section className={`${styles['comment-section']} ${(props.page === "ViewPost") ? styles["hide"]: ""}`}>
                <span id={styles['view-comments']}>View Comments</span>
            </section>
        </div>
    );
};

export default Post;