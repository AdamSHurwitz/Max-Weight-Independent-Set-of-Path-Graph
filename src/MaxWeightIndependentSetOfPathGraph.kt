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
            } else {
                maxIndicesArrayList.addAll(outputArrayList.get(i - 2).maxIndicesArrayList)
                maxIndicesArrayList.addAll(inputArrayList.get(i - 1).maxIndicesArrayList)
            }
            outputArrayList.add(Node(i, nextMaxIndependentNodeWeight, maxIndicesArrayList))
        }
        var potentialMaxIndySetIndices = arrayListOf<Int>(1, 2, 3, 4, 17, 117, 517, 997)
        for (potentialMaxIndySetIndex in potentialMaxIndySetIndices) {
            if (outputArrayList.get(outputArrayList.size - 1).maxIndicesArrayList.contains(potentialMaxIndySetIndex)) {
                binaryOutput += 1
            } else {
                binaryOutput += 0
            }
        }
        return binaryOutput
    }
    //10100110
}