import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main(args: Array<String>) {
    println(feedTheFish())
//    var fortune : String
//    for (i in 1..7) {
//        fortune = getFortune(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break;
//    }

}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday : Int) : String {
    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )

    return fortunes[birthday.rem(fortunes.size)]
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, 50)
    shouldChangeWater(day = "Monday")

    if (shouldChangeWater(day)) {
        println("Change water today!")
    }

    if (canAddFish(10.0, listOf(), 3, true)) {
        println("You can add more fish!")
    } else {
        println("You need a bigger tank to add fish.")
    }
}

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 20) : Boolean {
    return true
}

fun canAddFish(tankSize: Double,
               currentFish: List<Int>,
               fishSize: Int = 2,
               hasDecorations: Boolean = true) : Boolean {

    return if (hasDecorations) {
        currentFish.sum() <= tankSize.times(0.80) - fishSize
    } else if (!hasDecorations) {
        currentFish.sum() <= tankSize - fishSize
    } else {
        false
    }
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}
fun fishFood(day : String): String {
    var food = "fasting"
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }

}

fun randomDay(): String {
    val week = listOf("Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}

fun dayOfWeek() {
    println("What day is it today?\n")
    val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (today) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "We have reached the event horizon"
    })
}

fun dayTime() {
    val time = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("kk")
    val humanTime = time.format(formatter).toInt()
    if (humanTime < 12) {
        println("Good morning, Kotlin")
    } else {
        println("Good night, Kotlin")
    }
}