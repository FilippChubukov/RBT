
class Node<K: Comparable <K>, V>(var key: K, var value:V, var black: Boolean=false) {//Black=true, Red=false

    var right: Node<K,V>? = null
    var left: Node<K,V>? = null
    var parent: Node<K,V>? = null
}

