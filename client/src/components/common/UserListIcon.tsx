import React, {useState} from "react";
import styles from "./UserListIcon.module.css";
interface Props {

}

const UserListIcon: React.FC<Props> = () => {

    return (
        <div className={styles['people-container']}>
            <h3>Friends</h3>
            <div className={styles["pic-text-container"]}>
                <div className={styles["pic-list-container"]}>
                    <div className={styles['prof-pic-container']}>
                        <img className={styles["prof-pic"]}
                        src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                        uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        alt="profile"/>
                    </div>
                    <div className={styles['prof-pic-container']}>
                        <img className={styles["prof-pic"]}
                        src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                        uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        alt="profile"/>
                    </div>
                    <div className={styles['prof-pic-container']}>
                        <img className={styles["prof-pic"]}
                        src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&a
                        uto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                        alt="profile"/>
                    </div>
                </div>
                <span>and 87 more...</span>
            </div>
        </div>
    );
};

export default UserListIcon;