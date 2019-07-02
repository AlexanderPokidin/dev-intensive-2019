package ru.skillbranch.devintensive.utils

object Utils {
    //    TODO: Fix me!!!
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        return if (fullName.isNullOrEmpty() || fullName.equals(" ")) {
            val firsName = null
            val lastName = null
            firsName to lastName
        } else {
            val firsName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)
            firsName to lastName
        }

//        val parts: List<String>? = fullName?.split(" ")

//        val firsName = parts?.getOrNull(0)
//        val lastName = parts?.getOrNull(1)
//        return Pair(firsName, lastName)
//        return firsName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO()  // перевод имени пользователя
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial: String? =
            (if (firstName.isNullOrBlank()) {
                null
            } else {
                firstName[0].toString().toUpperCase()
            })

        val lastInitial: String? =
            (if (lastName.isNullOrBlank()) {
                null
            } else {
                lastName[0].toString().toUpperCase()
            })

        return when {
            firstInitial.isNullOrBlank() -> null
            lastInitial.isNullOrBlank() -> firstInitial
            else -> firstInitial.plus(lastInitial)
        }
    }

}