package com.zenmo.web.zenmo.models.navigation

data class MenuLanguage(
    val en: String,
    val nl: String,
)

/**
 * Represents a menu item in the navigation bar.
 * The [MenuItem] can be either a simple item with a path and language
 * or a complex item with sub-items.
 * */
sealed class MenuItem {
    data class Simple(
        val path: String = "",
        val title: MenuLanguage
    ) : MenuItem() {
        val getPath: String
            get() = path.ifEmpty { title.en.asNavLinkPath() }
    }

    /**
     * Represents a menu item with sub-items.
     * The [title] is the main title of the menu item,
     * and [subItems] is a list of menu items.
     * */
    data class WithSubs(val path: String = "", val title: MenuLanguage, val subItems: List<MenuLanguage>) : MenuItem()

    companion object {
        val menuItems = listOf(
            Simple(path = "/", title = MenuLanguage(en = "Home", nl = "Thuis")),
            Simple(
                title = MenuLanguage(
                    en = "What we do",
                    nl = "Wat we doen"
                )
            ),
            Simple(
                title = MenuLanguage(
                    en = "Customers",
                    nl = "Klanten"
                )
            ),
            WithSubs(
                title = MenuLanguage(en = "About us", nl = "Over ons"),
                subItems = listOf(
                    MenuLanguage(en = "Our Team", nl = "Ons Team"),
                    MenuLanguage(en = "Jobs", nl = "Banen"),
                    MenuLanguage(en = "History", nl = "Geschiedenis"),
                )
            ),
            Simple(
                title = MenuLanguage(en = "Contact", nl = "Contact")
            )
        )
    }

}


fun String.asNavLinkPath(
    base: String = ""
): String {
    val basePath = if (base.isNotBlank()) "/${base.trim()}" else ""
    return "$basePath/${this.trim()}".replace(" ", "-").lowercase()
}
