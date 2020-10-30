import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

    public void saveGame(String s) {

        try (ObjectOutputStream vol1 = new ObjectOutputStream
                (new FileOutputStream(s))) {

            vol1.writeObject(health);
            vol1.writeObject(weapons);
            vol1.writeObject(lvl);
            vol1.writeObject(distance);

        }
        catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String s, String b){

        String filename = b;
        try(ZipOutputStream zout = new ZipOutputStream
                (new FileOutputStream(s));
            FileInputStream fis= new FileInputStream(filename);)
        {
            ZipEntry entry1=new ZipEntry("notes.txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

}
