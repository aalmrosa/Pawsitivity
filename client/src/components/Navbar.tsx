import React, {useState} from "react";
import logo from "../pawsitivity-icon.png";
import styles from "./Navbar.module.css";
import { Link } from "react-router-dom";
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
                <i id={styles['search-icon']} className={'material-symbols-outlined'}>search</i>
            </div>

            <ul className={`${styles['nav-items']} ${icon === "menu_open" ? styles.active : ""}`}>
                <li className={styles['nav-item']}>
                    <Link to="/">
                        <i className={'material-symbols-outlined'}>home</i>
                        <span>Home</span>
                    </Link>
                    
                </li>
                <li className={styles['nav-item']}>
                    <Link to="/profile">
                        <i className={'material-symbols-outlined'}>person</i>
                        <span>Profile</span>
                    </Link>
                    
                </li>
                <li className={styles['nav-item']}>
                    <Link to="/">
                        <i className={'material-symbols-outlined'}>notifications</i>
                        <span>Notifications</span>
                    </Link>
                </li>
                <li className={styles['nav-item']}>
                    <Link to="/">
                        <i className={'material-symbols-outlined'}>settings</i>
                        <span>Settings</span>
                    </Link>
                </li>
            </ul>

            <i className={`material-symbols-outlined ${styles['closed']} ${styles['hamburger']}`}
               onClick={toggleMenu}>
                {icon}
            </i>
        </div>

    );
};

export default Navbar;