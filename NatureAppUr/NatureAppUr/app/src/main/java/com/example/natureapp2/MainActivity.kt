package com.example.natureapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureApp()
        }
    }
}

class Place(val name: String, val description: String, val imageUrl: String)

@Composable
fun NatureApp() {
    val scrollState = rememberScrollState()

    val places = listOf(
        Place(
            name = "Jeju Island",
            description = "Esta isla volcánica es conocida por sus paisajes naturales impresionantes, incluidas playas de arena blanca, acantilados dramáticos y el volcán Hallasan, el punto más alto de Corea. Jeju es un destino popular tanto para turistas como locales por sus rutas de senderismo, cascadas y el famoso túnel de lava Manjanggul.",
            imageUrl = "https://www.outlooktravelmag.com/media/jeju-island-1-1643649088.profileImage.2x-jpg.webp"
        ), Place(
            name = "Gyeongbokgung Palace",
            description = "Ubicado en Seúl, es uno de los palacios más grandes y antiguos de la dinastía Joseon. Con jardines espectaculares, pabellones y puertas majestuosas, Gyeongbokgung ofrece una visión impresionante de la arquitectura coreana tradicional.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsBdG7JnvuRjciX83WWPFVhqeVaTEpRPujjQ&s"
        ), Place(
            name = "Seoraksan National Park",
            description = "Este parque, con montañas espectaculares y una vegetación diversa, es ideal para los amantes del senderismo. Seoraksan es famoso por sus formaciones rocosas únicas, arroyos cristalinos y el templo budista Sinheungsa, que ofrece vistas impresionantes del paisaje montañoso.",
            imageUrl = "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/39/82/9b.jpg"
        ), Place(
            name = "Bukchon Hanok Village",
            description = "Ubicada en Seúl, esta aldea histórica está formada por casas tradicionales coreanas llamadas “hanok”. Caminar por las estrechas calles empedradas de Bukchon te transporta al pasado, rodeado de arquitectura tradicional, cafés y talleres de artesanía, con vistas panorámicas a la ciudad moderna de Seúl.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9Yur9f6SL1URvdtZZxZhpGOfJinkeEuctIw&s"
        ), Place(
            name = "Nami Island",
            description = "Famosa por sus paisajes idílicos, especialmente en otoño e invierno, Nami Island es conocida por sus largas avenidas de árboles alineados, que cambian de color con las estaciones. Es un destino popular para escapadas románticas y familiares, y es famosa por haber sido escenario de varios dramas coreanos.",
            imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhf3OL7nDvqqy60v9O3dx4vwBEzoiFScK4NBPOh1gNY4vxVjralcn8BFg2u_r5cBrFL_-7z3WpBp-UtJHS_PL2w4IJoZvp3arVARys1_1lkmXzSfU7Jx-51TQO6MPFopF6vInO56qTElDw/s1920/3.jpg"
        )
    )


    Column(modifier = Modifier.verticalScroll(scrollState)) {
        places.forEach { place ->
            PlaceCard(place)
        }
    }
}

@Composable
fun PlaceCard(place: Place) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            AsyncImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = place.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NatureApp()
}