// Name: Yousef Alothman
// Date: Feb 13 2025
// Description: This Kotlin program demonstrates the use of lambda functions, higher-order functions, filtering, and mapping.


// Function to filter names based on a given lambda function
fun filterNames(name: List<String>, lamFunction: (String) -> Boolean): List<String> {
    return name.filter(lamFunction)  // Uses the filter function to return only names that satisfy the lambda condition
}

// Function to filter numbers based on a given lambda function
fun customFilter(numbers: List<Int>, lamFilter: (Int) -> Boolean): List<Int> {
    return numbers.filter(lamFilter)  // Filters the numbers based on the lambda condition
}

// Function to filter numbers first and then apply an action (mapping)
fun processNumbers(number: List<Int>, lamFilter: (Int) -> Boolean, lamAction: (Int) -> Int): List<Int> {
    val temp = number.filter(lamFilter)  // First, filter numbers based on the lambda function
    return temp.map(lamAction)  // Then, transform the filtered numbers using the mapping lambda function
}

fun main() {
    // Part 1: Doubling each element in the list
    val intList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(intList)

    val lamDouble: (Int) -> Int = { num -> num * 2 }  // Lambda function to double a number
    val doubleNumber = intList.map(lamDouble)  // Apply the function to each element
    println(doubleNumber)

    // Part 2: Filtering names that start with 'A'
    val name1 = listOf("Alice", "Bob", "Amir", "Charlie", "Annie", "David")
    val firstLetterA: (String) -> Boolean = { x -> x.startsWith("A") }  // Lambda to check if the name starts with 'A'
    println(filterNames(name1, firstLetterA))

    // Part 3: Sorting a list of strings in descending order
    val name2 = listOf("apple", "banana", "kiwi", "strawberry", "grape")
    println(name2)

    val lamSortList: (List<String>) -> List<String> = { temp -> temp.sortedDescending() }  // Sorting in descending order
    println(lamSortList(name2))

    // Part 4: Custom filtering with different conditions
    val numList2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val lamGreaterThan5: (Int) -> Boolean = { temp -> temp > 5 }  // Filter numbers greater than 5
    val lamEvenNumbers: (Int) -> Boolean = { temp -> temp % 2 == 0 }  // Filter even numbers
    val lamMultOf3: (Int) -> Boolean = { temp -> temp % 3 == 0 }  // Filter numbers that are multiples of 3

    println(customFilter(numList2, lamGreaterThan5))
    println(customFilter(numList2, lamEvenNumbers))
    println(customFilter(numList2, lamMultOf3))

    // Part 5: Filtering odd numbers and squaring them
    val lamOddNumbers: (Int) -> Boolean = { temp -> temp % 2 == 1 }  // Filter odd numbers
    val lamSquare: (Int) -> Int = { temp -> temp * temp }  // Square each number
    println(processNumbers(numList2, lamOddNumbers, lamSquare))
}