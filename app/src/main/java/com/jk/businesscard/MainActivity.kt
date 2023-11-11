package com.jk.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jk.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200)),
        Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            Modifier
                .weight(1f),
            Arrangement.Bottom) {
            TitleCard(name = stringResource(R.string.name),
                title = stringResource(R.string.android_developer),
                image = painterResource(id = R.drawable.android_logo)
            )
        }
        Column(
            Modifier
                .weight(1f)
                .padding(bottom = 24.dp),
            Arrangement.Bottom) {
            ContactInformation(phone = stringResource(R.string.phone), website = stringResource(R.string.website), email = stringResource(
                R.string.email)
            )
        }
    }
}

@Composable
fun TitleCard(name: String, title: String, image: Painter, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(painter = image, contentDescription = "Photo",
            Modifier
                .width(96.dp)
                .height(96.dp)
                .background(color = Color.DarkGray))
        Text(text = name, fontSize = 32.sp, modifier = modifier.padding(8.dp))
        Text(text = title, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.teal_700))
    }
}

@Composable
fun ContactInformation(phone: String, website: String, email: String, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        InfoRow(value = phone, icon = painterResource(id = R.drawable.baseline_phone_24))
        InfoRow(value = website, icon = painterResource(id = R.drawable.baseline_share_24))
        InfoRow(value = email, icon = painterResource(id = R.drawable.baseline_email_24))
    }
}

@Composable
fun InfoRow(value: String, icon: Painter){
    Row(Modifier.padding(8.dp)) {
        Icon(painter = icon, contentDescription = "Phone Number", tint = Color(R.color.green), modifier = Modifier.padding(end = 20.dp) )
        Text(text = value, color = colorResource(id = R.color.green))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}