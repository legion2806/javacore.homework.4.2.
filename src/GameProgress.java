import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String stats) {

        try (ObjectOutputStream vol1 = new ObjectOutputStream
                (new FileOutputStream(stats))) {

            vol1.writeObject(health);
            vol1.writeObject(weapons);
            vol1.writeObject(lvl);
            vol1.writeObject(distance);

        }
        catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    List<String> zipFiles(String txtFiles){

        try(ZipOutputStream zout = new ZipOutputStream
                (new FileOutputStream("/Users/benya/IdeaProjects/java.core.homework.4.1./Games/savegames/zip.zip"));
            FileInputStream fis= new FileInputStream(txtFiles);)
        {
            ZipEntry entry1=new ZipEntry("notes.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }

}
