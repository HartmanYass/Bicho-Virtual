class BichoVirtual(val nome: String) {

    var fome = 50
    var felicidade = 50
    var cansaço = 0
    var idade = 0
    var banheiro = 0
    var sujeira = 0

    val limiteBanheiro = 100
    val limiteSujeira = 100

    var perdeu = false

    fun alimentar() {
        fome -= 10
        if (fome < 0) fome = 0

        banheiro += 15

        println("$nome comeu! Fome diminuiu e vontade de ir ao banheiro aumentou.")
        verificarDerrota()
    }

    fun brincar() {
        felicidade += 10
        if (felicidade > 100) felicidade = 100

        cansaço += 15
        sujeira += 10

        println("$nome brincou! Felicidade aumentou, mas ficou mais cansado e mais sujo.")
        verificarDerrota()
    }

    fun descansar(horas: Int) {
        cansaço -= (horas * 15)
        if (cansaço < 0) cansaço = 0

        println("$nome descansou por $horas horas e recuperou energia.")
    }

    fun verificarStatus() {
        println("\n--- STATUS DE $nome ---")
        println("Idade: $idade")
        println("Fome: $fome")
        println("Felicidade: $felicidade")
        println("Cansaço: $cansaço")
        println("Banheiro: $banheiro")
        println("Sujeira: $sujeira")
        println("------------------------\n")
    }

    fun passarTempo() {
        fome += 3
        felicidade -= 3
        cansaço += 10
        idade += 1

        println("O tempo passou... $nome está um pouco mais velho e suas necessidades aumentaram.")

        verificarDerrota()
    }

    fun verificarDerrota() {
        if (fome >= 100) {
            println("${nome} morreu de fome! Você perdeu.")
            perdeu = true
        }
        if (felicidade <= 0) {
            println("${nome} ficou deprimido... Você perdeu.")
            perdeu = true
        }
        if (cansaço >= 100) {
            println("${nome} desmaiou de cansaço! Você perdeu.")
            perdeu = true
        }
        if (banheiro >= limiteBanheiro) {
            println("${nome} passou mal por não ir ao banheiro! Você perdeu.")
            perdeu = true
        }
        if (sujeira >= limiteSujeira) {
            println("${nome} ficou doente devido à sujeira! Você perdeu.")
            perdeu = true
        }
    }
}
