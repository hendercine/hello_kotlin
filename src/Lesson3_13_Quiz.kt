
fun main(args: Array<String>) {

    fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {

        return when (mood) {
            "happy" -> "Go for a walk."
            else -> "Stay inside and read."
        }
    }
}