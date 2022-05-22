import java.util.*

fun main(){
    println("Hello World!!")
/*
    for(i in 100 downTo 10 step 10){
        if(i == 100){
            print("$i")
        }
        print(", $i")
    }

    var things = arrayOf(1,2,3,4,5,6,7,8,9,10,11)
    for(item in things){
        if(item % 5 == 0){
            println("$item is divisable by 5")
        }else{
            println("$item is not diviable by 5")
        }
    }

    var peopleArray = arrayOf("Jeff", "Andrew", "Jawn", "Steve", "Vic", "Anthony", "Jake", "Matt")

    for( people in peopleArray) {
        println("$people")
    }
    for( i in peopleArray.indices){
        println(peopleArray[i])
    }
    for( (i,v) in peopleArray.withIndex()){
        println("My index is $i and the corresponding value is $v")
    }
    val name = "Kurt T Jeffries"
    for(letter in name){
        print(letter)
    }


    for(letter in name.indices){
        print(name[letter])
    }

    for((i,v) in name.withIndex()){
        println("The index $i is the letter $v")
    }

    var collection =listOf(1,2,"Steve","Gary")

    for(item in collection){
        println(item)
    }

    var a = arrayOf( 1,3,7,2,60,23)
    var b = 23

    for ((i,v) in a.withIndex()){
        if(v == b){
            println("$b found at index: $i")
            break
        }else if (i == a.lastIndex) {
                println("$b not found in array.")
        }


    }

    var myString:String? = "Huh?"
    println(myString)
    myString = null
    println(myString)


    print("Enter text: ")
    var input = readLine()
    println("Your input is: $input")

    val num = Scanner(System.`in`)
    print("Enter integer: ")
    var myNum = num.nextInt()

    print("Enter float: ")
    var myFloat = num.nextFloat()
    println("Your integer: $myNum")
    println("Your float: $myFloat")


    Ask for input integer
    then output sum of all numbers before input

    val num = Scanner(System.`in`)
    print("Enter integer: ")
    var myNum = num.nextInt()
    var output = 0
    for(i in 1..myNum){
        output += i
    }
    println("The sum of all numbers leading to your input is $output")



    print("Enter 5 numbers:")
    var myIntArray = Array<Int>(5){readln().toInt()}
    var sum = 0

    val read = Scanner(System.`in`)
    //Collect array size
    println("Please select an Array Size:")
    val n = read.nextInt()
    //instantiate an array with n length and collect n items for the array
    println("The Int inputs please:")

        var myScanInp = Array(n) { i -> read.nextInt() }


    for(ele in myIntArray){

            sum += ele

        println(ele)
    }
    println("Your total: $sum")
    sum = 0
    for(ele in myScanInp){

            sum += ele

        println(ele)
    }
    println("Your total: $sum")

 */
    /*
    Exercise 2 find factorial n!
    multiply all numbers up to input

    Exercise 3
    generate mutiplications table

    inp * 1 = x all the way to 10

    Exercise 4
    Display fibonacci series up to 100
    prev + current = next

    Exercise 5
    print the following numbers using for loop
    1236420

    Exercise 6: Find largest element in an array
    Use the following elements in the array
    (23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5)

    Exercise 7: Program to Calculate Average Using Arrays
    Use the following value for array:
    (45.3, 67.5, -45.6, 20.34, 33.0, 45.6)

    Exercise 8:Print ASCII values and their equivalent characters. ASCII value vary from 0 to 255.



     */

    //Exercise 2


    val factorial = Scanner(System.`in`)
    print("Enter number: ")
    val myFactorial = factorial.nextLong()
    var output: Long = 1
    for(i in 1..myFactorial){
        output *= i
    }
    println("The factorial of $myFactorial is $output")

    //Exercise 3
    val read = Scanner(System.`in`)
    println("Please give int to multiply")
    val mult = read.nextInt()

    for(i in 1..10){
        println("$mult * $i = ${mult * i}")
    }

    //Exercise 4
    print("End the fibbonaci where?")
    val end = Scanner(System.`in`)
    val myEnding = end.nextInt()
    var prev = 0
    var curr = 1
    print(prev)
    do{
        print(" $curr")
        val temp = prev + curr
        prev = curr
        curr = temp
    }while(curr < myEnding)
    println()

    //Exercise 5
    val a = arrayOf(1,2,3,6,4,2,0)
    for(i in a){
        print("$i ")
    }

    //Exercise 6
    //(23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5)
    val b = arrayOf(23.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5)
    var largest = b[0]
    for(i in b){
        if(i > largest){
            largest = i
        }
    }
    println("$largest is the largest number in the array.")

    //Exercise 7
    val c = arrayOf(45.3, 67.5, -45.6, 20.34, 33.0, 45.6)
    var sum = 0.0
     for(i in c){
         sum += i
     }
    println("The average of the array is ${sum / c.size}")

    //Exercise 8
    for(i in 0..255){
        print("$i : ${i.toChar()}, ")
    }
}