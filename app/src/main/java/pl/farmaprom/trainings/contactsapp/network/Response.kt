package pl.farmaprom.trainings.contactsapp.network

sealed class Response {

    data class Progress(val status: Int): Response()
    data class Success(val data: String, val status: Int): Response()
    data class Failure(val errorMessage: String, val status: Int): Response()

}

class ResponseParser() {

   fun parse(response: Response) {
       when (response) {
           is Response.Progress -> {response.status}
           is Response.Success -> {response.data}
           is Response.Failure -> {response.errorMessage}
       }
   }

    fun String.hasEvenNumberOfCharacters() = this.length % 2 == 0
    fun checkIsNameIsCool(name: String) = name.hasEvenNumberOfCharacters()
}