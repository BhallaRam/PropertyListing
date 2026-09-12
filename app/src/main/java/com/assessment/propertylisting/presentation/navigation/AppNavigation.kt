package com.assessment.propertylisting.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.assessment.propertylisting.presentation.login.LoginScreen
import com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyScreen
import com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardScreen
import com.assessment.propertylisting.presentation.user.dashboard.UserDashboardScreen
import com.assessment.propertylisting.presentation.user.interest.InterestFormScreen
import com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailScreen

/**
 * Top-level application navigation graph coordinating screen routing,
 * argument passing, and backstack safety.
 * Always launches into the Login screen upon app open.
 */
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route,
        modifier = modifier
    ) {
        // 1. Login Screen
        composable(route = Routes.Login.route) {
            LoginScreen(
                onNavigateToUserDashboard = {
                    navController.navigate(Routes.UserDashboard.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                },
                onNavigateToOwnerDashboard = { ownerId ->
                    navController.navigate(Routes.OwnerDashboard.createRoute(ownerId)) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // 2. User Dashboard
        composable(route = Routes.UserDashboard.route) {
            UserDashboardScreen(
                onNavigateToPropertyDetail = { propertyId ->
                    navController.navigate(Routes.PropertyDetail.createRoute(propertyId))
                },
                onLogout = {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        // 3. Property Detail Screen
        composable(
            route = Routes.PropertyDetail.route,
            arguments = listOf(
                navArgument(Routes.PropertyDetail.ARG_PROPERTY_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            PropertyDetailScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToInterestForm = { propertyId ->
                    navController.navigate(Routes.InterestForm.createRoute(propertyId))
                }
            )
        }

        // 4. Interest Form Screen
        composable(
            route = Routes.InterestForm.route,
            arguments = listOf(
                navArgument(Routes.InterestForm.ARG_PROPERTY_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            InterestFormScreen(
                onNavigateBack = { navController.popBackStack() },
                onSubmissionSuccess = {
                    navController.popBackStack(Routes.UserDashboard.route, inclusive = false)
                }
            )
        }

        // 5. Owner Dashboard Screen
        composable(
            route = Routes.OwnerDashboard.route,
            arguments = listOf(
                navArgument(Routes.OwnerDashboard.ARG_OWNER_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            OwnerDashboardScreen(
                onNavigateToPropertyDetail = { propertyId ->
                    navController.navigate(Routes.PropertyDetail.createRoute(propertyId))
                },
                onNavigateToAddProperty = { ownerId ->
                    navController.navigate(Routes.AddEditProperty.createRoute(ownerId))
                },
                onNavigateToEditProperty = { ownerId, propertyId ->
                    navController.navigate(Routes.AddEditProperty.createRoute(ownerId, propertyId))
                },
                onLogout = {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        // 6. Add / Edit Property Screen
        composable(
            route = Routes.AddEditProperty.route,
            arguments = listOf(
                navArgument(Routes.AddEditProperty.ARG_OWNER_ID) {
                    type = NavType.StringType
                },
                navArgument(Routes.AddEditProperty.ARG_PROPERTY_ID) {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            AddEditPropertyScreen(
                onNavigateBack = { navController.popBackStack() },
                onSaveSuccess = { navController.popBackStack() }
            )
        }
    }
}
