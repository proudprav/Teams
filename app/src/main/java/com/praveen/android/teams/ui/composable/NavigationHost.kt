package com.praveen.android.teams.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.get
import java.util.*

fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument> = Collections.emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    addDestination(
        ComposeNavigator.Destination(provider[ComposeNavigator::class], content).apply {
            this.route = route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
        }
    )
}