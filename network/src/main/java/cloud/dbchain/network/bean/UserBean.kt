package cloud.dbchain.network.bean

data class UserBean(
    val userName: String,
    val password: String
) {
    var cookie: String = ""
    var name: String = ""
    var age: String = ""
    var sex: String = ""
    var photo: String = ""
    var motto: String = ""

    companion object {
        const val DEFAULT_AVATAR = 0
    }
}