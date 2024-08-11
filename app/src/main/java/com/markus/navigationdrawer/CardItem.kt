package com.markus.navigationdrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun CardItem(
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column(modifier.padding(16.dp)) {
        HorizontalDivider()
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier
                .fillMaxWidth()
                .clickable {
                    scope.launch {
                        snackbarHostState.showSnackbar(message = "Card Clicked!")
                    }
                }
        ) {
            Text(
                text = "clerks+59",
                textAlign = TextAlign.Center
            )
        }
    }
}