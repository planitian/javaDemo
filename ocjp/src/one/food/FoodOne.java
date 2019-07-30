package one.food;

class FoodOne implements Food {
    @Override
    public void eat() {
        System.out.println(name);
    }
}
