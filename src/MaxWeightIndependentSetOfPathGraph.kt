class MaxWeightIndependentSetOfPathGraph {
    var outputArrayList = arrayListOf<Node>()
    var binaryOutput = ""
    fun calculate(inputArrayList: ArrayList<Node>): String {
        outputArrayList.add(Node(1, 0, arrayListOf()))
        var secondInputNode = inputArrayList.get(0)
        outputArrayList.add(Node(2, secondInputNode.weight, arrayListOf(secondInputNode.id)))
        for (i in 2..inputArrayList.size) {
            var lastCumWeight = outputArrayList.get(i - 1).weight
            var secondLastPlusCurrentCumWeight = outputArrayList.get(i - 2).weight + inputArrayList.get(i - 1).weight
            var nextMaxIndependentNodeWeight = Math.max(lastCumWeight, secondLastPlusCurrentCumWeight)
            var maxIndicesArrayList = arrayListOf<Int>()
            if (nextMaxIndependentNodeWeight == lastCumWeight) {
                maxIndicesArrayList.addAll(outputArrayList.get(i - 1).maxIndicesArrayList)
                println(String.format("lastCumWeight indices: %1s", outputArrayList.get(i - 1).maxIndicesArrayList))
            } else {
                maxIndicesArrayList.addAll(outputArrayList.get(i - 2).maxIndicesArrayList)
                maxIndicesArrayList.addAll(inputArrayList.get(i - 1).maxIndicesArrayList)
                println(String.format("secondLastPlusCurrentCumWeight indices: %1s %2s",
                        outputArrayList.get(i - 2).maxIndicesArrayList, inputArrayList.get(i - 1).maxIndicesArrayList))
            }
            outputArrayList.add(Node(i, nextMaxIndependentNodeWeight, maxIndicesArrayList))


                println(String.format("Max: %1s and %2s + %3s",
                        outputArrayList.get(i - 1).weight,
                        outputArrayList.get(i - 2).weight, inputArrayList.get(i - 1).weight))
        }

        /*for (node in outputArrayList) {
            println(String.format("id:%1s weight:%2s maxIndicesArrayList: %3s",
                    node.id, node.weight, node.maxIndicesArrayList))
        }*/

        for(node in inputArrayList) {
            if (!outputArrayList.get(outputArrayList.size -1).maxIndicesArrayList.contains(node.id)) {
                binaryOutput += 0
            } else {
                binaryOutput += 1
            }
        }
        //outputArrayList.get(outputArrayList.size -1).maxIndicesArrayList.toString()
        return binaryOutput
    }
}