import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

suspend fun main() {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    val joke: Joke = client.get("https://geek-jokes.sameerkumar.website/api?format=json")

    println(joke.joke)
}

@Serializable
data class Joke(val joke: String)
