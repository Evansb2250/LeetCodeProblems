data class Book(
    val id: String,
    val title: String,
    private val pageCount: Int,
    private val summary: String,
) {
    fun viewDetails(): String = summary
}

class Catalog {
    private val bookCatalog = mutableMapOf<String, Book>()

    fun addBooks(newBook: Book) {
        bookCatalog.put(newBook.id, newBook)
    }

    fun searchBook(bookId: String): Book? {
        return bookCatalog.get(bookId)
    }
}


