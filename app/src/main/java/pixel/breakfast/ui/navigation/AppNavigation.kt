package pixel.breakfast.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pixel.breakfast.R
import pixel.breakfast.ui.components.AppHeader
import pixel.breakfast.ui.components.HomeHeader
import pixel.breakfast.ui.screen.home.HomeScreen
import pixel.breakfast.ui.screen.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // Record current route
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp),
        // ====== top bar ======
        topBar = {
            when (currentRoute) {
                Routes.HOME -> HomeHeader("John")
                Routes.CART, Routes.COUPON, Routes.ORDERS -> {
                    AppHeader(
                        title = when (currentRoute) {
                            Routes.CART -> stringResource(R.string.cart_screen_title)
                            Routes.COUPON -> "優惠券"
                            Routes.ORDERS -> "訂單"
                            else -> ""
                        },
                        onBackClick = { navController.popBackStack() }
                    )
                }

                else -> Unit
            }
        },
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Routes.HOME) {
                val homeVm: HomeViewModel = hiltViewModel()
                val homeState by homeVm.uiState.collectAsStateWithLifecycle()
                HomeScreen(state = homeState)
            }

            composable(Routes.CART) {}
        }
    }
}
