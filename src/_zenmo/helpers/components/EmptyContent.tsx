import React from "react";
import {ShapedIcon} from "./ShapedIcon.tsx";
import {toAbsoluteUrl} from "../AssetHelpers.ts";
import {useThemeMode} from "../../partials";

type Props = {
    actionContent?: React.ReactNode
    displayContent?: React.ReactNode
    title: string
    subtitle?: string
    className?: string
    imagePath?: string
}

export const EmptyContent: React.FC<Props> = ({
                                                  actionContent,
                                                  className,
                                                  displayContent = <>
                                                  <ShapedIcon
                                                      fill={'#F9F9F9'}
                                                      icon={'information-5'}
                                                      stroke={'#C4CADA'}
                                                      color={'gray-500'}
                                                      iconType={'outline'}
                                                      />
                                                  </>,
                                                  subtitle,
                                                  title}) => {
    const {mode} = useThemeMode()
    return (
        <div className={`d-flex flex-column align-items-center justify-content-center ${className}`}
             style={{
                 backgroundPosition: 'right top',
                 backgroundSize: '80% auto',
                 backgroundImage: `
                 ${mode === 'light' && `url(${toAbsoluteUrl('media/patterns/bg-3.png')})` || ''}`,
                    backgroundRepeat: 'no-repeat'
                }}
        >
            {displayContent && displayContent}
            {title && <h3 className="text-gray-800 font-weight-bold mt-10">{title}</h3>}
            {subtitle && <span className="text-muted font-weight-bold mt-2 mb-10">{subtitle}</span>}
            {actionContent}
        </div>
    );
};