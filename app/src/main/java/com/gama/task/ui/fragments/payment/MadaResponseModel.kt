package com.surepay.integratemada

import com.google.gson.annotations.SerializedName

data class MadaResponseModel (
    @SerializedName("MID") val mID : String,
    @SerializedName("BANK_ID") val bANK_ID : String,
    @SerializedName("MER_ADDRS_A") val mER_ADDRS_A : String,
    @SerializedName("AID") val aID : String,
    @SerializedName("PAN") val pAN : String,
    @SerializedName("LEAPICCTagsInfo") val lEAPICCTagsInfo : String,
    @SerializedName("SCHEME_ID") val sCHEME_ID : String,
    @SerializedName("otherAMOUNT") val otherAMOUNT : String,
    @SerializedName("ID") val iD : String,
    @SerializedName("TX_RESPONSECODE") val tX_RESPONSECODE : String,
    @SerializedName("SMS_MSG") val sMS_MSG : String,
    @SerializedName("MOBILE_NUMB") val mOBILE_NUMB : String,
    @SerializedName("RRN") val rRN : String,
    @SerializedName("MER_PHONE") val mER_PHONE : String,
    @SerializedName("TX_RSLT") val tX_RSLT : String,
    @SerializedName("SCHEME_N_A") val sCHEME_N_A : String,
    @SerializedName("OFFLINE_TRX") val oFFLINE_TRX : String,
    @SerializedName("TRANS_DT_ST") val tRANS_DT_ST : String,
    @SerializedName("AQU_ID") val aQU_ID : String,
    @SerializedName("SCHEME_N_E") val sCHEME_N_E : String,
    @SerializedName("TID") val tID : String,
    @SerializedName("AMOUNT") val aMOUNT : String,
    @SerializedName("TRANS_DT_END") val tRANS_DT_END : String,
    @SerializedName("MER_NAME_E") val mER_NAME_E : String,
    @SerializedName("APP_VER") val aPP_VER : String,
    @SerializedName("STAN") val sTAN : String,
    @SerializedName("MER_NAME_A") val mER_NAME_A : String,
    @SerializedName("AUTH") val aUTH : String,
    @SerializedName("CVM_MSG") val cVM_MSG : String,
    @SerializedName("AdsMessage") val adsMessage : String,
    @SerializedName("ClientRef") val clientRef : String,
    @SerializedName("CRD_HLDR_N") val cRD_HLDR_N : String,
    @SerializedName("EXP_DATE") val eXP_DATE : String,
    @SerializedName("TRANS_TYPE") val tRANS_TYPE : String,
    @SerializedName("MadaSpec") val madaSpec : String,
    @SerializedName("TX_RESP_MSG") val tX_RESP_MSG : String,
    @SerializedName("MER_ADDRS_E") val mER_ADDRS_E : String
)