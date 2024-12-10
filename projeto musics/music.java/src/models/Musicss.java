package models;
 
public class Musicss {   
private int id;
private String nome;
private int idade;
private String Musicas;
private int Grammys;
private String Vivo;
private String Genero;
private String  Nacionalidade;


 
// Construtores
 
 
public Musicss() {
 
}
 
 
/*cria um com id e um com sem */
 
public Musicss(int id, String nome, int idade, String Musicas,int Grammys,String Vivo, String Genero, String Nacionalidade ) {
 
this.id = id;
this.nome = nome;
this.idade = idade;
this.Musicas = Musicas;
this.Grammys = Grammys;
this.Vivo = Vivo;
this.Genero = Genero;
this.Nacionalidade = Nacionalidade;
 
}
public Musicss( String nome, int idade, String Musicas,int Grammys,String Vivo, String Genero, String Nacionalidade ) {

this.nome = nome;
this.idade = idade;
this.Musicas = Musicas;
this.Grammys = Grammys;
this.Vivo = Vivo;
this.Genero = Genero;
this.Nacionalidade = Nacionalidade;
}
 
// Getters e Setters

public int getId() {
    return id;   
  }
    // ID somente leitura, sem setter
     
    public String getNome() { 
    return nome;
    }
     
    public void setNome (String nome) {
    this.nome = nome;
    }
     
    public int getidade() {
    return idade; 
    }
     
    public void setidade(int idade) {
    this.idade = idade;
    }

public String  getMusicas(){
    return Musicas;
}
     
public void setMusicas(String Musicas){
    this.Musicas = Musicas;
}

public int getGrammys() {
    return Grammys; 
    }
     
    public void setGrammys(int Grammys) {
    this.Grammys = Grammys;
    }

    public String getVivo() { 
        return Vivo;
        }
         
        public void setVivo (String Vivo) {
        this.Vivo = Vivo;
        }

        public String getGenero() { 
            return Genero;
            }
             
            public void setGenero (String Genero) {
            this.Genero = Genero;
            }

            public String getNacionalidade() { 
                return Nacionalidade;
                }
                 
                public void setNacionalidade (String Nacionalidade) {
                this.Nacionalidade = Nacionalidade;
                }


//toString

@Override
public String toString(){
     return "Music [id=" + id + ", nome=" + nome + ", idade= " + idade + ", Musicas=" + Musicas +", Grammys= " + Grammys +", Vivo=" + Vivo +", Genero=" + Genero +", Nacionalidade=" + Nacionalidade +"]";   
}

}