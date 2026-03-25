package com.example.lab7_firebase_courses

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.lab7_firebase_courses.ui.theme.Baitap_Lap1Theme
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
class UpdateCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val courseID = intent.getStringExtra("courseID") ?: ""
        val courseName = intent.getStringExtra("courseName") ?: ""
        val courseDuration = intent.getStringExtra("courseDuration") ?: ""
        val courseDescription = intent.getStringExtra("courseDescription") ?: ""

        setContent {
            Baitap_Lap1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Update Course") }
                            )
                        }
                    ) { innerPadding ->
                        UpdateCourseUI(
                            context = LocalContext.current,
                            courseID = courseID,
                            courseName = courseName,
                            courseDuration = courseDuration,
                            courseDescription = courseDescription,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UpdateCourseUI(
    context: Context,
    courseID: String,
    courseName: String,
    courseDuration: String,
    courseDescription: String,
    modifier: Modifier = Modifier
) {
    val name = remember { mutableStateOf(courseName) }
    val duration = remember { mutableStateOf(courseDuration) }
    val description = remember { mutableStateOf(courseDescription) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Course Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = duration.value,
            onValueChange = { duration.value = it },
            label = { Text("Course Duration") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Course Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                updateData(
                    courseID = courseID,
                    courseName = name.value,
                    courseDuration = duration.value,
                    courseDescription = description.value,
                    context = context
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Course")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                deleteData(courseID, context)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete Course")
        }
    }
}

fun updateData(
    courseID: String,
    courseName: String,
    courseDuration: String,
    courseDescription: String,
    context: Context
) {
    val db = FirebaseFirestore.getInstance()

    val course = Course(
        courseID = courseID,
        courseName = courseName,
        courseDuration = courseDuration,
        courseDescription = courseDescription
    )

    db.collection("Courses")
        .document(courseID)
        .set(course)
        .addOnSuccessListener {
            Toast.makeText(context, "Course Updated", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Fail to update: $e", Toast.LENGTH_SHORT).show()
        }
}

fun deleteData(courseID: String, context: Context) {
    val db = FirebaseFirestore.getInstance()

    db.collection("Courses")
        .document(courseID)
        .delete()
        .addOnSuccessListener {
            Toast.makeText(context, "Course Deleted", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Fail to Delete: $e", Toast.LENGTH_SHORT).show()
        }
}