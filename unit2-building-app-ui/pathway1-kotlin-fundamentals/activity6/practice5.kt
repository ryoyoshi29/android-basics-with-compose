class Song {
    val title: String = "hello"
    val artist: String = "ryo"
    val releaseYear: String = "2000"
    val numView: Int = 2000
    var isPopular: Boolean = false
    	get() = numView >= 1000
    
    fun introduceMusic() {
        println("$title, performed by $artist, was released in $releaseYear")
    }
}

fun main() {
    var song: Song = Song()
    song.introduceMusic()
    println(song.isPopular)
}