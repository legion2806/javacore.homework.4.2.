import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        GameProgress playerSasha = new GameProgress(10000, 4,100,10346);
        GameProgress playerVanya = new GameProgress(100, 0,1,23);
        GameProgress playerVasya = new GameProgress(400, 1,4,236);

        playerSasha.saveGame("/Users/benya/IdeaProjects/java.core.homework.4.1./Games/savegames/saveStats");
        playerSasha.zipFiles("/Users/benya/IdeaProjects/java.core.homework.4.1./Games/savegames/saveStats");

    }

}
