import React, {useState} from "react";
import logo from "../pawsitivity-icon.png";
import styles from "./Navbar.module.css";
interface Props {

}

const Navbar: React.FC<Props> = () => {

    return (
        <div className={styles['nav-container']}>
            <div><img id={styles['logo']} src={logo} alt='pawsitivity logo'/></div>
            <div className={styles['nav-items']}>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>home</i>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>person</i>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>more_vert</i>
            </div>
        </div>

    );
};

export default Navbar;