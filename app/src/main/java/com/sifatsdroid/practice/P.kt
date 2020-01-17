package com.sifatsdroid.practice

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.durbinlabs.ducommcore.utils.C
import org.json.JSONArray


/**

 */
object P {
    private val TAG = P::class.java.simpleName

    const val DEF_USER_NAME = ""// "ContactItem Name";
    private const val DEF_FULL_NAME = DEF_USER_NAME// "Full Name";
    private const val DEF_INST = ""// "{ Set Institution }";
    private const val DEF_EMAIL = ""// "{ Set An Email }";
    private const val DEF_ADDRESS = ""// "{ Set Your Address}";
    private const val DEF_DISTRICT = ""// "{ Set Your District}";
    private const val DEF_CONTACT = ""// "{ Set A Contact No. }";
    private const val DEF_DOB = ""// "{ Set Your Birthday}";
    private const val DEF_PREFIX = ""
    const val EMPTY = "empty"

    const val DEF_MIN_KB_HEIGHT = 300

    private const val PREF_IMAGE_LOAD = "img_load_enabled"
    private const val PREF_ID = "USER_MONGO_ID"
    private const val PREF_USER_NAME = "username"
    private const val PREF_SERVER_URL = "serverUrl"
    private const val PREF_PROFILE_PIC_KEY = "profile_pic_key"
    private const val PREF_NID_PIC_KEY = "nid_pic_key"
    private const val PREF_PASSPORT_IMG_KEY = "ps_pic_key"

    private const val PREF_PP = "profile_pic_url"
    private const val PREF_FULL_NAME = "STD_NAME_FULL"
    private const val PREF_DISPLAY_NAME = "display_name"
    private const val PREF_NID_NO = "nid_no"
    private const val PREF_ADDRESS = "address_profile"


    private const val PREF_EMAIL = "EMAIL"
    private const val PREF_INST = "INSTITUTE"
    private const val PREF_DOB = "DATE_OF_BIRTH"
    private const val PREF_DEVICE_TOKEN = "device_token"  //PushY
    private const val PREF_FCM_DEVICE_TOKEN = "fcm_device_token"
    private const val PREF_SENT_FCM_DEVICE_TOKEN = "sent_fcm_device_token"
    private const val PREF_SIP_HOST_URL = "sip_server_url"
    private const val PREF_SIP_NUMBER = "sip_number"
    private const val PREF_SIP_PASSWORD = "sipPassword"
    private const val PREF_IS_APP_FG = "isAppForeground"
    private const val GOT_STICKERS = "json_array_of_got_stickers"

    private const val KEY_KB_HEIGHT = "_keyboard_height"

    private const val PREF_CONTACT_SYNC_FIRST = "contactSyncFirst"
    private const val PREF_IS_NEVER_ASK_FOR_AUTO_START = "neverAskForAutoStart"
    private const val PREF_IS_AUTO_START_ENABLED = "isAutoStartEnabled"
    private const val PREF_LAST_AUTO_START_DIALOG = "lastAutoStartDialog"

    private const val PREF_BALANCE = "accountBalance"
    private const val PREF_EXPIRY_DATE = "expiryDate"
    private const val PREF_CURRENCY = "accountCurrency"

    private const val PREF_APP_INTRO_LUNCHED_ONCE = "appIntroLunchedOnce"
    private const val PREF_MILLIS_WHEN_NOTIFICATION_STARTED = "millis_noti_started"
    private const val PREF_DURATION_WHEN_NOTIFICATION_STARTED = "duration_noti_started"
    private const val PREF_CALL_ID_WHEN_NOTIFICATION_STARTED = "call_id_noti_started"
    private const val PREF_USERNAME_WHEN_NOTIFICATION_STARTED = "username_noti_started"
    private const val PREF_SIP_IN_OR_OUT_WHEN_NOTIFICATION_STARTED = "sip_in_or_out_noti_started"
    private const val PREF_CONNECTION_STATUS_WHEN_NOTIFICATION_STARTED = "sip_connection_status"

    private const val PREF_GSM_CALL_STATE = "gsmCallState"

    private var prefs: SharedPreferences? = null
    private var prefsEditor: SharedPreferences.Editor? = null

    @SuppressLint("CommitPrefEdits")
    private fun assurePrefNotNull(context: Context) {
        if (prefs == null)
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
        if (prefsEditor == null) {
            prefsEditor = prefs!!.edit()
            prefsEditor!!.apply()
        }
    }

    @JvmStatic
    fun setData(context: Context, key: String, data: Boolean) {
        assurePrefNotNull(context)
        prefsEditor!!.putBoolean(key, data)
        prefsEditor!!.commit()
    }

    @JvmStatic
    fun setData(context: Context, key: String, data: String) {
        assurePrefNotNull(context)
        prefsEditor!!.putString(key, data)
        prefsEditor!!.commit()
    }

    @JvmStatic
    fun setData(context: Context, key: String, data: Int) {
        assurePrefNotNull(context)
        prefsEditor!!.putInt(key, data)
        prefsEditor!!.commit()
    }

    @JvmStatic
    fun setData(context: Context, key: String, data: Long) {
        assurePrefNotNull(context)
        prefsEditor!!.putLong(key, data)
        prefsEditor!!.commit()
    }

    @JvmStatic
    fun getInt(context: Context, key: String, defVal: Int): Int {
        assurePrefNotNull(context)
        return prefs!!.getInt(key, defVal)
    }

    @JvmStatic
    fun getLong(context: Context, key: String, defVal: Long): Long {
        assurePrefNotNull(context)
        return prefs!!.getLong(key, defVal)
    }

    @JvmStatic
    fun getFloat(context: Context, key: String, defVal: Float): Float {
        assurePrefNotNull(context)
        return prefs!!.getFloat(key, defVal)
    }

    @JvmStatic
    fun getBoolean(context: Context, key: String, defVal: Boolean): Boolean {
        assurePrefNotNull(context)
        return prefs!!.getBoolean(key, defVal)
    }

    @JvmStatic
    fun getString(context: Context, key: String, defVal: String): String? {
        assurePrefNotNull(context)
        return prefs?.getString(key, defVal)
    }

    /**
     * @param imageSettings <br></br>
     * 0: On,
     * 1: Over WiFi Only
     * 2: Off
     */
    @JvmStatic
    fun setImageSettings(context: Context, imageSettings: Int) {
        setData(context, PREF_IMAGE_LOAD, imageSettings)
    }
    //endregion

    @JvmStatic
    fun isImageLoadingAllowed(context: Context): Boolean {
        val i = getImageSettings(context)
        return i != C.OFF_SETTINGS && (i != C.WIFI_ONLY_SETTINGS || U.isWifiConnected(context))
    }

    @JvmStatic
    fun getImageSettings(context: Context): Int = getInt(context, PREF_IMAGE_LOAD, C.ON_SETTINGS)

    @JvmStatic
    fun setUserName(context: Context, newName: String) {
        setData(context, PREF_USER_NAME, newName)
    }

    @JvmStatic
    fun setServerUrl(context: Context, newServer: String) {
        setData(context, PREF_SERVER_URL, newServer)
    }

    @JvmStatic
    fun setFullName(context: Context, newFullName: String) {
        setData(context, PREF_FULL_NAME, newFullName)
    }

    @JvmStatic
    fun setDisplayName(context: Context, newFullName: String) {
        setData(context, PREF_DISPLAY_NAME, newFullName)
    }

    @JvmStatic
    fun setAddress(context: Context, address: String) {
        setData(context, PREF_ADDRESS, address)
    }
    @JvmStatic
    fun setNidNo(context: Context, newFullName: String) {
        setData(context, PREF_NID_NO, newFullName)
    }
    //PushY Token
    @JvmStatic
    fun setDeviceToken(context: Context, token: String) {
        setData(context, PREF_DEVICE_TOKEN, token)
    }

    //PushY Token
    @JvmStatic
    fun getDeviceToken(context: Context) = getString(context, PREF_DEVICE_TOKEN, EMPTY)

    @JvmStatic
    fun setFCMDeviceToken(context: Context, token: String) {
        setData(context, PREF_FCM_DEVICE_TOKEN, token)
    }

    @JvmStatic
    fun getFCMDeviceToken(context: Context) = getString(context, PREF_FCM_DEVICE_TOKEN, EMPTY)

    @JvmStatic
    fun setSentFCMDeviceToken(context: Context, token: String) {
        setData(context, PREF_SENT_FCM_DEVICE_TOKEN, token)
    }

    @JvmStatic
    fun getSentFCMDeviceToken(context: Context) = getString(context, PREF_SENT_FCM_DEVICE_TOKEN, EMPTY)


    @JvmStatic
    fun getUserDob(context: Context): String {
        var dob = getString(context, PREF_DOB, "")
        if (dob == null || dob.trim { it <= ' ' }.length < 4)
            dob = ""

        if(dob.length>11) dob=dob.substring(0,10)
        return dob
    }

    @JvmStatic
    fun getUserName(context: Context): String {
        var userName = getString(context, PREF_USER_NAME, DEF_USER_NAME)
        if (userName == null || userName.trim { it <= ' ' }.length < 4)
            userName = DEF_USER_NAME
        return userName
    }

    @JvmStatic
    fun getServerUrl(context: Context): String {
        var serverUrl = getString(context, PREF_SERVER_URL, C.SERVER_URL)
        if (serverUrl == null || serverUrl.trim { it <= ' ' }.length < 4)
            serverUrl = DEF_USER_NAME
        return serverUrl
    }

    @JvmStatic
    fun setUserDob(context: Context, dob: String) {
        setData(context, PREF_DOB, dob)
    }

    @JvmStatic
    fun getUserEmail(context: Context): String {
        var email = getString(context, PREF_EMAIL, DEF_EMAIL)
        if (U.isEmpty(email!!.trim { it <= ' ' }))
            email = DEF_EMAIL
        return email
    }

    @JvmStatic
    fun getFullName(context: Context): String {
        var fullName = getString(context, PREF_FULL_NAME, "")
        if (U.isEmpty(fullName!!.trim { it <= ' ' }))
            fullName = DEF_USER_NAME
        return fullName
    }


    @JvmStatic
    fun getDisplayName(context: Context): String {
        var value = getString(context, PREF_DISPLAY_NAME, "")
        if (U.isEmpty(value!!.trim { it <= ' ' }))
            value = DEF_USER_NAME
        return value
    }

    @JvmStatic
    fun getNidNo(context: Context): String {
        var value = getString(context, PREF_NID_NO, getUserName(context))
        if (U.isEmpty(value!!.trim { it <= ' ' }))
            value = ""
        return value
    }


    @JvmStatic
    fun getAddress(context: Context): String {
        var address = getString(context, PREF_ADDRESS, "")
        if (U.isEmpty(address!!.trim { it <= ' ' }))
            address = ""
        return address
    }

    @JvmStatic
    fun getNidPicKey(context: Context): String {
        val url = getString(context, PREF_NID_PIC_KEY, "")
        return url ?: ""
        /*if (U.notEmpty(url) && !U.isValidUrl(url))
            url = C.DEF_BUCKET_HEAD + url
        return url ?: ""*/
    }

    @JvmStatic
    fun setNidPicKey(context: Context, url: String) {
        //val picUrl = if (U.isValidUrl(url)) url else U.concatForUrl(C.DEF_BUCKET_HEAD, url)
        setData(context, PREF_NID_PIC_KEY, url)
    }

    @JvmStatic
    fun getPassportSizePicKey(context: Context): String {
        val url = getString(context, PREF_PASSPORT_IMG_KEY, "")
        return url ?: ""

        /*if (U.notEmpty(url) && !U.isValidUrl(url))
            url = C.DEF_BUCKET_HEAD + url
        return url ?: ""*/
    }

    @JvmStatic
    fun setPassportSizePicKey(context: Context, url: String) {
        //val picUrl = if (U.isValidUrl(url)) url else U.concatForUrl(C.DEF_BUCKET_HEAD, url)
        setData(context, PREF_PASSPORT_IMG_KEY, url)
    }

    @JvmStatic
    fun getProfilePicKey(context: Context): String {
        val url = getString(context, PREF_PROFILE_PIC_KEY, "")
        return url ?: ""

        /*if (U.notEmpty(url) && !U.isValidUrl(url))
            url = C.DEF_BUCKET_HEAD + url
        return url ?: ""*/
    }

    @JvmStatic
    fun setProfilePicKey(context: Context, url: String) {
        //val picUrl = if (U.isValidUrl(url)) url else U.concatForUrl(C.DEF_BUCKET_HEAD, url)
        setData(context, PREF_PROFILE_PIC_KEY, url)
    }

    @JvmStatic
    fun getProfilePic(context: Context): String {
        val url = getString(context, PREF_PROFILE_PIC_KEY, "")
        return url ?: ""

        /*if (U.notEmpty(url) && !U.isValidUrl(url))
            url = C.DEF_BUCKET_HEAD + url
        return url ?: ""*/
    }

    @JvmStatic
    fun setProfilePic(context: Context, url: String) {
        //val picUrl = if (U.isValidUrl(url)) url else U.concatForUrl(C.DEF_BUCKET_HEAD, url)
        setData(context, PREF_PROFILE_PIC_KEY, url)
    }


    @JvmStatic
    fun setSipHostUrl(context: Context, url: String) {
        setData(context, PREF_SIP_HOST_URL, url)
    }

    @JvmStatic
    fun getSipHostUrl(context: Context): String {
        var url = getString(context, PREF_SIP_HOST_URL, C.NULL_STR)
        return url ?: C.NULL_STR
    }

    @JvmStatic
    fun setSipNumber(context: Context, sipNumber: String) {
        setData(context, PREF_SIP_NUMBER, sipNumber)
    }

    @JvmStatic
    fun getSipNumber(context: Context): String {
        var sipNumber = getString(context, PREF_SIP_NUMBER, C.NULL_STR)
        return sipNumber ?: C.NULL_STR
    }

    @JvmStatic
    fun setSipPassword(context: Context, sipPassword: String) {
        setData(context, PREF_SIP_PASSWORD, sipPassword)
    }

    @JvmStatic
    fun setIsAppForegroundPref(context: Context, isAppFg: Boolean) {
        setData(context, PREF_IS_APP_FG, isAppFg)
    }


    @JvmStatic
    fun getIsAppForegroundPref(context: Context): Boolean{

        var isFg = getBoolean(context, PREF_IS_APP_FG, false)
        return isFg
    }
    @JvmStatic
    fun getSipPassword(context: Context): String {
        var sipPassword = getString(context, PREF_SIP_PASSWORD, C.NULL_STR)
        return sipPassword ?: C.NULL_STR
    }

    @JvmStatic
    fun getAddedStickerPacks(context: Context): JSONArray {
        assurePrefNotNull(context)
        return try {
            JSONArray(getString(context, GOT_STICKERS, "[]")
                    ?: "[]")
        } catch (e: Exception) {
            JSONArray()
        }
    }

    @JvmStatic
    fun addStickerPack(context: Context, packId: String) {
        val ja = getAddedStickerPacks(context)
        val l = ja.length()
        for (i in 0 until l)
            if (ja.get(i).toString() == packId)
                return
        ja.put(packId)
        prefsEditor!!.putString(GOT_STICKERS, ja.toString())
        prefsEditor!!.commit()
    }

    @JvmStatic
    fun getIsContactSyncFirstTime(context: Context): String {
        var isContactSyncFirstTime = getString(context, PREF_CONTACT_SYNC_FIRST, C.NO)

        return isContactSyncFirstTime ?: C.NO
    }

    @JvmStatic
    fun setIsContactSyncFirstTime(context: Context, contactSync: String) {
        setData(context, PREF_CONTACT_SYNC_FIRST, contactSync)
    }

    @JvmStatic
    fun getIsNeverAskForAutoStart(context: Context) =
            getBoolean(context, PREF_IS_NEVER_ASK_FOR_AUTO_START, false)

    @JvmStatic
    fun setNeverAskForAutoStart(context: Context, contactSync: Boolean) =
            setData(context, PREF_IS_NEVER_ASK_FOR_AUTO_START, contactSync)

    @JvmStatic
    fun getIsAutoStartEnabled(context: Context) =
            getBoolean(context, PREF_IS_AUTO_START_ENABLED, false)

    @JvmStatic
    fun setIsAutoStartEnabled(context: Context, contactSync: Boolean) =
            setData(context, PREF_IS_AUTO_START_ENABLED, contactSync)

    @JvmStatic
    fun getWhenLastAutoStartWindowOpened(context: Context): Long {
        return getLong(context, PREF_LAST_AUTO_START_DIALOG, -1L)
    }

    @JvmStatic
    fun setWhenLastAutoStartWindowOpened(context: Context, lastDialogShownTime: Long) {
        setData(context, PREF_LAST_AUTO_START_DIALOG, lastDialogShownTime)
    }

    //Get Camera Resoulation From Setting Pref
    @JvmStatic
    fun getCameraResolutionSettingsPref(context: Context): String {

        //context.getString(R.string.key_upload_quality)
        val videoQualityPrefKey =context.getString(R.string.key_upload_quality) //"key_upload_quality"
        val cameraResolutionPrefStr = PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(videoQualityPrefKey, C.NULL_STR)

        return cameraResolutionPrefStr!!
    }

    @JvmStatic
    fun getRingtoneSettingsPref(context: Context): String{
        val ringtonePrefKey =context.getString(R.string.key_ringtone)
        val ringtonePrefStr = PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(ringtonePrefKey, C.NULL_STR)
        return ringtonePrefStr!!
    }


    @JvmStatic
    fun getBackgroundSipEnabledPref(context: Context): Boolean{

        val backgroundSipPrefKey = context.getString(R.string.key_sip)

        return PreferenceManager
            .getDefaultSharedPreferences(context)
            .getBoolean(backgroundSipPrefKey, false)
    }



    //Get Camera Resoulation From Setting Pref
    @JvmStatic
    fun getAllNotificationMuteSettingsPref(context: Context): Boolean {

        val allNotificationSettingsKey = "key_notifications" // TODO need get string string.xml
        var allNotificaitonSetingsPrefBoolean = PreferenceManager
                .getDefaultSharedPreferences(context)
                .getBoolean(allNotificationSettingsKey, true)

        return allNotificaitonSetingsPrefBoolean
    }

    //Get Camera Resoulation From Setting Pref
    @JvmStatic
    fun setAllNotificationMuteSettingsPref(context: Context, isNotificationEnabled: Boolean) {

        val allNotificationSettingsKey = "key_notifications" // TODO need get string string.xml
        PreferenceManager
                .getDefaultSharedPreferences(context)
                .edit().putBoolean(allNotificationSettingsKey, isNotificationEnabled)
                .apply()
        //.getBoolean(allNotificationSettingsKey, true)

    }


    @JvmStatic
    fun setBalance(context: Context, balance: String) {
        setData(context, PREF_BALANCE, balance)
    }

    @JvmStatic
    fun getBalance(context: Context): String {
        return getString(context, PREF_BALANCE, C.DEFAULT_BALANCE)!!
    }

    @JvmStatic
    fun setExpiryDate(context: Context, exp: String) {
        setData(context, PREF_EXPIRY_DATE, exp)
    }

    @JvmStatic
    fun getExpiryDateFull(context: Context): String {
        return getString(context, PREF_EXPIRY_DATE, C.DEFAULT_EXPIRYDATE)!!
    }

    @JvmStatic
    fun getExpiryDate(context: Context): String {

        var expDate = getString(context, PREF_EXPIRY_DATE, C.DEFAULT_EXPIRYDATE)
        if (expDate == null || expDate.trim { it <= ' ' }.length < 4)
            expDate = ""

        if(expDate.length>11) expDate=expDate.substring(0,10)
        return expDate
    }


    @JvmStatic
    fun setCurrency(context: Context, currency: String) {
        setData(context, PREF_CURRENCY, currency)
    }

    @JvmStatic
    fun getCurrency(context: Context): String {
        return getString(context, PREF_CURRENCY, C.DEFAULT_CURRENCY)!!
    }

    @JvmStatic
    fun getIsAppIntroLuchedOnce(context: Context) =
            getBoolean(context, PREF_APP_INTRO_LUNCHED_ONCE, false)

    @JvmStatic
    fun setIsAppIntroLunchedOnce(context: Context, isLunched: Boolean) =
            setData(context, PREF_APP_INTRO_LUNCHED_ONCE, isLunched)

    @JvmStatic
    fun setGsmCallState(context: Context, gsmCallState: String) {
        setData(context, PREF_GSM_CALL_STATE, gsmCallState)
    }

    @JvmStatic
    fun getGsmCallState(context: Context): String {
        var gsmCallState = getString(context, PREF_GSM_CALL_STATE, C.GsmCallState.GSM_IDLE)
        return gsmCallState ?: C.GsmCallState.GSM_IDLE
    }

    /**call duration in notification handling*/
    @JvmStatic
    fun setSipInOrOutWhenNotificationStarted(context: Context, callId: String) {
        setData(context, PREF_SIP_IN_OR_OUT_WHEN_NOTIFICATION_STARTED, callId)

    }

    fun getSipInOrOutWhenNotificationStarted(context: Context) :String {
        var sipInOrOut = getString(context, PREF_SIP_IN_OR_OUT_WHEN_NOTIFICATION_STARTED, C.NULL_STR)
        return sipInOrOut ?: C.NULL_STR
    }

    @JvmStatic
    fun setSipConnectionStatusWhenNotificationStarted(context: Context, connectionStatus: String) {
        setData(context, PREF_CONNECTION_STATUS_WHEN_NOTIFICATION_STARTED, connectionStatus)

    }
    @JvmStatic
    fun getSipConnectionStatusWhenNotificationStarted(context: Context) :String {
        var connectionStatus = getString(context, PREF_CONNECTION_STATUS_WHEN_NOTIFICATION_STARTED, C.NULL_STR)
        return connectionStatus ?: C.NULL_STR
    }

    @JvmStatic
    fun setCallIdWhenNotificationStarted(context: Context, callId: String) {
        setData(context, PREF_CALL_ID_WHEN_NOTIFICATION_STARTED, callId)
    }
    @JvmStatic
    fun getCallIdWhenNotificationStarted(context: Context) :String {
        var notificationWhenStarted = getString(context, PREF_CALL_ID_WHEN_NOTIFICATION_STARTED, C.NULL_STR)
        return notificationWhenStarted ?: C.NULL_STR
    }
    @JvmStatic
    fun setUsernameWhenNotificationStarted(context: Context, username: String) {
        setData(context, PREF_USERNAME_WHEN_NOTIFICATION_STARTED, username)
    }
    @JvmStatic
    fun getUsernameWhenNotificationStarted(context: Context) :String {
        var username = getString(context, PREF_USERNAME_WHEN_NOTIFICATION_STARTED, C.NULL_STR)
        return username ?: C.NULL_STR
    }

    @JvmStatic
    fun setSystmCurrWhenNotificationStarted(context: Context, millis: Long) {
        setData(context, PREF_MILLIS_WHEN_NOTIFICATION_STARTED, millis)
    }
    @JvmStatic
    fun getSystmCurrWhenNotificationStarted(context: Context, defVal: Long) =
        getLong(context, PREF_MILLIS_WHEN_NOTIFICATION_STARTED, defVal)

    @JvmStatic
    fun setDurationWhenNotificationStarted(context: Context, dur: Long) { //Second value
        setData(context, PREF_DURATION_WHEN_NOTIFICATION_STARTED, dur)
    }
    @JvmStatic
    fun getDurationWhenNotificationStarted(context: Context, defVal: Long) =
            getLong(context, PREF_DURATION_WHEN_NOTIFICATION_STARTED, defVal)


    @JvmStatic
    fun signOut(context: Context) {
        assurePrefNotNull(context)
        prefsEditor!!.remove(PREF_ID)
        prefsEditor!!.remove(PREF_USER_NAME)

        prefsEditor!!.remove(PREF_SERVER_URL)
        prefsEditor!!.remove(PREF_IMAGE_LOAD)
        prefsEditor!!.remove(PREF_PROFILE_PIC_KEY)

        prefsEditor!!.remove(PREF_FULL_NAME)
        prefsEditor!!.remove(PREF_EMAIL)
        prefsEditor!!.remove(PREF_INST)
        prefsEditor!!.remove(PREF_DOB)
        prefsEditor!!.remove(GOT_STICKERS)
        //Device token not delete after signOut
        prefsEditor!!.remove(PREF_DEVICE_TOKEN)
        prefsEditor!!.remove(PREF_FCM_DEVICE_TOKEN)
        prefsEditor!!.remove(PREF_SENT_FCM_DEVICE_TOKEN)
        prefsEditor!!.remove(PREF_SIP_HOST_URL)
        prefsEditor!!.remove(PREF_SIP_NUMBER)
        prefsEditor!!.remove(PREF_SIP_PASSWORD)
        prefsEditor!!.remove(KEY_KB_HEIGHT)
        prefsEditor!!.remove(PREF_CONTACT_SYNC_FIRST)
        prefsEditor!!.remove(PREF_IS_NEVER_ASK_FOR_AUTO_START)
        prefsEditor!!.remove(PREF_IS_AUTO_START_ENABLED)
        prefsEditor!!.remove(PREF_LAST_AUTO_START_DIALOG)
        prefsEditor!!.remove(PREF_BALANCE)
        prefsEditor!!.remove(PREF_CURRENCY)
        prefsEditor!!.remove(PREF_APP_INTRO_LUNCHED_ONCE)
        prefsEditor!!.apply()
        prefsEditor!!.remove(PREF_CALL_ID_WHEN_NOTIFICATION_STARTED)
        prefsEditor!!.remove(PREF_USERNAME_WHEN_NOTIFICATION_STARTED)
        prefsEditor!!.remove(PREF_SIP_IN_OR_OUT_WHEN_NOTIFICATION_STARTED)

        Lg.d(TAG, "Signed out")
    }


    // region non-volatile data to sign-out

    @JvmStatic
    fun setKeyboardHeight(context: Context, height: Int) {
        if (height < DEF_MIN_KB_HEIGHT) return
        setData(context, KEY_KB_HEIGHT, height)
    }

    @JvmStatic
    @JvmOverloads
    fun getKeyboardHeight(context: Context, defVal: Int = DEF_MIN_KB_HEIGHT) =
            getInt(context, KEY_KB_HEIGHT, defVal)

    // endregion
}
