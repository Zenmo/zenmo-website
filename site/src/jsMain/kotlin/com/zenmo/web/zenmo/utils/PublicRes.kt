package com.zenmo.web.zenmo.utils

object PublicRes {
    object Images {
        object Avatars {
            private const val PATH = "avatars"

            const val AUKE = "$PATH/Auke_Hoekstra.jpg"
            const val ERIK = "$PATH/Erik.jpg"
        }

        object Logo {
            private const val PATH = "logos"
            const val ZENMO = "$PATH/logo.png"
            // todo add LUX logo
        }
    }

    object FontFamilies {
        const val POPPINS_REGULAR = "PoppinsRegular"
        const val POPPINS_MEDIUM = "PoppinsMedium"
        const val MONTSERRAT_REGULAR = "MontserratRegular"
        const val MONTSERRAT_MEDIUM = "MontserratMedium"
    }

    object StringConstants {
        const val COPY_RIGHT = "©2018-2025 ZEnMo Simulations BV"
        const val DISCLAIMER_URL = "#"
    }
}