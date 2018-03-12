package lesson9.Task;

import java.util.Arrays;

public class DemoUserRepositoryTestClass {
    public static void main(String[] args) {

        User u1 = new User(1, "u11", "rwg2w");
        User u2 = new User(2, "u22", "wef24");
        User[] usAr = {u1, u2};
        User[] usAr1 = new User[5];

        //getUserNames()
        //возвращает массив с именами юзеров +
        //если массив не полный +
        //если массив null +

        UserRepository ur = new UserRepository(usAr);
        System.out.println(Arrays.toString(ur.getUserNames()));

        usAr1[0] = u1;
        usAr1[3] = u2;
        UserRepository ur1 = new UserRepository(usAr1);
        System.out.println(Arrays.toString(ur1.getUserNames()));

        UserRepository ur2 = new UserRepository(null);
        System.out.println(ur2.getUserNames());

        //getUserIds()
        //возвращает массив с Id юзеров +
        //если массив не полный +
        //если массив null +

        System.out.println(Arrays.toString(ur.getUserIds()));

        System.out.println(Arrays.toString(ur1.getUserIds()));

        System.out.println(ur2.getUserIds());

        //getUserNameById(long id)
        //ищет имя юзера по id +
        //если юзера такого нет +
        //если массив null +

        System.out.println(ur.getUserNameById(1));

        System.out.println(ur.getUserNameById(100));

        System.out.println(ur2.getUserNameById(1));

        //getUserByName(String name)
        //ищет юзера за именем +
        //если такого юзера нет +
        //если имя юзера null +
        //если массив null +

        System.out.println(ur.getUserByName("u11").toString());

        System.out.println(ur.getUserByName("u11ewf"));

        System.out.println(ur.getUserByName(null));

        System.out.println(ur2.getUserByName("u11"));

        //getUserById(long id)
        //ищет юзера за id +
        //если такого юзера нет +
        //если массив null +

        System.out.println(ur.getUserById(1).toString());

        System.out.println(ur.getUserById(12));

        System.out.println(ur2.getUserById(1));

        //getUserBySessionId(String sessionId)
        //ищет юзера за sessionId +
        //если такого юзера нет +
        //если массив null +

        System.out.println(ur.getUserBySessionId("rwg2w").toString());

        System.out.println(ur.getUserBySessionId(""));

        System.out.println(ur2.getUserBySessionId("f"));

        //findById(long id)
        //ищет юзера по id +
        //если такого юзера нет +
        //если массив null +

        System.out.println(ur.findById(1).toString());

        System.out.println(ur.findById(12));

        System.out.println(ur2.findById(1));

        //delete(long id)
        //удаляет юзера по id +
        //если такого юзера нет +
        //если массив null +

        System.out.println(Arrays.toString(ur.getUsers()));

        ur.delete(1);

        System.out.println(Arrays.toString(ur.getUsers()));

        ur.delete(1);

        System.out.println(Arrays.toString(ur.getUsers()));

        ur2.delete(1);

        //save(User user)
        //сохранение юзера +
        //сохранение того же юзера +
        //когда нет места в массиве +
        //когда сохраняем null +
        //если массив null +

        UserRepository userRepository = new UserRepository(usAr);

        System.out.println(Arrays.toString(userRepository.getUsers()));

        User user = new User(1001, "Ann", "1w21212");
        userRepository.save(user);

        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.save(user);

        System.out.println(Arrays.toString(userRepository.getUsers()));

        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann", "1w21212");
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.save(null);

        ur2.save(user);

        //update(User user)
        //обновление юзера +
        //когда нет юзера на обновление +
        //когда обновляем null +
        //если массив null +

        user = new User(1001, "Ann", "eretertert");
        userRepository.update(user);

        System.out.println(Arrays.toString(userRepository.getUsers()));

        user = new User(9999, "Ann", "eretertert");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        System.out.println(ur2.update(user));

    }
}
