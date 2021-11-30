import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();
            // Добавляем запись
//            dbHandler.addHero(new Hero(1,"Бэтмен", 1, "интеллект, обширные познания, знания боевых искусств, ловкость"));
//            dbHandler.addHero(new Hero("Супермен", 2, "непробиваемость, суперсила, полет, самоисцеление, суперзрение и суперслух"));
//            dbHandler.addHero(new Hero("Железный человек", 3, "высокий уровень интеллекта, широкие познания науки и техники, связь со всемирной паутиной, бронекостюмы"));
//            dbHandler.addHero(new Hero("Человек-паук", 4, "сверхчеловеческие рефлексы, «паучье чутье», способность прилепляться к твердым поверхностям, производство паутины"));
//            dbHandler.addHero(new Hero("Капитан Америка", 5, "сила, выносливость, бессмертие, быстрая регенерация, мастерство скрытности и боя"));
//            dbHandler.addHero(new Hero("Тор", 6, "все, что может бог, плюс молот Мьелнир"));
//            dbHandler.addHero(new Hero("Халк", 7, "сверхчеловеческая сила"));
//            dbHandler.addHero(new Hero("Чудо-женщина", 8, "скорость, выносливость, полет"));
//            dbHandler.addHero(new Hero("Черная вдова", 9, "пик человеческого физического потенциала, замедленное старение, знание многих языков"));
//            dbHandler.addHero(new Hero("Дэдпул", 10, "высокий болевой порог, регенерация и бессмертие, сверхчеловеческая иммунная система"));
            // Получаем все записи и выводим их на консоль
            List<Hero> heroes = dbHandler.getAllHeroes();
            for (Hero hero : heroes) {
                System.out.println(hero.toString());
            }
            // Удаление записи с id = 1
//            dbHandler.deleteHero(1);
            // получить героя с id = 10
//            dbHandler.getHero(10);

        } catch (SQLException e) {
            e.printStackTrace();
        }

// ********** Тест сериализации и десериализации
        Pudge example = new Pudge(389, "TVERSKOI", 6, "fantaz");

        System.out.println("Before Serialization: " + example);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(example);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Pudge from = (Pudge) ois.readObject();

        System.out.println("After Deserialization: " + from);
        System.out.println(example.name.equals(from.name.toString()));
    }


}
