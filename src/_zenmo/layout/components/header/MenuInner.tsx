import React from 'react'
import {MenuItem} from './MenuItem'
import {MenuInnerWithSub} from './MenuInnerWithSub'
import {ToolsMenu} from './ToolsMenu.tsx'

export function MenuInner() {
    return (
        <>
            <MenuItem title={'Authorities'} to='/authrt'/>
            <MenuItem title='Grid Management' to='/gmgt'/>
            <MenuItem title='Mobility' to='/mblt'/>
            <MenuItem title='Virtual Labs' to='/vtlbs'/>

            <MenuInnerWithSub
                isMega={true}
                title='Tools'
                to='/tools'
                menuPlacement='bottom-start'
                menuTrigger={`{default:'click', lg: 'hover'}`}
            >
                <ToolsMenu/>
            </MenuInnerWithSub>


            <MenuItem title='Vacancies' to='/vcns'/>

            <MenuInnerWithSub
                title='About Us'
                to='/abt'
                menuPlacement='bottom-start'
                menuTrigger={`{default:'click', lg: 'hover'}`}
            >
                {/* PAGES */}
                <MenuItem to='/abt/md' title='Media' icon='element-plus'/>
                <MenuItem to='/abt/ost' title='Our Story' icon='data'/>
                <MenuItem to='/abt/tm' title='Our Team' icon='people'/>
                <MenuItem to='/abt/ct' title='Contact' icon='phone'/>

            </MenuInnerWithSub>
        </>
    )
}
