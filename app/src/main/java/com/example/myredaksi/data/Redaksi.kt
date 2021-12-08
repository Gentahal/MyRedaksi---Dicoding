package com.example.myredaksi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Redaksi(
    var nama :String?,
    var detail : String?,
    var sumber : String?,
    var smbr : String?,
    var isi : String?,
    var gambar : Int
):Parcelable
