package com.durbinlabs.ducommcore.utils

import android.os.Environment
import com.sifatsdroid.practice.P
import java.io.File



object C {
    const val IS_APP_DEBUGGABLE = true
    const val GET_SIP_CREDENTIAL = false
    const val DUMMY_BALANCE_ACTIVITY = true
    const val VERIFICATION_TYPE = AUTH.VERIFY_GOOGLE_SMS //VERIFY_FB_SMS

    @JvmField
    var SERVER_URL: String = "http://link3.oii.chat" // "http://ducomm.oii.chat"
    const val SIP_HOST_ADDRESS = "dialswitch.link3.net:5160"
    const val APP_NAME = "Ducomm"
    const val PACKAGE_NAME = "com.durbinlabs.ducomm"
    const val COLOR_THEME_HEX = "0x044fa2"

    const val ACCOUNT_TYPE = PACKAGE_NAME
    const val ACCOUNT_TOKEN = "836"
    const val ACCOUNT_NAME = APP_NAME
    const val AUTH_TOKEN_TYPE_FULL_ACCESS = "Full access"

    const val MIRROR_LOCAL_STREAM = true

    const val PLAY_STORE = "https://play.google.com/store/apps/details?id=com.ducomm"

    private const val BUCKET_NAME = "ducomm"
    const val DEF_BUCKET_HEAD = "https://$BUCKET_NAME.s3.amazonaws.com"
    const val DEF_PROFILE_HTTP = "https://"

    const val DEF_LATITUDE = 23.83743
    const val DEF_LONGITUDE = 90.3650374

    const val IS_COOKIE_ALREADY_VERIFIED = "navigation_init"

    //TODO USERS_STR should go to thread property
    const val USERS_STR = "users_str"
    const val IS_USER = "_is_app_user"
    const val PHONEBOOK_NAME = "phonebook_name"

    const val NOTIFICATION_ID = "ducomm_notification"
    const val NOTIFICATION_TYPE = "NotificationType"
    const val MESSAGE_NOTIFICATION = "messageNotification"

    const val isHardwareCodecEnabled = false

    /**Max permitted file size is 1 MB, expressed in bytes(1024*1024) in this constant.*/
    const val MAX_FILE_SIZE = 10 * 1024 * 1024L
    const val GROUP_CALL_WAIT_TIME = 60 * 1000 // 1 minute wait for close group call.
    const val STICKER_CODE = 129

    const val NET_TIMEOUT_READ = 40L
    const val NET_TIMEOUT_WRITE = 60L
    const val NET_TIMEOUT_CONNECT = 30L

    @JvmField
    val APP_DIRECTORY = File(Environment.getExternalStorageDirectory(), APP_NAME)
    const val DEF_NAME_IMAGE_TAKEN = "${APP_NAME}_image.png"
    const val APP_TEMP_IMAGE_NAME = "${APP_NAME}_capture.png"
    const val DEF_NAME_TEMP_FILE = "${APP_NAME}_file"

    const val OFF_SETTINGS = 0
    const val ON_SETTINGS = 1
    const val WIFI_ONLY_SETTINGS = 2

    @JvmField
    val NUMBERS_BN = arrayOf("০", "১", "২", "৩", "৪", "৫", "৬", "৭", "৮", "৯")

    @JvmField
    val RESERVED_NAMES = arrayOf("durbin", "bangladesh", "bangabandhu", APP_NAME)

    const val CONTACTS_EACH_CHUNK_SIZE = 100
    const val DURBIN_LABS_URL = "https://durbinlabs.com/"
    const val PRIVACY_POLICY = "https://s3-ap-southeast-1.amazonaws.com/ducomm/ducomm/privacy.html"
    const val TERMS_AND_CONDITIONS = "https://s3-ap-southeast-1.amazonaws.com/ducomm/ducomm/terms.html"
    const val FAQ_URL = "https://s3-ap-southeast-1.amazonaws.com/ducomm/ducomm/faq.html"
    const val MIN_PRIORITY = -1
    const val NULL_STR = "null"
    const val NOW = "now"
    const val ZERO_SEC = "In 0 seconds"
    const val EMPTY = "empty"
    const val YES = "yes"
    const val NO = "no"
    const val COLLECTION_USER = "users"

    const val KEY_NAME = "name"
    const val KEY_MSG = "msg"
    const val KEY_FILE_KEY = "key"
    const val KEY_MESSAGE = "message"
    const val KEY_CONTACT = "_contact"

    @JvmField
    val IMAGE_MIMES = arrayOf("jpg", "jpeg", "png", "ico")
    @JvmField
    val GENDERS = arrayOf("Male", "Female", "Hidden")

    const val KEY_LOADER = "loader"
    const val API_ERROR_MESSAGE = "Network Error! Try again later."

    const val COLLECTION_CALLS = "Calls"
    const val COLLECTION_CHAT_MESSAGE = "ChatMessage"
    const val TYPE_VIDEO = "video"
    const val TYPE_AUDIO = "audio"

    const val KEY_PHONE = "phone_number"
    const val KEY_PSW = "password"
    const val DEF_STICKER_URL = "https://ducomm.s3.amazonaws.com/stickers/fluffy_pack/icon.png"
    const val DEF_PHONE_REGION = "BD"

    const val MSG_BETA_FEATURE = "Feature is under-construction in this beta-                                   .\nPlease wait for another release."

    const val DEFAULT_BALANCE = "0.00"
    const val DEFAULT_EXPIRYDATE = "Not found"
    const val DEFAULT_CURRENCY = "$ "

    object KEYS {
        const val DATA = "data"
        const val URL = "_url"
        const val STATUS = "status"
        const val MSG = "message"
        const val SUCCESS = "success"
        const val REGISTERED_CONTACTS = "registeredContatcs"

        // Esp. file related keys
        const val NAME = "name"
        const val MIME = "mimeType"
        const val KEY = "key"
        const val SIZE = "size"
        const val EVENT = "event"
        const val ID = "id"

        const val FCM = "FCM"
        const val PUSHY = "PUSHY"
        const val TITLE = "title"

        const val DIALOG_DELAY = 500
        const val PING_TIMER_INTERVAL = 40 * 1000 //15*60*1000
        const val CALL_CLOSE_INTERVAL = 60//seconds

        const val REGISTERED = "registered"

        const val USER = "_user_item"
        const val OII_USER = "_oii_user_item"

        const val WhichActivity = "WhichActivity"
        const val NavigationActivity = "NavigationActivity"
        const val DialActivity = "DialActivity"
    }

    object CONTACT_SENT {
        const val CONTACT_SEND_TO_SERVER = "contact_send_to_server"
        const val CONTACT_IGNORE = "contact_sent_ignore"
        const val CONTACT_SENT = "contact_sent"
        const val CONTACT_NOT_SENT = "contact_not_sent"

        const val CONTACT_READ = "read_contact"
        const val CONTACT_MATCHING = "contact_matching"

        const val CONTACT_SENT_TASK_DONE = "contact_sent_task_done"
        const val CONTACT_SENT_PROGRESS_UPDATE = "contact_sent_progress_update"
        const val MAX_TRY = 3
    }

    object AUTH {
        const val LOGGED_IN = "loggedIn"
        const val FIRST_LOGIN = "firstLogin"
        const val VERIFY_GOOGLE_SMS = "googleSms"
        const val VERIFY_FB_SMS = "fbSms"
    }

    object PROFILE {

        const val PROPIC = "proPicLarge"
        const val PROPIC_SMALL = "proPicSmall"
        const val USERNAME = "username"
        const val NAME = "name"
        const val DOB = "dateOfBirth"
        const val ADDRESS = "address"
        const val NID_NO = "nid"
        const val NID_PIC = "nidPhoto"
        const val PASSPORT_PIC = "photo"
        const val SIP_DATA = "sipData"
        const val BALANCE = "balance"
        const val EXPIRY_DATE = "expiry"
    }

    object HTTP {
        const val OK = 200
        const val OK_MAX = 299
        const val INVALID = 400
        const val  UNAUTHORIZED = 401
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val TIMEOUT = 408
        const val INVALID_MAX = 499
        const val ERROR = 500
        const val ERROR_MAX = 599
        const val GATEWAY_TIMEOUT = 504
    }

    object NOTIFY {
        const val MESSAGE = 2
        const val INFO = 1
        const val WARNING = 0
        const val ERROR = -1
    }

    enum class EventType {

        BACKGROUND_SIP_SERVICE_ENABLED,
        NET_CONNECTION_UPDATED,

        ON_MESSAGE_RECEIVED_MESSAGE_THREAD,
        ON_MSG_RECEIVED_GROUP_THREAD,
        ON_RECONNECT,
        ON_SEND,

        ON_MESSAGE_READ,
        ON_LOADING,
        ON_NOTIFY_ITEM_CHANGE,

        ON_RESPONSE,
        ON_ERROR,
        REMOVE_ACTIVE_CALL_BAR,
        SHOW_ACTIVE_CALL_BAR,
        ON_CLEAR_CACHE,
        //
        CLOSE_INCOMING_ACTIVITY,
        CLOSE_NAVIGATION_ACTIVITY,
        API_REQUEST,
        REFRESH_AFTER_UPDATE_OII_USER, // PRESENCE SERVICE
        UPDATE_USER_CACHE,
        ONLINE_STATUS,
        //ChatActivity
        OPEN_THREAD_MSG_RECEIVED_TONE
    }

    enum class SipEventType {
        //Dial Activity Event
        REG_STATE,
        INCOMING_CALL,
        OUTGOING_INIT,
        OUTGOING_PROGRESS,
        OUTGOING_EARLYMEDIA,
        CALL_CONNECTED,
        STREAMS_RUNNING,
        CALL_RELEASED,
        CALL_END,
        CALL_DETAILS,
        CLOSE_DIAL_ACTIVITY,
        ERROR
    }

    object ChatActivityKey {
        const val THREAD_TITLE = "threadTitle"
        const val THREAD_SUBTITLE = "threadSubtitle"
        const val OPEN_CHAT_ACTIVITY_FROM_PUSH = "openChatActivityFromPush"

        const val KB_MIN_HEIGHT = P.DEF_MIN_KB_HEIGHT

        const val FILE_CODE = 10
        const val PERM_READ_FILE = 11
        const val MSG_PERM_STORAGE = "Please provide storage permission to pick the file."

        const val REQ_CODE_AUDIO_VIDEO_PERMISSION = 101
        const val REQ_CODE_GROUP_PHOTO = 179
        const val REQ_PICTURE = 171
        const val REQ_PICK_PLACE = 121
        const val PERM_STORAGE_FOR_CAM = 191
        const val PERM_STORAGE_FOR_GAL = 193
        const val REQ_STORAGE_PERM_PROMPT = "Storage-access permission must be given to get any picture.\nPlease accept it first."
        const val MSG_THREAD_NULL = "Invalid User!\nPlease restart the app & try again."
    }

    object PermissionKey {
        const val REQ_CODE_AUDIO_VIDEO_PERMISSION = 101
    }

    /*Socket Event*/
    object SocketEvent {
        //CallService Events
        const val CREATE_CALL_SUCCESS = "createCallSuccess"
        const val PUBLISHER_REMOTE_SDP = "publisherRemoteSdp"
        const val INCOMING_CALL = "incomingCall"
        const val NEW_FEED = "newFeed"
        const val FEED_REMOVED = "feedRemoved"
        const val JOIN_CALL_SUCCESS = "joinCallSuccess"
        const val END_CALL = "endCall"
        const val END_SESSION = "endSession"
        const val CREATE_CALL_ERROR = "createCallError"
        const val JOIN_CALL_ERROR = "joinCallError"
        const val DELIVERED_CALL = "deliveredCall"
        const val JOINED_SOMEWHERE = "joinedSomewhere"
        const val BUSY = "busy"
        //Message Service
        const val MESSAGE = "message"
        const val DELIVERED = "delivered"
        const val SEEN = "seen"
        const val EDIT_MESSAGE = "editMessage"
        const val DELETE_MESSAGE = "deleteMessage"

        //PresenceService
        const val IN_APP = "inApp"
        const val OFFLINE = "offline"
        const val REACHABLE = "reachable"
    }

    object SocketEmitter {
        //CallService Emitters
        const val JOIN_REQUEST = "joinCallRequest"
        const val END_CALL = "endCall"
        const val RECEIVED_CALL = "receivedCall"
        const val BUSY = "busy"
        const val CREATE_CALL_REQUEST = "createCallRequest"
        const val JOIN_CALL_REQUEST = "joinCallRequest"
        const val LOCAL_SDP = "localSdp"
        const val ICE_CANDIDATE = "iceCandidate"
        //Message Service
        const val MESSAGE = "message"
        const val SEEN = "seen"
        const val RECEIVED = "received"
        //PresenceService
        const val IN_APP = C.SocketEvent.IN_APP

    }

    object SocketKey {
        //MESSAGE SERVICE
        const val DATA = "data"
        const val THREAD = "thread"
        const val THREAD_ID = "threadId"
        const val TIME = "time"
        const val SENDER = "sender"
        const val DELIVERED = "delivered"
        const val USER = "user"
        const val CONTENT_TYPE = "type"
        const val CALLER = "caller"
        const val CONTENT = "content"
        const val EDITED = "edited"
        const val EDITED_AT = "editedAt"
        const val DELETED = "deleted"
        const val DELETED_AT = "deletedAt"
        const val IMAGE = "image"
        const val MUTED = "muted"
    }

    object CallKey {
        const val CALL_ID = "callId"
        const val REFERENCE_ID = "referenceId"
        const val TURN_CREDENTIALS = "turnCredentials"
        const val DATA = "data"
        const val JSEP = "jsep"
        const val CALLER = "caller"
        const val CALLEES = "callees"
        const val CALLEE = "callee"
        const val IS_VIDEO_CALL = "isVideoCall"
        const val FEED_ID = "feedId"

        const val CALL_IN_OR_OUT = "call_IO"
        const val CALL_IN = "call_IN"
        const val CALL_OUT = "call_OUT"

        const val RECEIVED_CALL = "receivedCall"
        const val PHONE = "phone"
        const val ACTIVE_CALL = "activeCall"
        const val STATUS = "status"
        const val MISSED_CALL = "missedCall"
        const val OUT_GOINNG = "outGoingCall"
        const val INCOMING_CALL = "incomingCall"
        const val ACTIVE = "active"
        const val THREAD_TYPE = C.THREAD.TYPE
        const val THREAD_ID = C.THREAD.ID
        const val CALL_TYPE = "callType"
        const val SIP_CALL = "sipCall"
        const val WEBRTC_CALL = "webrtcCall"
        const val TALK_TIME = "talkTime"

        //TODO need to marge
        const val CALLEE_USERNAME = "callee_username"
        const val CALLEE_NAME = "callee_name"
        const val CALLER_NAME = "caller_name"
        const val CALLER_PIC_URL = "caller_pic_key"
        const val CALLER_USERNAME = "callerUsername"
    }

    object CallEvent {
        const val END_CALL = "End Call"
        const val LOCAL_STREAM = "localStream"
        const val REMOTE_STREAM = "remoteStream"
        const val REMOVE_REMOTE_STREAM = "removeRemoteStream"
        const val ICE_CANDIDATE = "iceCandidate"
        const val LOCAL_SDP = "localSdp"
        const val JOIN = "join"
        const val START = "start"
        const val MESSAGE = "message"
        const val DELIVERED = "delivered"
        const val CLOSED = "closed"
    }

    object PeerConnectionClientEvent {
        const val LOCAL_STREAM = "localStream"
        const val REMOTE_STREAM = "remoteStream"
        const val LOCAL_SDP = "localSdp"
        const val ICE_CANDIDATE = "iceCandidate"
    }

    object THREAD {
        const val ID = "threadId"
        const val THREAD = "thread"
        const val THREADS = "threads"
        const val NAME = "name"
        const val THREAD_NAME = "name"
        const val TYPE = "threadType"
        const val TYPE_1to1 = "oneToOne"
        const val TYPE_GROUP = "group"
        const val THREAD_SIP_AUDIO = "sipAudio"
        const val USERS = "users"
        const val CONTENT = "content"
        const val CONTENT_TYPE = "type"
        const val TIME = "time"
        const val UNREAD = "unreadCount"
        const val LAST_MESSAGE = "lastMessage"
        const val SENDER = "sender"
        const val MUTED = "muted"
        const val CAN_POST_MSG = "canPostMessage"
        //FOR ChatMessage
        const val REFERENCE_ID = "referenceId"
    }

    object REST {
        const val DATA = "data"
        const val THREAD = C.THREAD.THREAD
        const val THREAD_ID = C.THREAD.ID
        const val THREAD_TYPE = "type" // TODO Tell Raju Vhai
        const val THREAD_USERS = "users"
        const val SEEN_TIME = "seenTime"
        const val MESSAGE = "messages"
        const val LAST_SEEN_MESSAGE_TIME = "lastSeenMessageTime"
        const val LAST_SEEN_AT = "lastSeenAt"
        const val LOGGED_IN = "loggedIn"
    }

    object MessageType {
        const val TEXT = "text"
        const val STICKER = "sticker"
        const val IMAGE = "image"
        const val FILE = "file"
        const val GROUP_CREATE = "groupCreate"
        const val END_CALL = "endCall"
        const val LOCATION = "location"
    }

    object MsgStatus {
        const val INVALID = 0
        const val GOT_ACK = 1
        const val DELIVERED = 2
        const val SEEN = 3
        const val NOT_SENT = 4
        const val ERROR = 5
        const val INVISIBLE = 6
    }

    object PresenceKey {
        const val STATUS = "status"
        const val LAST_SEEN = "lastSeen"
        const val IN_APP = "inApp"
        const val REACHABLE = "reachable"
        const val OFFLINE = "offline"
    }

    object GsmCallState {
        const val GSM_RINGING = "gsmRinging"
        const val GSM_OUTGOING = "gsmOutgoing"
        const val GSM_RUNNING = "gsmRunning"
        const val GSM_IDLE = "gsmIdle"
    }

    object SipCallState {
        const val SIP_RINGING = "sipRinging"
        const val SIP_CONNECTING = "sipConnecting"
        const val SIP_OUTGOING = "sipOutgoing"
        const val SIP_RUNNING = "sipRunning"
        const val SIP_IDLE = "sipIdle"
    }

    object WebRtcCallState {
        const val WEB_RTC_RINGING = "rtcRinging"
        const val WEB_RTC_CONNECTING = "rtcConnecting"
        const val WEB_RTC_OUTGOING = "rtcOutgoing"
        const val WEB_RTC_CONNECTED = "rtcConnected"
        const val WEB_RTC_DISCONNECTED = "rtcDisConnected"
        const val WEB_RTC_NONE = "rtcNone"

    }

    object LastCallDetails {
        const val DEBIT = "debit"
        const val DESTINATION = "destination"
        const val BILLSECONDS = "billseconds"
        const val BALANCE = "balance"
        const val CURRENCYCODE = "currencyCode"

    }

    object Notification {
        const val LAST_CALL_NOTIFICATION = 10
        const val FOREGROUND_LINPHONE_SERVICE = 5
        const val FOREGROUND_SIP_INCOMING_SERVICE = 1
        const val FOREGROUND_WRTC_INCOMING_SERVICE = 3
        const val FOREGROUND_SIP_RTC_SERVICE = 2

        const val FOREGROUND_SERVICE_NOTIFICATION_CHANNEL = "ForegroundServiceChannel"
        const val SIP_SERVICE_CHANNEL = "sip_service_sticky_noti"
        const val SIMPLE_NOTIFICATION_CHANNEL = "simpleNotificationChannel"
    }

    object SipKey {
        const val SIP_IN_OR_OUT = "sipInOrOut"
        const val INCOMING = "sipIncoming"
        const val DIALING = "dialing"
        const val OUTGOING = "outgoing"
        const val CONNECTING = "callConnecting"
        const val CALL_TIME = "callTime"
        const val CURRENT_MILLS = "currMills"


        const val FROM_NOTIFICATION ="fromNotification"
        const val FROM_BACKGROUND_SIP_NOTIFICATION ="fromBackSipNotification"

        const val USERNAME = "username"
        const val DISPLAY_NAME = "displayName"
        const val CALL_ID = "callId"
        const val PHONE_NO = "phoneNo"

        const val SIP_HOST = "sipHost"
        const val SIP_NUMBER = "sipNumber"
        const val SIP_PASSWORD = "sipPassword"

        const val SIP_DATA = "sipData"
        const val NUMBER = "number"
        const val PASSWORD = "password"
        const val EXPIRY = "expiry"
        const val BALANCE = "balance"
        const val CALL_DETAILS = "callDetails"
        const val REQ_CODE_AUDIO_VIDEO_PERMISSION = 101
        const val REQ_CODE_AUDIO_VIDEO_PERMISSION_INCOMING = 120
    }

    object WebrtcKey {
        const val VIDEO_CODEC_VP8 = "VP8"
        const val VIDEO_CODEC_VP9 = "VP9"
        const val VIDEO_CODEC_H264 = "H264"
        const val AUDIO_CODEC_OPUS = "OPUS"
        const val AUDIO_CODEC_ISAC = "ISAC"
        // nHD, 360p 640 x 360
        const val nHD_Key = "0"
        const val nHD_VIDEO_WIDTH = 640
        const val nHD_VIDEO_HEIGHT = 360
        // qHD, 540p 960 x 540
        const val qHD_key = "1"
        const val qHD_VIDEO_WIDTH = 960
        const val qHD_VIDEO_HEIGHT = 540
        // HD, 720p 1280 x 720
        const val HD_key = "2"
        const val HD_VIDEO_WIDTH = 1280
        const val HD_VIDEO_HEIGHT = 720
        // Full HD, 1080p 1920 x 1080
        const val FHD_key = "3"
        const val FHD_VIDEO_WIDTH = 1920
        const val FHD_VIDEO_HEIGHT = 1080
        // Ultra HD, 4K, 2160p 3860 x 2160
        const val UHD_key = "4"
        const val UHD_VIDEO_WIDTH = 3860
        const val UHD_VIDEO_HEIGHT = 2160

        //background notification service
        const val IN_OR_OUT = "InOrOut"
        const val INCOMING = "sipIncoming"
        const val DIALING = "dialing"
        const val OUTGOING = "outgoing"
        const val CONNECTING = "callConnecting"
        const val CALL_TIME = "callTime"
        const val CURRENT_MILLS = "currMills"
        const val FROM_NOTIFICATION ="fromNotification"
        const val USERNAME = "username"
        const val DISPLAY_NAME = "displayName"
        const val CALL_ID = "callId"
        const val PHONE_NO = "phoneNo"
        const val COUNT_AUTO_REJECT_TIME = "timeOutCount"
    }

    object TOST_MSG {
        const val SIP_NOT_CONNECTED = "Sip Not Connected"
    }
}