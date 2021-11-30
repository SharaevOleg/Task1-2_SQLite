import java.io.*;

public class Pudge extends Hero implements Serializable {

//    Уникальный идентификатор версии сериализованного класса
    private static final long serialVersionUID = 1L;

    public Pudge(long id, String name, int level, String ultimate) {
        super(id, name, level, ultimate);
    }

    public Pudge(String name, int level, String ultimate) {
        super(name, level, ultimate);
    }

    public Pudge() {
        super();
    }

//    Кастомизируем стандартную сериализацию так как класс "Hero" не Serializable
//    добавляем методы, отвечающие за сериализацию/десериализацияю класса

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeLong(id);
        out.writeUTF(name);
        out.writeInt(level);
        out.writeUTF(ultimate);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        name = in.readUTF();
        level = in.readInt();
        ultimate = in.readUTF();
    }
}
