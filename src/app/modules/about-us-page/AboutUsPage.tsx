import React from 'react'
import {Navigate, Outlet, Route, Routes} from 'react-router-dom'
import {PageLink, PageTitle} from '../../../_zenmo/layout/core'
import {EmptyContent} from "../../../_zenmo/helpers/components/EmptyContent.tsx";
import {ShapedIcon} from "../../../_zenmo/helpers/components/ShapedIcon.tsx";

const accountBreadCrumbs: Array<PageLink> = [
    {
        title: 'About Us',
        path: '/abt/md',
        isSeparator: false,
        isActive: false,
    },
    {
        title: '',
        path: '',
        isSeparator: true,
        isActive: false,
    },
]

const AboutUsPage: React.FC = () => {
    return (
        <Routes>
            <Route
                element={
                    <>
                        <Outlet/>
                    </>
                }
            >
                <Route
                    path='md'
                    element={
                        <>
                            <PageTitle breadcrumbs={accountBreadCrumbs}>Media</PageTitle>
                            <EmptyAboutUsContent title={'Media'}/>
                        </>
                    }
                />
                <Route
                    path='ost'
                    element={
                        <>
                            <PageTitle breadcrumbs={accountBreadCrumbs}>Our Story</PageTitle>
                            <EmptyAboutUsContent title={'Our Story'}/>
                        </>
                    }
                />
                <Route
                    path='tm'
                    element={
                        <>
                            <PageTitle breadcrumbs={accountBreadCrumbs}>Our Team</PageTitle>
                            <EmptyAboutUsContent title={'Our Team'}/>
                        </>
                    }
                />
                <Route
                    path='ct'
                    element={
                        <>
                            <PageTitle breadcrumbs={accountBreadCrumbs}>Our Team</PageTitle>
                            <EmptyAboutUsContent title={'Contact'}/>
                        </>
                    }
                />
                <Route index element={<Navigate to='/abt/md'/>}/>
            </Route>
        </Routes>
    )
}

const EmptyAboutUsContent: React.FC<{ title: string }> = ({title}) => {
    return (
        <>
            <EmptyContent
                title={title + " Page"}
                subtitle={'Coming soon'}
                className={'flex-center mt-20  rounded-5  h-700px'}
                displayContent={<>
                    <ShapedIcon
                        fill={'#F9F9F9'}
                        icon={'category'}
                        stroke={'#C4CADA'}
                        color={'gray-500'}
                        iconType={'outline'}
                        size={'70px'}
                    />
                </>}
            />
        </>
    )
}

export default AboutUsPage
