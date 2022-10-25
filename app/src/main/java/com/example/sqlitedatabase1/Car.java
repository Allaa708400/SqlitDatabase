package com.example.sqlitedatabase1;
public class Car {
        private int id;
        private String model;
        private String color;
        private double dbl;
        public Car(int id, String model, String color, double dbl) {
            this.id = id;
            this.model = model;
            this.color = color;
            this.dbl = dbl;
        }
        public Car(String model, String color, double dbl) {
            this.model = model;
            this.color = color;
            this.dbl = dbl;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public double getDbl() {
            return dbl;
        }
        public void setDbl(double dbl) {
            this.dbl = dbl;
        }

}
