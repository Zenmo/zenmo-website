import React, {FC} from "react";
import {KTIcon} from "../index.ts";

type ShapedIconProps = {
    icon?: string
    color?: string
    size?: string
    fill?: string
    stroke?: string
    pathD?: string
    iconType?: 'outline' | 'solid' | 'duotone'
}
export const ShapedIcon: FC<ShapedIconProps> = ({
                                                    icon = 'user',
                                                    iconType = 'outline',
                                                    color = 'primary',
                                                    size = '65px',
                                                    fill = '#E9F3FF',
                                                    stroke = '#d73166',
                                                    pathD = 'M10.2,21.23,4.91,18.17a3.58,3.58,0,0,1-1.8-3.11V8.94a3.58,3.58,0,0,1,1.8-3.11L10.2,2.77a3.62,3.62,0,0,1,3.6,0l5.29,3.06a3.58,3.58,0,0,1,1.8,3.11v6.12a3.58,3.58,0,0,1-1.8,3.11L13.8,21.23A3.62,3.62,0,0,1,10.2,21.23Z'
                                                }) => {
    return (
        <div
            className='d-flex h-80px w-80px flex-shrink-0 flex-center position-relative'>
            <svg
                xmlns='http://www.w3.org/2000/svg'
                viewBox='0 0 24 24'
                className={`text-${color} h-${size} w-${size}  position-absolute `}
            >
                <path
                    fill={fill}
                    stroke={stroke}
                    strokeWidth={0.5}
                    d={pathD}
                ></path>
            </svg>
            <KTIcon iconName={icon} iconType={iconType}
                    className={`fs-1 text-${color} position-absolute`}/>
        </div>
    );
};