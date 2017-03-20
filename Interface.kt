
interface Interface<K: Comparable<K>,V> {

     var root: Node<K,V>?
     fun insert(NewNode: Node<K,V>)
     fun Lrotate(A: Node<K,V>?)
     fun Rrotate(A: Node<K,V>?)
     fun findMAX(node: Node<K, V>? = root): Node<K, V>?
     fun findMIN(node: Node<K, V>? = root): Node<K, V>?
     fun findnode(key: K, current: Node<K,V>? = root): Node<K,V>?
     fun MAXSmaller(node: Node<K,V>?): Node<K,V>?
}