import java.util.Random;

public class PokemonFactory {
    private static PokemonFactory miPokemonFactory;
    private PokemonFactory(){}

    public static PokemonFactory getPokemonFactory(){
        if(miPokemonFactory==null){
            miPokemonFactory= new PokemonFactory();
        }
        return miPokemonFactory;
    }

    public Pokemon crearPokemon (String tipo, int idEntrenador, int idPokemon){
        Pokemon miPokemon = switch (tipo) {
            case "TipoAgua" -> new TipoAgua(idEntrenador, idPokemon);
            case "TipoFuego" -> new TipoFuego(idEntrenador, idPokemon);
            case "TipoElectrico" -> new TipoElectrico(idEntrenador, idPokemon);
            case "TipoPlanta" -> new TipoPlanta(idEntrenador, idPokemon);
            default -> null;
        };
        return miPokemon;
    }

    public Pokemon crearPokemonAleatorio(int idEntrenador, int idPokemon){
        Random rand= new Random();
        int tipo= rand.nextInt(4);
        Pokemon miPokemon=null;
        if(tipo==0){ miPokemon= crearPokemon("TipoAgua",idEntrenador,idPokemon);}
        else if(tipo==1){ miPokemon= crearPokemon("TipoFuego",idEntrenador,idPokemon);}
        else if(tipo==2){ miPokemon= crearPokemon("TipoElectrico",idEntrenador,idPokemon);}
        else {miPokemon= crearPokemon("TipoPlanta",idEntrenador,idPokemon);}
        return miPokemon;
    }
}
