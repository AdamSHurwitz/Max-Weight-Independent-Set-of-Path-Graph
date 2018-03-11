import java.io.File

object MaxWeightIndependentSetofPathGraphTest {
    @JvmStatic
    fun main(args: Array<String>){
        var inputArrayList = arrayListOf<Node>()
        var i = 0
        //File("src/data/set_small_sample")
        //File("src/data/set_small_sample2")
        //File("src/data/set_1_10")
        File("src/data/set")
                .inputStream()
                .bufferedReader()
                .forEachLine { it ->
                    inputArrayList.add(Node(i, it.toInt(), arrayListOf(i)))
                    i++
                }
        inputArrayList.remove(inputArrayList.get(0))
        println(MaxWeightIndependentSetOfPathGraph().calculate(inputArrayList))
    }
}