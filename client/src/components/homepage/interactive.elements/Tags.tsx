import React from 'react'
import Styles from './Tags.module.css'
interface Props {

}

const Tags: React.FC<Props> = () => {

    return (
        <div className={Styles["container"]}>
            <div className={Styles["header"]}>tags</div>
            <div className={Styles["tags"]}>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
                <div className={Styles["tag"]}>info</div>
            </div>
        </div>
    );
};

export default Tags;