package estado.codegen

import estado.ast.nodes.Type

class CDecl(val type: Type, val id:String = "") {
    companion object {
        //creates a declaration for the implementation function of a RefFun
        fun refFunImplDecl(type: Type.Op.Fun.Ref, id: String, paramIds: List<String>? = null): String {
            return if (paramIds != null) {
                val paramString = (listOf("struct fun *self") +
                        type.paramTypes.zip(paramIds).map { CDecl(it.first, it.second).toString() }).joinToString()
                "${CDecl(type.retType)} $id($paramString)"
            } else {
                "${CDecl(type.retType)} $id(${type.paramTypes.map { CDecl(it) }.joinToString()})"
            }
        }
        //create extern decl
        fun externDecl(type: Type, id: String): String {
            return when (type) {
                is Type.Op.Fun.Native -> "extern ${CDecl(type.retType)} $id(${type.paramTypes.map { CDecl(it, "") }.joinToString()})"
                else -> throw RuntimeException("CDecl.toString not implemented for $type $id")
            }
        }
    }
    override fun toString(): String {
        return when (type) {
            is Type.Op.Bool -> "bool $id"
            is Type.Op.Int -> "int $id"
            is Type.Op.Unit -> "unit $id"
            is Type.Op.Text -> "struct text *$id"
            is Type.Op.Optional -> CDecl(type.t, id).toString()
            is Type.Op.OptionalPrimitive -> "struct optional_primitive $id"
            is Type.Op.Fun.Native -> "${CDecl(type.retType)} (*$id)(${type.paramTypes.map { CDecl(it, "") }.joinToString()})"
            is Type.Op.Fun.Ref -> "struct fun *$id"
            else -> throw RuntimeException("CDecl.toString not implemented for $type $id")
        }
    }
}