import React, { useState } from "react";
import styles from "./SideProfile.module.css";
import UserListIcon from "./UserListIcon";
interface Props {}

const SideProfile: React.FC<Props> = () => {
  return (
    <div id={styles["side-profile-container"]}>
      <div id={styles["side-prof-inner"]}>
        <section className={styles["prof-top"]}>
          <h2>Profile</h2>
          <div className={styles["main-pic-container"]}>
            <img
              className={styles["main-pic"]}
              src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                        uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
              alt="profile"
            />
          </div>
          <div id={styles["name-container"]}>
            <span className={styles["first-name"]}>Luke</span>
            <span className={styles["last-name"]}>Meowton</span>
          </div>
          <div className={styles["profile-buttons"]}>
            <button>Follow</button>
            <button>Add Friend</button>
          </div>
        </section>
        <hr style={{ margin: "0 1rem" }} />
        <section className={styles["about-container"]}>
          <h3>About</h3>
          <ul className={styles["about-info-list"]}>
            <li>Gender: Male</li>
            <li>Species: Cat</li>
            <li>Breed: Norwegian Forest</li>
          </ul>
        </section>
        <section className={styles["friends-container"]}>
          <UserListIcon />
        </section>
        <section className={styles["followers-container"]}>
          <UserListIcon />
        </section>
      </div>
    </div>
  );
};

export default SideProfile;
