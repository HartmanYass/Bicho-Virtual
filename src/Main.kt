fun main() {

    println("Bem-vindo ao simulador de Animal de Estimação Virtual!")
    print("Digite o nome do seu pet: ")
    val nomePet = readLine() ?: "Pixel"

    val pet = BichoVirtual(nomePet)

    while (!pet.perdeu) {
        if (pet.idade >= 50) {
            println("Parabéns! Você conseguiu fazer $nomePet chegar à idade 50! 🎉")
            break
        }

        println(
            """
            
Escolha uma ação:
1 – Alimentar $nomePet
2 – Brincar com $nomePet
3 – Descansar
4 – Verificar Status
5 – Sair

""".trimIndent()
        )

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> {
                print("Quantas horas ele deve descansar? ")
                val horas = readLine()?.toIntOrNull() ?: 0
                pet.descansar(horas)
            }
            4 -> pet.verificarStatus()
            5 -> {
                println("Tchau! Volte sempre! <3")
                break
            }
            else -> println("Opção inválida!")
        }

        if (!pet.perdeu && escolha != 4) {
            pet.passarTempo()
        }
    }
}
