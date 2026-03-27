package com.example.kotlinlearningapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlinlearningapp.data.model.Question
import com.example.kotlinlearningapp.data.model.Topic

class TopicViewModel : ViewModel() {

    private val beginnerTopics = listOf(
        Topic(
            id = 1,
            title = "Basic Types",
            theory = "Kotlin has basic types as: Int, Double, String and Boolean.",
            code = """
val age: Int = 25
val price: Double = 10.5
val name: String = "Juan"
val isActive: Boolean = true""",
            questions = listOf(
                Question(
                    "What type is used for integers?",
                    listOf("String", "Byte", "Boolean", "Double"), 1
                ),
                Question(
                    "What type is used for floating-point numbers?",
                    listOf("String", "Byte", "Boolean", "Double"), 3
                ),
                Question(
                    "What type is declared for: val f = '\\n'?",
                    listOf("Long", "Int", "Char", "String"), 2
                ),
                Question(
                    "What type is declared for: val d = 100_000_000_000_000?",
                    listOf("Long", "Double", "Float", "String"), 0
                ),
                Question(
                    "What type represents text?",
                    listOf("Int", "Boolean", "String", "Float"), 2
                )
            )
        ),
        Topic(
            id = 2,
            title = "Collections",
            theory = "Kotlin has three main collection types: List (ordered, allows duplicates), Set (no duplicates), and Map (key-value pairs).",
            code = """
val list = listOf("a", "b", "c")
val set = setOf(1, 2, 3)
val map = mapOf("key" to "value")""",
            questions = listOf(
                Question(
                    "Which collection type is ordered and allows duplicates?",
                    listOf("Set", "Map", "List", "HashSet"), 2
                ),
                Question(
                    "What function is used to create a list in Kotlin?",
                    listOf("arrayOf()", "listOf()", "setOf()", "mapOf()"), 1
                ),
                Question(
                    "Which collection does NOT allow duplicate elements?",
                    listOf("List", "Set", "ArrayList", "MutableList"), 1
                ),
                Question(
                    "How do you access the first element of a list?",
                    listOf("list[0]", "list.first()", "Both A and B", "list.getFirst()"), 2
                ),
                Question(
                    "Which collection stores key-value pairs?",
                    listOf("List", "Set", "Map", "Array"), 2
                )
            )
        ),
        Topic(
            id = 3,
            title = "Control Flow",
            theory = "Kotlin uses if, when, for, and while for control flow. The 'when' expression replaces switch.",
            code = """
val x = 5
if (x > 3) println("Yes")
when (x) {
    1 -> println("One")
    else -> println("Other")
}
for (i in 1..5) println(i)""",
            questions = listOf(
                Question(
                    "Which keyword is used for conditional statements?",
                    listOf("loop", "if", "switch", "case"), 1
                ),
                Question(
                    "What is Kotlin's alternative to switch?",
                    listOf("case", "select", "when", "choose"), 2
                ),
                Question(
                    "What will this print? if (5 > 3) println(\"Yes\")",
                    listOf("No", "Error", "Yes", "Nothing"), 2
                ),
                Question(
                    "Which loop is used to iterate over a range?",
                    listOf("while", "do-while", "for", "loop"), 2
                ),
                Question(
                    "Result of: when(x) { 1 -> \"One\" else -> \"Other\" } if x = 2?",
                    listOf("One", "Two", "Other", "Error"), 2
                )
            )
        ),
        Topic(
            id = 4,
            title = "Functions",
            theory = "Functions in Kotlin are declared with the 'fun' keyword. They support default parameters and single-expression syntax.",
            code = """
fun sum(a: Int, b: Int): Int = a + b

fun greet(name: String = "World") {
    println("Hello, ${'$'}name!")
}""",
            questions = listOf(
                Question(
                    "Which keyword is used to declare a function in Kotlin?",
                    listOf("fun", "function", "def", "void"), 0
                ),
                Question(
                    "What is the return type of a function that returns nothing?",
                    listOf("Null", "Void", "Unit", "Empty"), 2
                ),
                Question(
                    "How do you define a function with parameters?",
                    listOf(
                        "fun sum(a, b)",
                        "fun sum(a: Int, b: Int)",
                        "function sum(Int a, Int b)",
                        "def sum(a, b)"
                    ), 1
                ),
                Question(
                    "What is a single-expression function?",
                    listOf(
                        "A function with one line",
                        "A function without return",
                        "A function using = instead of {}",
                        "A function with one parameter"
                    ), 2
                ),
                Question(
                    "What will this return? fun sum(a: Int, b: Int) = a + b",
                    listOf("Nothing", "Int", "Double", "String"), 1
                )
            )
        ),
        Topic(
            id = 5,
            title = "Classes",
            theory = "Classes in Kotlin are declared with the 'class' keyword. By default they are final (non-inheritable).",
            code = """
class Person(val name: String, var age: Int) {
    fun greet() = "Hello, I'm ${'$'}name"
}
val p = Person("Juan", 25)
println(p.greet())""",
            questions = listOf(
                Question(
                    "Which keyword is used to define a class in Kotlin?",
                    listOf("class", "object", "struct", "define"), 0
                ),
                Question(
                    "What is a constructor?",
                    listOf(
                        "A function inside a class",
                        "A method to destroy objects",
                        "A special function to initialize objects",
                        "A variable inside a class"
                    ), 2
                ),
                Question(
                    "How do you create an object from a class?",
                    listOf("new Person()", "Person()", "create Person()", "object Person()"), 1
                ),
                Question(
                    "What is the default visibility of classes in Kotlin?",
                    listOf("private", "protected", "public", "internal"), 2
                ),
                Question(
                    "Which keyword is used for inheritance?",
                    listOf("extends", "implements", ":", "inherits"), 2
                )
            )
        ),
        Topic(
            id = 6,
            title = "Null Safety",
            theory = "In Kotlin, it's possible to have a null value. Kotlin uses null values when something is missing or not yet set.",
            code = """
var nullable: String? = "You can keep a null here"
nullable = null

val length = nullable?.length  // null
val safe = nullable ?: "default" """,
            questions = listOf(
                Question(
                    "What symbol is used to declare a nullable variable?",
                    listOf("!", "?", "*", "#"), 1
                ),
                Question(
                    "What does the safe call operator (?.) do?",
                    listOf(
                        "Throws error if null",
                        "Ignores null values",
                        "Executes only if not null",
                        "Converts null to zero"
                    ), 2
                ),
                Question(
                    "What does this return? name?.length",
                    listOf("Always Int", "Int or null", "String", "Error"), 1
                ),
                Question(
                    "What does the !! operator do?",
                    listOf(
                        "Makes variable nullable",
                        "Forces non-null (may crash)",
                        "Ignores null",
                        "Converts to String"
                    ), 1
                ),
                Question(
                    "Which is a nullable variable?",
                    listOf("var name: String", "var name: String?", "val name: String", "val name: Int"), 1
                )
            )
        )
    )

    private val intermediateTopics = listOf(
        Topic(
            id = 7,
            title = "Extension Functions",
            theory = "To create an extension function, write the class name followed by a dot and your function name.",
            code = """
fun String.bold(): String = "<b>${'$'}this</b>"

fun main() {
    println("hello".bold())
    // <b>hello</b>
}""",
            questions = listOf(
                Question(
                    "What is an extension function in Kotlin?",
                    listOf(
                        "A function inside a class",
                        "A function that modifies the original class code",
                        "A function that adds new behavior to an existing class",
                        "A function that inherits another function"
                    ), 2
                ),
                Question(
                    "How do you declare an extension function?",
                    listOf(
                        "fun extend String()",
                        "fun String.myFunction()",
                        "function String.myFunction()",
                        "fun myFunction(String)"
                    ), 1
                ),
                Question(
                    "Can extension functions access private members of a class?",
                    listOf("Yes", "No", "Only protected", "Only public and private"), 1
                ),
                Question(
                    "Where is the extension function actually stored?",
                    listOf(
                        "Inside the class",
                        "In the object instance",
                        "Statically resolved outside the class",
                        "In memory only"
                    ), 2
                ),
                Question(
                    "What happens if a class already has a method with the same name?",
                    listOf(
                        "Extension overrides it",
                        "Compilation error",
                        "Member function is used",
                        "Both are executed"
                    ), 2
                )
            )
        ),
        Topic(
            id = 8,
            title = "Scope Functions",
            theory = "Scope functions execute a block of code in the context of an object: let, apply, run, with, also.",
            code = """
val result = "hello".let { it.uppercase() }

val sb = StringBuilder().apply {
    append("Hello")
    append(" World")
}""",
            questions = listOf(
                Question(
                    "Which of the following is NOT a scope function?",
                    listOf("let", "apply", "run", "loop"), 3
                ),
                Question(
                    "Which scope function uses 'it' as the default reference?",
                    listOf("apply", "run", "let", "with"), 2
                ),
                Question(
                    "Which scope function returns the object itself?",
                    listOf("let", "apply", "run", "with"), 1
                ),
                Question(
                    "Which function is typically used for null checking?",
                    listOf("apply", "let", "run", "also"), 1
                ),
                Question(
                    "What is the main purpose of scope functions?",
                    listOf(
                        "Looping",
                        "Exception handling",
                        "Object configuration and transformations",
                        "Inheritance"
                    ), 2
                )
            )
        ),
        Topic(
            id = 9,
            title = "Lambda with Receiver",
            theory = "A lambda with receiver allows calling methods on an object inside a lambda block, using 'this' as the receiver.",
            code = """
val sum: Int.(Int) -> Int = { other -> this + other }
println(1.sum(2)) // 3

// Common in DSLs:
fun buildString(block: StringBuilder.() -> Unit): String {
    return StringBuilder().apply(block).toString()
}""",
            questions = listOf(
                Question(
                    "What is a lambda with receiver?",
                    listOf(
                        "A lambda with parameters",
                        "A lambda where 'this' refers to a receiver object",
                        "A lambda without return value",
                        "A lambda with multiple arguments"
                    ), 1
                ),
                Question(
                    "What keyword refers to the receiver inside the lambda?",
                    listOf("it", "this", "self", "receiver"), 1
                ),
                Question(
                    "Which syntax defines a lambda with receiver?",
                    listOf("(Int) -> Unit", "Int.(Int) -> Int", "Int -> Int", "() -> Int"), 1
                ),
                Question(
                    "Where are lambdas with receiver commonly used?",
                    listOf("Loops", "Collections", "DSLs (Domain Specific Languages)", "Arrays"), 2
                ),
                Question(
                    "What advantage do lambdas with receiver provide?",
                    listOf(
                        "Faster execution",
                        "Cleaner and more readable code",
                        "Less memory usage",
                        "Automatic null safety"
                    ), 1
                )
            )
        ),
        Topic(
            id = 10,
            title = "Classes and Interfaces",
            theory = "Interfaces define a contract. In Kotlin, interfaces can have default implementations. A class implements an interface using ':'.",
            code = """
interface Animal {
    fun sound(): String
    fun description() = "I am an animal" // default implementation
}
class Dog : Animal {
    override fun sound() = "Woof"
}""",
            questions = listOf(
                Question(
                    "What is an interface in Kotlin?",
                    listOf(
                        "A class with implementation",
                        "A blueprint of methods without full implementation",
                        "A constructor",
                        "A variable"
                    ), 1
                ),
                Question(
                    "Can interfaces have method implementations in Kotlin?",
                    listOf("No", "Yes", "Only abstract", "Only private"), 1
                ),
                Question(
                    "How do you implement an interface?",
                    listOf("implements", "extends", ":", "inherits"), 2
                ),
                Question(
                    "Can a class implement multiple interfaces?",
                    listOf("Yes", "No", "Only two", "Only one"), 0
                ),
                Question(
                    "What must be used when implementing interface methods?",
                    listOf("override", "super", "this", "return"), 0
                )
            )
        ),
        Topic(
            id = 11,
            title = "Objects",
            theory = "Object declarations create singletons in Kotlin. Object expressions create anonymous objects. Companion objects provide class-level members.",
            code = """
object Database {
    val name = "MyDB"
    fun connect() = println("Connected to ${'$'}name")
}
Database.connect()

// Companion object
class MyClass {
    companion object {
        fun create() = MyClass()
    }
}""",
            questions = listOf(
                Question(
                    "What is an object in Kotlin?",
                    listOf("A class", "A singleton instance", "A variable", "A function"), 1
                ),
                Question(
                    "How do you declare a singleton object?",
                    listOf("class MyObject", "object MyObject", "singleton MyObject", "new MyObject"), 1
                ),
                Question(
                    "Can objects have functions?",
                    listOf("No", "Yes", "Only static", "Only private"), 1
                ),
                Question(
                    "What is an object expression?",
                    listOf("A class", "An anonymous object", "A function", "An interface"), 1
                ),
                Question(
                    "Are objects instantiated multiple times?",
                    listOf("Yes", "No", "Only twice", "Depends"), 1
                )
            )
        ),
        Topic(
            id = 12,
            title = "Open and Special Classes",
            theory = "By default Kotlin classes are final. Use 'open' to allow inheritance. Abstract classes cannot be instantiated. Data classes auto-generate equals/hashCode/copy.",
            code = """
open class Vehicle(val brand: String)

class Car(brand: String, val doors: Int) : Vehicle(brand)

abstract class Shape {
    abstract fun area(): Double
}

data class Point(val x: Int, val y: Int)""",
            questions = listOf(
                Question(
                    "What is the default behavior of classes in Kotlin?",
                    listOf("Open", "Final", "Abstract", "Private"), 1
                ),
                Question(
                    "Which keyword allows inheritance?",
                    listOf("extend", "open", "override", "inherit"), 1
                ),
                Question(
                    "What is an abstract class?",
                    listOf(
                        "A class that cannot be instantiated",
                        "A class with no methods",
                        "A class with only variables",
                        "A class without constructor"
                    ), 0
                ),
                Question(
                    "Which keyword is used to override a method?",
                    listOf("open", "override", "super", "fun"), 1
                ),
                Question(
                    "Can a final class be inherited?",
                    listOf("Yes", "No", "Sometimes", "Only once"), 1
                )
            )
        ),
        Topic(
            id = 13,
            title = "Properties",
            theory = "Properties in Kotlin can have custom getters and setters. The 'field' keyword accesses the backing field inside a setter/getter.",
            code = """
class Circle(radius: Double) {
    var radius = radius
        set(value) {
            field = if (value > 0) value else 0.0
        }
    val area: Double
        get() = Math.PI * radius * radius
}""",
            questions = listOf(
                Question(
                    "What is a property in Kotlin?",
                    listOf("A function", "A variable with getter and setter", "A class", "An interface"), 1
                ),
                Question(
                    "Which keyword declares a mutable property?",
                    listOf("val", "var", "let", "const"), 1
                ),
                Question(
                    "Which keyword declares an immutable property?",
                    listOf("var", "val", "const", "let"), 1
                ),
                Question(
                    "Can properties have custom getters and setters?",
                    listOf("No", "Yes", "Only getters", "Only setters"), 1
                ),
                Question(
                    "What does 'field' refer to in a property?",
                    listOf("Function name", "Backing field", "Class name", "Constructor"), 1
                )
            )
        ),
        Topic(
            id = 14,
            title = "Null Safety (Advanced)",
            theory = "Advanced null safety: Elvis operator (?:) provides defaults, !! forces non-null (crashes on null), as? is a safe cast, lateinit defers initialization.",
            code = """
val name: String? = null

// Elvis operator
val length = name?.length ?: 0

// Safe cast
val number = name as? Int  // null instead of exception

// lateinit
lateinit var data: String""",
            questions = listOf(
                Question(
                    "What does the Elvis operator (?:) do?",
                    listOf(
                        "Throws exception",
                        "Returns default value if null",
                        "Ignores null",
                        "Converts to string"
                    ), 1
                ),
                Question(
                    "What happens when using !! on null?",
                    listOf("Returns null", "Throws exception", "Ignores error", "Returns 0"), 1
                ),
                Question(
                    "Which operator checks type safely?",
                    listOf("as", "as?", "is", "!!"), 1
                ),
                Question(
                    "What does 'lateinit' do?",
                    listOf(
                        "Makes variable nullable",
                        "Initializes later",
                        "Prevents null",
                        "Deletes value"
                    ), 1
                ),
                Question(
                    "Where can 'lateinit' be used?",
                    listOf("val variables", "var variables", "functions", "interfaces"), 1
                )
            )
        ),
        Topic(
            id = 15,
            title = "Libraries and APIs",
            theory = "Kotlin works with external libraries managed by Gradle. Retrofit handles HTTP API calls. JSON is the standard format for data exchange.",
            code = """
// build.gradle.kts
implementation("com.squareup.retrofit2:retrofit:2.9.0")

// Retrofit interface
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}""",
            questions = listOf(
                Question(
                    "What is a library in Kotlin?",
                    listOf("A database", "A collection of reusable code", "A compiler", "An IDE"), 1
                ),
                Question(
                    "What is an API?",
                    listOf(
                        "A programming language",
                        "A set of rules for communication between software",
                        "A database",
                        "A UI component"
                    ), 1
                ),
                Question(
                    "Which tool manages dependencies in Android?",
                    listOf("Gradle", "JVM", "SDK", "ADB"), 0
                ),
                Question(
                    "What does Retrofit do?",
                    listOf("Database management", "HTTP API calls", "UI design", "File storage"), 1
                ),
                Question(
                    "What is JSON used for?",
                    listOf("UI design", "Data exchange", "Compilation", "Encryption"), 1
                )
            )
        )
    )

    fun getTopics(level: String): List<Topic> {
        return when (level) {
            "Beginner" -> beginnerTopics
            "Intermediate" -> intermediateTopics
            else -> emptyList()
        }
    }

    fun getTopicById(id: Int): Topic? {
        return (beginnerTopics + intermediateTopics).find { it.id == id }
    }
}