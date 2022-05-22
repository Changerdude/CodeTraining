import java.util.Objects
import kotlin.math.sqrt

/*
//OOP

    Class is a user defined data type
    object is an instance of a class
    Human Class
    Kurt Object

//Class Signature
//class header class ClassName{//class body
    property
    member function
    }

    class Student{

    }

//Constructors
//Primary Constructor
    Uses the one written into the class signature / Used to pass parameters / Can use default values
    class Calc ( a:Int, b:Int){
    With default value
    class Calc ( a:Int, b:Int = 5){
//Secondary Constructor
    class Calc ( a:Int, b:Int){
        constructor(c:Int){

        }
    }
//Inherit Class / Override functions
    to inherit clas the parent class must be open

    open class Person(){}
    class Teacher():Person(){}

    to override inherited functions the parent function must be open and the new function needs the override keyword
    open class Person(){
        open fun getName(){}
    }
    class Teacher():Person(){
        override fun getName(){}
    }


 */

fun main() {
    val obj1 = Calc(1, 2)

    println(obj1.sum(4, 5))
    println(obj1.myA)

    obj1.myA = 23
    println(obj1.myA)

    val obj2 = Calc(3, 4)
    println(obj2.myA)

    //Secondary constructors
    var myStudent0 = Student()
    var myStudent1 = Student(1)
    var myStudent2 = Student(1, 2)
    var myStudent3 = Student(1, 2, 3)
    var myStudent4 = Student("Woah")

    //Getters and Setters are available by default in Kotlin
    val p = Person()
    println(p.name)
    p.name = "Adam"
    println(p.name)

    //Inheritance
    val aM = AmericanPresident()
    aM.getName()
    println(aM.getLikeability())
    aM.mediaRampage()

    val ceo = CEO("Jawn", 12345, 1200000.00)

    val b = B()
    println(b.getA())

    /*
    Exercises
    //1 Write a program to print the area and the perimeter of a triangle having sides 3,4,5 units
    by creating a class names triangle without any parameter in its constructor

    //2 Kotlin problem to add two complex numbers by passing class to a function
    create a class - complex number - 2 objects for the class - pass that to a function that returns the sum
    create some functions in the class that do the arithmetic operation on complex numbers

    //3 Create a class Car
    with args carName, carModel, carPrice, and create some 3 car objects assign them to different values
    pass array of objects to a function that will calculate the total price of all the 3 cars

    //4 //Homework Implement Tree Data type(Binary Tree(BST))
    have a class called tree with methods to create tree, insert element, search element
    In order Traversal Pre order Traversal Post order Traversal

    //5 // Homework Implement HashTable data type
    Create HashTable, insert, handle collision


    //6 create a calculator
    be able to mix arithmetic operations

    //7 Class called arithmetic with add function add(a,b)
    child Adder inherits arithmetic
    classes are not public
    child to override add func of parent: square the result of parent add and print it

    //8 Create a school with all the necessary different classes thats needed to construct a school/ if possible bring in relationships
    school, teacher, student, subject (Get creative and make things)

     */
    var tri = Triangle()
    println(tri.getArea())
    println(tri.getPerimeter())

    var c1 = ComplexNumber(4, 2)
    var c2 = ComplexNumber(3, 4)
    var c3 = c1.complexSum(c2)
    c1.printComNum()
    c2.printComNum()
    c3.printComNum()

    val car1 = Car("Betsy", "Civic", 13455.00)
    val car2 = Car("Slick", "Model x", 69420.00)
    val car3 = Car("Jeff", "F250", 55000.00)
    var cars = arrayOf(car1, car2, car3)
    println(carTotal(cars))
}
internal open class Arithmetic(var a:Int, var b:Int){
    open fun sum():Int{
        return a+b
    }
}
internal class Adder(a:Int,b:Int):Arithmetic(a,b){
    override fun sum():Int{
        var result = sqrt(super.sum().toDouble())
        println(result)
        return result.toInt()
    }

}
class Calculator(a:Array<Int>){
    var myIntArray = a
    fun sum():Int{
        var retu = 0
        for(i in myIntArray){
            retu += myIntArray[i]
        }
        return retu
    }
    fun sub():Int{
        var retu = 0
        for(i in myIntArray){
            retu -= myIntArray[i]
        }
        return retu

    }
    fun mul():Int{
        var retu = myIntArray[0]
        for(i in 1 until myIntArray.size){
            retu *= myIntArray[i]
        }
        return retu

    }
    fun divi():Int{
        var retu = myIntArray[0]
        for(i in 1 until myIntArray.size){
            retu /= myIntArray[i]
        }
        return retu

    }


}
fun carTotal(a:Array<Car>):Double{
    var sum = 0.0
    for(i in a){
        sum += i.price
    }
    return sum
}
class Car(carName:String, carModel:String, carPrice:Double){
    var name = carName
    var model = carModel
    var price = carPrice

}
class ComplexNumber(a:Int, b:Int){
    var real = a
    var imag = b
    fun printComNum(){
        println("$real + $imag" + "i")
    }
    fun complexSum(a: ComplexNumber):ComplexNumber{
        val real = a.real+this.real
        val imag = a.imag+this.imag

        return ComplexNumber(real,imag)
    }
}
//fun complexSum(a: ComplexNumber, b: ComplexNumber):ComplexNumber{
//    val real = a.real+b.real
//    val imag = a.imag+b.imag

//    return ComplexNumber(real,imag)
//}
class Triangle(){
    var a = 3
    var b = 4
    var c = 5
    fun getArea():Double{
        var s = ((a+b+c)/2)
        var temp = s*(s-a)*(s-b)*(s-c)
        return sqrt(temp.toDouble())
    }
    fun getPerimeter():Int{
        return a+b+c
    }
}
class Calc (a:Int, b:Int = 3){ //class parameters are immutable and uncallable
    //Property / Member variables
    var myA:Int
    var myB:Int
    //using Init to initialize
    init{

        println(a)
        println(b)
        myA = a
        myB = b
    }

    //Member Functions
    fun sum(a:Int, b:Int): Int{
        return a+b
    }
    fun mul(a:Int, b:Int): Int{
        return a*b
    }
    fun rem(a:Int, b:Int): Int{
        return a%b
    }
}
//Secondary constructors
class Student{
    constructor(){
        println("I am called for no args")
    }
    constructor(a:Int){
        println("I am called for 1 args: $a")
    }
    constructor(a:Int, b:Int){
        println("I am called for 2 args: $a ,$b")
    }
    constructor(a:Int, b:Int, c:Int){
        println("I am called for 3 args: $a ,$b, $c")
    }
    constructor(a:String){
        println("I am called for String args: $a")
    }
}

class Person(){
    var name = "default"
}
//inheritance
//by default class is "public final class"
open class Human (){
    open fun getName(){
        println("Jeff")
    }

}
class Dictator():Human(){
    fun oppress(){
        println("Welcome to opression")
    }
}
open class President():Human(){
    fun getLikeability():Double{
        return 32.56
    }

}
class AmericanPresident():President(){
    override fun getName(){
        super.getName() // Calls parent function, so you could add functionality here for specialization
        println("Gary")
    }
    fun mediaRampage(){
        println("That cant be correct, im rich.")
    }

}

/*open class Employee(name: String, id: Int){
    init{
        println("Hi my name is: $name")
        println("Hi my id is: $id")
    }
}

class CEO(name: String, id: Int, salary: Double):Employee(name,id){
    init{
        println("My Salary is: $salary")
    }
}

 */
open class Employee{
    constructor(name: String, id: Int){
        println("Hi my name is: $name")
        println("Hi my id is: $id")
    }
}
//If using secondary constructors, you need to call the super constructor you plan to use
class CEO:Employee{
    constructor(name: String, id: Int, salary: Double):super(name,id){
        println("My Salary is: $salary")
    }
}
/*
//Visibility modifiers
    public -visible everywhere
    private -visible only within the same class
    protected -visible within the same class AND its subclasses
    internal (Kotlin specific) -visible inside the same module(within folder/package)

 */
//Kotlin defaults to public final class
open class A{
    protected var a = 10
    //protected means it is still visible in subclass BProtected()
}

private class B{
    private var a1 = 22
    fun display(){
        println(a1)
    }
    fun getA(): Int{
        return a1
    }

}

class BProtect:A(){
    fun getMyProtectedValue():Int{
        return a
    }

}
//Recursion - Stack, Back Tracking
//fun funA(){
//    funA()
//    //Needs an exit condition, so it won't become an infinite loop
//}
