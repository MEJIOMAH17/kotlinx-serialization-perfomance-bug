import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.Test

class PerformanceBug {
    @Test
    fun reproduce() {
        val sample = Sample(
            str = """ 
                 "load"
            """.trimIndent().repeat(100_000)
        )
        Json.encodeToString(Sample.serializer(), sample)

    }

    @Serializable
    class Sample(
        val str: String
    )
}