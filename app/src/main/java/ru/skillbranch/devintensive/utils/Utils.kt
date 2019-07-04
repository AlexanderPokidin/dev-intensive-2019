package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        return if (fullName.isNullOrEmpty() || fullName == " ") {
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
        var result = ""
        val translationMap: Map<String, String> = hashMapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            "А" to "A",
            "Б" to "B",
            "В" to "V",
            "Г" to "G",
            "Д" to "D",
            "Е" to "E",
            "Ё" to "E",
            "Ж" to "Zh",
            "З" to "Z",
            "И" to "I",
            "Й" to "I",
            "К" to "K",
            "Л" to "L",
            "М" to "M",
            "Н" to "N",
            "О" to "O",
            "П" to "P",
            "Р" to "R",
            "С" to "S",
            "Т" to "T",
            "У" to "U",
            "Ф" to "F",
            "Х" to "H",
            "Ц" to "C",
            "Ч" to "Ch",
            "Ш" to "Sh",
            "Щ" to "Sh'",
            "Ъ" to "",
            "Ы" to "I",
            "Ь" to "",
            "Э" to "E",
            "Ю" to "Yu",
            "Я" to "Ya"
        )

        for (i in payload) {
            when {
                translationMap.containsKey(i.toString()) -> result += translationMap[i.toString()]
                i.toString() == " " -> result += divider
                else -> result += i
            }
        }
        return result
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
            firstInitial.isNullOrBlank() -> {
                lastInitial
            }
            lastInitial.isNullOrBlank() -> {
                firstInitial
            }
            else -> firstInitial.plus(lastInitial)
        }
    }
}