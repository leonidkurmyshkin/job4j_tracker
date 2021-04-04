package ru.job4j.stream;

public class Clothes {
    private String name;
    private String forSex;
    private String brand;
    private String style;
    private String color;
    private String size;
    private double price;

    @Override
    public String toString() {
        return "Clothes{"
                + "name='" + name + '\''
                + ", forSex='" + forSex + '\''
                + ", brand='" + brand + '\''
                + ", style='" + style + '\''
                + ", color='" + color + '\''
                + ", size='" + size + '\''
                + ", price=" + price
                + '}';
    }

    static class Builder {
        private String name;
        private String forSex;
        private String brand;
        private String style;
        private String color;
        private String size;
        private double price;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildForSex(String forSex) {
            this.forSex = forSex;
            return this;
        }

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildStyle(String style) {
            this.style = style;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildSize(String size) {
            this.size = size;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        Clothes build() {
            Clothes clothes = new Clothes();
            clothes.name = name;
            clothes.forSex = forSex;
            clothes.brand = brand;
            clothes.style = style;
            clothes.color = color;
            clothes.size = size;
            clothes.price = price;
            return clothes;
        }
    }

    public static void main(String[] args) {
        Clothes jeans1 = new Builder()
                .buildName("super skinny jeans")
                .buildForSex("man")
                .buildBrand("BOSS")
                .buildStyle("casual")
                .buildColor("blue")
                .buildSize("L")
                .buildPrice(2150D)
                .build();
        System.out.println(jeans1);
    }
}
