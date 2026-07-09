package se.supernovait.bigflavour.presentation.navigation

interface NavigationRoute {
    val titleId: Int
    val iconId: Int
    val selectedIconId: Int?
        get() = null
    val param: String?
        get() = null
    val isHome: Boolean
        get() = false
    val hasNews: Boolean
        get() = false
    val badgeCount: Int?
        get() = null
}
