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
            <input placeholder={'Search'} id={styles['search-bar']}/>
            <div className={styles['nav-items']}>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>home</i>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>person</i>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>notifications</i>
                <i className={`material-icons-outlined ${styles['nav-item']}`}>settings</i>
                <i className={`material-icons-outlined ${styles['nav-item']} ${styles['closed']}`} onClick={toggleMenu}>
                    {icon}
                </i>
            </div>
        </div>

    );
};

export default Navbar;