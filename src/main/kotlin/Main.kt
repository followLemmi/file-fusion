import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import views.FileComponent

@Composable
@Preview
fun app() {
    val fileTest : FileTest = FileTest()
    var files by remember { mutableStateOf(fileTest.getFiles()) }
    MaterialTheme {
        Column {
            files.forEach {file ->
                FileComponent(file, onClick = {
                    files = fileTest.getInnerFiles(file)
                })
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}
