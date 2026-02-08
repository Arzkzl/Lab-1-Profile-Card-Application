package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardTheme {
                //Main screen layout with full size, padding, and background color.
                ProfileCard(
                    name="Arzu Yilmaz Kizilin",
                    "I'm a Computer Information Technology student with an interest in mobile applications. I enjoy learning, creating, and turning ideas into simple, usable applications.",
                    modifier=Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}
@Composable
fun ProfileCard(name:String, bio:String, modifier:Modifier=Modifier) {
    //Column stacks elements vertically and centers them on the screen.
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.Yellow)

    ){
    //Circular profile image for the profile picture.
    Image(
        painter=painterResource(R.drawable.arzu),
        contentDescription = "Profile picture",
        modifier=Modifier
            .clip(CircleShape) //makes the image circular.
            .size(200.dp) //sets the image size.
    )
        Spacer(modifier=Modifier.height(8.dp)) //sets spacing between elements
    //Displays the profile name with appropriate style.
    Text(
        text = name,
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
        modifier= Modifier.padding(16.dp)
    )
        Spacer(modifier=Modifier.height(8.dp))

    //Displays the biography with appropriate style.
    Text(
        text= bio,
        fontSize = 24.sp,
        textAlign=TextAlign.Center,
        modifier= Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ProfileCardTheme {
        ProfileCard(
            name= "Arzu Yilmaz Kizilin",
            bio="I'm a Computer Information Technology student with an interest in mobile applications. I enjoy learning, creating, and turning ideas into simple, usable applications.",
            //I added the same modifiers for the main screen in the preview because
            //without them the full layout was not visible in the preview window.
            modifier=Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.Yellow)
        )
    }
}