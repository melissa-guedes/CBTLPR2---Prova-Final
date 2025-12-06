public class Paciente {

    private int id;      // ID automático no banco
    private String nome;
    private int idade;
    private float peso;
    private float altura;

    public Paciente(String nome, int idade, float peso, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nPeso: " + peso +
                "\nAltura: " + altura;
    }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public float getPeso() { return peso; }
    public float getAltura() { return altura; }
}
