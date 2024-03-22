package pl.farmaprom.trainings.contactsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme
import java.lang.ArithmeticException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Greeting("Android")
                }
            }
        }
        val calculationContainer = CalculationContainer()
        println("result == ${calculationContainer.calculate({a,b -> 
            CalculationContainer.performDivision(6, 2)}, 6, 2)}")

        val group = Group()

        val students = listOf(Student("Jan", "Kowalski", true, "praca1"),
            Student("Jan", "Niezbedny", true, "praca2"),
            Student("Jakub", "Nowak", true, "praca3"),
            Student("Andrzej", "Fajny", true, "praca4"),
            Student("Henryk", "Kowalski", true),
            Student("Jerzy", "Kowalski", true))

        for(student in students){
            group.addStudent(student)
        }
        group.printStudents()
    }
}

class CalculationContainer {
    companion object {
        var a: Int = 1
        var b: Int = 5
        fun performAdding(a: Int, b: Int) = a + b
        fun  performDivision(a: Int, b: Int) = try{
            (a / b)
        } catch (e: ArithmeticException) {
            println("do not divide by 0")
        }
    }
    fun calculate(calculation: (Int, Int) -> Any, a: Int, b: Int) = calculation.invoke(a,b)
}

data class Student(
    val name: String = "",
    val surname: String = "",
    var isActive: Boolean = false,
    var thesisName: String? = null
)

class Group {
    private val students = mutableListOf<Student>()
    fun addStudent(student: Student) = students.add(student)
    fun printStudents () {
        students.getStudentsWithThesisName().forEach { human ->
            human.thesisName?.let {
                println("student == ${human.name}, ${human.surname}, ${it}")
                //komentarz
            }
        }
    }

    fun List<Student>.getStudentsWithThesisName() = this
        .filter{ it.thesisName.isNullOrBlank().not()}
            .sortedBy { it.thesisName }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactsAppTheme {
        Greeting("Android")
    }
}


