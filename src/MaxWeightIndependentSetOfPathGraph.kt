class MaxWeightIndependentSetOfPathGraph {
    var outputArrayList = arrayListOf<Node>()
    fun calculate(inputArrayList: ArrayList<Node>): String {
        outputArrayList.add(Node(1, 0, arrayListOf()))
        var secondInputNode = inputArrayList.get(0)
        outputArrayList.add(Node(2, secondInputNode.weight, arrayListOf(secondInputNode.id)))
        for(i in 0 .. inputArrayList.size - 1) {
            if (i < outputArrayList.size) {
                var outputNode = outputArrayList.get(i)
                println(String.format("id:%1s weight:%2s maxIndicesArrayList: %3s",
                        outputNode.id, outputNode.weight, outputNode.maxIndicesArrayList))
            }
            //println(inputArrayList[i].id)
        }
        return "Hello World"
    }
}