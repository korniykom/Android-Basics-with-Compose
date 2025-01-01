enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Question<AnswerType>(
    val questionText: String,
    val answer : AnswerType,
    val difficulty: Difficulty
) {

}



class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override val progressText: String
        get() = "${answered} of ${total}  answered"

    override fun printProgressBar() {
        repeat(answered) {print("▓")}
        repeat(total - answered) { print("▒") }

    }
    companion object StudentProgress {
        val total : Int = 10;
        val answered : Int = 3;

    }

    fun printQuiz() {
        question1.let {
            print(it.questionText)
            print(it.answer)
            print(it.difficulty)
        }
        question2.let {
            print(it.questionText)
            print(it.answer)
            print(it.difficulty)
        }
        question3.let {
            print(it.questionText)
            print(it.answer)
            print(it.difficulty)
        }
    }


}


interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()

}