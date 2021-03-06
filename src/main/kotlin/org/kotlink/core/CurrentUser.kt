package org.kotlink.core

import org.kotlink.core.account.UserAccount
import org.kotlink.core.account.UserAccountService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
class CurrentUser(
    private val userAccountService: UserAccountService,
    @Value("\${kotlink.security.admin-email:#{null}}") private val adminEmail: String? = null
) {

    fun getEmail(): String {
        val auth: Authentication? = SecurityContextHolder.getContext().authentication
        if (auth is OAuth2AuthenticationToken) {
            return auth.principal.attributes["email"] as String
        }
        return UNKNOWN_USER_EMAIL
    }

    fun isKnown() = getEmail() != UNKNOWN_USER_EMAIL

    fun isAdmin() = getEmail() == adminEmail

    fun getAccount(): UserAccount =
        userAccountService.findOrCreateAccountForEmail(getEmail())

    companion object {
        const val UNKNOWN_USER_EMAIL = "unknown"
    }
}
