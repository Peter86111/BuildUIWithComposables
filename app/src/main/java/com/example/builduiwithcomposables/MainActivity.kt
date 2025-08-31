package com.example.builduiwithcomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.builduiwithcomposables.ui.theme.BuildUIWithComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }

// Marks this function as a composable, meaning it can be used to build UI in Jetpack Compose
@Composable
fun BusinessCardApp() {
    // Calls the BusinessCard composable and passes all the required resources
    BusinessCard(
        // Background image resource for the card
        imageBackground = painterResource(R.drawable.android_wallpaper),

        // Profile picture resource
        imageProfile = painterResource(R.drawable.me),

        // User's full name (loaded from string resources)
        name = stringResource(R.string.p_ter_moln_r),

        // Job title (loaded from string resources)
        jobTitle = stringResource(R.string.junior_software_developer),

        // GitHub profile URL
        gitHub = stringResource(R.string.https_github_com_peter86111),

        // Email address
        email = stringResource(R.string.mpeti86_gmail_com),
    )
}

// Marks this function as a composable for building a business card UI
@Composable
private fun BusinessCard(
    imageBackground: Painter,           // Background image
    imageProfile: Painter,              // Profile picture
    name: String,                       // User's name
    jobTitle: String,                   // User's job title
    gitHub: String,                     // GitHub link
    email: String,                      // Email address
    modifier: Modifier = Modifier       // Optional modifier for styling
) {
    // Container that stacks children on top of each other
    Box(modifier = Modifier.fillMaxSize()   // Fill the entire available space
    ) {

        // Background image, stretched to fill parent
        Image(
            painter = imageBackground,
            contentDescription = null,
            contentScale = ContentScale.Crop,       // Crop to fill without distortion
            modifier = Modifier.matchParentSize()   // Makes this composable fill the same size as its parent container
        )

        // Column for profile picture, name, and title
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 150.dp, top = 50.dp, end = 5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Circular profile image
            Image(
                painter = imageProfile,
                contentDescription = "Me",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
            )
            // User's name
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    color = Color.Green
                ),
                modifier = Modifier.padding(top = 10.dp)
            )
            // User's job title
            Text(
                text = jobTitle,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    color = Color.Green
                )
            )
        }
        // Column for GitHub and Email info, aligned at the bottom-left
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            // GitHub row with icon and text
            Row(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp),
                    tint = Color.Green
                )
                Text(
                    text = gitHub,
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        color = Color.Green
                    )
                )
            }

            // Email row with icon and text
            Row(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            ) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp),
                    tint = Color.Green
                )
                Text(
                    text = email,
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        color = Color.Green
                    ),
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildUIWithComposablesTheme {
        BusinessCardApp()
    }
}