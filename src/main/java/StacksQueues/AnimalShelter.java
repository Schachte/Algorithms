package StacksQueues;

/**
 * The goal is to offer adoption based on the oldest animal (based on arrival time)
 * OR the adoptee can adopt an animal of a specific type and receive the oldest of that type
 */
public class AnimalShelter {
    private static Animal oldestAnimal;

    private static class Animal {
        private String type;
        private String name;
        private Animal nextAnimal;

        public Animal(String name, String type) {
            this.type = type;
            this.name = name;
            assignYoungest(this);
        }

        private void assignYoungest(Animal animal) {
            if (oldestAnimal == null) {
                oldestAnimal = animal;
            } else {
                Animal iter = oldestAnimal;
                while (iter.nextAnimal != null) {
                    iter = iter.nextAnimal;
                }
                iter.nextAnimal = animal;
            }
        }
    }

    public static void main(String[] args) {
        new Animal("josh","cat");
        new Animal("don", "cat");
        new Animal("austin", "dog");
        new Animal("ryan", "cat");
        new Animal("ryan2", "cat");
        new Animal("bill", "dog");

        System.out.println(adoptDog().name);
        System.out.println(adoptCat().name);
        System.out.println(adoptCat().name);
        System.out.println(adoptCat().name);
        System.out.println(adoptDog().name);
    }

    public static Animal adoptDog() {
        Animal iterAnimal = oldestAnimal;

        if (iterAnimal.type.equals("dog")) {
            Animal oldestDog = iterAnimal;
           oldestAnimal = iterAnimal.nextAnimal;
           return oldestDog;
        }
        while (iterAnimal.nextAnimal != null) {
            if (iterAnimal.nextAnimal.type.equals("dog")) {
                Animal oldestDog = iterAnimal.nextAnimal;
                iterAnimal.nextAnimal = iterAnimal.nextAnimal.nextAnimal;
                return oldestDog;
            }
            iterAnimal = iterAnimal.nextAnimal;
        }
        return null;
    }

    public static Animal adoptCat() {
        Animal iterAnimal = oldestAnimal;
        if (iterAnimal.type.equals("cat")) {
            Animal oldestCat = iterAnimal;
            oldestAnimal = oldestAnimal.nextAnimal;
            return oldestCat;
        }

        while (iterAnimal.nextAnimal != null) {
            if (iterAnimal.nextAnimal.type.equals("cat")) {
                Animal oldestCat = iterAnimal.nextAnimal;
                iterAnimal.nextAnimal = iterAnimal.nextAnimal.nextAnimal;
                return oldestCat;
            }
            iterAnimal = iterAnimal.nextAnimal;
        }
        return null;
    }

    public static Animal adopt() {
        Animal iterAnimal = oldestAnimal;
        oldestAnimal = oldestAnimal.nextAnimal;
        return iterAnimal;
    }

}
