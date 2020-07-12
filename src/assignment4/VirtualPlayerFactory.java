package assignment4;

public class VirtualPlayerFactory {

    public VirtualPlayer getVirtialPlayer(GameModes mode){
        if(mode == GameModes.EASY){
            return new MediumVirtualPlayer();
        }
        if(mode == GameModes.MEDIUM)
        {
            return new MediumVirtualPlayer();

        }
        if(mode == GameModes.HARD)
        {
            return new MediumVirtualPlayer();
        }

        return null;
    }
}
