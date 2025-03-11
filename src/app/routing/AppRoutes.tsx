/**
 * High level router.
 *
 */

import {FC} from 'react'
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import {PrivateRoutes} from './PrivateRoutes'
import {App} from '../App'


const {BASE_URL} = import.meta.env

const AppRoutes: FC = () => {
    return (
        <BrowserRouter basename={BASE_URL}>
            <Routes>
                <Route element={<App/>}>
                    <Route path='/*' element={<PrivateRoutes/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export {AppRoutes}
