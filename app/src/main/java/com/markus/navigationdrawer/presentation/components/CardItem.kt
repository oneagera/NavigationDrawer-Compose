package com.markus.navigationdrawer.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.markus.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()

    Column() {
        Card(
            modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 2.dp)
                .clickable {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Card Clicked!",
                            duration = SnackbarDuration.Short,
                            actionLabel = "done"
                        )
                    }
                },
            shape = CardDefaults.outlinedShape
        ) {
            Text(
                text = "click here",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CardItemPreview() {
    NavigationDrawerTheme {
        CardItem(snackbarHostState = remember { SnackbarHostState() })
    }

}