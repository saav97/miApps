package com.example.miapps

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miapps.ui.theme.MiAppsTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


private val messages: List<MyMessage> = listOf(
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack \"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a fre" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack \"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a fre" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
    MyMessage("Arriagada Alejandro","Desarrollo Full Stack" ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiAppsTheme {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body:String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyImage() {
    Image(painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de ejemplo!",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp))

}

@Composable
fun MyTexts(message: MyMessage) {
    var expanded by remember { mutableStateOf(false) }
    Column (modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(text = message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(text = message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if (expanded) Int.MAX_VALUE else 1)
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    MiAppsTheme {
        MyMessages(messages)
    }
}







