package com.zenmo.web.zenmo.core.data

enum class StringRes(
    val en: String = "",
    val nl: String = "",
) {
    Home(
        "Home",
        "Thius"
    ),
    About(
        "About",
        "Over"
    ),
    Disclaimer(
        "Disclaimer",
        "Disclaimer"
    ),
    LuxProducts(
        "Lux Products",
        "Lux Producten"
    ),
    LuxEnergyHub(
        "Lux Energy Hub",
        "Lux Energie Hub"
    ),
    AboutZenmo(
        "About ZEnMo",
        "Over ZEnMo"
    ),
    AboutLux(
        "About Lux",
        "Over Lux"
    ),
    OurTeam(
        "Our Team",
        "Ons Team"
    ),
    History(
        "History",
        "Geschiedenis"
    ),
}

fun StringRes.asNavLinkPath(): String = "/${this.name.replace(" ", "-").lowercase()}"
