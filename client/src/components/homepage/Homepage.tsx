import React, { useState } from "react";
import styles from "./Homepage.module.css";
import Post from "../common/Post";
import SideProfile from "../common/SideProfile";
import InfoWindow from "../common/InfoWindow";
import { create } from "domain";
interface Props {

}

const Homepage: React.FC<Props> = () => {

    const [visibility, setVisibility] = useState("PUBLIC");
    const [content, setContent] = useState("");

    const createPost = async(event: React.FormEvent<HTMLFormElement>): Promise<void> => {
        event.preventDefault();
        
        try {
            const response = await fetch("http://localhost:8080/post/create", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({'content': content, 'visibility': visibility})
            });
            if(response.ok){
                console.log("CREATED POST")
            }
            else{
                console.log("UNABLE TO CREATE POST");
            }
            setContent("");
            setVisibility("PUBLIC");
        } catch (error){
            console.log("create error");
        }
    }

    return (
        <div className={styles["container"]}>
            <section className={`${styles['side-profile-container']} ${styles['sticky']}`} >
                <SideProfile/>
            </section>

            <section className={styles["feed-container"]}>
                <section className={styles["create-post"]}>
                    <div className={styles["prof-pic-container"]}>
                        <img className={styles["prof-pic"]}
                            src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            alt="profile picture"/>
                    </div>
                    <form className={styles["new-post-text"]} onSubmit={createPost}>
                        <select className="visibility" value={visibility} onChange={(e)=>setVisibility(e.target.value)}>
                            <option selected value="PUBLIC">Public</option>
                            <option value="FRIENDS_ONLY">Friends Only</option>
                            <option value="PRIVATE">Private</option>
                        </select>
                        <textarea 
                        onChange={(e) => setContent(e.target.value)}
                        className={styles["new-post-text"]}
                        placeholder={"What are your pet peeves regarding humans? Do share!"}
                        value={content}>
                        </textarea>
                        <input type="submit"/>
                    </form>
                    
                </section>
                <section className={styles["info-mbl-only"]}>
                    <InfoWindow/>
                </section>
                <section className={styles["feed-posts-container"]}>
                    <Post/>
                    <Post/>
                    <Post/>
                    <Post/>
                    <Post/>
                    <Post/>
                    <Post/>
                    <Post/>
                    <span className={styles["load-btn"]}>Load more</span>
                </section>
            </section>
            
            <section className={`${styles['right-container']} ${styles['sticky']}`}>
                <InfoWindow/>
                <InfoWindow/>
            </section>
        </div>
  );
};

export default Homepage;
