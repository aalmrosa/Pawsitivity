import React from 'react'
import Styles from './InfoPanel.module.css'
interface Props {

}

const Info: React.FC<Props> = () => {

    return (
        <div className={Styles["container"]}>
            <img className={Styles["prof-pic"]}
                    src="https://images.unsplash.com/photo-1561948955-570b270e7c36?q=80&w=1802&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                    alt="profile picture"/>
            <p className={Styles["content"]}>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quidem adipisci 
                cupiditate voluptate non ullam, officiis illum magni iusto magnam eius eveniet 
                labore velit nam consequatur delectus eum perspiciatis temporibus cum.
            </p>
        </div>
    );
};

export default Info;