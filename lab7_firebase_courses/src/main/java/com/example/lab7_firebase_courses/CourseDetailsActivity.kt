package com.example.lab7_firebase_courses

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lab7_firebase_courses.ui.theme.Baitap_Lap1Theme
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
class CourseDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val courseList = mutableStateListOf<Course?>()
        val db = FirebaseFirestore.getInstance()

        db.collection("Courses")
            .get()
            .addOnSuccessListener { queryDocumentSnapshots ->
                if (!queryDocumentSnapshots.isEmpty) {
                    val list = queryDocumentSnapshots.documents
                    for (d in list) {
                        val c: Course? = d.toObject(Course::class.java)
                        c?.courseID = d.id
                        courseList.add(c)
                    }
                } else {
                    Toast.makeText(
                        this,
                        "No data found in Database",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                setContent {
                    Baitap_Lap1Theme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text(text = "View Courses") }
                                    )
                                }
                            ) { innerPadding ->
                                CourseListUI(
                                    modifier = Modifier.padding(innerPadding),
                                    courseList = courseList
                                )
                            }
                        }
                    }
                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    this,
                    "Fail to get the data.",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}

@Composable
fun CourseListUI(
    modifier: Modifier = Modifier,
    courseList: SnapshotStateList<Course?>
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(courseList) { _, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            val i = Intent(context, UpdateCourse::class.java)
                            i.putExtra("courseID", item?.courseID ?: "")
                            i.putExtra("courseName", item?.courseName ?: "")
                            i.putExtra("courseDuration", item?.courseDuration ?: "")
                            i.putExtra("courseDescription", item?.courseDescription ?: "")
                            context.startActivity(i)
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Course Name: ${item?.courseName ?: ""}",
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "Course Duration: ${item?.courseDuration ?: ""}")
                        Text(text = "Course Description: ${item?.courseDescription ?: ""}")
                        Text(text = "Course ID: ${item?.courseID ?: ""}")
                    }
                }
            }
        }
    }
}