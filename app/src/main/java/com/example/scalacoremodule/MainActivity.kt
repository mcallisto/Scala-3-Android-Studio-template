package com.example.scalacoremodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.Description
import com.example.core.Foo
import com.example.scalacoremodule.ui.theme.ScalaCoreModuleTheme
import java.util.Optional

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScalaCoreModuleTheme {
                Form()
            }
        }
    }
}

@Composable
fun Form() {
    var org by remember { mutableStateOf("") }
    var repo by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var proj: Optional<Description> by remember { mutableStateOf(Optional.empty()) }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = error)
            Text("Organisation")
            OutlinedTextField(value = org, onValueChange = { org = it })
            Text("Repository")
            OutlinedTextField(value = repo, onValueChange = { repo = it })
            Button(onClick = {
                Foo.getProjectInfo(org, repo).fold({ error = it }, {})
            }) { Text("Look up on Scaladex") }
            ProjectDescription(proj)


        }
    }
}

@Composable
fun ProjectDescription(desc: Optional<Description>) {
    if (desc.isEmpty) Column { }
    else {
        var proj = desc.get()
        Column {
            Text(proj.description())
            Text(proj.stars().toString())
        }
    }
}

@Composable
fun Submit(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Look up")
    }
}