package br.com.tercio.alcoolOuGasolina

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tercio.alcoolOuGasolina.ui.theme.AlcoolOuGasolinaTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcoolOuGasolinaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
        }
    }
}

@Composable
fun App(){
    var valorGasolina by remember {mutableStateOf("")}
    var valorAlcool by remember {mutableStateOf("")}
    var alcoolOuGasolina by remember { mutableStateOf("Gasolina") }
    var cor by remember { mutableStateOf(Color.Red) }
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF04B7CE)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Álcool ou Gasolina?",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ))

//            Condicional para verificar qual combustível está com melhor preço
            
            AnimatedVisibility(visible = valorAlcool.isNotBlank() && valorGasolina.isNotBlank()) {
                if (valorAlcool.isNotBlank() && valorGasolina.isNotBlank()){
                    val gasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7
                    alcoolOuGasolina = if(gasolina){"Gasolina"}else{"Álcool"}
                    cor = if(gasolina) Color.Red else Color.Green
                }
            }
            



            Text(text = alcoolOuGasolina,
                style = TextStyle(
                    color = cor,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold

                ))
            TextField(
                label = {
                    Text(text = "Gasolina", textAlign = TextAlign.Center)
                },
                value = valorGasolina,
                onValueChange = {
                    valorGasolina = it
                } )

            TextField(
                label = {
                        Text(text = "Álcool", textAlign = TextAlign.Center)
                },
                value = valorAlcool,
                onValueChange = {
                    valorAlcool = it
                }
            )
        }
    }
}}


@Preview
@Composable
fun AppPreview(){
    AlcoolOuGasolinaTheme {
        App()
    }
}

@Composable
fun App() {
    TODO("Not yet implemented")
}
