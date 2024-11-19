import React from 'react'
import Styles from './InfoWindow.module.css'
import Tags from './Tags';
import Info from './InfoPanel';
interface Props {

}

const InfoWindow: React.FC<Props> = () => {

    return (
        <div className={Styles["container"]}>
            <div className={Styles["header"]}>Mews/Events</div>
            <div className={Styles["tag-panel"]}>
                <Tags/>
            </div>
            <div className={Styles["info-panels"]}>    
                <Info/>
                <Info/>
                <Info/>
                <Info/>
            </div>
            <a className={Styles["link"]}>More</a>
        </div>
    );
};

export default InfoWindow;