import React, {useState} from "react";
import styles from "./ProfileCardMobile.module.css";
import UserListIcon from "../common/UserListIcon";
interface Props {

}

const ProfileCardMobile: React.FC<Props> = () => {

    const [selection, setSelection] = useState<String>("About");


    return (
        <div id={styles['profileCard-container']}>
            <div className={styles['user-detail-container']}>
                <div className={styles['main-pic-container']}>
                    <img className={styles['main-pic']}
                     src="https://plus.unsplash.com/premium_photo-1673967796686-154ab5ad9ca1?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="cat paw"/>
                </div>
                <div id={styles['name-container']}>
                    <div className={styles['first-name']}>Luke</div>
                    <div className={styles['last-name']}>Meowton</div>
                </div>
            </div>
            <div className={styles['profile-btn-container']}>
                <button className={styles['edit-prof-btn']}>
                    <span>Edit Profile</span>
                    <i className={'material-symbols-outlined'}>edit</i>
                </button>
            </div>
            <hr/>
            <section className={styles['profile-info-container']}>
                <ul className={styles['profile-selections']}>
                    <li onClick={() => {setSelection("About")}} 
                        className={(selection === "About") ? `${styles['active']}` : "" }>About</li>
                    <li onClick={() => {setSelection("Friends")}} 
                        className={(selection === "Friends") ? `${styles['active']}` : "" }>Friends</li>
                    <li onClick={() => {setSelection("Followers")}}
                        className={(selection === "Followers") ? `${styles['active']}` : "" }>Followers</li>
                </ul>
                {selection === "About" && 
                    <div>
                    <ul className={styles['profile-info']}>
                        <li>Gender: Male</li>
                        <li>Species: Cat</li>
                        <li>Breed: Norwegian Forest</li>
                    </ul>
                    </div>
                }
                {selection === "Friends" && 
                    <div>
                        <UserListIcon/>
                    </div>
                }
                {selection === "Followers" && 
                    <div>
                        <UserListIcon/>
                    </div>
                }
            </section>
        </div>
    );
};

export default ProfileCardMobile;