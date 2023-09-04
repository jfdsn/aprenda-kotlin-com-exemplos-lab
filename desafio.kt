enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class User(val name: String, val age: Int)

data class ConteudoEducacional(var name: String, val duration: Int = 60, val nivel: Nivel)

data class Formacao(val name: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<User>()
    
    //Realiza a matricula de um usuário do tipo User
    fun matricular(user: User) {
        inscritos.add(user)
        val username = user.name
        println("Usuário: $username adicionado com sucesso.")
    }
    
    //Retorna a lista de usuários já matriculados em uma Formação
    fun getUsers() {
        val allNames = mutableListOf<String>()
        
        for(i in inscritos) allNames.add(i.name)
        
        println("Todos usuários matriculados: $allNames")
    }
}

fun main() {
    
    val conteudo = mutableListOf<ConteudoEducacional>()
    conteudo.add(ConteudoEducacional("Listas mutáveis em Kotlin", 30, Nivel.INTERMEDIARIO))
    
    val formacaoKotlin = Formacao("Kotlin", conteudo)
    
    val usuario1 = User("Maria", 33)
    val usuario2 = User("Jose", 21)
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    formacaoKotlin.getUsers()
}
