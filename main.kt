
import java.util.Random

 fun main(args: Array<String>) {
    val rbt = Tree<Int, Char>()

    while (true) {

        val input = readLine()
        when (input) {
            "f" -> {

                print("Find: ")
                val key = readLine()?.toIntOrNull()
                if (key != null) {
                    if (rbt.findnode(key) != null) println("Found")
                    else println("Not found")
                }
            }
            "p" -> {

                for (i in rbt) {
                    Printer<Int, Char>().print(i)
                }
            }
            else -> {

                val key = input?.toIntOrNull()
                if (key != null) {
                    val newNode = Node(key, 'a')
                    rbt.insert(newNode)
                }
            }
        }
    }
}
