package estado.util

fun String.toCIdentifier(): String =
    replace(Regex("(^[^a-zA-Z_])|([^a-zA-Z_0-9])"), "_")