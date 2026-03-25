package com.example.lab7_firebase_courses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7_firebase_courses.ui.theme.Baitap_Lap1Theme
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Baitap_Lap1Theme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold { innerPadding ->
                        Column(modifier = Modifier.padding(innerPadding)) {
                            FirebaseUI(LocalContext.current)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FirebaseUI(context: Context) {

    val courseID = remember { mutableStateOf("") }
    val courseName = remember { mutableStateOf("") }
    val courseDuration = remember { mutableStateOf("") }
    val courseDescription = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = courseName.value,
                onValueChange = { courseName.value = it },
                placeholder = { Text("Enter your course name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black
                ),

                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = courseDuration.value,
                onValueChange = { courseDuration.value = it },
                placeholder = { Text("Enter your course duration") },
                modifier = Modifier.fillMaxWidth(),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black
                ),

                textStyle = TextStyle(fontSize = 16.sp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = courseDescription.value,
                onValueChange = { courseDescription.value = it },
                placeholder = { Text("Enter your course description") },
                modifier = Modifier.fillMaxWidth(),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black
                ),

                textStyle = TextStyle(fontSize = 16.sp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {

                    if (TextUtils.isEmpty(courseName.value)) {
                        Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT).show()
                    }

                    else if (TextUtils.isEmpty(courseDuration.value)) {
                        Toast.makeText(context, "Please enter course duration", Toast.LENGTH_SHORT).show()
                    }

                    else if (TextUtils.isEmpty(courseDescription.value)) {
                        Toast.makeText(context, "Please enter course description", Toast.LENGTH_SHORT).show()
                    }

                    else {

                        addDataToFirebase(
                            courseID.value,
                            courseName.value,
                            courseDuration.value,
                            courseDescription.value,
                            context
                        )

                    }

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)

            ) {

                Text(
                    text = "Add Data",
                    modifier = Modifier.padding(8.dp)
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    context.startActivity(
                        Intent(context, CourseDetailsActivity::class.java)
                    )
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)

            ) {

                Text(
                    text = "View Courses",
                    modifier = Modifier.padding(8.dp)
                )

            }

        }

        Text(
            text = "Developed by Nguyen Dang Khoa",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

    }

}

fun addDataToFirebase(
    courseID: String,
    courseName: String,
    courseDuration: String,
    courseDescription: String,
    context: Context
) {

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbCourses: CollectionReference = db.collection("Courses")

    val course = Course(
        courseID = courseID,
        courseName = courseName,
        courseDuration = courseDuration,
        courseDescription = courseDescription
    )

    dbCourses.add(course)
        .addOnSuccessListener {

            Toast.makeText(
                context,
                "Course Added to Firebase",
                Toast.LENGTH_SHORT
            ).show()

        }
        .addOnFailureListener { e ->

            Toast.makeText(
                context,
                "Fail to add course \n$e",
                Toast.LENGTH_SHORT
            ).show()

        }

}