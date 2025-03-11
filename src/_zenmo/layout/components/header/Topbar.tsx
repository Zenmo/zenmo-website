import clsx from 'clsx'
import React, {FC} from 'react'
import {KTIcon} from '../../../helpers'
import {ThemeModeSwitcher,} from '../../../partials'

const toolbarButtonMarginClass = 'ms-1 ms-lg-3',
    toolbarButtonHeightClass = 'w-30px h-30px w-md-40px h-md-40px',
    toolbarButtonIconSizeClass = 'fs-1'

const Topbar: FC = () => {
    return (
        <div className='d-flex align-items-stretch flex-shrink-0'>
            <div className='topbar d-flex align-items-stretch flex-shrink-0'>

                {/* Activities */}
                <div className={clsx('d-flex align-items-center ', toolbarButtonMarginClass)}>
                    {/* begin::Drawer toggle */}
                    <div
                        className={clsx(
                            'btn btn-icon btn-active-light-primary btn-custom',
                            toolbarButtonHeightClass
                        )}
                        id='kt_activities_toggle'
                    >
                        <KTIcon iconName='chart-simple' className={toolbarButtonIconSizeClass}/>
                    </div>
                    {/* end::Drawer toggle */}
                </div>


                {/* begin::Theme mode */}
                <div className={'d-flex align-items-center ms-lg-5'}>
                    <ThemeModeSwitcher
                        toggleBtnClass='btn btn-active-light d-flex align-items-center bg-hover-light py-2 px-2 px-md-3'/>
                </div>
                {/* end::Theme mode */}

            </div>
        </div>
    )
}

export {Topbar}
