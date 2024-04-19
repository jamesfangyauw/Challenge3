package com.james.challenge3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String,
    val player: List<Player>
) : Parcelable

@Parcelize
class Player (
    val name: String
) : Parcelable
