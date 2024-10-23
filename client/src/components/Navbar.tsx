import React, {useState} from "react";
import logo from "../pawsitivity-icon.png";
import styles from "./Navbar.module.css";
interface Props {

}

const Navbar: React.FC<Props> = () => {

    const [icon, setIcon] = useState<string>("menu")

    const toggleMenu = () => {
        icon === "menu" ? setIcon("menu_open") : setIcon("menu");
    }

    return (
        <div className={styles['nav-container']}>
            <div id={styles['logo-container']}><img id={styles['logo']} src={logo} alt='pawsitivity logo'/></div>

            <div id={styles['search-container']}>
                <input placeholder={'Search'} id={styles['search-bar']}/>
                <i id={styles['search-icon']} className={'material-icons-outlined'}>search</i>
            </div>


            <ul className={`${styles['nav-items']} ${icon === "menu_open" ? styles.active : ""}`}>
                <li className={styles['nav-item']}>
                    <i className={'material-icons-outlined'}>home</i>
                    <span>Home</span>
                </li>
                <li className={styles['nav-item']}>
                    <i className={'material-icons-outlined'}>person</i>
                    <span>Profile</span>
                </li>
                <li className={styles['nav-item']}>
                    <i className={'material-icons-outlined'}>notifications</i>
                    <span>Notifications</span>
                </li>
                <li className={styles['nav-item']}>
                    <i className={'material-icons-outlined'}>settings</i>
                    <span>Settings</span>
                </li>

                {/*<i className={`material-icons-outlined ${styles['nav-item']}`}>home</i>*/}
                {/*<i className={`material-icons-outlined ${styles['nav-item']}`}>person</i>*/}
                {/*<i className={`material-icons-outlined ${styles['nav-item']}`}>notifications</i>*/}
                {/*<i className={`material-icons-outlined ${styles['nav-item']}`}>settings</i>*/}
            </ul>

            <i className={`material-icons-outlined ${styles['closed']} ${styles['hamburger']}`}
               onClick={toggleMenu}>
                {icon}
            </i>
        </div>

    );
};

export default Navbar;