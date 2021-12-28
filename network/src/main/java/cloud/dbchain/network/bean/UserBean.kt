package cloud.dbchain.network.bean

data class UserBean(
    val userName: String,
    val password: String
) {
    var cookie: String = ""
}