package me.tmbmnadim.dhaka_unleashed


import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import me.tmbmnadim.dhaka_unleashed.ui.DhakaPlacesScreen
import me.tmbmnadim.dhaka_unleashed.ui.PlacesDescriptionScreen
import me.tmbmnadim.dhaka_unleashed.utils.DhakaUnleashContentType
import me.tmbmnadim.dhaka_unleashed.view_model.DhakaPlacesViewModel

@Composable
fun DhakaUnleashedApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: DhakaPlacesViewModel = viewModel()
    val contentType: DhakaUnleashContentType
    val uiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = DhakaUnleashContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            contentType = DhakaUnleashContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = DhakaUnleashContentType.LIST_AND_DETAIL
        }
        else -> {
            contentType = DhakaUnleashContentType.LIST_ONLY
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DhakaUnleashedAppBar(
                title = "Dhaka Unleashed",
                showBackIcon =
                    contentType == DhakaUnleashContentType.LIST_ONLY
                            && !uiState.isShowingHomepage,
                onBackPressed = {
                    if(contentType == DhakaUnleashContentType.LIST_ONLY) {
                        viewModel.resetHomeScreenStates()
                    }
                }
            )
        }
    ) { innerPadding ->
        if(contentType == DhakaUnleashContentType.LIST_ONLY){
            if (uiState.isShowingHomepage) {
                DhakaPlacesScreen(
                    modifier = modifier.padding(innerPadding),
                    onTap = {
                        viewModel.updateDetailsScreenStates(it)
                    }
                )
            } else {
                PlacesDescriptionScreen(
                    modifier = modifier.padding(innerPadding),
                    place = uiState.selectedPlace,
                    onBackPressed = {
                        viewModel.resetHomeScreenStates()
                    }
                )
            }
        } else {
            val activity = LocalActivity.current
            Row(modifier = Modifier) {
                DhakaPlacesScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth(0.5f),
                    onTap = {
                        viewModel.updateDetailsScreenStates(it)
                    }
                )
                PlacesDescriptionScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth(0.5f),
                    place = uiState.selectedPlace,
                    onBackPressed = {
                        activity?.finish()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DhakaUnleashedAppPreview() {
    DhakaUnleashedApp(
        windowSize = WindowWidthSizeClass.Compact
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DhakaUnleashedAppBar(
    title: String,
    showBackIcon: Boolean = false,
    onBackPressed: () -> Unit = {}
) {
    TopAppBar(
        navigationIcon = {
            if (showBackIcon) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Open Navigation Menu"
                    )
                }
            }
        },
        title = {
            Text(title)
        }
    )
}