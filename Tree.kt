
class Tree<K: Comparable<K>, V>: Interface<K, V>, Iterable<Node<K, V>>  {

    override var root: Node<K,V>? = null

    override fun insert(NewNode: Node<K,V>){

        var current: Node<K,V>? = root

        var par: Node<K,V>? = null

        while( current != null ) {

            par = current
            if(NewNode.key < current.key) {

                current = current.left
            }else {

                current = current.right
            }
        }

        NewNode.parent = par
        if(NewNode.parent == null) {

            root = NewNode
            NewNode.black = true
            return
        }

        if(NewNode.key < par!!.key) {

            par.left = NewNode
            NewNode.black = false
        }else {

            par.right = NewNode
            NewNode.black = false
        }
        NewNode.right = null
        NewNode.left = null
        Balance(NewNode)
    }

    private fun Balance(NewNode: Node<K, V>?){

        var uncle: Node<K,V>?
        var current: Node<K,V>? = NewNode

        while(current?.parent?.black == false){

            if(current.parent == current.parent?.parent?.left){

                uncle = current.parent?.parent?.right
                if(uncle?.black == false){

                    current.parent?.black = true
                    uncle.black = true
                    current.parent?.parent?.black = false
                    current = current.parent?.parent
                }else if (current == current.parent?.right) {

                    current = current.parent
                    Lrotate(current)
                }else if (current == current.parent?.left) {

                    current.parent?.black = true
                    current.parent?.parent?.black = false
                    Rrotate(current.parent?.parent)
                }
            }else {

                uncle = current.parent?.parent?.left
                if (uncle?.black == false) {

                    current.parent?.black = true
                    uncle.black = true
                    current.parent?.parent?.black = false
                    current = current.parent?.parent
                } else if (current == current.parent?.left) {


                    current = current.parent
                    Rrotate(current)
                } else if (current == current.parent?.right) {

                    current.parent?.black = true
                    current.parent?.parent?.black = false
                    Lrotate(current.parent?.parent)
                }
            }
        }
        root?.black = true
    }

    override fun Lrotate(A: Node<K, V>?) {

        val B: Node<K, V>? = A?.right
        A?.right = B?.left
        B?.left?.parent = A
        B?.parent = A?.parent
        if (A?.parent == null) {

            root = B
        }
        if (A == A?.parent?.left) {

            A?.parent?.left = B
        }
        if (A == A?.parent?.right) {

            A?.parent?.right = B
        }
        B?.left = A
        A?.parent = B
    }





    override fun Rrotate(A: Node<K, V>?) {

        val B: Node<K, V>? = A?.left
        A?.left = B?.right
                B?.right?.parent = A
                B?.parent = A?.parent
                if (A?.parent == null) {

            root = B
        }
        if (A == A?.parent?.right) {

            A?.parent?.right = B
        }
        if (A == A?.parent?.left) {

            A?.parent?.left = B
        }
        B?.right = A
                A?.parent = B
    }

    override fun iterator(): Iterator<Node<K, V>> {
        return (object : Iterator<Node<K, V>> {

            var node = findMAX()
            var next = findMAX()
            val last = findMIN()

            override fun hasNext(): Boolean {

                return (node != null) && (node!!.key >= last!!.key)
            }

            override fun next(): Node<K, V> {

                next = node
                node = MAXSmaller(node)
                return next!!
            }
        })
    }

    override fun findMAX(node: Node<K,V>?): Node<K,V>?{

        var max = node
        while(max?.right != null){

            max = max.right
        }
        return max
    }

    override fun findMIN(node: Node<K, V>?): Node<K, V>? {

        var min = node
        while (min?.left != null) {

            min = min.left
        }
        return min
    }

    override fun MAXSmaller(node: Node<K, V>?): Node<K,V>? {

        var smaller = node ?: return null

        when {

            (smaller.left != null) -> {
                return findMAX(smaller.left)
            }
            (smaller == smaller.parent?.left) -> {
                while (smaller == smaller.parent?.left) {
                    smaller = smaller.parent!!
                }
            }
        }

        return smaller.parent
    }

    override fun findnode(key: K, current: Node<K, V>?): Node<K, V>? {

        if (current == null) return null
        if(current.key == key) return current
        if(current.key > key) {

            return this.findnode(key, current.left)

        }else { if(current.key <key) return this.findnode(key, current.right)}
        return null
    }


}