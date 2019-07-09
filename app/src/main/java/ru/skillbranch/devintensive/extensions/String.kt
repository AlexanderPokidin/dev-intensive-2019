package ru.skillbranch.devintensive.extensions

fun String.truncate(numOfChars: Int = 16): String {
    val tmpString = this
    var resString: String = tmpString

    val baseLength: Int = tmpString.length
    var resLength: Int = baseLength

    while (tmpString[baseLength - 1] == ' ') {
        resString = tmpString.substringBeforeLast(" ")
        resLength = resString.length
    }

    if (resLength > numOfChars) {
        resString = resString.removeRange(numOfChars, resLength)
        while (resString[resString.length - 1] == ' ') {
            resString = resString.substringBeforeLast(" ")
        }
        resString = "$resString..."
    }
    return resString
}

fun String.stripHtml(): String {
    val tmpString = this
    var resString: String

    val regexHtml = Regex("<[a-zA-Z0-9 =/\"]*>")
    val regexEsc1 = Regex("&[a-zA-Z0-9#]+;")
    val regexEsc2 = Regex("<[a-zA-Z0-9=\"'/ .:;\\-]*>")

    resString = tmpString.replace(regexHtml, "")
        .replace(regexEsc1, "")
        .replace(regexEsc2, "")

    val regexSpace = Regex("[ ]+")
    resString = resString.replace(regexSpace, " ")

    return resString
}