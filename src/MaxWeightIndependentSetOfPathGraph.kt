class MaxWeightIndependentSetOfPathGraph {
    var outputArrayList = arrayListOf<Node>()
    fun calculate(inputArrayList: ArrayList<Node>): String {
        outputArrayList.add(Node(1, 0, arrayListOf()))
        var secondInputNode = inputArrayList.get(0)
        outputArrayList.add(Node(2, secondInputNode.weight, arrayListOf(secondInputNode.id)))
        for (i in 2..inputArrayList.size) {
            //if (i < outputArrayList.size) {
            //todo: save winning indexes
            var lastCumWeight = outputArrayList.get(i - 1).weight
            var secondLastPlusCurrentCumWeight = outputArrayList.get(i - 2).weight + inputArrayList.get(i - 1).weight
            var nextMaxIndependentNodeWeight = Math.max(lastCumWeight, secondLastPlusCurrentCumWeight)
            var maxIndicesArrayList = arrayListOf<Int>()
            if (nextMaxIndependentNodeWeight == lastCumWeight) {
                maxIndicesArrayList.addAll(outputArrayList.get(i - 1).maxIndicesArrayList)
                println(String.format("lastCumWeight indices: %1s", outputArrayList.get(i - 1).maxIndicesArrayList))
                //outputArrayList.get(i).maxIndicesArrayList.add(inputArrayList.get(i - 1).id)
            } else {
                maxIndicesArrayList.addAll(outputArrayList.get(i - 2).maxIndicesArrayList)
                maxIndicesArrayList.addAll(inputArrayList.get(i - 1).maxIndicesArrayList)
                println(String.format("secondLastPlusCurrentCumWeight indices: %1s %2s",
                        outputArrayList.get(i - 2).maxIndicesArrayList, inputArrayList.get(i - 1).maxIndicesArrayList))
                //outputArrayList.get(i).maxIndicesArrayList.add(inputArrayList.get(i - 2).id)
            }
            outputArrayList.add(Node(i, nextMaxIndependentNodeWeight, maxIndicesArrayList))


                println(String.format("Max: %1s and %2s + %3s",
                        outputArrayList.get(i - 1).weight,
                        outputArrayList.get(i - 2).weight, inputArrayList.get(i - 1).weight))

            var outputNode = outputArrayList.get(i)
            /*println(String.format("id:%1s weight:%2s maxIndicesArrayList: %3s",
                    outputNode.id, outputNode.weight, outputNode.maxIndicesArrayList))*/
            //}
            //println(inputArrayList[i].id)
        }

        /*for (node in outputArrayList) {
            println(String.format("id:%1s weight:%2s maxIndicesArrayList: %3s",
                    node.id, node.weight, node.maxIndicesArrayList))
        }*/

        return "Hello World"
    }
}