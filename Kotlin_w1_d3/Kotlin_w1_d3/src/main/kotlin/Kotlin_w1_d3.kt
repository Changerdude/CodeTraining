import java.time.LocalDate
import kotlin.math.*

fun main(){
        /*
        Functions
        signature of a function

        fun functionsName(arg: argType,...):returnType{

        }

        2 Catagories of Funtion
        1. Standard Library function - print, readLine, toInt
        2. User defined function - sum

        //Default parameters of a Function
                                                                             vvvvv
        fun insertStudentDetails(name: String, id: Int, grade: Char, age: Int = 10, dob: LocalDate): Boolean{
        Defaults to age 10 if there isn't anything in age however, args with defaults should be at the end to be
        able to leave out of the parameter list if unavailable

        can use named arguments to label which are which to avoid issues with defaults used or not
        insertStudentDetails(name = "Kurt", id = 24, dob= LocalDate.parse("1990-05-02"))

        //Lambda expressions
        val name : dataType = {argList -> codeBlock}
        Ex.
        val myOutput = { println("My output") }
        can call by simply
        myOutput()

        //Anonymous functions
        Functions with no names.
        fun(argsName:argType,....): returnType {codeBlock}
        fun(argsName:argType,....): returnType = codeblock

        fun(a:Int, b:Int): Int = a*b

        The difference between a Lambda and an Anonymous function is that the lambda will return the last statement
        but the anonymous function uses the "return" function. Using a return in a lambda will use the return in
        the function that called the lambda.


        //Inline functions
        inline will tell compiler not to allocate space for the function, does code there without passing to function
        for computing then passing back information

        inline fun higherSum(a: Int, b: Int): Int{

        in Kotlin instead of using void type it is called Unit

        }
        //Higher order Functions
        A function the is using a function as an arg is called a higher order function and returns another
        function



        Extension Functions

         */
        println(sum(2,4))
        println(mul(2,4))

        val nameArray = arrayOf("Jeff", "Steve", "Vic", "Jawn")
        val idArray = arrayOf(1234,4321, 1243, 2134)
        val gradeArray = arrayOf('B', 'A', 'A', 'B')
        val ageArray = arrayOf(12, 25, 25, 26)
        val dobArray = arrayOf(LocalDate.parse("2009-02-12"), LocalDate.parse("1995-05-02"), LocalDate.parse("1995-02-22"), LocalDate.parse("1994-02-12"))

        for((index,value) in nameArray.withIndex()) {
            insertStudentDetails(value, idArray[index], dobArray[index], gradeArray[index], ageArray[index])
        }
        //Named parameters
        insertStudentDetails(name = "Kurt", id = 24, dob= LocalDate.parse("1990-05-02"))

        println(mul(3,4))

        //Lambda expression
        val sum = {a:Int,b:Int -> a+b}
        println(sum(3,4))

        val sum2 = {a:Int, b:Int ->
            val i = (a+b) * 2
            println(i)
        }
    sum2(5,4)

    println(anon1(2,3))
    println(anon2(2,3))

    higherSum({println("Hello")
        23},
        {println("Ello")
        99})

     hoFun(lmb)
     hoFun(::mul)
    var sum3 = hoFun()
    println("My summed output is: ${sum3(10,11)}")

    //Find if two rectangles will overlap each other
    // (rec1x1,rec1y1)(rec1x2,rec1y2)
    //x1y1----------|
    //|             |
    //|-------------x2y2
    // (rec2x1,rec2y1)(rec2x2,rec2y2)
    // are any numbers between rec2x1 and rec2x2 also between rec1x1 and rec1x2 if so check y's of that x
    val rec1x1 = 0
    val rec1y1 = 0
    val rec1x2 = 10
    val rec1y2 = 10
    val rec2x1 = 8
    val rec2y1 = 8
    val rec2x2 = 12
    val rec2y2 = 12

        for(x in rec1x1..rec1x2){
            if(x in (rec2x1) until rec2x2){
                for(y in rec1y1..rec1y2) {
                    if (y in (rec2y1) until rec2y2) {
                        println("Rectangles do overlap")
                        //return
                    }
                }
            }
        }
        println("Rectangles do not overlap")

    // Check if two date ranges will overlap
    // L1 (l1x1,l1y1) (l1x2,l1y2)
    // L2 (l2x1,l2y1) (l2x2,l2y2)
    // Overlaping line segments


    //Sort a list of items using for loop
    //(index,value) in nameArray.withIndex()
    var intArray = arrayOf(2,1,34,22,5,11)
    var index = 0
    for(i in 0..intArray.size -1) {
        var minimum = intArray[i]
        for (j in i+1..intArray.size -1){
            if (j < minimum) {
                minimum = intArray[j]
                index = j
            }
        }
        println("$minimum, ")
        var t = intArray[i]
        intArray[i] =intArray[index]
        intArray[index] = t

    }


    //Kotlin program to convert decimal number to binary



    //Kotlin program to multiply two matrix using multi-dimensional array
    var arr1 = intArrayOf(1,2,3,4)
    var arr2 = intArrayOf(2,4,6,8)
    var arr3 = intArrayOf(3,6,9,12)
    var arr4 = intArrayOf(4,8,12,16)
    var arrM1 = intArrayOf(0,0)
    var arrM2 = intArrayOf(0,0)

    var matrix1: Array<IntArray> = arrayOf(arr1, arr3)
    var matrix2: Array<IntArray> = arrayOf(arr2, arr4)
    var matrixMulti: Array<IntArray> = arrayOf(arrM1, arrM2)
    var sumMM = 0
    for(i in 0..1){
         for (k in 0..1){
            for(j in 0 until matrix1[i].size) {
                sumMM += matrix1[i][j] * matrix2[k][j]

            }
            matrixMulti[i][k] = sumMM
            sumMM = 0
        }

    }
    for(i in matrixMulti){
        for(k in i){
            print("$k ")
        }
        println()
    }


    //Find distance between two points // What if the points are locations on a map(lat long distance,Distance not is a straight line)
    var point1 = doubleArrayOf(13.9,23.6)
    var point2 = doubleArrayOf(137.4,53.8)
    val r = 6371 //radius of earth in km
    var distStraight = sqrt((point2[0] - point1[0]).pow(2) + (point2[1] - point1[1]).pow(2))

    var latDif = (point2[0] - point1[0]) + (PI/180)
    var lonDif = (point2[1] - point1[1]) + (PI/180)

    val a = (sin(latDif/2)).pow(2) + cos(point1[0]) * cos(point2[0]) * (sin(lonDif/2)).pow(2)

    val c = 2 * atan2(sqrt(a), sqrt(1-a))


    var distHavers = r * c

    println(distStraight)
    println(distHavers)





    //Given a word you need to do a spell check and suggest a word // Distance formula between two words



    }

    //Higher order fun
    val lmb = {a:Int, b:Int -> a+b}
    fun hoFun(lmb: (Int, Int) -> Int){
        var r = lmb(2,5)
        println("My result: $r")
    }

    fun hoFun(): (Int, Int) -> Int{
    return ::sum
}

    inline fun higherSum(lmb1: () -> Int, lmb2: () -> Int ){
        lmb1()

        lmb2()

        println(lmb1()+lmb2())
        println("ddsadasdas")
    }
    val anon1 = fun(a:Int, b:Int): Int = a+b
    val anon2 = fun(a:Int, b:Int): Int {
        return a*b
    }

    fun sum(a: Int, b: Int):Int{
        return a+b
    }

    fun mul(a: Int, b: Int):Int{
        return(a*b)
    }
    //Default parameter                                                                     vvvvvvvv
    fun insertStudentDetails(name: String, id: Int, dob: LocalDate, grade: Char = 'U', age: Int = 10): Boolean{
        println("Student Details")
        println("Name: $name")
        println("Id: $id")
        println("Grade: $grade")
        println("Age: $age")
        println("DoB: $dob")
        return true
    }