package np.com.bimalkafle.mycalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import np.com.bimalkafle.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorTheme {
                var num1 by remember { mutableStateOf("0") }
                var num2 by remember { mutableStateOf("0") }

                // Use Scaffold to avoid overlapping with the status bar
                Scaffold { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues) // Respect the system UI padding
                            .padding(30.dp) // Add custom padding for content
                    ) {
                        TextField(
                            value = num1,
                            onValueChange = { num1 = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = num2,
                            onValueChange = { num2 = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row {
                            Button(onClick = {
                                val result = num1.toInt() + num2.toInt()
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "+")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(onClick = {
                                val result = num1.toInt() - num2.toInt()
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "-")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(onClick = {
                                val result = num1.toInt() * num2.toInt()
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "X")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(onClick = {
                                val result = num1.toInt() / num2.toInt()
                                Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "/")
                            }
                        }
                    }
                }
            }
        }
    }
}
