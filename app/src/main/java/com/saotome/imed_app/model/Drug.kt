package com.saotome.imed_app.model

import java.time.LocalDateTime

class Drug (
    val id: Int = 0,
    val name : String,
    val dosage : String,
    val startTime : String,
    val frequency : String
) {

    val creationTimestamp : LocalDateTime

    init {
        creationTimestamp = LocalDateTime.now()
    }
}