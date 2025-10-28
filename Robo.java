public class Robo {
    // Constantes da Sala (20x40) - Requisito do Item B
    public static final int MAX_LINHA = 20;  // Linhas de 0 a 19
    public static final int MAX_COLUNA = 40; // Colunas de 0 a 39

    // Atributos
    private int linha;
    private int coluna;
    private int passo;

    /**
     * Construtor da classe Robo.
     * @param linhaInicial Linha inicial do robô (coordenada y).
     * @param colunaInicial Coluna inicial do robô (coordenada x).
     * @param passoInicial Quantos pontos o robô se move a cada vez.
     */
    public Robo(int linhaInicial, int colunaInicial, int passoInicial) {
        this.passo = passoInicial;
        
        // Inicializa a posição verificando os limites
        if (linhaInicial >= 0 && linhaInicial < MAX_LINHA) {
            this.linha = linhaInicial;
        } else {
            System.out.println("Aviso: Linha inicial fora dos limites. Redefinindo para 0.");
            this.linha = 0;
        }

        if (colunaInicial >= 0 && colunaInicial < MAX_COLUNA) {
            this.coluna = colunaInicial;
        } else {
            System.out.println("Aviso: Coluna inicial fora dos limites. Redefinindo para 0.");
            this.coluna = 0;
        }
    }
    
    // Métodos Getters
    public int getLinha() { return linha; }
    public int getColuna() { return coluna; }
    public int getPasso() { return passo; }

    /**
     * Mostra a posição atual (coordenadas) do robô.
     */
    public void mostrarPosicaoAtual() {
        System.out.println("Posição Atual do Robô R1: (" + this.linha + ", " + this.coluna + ")");
    }

    /**
     * Método auxiliar privado para aplicar o movimento e as restrições de fronteira (Item C).
     * O robô se desloca apenas até a posição imediatamente anterior à fronteira, se necessário.
     * @param novaLinha A linha de destino calculada.
     * @param novaColuna A coluna de destino calculada.
     */
    private void mover(int novaLinha, int novaColuna) {
        // Restrição da Linha
        if (novaLinha < 0) {
            this.linha = 0; // Vai até a fronteira superior
        } else if (novaLinha >= MAX_LINHA) {
            this.linha = MAX_LINHA - 1; // Vai até a fronteira inferior
        } else {
            this.linha = novaLinha; // Move normalmente
        }

        // Restrição da Coluna
        if (novaColuna < 0) {
            this.coluna = 0; // Vai até a fronteira esquerda
        } else if (novaColuna >= MAX_COLUNA) {
            this.coluna = MAX_COLUNA - 1; // Vai até a fronteira direita
        } else {
            this.coluna = novaColuna; // Move normalmente
        }
    }

    /**
     * Move o robô para Frente (assume que Frente é diminuir a linha, ou seja, 'subir').
     */
    public void andarFrente() {
        int novaLinha = this.linha - this.passo;
        mover(novaLinha, this.coluna);
        System.out.println("Robô andou " + this.passo + " passos para Frente.");
    }

    /**
     * Move o robô para Trás (assume que Trás é aumentar a linha, ou seja, 'descer').
     */
    public void andarTras() {
        int novaLinha = this.linha + this.passo;
        mover(novaLinha, this.coluna);
        System.out.println("Robô andou " + this.passo + " passos para Trás.");
    }

    /**
     * Move o robô para a Direita (aumenta a coluna).
     */
    public void andarDireita() {
        int novaColuna = this.coluna + this.passo;
        mover(this.linha, novaColuna);
        System.out.println("Robô andou " + this.passo + " passos para Direita.");
    }

    /**
     * Move o robô para a Esquerda (diminui a coluna).
     */
    public void andarEsquerda() {
        int novaColuna = this.coluna - this.passo;
        mover(this.linha, novaColuna);
        System.out.println("Robô andou " + this.passo + " passos para Esquerda.");
    }
}