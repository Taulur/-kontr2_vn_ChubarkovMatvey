import kotlinx.coroutines.delay

class Airplanes(
    override var from: String,
    override var target: String,
    override var datefrom: String,
    override var timefrom: Int,
    override var time: Int,
    private var type : String
) : Carrier() {


    override fun SetInfo() {
        try {
            println("Введите марку самолета")
            this.type = readln()
            println("Введите пункт отправления")
            this.from = readln()
            println("Выберите пункт назначения")
            this.target = readln()
            println("Введите дату отправления в часах")
            this.datefrom = readln()
            do {
                println("Выберите время отправления")
                this.timefrom = readln()!!.toInt()
            } while (this.timefrom <= 0 || this.timefrom > 24)
            do {
                println("Введите время в пути в часах")
                this.time = readln()!!.toInt()
            } while (this.time <= 0 || this.time > 24)
        } catch (e:Exception)
        {
            println("Данные были введены неверно")
        }
    }
    override fun GetInfo() {
        println("Марка самолета - ${this.type}")
        println("Пункт отправления - ${this.from}")
        println("Пункт назначения - ${this.target}")
        println("Дата отправления - ${this.datefrom}")
        println("Время отправления - ${this.timefrom} ч")
        println("Количество часов в пути - ${this.time} ч")
    }

    fun AfterTime() {
        var aftertime = this.time + this.timefrom
        if (aftertime >= 24)
        {
            aftertime -= 24
            println("Вы отбываете в ${this.timefrom} и прибудите в ${aftertime} следущего дня")
        }
        else
        {
            println("Вы отбываете в ${this.timefrom} и прибываете в ${aftertime} этого же дня")
        }
    }

    suspend fun TodayFlight(n : Int){
        try {
            var flights = ""
            for (i in 0..n-1) {
                println("Введите следующий рейс")
                flights += "${readln()} "
                delay(500L)
            }
            println("Рейсы на сегодня : ${flights}")
        }
        catch (e:Exception)
        {
            println("Данные введены неверно")
        }
    }
}