import java.util.concurrent.ConcurrentHashMap

val weightedIpList = ConcurrentHashMap(
        mapOf(
                "192.168.1.100" to 1,
                "192.168.1.101" to 1,

                "192.168.1.102" to 4,
                "192.168.1.103" to 1,
                "192.168.1.104" to 1,

                "192.168.1.105" to 3,
                "192.168.1.106" to 1,

                "192.168.1.107" to 2,
                "192.168.1.108" to 1,
                "192.168.1.109" to 1,
                "192.168.1.110" to 1
        )
)

class LoadBalancer {
    companion object {
        var pos2: Int = 0
    }
}

fun getServerUsingWeightedRoundRobin(): String {
    val sortedIpMap = ConcurrentHashMap(weightedIpList)
            .toList()
            .sortedByDescending { (_, value) -> value }
            .toMap()

    val servers = mutableListOf<String>()
    sortedIpMap.keys.forEach { key ->
        servers.apply { repeat(sortedIpMap[key] ?: 0) { this.add(key) } }
    }

    synchronized(LoadBalancer.pos2) {
        LoadBalancer.pos2 = when (LoadBalancer.pos2 > servers.size - 1) {
            true -> 0
            false -> LoadBalancer.pos2
        }
    }
    val nominatedServer = servers[LoadBalancer.pos2]
    LoadBalancer.pos2++
    return nominatedServer

}