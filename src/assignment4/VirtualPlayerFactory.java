package assignment4;

public class VirtualPlayerFactory {

    public Player getVirtialPlayer(GameModes mode){
        if(mode == GameModes.EASY)
        {
            return new ComputerPlayerMedium();
        }
        if(mode == GameModes.MEDIUM)
        {
            return new ComputerPlayerMedium();

        }
        if(mode == GameModes.STRONG)
        {
            return new ComputerPlayerMedium(); // FIXME: need to implement strong computer player
        }

        return null;
    }
}
