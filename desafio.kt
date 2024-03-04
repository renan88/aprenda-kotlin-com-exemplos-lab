// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach { println(it.nome) }
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    val usuario1 = Usuario("Renan")
    val usuario2 = Usuario("Ingrid")
    val usuario3 = Usuario("Benício")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    val formacao1 = Formacao("Formação em Desenvolvimento Web", Nivel.BASICO)
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)

    val formacao2 = Formacao("Formação em Ciência de Dados", Nivel.INTERMEDIARIO)
    formacao2.adicionarConteudo(conteudo1)
    formacao2.adicionarConteudo(conteudo3)

    val formacao3 = Formacao("Formação em Machine Learning", Nivel.AVANCADO)
    formacao3.adicionarConteudo(conteudo2)
    formacao3.adicionarConteudo(conteudo3)

    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)
    

    formacao1.listarConteudos()
    formacao1.listarInscritos()

    formacao2.listarConteudos()
    formacao2.listarInscritos()

    formacao3.listarConteudos()
}

