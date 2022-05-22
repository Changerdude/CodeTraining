/*
//Interfaces
    Interface provides a guarantee that the object has a certain set of properties and or functions

    interface InterfaceName{
        (Abstract properties)
        var test: String
        (Abstracted Methods)
        fun myAbsFun()
        (default implementation of properties and methods)
        fun hello(){
            println("Hello World!")
        }
    }

//Abstract Classes
    Abstract = Cannot be instantiated/can create an object from abstract class
    by default all member variables and fun not abstract
    abstract member function can be overwritten without open keyword
    abstract member function will have no implementation in the parent class_ it will be in the child class

    signature
    abstract class AbsClass(val x:Int){
        abstract var y:Int
        abstract var z:Int

        abstract fun sum()
    }

//Data Classes
only class that can be created within the main function
    signature
    data class ClassName(val Name){

    }
    the default functions to data class
    toString()
    copy()
    equals()
    hashCode()

//Sealed Class
    have a bounded set of class. A Sealed class is implicitly abstract, will have a set of subclasses that are only available within
    the sealed class.(A set of sub classes called through the sealed class)

    sealed class MySeal

//Kotlin Objects
    If a class is a "Singleton" the class/object can only have one instance
    signature
    object SingletonObject{

    }

//Nested and Inner Classes


 */

fun main(){
    val c1 = Car()
    c1.start()
    c1.run()

    var myNewObject = S()
    myNewObject.testA()
    myNewObject.testB()
    myNewObject.hello()


    var d1 = MyData("Bob", 1234, 32)
    var d2 = MyData("Jeff",4312,22)
    var d3 = d2.copy(name="Jawn")
    //toString doesnt include code block variables, only constructor values
    //doesnt show .address
    println(d1.toString())
    println(d3.toString())
    println(d1.address)
    var hash1 = d1.hashCode()
    var hash2 = d2.hashCode()
    var hash3 = d3.hashCode()
    //Hash will get a numerical value to compare two data classes
    println("Hash1: $hash1")
    println("Hash2: $hash2")
    println("Hash3: $hash3")
    println(hash2.equals(hash2))
    println(hash2.equals(hash3))



    var sC1 = MySeal.A()
    var sC2 = MySeal.B()

    sC1.display()
    sC2.display()

    val myO = MyAbsChild(5)
        myO.sum1()

    var add = Add()
    println(add.cal(1,2))
    var sub = Sub()
    println(sub.cal(1,2))
    var mul = Mul()
    println(mul.cal(1,2))
    //because Test is defined as an object it does not need to be initialized
    println(Test.sum())

}

sealed class MySeal{
    class A:MySeal(){
        fun display(){
            println("Inside A subclass")
        }
    }
    class B:MySeal(){
        fun display(){
            println("Inside B subclass")
        }
    }
}
class TestSeal: MySeal(){

    class SubClass : MySeal()
}
abstract class AbsClass(val x:Int){

    abstract var z:Int

    abstract fun sum1()

    open fun newSum(){
        println("In new sum")
    }
}
class MyAbsChild(x:Int):AbsClass(x){
    override var z = 10
    override fun sum1(){
        println("Inside sum")
    }
    override fun newSum(){
        println("In child new sum")
    }
}

abstract class Calculator{
    abstract fun cal(x:Int, y:Int):Int
}
class Add: Calculator(){
    override fun cal(x:Int, y:Int):Int{
        return x+y
    }
}
class Sub: Calculator(){
    override fun cal(x:Int, y:Int):Int{
        return x-y
    }
}
class Mul: Calculator(){
    override fun cal(x:Int, y:Int):Int{
        return x*y
    }
}

object SingletonObject{

}
//Already instantiated as an object
object Test{
    var a:Int = 5
    var b:Int = 6
    fun sum():Int{
        return a+b
    }
}

//Can be created in main function
data class MyData(val name: String,val id:Int, val age:Int){
    var address:String = "Holyoke"
}
//Guarantee's that classes that implement will have start and stop functions
interface Vehicle{
    fun start()
    fun stop()
    fun run(){
        println("Interface Moving")
    }
}
//Implements Vehicle, so it must have overridden start and stop functions. Does not need to override run because it
//has an implementation in the interface, fulfilling the guarantee that it is available
class Car():Vehicle {
    override fun start() {

    }

    override fun stop() {

    }
    override fun run(){
        super.run()
        println("Class Moving")
    }
}

class S:A,B{
    override fun hello(){
        super<A>.hello()
        super<B>.hello()
        println("Hello from Class")
    }
}
interface A{
    fun testA(){
        println("Test a")
    }
    fun hello(){
        println("Hello from A")
    }
}
interface B{
    fun testB(){
        println("Test a")
    }
    fun hello(){
        println("Hello from B")
    }
}

interface Dimentions{
    val len: Double
    val breadth: Double

}

interface CalcParams:Dimentions{
    fun area()
    fun perimeter()
}

class Triangle:CalcParams{
    //Set val len to 10.2
    override val len : Double = 10.2
    //Another way to set value. Could also make as pass-in parameters
    override val breadth : Double
        get() = 20.2



    override fun area(){
        println("This is my area")
    }
    override fun perimeter(){
        println("This is my perimeter")
    }

}
/*
//Food delivery app


 */