import {FC, lazy, Suspense} from 'react'
import {Navigate, Route, Routes} from 'react-router-dom'
import {MasterLayout} from '../../_zenmo/layout/MasterLayout'
import TopBarProgress from 'react-topbar-progress-indicator'
import {getCSSVariableValue} from '../../_zenmo/assets/ts/_utils'
import {DisableSidebar} from '../../_zenmo/layout/core'
import {WithChildren} from '../../_zenmo/helpers'
import {ShapedIcon} from "../../_zenmo/helpers/components/ShapedIcon.tsx";
import {EmptyContent} from "../../_zenmo/helpers/components/EmptyContent.tsx";

const PrivateRoutes = () => {
    const AboutUsPage = lazy(() => import('../modules/about-us-page/AboutUsPage.tsx'))

    return (
        <Routes>
            <Route element={<MasterLayout/>}>
                {/* Redirect to Dashboard after success login/registartion */}
                <Route path='/*' element={<Navigate to='/authrt'/>}/>
                {/* Pages */}
                <Route path='authrt' element={<EmptyRouteContent title={'Authorities'}/>}/>
                {/* Lazy Modules */}
                <Route
                    path='gmgt'
                    element={
                        <SuspensedView>
                            <EmptyRouteContent title={'Grid Management'}/>
                        </SuspensedView>
                    }
                />
                <Route
                    path='mblt'
                    element={
                        <SuspensedView>
                            <EmptyRouteContent title={'Mobility'}/>
                        </SuspensedView>
                    }
                />
                <Route
                    path='vtlbs'
                    element={
                        <SuspensedView>
                            <EmptyRouteContent title={'Virtual Labs'}/>
                        </SuspensedView>
                    }
                />
                <Route
                    path='abt/*'
                    element={
                        <SuspensedView>
                            <AboutUsPage/>
                        </SuspensedView>
                    }
                />
                <Route
                    path='vcns'
                    element={
                        <SuspensedView>
                            <EmptyRouteContent title={'Vacancies'}/>
                        </SuspensedView>
                    }
                />
                {/* Page Not Found */}
                <Route path='*' element={<Navigate to='/authrt'/>}/>
            </Route>
        </Routes>
    )
}

const EmptyRouteContent: React.FC<{ title: string }> = ({title}) => {
    return (
        <>
            <EmptyContent
                title={title + " Page"}
                subtitle={'Coming soon'}
                className={'flex-center mt-20  rounded-5  h-700px'}
                displayContent={<>
                    <ShapedIcon
                        fill={'#F9F9F9'}
                        icon={'information'}
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

const SuspensedView: FC<WithChildren> = ({children}) => {
    const baseColor = getCSSVariableValue('--bs-primary')
    TopBarProgress.config({
        barColors: {
            '0': baseColor,
        },
        barThickness: 2,
        shadowBlur: 5,
    })
    return (
        <Suspense fallback={<TopBarProgress/>}>
            <DisableSidebar>{children}</DisableSidebar>
        </Suspense>
    )
}

export {PrivateRoutes}
