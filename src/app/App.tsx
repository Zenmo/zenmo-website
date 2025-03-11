import {Suspense} from 'react'
import {Outlet} from 'react-router-dom'
import {I18nProvider} from '../_zenmo/i18n/i18nProvider'
import {LayoutProvider, LayoutSplashScreen} from '../_zenmo/layout/core'
import {MasterInit} from '../_zenmo/layout/MasterInit'
import {ThemeModeProvider} from '../_zenmo/partials'

const App = () => {
    return (
        <Suspense fallback={<LayoutSplashScreen/>}>
            <I18nProvider>
                <LayoutProvider>
                    <ThemeModeProvider>
                        <Outlet/>
                        <MasterInit/>
                    </ThemeModeProvider>
                </LayoutProvider>
            </I18nProvider>
        </Suspense>
    )
}

export {App}
