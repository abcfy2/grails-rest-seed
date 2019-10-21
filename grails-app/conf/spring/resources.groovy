import top.dteam.earth.backend.converter.DateTimeValueConverter
import top.dteam.earth.backend.user.LoginEventListener
import top.dteam.earth.backend.user.LoginResponseJsonRender
import top.dteam.earth.backend.user.MyUserDetailsService
import top.dteam.earth.backend.user.UserPasswordEncoderListener

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(MyUserDetailsService)
    accessTokenJsonRenderer(LoginResponseJsonRender) {
        usernamePropertyName = 'username'
        tokenPropertyName = 'access_token'
        authoritiesPropertyName = 'roles'
        useBearerToken = true
    }
    loginEventListener(LoginEventListener)
    dateTimeValueConverter(DateTimeValueConverter)
}
