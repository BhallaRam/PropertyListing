package com.assessment.propertylisting.presentation.navigation

/**
 * Sealed routes hierarchy defining all destination paths and argument keys in the application.
 */
sealed class Routes(val route: String) {
    object Login : Routes("login")
    object UserDashboard : Routes("user_dashboard")
    
    object PropertyDetail : Routes("property_detail/{propertyId}") {
        const val ARG_PROPERTY_ID = "propertyId"
        fun createRoute(propertyId: String): String = "property_detail/$propertyId"
    }

    object InterestForm : Routes("interest_form/{propertyId}") {
        const val ARG_PROPERTY_ID = "propertyId"
        fun createRoute(propertyId: String): String = "interest_form/$propertyId"
    }

    object OwnerDashboard : Routes("owner_dashboard/{ownerId}") {
        const val ARG_OWNER_ID = "ownerId"
        fun createRoute(ownerId: String): String = "owner_dashboard/$ownerId"
    }

    object AddEditProperty : Routes("add_edit_property/{ownerId}?propertyId={propertyId}") {
        const val ARG_OWNER_ID = "ownerId"
        const val ARG_PROPERTY_ID = "propertyId"
        fun createRoute(ownerId: String, propertyId: String? = null): String {
            return if (!propertyId.isNullOrBlank()) {
                "add_edit_property/$ownerId?propertyId=$propertyId"
            } else {
                "add_edit_property/$ownerId"
            }
        }
    }
}
