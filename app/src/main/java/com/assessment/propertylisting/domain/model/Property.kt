package com.assessment.propertylisting.domain.model

data class Property(
    val id: String,
    val propertyName: String,
    val propertyType: PropertyType,
    val location: String,
    val price: Double,
    val area: Int,
    val configuration: String,
    val status: PropertyStatus,
    val description: String,
    val imageUrl: String,
    val ownerId: String,
    val ownerName: String
) {
    /**
     * Formats price into readable Indian numbering system (e.g. ₹1.25 Cr or ₹85 Lac).
     */
    val formattedPrice: String
        get() = when {
            price >= 10000000 -> {
                val cr = price / 10000000.0
                if (cr == cr.toLong().toDouble()) {
                    "₹${cr.toLong()} Cr"
                } else {
                    "₹${String.format(java.util.Locale.US, "%.2f", cr)} Cr"
                }
            }
            price >= 100000 -> {
                val lac = price / 100000.0
                if (lac == lac.toLong().toDouble()) {
                    "₹${lac.toLong()} Lac"
                } else {
                    "₹${String.format(java.util.Locale.US, "%.2f", lac)} Lac"
                }
            }
            else -> "₹${price.toLong()}"
        }

    val formattedArea: String
        get() = "$area sq.ft"
}
