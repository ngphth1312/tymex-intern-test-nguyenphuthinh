fun main() {
    val inventory = mutableListOf<Product>()//Initialize inventory

    //Creating products and adding it to the inventory
    val product1 = Product("Laptop", 999.99, 5)
    val product2 = Product("Smartphone", 499.99, 10)
    val product3 = Product("Tablet", 299.99, 0)
    val product4 = Product("Smartwatch", 199.99, 3)

    inventory.add(product1)
    inventory.add(product2)
    inventory.add(product3)
    inventory.add(product4)

//    val product5 = Product("Headphones", 199.99, 3) create and adding Headphones to inventory to test the output of question 3
//    inventory.add(product5)

    //1. Calculate the total inventory value
    val totalValue = calculateTotalValue(inventory)
    println("Q1. Total value of inventory is: $totalValue")

    //2. Find the most expensive product
    val mostExpensiveProduct = findMostExpensiveProduct(inventory)
    println("Q2. The most expensive product is ${mostExpensiveProduct?.name}, which cost ${mostExpensiveProduct?.price}")

    //3. Check if a product named "Headphones" is in stock
    val checkProductName = "Headphones"
    when(isProductNameInStock(inventory, checkProductName)){
        true -> println("Q3. True (Headphones are in stock)")
        false -> println("Q3. False (Headphones are NOT in stock)")
    }

    //4. Sort products in descending/ascending order with options like by price, quantity
    //Sort option: price
    val sortedByPriceAscending = sortedProductsAscendingByOption(inventory, "price")
    val sortedByQuantityAscending = sortedProductsAscendingByOption(inventory, "quantity")
    if(sortedByPriceAscending == null || sortedByQuantityAscending == null) {
        println("Q4. Error: Unexpected error when sorting inventory")
    } else{
        println("Q4. Products sorted:")
        printQuestion4Result(sortedByPriceAscending, sortedByQuantityAscending)
    }
}

fun calculateTotalValue(inventory: MutableList<Product>): Double {
    var total = 0.0
    for(product in inventory){
        total += product.price * product.quantity
    }
    return total
}

fun isProductNameInStock(inventory: MutableList<Product>, productName: String): Boolean {
    return inventory.any { it.name == productName }
}

fun findMostExpensiveProduct(inventory: MutableList<Product>): Product? {
    var maxPrice = 0.0
    for(product in inventory){
        if(product.price > maxPrice){
            maxPrice = product.price
        }
    }
    return inventory.find { it.price == maxPrice }
}

fun sortedProductsAscendingByOption(inventory: MutableList<Product>, option: String): MutableList<Product>? {
    return when(option){
        "price" -> inventory.sortedBy { it.price }.toMutableList()
        "quantity" -> inventory.sortedBy { it.quantity }.toMutableList()
        else -> null
    }
}

fun printQuestion4Result(sortedProductsByPrice : MutableList<Product>, sortedProductByQuantity : MutableList<Product>) : Unit {
    //Option: price
    //Ascending
    println("\nProducts sorted by Price in ASCENDING order:")
    for(i in sortedProductsByPrice.indices){
        println("${i + 1}. ${sortedProductsByPrice[i].name}, price ${sortedProductsByPrice[i].price}, quantity ${sortedProductsByPrice[i].quantity}")
    }
    //Descending
    val sortedByPriceDescending = sortedProductsByPrice.reversed()
    println("\nProducts sorted by Price in DESCENDING order:")
    for(i in sortedByPriceDescending.indices){
        println("${i + 1}. ${sortedByPriceDescending[i].name}, price ${sortedByPriceDescending[i].price}, quantity ${sortedByPriceDescending[i].quantity}")
    }

    //Option: Quantity
    //Ascending
    println("\nProducts sorted by Quantity in ASCENDING order:")
    for(i in sortedProductByQuantity.indices){
        println("${i + 1}. ${sortedProductByQuantity[i].name}, price ${sortedProductByQuantity[i].price}, quantity ${sortedProductByQuantity[i].quantity}")
    }
    //Descending
    val sortedByQuantityDescending = sortedProductByQuantity.reversed()
    println("\nProducts sorted by Quantity in DESCENDING order:")
    for(i in sortedByQuantityDescending.indices){
        println("${i + 1}. ${sortedByQuantityDescending[i].name}, price ${sortedByQuantityDescending[i].price}, quantity ${sortedByQuantityDescending[i].quantity}")
    }
}