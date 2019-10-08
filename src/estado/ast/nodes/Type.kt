package estado.ast.nodes

sealed class Type {

    companion object {
        const val BOOL = "Bool"
        const val INT = "Int"
        const val TEXT = "Text"
        const val FUN = "Fun"
        const val REFFUN = "RefFun"
        const val UNIT = "Unit"
        const val OPTIONAL = "Optional"
        const val REF = "Ref"
    }

    sealed class Op: Type() {

        abstract val operator: String

        abstract val params: List<Type>

        object Unit: Op() {
            override val params: List<Type> get() = emptyList()
            override val operator: String get() = UNIT
            override fun isManaged(): Boolean = false
            override fun toString(): String = "Unit"
        }

        object Int: Op() {
            override val operator: String
                get() = INT
            override val params: List<Type>
                get() = emptyList()
            override fun isManaged(): Boolean = false
            override fun toString(): String = "Int"
        }

        object Bool: Op() {
            override val operator: String
                get() = BOOL
            override val params: List<Type>
                get() = emptyList()
            override fun isManaged(): Boolean = false
            override fun toString(): String = "Bool"
        }

        class Optional(val t: Type): Op() {
            override val operator: String
                get() = OPTIONAL
            override val params: List<Type>
                get() = listOf(t)
            override fun isManaged(): Boolean = t.isManaged()
            override fun toString(): String = "?$t"
        }

        class OptionalPrimitive(val t: Type): Op() {
            override val operator: String
                get() = OPTIONAL
            override val params: List<Type>
                get() = listOf(t)
            override fun isManaged(): Boolean = false
            override fun toString(): String = "?$t"
        }

        object Text: Op() {
            override val operator: String
                get() = TEXT
            override val params: List<Type>
                get() = emptyList()
            override fun isManaged(): Boolean = true
            override fun toString(): String = "Text"
        }

        class Ref(val t: Type): Op() {
            override val operator: String
                get() = REF
            override val params: List<Type>
                get() = listOf(t)
            override fun isManaged(): Boolean = true
            override fun toString(): String = "&$t"
        }

        sealed class Fun(private val _params: List<Type>, private val ret: Type): Op() {

            override val operator: String
                get() = FUN
            override val params: List<Type>
                get() = _params + ret

            val retType: Type get() = params.last()
            val paramTypes: List<Type> get() = params.dropLast(1)

            class Native(_params: List<Type>, ret: Type): Fun(_params, ret) {
                override val operator: String get() = FUN
                override fun isManaged(): Boolean = false
                override fun toString(): String = "(${paramTypes.joinToString()})$retType"
            }
            class Ref(_params: List<Type>, ret: Type): Fun(_params, ret) {
                override val operator: String get() = REFFUN
                override fun isManaged(): Boolean = true
                override fun toString(): String = "&(${paramTypes.joinToString()})$retType"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Op

            if (operator != other.operator) return false
            if (params != other.params) return false

            return true
        }

        override fun hashCode(): kotlin.Int {
            var result = operator.hashCode()
            result = 31 * result + params.hashCode()
            return result
        }
    }

    class Var: Type() {

        companion object {
            private var index = 0
        }

        val id:Int = index++

        override fun toString(): String =
            "<$id>"

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Var

            if (id != other.id) return false

            return true
        }

        override fun hashCode(): Int {
            return id
        }
    }

    open fun isManaged(): Boolean = TODO("not implemented")

}