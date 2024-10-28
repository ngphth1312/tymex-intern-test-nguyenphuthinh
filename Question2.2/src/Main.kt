fun main() {
    //[3, 7, 1, 2, 6, 4]

    print("Enter the array: ")
    var input = readlnOrNull() //input can be: "3 7 1 2 6 4" or "[3, 7, 1, 2, 6, 4]"

    while (input.isNullOrEmpty()) {
        print("Please enter the array for calculation: ")
        input = readlnOrNull()
    }

    val numberArr = input //handle user input
        .replace("[", "")
        .replace("]", "")
        .split(",", " ") //split by "," or " "
        .filter { it.isNotEmpty() } //filter to make sure array have no empty value
        .map { it.toInt() } //convert all the value to Int
        .toTypedArray()

    when(val result = findMissingNumber(numberArr)){
        -1 -> println("Something wrong occur, please try again later")
        0 -> println("There is no missing number in this array")
        else -> println("Missing number in this array is: $result")
    }
}

fun findMissingNumber(arr: Array<Int>) : Int {
    if(arr.isNotEmpty()){
        val n = arr.size
        var expectedSum = 0 //this is the result when we calculate the sum from 1 to n + 1
        for(i in 1..n+1){
            expectedSum += i
        }

        val inputArrSum = arr.sum()//this is the sum of the input array

        return when(val result = expectedSum - inputArrSum){
            n + 1 -> 0 //when expectedSum - inputArrSum = n + 1, it means that input the array is not missing any number
            else -> result
        }
    }
    return -1 //return -1 when something wrong occur (format, null, runtime errors, ...)
}