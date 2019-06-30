package ru.skillbranch.devintensive.utils

object Utils {
    //    TODO: Fix me!!!
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firsName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
//        return Pair(firsName, lastName)
        return firsName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO()  // перевод имени пользователя
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO() // Создание инициалов
    }

}