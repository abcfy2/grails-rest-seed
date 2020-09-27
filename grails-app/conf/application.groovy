// 支持的时间日期格式:
// 2018-01-01 00:00:00
// 2018-01-01 00:00:00Z
// 2018-01-01 00:00:00+08
// 2018-01-01 00:00:00+0800
// 2018-01-01 00:00:00+08:00
// 2018-01-01 00:00:00.000
// 2018-01-01 00:00:00.000Z
// 2018-01-01 00:00:00.000+08
// 2018-01-01 00:00:00.000+0800
// 2018-01-01 00:00:00.000+08:00
// 2018-01-01T00:00:00
// 2018-01-01T00:00:00Z
// 2018-01-01T00:00:00+08
// 2018-01-01T00:00:00+0800
// 2018-01-01T00:00:00+08:00
// 2018-01-01T00:00:00.000
// 2018-01-01T00:00:00.000Z
// 2018-01-01T00:00:00.000+08
// 2018-01-01T00:00:00.000+0800
// 2018-01-01T00:00:00.000+08:00
grails.databinding.dateFormats = [
        "yyyy-MM-dd HH:mm:ss"
        , "yyyy-MM-dd HH:mm:ssX"
        , "yyyy-MM-dd HH:mm:ssXXX"
        , "yyyy-MM-dd HH:mm:ss.SSS"
        , "yyyy-MM-dd HH:mm:ss.SSSX"
        , "yyyy-MM-dd HH:mm:ss.SSSXXX"
        , "yyyy-MM-dd'T'HH:mm:ss"
        , "yyyy-MM-dd'T'HH:mm:ssX"
        , "yyyy-MM-dd'T'HH:mm:ssXXX"
        , "yyyy-MM-dd'T'HH:mm:ss.SSS"
        , "yyyy-MM-dd'T'HH:mm:ss.SSSX"
        , "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
] + org.grails.plugins.databinding.AbstractDataBindingGrailsPlugin.DEFAULT_DATE_FORMATS

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'top.dteam.earth.backend.user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'top.dteam.earth.backend.user.UserRole'
grails.plugin.springsecurity.authority.className = 'top.dteam.earth.backend.user.Role'

// 监听登录事件，记录登录日志
grails.plugin.springsecurity.useSecurityEventListener = true

grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false

grails.plugin.springsecurity.rest.token.storage.jwt.with {
    useSignedJwt = System.getenv('USE_SIGNED_JWT') ?: true
    secret = System.getenv('JWT_SECRET') ?: 'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'
    expiration = System.getenv('JWT_EXPIRATION') ?: 3600
    useEncryptedJwt = System.getenv('USE_ENCRYPTED_JWT') ?: false
    privateKeyPath = System.getenv('PRIVATE_KEY_PATH')
    publicKeyPath = System.getenv('PUBLIC_KEY_PATH')
}

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/', access: ['permitAll']]
        , [pattern: '/error', access: ['permitAll']]
        , [pattern: '/api/sendSmsCode', access: ['permitAll']]
        , [pattern: '/api/register', access: ['permitAll']]
        , [pattern: '/api/self', access: ["isFullyAuthenticated()"]]
        , [pattern: '/api/updatePersonalInfo', access: ["isFullyAuthenticated()"]]
        , [pattern: '/api/changePassword', access: ["isFullyAuthenticated()"]]
        , [pattern: '/api/users', access: ['ROLE_ADMIN']]
        , [pattern: '/api/users/resetPassword', access: ['permitAll'], httpMethod: 'PUT']
        , [pattern: '/api/users/*', access: ['ROLE_ADMIN']]
        , [pattern: '/api/jobs', access: ['ROLE_ADMIN'], httpMethod: 'GET']
        , [pattern: '/api/getUploadAuthority', access: ['isFullyAuthenticated()'], httpMethod: 'GET']
        , [pattern: '/api/**', access: ['denyAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
]

grails.plugin.springsecurity.failureHandler.exceptionMappings = [
        [exception: org.springframework.security.authentication.CredentialsExpiredException.name, url: '/api/passwordExpired']
]

grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
