package io.amtunnel.core.dns

import java.io.File

interface ResolverStore {
    fun load(): List<ResolverEndpoint>
    fun save(endpoints: List<ResolverEndpoint>)
}

class InMemoryResolverStore(initial: List<ResolverEndpoint> = emptyList()) : ResolverStore {
    private var entries: List<ResolverEndpoint> = initial
    override fun load(): List<ResolverEndpoint> = entries
    override fun save(endpoints: List<ResolverEndpoint>) {
        entries = endpoints.toList()
    }
}

/**
 * Dependency-free persistence: one resolver per line.
 * `key<TAB>label<TAB>source<TAB>enabled`
 */
class FileResolverStore(private val file: File) : ResolverStore {
    override fun load(): List<ResolverEndpoint> {
        if (!file.exists()) return emptyList()
        return runCatching {
            file.readLines()
                .asSequence()
                .map { it.trim() }
                .filter { it.isNotEmpty() && !it.startsWith("#") }
                .mapNotNull { line ->
                    val parts = line.split('\t')
                    val endpoint = ResolverEndpoint.parse(parts[0], ResolverSource.MANUAL) ?: return@mapNotNull null
                    val label = parts.getOrNull(1).orEmpty()
                    val source = parts.getOrNull(2)
                        ?.let { runCatching { ResolverSource.valueOf(it) }.getOrNull() }
                        ?: ResolverSource.MANUAL
                    val enabled = parts.getOrNull(3)?.toBooleanStrictOrNull() ?: true
                    endpoint.copy(label = label, source = source, enabled = enabled)
                }
                .distinctBy { it.key }
                .toList()
        }.getOrElse { emptyList() }
    }

    override fun save(endpoints: List<ResolverEndpoint>) {
        file.parentFile?.mkdirs()
        val text = buildString {
            appendLine("# AM Tunnel client resolver list (auto-generated)")
            endpoints.forEach { e ->
                append(e.key)
                append('\t').append(e.label)
                append('\t').append(e.source.name)
                append('\t').append(e.enabled)
                appendLine()
            }
        }
        file.writeText(text)
    }
}
