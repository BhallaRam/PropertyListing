package com.assessment.propertylisting.presentation.user.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.model.UserRole
import com.assessment.propertylisting.presentation.components.AppTopBar
import com.assessment.propertylisting.presentation.components.EmptyState
import com.assessment.propertylisting.presentation.components.ErrorState
import com.assessment.propertylisting.presentation.components.FilterBottomSheet
import com.assessment.propertylisting.presentation.components.LoadingState
import com.assessment.propertylisting.presentation.components.PropertyCard
import com.assessment.propertylisting.presentation.components.SearchBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDashboardScreen(
    onNavigateToPropertyDetail: (String) -> Unit,
    onLogout: () -> Unit,
    viewModel: UserDashboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showFilterSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        topBar = {
            AppTopBar(
                title = "EstatePro",
                role = UserRole.USER,
                onLogoutClick = { viewModel.logout(onLogout) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Search Bar with Active Filter Count
                SearchBarComponent(
                    query = uiState.filter.searchQuery,
                    onQueryChange = { viewModel.onSearchQueryChange(it) },
                    onFilterClick = { showFilterSheet = true },
                    activeFilterCount = uiState.filter.activeFilterCount
                )

                // Quick Type Filter Chips Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilterChip(
                        selected = uiState.filter.propertyType == null,
                        onClick = { viewModel.onPropertyTypeQuickFilter(null) },
                        label = { Text("All Types") },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )

                    PropertyType.entries.forEach { type ->
                        FilterChip(
                            selected = uiState.filter.propertyType == type,
                            onClick = { viewModel.onPropertyTypeQuickFilter(type) },
                            label = { Text(type.displayName) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }

                // Active Filters Banner (if location, price, status, or configuration is set)
                if (uiState.filter.isActive) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(horizontal = 16.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        uiState.filter.location?.let { loc ->
                            AssistChip(
                                onClick = { viewModel.onApplyFilter(uiState.filter.copy(location = null)) },
                                label = { Text("City: $loc") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove",
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                }
                            )
                        }

                        uiState.filter.configuration?.let { config ->
                            AssistChip(
                                onClick = { viewModel.onApplyFilter(uiState.filter.copy(configuration = null)) },
                                label = { Text("Config: $config") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove",
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                }
                            )
                        }

                        uiState.filter.maximumPrice?.let { maxPrice ->
                            val lac = (maxPrice / 100000.0).toInt()
                            AssistChip(
                                onClick = { viewModel.onApplyFilter(uiState.filter.copy(maximumPrice = null)) },
                                label = { Text("Under ₹$lac Lac") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove",
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                }
                            )
                        }

                        uiState.filter.status?.let { status ->
                            AssistChip(
                                onClick = { viewModel.onApplyFilter(uiState.filter.copy(status = null)) },
                                label = { Text(status.displayName) },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove",
                                        modifier = Modifier.padding(end = 4.dp)
                                    )
                                }
                            )
                        }
                    }
                }

                // Results count and header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Properties (${uiState.filteredProperties.size})",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )

                    if (uiState.filter.isActive) {
                        Text(
                            text = "Filtered",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }

                // Main Content Body
                when {
                    uiState.isLoading -> {
                        LoadingState(
                            message = "Loading available properties...",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    uiState.errorMessage != null -> {
                        ErrorState(
                            message = uiState.errorMessage ?: "An error occurred",
                            onRetry = { viewModel.retry() },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    uiState.filteredProperties.isEmpty() -> {
                        EmptyState(
                            title = "No Properties Found",
                            subtitle = "We couldn't find any properties matching your current criteria. Try adjusting or clearing your filters.",
                            actionLabel = "Clear Filters",
                            onActionClick = { viewModel.onClearFilter() },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    else -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(
                                items = uiState.filteredProperties,
                                key = { it.id }
                            ) { property ->
                                PropertyCard(
                                    property = property,
                                    onClick = { onNavigateToPropertyDetail(property.id) }
                                )
                            }
                        }
                    }
                }
            }

            // Filter Bottom Sheet
            if (showFilterSheet) {
                FilterBottomSheet(
                    currentFilter = uiState.filter,
                    onApplyFilter = { newFilter ->
                        viewModel.onApplyFilter(newFilter)
                    },
                    onDismiss = { showFilterSheet = false },
                    sheetState = sheetState
                )
            }
        }
    }
}
