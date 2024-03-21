import kotlinx.coroutines.*
suspend fun main() = coroutineScope{
    var airplane = Airplanes("unnamed","unnamed","unnamed",0,0,"unnamed")
    airplane.SetInfo()
    airplane.GetInfo()
    launch {
        var n : Int
        do {
            println("Введите количество рейсов на сегодня")
             n = readln().toInt()
        } while (n <= 0 || n > 15)
        airplane.TodayFlight(n)
    }
    delay(20000L)
    airplane.AfterTime()

}