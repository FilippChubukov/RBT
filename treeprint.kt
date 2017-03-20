
class Printer<K: Comparable<K>, V> {
    fun print(node: Node<K, V>?) {
        if (node == null) return

        if (node.black == true){

            print("Nodekey ${node.key}" + " Nodevalue ${node.value}" + " Color Black")
            if(node.parent != null){
               println(" Parent ${node.parent?.key}")
            }else println(" Root")


        }else {

            print("Nodekey ${node.key}" + " Nodevalue ${node.value}" + " Color Red")
            if (node.parent != null) {
                println(" Parent ${node.parent?.key}")
            } else println(" Root")
        }
    }
}
