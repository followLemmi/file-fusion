package views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import java.io.File
import java.nio.file.Files

@Composable
@Preview
fun FileComponent(file : File, onClick: () -> Unit) {
    val fileSize = try {
        "" + Files.size(file.toPath())
    } catch (e: Exception) {
        ""
    }
    MaterialTheme {
        Row(modifier = Modifier.clickable {
            onClick()
        }) {
            Text(file.path, modifier = Modifier.padding(end = 15.dp))
            Text(fileSize)
        }
    }
}