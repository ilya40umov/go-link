package org.kotlink.core.namespace

import javax.validation.constraints.Pattern

/**
 * Groups aliases that start with a common keyword, which is very helpful for isolating aliases between teams/projects.
 */
data class Namespace(
    val id: Long = 0,
    @field:Pattern(regexp = "[a-zA-Z0-9]+") val keyword: String
)